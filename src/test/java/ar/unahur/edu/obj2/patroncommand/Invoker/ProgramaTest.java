package ar.unahur.edu.obj2.patroncommand.Invoker;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unahur.edu.obj2.patroncommand.Microcontrolador.Microcontrolador;
import ar.unahur.edu.obj2.patroncommand.Microcontrolador.Programable;
import ar.unahur.edu.obj2.patroncommand.Operaciones.Add;
import ar.unahur.edu.obj2.patroncommand.Operaciones.Lod;
import ar.unahur.edu.obj2.patroncommand.Operaciones.Lodv;
import ar.unahur.edu.obj2.patroncommand.Operaciones.Nop;
import ar.unahur.edu.obj2.patroncommand.Operaciones.Str;
import ar.unahur.edu.obj2.patroncommand.Operaciones.Swap;

public class ProgramaTest {
    private Programa p = new Programa();
    private Programable micro = new Microcontrolador();

    @BeforeEach()
    void setUp() {
        p.vaciarLista();
        p.resetearMicro(micro);
    }

    @Test
    void avanzar3PosicionesElProgramaCounter() {
        p.agregarOperaciones(new Nop());
        p.agregarOperaciones(new Nop());
        p.agregarOperaciones(new Nop());
        p.ejecutar(micro);
        assertEquals(micro.getProgramCounter(), 3);
    }

    @Test
    void sumar20Mas17YObtener37EnAcumuladorA() {
        p.agregarOperaciones(new Lodv(20));
        p.agregarOperaciones(new Swap());
        p.agregarOperaciones(new Lodv(17));
        p.agregarOperaciones(new Add());

        p.ejecutar(micro);
        assertEquals(37, micro.getAcumuladorA());
        assertEquals(0, micro.getAcumuladorB());
        assertEquals(4, micro.getProgramCounter());
    }

    @Test
    void sumar2Mas8Mas5EnAcumuladorA() {
        p.agregarOperaciones(new Lodv(2));
        p.agregarOperaciones(new Str(0));
        p.agregarOperaciones(new Lodv(8));

        p.agregarOperaciones(new Swap());
        p.agregarOperaciones(new Lodv(5));
        p.agregarOperaciones(new Add());

        p.agregarOperaciones(new Swap());
        p.agregarOperaciones(new Lod(0));
        p.agregarOperaciones(new Add());

        p.ejecutar(micro);
        assertEquals(15, micro.getAcumuladorA());
        assertEquals(0, micro.getAcumuladorB());
        

    }
}
