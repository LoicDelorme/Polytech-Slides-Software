package com.delormeloic.generator.view.slidesforms;

import com.delormeloic.generator.model.slides.IConstants;
import com.delormeloic.generator.model.slides.SlideWithImageWithSpeech;
import com.delormeloic.generator.view.helpers.TextHelper;

import javafx.stage.FileChooser.ExtensionFilter;

/**
 * This class represents a slide with an image with a speech form.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class SlideWithImageWithSpeechForm extends SlideWithContentWithSpeechForm
{
	/**
	 * Create a slide with an image with a speech form.
	 *
	 * @param slideWithImageWithSpeech
	 *            The slide with an image with a speech.
	 */
	public SlideWithImageWithSpeechForm(SlideWithImageWithSpeech slideWithImageWithSpeech)
	{
		super(slideWithImageWithSpeech);
	}

	/**
	 * @see com.delormeloic.generator.view.slidesforms.SlideWithContentWithSpeechForm#getContentLoadedTextTextField()
	 */
	@Override
	public String getContentLoadedTextTextField()
	{
		return TextHelper.getText("slideFormImagesLoaded");
	}

	/**
	 * @see com.delormeloic.generator.view.slidesforms.SlideWithContentWithSpeechForm#getContentTitleTitledPane()
	 */
	@Override
	public String getContentTitleTitledPane()
	{
		return TextHelper.getText("slideWithContentWithSpeechFormImageTitleTitledPane");
	}

	/**
	 * @see com.delormeloic.generator.view.slidesforms.SlideWithContentWithSpeechForm#getExtensionFilter()
	 */
	@Override
	public ExtensionFilter getExtensionFilter()
	{
		return IConstants.DEFAULT_IMAGE_EXTENSION_FILTER;
	}
}