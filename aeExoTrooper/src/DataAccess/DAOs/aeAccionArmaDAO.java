package DataAccess.DAOs;

import DataAccess.DTOs.aeAccionArmaDTO;
import DataAccess.Helpers.DataHelperSQLiteDAO;
import Infrastructure.AppException;

public class aeAccionArmaDAO extends DataHelperSQLiteDAO<aeAccionArmaDTO> {
    public aeAccionArmaDAO() throws AppException {
        super(aeAccionArmaDTO.class, "AccionArma", "IdAccionArma");
    }
}
