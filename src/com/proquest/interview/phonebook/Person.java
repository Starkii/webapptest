package com.proquest.interview.phonebook;

/**
 * @author ProQuest/Jens Wessling
 *
 */
public class Person {
	
	private Name name;
	private String phoneNumber;
	private String address;
	
	public Person(Name name, String phoneNumber, String address)
	{
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	public Name getName()
	{
		return name;
	}
	
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public String toString()
	{
		StringBuffer nameString = new StringBuffer();
		Name name = getName();
		nameString.append(name.getFirst());
		nameString.append(" ");
		nameString.append(name.getLast());
		nameString.append("\n");
		nameString.append(getPhoneNumber());
		nameString.append("\n");
		nameString.append(getAddress());
		nameString.append("\n\n");
		return nameString.toString();
	}
}
