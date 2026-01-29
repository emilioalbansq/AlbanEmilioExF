package DataAccess.DAOs;

import DataAccess.DTOs.aeExoBotDTO;
import DataAccess.Helpers.DataHelperSQLiteDAO;
import Infrastructure.AppException;

public class aeExoBotDAO extends DataHelperSQLiteDAO<aeExoBotDTO> {
    public aeExoBotDAO() throws AppException {
        super(aeExoBotDTO.class, "ExoBot", "IdExoBot");
    }
}
