package com.delormeloic.generator.model;

import java.io.File;
import java.io.IOException;

import com.delormeloic.generator.controller.IController;
import com.delormeloic.generator.model.helpers.FileReaderHelper;
import com.delormeloic.generator.model.helpers.FileWriterHelper;

/**
 * This class represents a plain text file model.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public abstract class PlainTextFileModel extends DefaultModel
{
	/**
	 * The default file encoding.
	 */
	public static final String DEFAULT_FILE_ENCODING = "UTF-8";

	/**
	 * Create a plain text file model.
	 * 
	 * @param controller
	 *            The controller.
	 */
	public PlainTextFileModel(IController controller)
	{
		super(controller);
	}

	/**
	 * @see com.delormeloic.generator.model.IModel#openProject(java.io.File)
	 */
	@Override
	public void openProject(File projectFile) throws IOException
	{
		this.currentProject = projectFile;
		deserializeData(FileReaderHelper.readPlainTextFile(this.currentProject));
		this.controller.notifySetData(this.header, this.footer, this.background, this.slides);
	}

	/**
	 * @see com.delormeloic.generator.model.IModel#saveProject()
	 */
	@Override
	public void saveProject() throws IOException
	{
		FileWriterHelper.writePlainTextFile(serializeData(), this.currentProject, DEFAULT_FILE_ENCODING);
	}
}