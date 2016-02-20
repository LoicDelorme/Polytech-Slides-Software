package com.delormeloic.generator.view.slidesforms;

import com.delormeloic.generator.model.slides.IConstants;
import com.delormeloic.generator.model.slides.SlideWithTitleWithSpeechWithImage;
import com.delormeloic.generator.view.helpers.TextHelper;

import javafx.stage.FileChooser.ExtensionFilter;

/**
 * This class represents a slide with a title with a speech with an image form.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class SlideWithTitleWithSpeechWithImageForm extends SlideWithTitleWithSpeechWithContentForm
{
	/**
	 * Create a slide with a title with a speech with an image form.
	 *
	 * @param slideWithTitleWithSpeechWithImage
	 *            The slide with a title with a speech with an image.
	 */
	public SlideWithTitleWithSpeechWithImageForm(SlideWithTitleWithSpeechWithImage slideWithTitleWithSpeechWithImage)
	{
		super(slideWithTitleWithSpeechWithImage);
	}

	/**
	 * @see com.delormeloic.generator.view.slidesforms.SlideWithTitleWithSpeechWithContentForm#getContentLoadedTextTextField()
	 */
	@Override
	public String getContentLoadedTextTextField()
	{
		return TextHelper.getText("slideFormImagesLoaded");
	}

	/**
	 * @see com.delormeloic.generator.view.slidesforms.SlideWithTitleWithSpeechWithContentForm#getContentTitleTitledPane()
	 */
	@Override
	public String getContentTitleTitledPane()
	{
		return TextHelper.getText("slideWithSpeechWithImageFormImageTitleTitledPane");
	}

	/**
	 * @see com.delormeloic.generator.view.slidesforms.SlideWithTitleWithSpeechWithContentForm#getExtensionFilter()
	 */
	@Override
	public ExtensionFilter getExtensionFilter()
	{
		return IConstants.DEFAULT_IMAGE_EXTENSION_FILTER;
	}
}