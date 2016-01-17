package com.delormeloic.generator.model.slides;

import org.json.JSONObject;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
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
	 * The left image width attribute.
	 */
	public static final String LEFT_IMAGE_WIDTH_ATTRIBUTE = "leftImageWidth";

	/**
	 * The left image height attribute.
	 */
	public static final String LEFT_IMAGE_HEIGHT_ATTRIBUTE = "leftImageHeight";

	/**
	 * The middle text attribute.
	 */
	public static final String MIDDLE_TEXT_ATTRIBUTE = "middleText";

	/**
	 * The middle text font attribute.
	 */
	public static final String MIDDLE_TEXT_FONT_ATTRIBUTE = "middleTextFont";

	/**
	 * The middle text size attribute.
	 */
	public static final String MIDDLE_TEXT_SIZE_ATTRIBUTE = "middleTextSize";

	/**
	 * The right image attribute.
	 */
	public static final String RIGHT_IMAGE_ATTRIBUTE = "rightImage";

	/**
	 * The right image width attribute.
	 */
	public static final String RIGHT_IMAGE_WIDTH_ATTRIBUTE = "rightImageWidth";

	/**
	 * The right image height attribute.
	 */
	public static final String RIGHT_IMAGE_HEIGHT_ATTRIBUTE = "rightImageHeight";

	/**
	 * The left image.
	 */
	private final StringProperty leftImage;

	/**
	 * The left image width.
	 */
	private final IntegerProperty leftImageWidth;

	/**
	 * The left image height.
	 */
	private final IntegerProperty leftImageHeight;

	/**
	 * The middle text.
	 */
	private final StringProperty middleText;

	/**
	 * The middle text font.
	 */
	private final ObjectProperty<Font> middleTextFont;

	/**
	 * The middle text size.
	 */
	private final IntegerProperty middleTextSize;

	/**
	 * The right image.
	 */
	private final StringProperty rightImage;

	/**
	 * The right image width.
	 */
	private final IntegerProperty rightImageWidth;

	/**
	 * The right image height.
	 */
	private final IntegerProperty rightImageHeight;

	/**
	 * Create a footer.
	 * 
	 * @param data
	 *            The data.
	 */
	public Footer(JSONObject data)
	{
		this.leftImage = new SimpleStringProperty(data.getString(LEFT_IMAGE_ATTRIBUTE));
		this.leftImageWidth = new SimpleIntegerProperty(data.getInt(LEFT_IMAGE_WIDTH_ATTRIBUTE));
		this.leftImageHeight = new SimpleIntegerProperty(data.getInt(LEFT_IMAGE_HEIGHT_ATTRIBUTE));
		this.middleText = new SimpleStringProperty(data.getString(MIDDLE_TEXT_ATTRIBUTE));
		this.middleTextFont = new SimpleObjectProperty<Font>(new Font(data.getString(MIDDLE_TEXT_FONT_ATTRIBUTE), IConstants.DEFAULT_FONT_SIZE));
		this.middleTextSize = new SimpleIntegerProperty(data.getInt(MIDDLE_TEXT_SIZE_ATTRIBUTE));
		this.rightImage = new SimpleStringProperty(data.getString(RIGHT_IMAGE_ATTRIBUTE));
		this.rightImageWidth = new SimpleIntegerProperty(data.getInt(RIGHT_IMAGE_WIDTH_ATTRIBUTE));
		this.rightImageHeight = new SimpleIntegerProperty(data.getInt(RIGHT_IMAGE_HEIGHT_ATTRIBUTE));
	}

	/**
	 * Create a footer.
	 */
	public Footer()
	{
		this.leftImage = new SimpleStringProperty(IConstants.DEFAULT_TEXT);
		this.leftImageWidth = new SimpleIntegerProperty(IConstants.DEFAULT_IMAGE_WIDTH);
		this.leftImageHeight = new SimpleIntegerProperty(IConstants.DEFAULT_IMAGE_HEIGHT);
		this.middleText = new SimpleStringProperty(IConstants.DEFAULT_TEXT);
		this.middleTextFont = new SimpleObjectProperty<Font>(IConstants.DEFAULT_FONT);
		this.middleTextSize = new SimpleIntegerProperty(IConstants.DEFAULT_FONT_SIZE);
		this.rightImage = new SimpleStringProperty(IConstants.DEFAULT_TEXT);
		this.rightImageWidth = new SimpleIntegerProperty(IConstants.DEFAULT_IMAGE_WIDTH);
		this.rightImageHeight = new SimpleIntegerProperty(IConstants.DEFAULT_IMAGE_HEIGHT);
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
	 * Get the left image width.
	 * 
	 * @return The left image width.
	 */
	public int getLeftImageWidth()
	{
		return this.leftImageWidth.get();
	}

	/**
	 * Get the left image width property.
	 * 
	 * @return The left image width property.
	 */
	public IntegerProperty getLeftImageWidthProperty()
	{
		return this.leftImageWidth;
	}

	/**
	 * Get the left image height.
	 * 
	 * @return The left image height.
	 */
	public int getLeftImageHeight()
	{
		return this.leftImageHeight.get();
	}

	/**
	 * Get the left image height property.
	 * 
	 * @return The left image height property.
	 */
	public IntegerProperty getLeftImageHeightProperty()
	{
		return this.leftImageHeight;
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
	 * Get the middle text size.
	 * 
	 * @return The middle text size.
	 */
	public int getMiddleTextSize()
	{
		return this.middleTextSize.get();
	}

	/**
	 * Get the middle text size property.
	 * 
	 * @return The middle text size property.
	 */
	public IntegerProperty getMiddleTextSizeProperty()
	{
		return this.middleTextSize;
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
	 * Get the right image width.
	 * 
	 * @return The right image width.
	 */
	public int getRightImageWidth()
	{
		return this.rightImageWidth.get();
	}

	/**
	 * Get the right image width property.
	 * 
	 * @return The right image width property.
	 */
	public IntegerProperty getRightImageWidthProperty()
	{
		return this.rightImageWidth;
	}

	/**
	 * Get the right image height.
	 * 
	 * @return The right image height.
	 */
	public int getRightImageHeight()
	{
		return this.rightImageHeight.get();
	}

	/**
	 * Get the right image height property.
	 * 
	 * @return The right image height property.
	 */
	public IntegerProperty getRightImageHeightProperty()
	{
		return this.rightImageHeight;
	}

	/**
	 * @see com.delormeloic.generator.model.slides.ISerializable#toJSON()
	 */
	@Override
	public JSONObject toJSON()
	{
		final JSONObject data = new JSONObject();
		data.put(LEFT_IMAGE_ATTRIBUTE, getLeftImage());
		data.put(LEFT_IMAGE_WIDTH_ATTRIBUTE, getLeftImageWidth());
		data.put(LEFT_IMAGE_HEIGHT_ATTRIBUTE, getLeftImageHeight());
		data.put(MIDDLE_TEXT_ATTRIBUTE, getMiddleText());
		data.put(MIDDLE_TEXT_FONT_ATTRIBUTE, getMiddleTextFont().getName());
		data.put(MIDDLE_TEXT_SIZE_ATTRIBUTE, getMiddleTextSize());
		data.put(RIGHT_IMAGE_ATTRIBUTE, getRightImage());
		data.put(RIGHT_IMAGE_WIDTH_ATTRIBUTE, getRightImageWidth());
		data.put(RIGHT_IMAGE_HEIGHT_ATTRIBUTE, getRightImageHeight());

		return data;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		return (getLeftImage().hashCode() + getLeftImageWidth() + getLeftImageHeight() + getMiddleText().hashCode() + getMiddleTextFont().hashCode() + getMiddleTextSize() + getRightImage().hashCode() + getRightImageWidth() + getRightImageHeight());
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

		if (getLeftImageWidth() != footer.getLeftImageWidth())
		{
			return false;
		}

		if (getLeftImageHeight() != footer.getLeftImageHeight())
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

		if (getMiddleTextSize() != footer.getMiddleTextSize())
		{
			return false;
		}

		if (!getRightImage().equals(footer.getRightImage()))
		{
			return false;
		}

		if (getRightImageWidth() != footer.getRightImageWidth())
		{
			return false;
		}

		if (getRightImageHeight() != footer.getRightImageHeight())
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