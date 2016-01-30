package com.delormeloic.generator.view.slidesforms;

import com.delormeloic.generator.model.slides.Background;
import com.delormeloic.generator.view.helpers.GridPaneHelper;
import com.delormeloic.generator.view.helpers.TextHelper;

import javafx.scene.Node;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;

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

		final Node[] backgroundColorField = new Node[] { new Label(TextHelper.getText("backgroundFormBackgroundColorField")), backgroundColorPicker };

		return GridPaneHelper.buildGridPane(new Node[][] { backgroundColorField });
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