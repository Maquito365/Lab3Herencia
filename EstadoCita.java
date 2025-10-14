// Este enum representa el estado actual en el que se encuentra una cita médica.
// Se usa para controlar el flujo de una cita desde que se programa hasta que termina o se cancela.
public enum EstadoCita {
    PROGRAMADA,
    CONFIRMADA,
    EN_PROGRESO,
    COMPLETADA,
    CANCELADA,
    REAGENDADA
}