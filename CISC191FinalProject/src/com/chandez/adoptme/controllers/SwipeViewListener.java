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

import javax.swing.JButton;

import com.chandez.adoptme.domain.Pet;
import com.chandez.adoptme.domain.PetRepository;
import com.chandez.adoptme.ui.AdoptionWindow;
import com.chandez.adoptme.ui.SwipeView;

/**
 * Purpose: The reponsibility of SwipePageListener is ...
 *
 * SwipePageListener is-a ...
 * SwipePageListener is ...
 */
public class SwipeViewListener implements ActionListener
{
	private PetRepository petList;
	private SwipeView view;
	boolean yes; // TODO fix name, yes button is true and no button is false

	public SwipeViewListener(PetRepository petList, SwipeView view, boolean yes)
	{
		this.petList = petList;
		this.view = view;
		this.yes = yes;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// Move to the next Pet and update the UI with its info
		view.updatePetView(petList.nextPet(yes));

		// If the no button is pressed, check if the next Pet is the last one
		if (!yes && petList.onePetLeft())
		{
			new AdoptionWindow();
		}
	}
}