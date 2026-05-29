/**
 * Lead Author(s):
 * 
 * @author Rumi Chadwick
 * @author Ale Hernandez
 *
 *         Version: 2026-05-27
*
* Version: 2026-05-05
*/
package com.chandez.adoptme.exceptions;

/**
 * Purpose: The reponsibility of PhoneNumberException is ...
 *
 * PhoneNumberException is-a ...
 * PhoneNumberException is ...
 */
public class PhoneNumberException extends Exception
{	
	//Sets the error message to "Please enter a valid phone number".
	public PhoneNumberException()
	{
		super("Please enter a valid phone number");
	}
	
	/**
	 * 
	 * Purpose: To change the error displayed on the screen to match the PhoneNumberException error
	 * @param message the error message for PhoneNumberException 
	 */
	public PhoneNumberException(String message)
	{
		super(message); 
	}
}
