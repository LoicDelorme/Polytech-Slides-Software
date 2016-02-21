package com.delormeloic.generator.model.slides;

import java.util.regex.Pattern;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;

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
	public static final boolean DEFAULT_FOOTER_VALUE = true;

	/**
	 * The default text.
	 */
	public static final String DEFAULT_TEXT = "";

	/**
	 * The default background color.
	 */
	public static final Color DEFAULT_BACKGROUND_COLOR = Color.rgb(0, 155, 221);

	/**
	 * The default formation name.
	 */
	public static final String DEFAULT_FORMATION_NAME = "Computer Science";

	/**
	 * The default image extension filter.
	 */
	public static final FileChooser.ExtensionFilter DEFAULT_IMAGE_EXTENSION_FILTER = new FileChooser.ExtensionFilter("Images", "*.jpg", "*.png");

	/**
	 * The default movie extension filter.
	 */
	public static final FileChooser.ExtensionFilter DEFAULT_MOVIE_EXTENSION_FILTER = new FileChooser.ExtensionFilter("Movies", "*.mp4");

	/**
	 * The default student pattern 'STUDENTNUMBER_LASTNAME_FIRSTNAME'.
	 */
	public static final Pattern DEFAULT_STUDENT_PATTERN = Pattern.compile("(.*?)_(.*?)_(.*?).(jpg|png)");
}