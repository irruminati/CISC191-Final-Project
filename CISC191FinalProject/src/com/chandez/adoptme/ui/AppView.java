package com.chandez.adoptme.ui;

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
	private JPanel menuPage;
	private SwipeView swipePage;

	private JPanel likesPage;
	private JButton backButton;
	private JPanel likes;

	public AppView()
	{
		super();
		setMinimumSize(new Dimension(800, 800)); // Minimum size of window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close app when
														// window is
														// closed
		setTitle("Adopt Me"); // App name at the top

		// Menu //
		menuPage = new JPanel();

		// Swiping //
		// swipePage = new SwipeView();

		// Likes Library //
		likesPage = new JPanel();
	}

	public void setSwipePage(SwipeView swipeView)
	{
		swipePage = swipeView;
	}
}