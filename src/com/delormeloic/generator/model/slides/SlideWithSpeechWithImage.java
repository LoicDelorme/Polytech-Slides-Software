package com.delormeloic.generator.model.slides;

import org.json.JSONObject;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * This class represents a slide with a speech with an image.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class SlideWithSpeechWithImage extends SlideWithSpeechWithContent
{
	/**
	 * The class for name.
	 */
	public static final String CLASS_FOR_NAME = "SlideWithSpeechWithImage";

	/**
	 * The image attribute.
	 */
	public static final String IMAGE_ATTRIBUTE = "image";

	/**
	 * The image.
	 */
	private final StringProperty image;

	/**
	 * Create a slide with a speech with an image.
	 * 
	 * @param name
	 *            The name.
	 * @param data
	 *            The data.
	 */
	public SlideWithSpeechWithImage(String name, JSONObject data)
	{
		super(CLASS_FOR_NAME, name);
		this.image = new SimpleStringProperty(data.getString(IMAGE_ATTRIBUTE));
	}

	/**
	 * Create a slide with a speech with an image.
	 * 
	 * @param name
	 *            The name.
	 */
	public SlideWithSpeechWithImage(String name)
	{
		super(CLASS_FOR_NAME, name);
		this.image = new SimpleStringProperty(IConstants.DEFAULT_TEXT);
	}

	/**
	 * Get the image.
	 * 
	 * @return The image.
	 */
	public String getImage()
	{
		return this.image.get();
	}

	/**
	 * Get the image property.
	 * 
	 * @return The image property.
	 */
	public StringProperty getImageProperty()
	{
		return this.image;
	}

	/**
	 * @see com.delormeloic.generator.model.slides.SlideWithSpeechWithContent#getContentAttribute()
	 */
	@Override
	public String getContentAttribute()
	{
		return IMAGE_ATTRIBUTE;
	}

	/**
	 * @see com.delormeloic.generator.model.slides.SlideWithSpeechWithContent#getContentValue()
	 */
	@Override
	public String getContentValue()
	{
		return getImage();
	}
}