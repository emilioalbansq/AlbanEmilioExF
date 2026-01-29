package DataAccess.DAOs;

import DataAccess.DTOs.aeExoBotArmaDTO;
import DataAccess.Helpers.DataHelperSQLiteDAO;
import Infrastructure.AppException;

public class aeExoBotArmaDAO extends DataHelperSQLiteDAO<aeExoBotArmaDTO> {
    public aeExoBotArmaDAO() throws AppException {
        super(aeExoBotArmaDTO.class, "ExoBotArma", "IdExoBotArma");
    }
}
