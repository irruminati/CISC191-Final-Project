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
	private String name;
	private int age;
	private LocalDate intakeDate;
	private String bio;
	private BufferedImage photo;

	public Pet(String name, int age, LocalDate intakeDate, String bio,
			BufferedImage photo)
	{
		this.name = name;
		this.age = age;
		this.intakeDate = intakeDate;
		this.bio = bio;
		this.photo = photo;
	}
}