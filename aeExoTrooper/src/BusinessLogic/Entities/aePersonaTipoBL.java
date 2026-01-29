package BusinessLogic.Entities;

import java.util.List;

import DataAccess.DAOs.aePersonaTipoDAO;
import DataAccess.DTOs.aePersonaTipoDTO;


public class aePersonaTipoBL {

    private aePersonaTipoDTO personaTipo;
    private aePersonaTipoDAO personaTipoDAO;
    
    public aePersonaTipoBL() {}

    public List<aePersonaTipoDTO> getAll() throws Exception {
        return personaTipoDAO.readAll();
    }

    public aePersonaTipoDTO getByIdPersonaTipo(int id) throws Exception {
        personaTipo = personaTipoDAO.readBy(id);
        return personaTipo;
    }

    public boolean create(aePersonaTipoDTO regDTO)  throws Exception {
        return personaTipoDAO.create(regDTO);
    }

    public boolean update(aePersonaTipoDTO regDTO)  throws Exception {
        return personaTipoDAO.update(regDTO);
    }

    public boolean delete(int id)  throws Exception {
        return personaTipoDAO.delete(id);
    }

}
