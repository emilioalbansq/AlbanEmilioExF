import App.ConsoleApp.Sistema;
import App.DesktopApp.Forms.AppSplashScreen;
import App.DesktopApp.Forms.AppStart;
import BusinessLogic.Entities.aeUsuario;
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
        // Requisito: iniciar por consola solicitando autenticación (máx 3 intentos)
        Sistema sistema = new Sistema();
        aeUsuario user = new aeUsuario("patmic", "123");

        if (!sistema.aeAutenticarUsuario(user)) {
            System.exit(0);
        }

        new AppSplashScreen();
        new AppStart("aeExoBot");

        
    }
}
