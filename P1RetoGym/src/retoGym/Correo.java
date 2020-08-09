/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retoGym;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author darwi
 */
public class Correo {
    public static void EnvioCorreo(String destinatario, String mensaje,String asunto){
        String from="yiamrodriguez@gmail.com";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        
        Session session = Session.getInstance(props,new javax.mail.Authenticator() {
            
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from,"xzozqwgttymzaagv");
            }
			});

		try {

			Message messages = new MimeMessage(session);
			messages.setFrom(new InternetAddress(from));
			messages.setRecipients(Message.RecipientType.TO,InternetAddress.parse(destinatario));
			messages.setSubject(asunto);
			messages.setText(mensaje);

			Transport.send(messages);
			System.out.println("Se envio un correo con los datos del usuario a su correo "+destinatario);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
