package com.delormeloic.generator.model.slides;

import org.json.JSONObject;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * This class represents a slide with a content.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public abstract class SlideWithContent extends Slide
{
	/**
	 * The header attribute.
	 */
	public static final String HEADER_ATTRIBUTE = "header";

	/**
	 * The footer attribute.
	 */
	public static final String FOOTER_ATTRIBUTE = "footer";

	/**
	 * The header.
	 */
	private final BooleanProperty header;

	/**
	 * The footer.
	 */
	private final BooleanProperty footer;

	/**
	 * The content.
	 */
	private final StringProperty content;

	/**
	 * Create a slide with a content.
	 * 
	 * @param classForName
	 *            The class for name.
	 * @param name
	 *            The name.
	 * @param data
	 *            The data.
	 */
	public SlideWithContent(String classForName, String name, JSONObject data)
	{
		super(classForName, name);
		this.header = new SimpleBooleanProperty(data.getBoolean(HEADER_ATTRIBUTE));
		this.footer = new SimpleBooleanProperty(data.getBoolean(FOOTER_ATTRIBUTE));
		this.content = new SimpleStringProperty(data.getString(getContentAttribute()));
	}

	/**
	 * Create a slide with a content.
	 * 
	 * @param classForName
	 *            The class for name.
	 * @param name
	 *            The name.
	 */
	public SlideWithContent(String classForName, String name)
	{
		super(classForName, name);
		this.header = new SimpleBooleanProperty(IConstants.DEFAULT_HEADER_VALUE);
		this.footer = new SimpleBooleanProperty(IConstants.DEFAULT_FOOTER_VALUE);
		this.content = new SimpleStringProperty(IConstants.DEFAULT_TEXT);
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
	 * Get the content.
	 * 
	 * @return The content.
	 */
	public String getContent()
	{
		return this.content.get();
	}

	/**
	 * Get the content property.
	 * 
	 * @return The content property.
	 */
	public StringProperty getContentProperty()
	{
		return this.content;
	}

	/**
	 * Get the content attribute.
	 * 
	 * @return The content attribute.
	 */
	public abstract String getContentAttribute();

	/**
	 * @see com.delormeloic.generator.model.slides.Slide#getData()
	 */
	@Override
	public JSONObject getData()
	{
		final JSONObject data = new JSONObject();
		data.put(HEADER_ATTRIBUTE, getHeader());
		data.put(FOOTER_ATTRIBUTE, getFooter());
		data.put(getContentAttribute(), getContent());

		return data;
	}
}