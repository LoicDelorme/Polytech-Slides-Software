package com.delormeloic.generator.view;

import java.util.ArrayList;
import java.util.List;

import com.delormeloic.generator.controller.IController;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;

/**
 * This class represents a slide chooser.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class SlideChooser extends GridPane implements EventHandler<ActionEvent>
{
	/**
	 * The number of slides by line.
	 */
	public static final int NUMBER_OF_SLIDES_BY_LINE = 8;

	/**
	 * The list of slides choosers items.
	 */
	private final List<SlideChooserItem> items = new ArrayList<SlideChooserItem>();

	{
		for (SlideType slideType : SlideType.values())
		{
			this.items.add(new SlideChooserItem(slideType, this));
		}
	}

	/**
	 * The controller.
	 */
	private final IController controller;

	/**
	 * Create a new slide chooser.
	 * 
	 * @param controller
	 *            The controller.
	 */
	public SlideChooser(IController controller)
	{
		this.controller = controller;
		initializeGridPane();
	}

	/**
	 * Initialize the grid pane.
	 */
	private void initializeGridPane()
	{
		this.setVgap(10);
		this.setHgap(10);

		loop:
		{
			int currentItem = 0;
			for (int x = 0; x < Math.ceil((double) this.items.size() / NUMBER_OF_SLIDES_BY_LINE); x++)
			{
				for (int y = 0; y < NUMBER_OF_SLIDES_BY_LINE; y++)
				{
					if (currentItem == this.items.size())
					{
						break loop;
					}

					this.add(this.items.get(currentItem++), y, x);
				}
			}
		}
	}

	/**
	 * @see javafx.event.EventHandler#handle(javafx.event.Event)
	 */
	@Override
	public void handle(ActionEvent event)
	{
		final SlideChooserItem selectedSlideChooserItem = (SlideChooserItem) event.getSource();
		this.controller.notifyAddSlideForm(selectedSlideChooserItem.getSlideType().getSlideFormInstance());
	}
}