package domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Person {
	private String firstName;
	private String lastName;
	private Date birthDate;
	List<Account> accounts;
	List<Transaction> transactions;
	
	Person(String firstName, String lastName, String day, String month, String year){
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setBirthDate(day,month,year);
		this.accounts = new ArrayList<Account>();
		this.transactions = new ArrayList<Transaction>();
	}
	void setFirstName(String firstName){
		try {
			if(firstName != null && !firstName.isEmpty()) {
				this.firstName = firstName;
			}
			else {
				throw new Exception();
			}
		}
		catch(NullPointerException e) {
			System.out.println("First Name can't be null " + e.toString());
		}
		catch(Exception e) {
			System.out.println("First Name can't be empty " + e.toString());
		}
	}
	void setLastName(String lastName){
		try {
			if(lastName != null && !lastName.isEmpty()) {
				this.lastName = lastName;
			}
			else {
				throw new Exception();
			}
		}
		catch(NullPointerException e) {
			System.out.println("Last Name can't be null " + e.toString());
		}
		catch(Exception e) {
			System.out.println("Last Name can't be empty " + e.toString());
		}
	}
	void setBirthDate(String month, String day, String year) {
	    String pattern = "MM/dd/yyyy";
	    SimpleDateFormat format = new SimpleDateFormat(pattern);
	    try {
		    int monthInt = Integer.parseInt(month);
		    int dayInt = Integer.parseInt(day);
		    int yearInt = Integer.parseInt(year);
	    	if(monthInt>12 && dayInt> 31) {
	    		throw new Exception();
	    	}
	      Date birthDate1 = format.parse(month+"/"+day+"/"+year);
	      Date after = format.parse("01/01/1900");
	      if(birthDate1.before(new Date()) && birthDate1.after(after)) {
	    	  this.birthDate = birthDate1;
	      }
	      else {
	    	  throw new Exception();
	      }
	      System.out.println(format.format( birthDate1));
	    } catch(NullPointerException e){
	    	System.out.println("String can't be null" + e.toString());
	    }catch(NumberFormatException e) {
	    	System.out.println("Can't convert string to int " + e.toString());
	    }catch (ParseException e) {
	    	System.out.println("Couldn't parse string, check if all string aren't empty");
	        e.toString();
	    }catch(Exception e) {
	    	System.out.println("Date is incorect");
	    }
	    //System.out.println(format.format(new Date()));
	}
	void addAccount(Account account) {
		try {
			
		}catch(ClassNotFoundException e) {
			
		}
	}
	public static void main(String[] args) {
		Person das = new Person("Konrad","Sowisz","","","");
	}
}
