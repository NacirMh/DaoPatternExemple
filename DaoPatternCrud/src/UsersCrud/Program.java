package UsersCrud;

import java.util.List;
import java.util.Scanner;


import Dao.DaoUser;
import Dao.User;

public class Program {
	
	public static int generateId() {
		return (int)(Math.random() * 100000) + 1;
		
	}

	public static void main(String[] args) {

	   DaoUser dao= new DaoUser();
	   int id= generateId();	
	   int input=0;
	   
	   Scanner sc = new Scanner(System.in);

	   do {
		 System.out.println("1-Insert new user");
		 System.out.println("2-Delete user");
		 System.out.println("3-Display all users");
		 System.out.println("0-exit");
		 
	     
			input = sc.nextInt();
			 
			 switch (input) {
			    case 1 :
			    	String name;
			    	int age;
			    	String password;
			    	
			    	System.out.println("enter username");
			    	name = sc.next();
			    	System.out.println("enter user's age");
			    	age = sc.nextInt();
			    	System.out.println("enter user's password");
			    	password =sc.next();
			    	
			    	User u = new User(id,name,age,password);
			    	dao.addUser(u);
			    	System.out.println("Added user with id : "+id);

			    	id= generateId();
			    	
			    	
			    	break;
			    case 2:
			    	System.out.print("enter the user id");
			    	int idd = sc.nextInt();
			    	dao.deleteUser(idd);
			    	
			    	break;
			    case 3:
			    	List <User> users = dao.getAllUsers();
			    	for(User us : users) {
			    		System.out.println(us);
			    		System.out.println("-------------------------------------------------------");
			    	}
			    	break;
			    case 0:
			    	System.exit(0);
			    	break;
			    	
			 }

	   }while(input>0);
	   

	   


	   
	}

}
