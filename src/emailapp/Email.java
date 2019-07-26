package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private int defaultPasswordLength = 10;
	private String department;
	private String email;
	private int mailboxCapacity = 500;
	private String alternateEmail;
	private String companySuffix = "anycompany.com";
	
	// Constructor to receive the first name and last Name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		// Call a method asking for the department - return the department
		this.department = setDevelopment();
		
		// Call a method which generate random password
		this.password = randomPassword(defaultPasswordLength);
		
		// Combine elements to generate email
		email = this.firstName.toLowerCase() + '.' + this.lastName.toLowerCase() + "@" + this.department + '.' + companySuffix;
		
	}
	
	// Ask for the department
	private String setDevelopment() {
		System.out.println("Department Codes: \n 1 for Sales \n 2 for  Development \n 3 for account \n 0 for none");
		Scanner in = new Scanner(System.in);
		int depChoise = in.nextInt();
		if(depChoise == 1) {return "sales";}
		else if(depChoise == 2) {return "dev";}
		else if(depChoise == 3) {return "acct";}
		else { return "";}
	}
	
	// Generate a random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWX!@#$%";
		char[] password = new char[length];
		for(int i = 0; i < length; i++) {
			int rand = (int)(Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	// Set the mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	// Set the alternate email
	public void setAlternateEmail(String altmail) {
		this.alternateEmail = altmail;
	}
	
	// Change the password
	public void changePassword(String password) {
		this.password = password;
	}
	
	//Get Methods
	public int getMailboxCapacity() {return mailboxCapacity;}
	public String getAlternateEmail() {return alternateEmail;}
	public String getPassword() {return password;}
	
	public String showInfo() {
		return "Display Name: " + firstName + " " + lastName + " " + "\n" +
				"Password: " + password + "\n" +
				"Company Email: " + email + "\n" +
				"MailBox Capacity: " + mailboxCapacity + "mb";
	}
	
}
