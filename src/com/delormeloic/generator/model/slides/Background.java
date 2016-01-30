package com.delormeloic.generator.model.slides;

import org.json.JSONObject;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.paint.Color;

/**
 * This class represents a background.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class Background implements ISerializable
{
	/**
	 * The background red attribute.
	 */
	public static final String BACKGROUND_RED_ATTRIBUTE = "backgroundRed";

	/**
	 * The background green attribute.
	 */
	public static final String BACKGROUND_GREEN_ATTRIBUTE = "backgroundGreen";

	/**
	 * The background blue attribute.
	 */
	public static final String BACKGROUND_BLUE_ATTRIBUTE = "backgroundBlue";

	/**
	 * The background color.
	 */
	private final ObjectProperty<Color> backgroundColor;

	/**
	 * Create a background.
	 * 
	 * @param data
	 *            The data.
	 */
	public Background(JSONObject data)
	{
		this.backgroundColor = new SimpleObjectProperty<Color>(new Color(data.getDouble(BACKGROUND_RED_ATTRIBUTE), data.getDouble(BACKGROUND_GREEN_ATTRIBUTE), data.getDouble(BACKGROUND_BLUE_ATTRIBUTE), 1.0));
	}

	/**
	 * Create a background.
	 */
	public Background()
	{
		this.backgroundColor = new SimpleObjectProperty<Color>(IConstants.DEFAULT_BACKGROUND_COLOR);
	}

	/**
	 * Get the background color.
	 * 
	 * @return The background color.
	 */
	public Color getBackgroundColor()
	{
		return this.backgroundColor.get();
	}

	/**
	 * Get the background color property.
	 * 
	 * @return The background color property.
	 */
	public ObjectProperty<Color> getBackgroundColorProperty()
	{
		return this.backgroundColor;
	}

	/**
	 * @see com.delormeloic.generator.model.slides.ISerializable#toJSON()
	 */
	@Override
	public JSONObject toJSON()
	{
		final JSONObject data = new JSONObject();
		data.put(BACKGROUND_RED_ATTRIBUTE, getBackgroundColor().getRed());
		data.put(BACKGROUND_GREEN_ATTRIBUTE, getBackgroundColor().getGreen());
		data.put(BACKGROUND_BLUE_ATTRIBUTE, getBackgroundColor().getBlue());

		return data;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		return (getBackgroundColor().hashCode());
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object object)
	{
		if (object == null)
		{
			return false;
		}

		if (this == object)
		{
			return true;
		}

		if (!(object instanceof Background))
		{
			return false;
		}

		final Background background = (Background) object;

		if (!getBackgroundColor().equals(background.getBackgroundColor()))
		{
			return false;
		}

		return true;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return toJSON().toString();
	}
}