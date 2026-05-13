/**
* Lead Author(s):
* @author alehzp; student ID
* @author Full name; student ID
* <<Add additional lead authors here>>
*
* Other Contributors:
* Full name; student ID or contact information if not in class
* <<Add additional contributors (mentors, tutors, friends) here, with contact information>>
*
* References:
* Morelli, R., & Walde, R. (2016).
* Java, Java, Java: Object-Oriented Problem Solving
* https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
*
* <<Add more references here>>
*
* Version: 2026-05-09
*/
package com.chandez.adoptme.exceptions;

/**
 * Purpose: The reponsibility of AddressException is ...
 *
 * AddressException is-a ...
 * AddressException is ...
 */
public class AddressException extends Exception 
{
	public AddressException()
	{
		super("Please enter a valid address");
	}
	
	public AddressException(String message)
	{
		super(message);
	}
}
