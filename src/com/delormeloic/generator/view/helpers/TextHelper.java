package com.delormeloic.generator.view.helpers;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * This class represents a text helper.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class TextHelper
{
	/**
	 * The resource bundle.
	 */
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("com/delormeloic/generator/view/resources/i18n/generator", Locale.FRANCE);

	/**
	 * Get the text corresponding to the key.
	 * 
	 * @param key
	 *            The key.
	 * @return The corresponding text.
	 */
	public static String getText(String key)
	{
		return RESOURCE_BUNDLE.getString(key);
	}
}