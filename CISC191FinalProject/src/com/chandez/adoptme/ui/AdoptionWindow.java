/**
* Lead Author(s):
* @author alehzp; student ID
* @author Full name; student ID
* <<Add additional lead authors here>>
*
* Other Contributors:
* Full name; student ID or contact information if not in class
* <<Add additional contributors (mentors, tutors, friends) here, with contact information>>
*
* References:
* Morelli, R., & Walde, R. (2016).
* Java, Java, Java: Object-Oriented Problem Solving
* https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
*
* <<Add more references here>>
* Version: 2026-05-05
*/
package com.chandez.adoptme.ui;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Purpose: The reponsibility of AdoptionWindow is ...
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
	
	private JLabel titleLabel;
	private JLabel userNameLabel;
	private JLabel userPhoneLabel;
	private JLabel userAddressLabel; 
	
	private JTextField inputName;
	private JTextField inputPhone;
	private JTextField inputAddress;
	
	private static final short BORDER_PADDING = 30;
	private static final short TITLE_FONT_SIZE = 24;
	private static final short FIELD_CHAR_WIDTH = 15;
	
	public AdoptionWindow() 
	{
		super();
		
		setTitle("Adopt me");
		setMinimumSize(new Dimension(400, 400));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		userInfo = new JPanel();
		BoxLayout boxLayout = new BoxLayout(userInfo, BoxLayout.Y_AXIS);
		userInfo.setLayout(boxLayout);
		userInfo.setBorder(javax.swing.BorderFactory.createEmptyBorder(
				BORDER_PADDING, BORDER_PADDING, BORDER_PADDING, BORDER_PADDING));
		
		titleLabel = new JLabel("User Information");
		titleLabel.setAlignmentX(CENTER_ALIGNMENT);
		titleLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, TITLE_FONT_SIZE));
		
		namePanel = new JPanel();
		userNameLabel = new JLabel("Name");
		inputName = new JTextField(FIELD_CHAR_WIDTH);
		namePanel.add(userNameLabel);
		namePanel.add(inputName);
		
		phonePanel = new JPanel();
		userPhoneLabel = new JLabel("Phone Number");
		inputPhone = new JTextField(FIELD_CHAR_WIDTH);
		phonePanel.add(userPhoneLabel);
		phonePanel.add(inputPhone);
		
		addressPanel = new JPanel();
		userAddressLabel = new JLabel("Your Address");
		inputAddress = new JTextField(FIELD_CHAR_WIDTH);
		addressPanel.add(userAddressLabel);
		addressPanel.add(inputAddress);
		
		userInfo.add(titleLabel);
		userInfo.add(namePanel);
		userInfo.add(phonePanel);
		userInfo.add(addressPanel);
		
		add(userInfo);
		
		setVisible(true);
	}
}
