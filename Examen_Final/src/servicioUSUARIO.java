package src;

import interfaces.notificadorEMIL;
import interfaces.notificadorSMS;
import interfaces.notificadorPUSH;

public class servicioUSUARIO {
    private notificadorEMIL notificadorEmail;
    private notificadorSMS notificadorSMS;
    private notificadorPUSH notificadorPush;
    
    // Constructor para inyectar dependencias
    public servicioUSUARIO(notificadorEMIL email, notificadorSMS sms, notificadorPUSH push) {
        this.notificadorEmail = email;
        this.notificadorSMS = sms;
        this.notificadorPush = push;
    }
    
    // Constructor solo para email
    public servicioUSUARIO(notificadorEMIL email) {
        this(email, null, null);
    }
    
    // Constructor solo para SMS
    public servicioUSUARIO(notificadorSMS sms) {
        this(null, sms, null);
    }
    
    // Constructor solo para push
    public servicioUSUARIO(notificadorPUSH push) {
        this(null, null, push);
    }
    
    // Métodos para enviar notificaciones
    public void notificarPorEmail(String usuario, String mensaje) {
        if (notificadorEmail != null) {
            notificadorEmail.enviarEmail(usuario, mensaje);
        } else {
            System.out.println("❌ Email no configurado");
        }
    }
    
    public void notificarPorSMS(String numero, String mensaje) {
        if (notificadorSMS != null) {
            notificadorSMS.enviarSMS(numero, mensaje);
        } else {
            System.out.println("❌ SMS no configurado");
        }
    }
    
    public void notificarPorPush(String dispositivo, String mensaje) {
        if (notificadorPush != null) {
            notificadorPush.enviarPush(dispositivo, mensaje);
        } else {
            System.out.println("❌ Push no configurado");
        }
    }
}