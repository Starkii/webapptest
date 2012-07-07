package com.proquest.interview.phonebook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.proquest.interview.util.DatabaseUtil;

/**
 * @author ProQuest/Jens Wessling
 *
 */
public class PhoneBookImpl implements PhoneBook {
	private List<Person> people = new ArrayList<Person>();
	
	/* (non-Javadoc)
	 * @see com.proquest.interview.phonebook.PhoneBook#addPerson(com.proquest.interview.phonebook.Person)
	 */
	@Override
	public void addPerson(Person newPerson) {
		if(newPerson == null)
		{
			throw new NullPointerException("Invalid <null> value for newPerson.");
		}
	    people.add(newPerson);
	}
	
	/* (non-Javadoc)
	 * @see com.proquest.interview.phonebook.PhoneBook#removePerson(com.proquest.interview.phonebook.Person)
	 */
	@Override
	public void removePerson(Person oldPerson) {
		people.remove(oldPerson);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DatabaseUtil.initDB();  //You should not remove this line, it creates the in-memory database

		PhoneBookImpl phoneBook = new PhoneBookImpl();
		
		phoneBook.addPerson(new Person(new Name("John", "Smith"), "(248) 123-4567", "Sand Hill Dr, Royal Oak, MI"));
		phoneBook.addPerson(new Person(new Name("Cynthia", "Smith"), "(824) 128-8758", "875 Main St, Ann Arbor, MI"));
		
		System.out.println(phoneBook.toString());
		
		Person cynthia = phoneBook.findPerson("Cynthia","Smith");		
		System.out.println(cynthia);
		
		try {
			phoneBook.addPersonToDb(cynthia);
			phoneBook.addPersonToDb(phoneBook.findPerson("John","Smith"));
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Failed to add person to database.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("Failed to add person to database.");
		}	
	}

	/* (non-Javadoc)
	 * @see com.proquest.interview.phonebook.PhoneBook#findPerson(java.lang.String, java.lang.String)
	 */
	@Override
	public Person findPerson(String firstName, String lastName) {
		for(Person p: people)
		{
			if(p.getName().getFirst().equals(firstName) && p.getName().getFirst().equals(firstName))
			{
				return p;
			}
		}
		return null;
	}
	
	/**
	 * @param person
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	void addPersonToDb(Person person) throws SQLException, ClassNotFoundException
	{
		try {
		    Connection cn = DatabaseUtil.getConnection();
		    ///
		    // It's important to use prepared Statements here to avoid injection attacks;
			PreparedStatement pstmt = cn.prepareStatement("INSERT INTO PHONEBOOK (NAME,PHONENUMBER,ADDRESS) VALUES (?,?,?)");
			pstmt.setString(1, person.getName().getName());
			pstmt.setString(2, person.getPhoneNumber());
			pstmt.setString(3, person.getAddress());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * Simple representation of the contents of the PhoneBook.
	 */
	public String toString()
	{
		StringBuilder namesString = new StringBuilder();
		for(Person p: people)
		{
			namesString.append(p.toString());
		}
		return namesString.toString();
	}
}
