package com.delormeloic.generator.view.slidesforms;

import com.delormeloic.generator.model.slides.SlideWithImageWithSpeech;
import com.delormeloic.generator.view.helpers.TextHelper;

import javafx.stage.FileChooser;
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
	 * @see com.delormeloic.generator.view.slidesforms.SlideWithTitleWithSpeechWithContentForm#getContentLoadedText()
	 */
	@Override
	public String getContentLoadedText()
	{
		return TextHelper.getText("imagesLoaded");
	}

	/**
	 * @see com.delormeloic.generator.view.slidesforms.SlideWithTitleWithSpeechWithContentForm#getContentButtonText()
	 */
	@Override
	public String getContentButtonText()
	{
		return TextHelper.getText("slideWithContentWithSpeechFormImageButtonTitledPane");
	}

	/**
	 * @see com.delormeloic.generator.view.slidesforms.SlideWithTitleWithSpeechWithContentForm#getExtensionFilter()
	 */
	@Override
	public ExtensionFilter getExtensionFilter()
	{
		return new FileChooser.ExtensionFilter("Images", "*.jpg", "*.png");
	}
}