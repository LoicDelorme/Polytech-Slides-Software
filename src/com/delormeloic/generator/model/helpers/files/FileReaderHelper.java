package com.delormeloic.generator.model.helpers.files;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class represents a file reader helper.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class FileReaderHelper
{
	/**
	 * Read a plain text file.
	 * 
	 * @param file
	 *            The file to read.
	 * @return The data.
	 * @throws IOException
	 *             If the file was not found.
	 */
	public static String readPlainTextFile(File file) throws IOException
	{
		final StringBuilder data = new StringBuilder();
		final Scanner scanner = new Scanner(file);
		while (scanner.hasNextLine())
		{
			data.append(scanner.nextLine());
		}

		scanner.close();

		return data.toString();
	}
}