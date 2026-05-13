package com.chandez.adoptme.other;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.ImageIcon;

import com.chandez.adoptme.domain.*;

/**
 * Lead Author(s):
 * 
 * @author Rumi Chadwick
 * @author Ale Hernandez
 *
 *         Version: 2026-05-04
 */

/**
 * Purpose: The responsibility of CSVPetReader is ...
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
		LinkedList<Pet> list = new LinkedList<Pet>();
		File file = new File(fileName);
		try (Scanner scanner = new Scanner(file))
		{
			while (scanner.hasNext())
			{
				String line = scanner.nextLine();
				list.add(parsePetFromLine(line));
			}
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			System.out.println("Couldn't find file " + fileName);
		}
		return list;
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
	private Pet createPet(String type, String name, int age, String sex,
			LocalDate intakeDate, String bio, ImageIcon pic)
	{
		if (pic == null)
		{
			System.out.println("Couldn't find image for " + name);
		}
		switch (type)
		{
			case "Dog":
				return new Dog(name, age, sex, intakeDate, bio, pic);
			case "Cat":
				return new Cat(name, age, sex, intakeDate, bio, pic);
			case "Bird":
				return new Bird(name, age, sex, intakeDate, bio, pic);
			default:
				return null;
		}
	}

	/**
	 * Helper method to separate out Pet fields from a single line of the file
	 * 
	 * @param line the line of the file to turn into a Pet
	 * @return the Pet object created from the line
	 */
	private Pet parsePetFromLine(String line)
	{
		// Create an array of the fields, separated by commas
		String[] fields = line.split(",");

		// One by one, create the fields
		String type = fields[0].trim();
		String name = fields[1].trim();
		int age = Integer.parseInt(fields[2].trim());
		String sex = fields[3].trim();
		if (sex.equalsIgnoreCase("F"))
		{
			sex = "Female";
		}
		else
		{
			sex = "Male";
		}
		LocalDate intakeDate = LocalDate.parse(fields[3].trim());
		String bio = fields[4].trim();
		String picName = fields[5].trim();

		// Create an image from the parsed file name
		ImageIcon pic = new ImageIcon("./images/" + picName);

		// Print message if the picture wasn't properly created
		if (pic == null)
		{
			System.out.println("Couldn't find image " + picName);
		}

		return createPet(type, name, age, sex, intakeDate, bio, pic);
	}
}
