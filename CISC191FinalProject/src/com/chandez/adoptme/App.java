/**
 * Lead Author(s):
 * 
 * @author Rumi Chadwick
 * @author Ale Hernandez
 *
 *         Other Contributors:
 *         Alex Chow
 *
 *         Version: 2026-05-06
 */
package com.chandez.adoptme;

import com.chandez.adoptme.domain.*;
import com.chandez.adoptme.ui.*;

import fileReaders.CSVPetReader;

import java.time.LocalDate;
import java.time.Month;
import javax.swing.ImageIcon;

public class App
{
	public static void main(String[] args)
	{
		// TEST PET 1
		// LocalDate testDate = LocalDate.of(2026, Month.JANUARY, 25);
		//
		// ImageIcon felixPic = new ImageIcon("./images/kuri.JPG");
		//
		// Pet testPet = new Dog("Felix", 3, "M", testDate,
		// "This is the bio paragraph for this Pet \nWe don't have a real one
		// yet :(",
		// felixPic);
		// testPet.setType("Dog");
		//
		// // TEST PET 2
		// LocalDate testDate2 = LocalDate.of(2006, Month.DECEMBER, 4);
		// ImageIcon daisyPic = new ImageIcon("./images/daisy.jpeg");
		// Pet testPet2 = new Cat("Daisy", 15, "F", testDate2, "", daisyPic);
		// testPet2.setType("Cat");
		//
		// // TEST PET 3
		// LocalDate testDate3 = LocalDate.of(2006, Month.AUGUST, 22);
		// ImageIcon olePic = new ImageIcon("./images/six_seven.JPG");
		// Pet testPet3 = new Bird("Ole", 15, "M", testDate3, "", olePic);
		// testPet3.setType("Bird");

		// Create repository
		CSVPetReader reader = new CSVPetReader();
		PetRepository petRepo = new PetRepository(
				reader.readFile("./Pets.txt"));

		// Add testPets to the test repository
		// petRepo.addPet(testPet);
		// petRepo.addPet(testPet2);
		// petRepo.addPet(testPet3);

		new SwipeView(petRepo);
	}
}