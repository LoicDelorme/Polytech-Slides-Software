package com.delormeloic.generator.view.slidesforms;

import javafx.scene.Node;

/**
 * This interface represents a formable object.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public interface IFormable
{
	/**
	 * Get the form.
	 * 
	 * @return The form.
	 */
	public Node toForm();
}