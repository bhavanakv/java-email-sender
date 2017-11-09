    import java.util.Properties;    
    import javax.mail.*;    
    import javax.mail.internet.*; 
    import java.net.ServerSocket;
    import java.net.Socket;
    import java.util.*;   
    class Mailer{  
        public static void send(String from,String password,String to,String sub,String msg){  
              //Get properties object    
              Properties props = new Properties();    
              props.put("mail.smtp.host", "smtp.gmail.com");    
              props.put("mail.smtp.socketFactory.port", "465");    
              props.put("mail.smtp.socketFactory.class",    
                        "javax.net.ssl.SSLSocketFactory");    
              props.put("mail.smtp.auth", "true");    
              props.put("mail.smtp.port", "465");    
              //get Session   
              Session session = Session.getDefaultInstance(props,    
               new javax.mail.Authenticator() {    
               protected PasswordAuthentication getPasswordAuthentication() {    
               return new PasswordAuthentication(from,password);  
               }    
              });    
              //compose message    
              try {    
               MimeMessage message = new MimeMessage(session);    
               message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
               message.setSubject(sub);    
               message.setText(msg);    
               //send message  
               Transport.send(message);    
               System.out.println("message sent successfully");    
              } catch (MessagingException e) {throw new RuntimeException(e);}    
                 
        }  
    }  
    public class Mailer1{    
     public static void main(String[] args) throws Exception {    
         //from,password,to,subject,message
         // its okay
         ServerSocket sSocket = new ServerSocket(8000);
         Socket socket = sSocket.accept();
         System.out.println("Got a client");
       
      	 Scanner scanner = new Scanner(socket.getInputStream());
      	 String username = scanner.nextLine();
      	 String pwd = scanner.nextLine();
      	 String recipient = scanner.nextLine();
      	 String subject = scanner.nextLine();
      	 String message = scanner.nextLine(); 
         
         Mailer.send(username,pwd,recipient,subject,message);
         System.out.println("Done!");
         //change from, password and to  
     }    
    }    
