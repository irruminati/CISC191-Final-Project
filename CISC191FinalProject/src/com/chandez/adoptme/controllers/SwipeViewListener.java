/**
 * Lead Author(s):
 * 
 * @author Rumi Chadwick
 * @author Ale Hernandez
 *
 *         Version: 2026-04-29
 */
package com.chandez.adoptme.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.chandez.adoptme.domain.PetRepository;
import com.chandez.adoptme.ui.AdoptionWindow;
import com.chandez.adoptme.ui.SwipeView;

/**
 * SwipeViewListener is attached to the buttons on the SwipeView, and performs
 * different actions to the PetRepository depending on which button was pressed.
 */
public class SwipeViewListener implements ActionListener
{
	private PetRepository petList;
	private SwipeView view;
	boolean yes; // yes button is true and no button is false

	public SwipeViewListener(PetRepository petList, SwipeView view, boolean yes)
	{
		this.petList = petList;
		this.view = view;
		this.yes = yes;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// Play an animal sound if the user said yes to the Pet
		if (yes)
		{
			petList.getCurrPet().playSound();
		}

		// Move to the next Pet and update the UI with its info
		view.updatePetView(petList.nextPet(yes));

		// If the no button is pressed, check if the next Pet is the last one
		if (!yes && petList.onePetLeft())
		{
			showAdoptionWindow(petList);
		}
	}

	/**
	 * Helper method to create the popup adoption window
	 * 
	 * @param petRepo list
	 */
	private void showAdoptionWindow(PetRepository petRepo)
	{
		AdoptionWindow window = new AdoptionWindow();
		new AdoptionWindowController(window, petRepo);
	}
}