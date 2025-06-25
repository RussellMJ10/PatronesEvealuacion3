package SistemaGestiónTratamientoMédico;

public class HospitalExterno {
    private String nombre;

    public HospitalExterno(String nombre) {
        this.nombre = nombre;
    }

    public void conectar() {
        System.out.println("Conectado a sistema hospitalario externo: " + nombre);
    }

    public void exportarDatos() {
        System.out.println("Datos exportados al sistema " + nombre);
    }
}
