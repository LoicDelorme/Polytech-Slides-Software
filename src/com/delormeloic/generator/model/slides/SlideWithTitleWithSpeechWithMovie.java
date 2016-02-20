package com.delormeloic.generator.model.slides;

import org.json.JSONObject;

/**
 * This class represents a slide with a title with a speech with a movie.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class SlideWithTitleWithSpeechWithMovie extends SlideWithTitleWithSpeechWithContent
{
	/**
	 * The class for name.
	 */
	public static final String CLASS_FOR_NAME = "SlideWithTitleWithSpeechWithMovie";

	/**
	 * The movie attribute.
	 */
	public static final String MOVIE_ATTRIBUTE = "movie";

	/**
	 * Create a slide with a title with a speech with a movie.
	 * 
	 * @param name
	 *            The name.
	 * @param data
	 *            The data.
	 */
	public SlideWithTitleWithSpeechWithMovie(String name, JSONObject data)
	{
		super(CLASS_FOR_NAME, name, data);
	}

	/**
	 * Create a slide with a title with a speech with a movie.
	 * 
	 * @param name
	 *            The name.
	 */
	public SlideWithTitleWithSpeechWithMovie(String name)
	{
		super(CLASS_FOR_NAME, name);
	}

	/**
	 * @see com.delormeloic.generator.model.slides.SlideWithTitleWithSpeechWithContent#getContentAttribute()
	 */
	@Override
	public String getContentAttribute()
	{
		return MOVIE_ATTRIBUTE;
	}
}