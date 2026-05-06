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

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.Queue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class App
{
	public static void main(String[] args) throws MalformedURLException
	{
		// TEST PET 1
		LocalDate testDate = LocalDate.of(2026, Month.JANUARY, 25);

		URL felix = new URL(
				"https://images.dog.ceo//breeds//mastiff-tibetan//n02108551_1409.jpg");
		ImageIcon img = new ImageIcon(felix);

		// ImageIcon img = new ImageIcon("./images/kuri.JPG");

		Pet testPet = new Dog("Felix", 3, testDate, "", img);
		testPet.setType("Dog");

		// TEST PET 2
		LocalDate testDate2 = LocalDate.of(2006, Month.DECEMBER, 4);
		Pet testPet2 = new Cat("Daisy", 15, testDate2, "", null);
		testPet2.setType("Cat");

		// TEST PET 3
		LocalDate testDate3 = LocalDate.of(2006, Month.AUGUST, 22);
		Pet testPet3 = new Bird("Ole", 15, testDate3, "", null);
		testPet3.setType("Bird");

		// Create test repository
		LinkedList<Pet> petList = new LinkedList<Pet>();
		PetRepository petRepo = new PetRepository(petList);

		// Add testPets to the test repository
		petRepo.addPet(testPet);
		petRepo.addPet(testPet2);
		petRepo.addPet(testPet3);

		AppView appView = new AppView(petRepo);
	}
}