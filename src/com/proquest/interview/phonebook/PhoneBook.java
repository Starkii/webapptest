package com.proquest.interview.phonebook;

/**
 * @author ProQuest/Jens Wessling
 *
 */
public interface PhoneBook {
	/**
	 * @param firstName
	 * @param lastName
	 * @return The Person record if found, null if not found.
	 */
	public Person findPerson(String firstName, String lastName);
	
	/**
	 * @param newPerson
	 */
	public void addPerson(Person newPerson);
	
	/**
	 * @param oldPerson
	 */
	void removePerson(Person oldPerson);
}
