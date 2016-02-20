package com.delormeloic.generator.view.slidesforms;

import com.delormeloic.generator.model.slides.IConstants;
import com.delormeloic.generator.model.slides.SlideWithMovie;
import com.delormeloic.generator.view.helpers.TextHelper;

import javafx.stage.FileChooser.ExtensionFilter;

/**
 * This class represents a slide with a movie form.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class SlideWithMovieForm extends SlideWithContentForm
{
	/**
	 * Create a slide with a movie form.
	 * 
	 * @param slideWithMovie
	 *            The slide with a movie.
	 */
	public SlideWithMovieForm(SlideWithMovie slideWithMovie)
	{
		super(slideWithMovie);
	}

	/**
	 * @see com.delormeloic.generator.view.slidesforms.SlideWithContentForm#getContentLoadedTextTextField()
	 */
	@Override
	public String getContentLoadedTextTextField()
	{
		return TextHelper.getText("slideFormMoviesLoaded");
	}

	/**
	 * @see com.delormeloic.generator.view.slidesforms.SlideWithContentForm#getContentTitleTitledPane()
	 */
	@Override
	public String getContentTitleTitledPane()
	{
		return TextHelper.getText("slideWithContentFormMovieTitleTitledPane");
	}

	/**
	 * @see com.delormeloic.generator.view.slidesforms.SlideWithContentForm#getExtensionFilter()
	 */
	@Override
	public ExtensionFilter getExtensionFilter()
	{
		return IConstants.DEFAULT_MOVIE_EXTENSION_FILTER;
	}
}