package com.delormeloic.generator.view.slidesforms;

import com.delormeloic.generator.model.slides.SlideWithTitleWithSpeechWithImage;
import com.delormeloic.generator.view.helpers.TextHelper;

import javafx.stage.FileChooser;
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
		return TextHelper.getText("slideWithSpeechWithImageFormImageButtonTitledPane");
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