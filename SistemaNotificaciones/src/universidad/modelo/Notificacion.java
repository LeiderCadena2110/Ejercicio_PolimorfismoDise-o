package universidad.modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import universidad.enums.TipoNotificacion;

/**
 * Clase abstracta base. Define los atributos y métodos comunes.
 * POLIMORFISMO DE INCLUSIÓN: las subclases heredan y sobreescriben enviar().
 */
public abstract class Notificacion {

    // ── Atributos del diagrama ────────────────────────────────
    protected String codigo;
    protected String destinatario;
    protected String mensaje;
    protected LocalDateTime fechaEnvio;
    protected String estado;
    protected TipoNotificacion tipoNotificacion;

    // Formato para mostrar la fecha
    private static final DateTimeFormatter FORMATO =
        DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    // ── Constructor ───────────────────────────────────────────
    public Notificacion(String codigo, String destinatario,
                         String mensaje, TipoNotificacion tipo) {
        this.codigo            = codigo;
        this.destinatario      = destinatario;
        this.mensaje           = mensaje;
        this.tipoNotificacion  = tipo;
        this.fechaEnvio        = LocalDateTime.now(); // se registra al crear
        this.estado            = "PENDIENTE";
    }

    // ── Método abstracto: cada subclase define CÓMO enviar ────
    public abstract void enviar();

    // ── Método concreto: compartido por todos ─────────────────
    public String getResume() {
        return "Código: " + codigo +
               " | Para: " + destinatario +
               " | Tipo: " + tipoNotificacion.getDescripcion() +
               " | Estado: " + estado +
               " | Fecha: " + fechaEnvio.format(FORMATO);
    }

    // ── Getters y Setters ─────────────────────────────────────
    public String getCodigo()      { return codigo; }
    public String getDestinatario() { return destinatario; }
    public String getMensaje()      { return mensaje; }
    public String getEstado()       { return estado; }
    public void   setEstado(String e){ this.estado = e; }
    public LocalDateTime getFechaEnvio() { return fechaEnvio; }
    public TipoNotificacion getTipoNotificacion() { return tipoNotificacion; }
}