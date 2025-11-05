package ar.unahur.edu.obj2.patroncommand.Operaciones;

import ar.unahur.edu.obj2.patroncommand.Microcontrolador.Programable;

public interface Operable {

    void execute(Programable micro);

    void undo(Programable micro);
}
