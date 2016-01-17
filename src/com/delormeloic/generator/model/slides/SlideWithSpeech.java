package com.delormeloic.generator.model.slides;

import org.json.JSONObject;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
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
	 * The title size attribute.
	 */
	public static final String TITLE_SIZE_ATTRIBUTE = "titleSize";

	/**
	 * The speech attribute.
	 */
	public static final String SPEECH_ATTRIBUTE = "speech";

	/**
	 * The speech font attribute.
	 */
	public static final String SPEECH_FONT_ATTRIBUTE = "speechFont";

	/**
	 * The speech size attribute.
	 */
	public static final String SPEECH_SIZE_ATTRIBUTE = "speechSize";

	/**
	 * The image attribute.
	 */
	public static final String IMAGE_ATTRIBUTE = "image";

	/**
	 * The image width attribute.
	 */
	public static final String IMAGE_WIDTH_ATTRIBUTE = "imageWidth";

	/**
	 * The image height attribute.
	 */
	public static final String IMAGE_HEIGHT_ATTRIBUTE = "imageHeight";

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
	 * The title size.
	 */
	private final IntegerProperty titleSize;

	/**
	 * The speech.
	 */
	private final StringProperty speech;

	/**
	 * The speech font.
	 */
	private final ObjectProperty<Font> speechFont;

	/**
	 * The speech size.
	 */
	private final IntegerProperty speechSize;

	/**
	 * The image.
	 */
	private final StringProperty image;

	/**
	 * The image width.
	 */
	private final IntegerProperty imageWidth;

	/**
	 * The image height.
	 */
	private final IntegerProperty imageHeight;

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
		this.titleSize = new SimpleIntegerProperty(data.getInt(TITLE_SIZE_ATTRIBUTE));
		this.speech = new SimpleStringProperty(data.getString(SPEECH_ATTRIBUTE));
		this.speechFont = new SimpleObjectProperty<Font>(new Font(data.getString(SPEECH_FONT_ATTRIBUTE), IConstants.DEFAULT_FONT_SIZE));
		this.speechSize = new SimpleIntegerProperty(data.getInt(SPEECH_SIZE_ATTRIBUTE));
		this.image = new SimpleStringProperty(data.getString(IMAGE_ATTRIBUTE));
		this.imageWidth = new SimpleIntegerProperty(data.getInt(IMAGE_WIDTH_ATTRIBUTE));
		this.imageHeight = new SimpleIntegerProperty(data.getInt(IMAGE_HEIGHT_ATTRIBUTE));
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
		this.titleSize = new SimpleIntegerProperty(IConstants.DEFAULT_FONT_SIZE);
		this.speech = new SimpleStringProperty(IConstants.DEFAULT_TEXT);
		this.speechFont = new SimpleObjectProperty<Font>(IConstants.DEFAULT_FONT);
		this.speechSize = new SimpleIntegerProperty(IConstants.DEFAULT_FONT_SIZE);
		this.image = new SimpleStringProperty(IConstants.DEFAULT_TEXT);
		this.imageWidth = new SimpleIntegerProperty(IConstants.DEFAULT_IMAGE_WIDTH);
		this.imageHeight = new SimpleIntegerProperty(IConstants.DEFAULT_IMAGE_HEIGHT);
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
	 * Get the title size.
	 * 
	 * @return The title size.
	 */
	public int getTitleSize()
	{
		return this.titleSize.get();
	}

	/**
	 * Get the title size property.
	 * 
	 * @return The title size property.
	 */
	public IntegerProperty getTitleSizeProperty()
	{
		return this.titleSize;
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
	 * Get the speech size.
	 * 
	 * @return The speech size.
	 */
	public int getSpeechSize()
	{
		return this.speechSize.get();
	}

	/**
	 * Get the speech size property.
	 * 
	 * @return The speech size property.
	 */
	public IntegerProperty getSpeechSizeProperty()
	{
		return this.speechSize;
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
	 * Get the image width.
	 * 
	 * @return The image width.
	 */
	public int getImageWidth()
	{
		return this.imageWidth.get();
	}

	/**
	 * Get the image width property.
	 * 
	 * @return The image width property.
	 */
	public IntegerProperty getImageWidthProperty()
	{
		return this.imageWidth;
	}

	/**
	 * Get the image height.
	 * 
	 * @return The image height.
	 */
	public int getImageHeight()
	{
		return this.imageHeight.get();
	}

	/**
	 * Get the image height property.
	 * 
	 * @return The image height property.
	 */
	public IntegerProperty getImageHeightProperty()
	{
		return this.imageHeight;
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
		data.put(TITLE_SIZE_ATTRIBUTE, getTitleSize());
		data.put(SPEECH_ATTRIBUTE, getSpeech());
		data.put(SPEECH_FONT_ATTRIBUTE, getSpeechFont().getName());
		data.put(SPEECH_SIZE_ATTRIBUTE, getSpeechSize());
		data.put(IMAGE_ATTRIBUTE, getImage());
		data.put(IMAGE_WIDTH_ATTRIBUTE, getImageWidth());
		data.put(IMAGE_HEIGHT_ATTRIBUTE, getImageHeight());

		return data;
	}
}