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
 * Purpose: The responsibility of AddressException is to outline what to do if this exception is thrown 
 *
 * AddressException is-a Exception
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
