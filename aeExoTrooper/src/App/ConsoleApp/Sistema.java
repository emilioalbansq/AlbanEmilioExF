package App.ConsoleApp;

import BusinessLogic.Entities.aeUsuario;

public class Sistema {
    

    public boolean aeAutenticarUsuario(aeUsuario user){
        int countTry = 0;
        while ( countTry++ < 3 ) {
            System.out.println("Ingrese usuario:");
            String u = System.console().readLine();
            System.out.println("Ingrese contraseña:");
            String p = System.console().readLine();

            if (user.aeCheckLogin(u, p)) 
                return true;
        }
        return false;
    }

    // public void start(EntomologoGenestita entomologo) {
    //     System.out.println(CMDColor.BLUE + "Sistema Ruso iniciado...." + CMDProgress.showSpinner() + CMDColor.RESET);
    //     try {
    //         if (autenticarEntomolgo(entomologo)) {
    //             System.out.println(CMDColor.GREEN + "¡Acceso concedido!" + CMDColor.RESET);
    //             saveHormigas(entomologo);
    //         } else {
    //             System.out.println(CMDColor.RED + "Acceso denegado. Saliendo del sistema." + CMDColor.RESET);
    //             System.exit(0);
    //         }
    //     } catch (AppException e) {
    //         System.out.println(CMDColor.RED + "Error durante la autenticación: " + e.getMessage() + CMDColor.RESET);
    //     }
    // }
    // // public void showEstado() {
    // //     FactoryBL<EstadoDTO> bl = new FactoryBL<>(EstadoDAO.class);
    // //     try {
    // //         for ( EstadoDTO eDTO : bl.getAll() ) {
    // //             System.out.println( eDTO.toString() );
    // //         }
    // //     } catch (Exception e) {
    // //         System.out.println( "Error leyendo estados: " + e.getMessage() );
    // //     }

    // // }
    

    // public void saveHormigas(EntomologoGenestita entomologo) {
    //     try {
    //         List<HormigaDTO> lstHormigas = entomologo.etlAntNest(); // cosecha hormigas
    //         for ( HormigaDTO hDTO : lstHormigas ) {
    //             antFactoryBl.add(hDTO);
    //             System.out.println( "Hormiga guardada: " + hDTO.toString() );
    //         }
    //     } catch (Exception e) {
    //         System.out.println( "Error al guardar la hormiga: " + e.getMessage() );
    //     }
    // }


    // public List<CoordenadaUK> readCoord(String fileNamePath) throws IOException {
    //     List<CoordenadaUK> lstCoord = new java.util.ArrayList<>();
    //     List<String> allLines = Files.readAllLines(Paths.get(fileNamePath));
    //     for (String line : allLines) {
    //         System.out.println(line);
    //         String[] coord = line.split(",");
    //         CoordenadaUK coordenada = new CoordenadaUK( coord[0], coord[6], false);
    //         lstCoord.add(coordenada);
    //         //System.out.println( coordenada.toString() );
    //     }
    //     return lstCoord;
    // }
}
