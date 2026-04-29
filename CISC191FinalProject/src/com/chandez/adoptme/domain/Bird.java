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
*
* Version: 2026-04-29
*/
package com.chandez.adoptme.domain;

import java.awt.image.BufferedImage;
import java.time.LocalDate;

/**
 * Purpose: The reponsibility of Bird is ...
 *
 * Bird is-a ...
 * Bird is ...
 */
public class Bird extends Pet
{	
	/**
	 * Purpose: 
	 * @param species
	 * @param name
	 * @param age
	 * @param intakeDate
	 * @param bio
	 * @param photo
	 */
	public Bird(String name, int age, LocalDate intakeDate,
			String bio, BufferedImage photo)
	{
		super(name, age, intakeDate, bio, photo);
	}
}