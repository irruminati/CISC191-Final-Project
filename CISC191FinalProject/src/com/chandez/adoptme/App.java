/**
 * Lead Author(s):
 * 
 * @author rumichadwick; student ID
 * @author Full name; student ID
 *         <<Add additional lead authors here>>
 *
 *         Other Contributors:
 *         Full name; student ID or contact information if not in class
 *         <<Add additional contributors (mentors, tutors, friends) here, with
 *         contact information>>
 *
 *         References:
 *         Morelli, R., & Walde, R. (2016).
 *         Java, Java, Java: Object-Oriented Problem Solving
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 *
 *         <<Add more references here>>
 *
 *         Version: 2026-04-29
 */
package com.chandez.adoptme;

import com.chandez.adoptme.domain.Pet;
import com.chandez.adoptme.domain.PetRepository;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JFrame;

import com.chandez.adoptme.domain.Bird;
import com.chandez.adoptme.domain.Cat;
import com.chandez.adoptme.domain.Dog;
import com.chandez.adoptme.ui.AppView;
import com.chandez.adoptme.ui.SwipeView;

public class App
{
	public static void main(String[] args)
	{
		// TEST PET 1
		LocalDate testDate = LocalDate.of(2026, Month.JANUARY, 25);
		Pet testPet = new Dog("Felix", 3, testDate, "", null);
		testPet.setType("Dog");

		// TEST PET 2
		LocalDate testDate2 = LocalDate.of(2006, Month.DECEMBER, 4);
		Pet testPet2 = new Cat("Daisy", 15, testDate2, "", null);
		testPet2.setType("Cat");

		// TEST PET 3
		LocalDate testDate3 = LocalDate.of(2006, Month.AUGUST, 22);
		Pet testPet3 = new Bird("Ole", 15, testDate3, "", null);
		testPet3.setType("Bird");

		LinkedList<Pet> petList = new LinkedList<Pet>();

		PetRepository petRepo = new PetRepository(petList);

		petRepo.addPet(testPet);
		petRepo.addPet(testPet2);
		petRepo.addPet(testPet3);

		AppView appView = new AppView();
		SwipeView swipeView = new SwipeView(testPet);
		appView.setSwipePage(swipeView);

		appView.updateUI(testPet3);
	}
}