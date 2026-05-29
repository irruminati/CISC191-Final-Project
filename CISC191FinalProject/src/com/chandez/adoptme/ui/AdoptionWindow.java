/**
 * Lead Author(s):
 * 
 * @author Ale Hernandez
 * @author Rumi Chadwick
 *
 *         Other Contributors:
 *         Alex Chow
 * 
 *         Version: 2026-05-05
 */
package com.chandez.adoptme.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.chandez.adoptme.controllers.AdoptionWindowController;

/**
 * Purpose: The responsibility of AdoptionWindow is ...
 *
 * AdoptionWindow is-a ...
 * AdoptionWindow is ...
 */
public class AdoptionWindow extends JFrame
{
	private JPanel userInfo;
	private JPanel namePanel;
	private JPanel phonePanel;
	private JPanel addressPanel;
	private JPanel submitPanel;

	private JLabel titleLabel;
	private JLabel userNameLabel;
	private JLabel userPhoneLabel;
	private JLabel userAddressLabel;
	private JLabel errorLabel;

	private JTextField inputName;
	private JTextField inputPhone;
	private JTextField inputAddress;

	private JButton submitButton;

	private static final short BORDER_PADDING = 30;
	private static final short TITLE_FONT_SIZE = 24;
	private static final short FIELD_CHAR_WIDTH = 15;

	public AdoptionWindow() //This will be the window that pops up after one pet is left. 
	{
		super();

		//Title of the window 
		setTitle("Adopt me");
		//Minimum size of window 
		setMinimumSize(new Dimension(400, 350));
		//Close app when window is closed
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Main panel //
		
		userInfo = new JPanel();
		BoxLayout boxLayout = new BoxLayout(userInfo, BoxLayout.Y_AXIS);
		userInfo.setLayout(boxLayout);
		userInfo.setBorder(
				javax.swing.BorderFactory.createEmptyBorder(BORDER_PADDING,
						BORDER_PADDING, BORDER_PADDING, BORDER_PADDING));

		// Label at the the top 
		titleLabel = new JLabel("User Information");
		titleLabel.setAlignmentX(CENTER_ALIGNMENT);
		titleLabel
				.setFont(new Font(Font.SANS_SERIF, Font.BOLD, TITLE_FONT_SIZE));

		// Name Panel //
		namePanel = new JPanel();
		userNameLabel = new JLabel("Name");
		inputName = new JTextField(FIELD_CHAR_WIDTH);
		namePanel.add(userNameLabel);
		namePanel.add(inputName);

		// Phone Panel //
		phonePanel = new JPanel();
		userPhoneLabel = new JLabel("Phone Number");
		inputPhone = new JTextField(FIELD_CHAR_WIDTH);
		phonePanel.add(userPhoneLabel);
		phonePanel.add(inputPhone);

		// Address Panel //
		addressPanel = new JPanel();
		userAddressLabel = new JLabel("Your Address");
		inputAddress = new JTextField(FIELD_CHAR_WIDTH);
		addressPanel.add(userAddressLabel);
		addressPanel.add(inputAddress);

		// Label/Message that will pop if there was a mistake with the information submitted.
		errorLabel = new JLabel(" ");
		errorLabel.setForeground(Color.RED);
		errorLabel.setAlignmentX(CENTER_ALIGNMENT);

		// Submit Panel with submit button.
		submitPanel = new JPanel();
		submitButton = new JButton("Submit");
		submitPanel.add(submitButton);

		//Adding everything to the main Panel
		userInfo.add(titleLabel);
		userInfo.add(namePanel);
		userInfo.add(phonePanel);
		userInfo.add(addressPanel);
		userInfo.add(submitPanel);
		userInfo.add(errorLabel);

		add(userInfo);

		setVisible(true);
	}

	// SETTERS AND GETTERS //
	
	public String getInputAddress()
	{
		return inputAddress.getText();
	}

	public String getInputPhone()
	{
		return inputPhone.getText();
	}

	public String getInputName()
	{
		return inputName.getText();
	}

	public JButton getSubmitButton()
	{
		return submitButton;
	}

	// Setting the errorLabel to whichever error occurred (e.g Phone can only have numbers).
	public void showError(String message)
	{
		errorLabel.setText(message);
	}

	//Clearing the error after it was fixed. 
	public void clearError()
	{
		errorLabel.setText(" ");
	}

	//Closing the window after information was submitted or closed by the user. 
	public void closeWindow()
	{
		dispose();
	}

}