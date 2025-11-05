package ar.unahur.edu.obj2.patroncommand.Operaciones;

import ar.unahur.edu.obj2.patroncommand.Microcontrolador.Programable;

public class Lod extends Comando {
    private final Integer ddr; //dirección en memoria.

    public Lod(Integer ddr) {
        this.ddr = ddr;
    }

    @Override
    protected void doExecute(Programable micro) {
        micro.setAcumuladorA(micro.getAddr(ddr));
    }
}
