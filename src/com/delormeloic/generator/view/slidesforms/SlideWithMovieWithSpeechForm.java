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
	 * @see com.delormeloic.generator.view.slidesforms.SlideWithContentWithSpeechForm#getContentLoadedTextTextField()
	 */
	@Override
	public String getContentLoadedTextTextField()
	{
		return TextHelper.getText("slideFormMoviesLoaded");
	}

	/**
	 * @see com.delormeloic.generator.view.slidesforms.SlideWithContentWithSpeechForm#getContentTitleTitledPane()
	 */
	@Override
	public String getContentTitleTitledPane()
	{
		return TextHelper.getText("slideWithContentWithSpeechFormMovieTitleTitledPane");
	}

	/**
	 * @see com.delormeloic.generator.view.slidesforms.SlideWithContentWithSpeechForm#getExtensionFilter()
	 */
	@Override
	public ExtensionFilter getExtensionFilter()
	{
		return new FileChooser.ExtensionFilter("Movies", "*.mp4");
	}
}