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
 * This class represents a slide with a content with a speech.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public abstract class SlideWithContentWithSpeech extends Slide
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
	 * The speech attribute.
	 */
	public static final String SPEECH_ATTRIBUTE = "speech";

	/**
	 * The speech font attribute.
	 */
	public static final String SPEECH_FONT_ATTRIBUTE = "speechFont";

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
	 * The speech.
	 */
	private final StringProperty speech;

	/**
	 * The speech font.
	 */
	private final ObjectProperty<Font> speechFont;

	/**
	 * Create a slide with a content with a speech.
	 * 
	 * @param classForName
	 *            The class for name.
	 * @param name
	 *            The name.
	 * @param data
	 *            The data.
	 */
	public SlideWithContentWithSpeech(String classForName, String name, JSONObject data)
	{
		super(classForName, name);
		this.header = new SimpleBooleanProperty(data.getBoolean(HEADER_ATTRIBUTE));
		this.footer = new SimpleBooleanProperty(data.getBoolean(FOOTER_ATTRIBUTE));
		this.content = new SimpleStringProperty(data.getString(getContentAttribute()));
		this.speech = new SimpleStringProperty(data.getString(SPEECH_ATTRIBUTE));
		this.speechFont = new SimpleObjectProperty<Font>(new Font(data.getString(SPEECH_FONT_ATTRIBUTE), IConstants.DEFAULT_FONT_SIZE));
	}

	/**
	 * Create a slide with a content with a speech.
	 * 
	 * @param classForName
	 *            The class for name.
	 * @param name
	 *            The name.
	 */
	public SlideWithContentWithSpeech(String classForName, String name)
	{
		super(classForName, name);
		this.header = new SimpleBooleanProperty(IConstants.DEFAULT_HEADER_VALUE);
		this.footer = new SimpleBooleanProperty(IConstants.DEFAULT_FOOTER_VALUE);
		this.content = new SimpleStringProperty(IConstants.DEFAULT_TEXT);
		this.speech = new SimpleStringProperty(IConstants.DEFAULT_TEXT);
		this.speechFont = new SimpleObjectProperty<Font>(IConstants.DEFAULT_FONT);
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
	 * @see com.delormeloic.generator.model.slides.Slide#getData()
	 */
	@Override
	public JSONObject getData()
	{
		final JSONObject data = new JSONObject();
		data.put(HEADER_ATTRIBUTE, getHeader());
		data.put(FOOTER_ATTRIBUTE, getFooter());
		data.put(getContentAttribute(), getContent());
		data.put(SPEECH_ATTRIBUTE, getSpeech());
		data.put(SPEECH_FONT_ATTRIBUTE, getSpeechFont().getName());

		return data;
	}
}