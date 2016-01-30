package com.delormeloic.generator.model.slides;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * This interface represents all useful constants.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public interface IConstants
{
	/**
	 * The default font.
	 */
	public static final Font DEFAULT_FONT = Font.getDefault();

	/**
	 * The default font size.
	 */
	public static final int DEFAULT_FONT_SIZE = 12;

	/**
	 * The default header value.
	 */
	public static final boolean DEFAULT_HEADER_VALUE = false;

	/**
	 * The default footer value.
	 */
	public static final boolean DEFAULT_FOOTER_VALUE = false;

	/**
	 * The default text.
	 */
	public static final String DEFAULT_TEXT = "";

	/**
	 * The default background color.
	 */
	public static final Color DEFAULT_BACKGROUND_COLOR = new Color(0, 155, 221, 1);
}