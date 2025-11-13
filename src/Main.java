import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Date;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		ArrayList<Message> messages = new ArrayList<Message>();
		ArrayList<File> files = new ArrayList<File>();
		
		File file = new File("TaxFile","docs");
		files.add(file);
				
		Message messBoard = new BoardMessage("Yuval","Hi, my name is Yuval and I live in Nordiya", new Date(),false,PriorityType.REGULAR);
		Message messEmail = new EmailMessage("Ofek", "Hi, I'm ofek. This is an important email regarding tax issues.", new Date() ,true, "Tax issues",files ,PriorityType.URGENT);
		
		messages.add(messBoard);
		messages.add(messEmail);
		
		menu(messages);
	}
	
	
	public static void menu(ArrayList<Message> messages) {
		
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
				
				addMessage(messages,s);
				
				
				break;
			}
			case 2: {
				
				deleteMessage(messages,s);
				
				break;
			}
			case 3: {
				
				printAllMessages(messages);
				
				break;
			}
			case 4: {
				
				s.nextLine();
		        System.out.println("You have " + messagesWithWords(messages,s) + " messages that includes these keywords.");

				
				break;
			}
			case 5: {
				
				printAllDigitalMessages(messages);
				
				break;
			}
			case 6: {
				
				showPreviewMessages(messages);
				
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
	
	
	
	public static void showPreviewMessages(ArrayList<Message> messages) {
		
    for(Message m : messages) {
			
			if(m instanceof BoardMessage) {
		        System.out.println(m.generatePreview());
			}
			else if(m instanceof EmailMessage) {
		        System.out.println(m.generatePreview());
			}
			else if(m instanceof FacebookMessage){
		        System.out.println(m.generatePreview());
			}
		}
		
	}
	
	public static void printAllDigitalMessages(ArrayList<Message> messages) {
		
		
		for(Message m : messages) {
			
			if(m instanceof IDigital) {
				
				if(m instanceof EmailMessage) {
			        System.out.println(m.toString());
			        ((IDigital) m).printCommunicationMethod();
				}
				else if(m instanceof FacebookMessage){
			        System.out.println(m.toString());
			        ((IDigital) m).printCommunicationMethod();

				}

			}
			
		}
		
	}
	
	
	public static int messagesWithWords(ArrayList<Message> messages, Scanner s) {
		
		int count = 0;
		System.out.println("Type the words: ");
		String text = s.nextLine();
		String[] wordsArray = text.toLowerCase().trim().split("\\s+");
		ArrayList<String> listOfWords = new ArrayList<>(Arrays.asList(wordsArray));

		
		
       for(Message m : messages) {
			
    	   if(m.find(listOfWords)) {
    		   
    		   count++;
    		   
    	   }
    	   
       }
       
       return count;
       
	}
	
	
	public static void printAllMessages(ArrayList<Message> messages) {
		
		for(Message m : messages) {
			
			if(m instanceof BoardMessage) {
		        System.out.println(m.toString());
			}
			else if(m instanceof EmailMessage) {
		        System.out.println(m.toString());
			}
			else if(m instanceof FacebookMessage){
		        System.out.println(m.toString());
			}
		}
		
	}
	
	public static void deleteMessage(ArrayList<Message> messages, Scanner s) {

	    int choice = 0;
	    while (true) {
	        
	    	System.out.println("What type of message do you want to delete?");
		    System.out.println("1. Board message");
		    System.out.println("2. Email message");
		    System.out.println("3. Facebook message");
	    	
	        choice = s.nextInt();
	        s.nextLine();
	        if (choice >= 1 && choice <= 3) break;
	        System.out.println("Invalid choice. Type 1, 2, or 3.");
	    }
	    
	    
	    if(choice == 1) {
	    	
	    	delBoardMessage(messages,s);
	    	
	    }
	    else if(choice == 2) {
	    	
	    	delEmailMessage(messages,s);
	    	
	    }
	    else {
	    	
	       delFacebookMessage(messages,s);
	       
	    }
		
	}
	
	public static void delBoardMessage(ArrayList<Message> messages, Scanner s) {
		
		
		for(Message b : messages) {
			
			if(b instanceof BoardMessage) {
		        System.out.println(b.toString());
			}
		}
        System.out.println("Type which serial number to remove:");
		int serialNum = s.nextInt();
		
		int current = 0;
		
		for(Message b : messages) {
			
			if(b instanceof BoardMessage) {
				
				if(current == serialNum - 1) {
					
					messages.remove(b);
					
				}
				
				current++;
				
			}
		}
		
		
		
		
		
	}
	
	public static void delEmailMessage(ArrayList<Message> messages, Scanner s) {
		
     for(Message e : messages) {
			
			if(e instanceof EmailMessage) {
		        System.out.println(e.toString());
			}
		}
        System.out.println("Type which serial number to remove:");
		int serialNum = s.nextInt();
		
		int current = 0;
		
		for(Message e : messages) {
			
			if(e instanceof EmailMessage) {
				
				if(current == serialNum - 1) {
					
					messages.remove(e);
					
				}
				
				current++;
				
			}
		}
		
	}
	
	
	public static void delFacebookMessage(ArrayList<Message> messages, Scanner s) {
		
   for(Message f : messages) {
			
			if(f instanceof FacebookMessage) {
		        System.out.println(f.toString());
			}
		}
        System.out.println("Type which serial number to remove:");
		int serialNum = s.nextInt();
		
		int current = 0;
		
		for(Message f : messages) {
			
			if(f instanceof FacebookMessage) {
				
				if(current == serialNum - 1) {
					
					messages.remove(f);
					
				}
				
				current++;
				
			}
		}
		
	}
	
	
	public static void addMessage(ArrayList<Message> messages, Scanner s) {
		
		int choice = 0;

		System.out.println("What type of message do you want to add?");
		
		while(1 > 0) {
			System.out.println("1. Board message (Type 1)?");
			System.out.println("2. Email message (Type 2)?");
			System.out.println("3. Facebook message (Type 3)?");
			
			choice = s.nextInt();
			s.nextLine();
			
			switch (choice) {
			case 1: {
				
				addBoardMessage(messages, s);
				
				break;
			}
			case 2: {
				
				addEmailMessage(messages, s);
				
				break;
			}
			case 3: {
				
				addFacebookMessage(messages, s);
				
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
			
			break;
			
		}
		
		
		
		

	}
	

	public static void addBoardMessage(ArrayList<Message> messages, Scanner s) {
				
		
		while(1> 0) {
			
			System.out.println("Type the sender's name:");
			String sender = s.nextLine();
			
			System.out.println("Type the content of the message:");
			String content = s.nextLine();
			
			System.out.println("Is it a favorite contact? 'true' for yes and 'false' for no:");
			boolean favoriteContact = s.nextBoolean();
			s.nextLine();
			
			PriorityType messageType;

			
			System.out.println("Prioritize your message: ");
			System.out.println("1. Urgent (Type 1).");
			System.out.println("2. Important (Type 2).");
			System.out.println("3. Regular (Type 3).");
			
			while (!s.hasNextInt()) { s.nextLine(); System.out.print("Type 1/2/3: "); }
		    int choiceForPriorityType = s.nextInt();
		    s.nextLine();
			
			if(choiceForPriorityType == 1) {
				messageType = PriorityType.URGENT;
				
			} 
			else if(choiceForPriorityType == 2) {
				messageType = PriorityType.IMPORTANT;


			}
			else  {
				messageType = PriorityType.REGULAR;
			}
							
			
			try {
				
				Message boardMess = new BoardMessage(sender, content, new Date() ,favoriteContact, messageType);
				
				messages.add(boardMess);
				
				break;
			}
			catch (IllegalArgumentException e) {
				
				System.out.println("Exception: " + e.getLocalizedMessage());

				
			}
			
						
		}
		
		
		
	}
	
	
	
	
	
	
	public static void addEmailMessage(ArrayList<Message> messages, Scanner s) {
		
		
   while(1> 0) {
			
			System.out.println("Type the sender's name:");
			String sender = s.nextLine();
			
			System.out.println("Type the email subject:");
			String subject = s.nextLine();
			
			
			System.out.println("Type the content of the message:");
			String content = s.nextLine();
			
			System.out.println("Is it a favorite contact? 'true' for yes and 'false' for no:");
			boolean favoriteContact = s.nextBoolean();
			s.nextLine();
			
			PriorityType messageType;

			
			System.out.println("Prioritize your message: ");
			System.out.println("1. Urgent (Type 1).");
			System.out.println("2. Important (Type 2).");
			System.out.println("3. Regular (Type 3).");
			
			while (!s.hasNextInt()) { s.nextLine(); System.out.print("Type 1/2/3: "); }
		    int choiceForPriorityType = s.nextInt();
		    s.nextLine();
			
			if(choiceForPriorityType == 1) {
				messageType = PriorityType.URGENT;
				
			} 
			else if(choiceForPriorityType == 2) {
				messageType = PriorityType.IMPORTANT;


			}
			else  {
				messageType = PriorityType.REGULAR;
			}
			
			
			System.out.println("Do you want to add files? 'true' for yes and 'false' for no:");
			boolean filesUploading = s.nextBoolean();
			s.nextLine();
			ArrayList<File> files = new ArrayList<File>();
			
			if(filesUploading) {
				
				while(true) {

					System.out.println("File name:");
					String fileName = s.nextLine();

					System.out.println("File type:");
					String fileType = s.nextLine();

					try {
						File file = new File(fileName,fileType);
						files.add(file);

					}
					catch (IllegalArgumentException e) {
						
						System.out.println("Exception: " + e.getLocalizedMessage());
						
					}
					
					System.out.println("Do you want to add more files? 'true' for yes and 'false' for no:");
					
					boolean more = s.nextBoolean();
					s.nextLine();

			        if (!more) break;
					
					
				}
				
			} else {
				
				files = null;
				
			}
			
			try {
				
				if(files == null) {
					Message emailMess = new EmailMessage(sender, content ,favoriteContact, subject ,messageType);
					messages.add(emailMess);

				} else {
					Message emailMess = new EmailMessage(sender, content, new Date() ,favoriteContact, subject, files ,messageType);
					messages.add(emailMess);

				}
							
				break;
			}
			catch (IllegalArgumentException e) {		
				System.out.println("Exception: " + e.getLocalizedMessage());		
			}			
						
		}
		
	}
	
	
	public static void addFacebookMessage(ArrayList<Message> messages, Scanner s) {
		
		
      while(1> 0) {
			
			System.out.println("Type the sender's name:");
			String sender = s.nextLine();
			
			Media mediaType = null;

			while (mediaType == null) {
			    System.out.println("Choose media type:");
			    System.out.println("1. VIDEO");
			    System.out.println("2. POST");
			    System.out.println("3. REEL");
			    System.out.println("4. STORY");

			    if (!s.hasNextInt()) {
			        s.nextLine();
			        System.out.println("You must type a number between 1-4.");
			        continue;
			    }

			    int mediaChoice = s.nextInt();
			    s.nextLine();

			    if (mediaChoice == 1) {
			        mediaType = Media.VIDEO;
			    } else if (mediaChoice == 2) {
			        mediaType = Media.POST;
			    } else if (mediaChoice == 3) {
			        mediaType = Media.REEL;
			    } else if (mediaChoice == 4) {
			        mediaType = Media.STORY;
			    } else {
			        System.out.println("Invalid choice. Please select 1–4.");
			    }
			}
			
			
			Boolean likeMessage = null;

			while (likeMessage == null) {
			    System.out.println("Do you want to like this message? Type 'true' for yes or 'false' for no:");

			    if (!s.hasNextBoolean()) {
			        s.nextLine();
			        System.out.println("Please type 'true' or 'false'.");
			        continue;
			    }

			    likeMessage = s.nextBoolean();
			    s.nextLine();
			}

			
			System.out.println("Type the content of the message:");
			String content = s.nextLine();
			
			System.out.println("Is it a favorite contact? 'true' for yes and 'false' for no:");
			boolean favoriteContact = s.nextBoolean();
			s.nextLine();
			
			
			try {
				
				
				Message facebookMess = new FacebookMessage(sender, content, new Date() ,favoriteContact , mediaType ,likeMessage);
				messages.add(facebookMess);

							
				break;
			}
			catch (IllegalArgumentException e) {
				
				System.out.println("Exception: " + e.getLocalizedMessage());

				
			}
		
	}
		
		
		
	}
}