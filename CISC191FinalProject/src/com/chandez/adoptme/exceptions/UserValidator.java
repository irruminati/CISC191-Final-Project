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
* Version: 2026-05-10
*/
package com.chandez.adoptme.exceptions;

/**
 * Purpose: The reponsibility of UserValidator is ...
 *
 * UserValidator is-a ...
 * UserValidator is ...
 */
public class UserValidator
{
	public static void validateName(String name) throws NameException
	{
		if(name == null || name.trim().isEmpty())
		{
			throw new NameException("Name cannot be empty");
		}
		
		if (!name.matches("[\\p{L}\\s'-]+"))
		{
			throw new NameException("Name can only contain letters");
		}
	}
	
	public static void validatePhone(String phone) throws PhoneNumberException
	{
		if(phone == null || phone.trim().isEmpty())
		{
			throw new PhoneNumberException("Phone number cannot be empty");
		}
		
		String phoneLength = phone.replaceAll("[^0-9]"," ");
		
		if(phoneLength.length()!= 10)
		{
			throw new PhoneNumberException("Phone number must be 10 digits");
		}
	}
	
	public static void validateAddress(String address) throws AddressException
	{
		if (address == null || address.trim().isEmpty())
		{
			throw new AddressException("Address cannot be empty");
		}
		
		if (address.trim().length() < 5)
        {
            throw new AddressException("Address is too short");
        }

        if (!address.matches(".*\\d.*"))
        {
            throw new AddressException("Address must have a street number");
        }

        if (!address.matches(".*[a-zA-Z].*"))
        {
            throw new AddressException("Address must have a street name");
        }
	}
	
	public static void validateAll(String name, String phone, String address)
            throws NameException, PhoneNumberException, AddressException
    {
        validateName(name);
        validatePhone(phone);
        validateAddress(address);
    }

}
