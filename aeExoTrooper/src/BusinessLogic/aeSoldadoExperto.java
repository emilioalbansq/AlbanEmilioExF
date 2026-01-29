package BusinessLogic;

import BusinessLogic.Entities.aeBioEscaner;
import BusinessLogic.Entities.aeTipoArma;
import BusinessLogic.Interfaces.IaeIABOT;
import Infrastructure.Tools.CMD;

public class aeSoldadoExperto implements IaeIABOT {

    private String nombre;
    public aeSoldadoExperto(String nombre, IaeIABOT iabot) {
        
    }

    public boolean aeEntrenarArma(IaeIABOT iabot) {
        if (iabot == null) {
            CMD.traceError(this.nombre + " SIN IABOT");
            return false;
        }

        CMD.traceGood(this.nombre + " ENTRENA ARMA");
        return true;

    }

    @Override
    public void aeAsistirEntrenamiento(aeTipoArma arma) {
    if (arma == null) {
            CMD.traceError("TIPO ARMA NULO");
            return;
        }

        CMD.traceGood("IAEXO ASISTE ENTRENAMIENTO " + arma.getTipo());
    }
}
