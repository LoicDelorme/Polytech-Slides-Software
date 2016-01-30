package com.delormeloic.generator.view;

import java.util.List;

import com.delormeloic.generator.view.slidesforms.BackgroundForm;
import com.delormeloic.generator.view.slidesforms.FooterForm;
import com.delormeloic.generator.view.slidesforms.HeaderForm;
import com.delormeloic.generator.view.slidesforms.SlideForm;

/**
 * This interface represents the view.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public interface IView
{
	/**
	 * Show window.
	 */
	public void showWindow();

	/**
	 * Close window.
	 */
	public void closeWindow();

	/**
	 * Display new project window.
	 */
	public void displayNewProjectWindow();

	/**
	 * Display open project window.
	 */
	public void displayOpenProjectWindow();

	/**
	 * Display save as project window.
	 */
	public void displaySaveAsProjectWindow();

	/**
	 * Display information pop up window.
	 * 
	 * @param title
	 *            The title to display.
	 * @param text
	 *            The text to display.
	 */
	public void displayInformationPopUpWindow(String title, String text);

	/**
	 * Display error pop up window.
	 * 
	 * @param text
	 *            The text to display.
	 */
	public void displayErrorPopUpWindow(String text);

	/**
	 * Display fatal error pop up window.
	 * 
	 * @param text
	 *            The text to display.
	 */
	public void displayFatalErrorPopUpWindow(String text);

	/**
	 * Set data.
	 * 
	 * @param header
	 *            The header form.
	 * @param footer
	 *            The footer form.
	 * @param background
	 *            The background form.
	 * @param slidesForms
	 *            The slides forms.
	 */
	public void setData(HeaderForm header, FooterForm footer, BackgroundForm background, List<SlideForm> slidesForms);

	/**
	 * Clear data.
	 */
	public void clearData();

	/**
	 * Add a slide form.
	 * 
	 * @param slideForm
	 *            The slide form to add.
	 */
	public void addSlideForm(SlideForm slideForm);

	/**
	 * Move up a slide form.
	 * 
	 * @param slideForm
	 *            The slide form to move up.
	 */
	public void moveUpSlideForm(SlideForm slideForm);

	/**
	 * Move down a slide form.
	 * 
	 * @param slideForm
	 *            The slide form to move down.
	 */
	public void moveDownSlideForm(SlideForm slideForm);

	/**
	 * Remove a slide form.
	 * 
	 * @param slideForm
	 *            The slide form to remove.
	 */
	public void removeSlideForm(SlideForm slideForm);
}