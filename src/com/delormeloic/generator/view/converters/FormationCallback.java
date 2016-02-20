package com.delormeloic.generator.view.converters;

import com.delormeloic.generator.model.slides.data.Formation;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

/**
 * This class represents a formation callback.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class FormationCallback implements Callback<ListView<Formation>, ListCell<Formation>>
{
	/**
	 * @see javafx.util.Callback#call(java.lang.Object)
	 */
	@Override
	public ListCell<Formation> call(ListView<Formation> param)
	{
		return new FormationListCell();
	}
}