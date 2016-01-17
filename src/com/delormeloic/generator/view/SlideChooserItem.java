package com.delormeloic.generator.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This class represents a slide chooser item.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class SlideChooserItem extends Button
{
	/**
	 * The slide type.
	 */
	private final SlideType slideType;

	/**
	 * Create a slide chooser item.
	 * 
	 * @param slideType
	 *            The slide type.
	 * @param eventHandler
	 *            The event handler.
	 */
	public SlideChooserItem(SlideType slideType, EventHandler<ActionEvent> eventHandler)
	{
		this.setGraphic(new ImageView(new Image(this.getClass().getResourceAsStream(slideType.getImagePath()))));
		this.setContentDisplay(ContentDisplay.TOP);
		this.setOnAction(eventHandler);

		this.slideType = slideType;
	}

	/**
	 * Get the slide type.
	 * 
	 * @return The slide type.
	 */
	public SlideType getSlideType()
	{
		return this.slideType;
	}
}