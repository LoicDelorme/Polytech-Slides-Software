package com.delormeloic.generator.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.delormeloic.generator.model.IModel;
import com.delormeloic.generator.model.slides.Footer;
import com.delormeloic.generator.model.slides.Header;
import com.delormeloic.generator.model.slides.Slide;
import com.delormeloic.generator.view.IView;
import com.delormeloic.generator.view.slidesforms.SlideForm;

/**
 * This interface represents the controller.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public interface IController
{
	/**
	 * Bind the model to the controller.
	 * 
	 * @param model
	 *            The model.
	 */
	public void bindModel(IModel model);

	/**
	 * Bind the view to the controller.
	 * 
	 * @param view
	 *            The view.
	 */
	public void bindView(IView view);

	/**
	 * Notify create new project.
	 * 
	 * @param selectedFile
	 *            The selected file.
	 * @throws IOException
	 *             If data can't be written.
	 */
	public void notifyCreateNewProject(File selectedFile) throws IOException;

	/**
	 * Notify open project.
	 * 
	 * @param projectFile
	 *            The project file to open.
	 * @throws IOException
	 *             If data can't be read.
	 */
	public void notifyOpenProject(File projectFile) throws IOException;

	/**
	 * Notify save as project.
	 * 
	 * @param newProjectFile
	 *            The new project file.
	 * @throws IOException
	 *             If data can't be written.
	 */
	public void notifySaveAsProject(File newProjectFile) throws IOException;

	/**
	 * Notify save project.
	 * 
	 * @throws IOException
	 *             If data can't be written.
	 */
	public void notifySaveProject() throws IOException;

	/**
	 * Notify close project.
	 * 
	 * @throws IOException
	 *             If data can't be written.
	 */
	public void notifyCloseProject() throws IOException;

	/**
	 * Notify add a slide form.
	 * 
	 * @param slideForm
	 *            The slide form to add.
	 */
	public void notifyAddSlideForm(SlideForm slideForm);

	/**
	 * Notify move up a slide form.
	 * 
	 * @param slideForm
	 *            The slide form to move up.
	 */
	public void notifyMoveUpSlideForm(SlideForm slideForm);

	/**
	 * Notify move down a slide form.
	 * 
	 * @param slideForm
	 *            The slide form to move down.
	 */
	public void notifyMoveDownSlideForm(SlideForm slideForm);

	/**
	 * Notify remove a slide form.
	 * 
	 * @param slideForm
	 *            The slide form to remove.
	 */
	public void notifyRemoveSlideForm(SlideForm slideForm);

	/**
	 * Notify set data.
	 * 
	 * @param header
	 *            The header.
	 * @param footer
	 *            The footer.
	 * @param slides
	 *            The slides.
	 */
	public void notifySetData(Header header, Footer footer, List<Slide> slides);
}