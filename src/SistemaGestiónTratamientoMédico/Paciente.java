package SistemaGestiónTratamientoMédico;

public class Paciente implements Observador {
    private String nombre;

    public Paciente(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void actualizar(String mensaje) {
        System.out.println("Paciente " + nombre + " recibió mensaje: " + mensaje);
    }
}
