package DataAccess.DAOs;

import DataAccess.DTOs.aePersonaTipoDTO;
import DataAccess.Helpers.DataHelperSQLiteDAO;
import Infrastructure.AppException;

public class aePersonaTipoDAO extends DataHelperSQLiteDAO<aePersonaTipoDTO> {

    public aePersonaTipoDAO() throws AppException {
        super(aePersonaTipoDTO.class, "Catalogo", "IdCatalogo");
    }

}
