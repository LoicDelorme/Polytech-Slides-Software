package com.delormeloic.generator.controller.helpers;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import com.delormeloic.generator.model.helpers.SlideParserHelper;
import com.delormeloic.generator.model.slides.Slide;
import com.delormeloic.generator.view.slidesforms.SlideForm;
import com.delormeloic.utils.logger.Logger;

/**
 * This class represents a slide form parser helper.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class SlideFormParserHelper
{
	/**
	 * The default slides forms classes package.
	 */
	public static final String DEFAULT_SLIDES_FORMS_CLASSES_PACKAGE = "com.delormeloic.generator.view.slidesforms.";

	/**
	 * Parse a list of slides into a list of slides forms.
	 * 
	 * @param slides
	 *            The list of slides.
	 * @return The list of slides forms.
	 */
	public static List<SlideForm> parseSlidesForms(List<Slide> slides)
	{
		final List<SlideForm> slidesForms = new ArrayList<SlideForm>();
		for (Slide currentSlide : slides)
		{
			slidesForms.add(parseSlideForm(currentSlide));
		}

		return slidesForms;
	}

	/**
	 * Parse a slide into a slide form.
	 * 
	 * @param slide
	 *            The slide.
	 * @return The slide form.
	 */
	@SuppressWarnings("unchecked")
	private static SlideForm parseSlideForm(Slide slide)
	{
		try
		{
			final Class<? extends Slide> slideClass = (Class<? extends Slide>) Class.forName(SlideParserHelper.DEFAULT_SLIDES_CLASSES_PACKAGE + slide.getClassForName());
			final Class<? extends SlideForm> slideFormClass = (Class<? extends SlideForm>) Class.forName(DEFAULT_SLIDES_FORMS_CLASSES_PACKAGE + slide.getClassForName() + "Form");
			final Constructor<? extends SlideForm> constructor = slideFormClass.getConstructor(slideClass);
			return constructor.newInstance(slide);
		}
		catch (Exception e)
		{
			Logger.severe(e);
			return null;
		}
	}
}