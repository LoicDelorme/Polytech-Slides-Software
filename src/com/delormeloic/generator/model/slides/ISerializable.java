package com.delormeloic.generator.model.slides;

import org.json.JSONObject;

/**
 * This interface represents a serializable object.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public interface ISerializable
{
	/**
	 * Get the JSON representation.
	 * 
	 * @return The JSON representation.
	 */
	public JSONObject toJSON();
}