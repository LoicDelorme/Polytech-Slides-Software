package com.delormeloic.generator.view.helpers;

import com.delormeloic.generator.model.slides.IConstants;

import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;

/**
 * This class represents a size spinner helper.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class SpinnerHelper
{
	/**
	 * Get default text size spinner value factory.
	 * 
	 * @return The default text size spinner value factory.
	 */
	public static IntegerSpinnerValueFactory getDefaultTextSizeSpinnerValueFactory()
	{
		return new IntegerSpinnerValueFactory(1, 40, IConstants.DEFAULT_FONT_SIZE, 1);
	}

	/**
	 * Get default image size spinner value factory.
	 * 
	 * @return The default image size spinner value factory.
	 */
	public static IntegerSpinnerValueFactory getDefaultImageSizeSpinnerValueFactory()
	{
		return new IntegerSpinnerValueFactory(1, 2000, IConstants.DEFAULT_IMAGE_WIDTH, 50);
	}
}