package com.delormeloic.generator.view.slidesforms;

import com.delormeloic.generator.model.slides.SlideWithImage;
import com.delormeloic.generator.view.helpers.TextHelper;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * This class represents a slide with an image form.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class SlideWithImageForm extends SlideWithContentForm
{
	/**
	 * Create a slide with an image form.
	 *
	 * @param slideWithImage
	 *            The slide with an image.
	 */
	public SlideWithImageForm(SlideWithImage slideWithImage)
	{
		super(slideWithImage);
	}

	/**
	 * @see com.delormeloic.generator.view.slidesforms.SlideWithContentForm#getContentLoadedTextTextField()
	 */
	@Override
	public String getContentLoadedTextTextField()
	{
		return TextHelper.getText("slideFormImagesLoaded");
	}

	/**
	 * @see com.delormeloic.generator.view.slidesforms.SlideWithContentForm#getContentTitleTitledPane()
	 */
	@Override
	public String getContentTitleTitledPane()
	{
		return TextHelper.getText("slideWithContentFormImageTitleTitledPane");
	}

	/**
	 * @see com.delormeloic.generator.view.slidesforms.SlideWithContentForm#getExtensionFilter()
	 */
	@Override
	public ExtensionFilter getExtensionFilter()
	{
		return new FileChooser.ExtensionFilter("Images", "*.jpg", "*.png");
	}
}