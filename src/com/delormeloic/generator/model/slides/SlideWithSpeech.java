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
 * This class represents a slide with a speech.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class SlideWithSpeech extends Slide
{
	/**
	 * The class for name.
	 */
	public static final String CLASS_FOR_NAME = "SlideWithSpeech";

	/**
	 * The header attribute.
	 */
	public static final String HEADER_ATTRIBUTE = "header";

	/**
	 * The header attribute.
	 */
	public static final String FOOTER_ATTRIBUTE = "footer";

	/**
	 * The title attribute.
	 */
	public static final String TITLE_ATTRIBUTE = "title";

	/**
	 * The title font attribute.
	 */
	public static final String TITLE_FONT_ATTRIBUTE = "titleFont";

	/**
	 * The speech attribute.
	 */
	public static final String SPEECH_ATTRIBUTE = "speech";

	/**
	 * The speech font attribute.
	 */
	public static final String SPEECH_FONT_ATTRIBUTE = "speechFont";

	/**
	 * The image attribute.
	 */
	public static final String IMAGE_ATTRIBUTE = "image";

	/**
	 * The header.
	 */
	private final BooleanProperty header;

	/**
	 * The footer.
	 */
	private final BooleanProperty footer;

	/**
	 * The title.
	 */
	private final StringProperty title;

	/**
	 * The title font.
	 */
	private final ObjectProperty<Font> titleFont;

	/**
	 * The speech.
	 */
	private final StringProperty speech;

	/**
	 * The speech font.
	 */
	private final ObjectProperty<Font> speechFont;

	/**
	 * The image.
	 */
	private final StringProperty image;

	/**
	 * Create a slide with a speech.
	 * 
	 * @param name
	 *            The name.
	 * @param data
	 *            The data.
	 */
	public SlideWithSpeech(String name, JSONObject data)
	{
		super(CLASS_FOR_NAME, name);
		this.header = new SimpleBooleanProperty(data.getBoolean(HEADER_ATTRIBUTE));
		this.footer = new SimpleBooleanProperty(data.getBoolean(FOOTER_ATTRIBUTE));
		this.title = new SimpleStringProperty(data.getString(TITLE_ATTRIBUTE));
		this.titleFont = new SimpleObjectProperty<Font>(new Font(data.getString(TITLE_FONT_ATTRIBUTE), IConstants.DEFAULT_FONT_SIZE));
		this.speech = new SimpleStringProperty(data.getString(SPEECH_ATTRIBUTE));
		this.speechFont = new SimpleObjectProperty<Font>(new Font(data.getString(SPEECH_FONT_ATTRIBUTE), IConstants.DEFAULT_FONT_SIZE));
		this.image = new SimpleStringProperty(data.getString(IMAGE_ATTRIBUTE));
	}

	/**
	 * Create a slide with a speech.
	 * 
	 * @param name
	 *            The name.
	 */
	public SlideWithSpeech(String name)
	{
		super(CLASS_FOR_NAME, name);
		this.header = new SimpleBooleanProperty(IConstants.DEFAULT_HEADER_VALUE);
		this.footer = new SimpleBooleanProperty(IConstants.DEFAULT_FOOTER_VALUE);
		this.title = new SimpleStringProperty(IConstants.DEFAULT_TEXT);
		this.titleFont = new SimpleObjectProperty<Font>(IConstants.DEFAULT_FONT);
		this.speech = new SimpleStringProperty(IConstants.DEFAULT_TEXT);
		this.speechFont = new SimpleObjectProperty<Font>(IConstants.DEFAULT_FONT);
		this.image = new SimpleStringProperty(IConstants.DEFAULT_TEXT);
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
	 * Get the speech.
	 * 
	 * @return The speech.
	 */
	public String getSpeech()
	{
		return this.speech.get();
	}

	/**
	 * Get the speech property.
	 * 
	 * @return The speech property.
	 */
	public StringProperty getSpeechProperty()
	{
		return this.speech;
	}

	/**
	 * Get the speech font.
	 * 
	 * @return The speech font.
	 */
	public Font getSpeechFont()
	{
		return this.speechFont.get();
	}

	/**
	 * Get the speech font property.
	 * 
	 * @return The speech font property.
	 */
	public ObjectProperty<Font> getSpeechFontProperty()
	{
		return this.speechFont;
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
	 * @see com.delormeloic.generator.model.slides.Slide#getData()
	 */
	@Override
	public JSONObject getData()
	{
		final JSONObject data = new JSONObject();
		data.put(HEADER_ATTRIBUTE, getHeader());
		data.put(FOOTER_ATTRIBUTE, getFooter());
		data.put(TITLE_ATTRIBUTE, getTitle());
		data.put(TITLE_FONT_ATTRIBUTE, getTitleFont().getName());
		data.put(SPEECH_ATTRIBUTE, getSpeech());
		data.put(SPEECH_FONT_ATTRIBUTE, getSpeechFont().getName());
		data.put(IMAGE_ATTRIBUTE, getImage());

		return data;
	}
}