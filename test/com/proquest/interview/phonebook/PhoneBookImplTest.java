package com.proquest.interview.phonebook;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.BeforeClass;
import org.junit.Test;

import com.proquest.interview.util.DatabaseUtil;

public class PhoneBookImplTest {
	
	@BeforeClass
	public static void runBeforeClass() {
		DatabaseUtil.initDB();  //You should not remove this line, it creates the in-memory database
	}
	
	@Test
	public void testFindPerson() 
	{
		PhoneBook phoneBook = new PhoneBookImpl();
		
		phoneBook.addPerson(new Person(new Name("John", "Smith"), "(248) 123-4567", "Sand Hill Dr, Royal Oak, MI"));
		Person john = phoneBook.findPerson("John","Smith");		
		assertEquals(john.getPhoneNumber(), "(248) 123-4567");
		assertNull(phoneBook.findPerson("Jens", "Wessling"));
	}
	
	@Test
	public void testAddPersonToDb() throws SQLException, ClassNotFoundException
	{
		Person p = new Person(new Name("John", "Smith"), "(248) 123-4567", "Sand Hill Dr, Royal Oak, MI");
		PhoneBookImpl phoneBookImpl = new PhoneBookImpl();
		phoneBookImpl.addPersonToDb(p);
		
		Connection cn = DatabaseUtil.getConnection();
		Statement stmt = cn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT count(*) FROM PHONEBOOK WHERE PHONENUMBER = '(248) 123-4567'");
		rs.next();
		assertEquals(rs.getInt(1), 1);
				
	}
}
