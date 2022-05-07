package utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Mail {

        public static void send(String to,String sub,String msg){
            String from="test.omerkircal@gmail.com";
            String pwd="Yadigar279";
            //Properties
            Properties p = new Properties();
            p.put("mail.smtp.host", "smtp.gmail.com");
            p.put("mail.smtp.socketFactory.port", "465");
            p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            p.put("mail.smtp.auth", "true");
            p.put("mail.smtp.port", "465");
            //Session
            Session s = Session.getDefaultInstance(p,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(from, pwd);
                        }
                    });
            //compose message
            try {
                MimeMessage m = new MimeMessage(s);
                m.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
                m.setSubject(sub);
                m.setText(msg);
                //send the message
                Transport.send(m);
                System.out.println("Message sent successfully");
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
    }

