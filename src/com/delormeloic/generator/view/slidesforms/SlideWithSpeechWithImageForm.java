package com.delormeloic.generator.view.slidesforms;

import com.delormeloic.generator.model.slides.SlideWithSpeechWithImage;
import com.delormeloic.generator.view.helpers.TextHelper;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * This class represents a slide with a speech with an image form.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class SlideWithSpeechWithImageForm extends SlideWithSpeechWithContentForm
{
	/**
	 * Create a slide with a speech with an image form.
	 *
	 * @param slideWithSpeechWithImage
	 *            The slide with a speech with an image.
	 */
	public SlideWithSpeechWithImageForm(SlideWithSpeechWithImage slideWithSpeechWithImage)
	{
		super(slideWithSpeechWithImage);
	}

	/**
	 * @see com.delormeloic.generator.view.slidesforms.SlideWithSpeechWithContentForm#getContentLoadedText()
	 */
	@Override
	public String getContentLoadedText()
	{
		return TextHelper.getText("imagesLoaded");
	}

	/**
	 * @see com.delormeloic.generator.view.slidesforms.SlideWithSpeechWithContentForm#getContentButtonText()
	 */
	@Override
	public String getContentButtonText()
	{
		return TextHelper.getText("slideWithSpeechWithImageFormImageButtonTitledPane");
	}

	/**
	 * @see com.delormeloic.generator.view.slidesforms.SlideWithSpeechWithContentForm#getExtensionFilter()
	 */
	@Override
	public ExtensionFilter getExtensionFilter()
	{
		return new FileChooser.ExtensionFilter("Images", "*.jpg", "*.png");
	}
}