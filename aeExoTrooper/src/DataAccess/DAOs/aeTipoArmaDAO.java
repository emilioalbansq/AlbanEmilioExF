package DataAccess.DAOs;

import DataAccess.DTOs.aeTipoArmaDTO;
import DataAccess.Helpers.DataHelperSQLiteDAO;
import Infrastructure.AppException;

public class aeTipoArmaDAO extends DataHelperSQLiteDAO<aeTipoArmaDTO> {
    public aeTipoArmaDAO() throws AppException {
        super(aeTipoArmaDTO.class, "TipoArma", "IdTipoArma");
    }
}
