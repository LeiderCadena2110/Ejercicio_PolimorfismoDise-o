package universidad.fabrica;

import universidad.enums.TipoNotificacion;
import universidad.modelo.*;

/**
 * POLIMORFISMO DE SOBRECARGA:
 * Mismo nombre de método, distintos parámetros.
 * Java decide cuál ejecutar según los argumentos que se pasen.
 */
public class NotificacionFactory {

    // Contador para generar códigos únicos automáticamente
    private static int contador = 1;

    private static String generarCodigo(String prefijo) {
        return String.format("%s-%04d", prefijo, contador++);
    }

    // ════════════════════════════════════════════════════════
    // SOBRECARGA 1: crearEmail — 3 versiones
    // ════════════════════════════════════════════════════════

    /** Versión básica: 4 parámetros */
    public static NotificacionEmail crearEmail(
            String dest, String msg, TipoNotificacion tipo, String email) {
        return new NotificacionEmail(
            generarCodigo("EMAIL"), dest, msg, tipo,
            tipo.getDescripcion(), // asunto = tipo por defecto
            email);
    }

    /** Versión media: 5 parámetros — con asunto personalizado */
    public static NotificacionEmail crearEmail(
            String dest, String msg, TipoNotificacion tipo,
            String email, String asunto) {
        return new NotificacionEmail(
            generarCodigo("EMAIL"), dest, msg, tipo, asunto, email);
    }

    /** Versión completa: 6 parámetros — con asunto y adjuntos */
    public static NotificacionEmail crearEmail(
            String dest, String msg, TipoNotificacion tipo,
            String email, String asunto, boolean adjuntos) {
        NotificacionEmail n = new NotificacionEmail(
            generarCodigo("EMAIL"), dest, msg, tipo, asunto, email);
        n.setTieneArchivosAdjuntos(adjuntos);
        return n;
    }

    // ════════════════════════════════════════════════════════
    // SOBRECARGA 2: crearSMS — 2 versiones
    // ════════════════════════════════════════════════════════

    /** Versión básica: 4 parámetros */
    public static NotificacionSMS crearSMS(
            String dest, String msg, TipoNotificacion tipo, String telefono) {
        return new NotificacionSMS(
            generarCodigo("SMS"), dest, msg, tipo, telefono);
    }

    /** Versión con abreviación automática: 5 parámetros */
    public static NotificacionSMS crearSMS(
            String dest, String msg, TipoNotificacion tipo,
            String telefono, boolean abreviar) {
        String mensajeFinal = msg;
        if (abreviar && msg.length() > 157) {
            mensajeFinal = msg.substring(0, 157) + "...";
        }
        return new NotificacionSMS(
            generarCodigo("SMS"), dest, mensajeFinal, tipo, telefono);
    }

    // ════════════════════════════════════════════════════════
    // SOBRECARGA 3: crearMovil — 3 versiones
    // ════════════════════════════════════════════════════════

    /** Versión básica: 5 parámetros */
    public static NotificacionMovil crearMovil(
            String dest, String msg, TipoNotificacion tipo,
            String token, String plataforma) {
        return new NotificacionMovil(
            generarCodigo("APP"), dest, msg, tipo, token, plataforma);
    }

    /** Versión con sonido: 6 parámetros */
    public static NotificacionMovil crearMovil(
            String dest, String msg, TipoNotificacion tipo,
            String token, String plataforma, boolean sonido) {
        NotificacionMovil n = new NotificacionMovil(
            generarCodigo("APP"), dest, msg, tipo, token, plataforma);
        n.setSonidoActivado(sonido);
        return n;
    }

    /** Versión completa: 7 parámetros — sonido + icono */
    public static NotificacionMovil crearMovil(
            String dest, String msg, TipoNotificacion tipo,
            String token, String plataforma, boolean sonido, String icono) {
        NotificacionMovil n = new NotificacionMovil(
            generarCodigo("APP"), dest, msg, tipo, token, plataforma);
        n.setSonidoActivado(sonido);
        n.setIconoNotificacion(icono);
        return n;
    }
}