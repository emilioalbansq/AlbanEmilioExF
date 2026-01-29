package DataAccess.DAOs;

import DataAccess.DTOs.aeTipoEnergiaDTO;
import DataAccess.Helpers.DataHelperSQLiteDAO;
import Infrastructure.AppException;

public class aeTipoEnergiaDAO extends DataHelperSQLiteDAO<aeTipoEnergiaDTO> {
    public aeTipoEnergiaDAO() throws AppException {
        super(aeTipoEnergiaDTO.class, "TipoEnergia", "IdTipoEnergia");
    }
}
