package com.delormeloic.generator.view.slidesforms;

import com.delormeloic.generator.model.slides.SlideWithTitleWithSpeechWithMovie;
import com.delormeloic.generator.view.helpers.TextHelper;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * This class represents a slide with a title with a speech with a movie form.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class SlideWithTitleWithSpeechWithMovieForm extends SlideWithTitleWithSpeechWithContentForm
{
	/**
	 * Create a slide with a title with a speech with a movie form.
	 * 
	 * @param slideWithTitleWithSpeechWithMovie
	 *            The slide with a title with a speech with a movie.
	 */
	public SlideWithTitleWithSpeechWithMovieForm(SlideWithTitleWithSpeechWithMovie slideWithTitleWithSpeechWithMovie)
	{
		super(slideWithTitleWithSpeechWithMovie);
	}

	/**
	 * @see com.delormeloic.generator.view.slidesforms.SlideWithTitleWithSpeechWithContentForm#getContentLoadedText()
	 */
	@Override
	public String getContentLoadedText()
	{
		return TextHelper.getText("moviesLoaded");
	}

	/**
	 * @see com.delormeloic.generator.view.slidesforms.SlideWithTitleWithSpeechWithContentForm#getContentButtonText()
	 */
	@Override
	public String getContentButtonText()
	{
		return TextHelper.getText("slideWithSpeechWithMovieFormMovieButtonTitledPane");
	}

	/**
	 * @see com.delormeloic.generator.view.slidesforms.SlideWithTitleWithSpeechWithContentForm#getExtensionFilter()
	 */
	@Override
	public ExtensionFilter getExtensionFilter()
	{
		return new FileChooser.ExtensionFilter("Movies", "*.mp4");
	}
}