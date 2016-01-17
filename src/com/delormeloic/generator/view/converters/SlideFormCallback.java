package com.delormeloic.generator.view.converters;

import com.delormeloic.generator.view.slidesforms.SlideForm;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

/**
 * This class represents a slide form callback.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class SlideFormCallback implements Callback<ListView<SlideForm>, ListCell<SlideForm>>
{
	/**
	 * @see javafx.util.Callback#call(java.lang.Object)
	 */
	@Override
	public ListCell<SlideForm> call(ListView<SlideForm> param)
	{
		return new SlideFormListCell();
	}
}