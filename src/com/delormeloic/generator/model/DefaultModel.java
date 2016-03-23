package com.delormeloic.generator.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.delormeloic.generator.controller.IController;
import com.delormeloic.generator.model.slides.Background;
import com.delormeloic.generator.model.slides.Footer;
import com.delormeloic.generator.model.slides.Header;
import com.delormeloic.generator.model.slides.Slide;

/**
 * This class represents the default model.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public abstract class DefaultModel implements IModel
{
	/**
	 * The controller.
	 */
	protected final IController controller;

	/**
	 * The header.
	 */
	protected Header header;

	/**
	 * The footer.
	 */
	protected Footer footer;

	/**
	 * The background.
	 */
	protected Background background;

	/**
	 * The slides.
	 */
	protected List<Slide> slides;

	/**
	 * The current project.
	 */
	protected File currentProject;

	/**
	 * Create a default model.
	 * 
	 * @param controller
	 *            The controller.
	 */
	public DefaultModel(IController controller)
	{
		this.controller = controller;
		this.header = null;
		this.footer = null;
		this.background = null;
		this.slides = null;
		this.currentProject = null;
	}

	/**
	 * Serialize data.
	 * 
	 * @return The serialized data.
	 */
	public abstract String serializeData();

	/**
	 * Deserialize data.
	 * 
	 * @param data
	 *            The data to deserialize.
	 */
	public abstract void deserializeData(String data);

	/**
	 * @see com.delormeloic.generator.model.IModel#createNewProject(java.io.File)
	 */
	@Override
	public void createNewProject(File newProject) throws IOException
	{
		this.header = new Header();
		this.footer = new Footer();
		this.background = new Background();
		this.slides = new ArrayList<Slide>();
		this.currentProject = newProject;
		saveProject();
		this.controller.notifySetData(this.header, this.footer, this.background, this.slides);
	}

	/**
	 * @see com.delormeloic.generator.model.IModel#saveAsProject(java.io.File)
	 */
	@Override
	public void saveAsProject(File newProjectFile) throws IOException
	{
		this.currentProject = newProjectFile;
		saveProject();
	}

	/**
	 * @see com.delormeloic.generator.model.IModel#closeProject()
	 */
	@Override
	public void closeProject() throws IOException
	{
		saveProject();
		this.header = null;
		this.footer = null;
		this.background = null;
		this.slides = null;
		this.currentProject = null;
	}

	/**
	 * @see com.delormeloic.generator.model.IModel#addSlide(com.delormeloic.generator.model.slides.Slide)
	 */
	@Override
	public void addSlide(Slide slide)
	{
		this.slides.add(slide);
	}

	/**
	 * @see com.delormeloic.generator.model.IModel#moveUpSlide(com.delormeloic.generator.model.slides.Slide)
	 */
	@Override
	public void moveUpSlide(Slide slide)
	{
		swapSlide(slide, -1);
	}

	/**
	 * @see com.delormeloic.generator.model.IModel#moveDownSlide(com.delormeloic.generator.model.slides.Slide)
	 */
	@Override
	public void moveDownSlide(Slide slide)
	{
		swapSlide(slide, 1);
	}

	/**
	 * Swap a slide.
	 * 
	 * @param slide
	 *            The slide to swap.
	 * @param offset
	 *            The offset.
	 */
	private void swapSlide(Slide slide, int offset)
	{
		final int currentIndex = this.slides.indexOf(slide);
		Collections.swap(this.slides, currentIndex, currentIndex + offset);
	}

	/**
	 * @see com.delormeloic.generator.model.IModel#removeSlide(com.delormeloic.generator.model.slides.Slide)
	 */
	@Override
	public void removeSlide(Slide slide)
	{
		this.slides.remove(slide);
	}
}