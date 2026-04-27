
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
	private String species;
	private String name;
	private int age;
	private LocalDate intakeDate;
	private String bio;
	private BufferedImage photo;
	private boolean liked;

	public Pet(String species, String name, int age, LocalDate intakeDate,
			String bio, BufferedImage photo)
	{
		this.species = species;
		this.name = name;
		this.age = age;
		this.intakeDate = intakeDate;
		this.bio = bio;
		this.photo = photo;
	}

	/**
	 * @return the type of animal this Pet is
	 */
	public String getSpecies();

	/*
	 * @return the name of the Pet
	 */
	public String getName();

	/**
	 * @return the age of the Pet
	 */
	public int getAge();

	/**
	 * @return the intake date of the Pet
	 */
	public LocalDate getIntakeDate();

	/**
	 * @return the biography of the Pet
	 */
	public String getBio();

	/**
	 * @return the profile photo of the Pet
	 */
	public BufferedImage getPhoto();

	/**
	 * @return whether or not the Pet has been "liked" by the user
	 */
	public boolean isLiked();

	/**
	 * Update the age of the Pet
	 */
	public void setAge(int age);

	/**
	 * Update the biography of the Pet
	 * 
	 * @param bio the new biography
	 */
	public void setBio(String bio);

	/**
	 * Update the profile photo of the Pet
	 * 
	 * @param photo the new profile picture
	 */
	public void setPhoto(BufferedImage photo);

	/**
	 * Like/Unlike the Pet to add or remove it from the liked library
	 * 
	 * @param liked true if Pet is liked, false otherwise
	 */
	public void setLiked(boolean liked);
}