package DataAccess.DAOs;

import DataAccess.DTOs.aeSexoDTO;
import DataAccess.Helpers.DataHelperSQLiteDAO;
import Infrastructure.AppException;

public class aeSexoDAO extends DataHelperSQLiteDAO<aeSexoDTO> {
    public aeSexoDAO() throws AppException {
        super(aeSexoDTO.class, "Catalogo", "IdCatalogo");
    }
}
