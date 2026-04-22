import universidad.enums.TipoNotificacion;
import universidad.fabrica.NotificacionFactory;
import universidad.modelo.*;
import universidad.servicio.GestorNotificaciones;

public class Main {

public static void main(String[] args) {

        titulo("1. POLIMORFISMO DE INCLUSIÓN");
        // Variable tipo padre, objetos de distinto tipo hijo
        Notificacion[] lista = {
        NotificacionFactory.crearEmail(
                "Laura Gómez",
                "Sus calificaciones del semestre ya están disponibles.",
                TipoNotificacion.PUBLICACION_CALIFICACIONES,
                "laura@universidad.edu",
                "Calificaciones publicadas",
                true
        ),
        NotificacionFactory.crearSMS(
                "Carlos Ramírez",
                "Recuerde pagar matrícula antes del 30 de abril.",
                TipoNotificacion.RECORDATORIO_PAGO,
                "+573001234567"
        ),
        NotificacionFactory.crearMovil(
                "Ana Torres",
                "La clase de Cálculo III del miércoles fue cancelada.",
                TipoNotificacion.CANCELACION_CLASE,
                "token_abc123xyz456",
                "android",
                true,
                "⚠️"
        )
        };

        // El mismo método enviar() pero cada objeto hace algo diferente
        for (Notificacion n : lista) {
        n.enviar();
        }


        titulo("2. POLIMORFISMO PARAMÉTRICO");

        // Gestor especializado solo para emails
        GestorNotificaciones<NotificacionEmail> gestorEmail =
        new GestorNotificaciones<>("Gestor-Email");

        gestorEmail.registrarYEnviar(NotificacionFactory.crearEmail(
        "Pedro Silva",
        "Quedó inscrito al Seminario de Inteligencia Artificial.",
        TipoNotificacion.CONFIRMACION_INSCRIPCION,
        "pedro@universidad.edu"
        ));
        gestorEmail.registrar(NotificacionFactory.crearEmail(
        "María López",
        "Confirmación de inscripción al taller de Robótica.",
        TipoNotificacion.CONFIRMACION_INSCRIPCION,
        "maria@universidad.edu",
        "Inscripción confirmada"
        ));
        gestorEmail.enviarPendientes();
        gestorEmail.mostrarHistorial();

        // Gestor separado para SMS
        GestorNotificaciones<NotificacionSMS> gestorSMS =
        new GestorNotificaciones<>("Gestor-SMS");
        gestorSMS.registrarYEnviar(NotificacionFactory.crearSMS(
        "Juan Pérez",
        "La clase de Física fue cancelada hoy.",
        TipoNotificacion.CANCELACION_CLASE,
        "+573109876543",
        true
        ));
        gestorSMS.mostrarHistorial();


        titulo("3. POLIMORFISMO DE SOBRECARGA");

        // 4 parámetros
        NotificacionEmail e1 = NotificacionFactory.crearEmail(
        "Est. A", "Sus notas fueron publicadas.",
        TipoNotificacion.PUBLICACION_CALIFICACIONES, "a@uni.edu");

        // 5 parámetros
        NotificacionEmail e2 = NotificacionFactory.crearEmail(
        "Est. B", "Recuerde pagar antes del viernes.",
        TipoNotificacion.RECORDATORIO_PAGO, "b@uni.edu", "Último aviso");

        // 6 parámetros
        NotificacionEmail e3 = NotificacionFactory.crearEmail(
        "Est. C", "Inscripción con documentos adjuntos.",
        TipoNotificacion.CONFIRMACION_INSCRIPCION, "c@uni.edu", "Docs", true);

        System.out.println("\n  Sobrecarga con 4 parámetros:"); e1.enviar();
        System.out.println("\n  Sobrecarga con 5 parámetros:"); e2.enviar();
        System.out.println("\n  Sobrecarga con 6 parámetros:"); e3.enviar();
}

private static void titulo(String t) {
        System.out.println("\n\n╔══════════════════════════════════════════╗");
        System.out.printf ("║  %-40s║%n", t);
        System.out.println("╚══════════════════════════════════════════╝");
}
}