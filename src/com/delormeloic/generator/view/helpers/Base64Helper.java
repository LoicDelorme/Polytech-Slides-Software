package com.delormeloic.generator.view.helpers;

import java.io.File;
import java.io.FileInputStream;

import javax.xml.bind.DatatypeConverter;

import com.delormeloic.utils.logger.Logger;

/**
 * This class represents a Base 64 helper.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class Base64Helper
{
	/**
	 * Encode a file.
	 * 
	 * @param file
	 *            The file to encode.
	 * @return The string representation of the file.
	 */
	public static String encode(File file)
	{
		try
		{
			final byte[] data = new byte[(int) file.length()];
			final FileInputStream fileInputStream = new FileInputStream(file);
			fileInputStream.read(data);
			fileInputStream.close();
			return DatatypeConverter.printBase64Binary(data);
		}
		catch (Exception e)
		{
			Logger.severe(e);
			return null;
		}
	}

	/**
	 * Decode a Base 64 string.
	 * 
	 * @param data
	 *            The data.
	 * @return The byte representation of the data.
	 */
	public static byte[] decode(String data)
	{
		return DatatypeConverter.parseBase64Binary(data);
	}
}