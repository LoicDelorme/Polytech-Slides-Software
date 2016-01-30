package com.delormeloic.generator.model.slides;

import org.json.JSONObject;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.text.Font;

/**
 * This class represents a footer.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class Footer implements ISerializable
{
	/**
	 * The left image attribute.
	 */
	public static final String LEFT_IMAGE_ATTRIBUTE = "leftImage";

	/**
	 * The middle text attribute.
	 */
	public static final String MIDDLE_TEXT_ATTRIBUTE = "middleText";

	/**
	 * The middle text font attribute.
	 */
	public static final String MIDDLE_TEXT_FONT_ATTRIBUTE = "middleTextFont";

	/**
	 * The right image attribute.
	 */
	public static final String RIGHT_IMAGE_ATTRIBUTE = "rightImage";

	/**
	 * The left image.
	 */
	private final StringProperty leftImage;

	/**
	 * The middle text.
	 */
	private final StringProperty middleText;

	/**
	 * The middle text font.
	 */
	private final ObjectProperty<Font> middleTextFont;

	/**
	 * The right image.
	 */
	private final StringProperty rightImage;

	/**
	 * Create a footer.
	 * 
	 * @param data
	 *            The data.
	 */
	public Footer(JSONObject data)
	{
		this.leftImage = new SimpleStringProperty(data.getString(LEFT_IMAGE_ATTRIBUTE));
		this.middleText = new SimpleStringProperty(data.getString(MIDDLE_TEXT_ATTRIBUTE));
		this.middleTextFont = new SimpleObjectProperty<Font>(new Font(data.getString(MIDDLE_TEXT_FONT_ATTRIBUTE), IConstants.DEFAULT_FONT_SIZE));
		this.rightImage = new SimpleStringProperty(data.getString(RIGHT_IMAGE_ATTRIBUTE));
	}

	/**
	 * Create a footer.
	 */
	public Footer()
	{
		this.leftImage = new SimpleStringProperty(IConstants.DEFAULT_TEXT);
		this.middleText = new SimpleStringProperty(IConstants.DEFAULT_TEXT);
		this.middleTextFont = new SimpleObjectProperty<Font>(IConstants.DEFAULT_FONT);
		this.rightImage = new SimpleStringProperty(IConstants.DEFAULT_TEXT);
	}

	/**
	 * Get the left image.
	 * 
	 * @return The left image.
	 */
	public String getLeftImage()
	{
		return this.leftImage.get();
	}

	/**
	 * Get the left image property.
	 * 
	 * @return The left image property.
	 */
	public StringProperty getLeftImageProperty()
	{
		return this.leftImage;
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
	 * Get the right image.
	 * 
	 * @return The right image.
	 */
	public String getRightImage()
	{
		return this.rightImage.get();
	}

	/**
	 * Get the right image property.
	 * 
	 * @return The right image property.
	 */
	public StringProperty getRightImageProperty()
	{
		return this.rightImage;
	}

	/**
	 * @see com.delormeloic.generator.model.slides.ISerializable#toJSON()
	 */
	@Override
	public JSONObject toJSON()
	{
		final JSONObject data = new JSONObject();
		data.put(LEFT_IMAGE_ATTRIBUTE, getLeftImage());
		data.put(MIDDLE_TEXT_ATTRIBUTE, getMiddleText());
		data.put(MIDDLE_TEXT_FONT_ATTRIBUTE, getMiddleTextFont().getName());
		data.put(RIGHT_IMAGE_ATTRIBUTE, getRightImage());

		return data;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		return (getLeftImage().hashCode() + getMiddleText().hashCode() + getMiddleTextFont().hashCode() + getRightImage().hashCode());
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

		if (!(object instanceof Footer))
		{
			return false;
		}

		final Footer footer = (Footer) object;

		if (!getLeftImage().equals(footer.getLeftImage()))
		{
			return false;
		}

		if (!getMiddleText().equals(footer.getMiddleText()))
		{
			return false;
		}

		if (!getMiddleTextFont().equals(footer.getMiddleTextFont()))
		{
			return false;
		}

		if (!getRightImage().equals(footer.getRightImage()))
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