package com.delormeloic.generator.model.slides;

import org.json.JSONObject;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.text.Font;

/**
 * This class represents a slide with an image with a title with a text.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class SlideWithImageWithTitleWithText extends Slide
{
	/**
	 * The class for name.
	 */
	public static final String CLASS_FOR_NAME = "SlideWithImageWithTitleWithText";

	/**
	 * The header attribute.
	 */
	public static final String HEADER_ATTRIBUTE = "header";

	/**
	 * The footer attribute.
	 */
	public static final String FOOTER_ATTRIBUTE = "footer";

	/**
	 * The image attribute.
	 */
	public static final String IMAGE_ATTRIBUTE = "image";

	/**
	 * The title attribute.
	 */
	public static final String TITLE_ATTRIBUTE = "title";

	/**
	 * The title font attribute.
	 */
	public static final String TITLE_FONT_ATTRIBUTE = "titleFont";

	/**
	 * The text attribute.
	 */
	public static final String TEXT_ATTRIBUTE = "text";

	/**
	 * The text font attribute.
	 */
	public static final String TEXT_FONT_ATTRIBUTE = "textFont";

	/**
	 * The header.
	 */
	private final BooleanProperty header;

	/**
	 * The footer.
	 */
	private final BooleanProperty footer;

	/**
	 * The image.
	 */
	private final StringProperty image;

	/**
	 * The title.
	 */
	private final StringProperty title;

	/**
	 * The title font.
	 */
	private final ObjectProperty<Font> titleFont;

	/**
	 * The text.
	 */
	private final StringProperty text;

	/**
	 * The text font.
	 */
	private final ObjectProperty<Font> textFont;

	/**
	 * Create a slide with an image with a title with a text.
	 * 
	 * @param name
	 *            The name.
	 * @param data
	 *            The data.
	 */
	public SlideWithImageWithTitleWithText(String name, JSONObject data)
	{
		super(CLASS_FOR_NAME, name);
		this.header = new SimpleBooleanProperty(data.getBoolean(HEADER_ATTRIBUTE));
		this.footer = new SimpleBooleanProperty(data.getBoolean(FOOTER_ATTRIBUTE));
		this.image = new SimpleStringProperty(data.getString(IMAGE_ATTRIBUTE));
		this.title = new SimpleStringProperty(data.getString(TITLE_ATTRIBUTE));
		this.titleFont = new SimpleObjectProperty<Font>(new Font(data.getString(TITLE_FONT_ATTRIBUTE), IConstants.DEFAULT_FONT_SIZE));
		this.text = new SimpleStringProperty(data.getString(TEXT_ATTRIBUTE));
		this.textFont = new SimpleObjectProperty<Font>(new Font(data.getString(TEXT_FONT_ATTRIBUTE), IConstants.DEFAULT_FONT_SIZE));
	}

	/**
	 * Create a slide with an image with a title with a text.
	 * 
	 * @param name
	 *            The name.
	 */
	public SlideWithImageWithTitleWithText(String name)
	{
		super(CLASS_FOR_NAME, name);
		this.header = new SimpleBooleanProperty(IConstants.DEFAULT_HEADER_VALUE);
		this.footer = new SimpleBooleanProperty(IConstants.DEFAULT_FOOTER_VALUE);
		this.image = new SimpleStringProperty(IConstants.DEFAULT_TEXT);
		this.title = new SimpleStringProperty(IConstants.DEFAULT_TEXT);
		this.titleFont = new SimpleObjectProperty<Font>(IConstants.DEFAULT_FONT);
		this.text = new SimpleStringProperty(IConstants.DEFAULT_TEXT);
		this.textFont = new SimpleObjectProperty<Font>(IConstants.DEFAULT_FONT);
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
	 * Get the image.
	 * 
	 * @return The image.
	 */
	public String getImage()
	{
		return this.image.get();
	}

	/**
	 * Get the image property.
	 * 
	 * @return The image property.
	 */
	public StringProperty getImageProperty()
	{
		return this.image;
	}

	/**
	 * Get the title.
	 * 
	 * @return The title.
	 */
	public String getTitle()
	{
		return this.title.get();
	}

	/**
	 * Get the title property.
	 * 
	 * @return The title property.
	 */
	public StringProperty getTitleProperty()
	{
		return this.title;
	}

	/**
	 * Get the title font.
	 * 
	 * @return The title font.
	 */
	public Font getTitleFont()
	{
		return this.titleFont.get();
	}

	/**
	 * Get the title font property.
	 * 
	 * @return The title font property.
	 */
	public ObjectProperty<Font> getTitleFontProperty()
	{
		return this.titleFont;
	}

	/**
	 * Get the text.
	 * 
	 * @return The text.
	 */
	public String getText()
	{
		return this.text.get();
	}

	/**
	 * Get the text property.
	 * 
	 * @return The text property.
	 */
	public StringProperty getTextProperty()
	{
		return this.text;
	}

	/**
	 * Get the text font.
	 * 
	 * @return The text font.
	 */
	public Font getTextFont()
	{
		return this.textFont.get();
	}

	/**
	 * Get the text font property.
	 * 
	 * @return The text font property.
	 */
	public ObjectProperty<Font> getTextFontProperty()
	{
		return this.textFont;
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
		data.put(IMAGE_ATTRIBUTE, getImage());
		data.put(TITLE_ATTRIBUTE, getTitle());
		data.put(TITLE_FONT_ATTRIBUTE, getTitleFont().getName());
		data.put(TEXT_ATTRIBUTE, getText());
		data.put(TEXT_FONT_ATTRIBUTE, getTextFont().getName());

		return data;
	}
}