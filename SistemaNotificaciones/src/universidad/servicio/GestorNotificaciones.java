package universidad.servicio;

import java.util.ArrayList;
import java.util.List;
import universidad.modelo.Notificacion;

/**
 * POLIMORFISMO PARAMÉTRICO:
 * T puede ser NotificacionEmail, NotificacionSMS o NotificacionMovil.
 * El código funciona igual para cualquiera de los tres tipos.
 */
public class GestorNotificaciones<T extends Notificacion> {

    // ── Atributos ─────────────────────────────────────────────
    private final List<T> historial;
    private final String  nombreGestor;

    // ── Constructor ───────────────────────────────────────────
    public GestorNotificaciones(String nombreGestor) {
        this.nombreGestor = nombreGestor;
        this.historial    = new ArrayList<>();
    }

    // ── Registrar y enviar al instante ────────────────────────
    public void registrarYEnviar(T notificacion) {
        historial.add(notificacion);
        notificacion.enviar();
    }

    // ── Solo registrar (dejar pendiente) ─────────────────────
    public void registrar(T notificacion) {
        historial.add(notificacion);
        System.out.println("📋 Registrado [" + notificacion.getCodigo() + "] - PENDIENTE");
    }

    // ── Enviar todas las pendientes ───────────────────────────
    public void enviarPendientes() {
        System.out.println("\n⏳ Enviando pendientes del gestor: " + nombreGestor);
        for (T n : historial) {
            if (n.getEstado().equals("PENDIENTE")) {
                n.enviar();
            }
        }
    }

    // ── Obtener por estado ────────────────────────────────────
    public List<T> obtenerPorEstados(String estado) {
        List<T> resultado = new ArrayList<>();
        for (T n : historial) {
            if (n.getEstado().equalsIgnoreCase(estado)) {
                resultado.add(n);
            }
        }
        return resultado;
    }

    // ── Mostrar historial completo ────────────────────────────
    public void mostrarHistorial() {
        System.out.println("\n══ HISTORIAL [" + nombreGestor + "] ══");
        if (historial.isEmpty()) {
            System.out.println("  (vacío)");
            return;
        }
        for (T n : historial) {
            System.out.println("  → " + n.getResume());
        }
        System.out.println("  Total: " + historial.size()
            + " | Enviadas: " + obtenerPorEstados("ENVIADO").size()
            + " | Pendientes: " + obtenerPorEstados("PENDIENTE").size()
            + " | Errores: " + obtenerPorEstados("ERROR").size());
    }

    // ── Getters ───────────────────────────────────────────────
    public List<T> getHistorial()    { return historial; }
    public String  getNombreGestor() { return nombreGestor; }
}