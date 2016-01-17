package com.delormeloic.generator.view.helpers;

import com.delormeloic.generator.model.slides.IConstants;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.text.Font;

/**
 * This class represents a fonts helper.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class FontsHelper
{
	/**
	 * The fonts.
	 */
	private static final ObservableList<Font> FONTS = FXCollections.observableArrayList();

	/**
	 * Get all available fonts.
	 * 
	 * @return The list of available fonts.
	 */
	public static ObservableList<Font> getAllAvailableFonts()
	{
		if (FONTS.isEmpty())
		{
			for (String fontName : Font.getFontNames())
			{
				FONTS.add(new Font(fontName, IConstants.DEFAULT_FONT_SIZE));
			}
		}

		return FONTS;
	}
}