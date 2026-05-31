package com.chandez.adoptme.domain;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Lead Author(s):
 * 
 * @author Rumi Chadwick
 * 
 *         Version date: 2026-04-27
 * 
 *         Purpose: PetRepository holds a database of Pets with a method to pass
 *         through them in one direction.
 */
public class PetRepository
{
	private Queue<Pet> petList;

	/**
	 *  Create a new PetRepository from a given LinkedList of Pets
	 *  
	 * @param petList the list of pets
	 */
	public PetRepository(LinkedList<Pet> petList)
	{
		this.petList = petList;
	}

	/**
	 * Add a Pet to the end of the list, eventually this will be called from the
	 * file reader and create pets from text info
	 * 
	 * @param pet the Pet to be added
	 */
	public void addPet(Pet pet)
	{
		petList.add(pet);
	}

	/**
	 * Append a list of Pets to the end of the list, this is called from the
	 * file reader that creates the list
	 * 
	 * @param list the list of Pets to be added
	 */
	public void addAllPets(LinkedList<Pet> list)
	{
		petList.addAll(list);
	}

	/**
	 * @return the current Pet in the swiping list
	 */
	public Pet getCurrPet()
	{
		return petList.peek();
	}

	/**
	 * Move to the next Pet, and move the current Pet to the end of the list.
	 * Also returns the new Pet at the top of the list.
	 * 
	 * @param liked true if the current Pet was liked by the user, false
	 *              otherwise
	 * @return the current Pet in the list
	 */
	public Pet nextPet(boolean liked)
	{
		// Remove the current Pet from the top of the list
		Pet currPet = petList.remove();

		// If the user "liked" the Pet, add it back to the end of the list
		if (liked)
		{
			petList.add(currPet);
		}

		// Return the next Pet in the list
		return petList.peek();
	}

	/**
	 * Check if there is only one Pet left in the list
	 * 
	 * @return true if list has exactly one Pet, false otherwise
	 */
	public boolean onePetLeft()
	{
		return petList.size() == 1;
	}
}