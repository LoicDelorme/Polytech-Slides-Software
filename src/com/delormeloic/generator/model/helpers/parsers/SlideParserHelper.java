package com.delormeloic.generator.model.helpers.parsers;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.delormeloic.generator.model.slides.Slide;
import com.delormeloic.utils.logger.Logger;

/**
 * This class represents a slide parser utils.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class SlideParserHelper
{
	/**
	 * The default slides classes package.
	 */
	public static final String DEFAULT_SLIDES_CLASSES_PACKAGE = "com.delormeloic.generator.model.slides.";

	/**
	 * Parse a JSONArray into a list of slides.
	 * 
	 * @param slides
	 *            The slides.
	 * @return The list of slides.
	 */
	public static List<Slide> parseSlides(JSONArray slides)
	{
		final List<Slide> parsedSlides = new ArrayList<Slide>();
		for (int offset = 0; offset < slides.length(); offset++)
		{
			parsedSlides.add(parseSlide(slides.getJSONObject(offset)));
		}

		return parsedSlides;
	}

	/**
	 * Parse a JSONObject into a slide.
	 * 
	 * @param slide
	 *            The slide.
	 * @return The slide.
	 */
	@SuppressWarnings("unchecked")
	private static Slide parseSlide(JSONObject slide)
	{
		final String classForName = DEFAULT_SLIDES_CLASSES_PACKAGE + slide.getString(Slide.CLASS_FOR_NAME_ATTRIBUTE);
		final String name = slide.getString(Slide.NAME_ATTRIBUTE);
		final JSONObject data = slide.getJSONObject(Slide.DATA_ATTRIBUTE);

		try
		{
			final Class<? extends Slide> slideClass = (Class<? extends Slide>) Class.forName(classForName);
			final Constructor<? extends Slide> constructor = slideClass.getConstructor(String.class, JSONObject.class);
			return constructor.newInstance(name, data);
		}
		catch (Exception e)
		{
			Logger.severe(e);
			return null;
		}
	}
}