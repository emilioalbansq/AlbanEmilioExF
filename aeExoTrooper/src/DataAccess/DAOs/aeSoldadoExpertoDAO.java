package DataAccess.DAOs;

import DataAccess.DTOs.aeSoldadoExpertoDTO;
import DataAccess.Helpers.DataHelperSQLiteDAO;
import Infrastructure.AppException;

public class aeSoldadoExpertoDAO extends DataHelperSQLiteDAO<aeSoldadoExpertoDTO> {
    public aeSoldadoExpertoDAO() throws AppException {
        super(aeSoldadoExpertoDTO.class, "SoldadoExperto", "IdSoldadoExperto");
    }
}
