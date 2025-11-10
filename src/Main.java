import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner s = new Scanner(System.in);
		
		try {
			File f = new File("FN","FT"); //File object
			
			ArrayList<File> files = new ArrayList<File>(); //Array of files
			
			files.add(f); //Adding the files into the array
			
			for(File file : files) { //Printing the files' data
				
				System.out.println(f.toString());
				
				
			}
			
			
			Message m = new BoardMessage("Yuval","Hello my name is Yuval Yanay and I live in Nordiya.",true);
			
			ArrayList<Message> messages = new ArrayList<Message>();
			
			messages.add(m);
			
			for(Message message : messages) {
				
				if (message instanceof BoardMessage) {
					BoardMessage messageBoard = (BoardMessage) message;
					System.out.println(message.toString());

				}
				
				
			}
			
		}
		catch(IllegalArgumentException e) {
			System.out.println("Exception: " + e.getLocalizedMessage()); 
		}
		
		
	}

}
