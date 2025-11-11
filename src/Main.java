import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner s = new Scanner(System.in);
		
		ArrayList<Message> messages = new ArrayList<Message>();
		
		Message messBoard = new BoardMessage("Yuval","Hi, my name is Yuval and I live in Nordiya",false);
		Message meesEmail = new EmailMessage("Ofek", "Hi, I'm ofek. This is an important email regarding tax issues.", true, "Tax issues", PriorityType.URGENT);
		
		
	}

}
