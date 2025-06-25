package SistemaGestiónTratamientoMédico;

import java.util.ArrayList;
import java.util.List;

public class TratamientoObservable {
    private Tratamiento tratamiento;
    private List<Observador> observadores = new ArrayList<>();

    public TratamientoObservable(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }

    public void agregarObservador(Observador observador) {
        observadores.add(observador);
    }

    public void notificarObservadores(String mensaje) {
        for (Observador obs : observadores) {
            obs.actualizar("[" + tratamiento.getNombre() + "] " + mensaje);
        }
    }

    public Tratamiento getTratamiento() {
        return tratamiento;
    }
}
