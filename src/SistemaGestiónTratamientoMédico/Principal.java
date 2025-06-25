// Paquete sugerido: meditrack

package SistemaGestiónTratamientoMédico;

import java.util.*;

// Clase principal del sistema
public class Principal {
    private static Scanner escaner = new Scanner(System.in);
    private static Controlador controlador = Controlador.getInstancia();
    private static Map<String, TratamientoObservable> tratamientos = new HashMap<>();
    private static List<Paciente> pacientes = new ArrayList<>();

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            System.out.println("\n===== MENú MEDITrack =====");
            System.out.println("1. Crear tratamiento nuevo");
            System.out.println("2. Clonar tratamiento");
            System.out.println("3. Registrar paciente");
            System.out.println("4. Asignar paciente a tratamiento");
            System.out.println("5. Notificar pacientes de tratamiento");
            System.out.println("6. Ver tratamientos registrados");
            System.out.println("7. Conectar a sistema hospitalario externo");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = escaner.nextInt();
            escaner.nextLine();

            switch (opcion) {
                case 1 -> crearTratamiento();
                case 2 -> clonarTratamiento();
                case 3 -> registrarPaciente();
                case 4 -> asignarPacienteATratamiento();
                case 5 -> notificarPacientes();
                case 6 -> controlador.mostrarTratamientos();
                case 7 -> conectarSistemaExterno();
                case 0 -> {
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                }
                default -> System.out.println("Opcion inválida");
            }
        }
    }

    private static void crearTratamiento() {
        System.out.print("Nombre del tratamiento: ");
        String nombre = escaner.nextLine();
        System.out.print("Descripción: ");
        String descripcion = escaner.nextLine();
        System.out.print("Duración (días): ");
        int dias = escaner.nextInt(); escaner.nextLine();

        Tratamiento tratamiento = new Tratamiento(nombre, descripcion, dias);
        TratamientoObservable tratamientoObs = new TratamientoObservable(tratamiento);
        tratamientos.put(nombre, tratamientoObs);
        controlador.agregarTratamiento(tratamiento);
        System.out.println("Tratamiento creado y registrado.");
    }

    private static void clonarTratamiento() {
        System.out.print("Nombre del tratamiento a clonar: ");
        String original = escaner.nextLine();
        if (tratamientos.containsKey(original)) {
            Tratamiento clon = tratamientos.get(original).getTratamiento().clonar();
            System.out.print("Nuevo nombre para el tratamiento clonado: ");
            String nuevoNombre = escaner.nextLine();
            clon = new Tratamiento(nuevoNombre, clon.getDescripcion(), clon.getDuracionDias());

            TratamientoObservable tratamientoObs = new TratamientoObservable(clon);
            tratamientos.put(nuevoNombre, tratamientoObs);
            controlador.agregarTratamiento(clon);
            System.out.println("Tratamiento clonado como: " + nuevoNombre);
        } else {
            System.out.println("Tratamiento no encontrado.");
        }
    }

    private static void registrarPaciente() {
        System.out.print("Nombre del paciente: ");
        String nombre = escaner.nextLine();
        Paciente paciente = new Paciente(nombre);
        pacientes.add(paciente);
        System.out.println("Paciente registrado.");
    }

    private static void asignarPacienteATratamiento() {
        System.out.print("Nombre del tratamiento: ");
        String nombreTratamiento = escaner.nextLine();
        System.out.print("Nombre del paciente: ");
        String nombrePaciente = escaner.nextLine();

        Optional<Paciente> paciente = pacientes.stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombrePaciente))
                .findFirst();

        if (tratamientos.containsKey(nombreTratamiento) && paciente.isPresent()) {
            tratamientos.get(nombreTratamiento).agregarObservador(paciente.get());
            System.out.println("Paciente asignado al tratamiento.");
        } else {
            System.out.println("Tratamiento o paciente no encontrado.");
        }
    }

    private static void notificarPacientes() {
        System.out.print("Nombre del tratamiento: ");
        String nombreTratamiento = escaner.nextLine();
        System.out.print("Mensaje a enviar: ");
        String mensaje = escaner.nextLine();

        if (tratamientos.containsKey(nombreTratamiento)) {
            tratamientos.get(nombreTratamiento).notificarObservadores(mensaje);
        } else {
            System.out.println("Tratamiento no encontrado.");
        }
    }

    private static void conectarSistemaExterno() {
        System.out.print("Nombre del sistema externo: ");
        String nombre = escaner.nextLine();
        HospitalExterno externo = new HospitalExterno(nombre);
        Adaptador adaptador = new AdaptadorHospital(externo);
        adaptador.sincronizarDatos();
    }
}
