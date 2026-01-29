package DataAccess.DAOs;

import DataAccess.DTOs.aeTipoExoBotDTO;
import DataAccess.Helpers.DataHelperSQLiteDAO;
import Infrastructure.AppException;

public class aeTipoExoBotDAO extends DataHelperSQLiteDAO<aeTipoExoBotDTO> {
    public aeTipoExoBotDAO() throws AppException {
        super(aeTipoExoBotDTO.class, "TipoExoBot", "IdTipoExoBot");
    }
}
