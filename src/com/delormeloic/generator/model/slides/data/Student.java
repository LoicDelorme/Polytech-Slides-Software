package com.delormeloic.generator.model.slides.data;

import org.json.JSONObject;

import com.delormeloic.generator.model.slides.ISerializable;

/**
 * This class represents a student.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class Student implements ISerializable
{
	/**
	 * The lastname attribute.
	 */
	public static final String LASTNAME_ATTRIBUTE = "lastname";

	/**
	 * The firstname attribute.
	 */
	public static final String FIRSTNAME_ATTRIBUTE = "firstname";

	/**
	 * The image attribute.
	 */
	public static final String IMAGE_ATTRIBUTE = "image";

	/**
	 * The lastname.
	 */
	private final String lastname;

	/**
	 * The firstname.
	 */
	private final String firstname;

	/**
	 * The image.
	 */
	private final String image;

	/**
	 * Create a student.
	 * 
	 * @param lastname
	 *            The lastname.
	 * @param firstname
	 *            The firstname.
	 * @param image
	 *            The image.
	 */
	public Student(String lastname, String firstname, String image)
	{
		this.lastname = lastname;
		this.firstname = firstname;
		this.image = image;
	}

	/**
	 * Get the lastname.
	 * 
	 * @return The lastname.
	 */
	public String getLastname()
	{
		return this.lastname;
	}

	/**
	 * Get the firstname.
	 * 
	 * @return The firstname.
	 */
	public String getFirstname()
	{
		return this.firstname;
	}

	/**
	 * Get the image.
	 * 
	 * @return The image.
	 */
	public String getImage()
	{
		return this.image;
	}

	/**
	 * @see com.delormeloic.generator.model.slides.ISerializable#toJSON()
	 */
	@Override
	public JSONObject toJSON()
	{
		final JSONObject data = new JSONObject();
		data.put(LASTNAME_ATTRIBUTE, this.lastname);
		data.put(FIRSTNAME_ATTRIBUTE, this.firstname);
		data.put(IMAGE_ATTRIBUTE, this.image);

		return data;
	}
}