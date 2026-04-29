package com.chandez.adoptme.domain;

import java.awt.image.BufferedImage;
import java.time.LocalDate;

/**
 * Lead Author(s):
 * 
 * @author Rumi Chadwick
 * @author Ale Hernandez
 *
 *         Version: 2026-04-15
 */

public abstract class Pet
{
	private String type;
	private String name;
	private int age;
	private LocalDate intakeDate;
	private String bio;
	private BufferedImage photo;
	private boolean liked;

	public Pet(String name, int age, LocalDate intakeDate, String bio,
			BufferedImage photo)
	{
		this.name = name;
		this.age = age;
		this.intakeDate = intakeDate;
		this.bio = bio;
		this.photo = photo;
	}

	/**
	 * @return the type of animal this Pet is
	 */
	public String getType()
	{
		return type;
	}

	/*
	 * @return the name of the Pet
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @return the age of the Pet
	 */
	public int getAge()
	{
		return age;
	}

	/**
	 * @return the intake date of the Pet
	 */
	public LocalDate getIntakeDate()
	{
		return intakeDate;
	}

	/**
	 * @return the biography of the Pet
	 */
	public String getBio()
	{
		return bio;
	}

	/**
	 * @return the profile photo of the Pet
	 */
	public BufferedImage getPhoto()
	{
		return photo;
	}

	/**
	 * @return whether or not the Pet has been "liked" by the user
	 */
	public boolean isLiked()
	{
		return liked;
	}

	/**
	 * Update the species of the Pet
	 */
	public void setType(String type)
	{
		this.type = type;
	}

	/**
	 * Update the age of the Pet
	 */
	public void setAge(int age)
	{
		this.age = age;
	}

	/**
	 * Update the biography of the Pet
	 * 
	 * @param bio the new biography
	 */
	public void setBio(String bio)
	{
		this.bio = bio;
	}

	/**
	 * Update the profile photo of the Pet
	 * 
	 * @param photo the new profile picture
	 */
	public void setPhoto(BufferedImage photo)
	{
		this.photo = photo;
	}

	/**
	 * Like/Unlike the Pet to add or remove it from the liked library
	 * 
	 * @param liked true if Pet is liked, false otherwise
	 */
	public void setLiked(boolean liked)
	{
		this.liked = liked;
	}
}