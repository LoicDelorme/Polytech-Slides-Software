package com.delormeloic.generator.view.slidesforms;

import com.delormeloic.generator.model.slides.SlideWithSpeechWithMovie;
import com.delormeloic.generator.view.helpers.TextHelper;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * This class represents a slide with a speech with a movie form.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class SlideWithSpeechWithMovieForm extends SlideWithSpeechWithContentForm
{
	/**
	 * Create a slide with a speech with a movie form.
	 * 
	 * @param slideWithSpeechWithMovie
	 *            The slide with a speech with a movie.
	 */
	public SlideWithSpeechWithMovieForm(SlideWithSpeechWithMovie slideWithSpeechWithMovie)
	{
		super(slideWithSpeechWithMovie);
	}

	/**
	 * @see com.delormeloic.generator.view.slidesforms.SlideWithSpeechWithContentForm#getContentLoadedText()
	 */
	@Override
	public String getContentLoadedText()
	{
		return TextHelper.getText("moviesLoaded");
	}

	/**
	 * @see com.delormeloic.generator.view.slidesforms.SlideWithSpeechWithContentForm#getContentButtonText()
	 */
	@Override
	public String getContentButtonText()
	{
		return TextHelper.getText("slideWithSpeechWithMovieFormMovieButtonTitledPane");
	}

	/**
	 * @see com.delormeloic.generator.view.slidesforms.SlideWithSpeechWithContentForm#getExtensionFilter()
	 */
	@Override
	public ExtensionFilter getExtensionFilter()
	{
		return new FileChooser.ExtensionFilter("Movies", "*.mp4");
	}
}