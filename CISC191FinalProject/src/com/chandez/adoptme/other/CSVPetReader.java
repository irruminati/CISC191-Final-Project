package com.chandez.adoptme.other;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;

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
		LocalDate intakeDate = LocalDate.parse(fields[3].trim());
		String bio = fields[4].trim();

		return createPet(type, name, age, intakeDate, bio);
	}
}
