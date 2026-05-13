/**
 * Lead Author(s):
 * 
 * @author alehzp; student ID
 * @author Full name; student ID
 *         <<Add additional lead authors here>>
 *
 *         Other Contributors:
 *         Full name; student ID or contact information if not in class
 *         <<Add additional contributors (mentors, tutors, friends) here, with
 *         contact information>>
 *
 *         References:
 *         Morelli, R., & Walde, R. (2016).
 *         Java, Java, Java: Object-Oriented Problem Solving
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 *
 *         <<Add more references here>>
 *
 *         Version: 2026-05-10
 */
package com.chandez.adoptme.controllers;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

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

	public AdoptionWindowController(AdoptionWindow adoptionWindow,
			PetRepository repo)
	{
		this.adoptionWindow = adoptionWindow;

		adoptionWindow.getSubmitButton()
				.addActionListener(e -> submitUserInfo());
	}

	private void submitUserInfo()
	{
		String name = adoptionWindow.getInputName();
		String phone = adoptionWindow.getInputPhone();
		String address = adoptionWindow.getInputAddress();

		try
		{
			UserValidator.validateAll(name, phone, address);

			adoptionWindow.clearError();

			JOptionPane.showMessageDialog(adoptionWindow,
					"Your information was submitted");

			adoptionWindow.closeWindow();
		}
		catch (NameException | AddressException | PhoneNumberException ex)
		{
			adoptionWindow.showError(ex.getMessage());
		}
	}
}
