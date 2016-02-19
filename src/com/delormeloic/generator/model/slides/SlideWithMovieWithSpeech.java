package com.delormeloic.generator.model.slides;

import org.json.JSONObject;

/**
 * This class represents a slide with a movie with a speech.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class SlideWithMovieWithSpeech extends SlideWithContentWithSpeech
{
	/**
	 * The class for name.
	 */
	public static final String CLASS_FOR_NAME = "SlideWithMovieWithSpeech";

	/**
	 * The movie attribute.
	 */
	public static final String MOVIE_ATTRIBUTE = "movie";

	/**
	 * Create a slide with a movie with a speech.
	 * 
	 * @param name
	 *            The name.
	 * @param data
	 *            The data.
	 */
	public SlideWithMovieWithSpeech(String name, JSONObject data)
	{
		super(CLASS_FOR_NAME, name, data);
	}

	/**
	 * Create a slide with a movie with a speech.
	 * 
	 * @param name
	 *            The name.
	 */
	public SlideWithMovieWithSpeech(String name)
	{
		super(CLASS_FOR_NAME, name);
	}

	/**
	 * @see com.delormeloic.generator.model.slides.SlideWithContentWithSpeech#getContentAttribute()
	 */
	@Override
	public String getContentAttribute()
	{
		return MOVIE_ATTRIBUTE;
	}
}