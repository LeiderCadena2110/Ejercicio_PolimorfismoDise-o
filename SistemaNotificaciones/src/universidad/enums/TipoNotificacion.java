package universidad.enums;

/**
 * Lista de los 4 tipos de notificaciones universitarias.
 * Aparece en el diagrama como <<enumeration>>
 */
public enum TipoNotificacion {

    PUBLICACION_CALIFICACIONES("Publicación de Calificaciones"),
    RECORDATORIO_PAGO("Recordatorio de Pago de Matrícula"),
    CANCELACION_CLASE("Aviso de Cancelación de Clase"),
    CONFIRMACION_INSCRIPCION("Confirmación de Inscripción");

    // Cada valor lleva una descripción legible
    private final String descripcion;

    // Constructor del enum
    TipoNotificacion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}