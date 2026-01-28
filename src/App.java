import App.DesktopApp.Forms.AppSplashScreen;
import App.DesktopApp.Forms.AppStart;
// import BusinessLogic.Entities.aeEstadoCivilBL;
// import BusinessLogic.Entities.aePersonaTipoBL;
// import BusinessLogic.Entities.aeSexoBL;
// import DataAccess.DAOs.aeEstadoCivilDAO;
// import DataAccess.DAOs.aePersonaTipoDAO;
// import DataAccess.DAOs.aeSexoDAO;
// import DataAccess.DTOs.aeEstadoCivilDTO;
// import DataAccess.DTOs.aeSexoDTO;

public class App {
    public static void main(String[] args) throws Exception {
        
        new AppSplashScreen();
        new AppStart("aeExoBot");

        //TESTING DAO:
        // try {
        //     SexoDAO sDAO = new SexoDAO();
        //     for (SexoDTO s : sDAO.readAll()) 
        //         System.out.println(s.toString());
            
            
        //     System.out.println("------------------");

        //     EstadoCivilDAO ecDAO = new EstadoCivilDAO();
        //     for (EstadoCivilDTO reg : ecDAO.readAll()) 
        //         System.out.println(reg.toString());
            

        //     System.out.println("------------------");

        //     PersonaTipoDAO ptDAO = new PersonaTipoDAO();
        //     for (var reg : ptDAO.readAll()) 
        //         System.out.println(reg.toString());
            
        // } catch (Exception e) {
        //     System.out.println(e.toString());
        // }

        //TESTING BL:
        // try {
        //     aeSexoBL sBL = new aeSexoBL();
        //     //sBL.create(new SexoDTO(0, 0, "Nuevo Sexo", "Prueba", null, null, null));
        //     for (aeSexoDTO s : sBL.getAll())
        //         System.out.println(s.toString());

        //     System.out.println("------------------");

        //     aeEstadoCivilBL ecBL = new aeEstadoCivilBL();
        //     for (aeEstadoCivilDTO ec : ecBL.getAll())
        //         System.out.println(ec.toString());

        //     System.out.println("------------------");

        //     aePersonaTipoBL ptBL = new aePersonaTipoBL();
        //     for (var pt : ptBL.getAll())
        //         System.out.println(pt.toString());
            
        // } catch (Exception e) {
        //     System.out.println(e.toString());
        // }
    }
}
