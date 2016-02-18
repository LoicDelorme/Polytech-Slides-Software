package com.delormeloic.generator.model.slides;

import org.json.JSONObject;

/**
 * This class represents a slide with a speech with a movie.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class SlideWithSpeechWithMovie extends SlideWithSpeechWithContent
{
	/**
	 * The class for name.
	 */
	public static final String CLASS_FOR_NAME = "SlideWithSpeechWithMovie";

	/**
	 * The movie attribute.
	 */
	public static final String MOVIE_ATTRIBUTE = "movie";

	/**
	 * Create a slide with a speech with a movie.
	 * 
	 * @param name
	 *            The name.
	 * @param data
	 *            The data.
	 */
	public SlideWithSpeechWithMovie(String name, JSONObject data)
	{
		super(CLASS_FOR_NAME, name, data);
	}

	/**
	 * Create a slide with a speech with a movie.
	 * 
	 * @param name
	 *            The name.
	 */
	public SlideWithSpeechWithMovie(String name)
	{
		super(CLASS_FOR_NAME, name);
	}

	/**
	 * @see com.delormeloic.generator.model.slides.SlideWithSpeechWithContent#getContentAttribute()
	 */
	@Override
	public String getContentAttribute()
	{
		return MOVIE_ATTRIBUTE;
	}
}