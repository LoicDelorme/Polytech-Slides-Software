package com.delormeloic.generator.view.slidesforms;

import com.delormeloic.generator.model.slides.Background;
import com.delormeloic.generator.view.helpers.FormBuilderHelper;
import com.delormeloic.generator.view.helpers.TextHelper;

import javafx.scene.Node;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;

/**
 * This class represents a background form.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class BackgroundForm implements IFormable
{
	/**
	 * The background.
	 */
	private final Background background;

	/**
	 * Create a background form.
	 * 
	 * @param background
	 *            The background.
	 */
	public BackgroundForm(Background background)
	{
		this.background = background;
	}

	/**
	 * @see com.delormeloic.generator.view.slidesforms.IFormable#toForm()
	 */
	@Override
	public Node toForm()
	{
		final ColorPicker backgroundColorPicker = new ColorPicker();
		backgroundColorPicker.valueProperty().bindBidirectional(this.background.getBackgroundColorProperty());

		final TitledPane backgroundColorTitledPane = new TitledPane(TextHelper.getText("backgroundFormBackgroundColorTitledPane"), new HBox(backgroundColorPicker));
		backgroundColorTitledPane.setCollapsible(false);

		final TitledPane backgroundTitledPane = FormBuilderHelper.buildTitledPane(TextHelper.getText("backgroundFormBackgroundTitledPane"), new TitledPane[] { backgroundColorTitledPane });

		return FormBuilderHelper.buildTitledPane(TextHelper.getText("slideFormDataTitledPane"), new TitledPane[] { backgroundTitledPane });
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Background";
	}
}