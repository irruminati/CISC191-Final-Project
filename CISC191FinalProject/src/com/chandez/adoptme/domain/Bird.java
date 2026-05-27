/**
 * Lead Author(s):
 * 
 * @author Rumi Chadwick
 * @author Ale Hernandez
 *
 *         Version: 2026-05-27
 */
package com.chandez.adoptme.domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;

/**
 * A Bird is a one of many kinds of Pets available for adoption
 */
public class Bird extends Pet
{
	/**
	 * @param species
	 * @param name
	 * @param age
	 * @param intakeDate
	 * @param bio
	 * @param photo
	 */
	public Bird(String name, int age, String sex, LocalDate intakeDate,
			String bio, ImageIcon photo)
	{
		super(name, age, sex, intakeDate, bio, photo);
	}

	public String getType()
	{
		return "Bird";
	}

	@Override
	public void playSound()
	{
		String fileName = "tweet.wav";

		new Thread(() -> {
			try
			{
				File audioFile = new File(fileName);

				try (AudioInputStream audioStream = AudioSystem
						.getAudioInputStream(audioFile))
				{
					Clip clip = AudioSystem.getClip();
					clip.open(audioStream);

					// Start playing sound
					clip.start();

					// Let the clip finish
					Thread.sleep(clip.getMicrosecondLength() / 1000);

					// Close the clip
					clip.close();
				}
				catch (FileNotFoundException e)
				{
					System.out.println("Couldn't find file " + fileName);
				}
			}
			catch (Exception e)
			{
				System.out.println("Unable to play audio");
				e.printStackTrace();
			}

			// Test if the method is being called properly
			System.out.println("tweet.");
		}).start();
	}
}