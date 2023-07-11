package Message;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface  MessagingService{
	void sendMessage();
}
class smsMessagingService implements MessagingService{
	public  void sendMessage() {
		Scanner Sc=new Scanner(System.in);
		System.out.println("Enter the number customer");
		long num=Sc.nextLong();
		System.out.println("Enter Message");
		String sms=Sc.next();
		if(sms.matches("[6-9]\\d{9}")){
			System.out.println(num);
			System.out.println(sms);
		}
		else {
			System.out.println("Invalid number");
		}
	}
}
class emailMessagingService implements MessagingService{
	public void sendMessage() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the email");
		String emailID=sc.next();
		System.out.println("Enter the subject");
		String subject=sc.next();
		System.out.println("Enter the mailContent");
		String message=sc.next();
		String regex="^[A-za-z0-9+_.-]+@(.+)$";
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher=pattern.matcher(emailID);
		if(matcher.matches()) {
			System.out.println(emailID);
			System.out.println(subject);
			System.out.println(message);
			
		}
		else {
			System.out.println("Invalid email adress");
		}
	}
}
class WhatsAppMessagingService implements MessagingService{
	public void sendMessage() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter user number");
		long num=sc.nextLong();
		System.out.println("Enter the if user exisit");
		int whatsapp=sc.nextInt();
		System.out.println("Enter Message content:");
		String message=sc.next();
		String number_str=String.valueOf(num);
		if(number_str.matches("[6-9]\\d{9}")&& whatsapp==1) {
			System.out.println(num);
			System.out.println(whatsapp);
		}
		else if(whatsapp==0) {
			System.out.println("user does not exist in whatasapp");
		}
		else {
			System.out.println("Invalid number");
		}
	}
}
public class Messengerapp {

	public static void main(String[] args) {
		MessagingService smsMessagingService = new smsMessagingService();
		MessagingService emailMessagingService = new emailMessagingService();
		MessagingService WhatsAppMessagingService = new WhatsAppMessagingService();
		Scanner sc=new Scanner(System.in);
		int count=5;
		do {
			System.out.println("Choose option"+"\n"+"1. SMS Messaging"+"\n"+"2. Email Messaging"+"\n"+""
					+ "3. Whatsapp Messaging"+"\n"+"4. exit");
			int n=sc.nextInt();
			if(n==1) {
				smsMessagingService.sendMessage();
			}
			else if(n==2) {
				emailMessagingService.sendMessage();
			}
			else if(n==3) {
				WhatsAppMessagingService.sendMessage();
			}
			else if(n==4) {
				count=0;
				break;
				
			}
			else {
				System.out.println("Invalid option");
			}
		}while(count>0);
		
	}

}
