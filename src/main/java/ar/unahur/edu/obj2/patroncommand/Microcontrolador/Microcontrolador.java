package ar.unahur.edu.obj2.patroncommand.Microcontrolador;

import java.util.Arrays;
import java.util.List;

import ar.unahur.edu.obj2.patroncommand.Excepciones.FueraDeRangoDeMemoriaException;
import ar.unahur.edu.obj2.patroncommand.Operaciones.Operable;

public class Microcontrolador implements Programable {
    private Integer acumuladorA;
    private Integer acumuladorB;
    private Integer programCounter;
    private List<Integer> memoria = Arrays.asList(new Integer[1024]);

    public Microcontrolador() {
        this.reset();
    }

    @Override
    public void run(List<Operable> operaciones) {
        operaciones.forEach(o -> o.execute(this));
    }

    @Override
    public void incProgramCounter() {
        programCounter++;
    }

    @Override
    public Integer getProgramCounter() {
        return programCounter;
    }

    @Override
    public void setAcumuladorA(Integer value) {
        acumuladorA = value;
    }

    @Override
    public Integer getAcumuladorA() {
        return acumuladorA;
    }

    @Override
    public void setAcumuladorB(Integer value) {
        acumuladorB = value;
    }

    @Override
    public Integer getAcumuladorB() {
        return acumuladorB;
    }

    @Override
    public void setAddr(Integer addr) {
        this.estaDentroDelRango(addr);
        memoria.set(acumuladorA, addr);
    }

    @Override
    public Integer getAddr(Integer addr) {
        this.estaDentroDelRango(addr);
        return memoria.get(addr);
    }

    private void estaDentroDelRango(Integer direccionEnMemoria) {
        if (direccionEnMemoria < 0 || direccionEnMemoria >= memoria.size()) {
            throw new FueraDeRangoDeMemoriaException();
        }
    }

    @Override
    public void reset() {
        setAcumuladorA(0);
        setAcumuladorB(0);
        programCounter = 0;
    }

    @Override
    public Programable copiar() {
        Microcontrolador nuevo = new Microcontrolador();
        nuevo.setAcumuladorA(this.acumuladorA);
        nuevo.setAcumuladorB(this.acumuladorB);
        nuevo.programCounter = this.programCounter;
        return nuevo;
    }

    @Override
    public void copiarDesde(Programable microDeRespaldo) {
        this.acumuladorA = microDeRespaldo.getAcumuladorA();
        this.acumuladorB = microDeRespaldo.getAcumuladorB();
        this.programCounter = microDeRespaldo.getProgramCounter();
    }

}
