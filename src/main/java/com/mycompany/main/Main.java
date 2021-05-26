/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.main;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
/**
 * 
 * @author juanjo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         // a quien se le envia.
        String to = "cortinezjuan@gmail.com";

        // quien es el remitente
        String from = "cortinezjuan@gmail.com";

        // se envia a través del protocolo smt de gmail
        String host = "smtp.gmail.com";

        // propiedades del sistema
        Properties properties = System.getProperties();

        // setup del server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // obtener la sesion.// y pasar usuario y clave
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("cortinezjuan@gmail.com", "30550198jjc");

            }

        });

        // utilizado para debuggear
        session.setDebug(true);

        try {
            // Crear el objeto MimeMessage.
            MimeMessage mensaje = new MimeMessage(session);

            // quien envia.
            mensaje.setFrom(new InternetAddress(from));

            // quien recibe.
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // configurar el subjectd
            mensaje.setSubject("mail desde java!");

            // el mensaje
            mensaje.setText("Esta es una prueba de envíos de email desde Java!!!");

            System.out.println("enviando...");
            // enviar el mensaje
            Transport.send(mensaje);
            System.out.println("El mensaje se envió exitosamente....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
        
    }
}
    