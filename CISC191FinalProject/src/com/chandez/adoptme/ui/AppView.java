package com.chandez.adoptme.ui;

import com.chandez.adoptme.controllers.*;
import com.chandez.adoptme.domain.*;

import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.*;

/**
 * Lead Author(s):
 * 
 * @author Rumi Chadwick
 * @author Ale Hernandez
 * 
 *         Version: 2026-04-13
 */
public class AppView extends JFrame
{
	private JPanel mainPanel;
	private SwipeView swipeView;
	private CardLayout cl;

	// private JPanel menuView;
	// private JPanel likesView;

	public AppView(PetRepository petRepo)
	{
		super();

		// Format AppView with CardLayout using mainPanel as the container //
		cl = new CardLayout();
		mainPanel = new JPanel(cl);
		add(mainPanel);

		swipeView = new SwipeView(petRepo);

		mainPanel.add(swipeView, "Swipe View");
		cl.show(mainPanel, "Swipe View");

		// Minimum size of window
		setMinimumSize(new Dimension(800, 800));
		// Close app when window is closed
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// App name at the top
		setTitle("Adopt Me");

		// Menu //
		// menuView = new JPanel();

		// Swiping //
		// swipeView = new SwipeView();

		// Likes Library //
		// likesView = new JPanel();

		setVisible(true);
	}
}