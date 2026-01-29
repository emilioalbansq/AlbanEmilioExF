package BusinessLogic.Entities;

import java.util.List;

import DataAccess.DAOs.aeSexoDAO;
import DataAccess.DTOs.aeSexoDTO;

public class aeSexoBL {
    private aeSexoDTO aeSexo;
    private aeSexoDAO aeSexoDAO;
    
    public aeSexoBL() {}

    public List<aeSexoDTO> getAll() throws Exception {
        List<aeSexoDTO> lst = aeSexoDAO.readAll();
        for (aeSexoDTO s : lst) {
            s.setNombre(s.getNombre().toUpperCase());
        }
        return lst;
    }

    public aeSexoDTO getByIdSexo(int id) throws Exception {
        aeSexo = aeSexoDAO.readBy(id);
        return aeSexo;
    }

    public boolean create(aeSexoDTO sexoDTO)  throws Exception {
        return aeSexoDAO.create(sexoDTO);
    }

    public boolean update(aeSexoDTO sexoDTO)  throws Exception {
        return aeSexoDAO.update(sexoDTO);
    }

    public boolean delete(int id)  throws Exception {
        return aeSexoDAO.delete(id);
    }

}
