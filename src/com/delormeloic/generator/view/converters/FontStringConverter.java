package com.delormeloic.generator.view.converters;

import javafx.scene.text.Font;
import javafx.util.StringConverter;

/**
 * This class represents a font string converter.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class FontStringConverter extends StringConverter<Font>
{
	/**
	 * @see javafx.util.StringConverter#toString(java.lang.Object)
	 */
	@Override
	public String toString(Font font)
	{
		return font.getName();
	}

	/**
	 * @see javafx.util.StringConverter#fromString(java.lang.String)
	 */
	@Override
	public Font fromString(String string)
	{
		throw new RuntimeException("Not required for ComboBox");
	}
}