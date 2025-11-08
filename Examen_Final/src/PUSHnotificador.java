package src;

import interfaces.notificadorPUSH;

public class PUSHnotificador implements notificadorPUSH {
    @Override
    public void enviarPush(String dispositivoId, String mensaje) {
        System.out.println("🔔 Enviando push a dispositivo: " + dispositivoId);
        System.out.println("   Mensaje: " + mensaje);
    }
}