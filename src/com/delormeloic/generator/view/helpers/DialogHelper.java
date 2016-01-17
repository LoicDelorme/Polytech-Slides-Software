package com.delormeloic.generator.view.helpers;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * This class represents a dialog helper.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class DialogHelper
{
	/**
	 * Display an information dialog.
	 * 
	 * @param title
	 *            The title.
	 * @param content
	 *            The content.
	 */
	public static void displayInformationDialog(String title, String content)
	{
		createDialog(TextHelper.getText("dialogHelperInformationTitle"), title, content, AlertType.INFORMATION);
	}

	/**
	 * Display an error dialog.
	 * 
	 * @param content
	 *            The content.
	 */
	public static void displayErrorDialog(String content)
	{
		createDialog(TextHelper.getText("dialogHelperErrorTitle"), TextHelper.getText("dialogHelperErrorHeader"), content, AlertType.ERROR);
	}

	/**
	 * Display a fatal error dialog.
	 * 
	 * @param content
	 *            The content.
	 */
	public static void displayFatalErrorDialog(String content)
	{
		createDialog(TextHelper.getText("dialogHelperFatalErrorTitle"), TextHelper.getText("dialogHelperFatalErrorHeader"), content, AlertType.ERROR);
	}

	/**
	 * Create a dialog.
	 * 
	 * @param title
	 *            The title.
	 * @param header
	 *            The header.
	 * @param content
	 *            The content.
	 * @param alertType
	 *            The alert type.
	 */
	private static void createDialog(String title, String header, String content, AlertType alertType)
	{
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);

		alert.showAndWait();
	}
}