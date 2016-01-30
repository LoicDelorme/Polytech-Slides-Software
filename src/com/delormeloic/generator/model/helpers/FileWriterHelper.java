package com.delormeloic.generator.model.helpers;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This class represents a file writer helper.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class FileWriterHelper
{
	/**
	 * Write a plain text file.
	 * 
	 * @param data
	 *            The data to write.
	 * @param file
	 *            The file which will be filled with data.
	 * @param encoding
	 *            The encoding.
	 * @throws IOException
	 *             If data cannot be written.
	 */
	public static void writePlainTextFile(String data, File file, String encoding) throws IOException
	{
		final PrintWriter writer = new PrintWriter(file, encoding);
		writer.write(data);
		writer.close();
	}
}