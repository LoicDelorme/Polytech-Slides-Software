package com.delormeloic.generator.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.delormeloic.generator.controller.helpers.SlideFormParserHelper;
import com.delormeloic.generator.model.IModel;
import com.delormeloic.generator.model.slides.Background;
import com.delormeloic.generator.model.slides.Footer;
import com.delormeloic.generator.model.slides.Header;
import com.delormeloic.generator.model.slides.Slide;
import com.delormeloic.generator.view.IView;
import com.delormeloic.generator.view.slidesforms.BackgroundForm;
import com.delormeloic.generator.view.slidesforms.FooterForm;
import com.delormeloic.generator.view.slidesforms.HeaderForm;
import com.delormeloic.generator.view.slidesforms.SlideForm;

/**
 * This class represents a basic controller.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class BasicController implements IController
{
	/**
	 * The view.
	 */
	private IView view;

	/**
	 * The model.
	 */
	private IModel model;

	/**
	 * Create a basic controller.
	 */
	public BasicController()
	{
		this.view = null;
		this.model = null;
	}

	/**
	 * @see com.delormeloic.generator.controller.IController#bindModel(com.delormeloic.generator.model.IModel)
	 */
	@Override
	public void bindModel(IModel model)
	{
		this.model = model;
	}

	/**
	 * @see com.delormeloic.generator.controller.IController#bindView(com.delormeloic.generator.view.IView)
	 */
	@Override
	public void bindView(IView view)
	{
		this.view = view;
	}

	/**
	 * @see com.delormeloic.generator.controller.IController#notifyCreateNewProject(java.io.File)
	 */
	@Override
	public void notifyCreateNewProject(File selectedFile) throws IOException
	{
		this.model.createNewProject(selectedFile);
	}

	/**
	 * @see com.delormeloic.generator.controller.IController#notifyOpenProject(java.io.File)
	 */
	@Override
	public void notifyOpenProject(File projectFile) throws IOException
	{
		this.model.openProject(projectFile);
	}

	/**
	 * @see com.delormeloic.generator.controller.IController#notifySaveAsProject(java.io.File)
	 */
	@Override
	public void notifySaveAsProject(File newProjectFile) throws IOException
	{
		this.model.saveAsProject(newProjectFile);
	}

	/**
	 * @see com.delormeloic.generator.controller.IController#notifySaveProject()
	 */
	@Override
	public void notifySaveProject() throws IOException
	{
		this.model.saveProject();
	}

	/**
	 * @see com.delormeloic.generator.controller.IController#notifyCloseProject()
	 */
	@Override
	public void notifyCloseProject() throws IOException
	{
		this.model.closeProject();
		this.view.clearData();
	}

	/**
	 * @see com.delormeloic.generator.controller.IController#notifyAddSlideForm(com.delormeloic.generator.view.slidesforms.SlideForm)
	 */
	@Override
	public void notifyAddSlideForm(SlideForm slideForm)
	{
		this.model.addSlide(slideForm.getSlide());
		this.view.addSlideForm(slideForm);
	}

	/**
	 * @see com.delormeloic.generator.controller.IController#notifyMoveUpSlideForm(com.delormeloic.generator.view.slidesforms.SlideForm)
	 */
	@Override
	public void notifyMoveUpSlideForm(SlideForm slideForm)
	{
		this.model.moveUpSlide(slideForm.getSlide());
		this.view.moveUpSlideForm(slideForm);
	}

	/**
	 * @see com.delormeloic.generator.controller.IController#notifyMoveDownSlideForm(com.delormeloic.generator.view.slidesforms.SlideForm)
	 */
	@Override
	public void notifyMoveDownSlideForm(SlideForm slideForm)
	{
		this.model.moveDownSlide(slideForm.getSlide());
		this.view.moveDownSlideForm(slideForm);
	}

	/**
	 * @see com.delormeloic.generator.controller.IController#notifyRemoveSlideForm(com.delormeloic.generator.view.slidesforms.SlideForm)
	 */
	@Override
	public void notifyRemoveSlideForm(SlideForm slideForm)
	{
		this.model.removeSlide(slideForm.getSlide());
		this.view.removeSlideForm(slideForm);
	}

	/**
	 * @see com.delormeloic.generator.controller.IController#notifySetData(com.delormeloic.generator.model.slides.Header, com.delormeloic.generator.model.slides.Footer, com.delormeloic.generator.model.slides.Background, java.util.List)
	 */
	@Override
	public void notifySetData(Header header, Footer footer, Background background, List<Slide> slides)
	{
		this.view.setData(new HeaderForm(header), new FooterForm(footer), new BackgroundForm(background), SlideFormParserHelper.parseSlidesForms(slides));
	}
}