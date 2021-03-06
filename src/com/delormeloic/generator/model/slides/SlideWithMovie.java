package com.delormeloic.generator.model.slides;

import org.json.JSONObject;

/**
 * This class represents a slide with a movie.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class SlideWithMovie extends SlideWithContent
{
	/**
	 * The class for name.
	 */
	public static final String CLASS_FOR_NAME = "SlideWithMovie";

	/**
	 * The movie attribute.
	 */
	public static final String MOVIE_ATTRIBUTE = "movie";

	/**
	 * Create a slide with a movie.
	 * 
	 * @param name
	 *            The name.
	 * @param data
	 *            The data.
	 */
	public SlideWithMovie(String name, JSONObject data)
	{
		super(CLASS_FOR_NAME, name, data);
	}

	/**
	 * Create a slide with a movie.
	 * 
	 * @param name
	 *            The name.
	 */
	public SlideWithMovie(String name)
	{
		super(CLASS_FOR_NAME, name);
	}

	/**
	 * @see com.delormeloic.generator.model.slides.SlideWithContent#getContentAttribute()
	 */
	@Override
	public String getContentAttribute()
	{
		return MOVIE_ATTRIBUTE;
	}
}