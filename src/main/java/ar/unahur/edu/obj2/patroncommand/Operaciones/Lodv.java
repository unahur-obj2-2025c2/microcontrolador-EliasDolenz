package ar.unahur.edu.obj2.patroncommand.Operaciones;

import ar.unahur.edu.obj2.patroncommand.Microcontrolador.Programable;

public class Lodv extends Comando {
    public final Integer val;

    public Lodv(Integer val) {
        this.val = val;
    }

    @Override
    protected void doExecute(Programable micro) {
        micro.setAcumuladorA(val);
    }

}
