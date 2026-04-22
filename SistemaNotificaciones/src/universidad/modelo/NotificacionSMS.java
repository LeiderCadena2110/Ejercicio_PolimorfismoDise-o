package universidad.modelo;

import universidad.enums.TipoNotificacion;

public class NotificacionSMS extends Notificacion {

    // ── Atributos propios del SMS ─────────────────────────────
    private final String numeroTelefono;
    private final int    caracteresUsados;
    private static final int MAX_CARACTERES = 160;

    // ── Constructor ───────────────────────────────────────────
    public NotificacionSMS(String codigo, String destinatario,
                            String mensaje, TipoNotificacion tipo,
                            String numeroTelefono) {
        super(codigo, destinatario, mensaje, tipo);
        this.numeroTelefono  = numeroTelefono;
        this.caracteresUsados = mensaje.length(); // cuenta automáticamente
    }

    // ── Implementación de enviar() con validación ─────────────
    @Override
    public void enviar() {
        // Validar que no supere el límite
        if (caracteresUsados > MAX_CARACTERES) {
            this.estado = "ERROR";
            System.out.println("\n❌ [SMS] Error: El mensaje supera "
                + MAX_CARACTERES + " caracteres.");
            return;
        }
        this.estado = "ENVIADO";
        System.out.println("\n📱 [MENSAJE DE TEXTO]");
        System.out.println("   Número  : " + numeroTelefono);
        System.out.println("   Mensaje : " + mensaje);
        System.out.printf ("   Chars   : %d / %d%n", caracteresUsados, MAX_CARACTERES);
        System.out.println("   ✅ SMS enviado al " + numeroTelefono);
    }

    // ── Getters ───────────────────────────────────────────────
    public String getNumeroTelefono()   { return numeroTelefono; }
    public int    getCaracteresUsados() { return caracteresUsados; }
}