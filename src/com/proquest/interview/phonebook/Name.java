package com.proquest.interview.phonebook;

/**
 * @author Jens Wessling
 *
 *
 * For simplicity sake, I'm representing the name as two strings, first_name and last_name.
 *  Normally I'd prefer to use something like 
 *  @see <a href="http://javadoc.google-api-java-client.googlecode.com/hg/apis/plus/v1/com/google/api/services/plus/model/PersonName.html"/>	
 */
class Name {

	private String first;
	private String last;

	/**
	 * @param first
	 * @param last
	 */
	public Name(String first, String last)
	{
		if(first == null || last == null)
		{
			throw new NullPointerException("Invalid first of last name.");
		}
		this.first = first;
		this.last = last;
	}
	
	/**
	 * @return The last name 
	 */
	public String getFirst() 
	{
		return first;
	}
	
	/**
	 * @return The first name
	 */
	public String getLast()
	{
		return last;
	}
	
	/**
	 * @return The full name
	 */
	public String getName()
	{
		return first + " " + last;
	}
}