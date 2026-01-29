package DataAccess.DAOs;

import DataAccess.Helpers.DataHelperSQLiteDAO;
import Infrastructure.AppException;
import DataAccess.DTOs.aeIABotDTO;

public class aeIABotDAO extends DataHelperSQLiteDAO<aeIABotDTO>{
    public aeIABotDAO() throws AppException {
        super(aeIABotDTO.class, "IABot", "IdIABot");
    }
}
