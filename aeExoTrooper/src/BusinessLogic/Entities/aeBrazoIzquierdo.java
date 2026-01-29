package BusinessLogic.Entities;

import Infrastructure.Tools.CMD;

public class aeBrazoIzquierdo {


    public void setArma(aeTipoArma arma) {
        if (arma == null) {
            CMD.traceError("BRAZO IZQUIERDO SIN ARMA");
            return;
        }
        
        CMD.traceGood("BRAZO IZQUIERDO USA " + arma.getTipo());

    }
}
