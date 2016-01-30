package com.delormeloic.generator.model;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.delormeloic.generator.controller.IController;
import com.delormeloic.generator.model.helpers.SlideParserHelper;
import com.delormeloic.generator.model.slides.Background;
import com.delormeloic.generator.model.slides.Footer;
import com.delormeloic.generator.model.slides.Header;
import com.delormeloic.generator.model.slides.Slide;

/**
 * This class represents plain text file model which uses JSON representation.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class JSONPlainTextFileModel extends PlainTextFileModel
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
	 * The background attribute.
	 */
	public static final String BACKGROUND_ATTRIBUTE = "background";

	/**
	 * The slides attribute.
	 */
	public static final String SLIDES_ATTRIBUTE = "slides";

	/**
	 * The indent factor.
	 */
	public static final int INDENT_FACTOR = 4;

	/**
	 * Create a JSON plain text file model.
	 * 
	 * @param controller
	 *            The controller.
	 */
	public JSONPlainTextFileModel(IController controller)
	{
		super(controller);
	}

	/**
	 * @see com.delormeloic.generator.model.PlainTextFileModel#parseData(java.lang.String)
	 */
	@Override
	public void parseData(String data)
	{
		final JSONObject parsedData = new JSONObject(data);
		this.header = new Header(parsedData.getJSONObject(HEADER_ATTRIBUTE));
		this.footer = new Footer(parsedData.getJSONObject(FOOTER_ATTRIBUTE));
		this.background = new Background(parsedData.getJSONObject(BACKGROUND_ATTRIBUTE));
		this.slides = new ArrayList<Slide>(SlideParserHelper.parseSlides(parsedData.getJSONArray(SLIDES_ATTRIBUTE)));
	}

	/**
	 * @see com.delormeloic.generator.model.PlainTextFileModel#serializeData()
	 */
	@Override
	public String serializeData()
	{
		final JSONArray slidesData = new JSONArray();
		for (Slide currentSlide : this.slides)
		{
			slidesData.put(currentSlide.toJSON());
		}

		final JSONObject serializedData = new JSONObject();
		serializedData.put(HEADER_ATTRIBUTE, this.header.toJSON());
		serializedData.put(FOOTER_ATTRIBUTE, this.footer.toJSON());
		serializedData.put(BACKGROUND_ATTRIBUTE, this.background.toJSON());
		serializedData.put(SLIDES_ATTRIBUTE, slidesData);

		return serializedData.toString(INDENT_FACTOR);
	}
}