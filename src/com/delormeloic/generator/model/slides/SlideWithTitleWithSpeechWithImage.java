package com.delormeloic.generator.model.slides;

import org.json.JSONObject;

/**
 * This class represents a slide with a title with a speech with an image.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class SlideWithTitleWithSpeechWithImage extends SlideWithTitleWithSpeechWithContent
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
	 * Create a slide with a title with a speech with an image.
	 * 
	 * @param name
	 *            The name.
	 * @param data
	 *            The data.
	 */
	public SlideWithTitleWithSpeechWithImage(String name, JSONObject data)
	{
		super(CLASS_FOR_NAME, name, data);
	}

	/**
	 * Create a slide with a title with a speech with an image.
	 * 
	 * @param name
	 *            The name.
	 */
	public SlideWithTitleWithSpeechWithImage(String name)
	{
		super(CLASS_FOR_NAME, name);
	}

	/**
	 * @see com.delormeloic.generator.model.slides.SlideWithTitleWithSpeechWithContent#getContentAttribute()
	 */
	@Override
	public String getContentAttribute()
	{
		return IMAGE_ATTRIBUTE;
	}
}