package com.synergix.utilities;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class MailBean
{
    public static void sendMail(String emailID, String emailPassword, String from, String to, String subject, String message)
    {
        try
        {

            /*** remember to turn this option on to bypass authentication exception ***/
            // https://www.google.com/settings/security/lesssecureapps

            //final String id       = ReadBean.getPropValue("config_mail.properties", "senderId");
            //final String password = ReadBean.getPropValue("config_mail.properties", "senderPwd");

            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.port", "587"); // 587 = NoSSL, 465 = SSL
            props.setProperty("mail.smtp.auth", "true");
            props.setProperty("mail.smtp.starttls.enable", "true");

            Session session = Session.getInstance(props, new Authenticator()
            {
                protected PasswordAuthentication getPasswordAuthentication()
                {
                    return new PasswordAuthentication(emailID, emailPassword);
                }
            });

            //Authenticator auth    = new SMTPAuthenticator(id, password);
            //Session       session = Session.getDefaultInstance(props);

            MimeMessage msg = new MimeMessage(session);
            msg.setText(message);
            msg.setSubject(subject);
            msg.setFrom(new InternetAddress(from));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            Transport.send(msg);
        } catch (Exception e)
        {
            e.getMessage();
        }
    }

    public static void sendMail(String host, String port, String emailID, String emailPassword, String from, InternetAddress[] to,
                                InternetAddress[] cc, String subject, String message, List<String> fileNames)
    {
        try
        {
            /*** remember to turn this option on to bypass authentication exception ***/
            // https://www.google.com/settings/security/lesssecureapps

            //final String id       = ReadBean.getPropValue("config_mail.properties", "senderId");
            //final String password = ReadBean.getPropValue("config_mail.properties", "senderPwd");

            Properties props = new Properties();
            props.setProperty("mail.smtp.host", host);
            props.setProperty("mail.smtp.port", port); // 587 = NoSSL, 465 = SSL
            props.setProperty("mail.smtp.auth", "true");
            props.setProperty("mail.smtp.starttls.enable", "true");

            Session session = Session.getInstance(props, new Authenticator()
            {
                protected PasswordAuthentication getPasswordAuthentication()
                {
                    return new PasswordAuthentication(emailID, emailPassword);
                }
            });

            //Authenticator auth    = new SMTPAuthenticator(id, password);
            //Session       session = Session.getDefaultInstance(props);

            //set message
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(message);
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            // attach file
            try
            {
                for (String fileName : fileNames)
                    if (new File(fileName).isFile())
                    {
                        Path p = Paths.get(fileName);
                        String fileNameOnly = p.getFileName().toString();

                        DataSource source = new FileDataSource(fileName);
                        messageBodyPart = new MimeBodyPart();
                        messageBodyPart.setDataHandler(new DataHandler(source));
                        messageBodyPart.setFileName(fileNameOnly);
                        multipart.addBodyPart(messageBodyPart);
                    }
            } catch (Exception e)
            {

            }

            // send the mail
            MimeMessage msg = new MimeMessage(session);
            msg.setSubject(subject);
            msg.setContent(multipart);

            msg.setFrom(new InternetAddress(from));
            msg.addRecipients(Message.RecipientType.TO, to);
            msg.addRecipients(Message.RecipientType.CC, cc);
            Transport.send(msg);
        } catch (Exception e)
        {
            e.getMessage();
        }
    }

    public static void sendEmailToPY(String subject, String message, List<String> fileNames)
    {
        try
        {
            InternetAddress[] to = new InternetAddress[]{new InternetAddress("synergix_payroll@synergixtech.com")};
            InternetAddress[] cc = new InternetAddress[]{new InternetAddress("synergix_autoqa@synergixtech.com"), new InternetAddress(
                    "esther@synergixtech.com"), new InternetAddress("rachel.vu@synergixtech.com")};
            MailBean.sendMail("mail.synergixtech.com", "25", "levin.le@synergixtech.com", "Grandia24", "levin.le@synergixtech.com", to, cc, subject,
                              message, fileNames);
        } catch (Exception e)
        {
        }
    }

    public static void sendEmailToFIN(String subject, String message, List<String> fileNames)
    {
        try
        {
            InternetAddress[] to = new InternetAddress[]{new InternetAddress("synergix_finance@synergixtech.com")};
            InternetAddress[] cc = new InternetAddress[]{new InternetAddress("synergix_autoqa@synergixtech.com"), new InternetAddress(
                    "rachel.vu@synergixtech.com")};
            MailBean.sendMail("mail.synergixtech.com", "25", "levin.le@synergixtech.com", "Grandia24", "levin.le@synergixtech.com", to, cc, subject,
                              message, fileNames);
        } catch (Exception e)
        {
        }
    }

    public static void sendEmailToPY(String subject, String message, String fileName)
    {
        List<String> fileNames = Arrays.asList(fileName);
        sendEmailToPY(subject, message, fileNames);
    }
}

