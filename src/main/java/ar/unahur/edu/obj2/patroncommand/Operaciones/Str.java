package ar.unahur.edu.obj2.patroncommand.Operaciones;

import ar.unahur.edu.obj2.patroncommand.Microcontrolador.Programable;

public class Str extends Comando {
    private final Integer addr;

    public Str(Integer addr) {
        this.addr = addr;
    }

    @Override
    protected void doExecute(Programable micro) {
        micro.setAddr(addr);
    }

}
