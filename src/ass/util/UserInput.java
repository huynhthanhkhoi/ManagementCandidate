/*
 * @author KhoiHT2
 * @date 7 thg 9, 2022
 * @version 1.0
 */



package ass.util;

import java.util.Scanner;

import ass.exception.BirthDayException;
import ass.exception.EmailException;

public class UserInput {

	// check email nếu ko đúng định dạng thì nhập tiếp
	public static String checkEmail(Scanner scanner) {
	    String email;

	    System.out.println("enter email");
	    email = scanner.nextLine();

	    while (!Validator.isValidEmail(email)) {
	      System.out.println("Invalid email (example: example@gmail.com)");
	      email = scanner.nextLine();
	    }

	    return email;
	  }
	// check email nếu ko đúng định dạng ném ra 1 ngoại lệ và kết thúc chương trình
	public static String checkEmail1(Scanner scanner) throws EmailException {
	    String email;
	    System.out.println("enter email");
	    email = scanner.nextLine();
	    Validator.validEmail(email);	   
	    return email;
	  }
	
	
	// check birthday nếu ko đúng địng dạn thì nhập lại cho đến khi đúng
	public static String checkBirthday(Scanner scanner) {
	    String birthday;

	    System.out.println("Please enter birthday");
	    birthday = scanner.nextLine();

	    while (!Validator.isValidBirthDay(birthday)) {
	      System.out.println("Invalid birthday example: (01/01/1990)");
	      birthday = scanner.nextLine();
	    }

	    return birthday;
	  }
	
	// check birthday nếu ko đúng định dạng ném ra ngoại lệ và kết thúc chương trình
	public static String checkBirthday1(Scanner sc) throws BirthDayException {
	    String birthday;
	    System.out.println("Please enter birthday");
	    birthday = sc.nextLine();
	    Validator.validBirthDay(birthday);	   
	    return birthday;
	  }
	
//	public static String checkAllInput(Scanner sc) {
//		
//	}
}
