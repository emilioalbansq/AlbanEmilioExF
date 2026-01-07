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
import DataAccess.DTO.aePersonaTipoDTO;

public class aePersonaTipoDAO extends aeDataHelperSQLite implements aeIDAO<aePersonaTipoDTO> {

    @Override
    public boolean create(aePersonaTipoDTO entity) throws Exception {
        //2,             'Masculino',     'tipos de sexualida'
        String query = "INSERT INTO Catalogo (IdCatalogoTipo, Nombre, Descripcion) VALUES (?,?,?)";
        try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, 1);
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
    public List<aePersonaTipoDTO> readAll() throws Exception {
        List<aePersonaTipoDTO> lst = new ArrayList<>();
        String query = "SELECT IdCatalogo "
                    + ",IdCatalogoTipo "
                    + ",Nombre "
                    + ",Descripcion "
                    + ",Estado "
                    + ",FechaCreacion "
                    + ",FechaModifica "
                    + "FROM Catalogo "
                    + "WHERE Estado ='A' "
                    + "AND IdCatalogoTipo = 1"; // Tipos de Personas

        try {
            Connection conn = openConnection(); // conectar a DB
            Statement stmt = conn.createStatement(); // CRUD : select * ...
            ResultSet rs = stmt.executeQuery(query); // ejecutar la
            while (rs.next()) {
                aePersonaTipoDTO s = new aePersonaTipoDTO(rs.getInt(1) // IdCatalogo
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
    public boolean update(aePersonaTipoDTO entity) throws Exception {
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
    public aePersonaTipoDTO readById(Integer id) throws Exception {
        aePersonaTipoDTO s = new aePersonaTipoDTO();
        String query = "SELECT IdCatalogo "
                    + ",IdCatalogoTipo "
                    + ",Nombre "
                    + ",Descripcion "
                    + ",Estado "
                    + ",FechaCreacion "
                    + ",FechaModifica "
                    + "FROM Catalogo "
                    + "WHERE Estado ='A' "
                    + "AND IdCatalogoTipo = 1 "
                    + "AND IdCatalogo = " + id.toString(); // Tipos de Personas

        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                s = new aePersonaTipoDTO(rs.getInt(1) // IdCatalogo
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
                     + " AND IdCatalogoTipo = 1"; // tipos de personas
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
