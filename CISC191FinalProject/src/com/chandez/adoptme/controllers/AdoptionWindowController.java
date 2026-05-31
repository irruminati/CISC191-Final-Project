/**
 * Lead Author(s):
 * 
/**
 * Lead Author(s):
 * 
 * @author Rumi Chadwick
 * @author Ale Hernandez
 *
 *         Version: 2026-05-27
 *
 *         Version: 2026-05-10
 */
package com.chandez.adoptme.controllers;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.chandez.adoptme.domain.Pet;
import com.chandez.adoptme.domain.PetRepository;
import com.chandez.adoptme.exceptions.AddressException;
import com.chandez.adoptme.exceptions.NameException;
import com.chandez.adoptme.exceptions.PhoneNumberException;
import com.chandez.adoptme.exceptions.UserValidator;
import com.chandez.adoptme.ui.AdoptionWindow;

/**
 * Purpose: The reponsibility of AdoptionWindowController is ...
 *
 * AdoptionWindowController is-a ...
 * AdoptionWindowController is ...
 */
public class AdoptionWindowController
{
	private AdoptionWindow adoptionWindow;
	private Pet pet;

	public AdoptionWindowController(AdoptionWindow adoptionWindow,
			PetRepository petRepo)
	{
		this.adoptionWindow = adoptionWindow;
		pet = petRepo.getCurrPet();

		adoptionWindow.getSubmitButton()
				.addActionListener(e -> submitUserInfo());
	}
	/**
	 * 
	 * Purpose: The purpose of this method is to take in the information put by the user and assure that it has been submitted. 
	 * Also to catch any exceptions that the submitted info might throw
	 */
	private void submitUserInfo()
	{
		String name = adoptionWindow.getInputName();
		String phone = adoptionWindow.getInputPhone();
		String address = adoptionWindow.getInputAddress();

		try
		{
			UserValidator.validateAll(name, phone, address);

			adoptionWindow.clearError(); //if there was an error showing in the screen, after information was changed to be correct, 
										 //this would clear the error. 

			JOptionPane.showMessageDialog(adoptionWindow,

					"Your information was submitted.\n" + pet.getName()
							+ " can't wait to meet you!");
			
			adoptionWindow.closeWindow();
		}
		catch (NameException | AddressException | PhoneNumberException ex)
		{
			adoptionWindow.showError(ex.getMessage()); //gets an error from the try-catch block and shows the type of error it is 
													   //(e.g. Name has numbers).
		}
	}
}
