package Framework;

public class AEException extends Exception {
    
    public AEException(String e, String clase, String metodo) {
        //grabar el log
        //System.out.println("ERROR APP --> LOG [" + clase + "." + metodo + " : " + e + "]");
    }

    @Override
    public String toString() {
        return " ¿Qué Miras? >:( ";
    }
}
