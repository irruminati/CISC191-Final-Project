package com.chandez.adoptme.ui;

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
	private JPanel menuPage;
	private SwipeView swipePage;

	private JPanel likesPage;
	private JButton backButton;
	private JPanel likes;

	public AppView()
	{
		super();
		
		// Minimum size of window
		setMinimumSize(new Dimension(800, 800)); 
		// Close app when window is closed
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		// App name at the top
		setTitle("Adopt Me"); 

		setLayout(new CardLayout());
		
		// Menu //
		menuPage = new JPanel();

		// Swiping //
		// swipePage = new SwipeView();

		// Likes Library //
		likesPage = new JPanel();
		
		setVisible(true);
	}

	public void setSwipePage(SwipeView swipeView)
	{
		swipePage = swipeView;
		
		add(swipeView);
	}
}