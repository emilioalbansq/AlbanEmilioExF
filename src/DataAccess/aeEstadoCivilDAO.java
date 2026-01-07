package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import DataAccess.DTO.aeDataHelperSQLite;
import DataAccess.DTO.aeEstadoCivilDTO;

public class aeEstadoCivilDAO extends aeDataHelperSQLite implements aeIDAO<aeEstadoCivilDTO> {

    @Override
    public boolean create(aeEstadoCivilDTO entity) throws Exception {
        //3,             'Soltero',     'Tipos de Estado Civil'
        String query = "INSERT INTO Catalogo (IdCatalogoTipo, Nombre, Descripcion) VALUES (?,?,?)";
        try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, 3);
            pstmt.setString(2, entity.getNombre());
            pstmt.setString(3, entity.getDescripcion());
            pstmt.executeUpdate();
            return true;
        }
        catch (SQLException e) {
            throw e; // new PatException(e.getMessage(), getClass().getName(), "create");
        }
    }

    @Override
    public List<aeEstadoCivilDTO> readAll() throws Exception {
        List<aeEstadoCivilDTO> lst = new ArrayList<>();
        String query = "SELECT IdCatalogo "
                    + ",IdCatalogoTipo "
                    + ",Nombre "
                    + ",Descripcion "
                    + ",Estado "
                    + ",FechaCreacion "
                    + ",FechaModifica "
                    + "FROM Catalogo "
                    + "WHERE Estado ='A' "
                    + "AND IdCatalogoTipo = 3";

        try {
            Connection conn = openConnection(); // conectar a DB
            Statement stmt = conn.createStatement(); // CRUD : select * ...
            ResultSet rs = stmt.executeQuery(query); // ejecutar la
            while (rs.next()) {
                aeEstadoCivilDTO s = new aeEstadoCivilDTO(rs.getInt(1) // IdCatalogo
                                        ,rs.getInt(2) // IdCatalogoTipo
                                        ,rs.getString(3) // Nombre
                                        ,rs.getString(4) // Descripcion
                                        ,rs.getString(5) // Estado
                                        ,rs.getString(6) // FechaCrea
                                        ,rs.getString(7)); // FechaModifica
                lst.add(s);
            }
        } catch (SQLException e) {
            throw e; // new PatException(e.getMessage(), getClass().getName(), "readALL()");
        }
        return lst;
    }

    @Override
    public boolean update(aeEstadoCivilDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Catalogo SET Nombre = ?, Descripcion = ?, FechaModifica = ? WHERE IdCatalogo = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, entity.getDescripcion());
            pstmt.setString(3, dtf.format(now).toString());
            pstmt.setInt(4, entity.getIdCatalogo());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e; // new PatException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = "UPDATE Catalogo SET Estado = ? WHERE IdCatalogo = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "x");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e; //new PatException(e.getMessage(), getClass().getName(), "delete()");
        }
    }
    
    @Override
    public aeEstadoCivilDTO readById(Integer id) throws Exception {
        aeEstadoCivilDTO s = new aeEstadoCivilDTO();
        String query = "SELECT IdCatalogo "
                    + ",IdCatalogoTipo "
                    + ",Nombre "
                    + ",Descripcion "
                    + ",Estado "
                    + ",FechaCreacion "
                    + ",FechaModifica "
                    + "FROM Catalogo "
                    + "WHERE Estado ='A' "
                    + "AND IdCatalogoTipo = 3 "
                    + "AND IdCatalogo = " + id.toString(); // Tipos de Estado Civil

        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                s = new aeEstadoCivilDTO(rs.getInt(1) // IdCatalogo
                                        ,rs.getInt(2) // IdCatalogoTipo
                                        ,rs.getString(3) // Nombre
                                        ,rs.getString(4) // Descripcion
                                        ,rs.getString(5) // Estado
                                        ,rs.getString(6) // FechaCrea
                                        ,rs.getString(7)); // FechaModifica
            }
        } catch (SQLException e) {
            throw e; // new PatException(e.getMessage(), getClass().getName(), "readById()");
        }
        return s;
    }

    public Integer getRowCount() throws Exception{
        String query = " SELECT COUNT(*) TotalReg"
                     + " FROM Catalogo "
                     + " WHERE Estado = 'A'"
                     + " AND IdCatalogoTipo = 3"; // Tipos de Estado Civil
        try {
            Connection conn = openConnection(); // conectar a DB
            Statement stmt = conn.createStatement(); // CRUD : select * ...
            ResultSet rs = stmt.executeQuery(query); // ejecutar la
            while (rs.next()) {
                return rs.getInt(1);
            }
        }
        catch (SQLException e) {
            throw e; //new PatException(e.getMessage(), getClass().getName(), "getMaxRow()");
        }
        return 0;
    }
    
}
