package SistemaGestiónTratamientoMédico;

public class AdaptadorHospital implements Adaptador {
    private HospitalExterno sistema;

    public AdaptadorHospital(HospitalExterno sistema) {
        this.sistema = sistema;
    }

    @Override
    public void sincronizarDatos() {
        sistema.conectar();
        sistema.exportarDatos();
        System.out.println("Sincronización completa.");
    }
}
