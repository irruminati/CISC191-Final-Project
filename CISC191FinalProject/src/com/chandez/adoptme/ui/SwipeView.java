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
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;

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
	
	private static final String BACKGROUND_PATH =
			"/Users/alehzp/git/CISC191-Final-Project/CISC191FinalProject/images/adoptme_bg.jpg"; 

	public SwipeView(PetRepository petRepo)
	{
		super();

		Pet pet = petRepo.getCurrPet();

		setLayout(new BorderLayout());

		// Minimum size of window
		setMinimumSize(new Dimension(600, 400));
		// Lock the size of the window
		setResizable(false);
		// Close app when window is closed
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.BLUE);
		// App name at the top
		setTitle("Adopt Me");
		
		//Background//
		
		ImageIcon backgroundIcon = new ImageIcon(BACKGROUND_PATH);
		Image backgroundImage = backgroundIcon.getImage();

		JPanel backgroundPanel = new JPanel(new BorderLayout())
		{
			@Override
			protected void paintComponent(Graphics g)
			{
				super.paintComponent(g);

				g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
			}
		};

		setContentPane(backgroundPanel);

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

		JPanel mainInfoPanel = new JPanel(new BorderLayout()); // rumi 
		
		mainInfoPanel.setOpaque(false); //me
		
		mainInfoPanel.add(photo, BorderLayout.CENTER); //rumi
		mainInfoPanel.add(basicInfo, BorderLayout.SOUTH);
		
		// mainInfoPanel.add(photo, BorderLayout.CENTER);
		// mainInfoPanel.add(basicInfo, BorderLayout.SOUTH);

		// BIOGRAPHY //

		JPanel extInfo = new JPanel();
		extInfo.setOpaque(false); //me
		extInfo.setLayout(new GridBagLayout());
		extInfo.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20)); // Left/right
																			// margins

		bioHeader = new JLabel();
		bioParagraph = new JTextArea();

		// TODO add constants ?
		bioParagraph.setBounds(bioParagraph.getX(), bioParagraph.getY(), 300,
				bioParagraph.getHeight());
		//bioParagraph.setOpaque(false); //me
		bioParagraph.setFocusable(false); // Make bio uneditable
		bioParagraph.setLineWrap(true);
		bioParagraph.setWrapStyleWord(true);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		extInfo.add(bioHeader, gbc);

		gbc.gridy = 1;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		extInfo.add(bioParagraph, gbc);

		setExtInfo(pet);

		// BUTTONS //

		// Create a container panel for the buttons with a box layout
		JPanel buttonPanel = new JPanel();
		buttonPanel.setOpaque(false); //me
		// Align them horizontally
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

		// Create the "no" button
		noButton = new JButton("✖");
		noButton.setBackground(Color.RED);
		noButton.setOpaque(true);
		noButton.setContentAreaFilled(true);
		noButton = new JButton("X");
		noButton.setBackground(Color.RED);
		noButton.setOpaque(true);
		noButton.setContentAreaFilled(true);
		noButton.setBorderPainted(false);
		noButton.setFocusPainted(false);
		buttonPanel.add(noButton);
		noButton.addActionListener(new SwipeViewListener(petRepo, this, false));

		// Spacer to push both buttons to the bottom corners
		buttonPanel.add(Box.createHorizontalGlue());

		// Create the "yes" button
		yesButton = new JButton("✔");
		yesButton.setBackground(new Color(34, 139, 34)); // Custom green color
		yesButton.setOpaque(true);
		yesButton.setContentAreaFilled(true);
		yesButton.setBorderPainted(false);
		yesButton.setFocusPainted(false);
		buttonPanel.add(yesButton);
		yesButton.addActionListener(new SwipeViewListener(petRepo, this, true));

		// Put buttons at the bottom of the app
		add(buttonPanel, BorderLayout.SOUTH);

		JPanel allInfoPanel = new JPanel();
		allInfoPanel.setOpaque(false); //me
		allInfoPanel.add(mainInfoPanel);
		allInfoPanel.add(extInfo);

		add(allInfoPanel, BorderLayout.CENTER);

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
		nameAndAge.setText(pet.getName() + ", " + pet.getAge() + ",");
		breed.setText(pet.getType());
	}

	/**
	 * Helper method to update just the labels to the right of the picture
	 * 
	 * @param pet the new Pet from which to get extended info
	 */
	private void setExtInfo(Pet pet)
	{
		bioHeader.setText("All about " + pet.getName() + "!");
		bioParagraph.setText(pet.getBio() + "\n\n" + pet.getName()
				+ " joined us on " + pet.getIntakeDate());
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