/**
 * Lead Author(s):
 * 
 * @author Rumi Chadwick
 * @author Ale Hernandez
 * 
 *         References:
 *         Morelli, R., & Walde, R. (2016).
 *         Java, Java, Java: Object-Oriented Problem Solving
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 *
 *         Version: 2026-04-29
 */
package com.chandez.adoptme.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

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

	public SwipePageListener(PetRepository petList, SwipeView view,
			JButton yesButton, JButton noButton)
	{
		this.petList = petList;
		this.view = view;
		this.yesButton = yesButton;
		this.noButton = noButton;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// If the yes button is pressed, change that Pet's like status to true
		if (e.getSource() == yesButton)
		{
			petList.getCurrPet().setLiked(true);
		}

		view.updateUI(petList.nextPet());
	}
}