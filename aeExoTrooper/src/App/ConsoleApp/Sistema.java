package App.ConsoleApp;

import java.util.Scanner;

import BusinessLogic.Entities.aeUsuario;
import Infrastructure.Tools.CMD;

public class Sistema {
    

    public boolean aeAutenticarUsuario(aeUsuario user){
        int countTry = 0;
        try (Scanner sc = new Scanner(System.in)) {
            while ( countTry++ < 3 ) {
                System.out.print("Ingrese usuario: ");
                String u = sc.nextLine();
                System.out.print("Ingrese contraseña: ");
                String p = sc.nextLine();

                if (user.aeCheckLogin(u, p)) {
                    CMD.traceGood("Acceso concedido");
                    return true;
                }

                CMD.traceError("Acceso denegado.");
            }
        }
        return false;
    }

    
}
