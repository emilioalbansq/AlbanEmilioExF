package BusinessLogic.Entities;

import java.util.List;

import DataAccess.DAOs.aeEstadoCivilDAO;
import DataAccess.DTOs.aeEstadoCivilDTO;


public class aeEstadoCivilBL {

    private aeEstadoCivilDTO aeEstadoCivil;
    private aeEstadoCivilDAO aeEstadoCivilDAO;
    
    public aeEstadoCivilBL() {}

    public List<aeEstadoCivilDTO> getAll() throws Exception {
        List<aeEstadoCivilDTO> lst = aeEstadoCivilDAO.readAll();
        for (aeEstadoCivilDTO ec : lst) {
            ec.setNombre(ec.getNombre().toUpperCase());
        }
        return lst;
    }

    public aeEstadoCivilDTO getByIdEstadoCivil(int id) throws Exception {
        aeEstadoCivil = aeEstadoCivilDAO.readBy(id);
        return aeEstadoCivil;
    }

    public boolean create(aeEstadoCivilDTO regDTO)  throws Exception {
        return aeEstadoCivilDAO.create(regDTO);
    }

    public boolean update(aeEstadoCivilDTO regDTO)  throws Exception {
        return aeEstadoCivilDAO.update(regDTO);
    }

    public boolean delete(int id)  throws Exception {
        return aeEstadoCivilDAO.delete(id);
    }

}
