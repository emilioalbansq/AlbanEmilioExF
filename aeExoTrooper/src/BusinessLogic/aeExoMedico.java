package BusinessLogic;

import BusinessLogic.Entities.aeTipoArma;
import BusinessLogic.Entities.aeTipoMunicion;
import BusinessLogic.Interfaces.IaeIABOT;

public class aeExoMedico implements IaeIABOT {

    public aeExoMedico(String nombre, IaeIABOT iabot) {
    }

    public boolean aeAsistir(aeTipoArma tipoArma, aeTipoMunicion tipoMunicion) {
        //LOGICA PARA ASISTIR CON TIPO DE ARMA Y TIPO DE MUNICION
        return false;
    }

    @Override
    public void aeAsistirEntrenamiento(aeTipoArma arma) {
        //LOGICA PARA ASISTIR EN ENTRENAMIENTO
    }

}
