/**
 * Lead Author(s):
 * 
 * @author Rumi Chadwick
 * @author Ale Hernandez
 *
 *         Version: 2026-05-27
*
* <<Add more references here>>
*
* Version: 2026-05-10
*/
package com.chandez.adoptme.exceptions;

/**
 * Purpose: The responsibility of UserValidator is to outline what is considered an error of each exceptions. 
 *
 * UserValidator is-a list of exceptions 
 */
public class UserValidator
{
	/**
	 * 
	 * Purpose: Validate the name submitted by the user.
	 * @param name name submitted by the user 
	 * @throws NameException
	 */
	public static void validateName(String name) throws NameException
	{
		if(name == null || name.trim().isEmpty()) //Makes sure the field isn't empty 
		{
			throw new NameException("Name cannot be empty"); 
		}
		
		if (!name.matches("[\\p{L}\\s'-]+")) //Makes sure that the name is only letters. 
		{
			throw new NameException("Name can only contain letters");
		}
	}
	
	/**
	 * 
	 * Purpose: Validates the number submitted by the user. 
	 * @param phone the phone number submitted by the user
	 * @throws PhoneNumberException
	 */
	public static void validatePhone(String phone) throws PhoneNumberException
	{
		if(phone == null || phone.trim().isEmpty())
		{
			throw new PhoneNumberException("Phone number cannot be empty");
		}
		
		String phoneLength = phone.replaceAll("[^0-9]"," "); //Makes sure that it contains numbers but also that there is 10 digits. 
		
		if(phoneLength.length()!= 10)
		{
			throw new PhoneNumberException("Phone number must be 10 digits");
		}
	}
	
	/**
	 * 
	 * Purpose: Validates the address submitted by the user. 
	 * @param address the address submitted by the user
	 * @throws AddressException
	 */
	public static void validateAddress(String address) throws AddressException
	{
		if (address == null || address.trim().isEmpty())
		{
			throw new AddressException("Address cannot be empty");
		}
		
		if (address.trim().length() < 5) //Makes sure address isn't too short or not formatted correctly.
        {
            throw new AddressException("Invalid Address");
        }

        if (!address.matches(".*\\d.*")) //Makes sure that the address contains numbers.
        { 
            throw new AddressException("Address must have a street number");
        }

        if (!address.matches(".*[a-zA-Z].*")) //Makes sure the address contains letters. 
        {
            throw new AddressException("Address must have a street name");
        }
	}
	
	/**
	 * 
	 * Purpose: To Validate all fields which will either clear all errors, or allow the user to submit their information 
	 * @param name name that was written 
	 * @param phone phone that was written 
	 * @param address address that was written 
	 */
	
	public static void validateAll(String name, String phone, String address)
            throws NameException, PhoneNumberException, AddressException
    {
        validateName(name);
        validatePhone(phone);
        validateAddress(address);
    }

}
