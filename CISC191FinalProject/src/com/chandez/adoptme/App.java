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

import java.time.LocalDate;
import java.time.Month;

import com.chandez.adoptme.domain.Dog;
import com.chandez.adoptme.ui.AppView;
import com.chandez.adoptme.ui.SwipeView;

public class App
{
	public static void main(String[] args)
	{
		LocalDate testDate = LocalDate.of(2026, Month.JANUARY, 25);
		Pet testPet = new Dog("Felix", 3, testDate, "", null);
		testPet.setType("Dog");
		
		AppView appView = new AppView();
		SwipeView swipeView = new SwipeView(testPet);
		appView.setSwipePage(swipeView);
		appView.add(swipeView);
	}
}