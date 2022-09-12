/*
 * @author KhoiHT2
 * @date 7 thg 9, 2022
 * @version 1.0
 */



package ass.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import ass.exception.BirthDayException;
import ass.exception.EmailException;

public class Validator {
	public static boolean isValidEmail(String email) {
	    return Pattern.matches("^(.+)@(\\S+)$", email);
	  }
	
	public static boolean isValidBirthDay(String birthday) {
		boolean check = false;
	    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	    SimpleDateFormat dfyear = new SimpleDateFormat("yyyy");
	    Date bd = null;
	    df.setLenient(false);	
	    try {
			bd = df.parse(birthday);
			
			if(Integer.parseInt(dfyear.format(bd)) > 1900) {
				check = true;
			}else {
				check = false;
			}
			
		} catch (ParseException e) {
		
			check = false;
			
		}
		return check;		
	    
	  }
	
	
	public static void  validEmail(String email) throws EmailException {
	    if(Pattern.matches("^(.+)@(\\S+)$",email)) {
	    	
	    }else {
	    	throw new EmailException("Email chưa đúng định dạng");
	    }
	  }
	
	
	public static void validBirthDay(String birthday) throws BirthDayException {
	    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	    SimpleDateFormat dfyear = new SimpleDateFormat("yyyy");
	    Date bd = null;
	    df.setLenient(false);		 
			try {
				bd = df.parse(birthday);
			} catch (ParseException e) {
				throw  new BirthDayException("Nhập vào birthday không hợp lệ");
			}			
			if(Integer.parseInt(dfyear.format(bd)) > 1900) {				
			}else {
				throw  new BirthDayException("Nhập vào birthday không hợp lệ");
			}
			
				
	    
	  }
	
}
