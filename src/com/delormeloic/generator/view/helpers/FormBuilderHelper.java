package com.delormeloic.generator.view.helpers;

import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

/**
 * This class represents a form builder helper.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class FormBuilderHelper
{
	/**
	 * Build a form.
	 * 
	 * @param title
	 *            The title.
	 * @param titledPanes
	 *            The titled panes.
	 * @return The form.
	 */
	public static TitledPane buildTitledPane(String title, TitledPane[] titledPanes)
	{
		return new TitledPane(title, new VBox(titledPanes));
	}
}