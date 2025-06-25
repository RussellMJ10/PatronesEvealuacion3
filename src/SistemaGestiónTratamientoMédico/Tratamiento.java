package SistemaGestiónTratamientoMédico;

public class Tratamiento {
    private String nombre;
    private String descripcion;
    private int duracionDias;

    public Tratamiento(String nombre, String descripcion, int duracionDias) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracionDias = duracionDias;
    }

    public Tratamiento clonar() {
        return new Tratamiento(nombre, descripcion, duracionDias);
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getDuracionDias() {
        return duracionDias;
    }
}
