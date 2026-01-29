package DataAccess.DAOs;

import DataAccess.DTOs.aeEstadoCivilDTO;
import DataAccess.Helpers.DataHelperSQLiteDAO;
import Infrastructure.AppException;

public class aeIABotDAO extends DataHelperSQLiteDAO<aeEstadoCivilDTO>{


    public aeIABotDAO() throws AppException {
        super(aeEstadoCivilDTO.class, "Catalogo", "IdCatalogo");
    }
}
