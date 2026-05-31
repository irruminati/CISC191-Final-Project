/**
 * Lead Author(s):
 * 
 * @author Rumi Chadwick
 * @author Ale Hernandez
 *
 *         Version: 2026-05-27
 */
package com.chandez.adoptme.domain;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;

import java.io.File;
import java.time.LocalDate;

/**
 * A Dog is a one of many kinds of Pet available for adoption
 */
public class Dog extends Pet
{
	private File audioFile; // File for bark sound effect
	private Clip clip; // Clip of bark sound effect

	/**
	 * @param species
	 * @param name
	 * @param age
	 * @param sex
	 * @param intakeDate
	 * @param bio
	 * @param photo
	 */
	public Dog(String name, int age, String sex, LocalDate intakeDate,
			String bio, ImageIcon photo)
	{
		super(name, age, sex, intakeDate, bio, photo);

		String fileName = "./sounds/bark.wav";
		try
		{
			audioFile = new File(fileName);
			// Pre-load the clip to avoid lag later
			try (AudioInputStream audioStream = AudioSystem
					.getAudioInputStream(audioFile))
			{
				clip = AudioSystem.getClip();
				clip.open(audioStream);
			}
		}
		catch (Exception e)
		{
			System.out.println("Couldn't create file " + fileName);
		}
	}

	public String getType()
	{
		return "Dog";
	}

	@Override
	public void playSound()
	{
		new Thread(() -> {
			try
			{
				// Reset the preloaded clip to the beginning
				clip.stop();
				clip.setFramePosition(0);

				// Play audio
				clip.start();
			}
			catch (Exception e)
			{
				System.out.println("Error playing clip");
				e.printStackTrace();
			}
		}).start();

		// Test if the method is being called properly
		// System.out.println("bark.");
	}
}
