package com.delormeloic.generator.model.slides;

import org.json.JSONObject;

/**
 * This class represents a slide with an image.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class SlideWithImage extends SlideWithContent
{
	/**
	 * The class for name.
	 */
	public static final String CLASS_FOR_NAME = "SlideWithImage";

	/**
	 * The image attribute.
	 */
	public static final String IMAGE_ATTRIBUTE = "image";

	/**
	 * Create a slide with an image.
	 * 
	 * @param name
	 *            The name.
	 * @param data
	 *            The data.
	 */
	public SlideWithImage(String name, JSONObject data)
	{
		super(CLASS_FOR_NAME, name, data);
	}

	/**
	 * Create a slide with an image.
	 * 
	 * @param name
	 *            The name.
	 */
	public SlideWithImage(String name)
	{
		super(CLASS_FOR_NAME, name);
	}

	/**
	 * @see com.delormeloic.generator.model.slides.SlideWithContent#getContentAttribute()
	 */
	@Override
	public String getContentAttribute()
	{
		return IMAGE_ATTRIBUTE;
	}
}