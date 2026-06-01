/**
 * Lead Author(s):
 * 
 * @author Rumi Chadwick
 * @author Ale Hernandez
 *
 *         Version: 2026-05-27
*
* Version: 2026-05-09
*/
package com.chandez.adoptme.exceptions;

/**
 * Purpose: The responsibility of NameException is to outline what to do if this exception is thrown 
 *
 * NameException is-a Exception
 */
public class NameException extends Exception
{
	//Sets the error message to "Please enter a valid name".
	public NameException()
 {
	 super("Please enter a valid name");
 }
	/**
	 * 
	 * Purpose: To change the message displayed on the screen to the error for NameException. 
	 * @param message the message for nameException error. 
	 */
	public NameException(String message)
	{
		super(message);
	}
}

