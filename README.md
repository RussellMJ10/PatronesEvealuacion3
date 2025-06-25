# PatronesEvaluacion3 – Sistema de Gestión de Tratamientos Médicos

## Descripción del sistema y problema a resolver

PatronesEvaluacion3 es un sistema de consola para la gestión y seguimiento de tratamientos médicos en un hospital o clínica. Permite crear, clonar y administrar tratamientos, registrar pacientes y asignarlos a tratamientos específicos. Los pacientes reciben notificaciones de actualizaciones en sus tratamientos.

Además, el sistema puede integrarse con sistemas hospitalarios externos para sincronizar datos, facilitando la interoperabilidad.

El problema funcional que resuelve es la organización clara y dinámica de tratamientos médicos con una comunicación eficiente a los pacientes, usando patrones de diseño para mantener escalabilidad, modularidad y claridad.

---

## Patrones de diseño aplicados y justificación

### 1. Singleton (`ControladorMediTrack`) – Patrón Creacional  
Se usa para asegurar que solo exista una instancia del controlador central que maneja todos los tratamientos. Así se evita inconsistencias y facilita el acceso global al controlador.

### 2. Prototype (`Tratamiento`) – Patrón Creacional  
Permite clonar tratamientos existentes para crear nuevos rápidamente sin repetir toda la creación desde cero. Esto es útil para tratamientos similares que solo difieren en algunos detalles.

### 3. Observer (`TratamientoObservable` y `Paciente`) – Patrón de Comportamiento  
Permite notificar a todos los pacientes (observadores) asignados a un tratamiento cuando hay novedades o mensajes importantes, garantizando comunicación efectiva.

### 4. Adapter (`AdaptadorHospital` y `SistemaHospitalExterno`) – Patrón Estructural  
Facilita la integración con sistemas hospitalarios externos, adaptando su interfaz para que funcione con nuestro sistema sin modificar el código original del sistema externo.

---

## Instrucciones de compilación y ejecución

### Requisitos  
- Java JDK 8 o superior  
- IDE recomendado: NetBeans (compatible con Java SE)  

### Compilación

Desde la terminal, en el directorio raíz del proyecto:

```bash
javac -d bin src/SistemaGestiónTratamientoMédico/*.java
