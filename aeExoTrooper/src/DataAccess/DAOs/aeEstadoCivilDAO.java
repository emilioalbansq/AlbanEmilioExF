package DataAccess.DAOs;

import DataAccess.Helpers.DataHelperSQLiteDAO;
import Infrastructure.AppException;
import DataAccess.DTOs.aeEstadoCivilDTO;

public class aeEstadoCivilDAO extends DataHelperSQLiteDAO<aeEstadoCivilDTO> {

    public aeEstadoCivilDAO() throws AppException {
        super(aeEstadoCivilDTO.class, "Catalogo", "IdCatalogo");
    }
    
}
