package com.chandez.adoptme.other;

import java.awt.image.BufferedImage;
import java.io.File;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;

import com.chandez.adoptme.domain.*;

/**
 * Lead Author(s):
 * 
 * @author Rumi Chadwick
 *
 *         Version: 2026-05-04
 */

/**
 * Purpose: The reponsibility of CSVPetReader is ...
 *
 * CSVPetReader is-a ...
 * CSVPetReader is ...
 */
public class CSVPetReader
{
	public CSVPetReader()
	{

	}

	public LinkedList<Pet> readFile(String fileName)
	{
		File file = new File(fileName);
		// TODO
		return null;
	}

	/**
	 * Helper method to create a Pet object from the data read from the file
	 * 
	 * @param type       what kind of animal the Pet is
	 * @param name       the name of the Pet
	 * @param age        the Age of the Pet
	 * @param intakeDate the date the Pet was taken in by the shelter
	 * @param bio        a short bit of text describing the Pet
	 * @return
	 */
	private Pet createPet(String type, String name, int age,
			LocalDate intakeDate, String bio)
	{
		switch (type)
		{
			case "Dog":
				return new Dog(name, age, intakeDate, bio, null);
			case "Cat":
				return new Cat(name, age, intakeDate, bio, null);
			case "Bird":
				return new Bird(name, age, intakeDate, bio, null);
			default:
				return null;
		}
	}

	private void parseLine()
	{
		
	}
}