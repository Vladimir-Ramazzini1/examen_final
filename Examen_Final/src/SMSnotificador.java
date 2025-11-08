package src;

import interfaces.notificadorSMS;

public class SMSnotificador implements notificadorSMS {
    @Override
    public void enviarSMS(String numero, String mensaje) {
        System.out.println("📱 Enviando SMS a: " + numero);
        System.out.println("   Mensaje: " + mensaje);
    }
}