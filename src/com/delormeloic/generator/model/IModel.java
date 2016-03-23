package com.delormeloic.generator.model;

import java.io.File;
import java.io.IOException;

import com.delormeloic.generator.model.slides.Slide;

/**
 * This interface represents the model.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public interface IModel
{
	/**
	 * The default file extension.
	 */
	public static final String DEFAULT_FILE_EXTENSION = ".data";

	/**
	 * The default file extension pattern.
	 */
	public static final String DEFAULT_FILE_EXTENSION_PATTERN = "*.data";

	/**
	 * Create a new project.
	 * 
	 * @param newProject
	 *            The new project.
	 * @throws IOException
	 *             If data can't be written.
	 */
	public void createNewProject(File newProject) throws IOException;

	/**
	 * Open a project.
	 * 
	 * @param projectFile
	 *            The project to open.
	 * @throws IOException
	 *             If data can't be read.
	 */
	public void openProject(File projectFile) throws IOException;

	/**
	 * Save the project as.
	 * 
	 * @param newProjectFile
	 *            The new project file.
	 * @throws IOException
	 *             If data can't be written.
	 */
	public void saveAsProject(File newProjectFile) throws IOException;

	/**
	 * Save the project.
	 * 
	 * @throws IOException
	 *             If data can't be written.
	 */
	public void saveProject() throws IOException;

	/**
	 * Close the current project.
	 * 
	 * @throws IOException
	 *             If data can't be written.
	 */
	public void closeProject() throws IOException;

	/**
	 * Add a new slide.
	 * 
	 * @param slide
	 *            The slide to add.
	 */
	public void addSlide(Slide slide);

	/**
	 * Move up a slide.
	 * 
	 * @param slide
	 *            The slide to move up.
	 */
	public void moveUpSlide(Slide slide);

	/**
	 * Move down a slide.
	 * 
	 * @param slide
	 *            The slide to move down.
	 */
	public void moveDownSlide(Slide slide);

	/**
	 * Remove a slide.
	 * 
	 * @param slide
	 *            The slide to remove.
	 */
	public void removeSlide(Slide slide);
}