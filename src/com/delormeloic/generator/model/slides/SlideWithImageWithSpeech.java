package com.delormeloic.generator.model.slides;

import org.json.JSONObject;

/**
 * This class represents a slide with an image with a speech.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class SlideWithImageWithSpeech extends SlideWithContentWithSpeech
{
	/**
	 * The class for name.
	 */
	public static final String CLASS_FOR_NAME = "SlideWithImageWithSpeech";

	/**
	 * The image attribute.
	 */
	public static final String IMAGE_ATTRIBUTE = "image";

	/**
	 * Create a slide with an image with a speech.
	 * 
	 * @param name
	 *            The name.
	 * @param data
	 *            The data.
	 */
	public SlideWithImageWithSpeech(String name, JSONObject data)
	{
		super(CLASS_FOR_NAME, name, data);
	}

	/**
	 * Create a slide with an image with a speech.
	 * 
	 * @param name
	 *            The name.
	 */
	public SlideWithImageWithSpeech(String name)
	{
		super(CLASS_FOR_NAME, name);
	}

	/**
	 * @see com.delormeloic.generator.model.slides.SlideWithContentWithSpeech#getContentAttribute()
	 */
	@Override
	public String getContentAttribute()
	{
		return IMAGE_ATTRIBUTE;
	}
}