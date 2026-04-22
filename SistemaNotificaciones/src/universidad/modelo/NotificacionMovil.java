package universidad.modelo;

import universidad.enums.TipoNotificacion;

public class NotificacionMovil extends Notificacion {

    // ── Atributos propios de la app móvil ────────────────────
    private final String  tokenDispositivo;
    private final String  plataforma;         // "ANDROID" o "IOS"
    private String  iconoNotificacion;
    private boolean sonidoActivado;

    // ── Constructor ───────────────────────────────────────────
    public NotificacionMovil(String codigo, String destinatario,
                              String mensaje, TipoNotificacion tipo,
                              String tokenDispositivo, String plataforma) {
        super(codigo, destinatario, mensaje, tipo);
        this.tokenDispositivo  = tokenDispositivo;
        this.plataforma        = plataforma.toUpperCase();
        this.iconoNotificacion = "🔔";
        this.sonidoActivado    = true;
    }

    // ── Implementación de enviar() ────────────────────────────
    @Override
    public void enviar() {
        this.estado = "ENVIADO";
        System.out.println("\n🔔 [NOTIFICACIÓN APP MÓVIL]");
        System.out.println("   Plataforma : " + plataforma);
        System.out.println("   Token      : " + tokenDispositivo.substring(0, 8) + "...");
        System.out.println("   Icono      : " + iconoNotificacion);
        System.out.println("   Mensaje    : " + mensaje);
        System.out.println("   Sonido     : " + (sonidoActivado ? "Activado" : "Silencio"));
        System.out.println("   ✅ Push enviado [" + plataforma + "]");
    }

    // ── Getters y Setters ─────────────────────────────────────
    public String  getTokenDispositivo()         { return tokenDispositivo; }
    public String  getPlataforma()               { return plataforma; }
    public boolean isSonidoActivado()            { return sonidoActivado; }
    public void    setSonidoActivado(boolean v)  { this.sonidoActivado = v; }
    public void    setIconoNotificacion(String i){ this.iconoNotificacion = i; }
}