package emailSetup;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.time.LocalDate;
import java.util.Properties;


import Config.configProperties;

public class SendEmailAfterExecution {


    public static void sendReportAfterExecution() throws MessagingException {


        if (configProperties.SendEmailAfterExecution.equals("True")) {
            //Recipient's Mail id
            String[] recepientTo = configProperties.To;


            //Sender's Mail id
            String senderFrom = configProperties.From;

            //Path of PDF test report
            String path = System.getProperty("user.dir") + "/reports/" + "ExtentReport.html";
            //Getting System properties
            Properties prop = System.getProperties();

            //Setting up smtp host
            prop.setProperty("mail.smtp.host", "smtp.gmail.com");

            //Creating a new session for smtp
            Session session = Session.getDefaultInstance(prop);

            MimeMessage msg = new MimeMessage(session);

            //Instance of From Internet address
            InternetAddress frmAddress = new InternetAddress(senderFrom);


            //Setting up sender's address
            msg.setFrom(frmAddress);


            //Setting up recipient's address

            for (int i = 0; i < recepientTo.length; i++) {

                msg.addRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(recepientTo[i])));
            }
//

            //Setting email's subject
            LocalDate dateTime = LocalDate.now();
            msg.setSubject(configProperties.ProjectDescription+ "===Test Execution Report=== " + dateTime);

            BodyPart msgBody = new MimeBodyPart();

            //Setting email's message body
            msgBody.setText("Test report after execution");

            //Instance of second part
            Multipart multiPart = new MimeMultipart();

            multiPart.addBodyPart(msgBody);

            //Another mail body
            msgBody = new MimeBodyPart();

            //Path to pdf file for attachment
            DataSource source = new FileDataSource(path);

            DataHandler dataHandler = new DataHandler(source);

            msgBody.setDataHandler(dataHandler);

            msgBody.setFileName(path);

            multiPart.addBodyPart(msgBody);

            msg.setContent(multiPart);

            //Authentication and connection establishment to the sender's mail
            Transport transport = session.getTransport("smtps");
            transport.connect("smtp.gmail.com", 465, configProperties.From, configProperties.FromPassword);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();

            System.out.println("Email send to respective Recipients");


        }
        else
        {
            System.out.println("Email Not sent as permissions are not given");
        }
    }


    }






