package DataAccess.DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DataAccess.DTOs.aeExoBotArmaViewDTO;
import Infrastructure.AppConfig;
import Infrastructure.AppException;

public class aeExoTrooperDAO {
    private Connection openConnection() throws SQLException {
        return DriverManager.getConnection(AppConfig.getDATABASE());
    }

    public List<aeExoBotArmaViewDTO> readGridAll() throws AppException {
        return readGridByTipoExoBot(null);
    }

    public List<aeExoBotArmaViewDTO> readGridByTipoExoBot(Integer idTipoExoBot) throws AppException {
        List<aeExoBotArmaViewDTO> list = new ArrayList<>();
        String sql =
            "SELECT " +
            "  b.IdExoBot              AS idExoBot, " +
            "  b.IdTipoExoBot          AS idTipoExoBot, " +
            "  t.Nombre                AS tipoExoBot, " +
            "  b.Entreno               AS entreno, " +
            "  b.NoAccion              AS noAccion, " +
            "  ea.IdExoBotArma          AS idExoBotArma, " +
            "  ea.IdTipoArma            AS idTipoArma, " +
            "  ta.Nombre                AS tipoArma, " +
            "  ta.TipoRecursos          AS tipoRecursos, " +
            "  ea.IdAccionArma          AS idAccionArma, " +
            "  aa.Nombre                AS accionArma, " +
            "  ea.IdTipoEnergia         AS idTipoEnergia, " +
            "  te.Nombre                AS recurso " +
            "FROM ExoBot b " +
            "JOIN TipoExoBot t   ON t.IdTipoExoBot = b.IdTipoExoBot " +
            "JOIN ExoBotArma ea  ON ea.IdExoBot = b.IdExoBot AND ea.Estado = 'A' " +
            "JOIN TipoArma ta    ON ta.IdTipoArma = ea.IdTipoArma " +
            "JOIN AccionArma aa  ON aa.IdAccionArma = ea.IdAccionArma " +
            "LEFT JOIN TipoEnergia te ON te.IdTipoEnergia = ea.IdTipoEnergia " +
            "WHERE b.Estado = 'A' " +
            (idTipoExoBot == null ? "" : "AND b.IdTipoExoBot = ? ") +
            "ORDER BY b.IdExoBot, ea.IdExoBotArma";

        try (Connection conn = openConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            if (idTipoExoBot != null) {
                stmt.setInt(1, idTipoExoBot);
            }
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    aeExoBotArmaViewDTO dto = new aeExoBotArmaViewDTO();
                    dto.setIdExoBot(rs.getInt("idExoBot"));
                    dto.setIdTipoExoBot(rs.getInt("idTipoExoBot"));
                    dto.setTipoExoBot(rs.getString("tipoExoBot"));
                    dto.setEntreno(rs.getString("entreno"));
                    dto.setNoAccion(rs.getInt("noAccion"));

                    dto.setIdExoBotArma(rs.getInt("idExoBotArma"));
                    dto.setIdTipoArma(rs.getInt("idTipoArma"));
                    dto.setTipoArma(rs.getString("tipoArma"));
                    dto.setTipoRecursos(rs.getString("tipoRecursos"));

                    dto.setIdAccionArma(rs.getInt("idAccionArma"));
                    dto.setAccionArma(rs.getString("accionArma"));

                    int idTipoEnergiaVal = rs.getInt("idTipoEnergia");
                    dto.setIdTipoEnergia(rs.wasNull() ? null : idTipoEnergiaVal);
                    dto.setRecurso(rs.getString("recurso"));

                    list.add(dto);
                }
            }
        } catch (SQLException e) {
            throw new AppException("Error al leer la grilla ExoTrooper", e, getClass(), "readGridByTipoExoBot");
        }
        return list;
    }

    public Integer getExoBotIdByTipoExoBot(Integer idTipoExoBot) throws AppException {
        String sql = "SELECT IdExoBot FROM ExoBot WHERE Estado='A' AND IdTipoExoBot = ? LIMIT 1";
        try (Connection conn = openConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idTipoExoBot);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next() ? rs.getInt(1) : null;
            }
        } catch (SQLException e) {
            throw new AppException("Error al obtener ExoBot por TipoExoBot", e, getClass(), "getExoBotIdByTipoExoBot");
        }
    }

    public Integer getTipoEnergiaIdByNombre(String nombre) throws AppException {
        String sql = "SELECT IdTipoEnergia FROM TipoEnergia WHERE Estado='A' AND Nombre = ? LIMIT 1";
        try (Connection conn = openConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next() ? rs.getInt(1) : null;
            }
        } catch (SQLException e) {
            throw new AppException("Error al obtener TipoEnergia por Nombre", e, getClass(), "getTipoEnergiaIdByNombre");
        }
    }

    public boolean setExoBotEntreno(Integer idExoBot, boolean entrenado) throws AppException {
        String sql = "UPDATE ExoBot SET Entreno = ?, FechaModifica = datetime('now','localtime') WHERE IdExoBot = ? AND Estado='A'";
        try (Connection conn = openConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, entrenado ? "SI" : "NO");
            stmt.setInt(2, idExoBot);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new AppException("Error al actualizar Entreno de ExoBot", e, getClass(), "setExoBotEntreno");
        }
    }

    public Integer incrementExoBotNoAccion(Integer idExoBot) throws AppException {
        String sql = "UPDATE ExoBot SET NoAccion = NoAccion + 1, FechaModifica = datetime('now','localtime') WHERE IdExoBot = ? AND Estado='A'";
        try (Connection conn = openConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idExoBot);
            int updated = stmt.executeUpdate();
            if (updated <= 0) return null;
        } catch (SQLException e) {
            throw new AppException("Error al incrementar NoAccion", e, getClass(), "incrementExoBotNoAccion");
        }

        String sqlRead = "SELECT NoAccion FROM ExoBot WHERE IdExoBot = ? AND Estado='A'";
        try (Connection conn = openConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlRead)) {
            stmt.setInt(1, idExoBot);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next() ? rs.getInt(1) : null;
            }
        } catch (SQLException e) {
            throw new AppException("Error al leer NoAccion", e, getClass(), "incrementExoBotNoAccion(read)");
        }
    }

    public boolean updateExoBotArmaAccion(Integer idExoBot, Integer noAccion, Integer idTipoEnergia, String descripcion) throws AppException {
        String sql =
            "UPDATE ExoBotArma " +
            "SET NoAccion = ?, IdTipoEnergia = ?, Descripcion = ?, FechaModifica = datetime('now','localtime') " +
            "WHERE IdExoBot = ? AND Estado='A'";
        try (Connection conn = openConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, noAccion == null ? 0 : noAccion);
            if (idTipoEnergia == null) stmt.setNull(2, java.sql.Types.INTEGER);
            else stmt.setInt(2, idTipoEnergia);
            stmt.setString(3, descripcion);
            stmt.setInt(4, idExoBot);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new AppException("Error al actualizar ExoBotArma", e, getClass(), "updateExoBotArmaAccion");
        }
    }

    public boolean updateExoBotArmaAccionById(Integer idExoBotArma, Integer noAccion, Integer idTipoEnergia, String descripcion) throws AppException {
        String sql =
            "UPDATE ExoBotArma " +
            "SET NoAccion = ?, IdTipoEnergia = ?, Descripcion = ?, FechaModifica = datetime('now','localtime') " +
            "WHERE IdExoBotArma = ? AND Estado='A'";
        try (Connection conn = openConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, noAccion == null ? 0 : noAccion);
            if (idTipoEnergia == null) stmt.setNull(2, java.sql.Types.INTEGER);
            else stmt.setInt(2, idTipoEnergia);
            stmt.setString(3, descripcion);
            stmt.setInt(4, idExoBotArma);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new AppException("Error al actualizar ExoBotArma por Id", e, getClass(), "updateExoBotArmaAccionById");
        }
    }
}

