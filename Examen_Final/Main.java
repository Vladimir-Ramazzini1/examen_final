import src.EMAILnotificador;
import src.SMSnotificador;
import src.PUSHnotificador;
import src.servicioUSUARIO;
import interfaces.notificadorEMIL;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== DEMOSTRACIÓN ISP Y DIP ===\n");

        // Crear los notificadores concretos
        EMAILnotificador email = new EMAILnotificador();
        SMSnotificador sms = new SMSnotificador();
        PUSHnotificador push = new PUSHnotificador();

        // 1. Servicio que solo usa EMAIL (ISP)
        System.out.println("1. Servicio solo con EMAIL:");
        servicioUSUARIO servicioEmail = new servicioUSUARIO(email);
        servicioEmail.notificarPorEmail("cliente@empresa.com", "Bienvenido!");
        servicioEmail.notificarPorSMS("123456", "Esto no funciona"); // No configurado

        // 2. Servicio que solo usa SMS (ISP)
        System.out.println("\n2. Servicio solo con SMS:");
        servicioUSUARIO servicioSMS = new servicioUSUARIO(sms);
        servicioSMS.notificarPorSMS("+123456789", "Tu código: 9999");

        // 3. Servicio con TODOS los notificadores (DIP)
        System.out.println("\n3. Servicio con TODOS los notificadores:");
        servicioUSUARIO servicioCompleto = new servicioUSUARIO(email, sms, push);
        servicioCompleto.notificarPorEmail("admin@empresa.com", "Reporte diario");
        servicioCompleto.notificarPorSMS("+555555555", "Alerta de seguridad");
        servicioCompleto.notificarPorPush("phone-123", "Actualización disponible");

        // 4. Demostrando que podemos cambiar implementaciones fácilmente (DIP)
        System.out.println("\n4. Cambiando implementación de Email:");
        notificadorEMIL emailEspecial = new notificadorEMIL() {
            @Override
            public void enviarEmail(String destinatario, String mensaje) {
                System.out.println(" EMAIL ESPECIAL para: " + destinatario);
                System.out.println("    " + mensaje);
            }
        };

        servicioUSUARIO servicioEspecial = new servicioUSUARIO(emailEspecial);
        servicioEspecial.notificarPorEmail("vip@cliente.com", "Oferta exclusiva!");

        System.out.println("\n¡Demostración completada!");
    }
}