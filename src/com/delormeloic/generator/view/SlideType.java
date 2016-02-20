package com.delormeloic.generator.view;

import java.lang.reflect.InvocationTargetException;

import com.delormeloic.generator.model.slides.Slide;
import com.delormeloic.generator.model.slides.SlideWithImage;
import com.delormeloic.generator.model.slides.SlideWithImageWithSpeech;
import com.delormeloic.generator.model.slides.SlideWithMovie;
import com.delormeloic.generator.model.slides.SlideWithMovieWithSpeech;
import com.delormeloic.generator.model.slides.SlideWithOneTrombinoscope;
import com.delormeloic.generator.model.slides.SlideWithTitle;
import com.delormeloic.generator.model.slides.SlideWithTitleWithSpeechWithImage;
import com.delormeloic.generator.model.slides.SlideWithTitleWithSpeechWithMovie;
import com.delormeloic.generator.model.slides.SlideWithTwoTrombinoscope;
import com.delormeloic.generator.view.slidesforms.SlideForm;
import com.delormeloic.generator.view.slidesforms.SlideWithImageForm;
import com.delormeloic.generator.view.slidesforms.SlideWithImageWithSpeechForm;
import com.delormeloic.generator.view.slidesforms.SlideWithMovieForm;
import com.delormeloic.generator.view.slidesforms.SlideWithMovieWithSpeechForm;
import com.delormeloic.generator.view.slidesforms.SlideWithOneTrombinoscopeForm;
import com.delormeloic.generator.view.slidesforms.SlideWithTitleForm;
import com.delormeloic.generator.view.slidesforms.SlideWithTitleWithSpeechWithImageForm;
import com.delormeloic.generator.view.slidesforms.SlideWithTitleWithSpeechWithMovieForm;
import com.delormeloic.generator.view.slidesforms.SlideWithTwoTrombinoscopeForm;
import com.delormeloic.utils.logger.Logger;

/**
 * This enumeration represents all slides types.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public enum SlideType
{
    /**
     * A slide with a title.
     */
	SLIDE_WITH_TITLE("/com/delormeloic/generator/view/resources/images/slide_with_title.png", SlideWithTitle.class, SlideWithTitleForm.class),

	/**
	 * A slide with a title with a speech with an image.
	 */
	SLIDE_WITH_TITLE_WITH_SPEECH_WITH_IMAGE("/com/delormeloic/generator/view/resources/images/slide_with_title_with_speech_with_image.png", SlideWithTitleWithSpeechWithImage.class, SlideWithTitleWithSpeechWithImageForm.class),

	/**
	 * A slide with a title with a speech with a movie.
	 */
	SLIDE_WITH_TITLE_WITH_SPEECH_WITH_MOVIE("/com/delormeloic/generator/view/resources/images/slide_with_title_with_speech_with_movie.png", SlideWithTitleWithSpeechWithMovie.class, SlideWithTitleWithSpeechWithMovieForm.class),

	/**
	 * A slide with an image with a speech.
	 */
	SLIDE_WITH_IMAGE_WITH_SPEECH("/com/delormeloic/generator/view/resources/images/slide_with_image_with_speech.png", SlideWithImageWithSpeech.class, SlideWithImageWithSpeechForm.class),

	/**
	 * A slide with a movie with a speech.
	 */
	SLIDE_WITH_MOVIE_WITH_SPEECH("/com/delormeloic/generator/view/resources/images/slide_with_movie_with_speech.png", SlideWithMovieWithSpeech.class, SlideWithMovieWithSpeechForm.class),

	/**
	 * A slide with an image.
	 */
	SLIDE_WITH_IMAGE("/com/delormeloic/generator/view/resources/images/slide_with_image.png", SlideWithImage.class, SlideWithImageForm.class),

	/**
	 * A slide with a movie.
	 */
	SLIDE_WITH_MOVIE("/com/delormeloic/generator/view/resources/images/slide_with_movie.png", SlideWithMovie.class, SlideWithMovieForm.class),

	/**
	 * A slide with one trombinoscope.
	 */
	SLIDE_WITH_ONE_TROMBINOSCOPE("/com/delormeloic/generator/view/resources/images/slide_with_one_trombinoscope.png", SlideWithOneTrombinoscope.class, SlideWithOneTrombinoscopeForm.class),

	/**
	 * A slide with two trombinoscope.
	 */
	SLIDE_WITH_TWO_TROMBINOSCOPE("/com/delormeloic/generator/view/resources/images/slide_with_two_trombinoscope.png", SlideWithTwoTrombinoscope.class, SlideWithTwoTrombinoscopeForm.class);

	/**
	 * The image path.
	 */
	private final String imagePath;

	/**
	 * The slide class.
	 */
	private final Class<? extends Slide> slideClass;

	/**
	 * The slide form class.
	 */
	private final Class<? extends SlideForm> slideFormClass;

	/**
	 * Private constructor.
	 * 
	 * @param imagePath
	 *            The image path.
	 * @param slideClass
	 *            The slide class.
	 * @param slideFormClass
	 *            The slide form class.
	 */
	private SlideType(String imagePath, Class<? extends Slide> slideClass, Class<? extends SlideForm> slideFormClass)
	{
		this.imagePath = imagePath;
		this.slideClass = slideClass;
		this.slideFormClass = slideFormClass;
	}

	/**
	 * Get the image path.
	 * 
	 * @return The image path.
	 */
	public String getImagePath()
	{
		return this.imagePath;
	}

	/**
	 * Get a slide form instance.
	 * 
	 * @return The slide form instance.
	 */
	public SlideForm getSlideFormInstance()
	{
		try
		{
			return this.slideFormClass.getConstructor(this.slideClass).newInstance(this.slideClass.getConstructor(String.class).newInstance(this.slideClass.getSimpleName()));
		}
		catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e)
		{
			Logger.severe(e);
			return null;
		}
	}
}