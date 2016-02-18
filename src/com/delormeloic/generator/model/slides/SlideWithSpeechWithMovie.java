package com.delormeloic.generator.model.slides;

import org.json.JSONObject;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

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
	 * The movie.
	 */
	private final StringProperty movie;

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
		super(CLASS_FOR_NAME, name);
		this.movie = new SimpleStringProperty(data.getString(MOVIE_ATTRIBUTE));
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
		this.movie = new SimpleStringProperty(IConstants.DEFAULT_TEXT);
	}

	/**
	 * Get the movie.
	 * 
	 * @return The movie.
	 */
	public String getMovie()
	{
		return this.movie.get();
	}

	/**
	 * Get the movie property.
	 * 
	 * @return The movie property.
	 */
	public StringProperty getMovieProperty()
	{
		return this.movie;
	}

	/**
	 * @see com.delormeloic.generator.model.slides.SlideWithSpeechWithContent#getContentAttribute()
	 */
	@Override
	public String getContentAttribute()
	{
		return MOVIE_ATTRIBUTE;
	}

	/**
	 * @see com.delormeloic.generator.model.slides.SlideWithSpeechWithContent#getContentValue()
	 */
	@Override
	public String getContentValue()
	{
		return getMovie();
	}
}