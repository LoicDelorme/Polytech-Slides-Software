package com.delormeloic.generator.model.slides;

import org.json.JSONObject;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.text.Font;

/**
 * This class represents an header.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class Header implements ISerializable
{
	/**
	 * The middle text attribute.
	 */
	public static final String MIDDLE_TEXT_ATTRIBUTE = "middleText";

	/**
	 * The middle text font attribute.
	 */
	public static final String MIDDLE_TEXT_FONT_ATTRIBUTE = "middleTextFont";

	/**
	 * The middle text.
	 */
	private final StringProperty middleText;

	/**
	 * The middle text font.
	 */
	private final ObjectProperty<Font> middleTextFont;

	/**
	 * Create an header.
	 * 
	 * @param data
	 *            The data.
	 */
	public Header(JSONObject data)
	{
		this.middleText = new SimpleStringProperty(data.getString(MIDDLE_TEXT_ATTRIBUTE));
		this.middleTextFont = new SimpleObjectProperty<Font>(new Font(data.getString(MIDDLE_TEXT_FONT_ATTRIBUTE), IConstants.DEFAULT_FONT_SIZE));
	}

	/**
	 * Create an header.
	 */
	public Header()
	{
		this.middleText = new SimpleStringProperty(IConstants.DEFAULT_TEXT);
		this.middleTextFont = new SimpleObjectProperty<Font>(IConstants.DEFAULT_FONT);
	}

	/**
	 * Get the middle text.
	 * 
	 * @return The middle text.
	 */
	public String getMiddleText()
	{
		return this.middleText.get();
	}

	/**
	 * Get the middle text property.
	 * 
	 * @return The middle text property.
	 */
	public StringProperty getMiddleTextProperty()
	{
		return this.middleText;
	}

	/**
	 * Get the middle text font.
	 * 
	 * @return The middle text font.
	 */
	public Font getMiddleTextFont()
	{
		return this.middleTextFont.get();
	}

	/**
	 * Get the middle text font property.
	 * 
	 * @return The middle text font property.
	 */
	public ObjectProperty<Font> getMiddleTextFontProperty()
	{
		return this.middleTextFont;
	}

	/**
	 * @see com.delormeloic.generator.model.slides.ISerializable#toJSON()
	 */
	@Override
	public JSONObject toJSON()
	{
		final JSONObject data = new JSONObject();
		data.put(MIDDLE_TEXT_ATTRIBUTE, getMiddleText());
		data.put(MIDDLE_TEXT_FONT_ATTRIBUTE, getMiddleTextFont().getName());

		return data;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		return (getMiddleText().hashCode() + getMiddleTextFont().hashCode());
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

		if (!(object instanceof Header))
		{
			return false;
		}

		final Header header = (Header) object;

		if (!getMiddleText().equals(header.getMiddleText()))
		{
			return false;
		}

		if (!getMiddleTextFont().equals(header.getMiddleTextFont()))
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