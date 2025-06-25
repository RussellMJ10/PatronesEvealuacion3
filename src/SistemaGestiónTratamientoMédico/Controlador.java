package SistemaGestiónTratamientoMédico;

import java.util.ArrayList;
import java.util.List;

public class Controlador {
    private static Controlador instancia;
    private List<Tratamiento> tratamientos;

    private Controlador() {
        tratamientos = new ArrayList<>();
    }

    public static Controlador getInstancia() {
        if (instancia == null) {
            instancia = new Controlador();
        }
        return instancia;
    }

    public void agregarTratamiento(Tratamiento tratamiento) {
        tratamientos.add(tratamiento);
    }

    public void mostrarTratamientos() {
        System.out.println("\n--- Lista de Tratamientos ---");
        for (Tratamiento t : tratamientos) {
            System.out.println("Nombre: " + t.getNombre() +
                               ", Descripción: " + t.getDescripcion() +
                               ", Duración: " + t.getDuracionDias() + " días");
        }
    }
}

