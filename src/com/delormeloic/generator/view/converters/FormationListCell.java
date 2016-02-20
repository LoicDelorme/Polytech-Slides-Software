package com.delormeloic.generator.view.converters;

import com.delormeloic.generator.model.slides.data.Formation;

import javafx.scene.control.ListCell;

/**
 * This class represents a formation list cell.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class FormationListCell extends ListCell<Formation>
{
	@Override
	public void updateItem(Formation item, boolean empty)
	{
		super.updateItem(item, empty);

		if (item != null)
		{
			textProperty().bind(item.getNameProperty());
		}
		else
		{
			textProperty().unbind();
			setText("");
		}
	}
}