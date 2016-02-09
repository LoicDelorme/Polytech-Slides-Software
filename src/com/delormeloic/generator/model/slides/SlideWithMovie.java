package com.delormeloic.generator.model.slides;

import org.json.JSONObject;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * This class represents a slide with a movie.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class SlideWithMovie extends Slide
{
	/**
	 * The class for name.
	 */
	public static final String CLASS_FOR_NAME = "SlideWithMovie";

	/**
	 * The header attribute.
	 */
	public static final String HEADER_ATTRIBUTE = "header";

	/**
	 * The footer attribute.
	 */
	public static final String FOOTER_ATTRIBUTE = "footer";

	/**
	 * The movie attribute.
	 */
	public static final String MOVIE_ATTRIBUTE = "movie";

	/**
	 * The header.
	 */
	private final BooleanProperty header;

	/**
	 * The footer.
	 */
	private final BooleanProperty footer;

	/**
	 * The movie.
	 */
	private final StringProperty movie;

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
		super(CLASS_FOR_NAME, name);
		this.header = new SimpleBooleanProperty(data.getBoolean(HEADER_ATTRIBUTE));
		this.footer = new SimpleBooleanProperty(data.getBoolean(FOOTER_ATTRIBUTE));
		this.movie = new SimpleStringProperty(data.getString(MOVIE_ATTRIBUTE));
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
		this.header = new SimpleBooleanProperty(IConstants.DEFAULT_HEADER_VALUE);
		this.footer = new SimpleBooleanProperty(IConstants.DEFAULT_FOOTER_VALUE);
		this.movie = new SimpleStringProperty(IConstants.DEFAULT_TEXT);
	}

	/**
	 * Get the header.
	 * 
	 * @return The header.
	 */
	public boolean getHeader()
	{
		return this.header.get();
	}

	/**
	 * Get the header property.
	 * 
	 * @return The header property.
	 */
	public BooleanProperty getHeaderProperty()
	{
		return this.header;
	}

	/**
	 * Get the footer.
	 * 
	 * @return The footer.
	 */
	public boolean getFooter()
	{
		return this.footer.get();
	}

	/**
	 * Get the footer property.
	 * 
	 * @return The footer property.
	 */
	public BooleanProperty getFooterProperty()
	{
		return this.footer;
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
	 * @see com.delormeloic.generator.model.slides.Slide#getData()
	 */
	@Override
	public JSONObject getData()
	{
		final JSONObject data = new JSONObject();
		data.put(HEADER_ATTRIBUTE, getHeader());
		data.put(FOOTER_ATTRIBUTE, getFooter());
		data.put(MOVIE_ATTRIBUTE, getMovie());

		return data;
	}
}