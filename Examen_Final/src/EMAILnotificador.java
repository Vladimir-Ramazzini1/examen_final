package src;

import interfaces.notificadorEMIL;

public class EMAILnotificador implements notificadorEMIL {
    @Override
    public void enviarEmail(String destinatario, String mensaje) {
        System.out.println("📧 Enviando email a: " + destinatario);
        System.out.println("   Mensaje: " + mensaje);
    }
}