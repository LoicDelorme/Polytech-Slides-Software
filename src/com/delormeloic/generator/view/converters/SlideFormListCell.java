package com.delormeloic.generator.view.converters;

import com.delormeloic.generator.view.slidesforms.SlideForm;

import javafx.scene.control.ListCell;

/**
 * This class represents a slide form list cell.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class SlideFormListCell extends ListCell<SlideForm>
{
	@Override
	public void updateItem(SlideForm item, boolean empty)
	{
		super.updateItem(item, empty);

		if (item != null)
		{
			textProperty().bind(item.getSlide().getNameProperty());
		}
		else
		{
			textProperty().unbind();
			setText("");
		}
	}
}