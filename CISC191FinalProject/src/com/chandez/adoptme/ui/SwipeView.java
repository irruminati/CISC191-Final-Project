package com.chandez.adoptme.ui;

/**
 * Lead Author(s):
 * 
 * @author Rumi Chadwick
 * @author Ale Hernandez
 * 
 *         Other Contributors:
 *         Alex Chow
 *
 *         Version: 2026-04-29
 */

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import com.chandez.adoptme.controllers.*;
import com.chandez.adoptme.domain.*;

/**
 * Purpose:
 */
public class SwipeView extends JFrame
{
	private JLabel photo; // Profile photo of the Pet

	private JLabel nameAndAge;
	private JLabel breed;

	private JLabel bioHeader;
	private JTextArea bioParagraph;

	private JButton yesButton;
	private JButton noButton;

	public SwipeView(PetRepository petRepo)
	{
		super();
		// TODO Maybe should change this to adhere to MVC ??
		Pet pet = petRepo.getCurrPet();

		setLayout(new BorderLayout());

		// Minimum size of window
		setMinimumSize(new Dimension(600, 400));
		// Close app when window is closed
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// App name at the top
		setTitle("Adopt Me");

		// PROFILE PICTURE //

		photo = new JLabel();
		setPhoto(pet);

		// BASIC INFO //

		JPanel basicInfo = new JPanel();

		nameAndAge = new JLabel();
		basicInfo.add(nameAndAge);

		breed = new JLabel();
		basicInfo.add(breed);

		setBasicInfo(pet);

		// MAIN PANEL //

		JPanel mainInfoPanel = new JPanel();
		mainInfoPanel.setLayout(new BoxLayout(mainInfoPanel, BoxLayout.Y_AXIS));

		mainInfoPanel.add(photo, BorderLayout.CENTER);
		mainInfoPanel.add(basicInfo, BorderLayout.CENTER);

		// BIOGRAPHY //

		JPanel extInfo = new JPanel();

		// GridBagConstraints gbc = new GridBagConstraints();
		// gbc.gridx = 0;
		// gbc.gridy = 0;
		// gbc.anchor = GridBagConstraints.CENTER;

		bioHeader = new JLabel();
		extInfo.add(bioHeader);

		bioParagraph = new JTextArea();
		bioParagraph.setFocusable(false);
		extInfo.add(bioParagraph);

		setExtInfo(pet);

		// BUTTONS //

		// Create a container panel for the buttons with a box layout
		JPanel buttonPanel = new JPanel();
		// Align them horizontally
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

		// Create the "no" button
		noButton = new JButton("No");
		buttonPanel.add(noButton);
		noButton.addActionListener(new SwipeViewListener(petRepo, this, false));

		// Spacer to push both buttons to the bottom corners
		buttonPanel.add(Box.createHorizontalGlue());

		// Create the "yes" button
		yesButton = new JButton("Yes");
		buttonPanel.add(yesButton);
		yesButton.addActionListener(new SwipeViewListener(petRepo, this, true));

		// add(new JLabel("Programmed by Rumi Chadwick and Ale Hernandez"),
		// BorderLayout.NORTH);
		add(buttonPanel, BorderLayout.SOUTH);
		add(mainInfoPanel, BorderLayout.CENTER);
		add(extInfo, BorderLayout.EAST);

		// Make the window visible
		setVisible(true);
	}

	/**
	 * Helper method to update just the photo
	 * 
	 * @param pet the new Pet from which to get the photo
	 */
	private void setPhoto(Pet pet)
	{
		try
		{
			ImageIcon icon = pet.getPhoto();
			if (icon != null)
			{
				// Scale the image to a reasonable size
				Image scaledImage = icon.getImage().getScaledInstance(300, 300,
						Image.SCALE_SMOOTH);
				ImageIcon scaledIcon = new ImageIcon(scaledImage);
				photo.setIcon(scaledIcon);
				photo.setPreferredSize(new Dimension(300, 300));
			}
		}
		catch (NullPointerException e)
		{
			e.printStackTrace();
			System.out
					.println("Failed to set photo for " + nameAndAge.getText());
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
		bioParagraph.setText(pet.getBio());
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