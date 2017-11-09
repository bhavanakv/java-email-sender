import java.io.*;
import java.net.*;
import java.util.*;
public class Client
{
	public static void main(String[] args) throws Exception
  	{
  		Socket socket = new Socket("localhost", 8000);
  		Scanner scanner = new Scanner(System.in);
  		String email = scanner.nextLine();
  		
  		PrintWriter pw = new PrintWriter(socket.getOutputStream());
  		pw.println(email);
		
		Console cnsl = System.console();      	
		char pwd[] = cnsl.readPassword("Enter the password:");
		String password = new String(pwd);
		pw.println(password);

		System.out.println("Enter the recipient address:");
		String recipient = scanner.nextLine();
		pw.println(recipient);

     	System.out.println("Enter the subject:");
     	String subject = scanner.nextLine();
     	pw.println(subject);
     	
     	System.out.println("Enter the message:");
     	String message = scanner.nextLine();
     	pw.println(message);

		pw.flush();
	}
}
     
                        
                     
