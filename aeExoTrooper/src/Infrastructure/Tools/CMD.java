package Infrastructure.Tools;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import Infrastructure.AppConfig;

public abstract class CMD {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private CMD() {}

    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void println(String msg){
        System.out.println(CMDColor.CYAN + msg + CMDColor.RESET);
    } 
    public static void printlnError(String msg){
        System.out.println(CMDColor.RED + msg + CMDColor.RESET);
    } 

    /**
     * Imprime y almacena un evento del sistema (ExoTracer).
     * Formato requerido por el examen: "GOOD : ..." / "ERROR: ..."
     */
    public static void traceGood(String msg) {
        trace("GOOD : ", msg, CMDColor.GREEN);
    }

    public static void traceError(String msg) {
        trace("ERROR: ", msg, CMDColor.RED);
    }

    private static void trace(String prefix, String msg, String color) {
        String line = prefix + msg;
        String timestamp = LocalDateTime.now().format(FORMATTER);
        String fileLine = timestamp + " | " + line;

        System.out.println(color + line + CMDColor.RESET);

        try (PrintWriter writer = new PrintWriter(new FileWriter(AppConfig.getEXOTRACER(), true))) {
            writer.println(fileLine);
        } catch (Exception e) {
            // Si falla el tracer, no debe tumbar el sistema; solo reporta en consola.
            System.out.println(CMDColor.RED + "ERROR: No se pudo escribir ExoTracer.txt -> " + e.getMessage() + CMDColor.RESET);
        }
    }
}
