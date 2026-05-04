package com.chandez.adoptme.ui;

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

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;

import com.chandez.adoptme.controllers.*;
import com.chandez.adoptme.domain.*;

/**
 * Purpose:
 */
public class SwipeView extends JPanel
{
	private JLabel photo; // Profile photo of the Pet

	private JPanel basicInfo; // Name, age, and breed
	private JLabel nameAndAge;
	private JLabel breed;

	private JPanel extInfo; // Extended info; ex) biography, intake date, vax
							// status, etc.
	private JLabel bioHeader;
	private JLabel bioParagraph;

	private JButton yesButton;
	private JButton noButton;

	public SwipeView(PetRepository petRepo)
	{
		super(new BorderLayout());
		setMinimumSize(new Dimension(800, 800));

		// TODO Maybe should change this to adhere to MVC ??
		Pet pet = petRepo.getCurrPet();

		// Create the photo //
		photo = new JLabel();
		setPhoto(pet);

		// Create basic info section //
		basicInfo = new JPanel();

		nameAndAge = new JLabel();
		basicInfo.add(nameAndAge);

		breed = new JLabel();
		basicInfo.add(breed);

		setBasicInfo(pet);

		// Create extended info section
		extInfo = new JPanel();

		bioHeader = new JLabel();
		extInfo.add(bioHeader);

		bioParagraph = new JLabel();
		extInfo.add(bioParagraph);

		setExtInfo(pet);

		// Create the buttons //
		JPanel buttonPanel = new JPanel();

		yesButton = new JButton("Yes");
		buttonPanel.add(yesButton);
		yesButton.addActionListener(new SwipePageListener(petRepo, this));

		noButton = new JButton("No");
		buttonPanel.add(noButton);
		noButton.addActionListener(new SwipePageListener(petRepo, this));

		add(buttonPanel, BorderLayout.SOUTH);

		// Add pfp to the center
		add(photo);
		// Add name and basic info under the photo
		add(basicInfo);
		// Add extended bio to the right of the photo
		add(extInfo, BorderLayout.EAST);
	}

	public JButton getYesButton()
	{
		return yesButton;
	}

	public JButton getNoButton()
	{
		return noButton;
	}

	/**
	 * Helper method to update just the photo
	 * 
	 * @param pet the new Pet from which to get the photo
	 */
	private void setPhoto(Pet pet)
	{
		// Wraps the BufferedImage from the Pet object into an ImageIcon,
		// which is then wrapped into a JLabel
		try
		{
			photo.setIcon(new ImageIcon(pet.getPhoto()));
		}
		catch (NullPointerException e)
		{
			// TODO
			// Not necessarily null, but catch potential error from Pet not
			// having a valid photo
		}
	}

	/**
	 * Helper method to update just the labels below the picture
	 * 
	 * @param pet the new Pet from which to get basic info
	 */
	private void setBasicInfo(Pet pet)
	{
		nameAndAge.setText(pet.getName() + ", " + pet.getAge());
		breed.setText(pet.getType());
	}

	/**
	 * Helper method to update just the labels to the right of the picture
	 * 
	 * @param pet the new Pet from which to get extended info
	 */
	private void setExtInfo(Pet pet)
	{
		// TODO
	}

	public void updatePetView(Pet pet)
	{
		// Update photo
		setPhoto(pet);

		// Update basic info below photo
		setBasicInfo(pet);

		// Update bio stuff to right of photo
		setExtInfo(pet);
	}
}