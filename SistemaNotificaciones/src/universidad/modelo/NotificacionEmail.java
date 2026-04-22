package universidad.modelo;

import universidad.enums.TipoNotificacion;

public class NotificacionEmail extends Notificacion {

    // ── Atributos propios del email ───────────────────────────
    private String  asunto;
    private final String  emailDestinatario;
    private boolean tieneArchivoAdjunto;

    // ── Constructor ───────────────────────────────────────────
    public NotificacionEmail(String codigo, String destinatario,
                              String mensaje, TipoNotificacion tipo,
                              String asunto, String emailDestinatario) {
        super(codigo, destinatario, mensaje, tipo); // llama al padre
        this.asunto              = asunto;
        this.emailDestinatario   = emailDestinatario;
        this.tieneArchivoAdjunto = false;
    }

    // ── Implementación obligatoria de enviar() ────────────────
    @Override
    public void enviar() {
        this.estado = "ENVIADO";
        System.out.println("\n📧 [CORREO ELECTRÓNICO]");
        System.out.println("   Para    : " + emailDestinatario);
        System.out.println("   Asunto  : " + asunto);
        System.out.println("   Mensaje : " + mensaje);
        System.out.println("   Adjunto : " + (tieneArchivoAdjunto ? "Sí" : "No"));
        System.out.println("   ✅ Email enviado a " + emailDestinatario);
    }

    // ── Getters y Setters propios ─────────────────────────────
    public String  getAsunto()                 { return asunto; }
    public String  getEmailDestinatario()       { return emailDestinatario; }
    public boolean isTieneArchivoAdjunto()      { return tieneArchivoAdjunto; }
    public void    setTieneArchivosAdjuntos(boolean v) { this.tieneArchivoAdjunto = v; }
    public void    setAsunto(String asunto)       { this.asunto = asunto; }
}