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
import com.chandez.adoptme.ui.SwipeView;

/**
 * Purpose: The reponsibility of SwipePageListener is ...
 *
 * SwipePageListener is-a ...
 * SwipePageListener is ...
 */
public class SwipePageListener implements ActionListener
{
	private PetRepository petList;
	private SwipeView view;
	private JButton yesButton;
	private JButton noButton;

	public SwipePageListener(PetRepository petList, SwipeView view)
	{
		this.petList = petList;
		this.view = view;
		this.yesButton = view.getYesButton();
		this.noButton = view.getNoButton();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		Pet currPet = petList.getCurrPet();
		// If the yes button is pressed, change that Pet's like status to true
		if (e.getSource() == yesButton)
		{
			currPet.setLiked(true);
		}
		else if (e.getSource() == noButton)
		{
			currPet.setLiked(false);
		}

		// Move to the next Pet and update the UI with its info
		view.updatePetView(petList.nextPet(currPet.isLiked()));
	}
}