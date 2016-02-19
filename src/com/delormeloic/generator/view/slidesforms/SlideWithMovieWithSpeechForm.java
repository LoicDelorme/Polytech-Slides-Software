package com.delormeloic.generator.view.slidesforms;

import com.delormeloic.generator.model.slides.SlideWithMovieWithSpeech;
import com.delormeloic.generator.view.helpers.TextHelper;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * This class represents a slide with a movie with a speech form.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class SlideWithMovieWithSpeechForm extends SlideWithContentWithSpeechForm
{
	/**
	 * Create a slide with a movie with a speech form.
	 * 
	 * @param slideWithMovieWithSpeech
	 *            The slide with a movie with a speech.
	 */
	public SlideWithMovieWithSpeechForm(SlideWithMovieWithSpeech slideWithMovieWithSpeech)
	{
		super(slideWithMovieWithSpeech);
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
		return TextHelper.getText("slideWithContentWithSpeechFormMovieButtonTitledPane");
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