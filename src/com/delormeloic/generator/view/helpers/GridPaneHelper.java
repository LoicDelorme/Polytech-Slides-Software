package com.delormeloic.generator.view.helpers;

import javafx.scene.Node;
import javafx.scene.control.Separator;
import javafx.scene.layout.GridPane;

/**
 * This class represents a grid pane helper.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class GridPaneHelper
{
	/**
	 * Build a grid pane.
	 * 
	 * @param nodes
	 *            The nodes.
	 * @return The built grid pane.
	 */
	public static GridPane buildGridPane(Node[][] nodes)
	{
		final GridPane gridPane = new GridPane();
		gridPane.setHgap(15);
		gridPane.setVgap(15);

		for (int mainOffset = 0; mainOffset < nodes.length; mainOffset++)
		{
			for (int secondOffset = 0; secondOffset < nodes[mainOffset].length; secondOffset++)
			{
				gridPane.add(nodes[mainOffset][secondOffset], secondOffset, mainOffset);
			}
		}

		return gridPane;
	}

	/**
	 * Get the separators.
	 * 
	 * @param numberOfSeperators
	 *            The number of separators.
	 * @return The separators.
	 */
	public static Node[] getSeparators(int numberOfSeperators)
	{
		final Node[] separators = new Node[numberOfSeperators];
		for (int offset = 0; offset < separators.length; offset++)
		{
			separators[offset] = new Separator();
		}

		return separators;
	}
}