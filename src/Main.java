import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		ArrayList<Message> messages = new ArrayList<Message>();
		ArrayList<File> files = new ArrayList<File>();
		
		File file = new File("TaxFile","docs");
		files.add(file);
				
		Message messBoard = new BoardMessage("Yuval","Hi, my name is Yuval and I live in Nordiya",false);
		Message messEmail = new EmailMessage("Ofek", "Hi, I'm ofek. This is an important email regarding tax issues.", new Date() ,true, "Tax issues",files ,PriorityType.URGENT);
		
		messages.add(messBoard);
		messages.add(messEmail);
		
		menu();
	}
	
	
	public static void menu() {
		
		Scanner s = new Scanner(System.in);
		int choice = 0;
		
		while(choice != 7) {
			System.out.println("Menu:");
			System.out.println("1. Type (1) for adding a message.");
			System.out.println("2. Type (2) for deleting a message.");
			System.out.println("3. Type (3) for printing all messages.");
			System.out.println("4. Type (4) for seeing how many messages with words you have left.");
			System.out.println("5. Type (5) for printing all the digital messages.");
			System.out.println("6. Type (6) for seeing preview messages.");
			System.out.println("7. Type (7) to exit");

			System.out.print("Type here: ");
			choice = s.nextInt();
			
			switch (choice) {
			case 1: {
				
				addMessage(messages);
				
				break;
			}
			case 2: {
				
				break;
			}
			case 3: {
				
				break;
			}
			case 4: {
				
				break;
			}
			case 5: {
				
				break;
			}
			case 6: {
				
				break;
			}
			case 7: {
				
				System.out.println("Goodbye!");
				choice = 7;
				
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}
		
		
		s.close();
	}
	
	public void addMessage(ArrayList<Message> messages) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("What type of message do you want to add?");
		System.out.println("1. ?");
		System.out.println("What type of message do you want to add?");
		System.out.println("What type of message do you want to add?");
		

	}
	

}
