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
 * Purpose: The reponsibility of AddressException is ...
 *
 * AddressException is-a ...
 * AddressException is ...
 */
public class AddressException extends Exception 
{
	////Sets the error message to "Please enter a valid address".
	public AddressException()
	{
		super("Please enter a valid address");
	}
	
	/**
	 * 
	 * Purpose: To change the error message displayed on the screen to match AddressException error. 
	 * @param message the error message for AddressException. 
	 */
	public AddressException(String message)
	{
		super(message);
	}
}
