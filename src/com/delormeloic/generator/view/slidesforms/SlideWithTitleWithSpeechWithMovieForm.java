package com.delormeloic.generator.view.slidesforms;

import com.delormeloic.generator.model.slides.IConstants;
import com.delormeloic.generator.model.slides.SlideWithTitleWithSpeechWithMovie;
import com.delormeloic.generator.view.helpers.TextHelper;

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
	 * @see com.delormeloic.generator.view.slidesforms.SlideWithTitleWithSpeechWithContentForm#getContentLoadedTextTextField()
	 */
	@Override
	public String getContentLoadedTextTextField()
	{
		return TextHelper.getText("slideFormMoviesLoaded");
	}

	/**
	 * @see com.delormeloic.generator.view.slidesforms.SlideWithTitleWithSpeechWithContentForm#getContentTitleTitledPane()
	 */
	@Override
	public String getContentTitleTitledPane()
	{
		return TextHelper.getText("slideWithSpeechWithMovieFormMovieTitleTitledPane");
	}

	/**
	 * @see com.delormeloic.generator.view.slidesforms.SlideWithTitleWithSpeechWithContentForm#getExtensionFilter()
	 */
	@Override
	public ExtensionFilter getExtensionFilter()
	{
		return IConstants.DEFAULT_MOVIE_EXTENSION_FILTER;
	}
}