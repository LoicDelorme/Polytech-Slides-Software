package com.delormeloic.generator.model.slides;

import org.json.JSONObject;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * This class represents a slide.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public abstract class Slide implements ISerializable
{
	/**
	 * The class for name attribute.
	 */
	public static final String CLASS_FOR_NAME_ATTRIBUTE = "classForName";

	/**
	 * The name attribute.
	 */
	public static final String NAME_ATTRIBUTE = "name";

	/**
	 * The data attribute.
	 */
	public static final String DATA_ATTRIBUTE = "data";

	/**
	 * The class for name.
	 */
	private final String classForName;

	/**
	 * The name.
	 */
	private final StringProperty name;

	/**
	 * Create a slide.
	 * 
	 * @param classForName
	 *            The class for name.
	 * @param name
	 *            The name.
	 */
	public Slide(String classForName, String name)
	{
		this.classForName = classForName;
		this.name = new SimpleStringProperty(name);
	}

	/**
	 * Get the class for name.
	 * 
	 * @return The class for name.
	 */
	public String getClassForName()
	{
		return this.classForName;
	}

	/**
	 * Get the name.
	 * 
	 * @return The name.
	 */
	public String getName()
	{
		return this.name.get();
	}

	/**
	 * Get the name property.
	 * 
	 * @return The name property.
	 */
	public StringProperty getNameProperty()
	{
		return this.name;
	}

	/**
	 * Get the data.
	 * 
	 * @return The data.
	 */
	public abstract JSONObject getData();

	/**
	 * @see com.delormeloic.generator.model.slides.ISerializable#toJSON()
	 */
	@Override
	public JSONObject toJSON()
	{
		final JSONObject data = new JSONObject();
		data.put(CLASS_FOR_NAME_ATTRIBUTE, this.classForName);
		data.put(NAME_ATTRIBUTE, getName());
		data.put(DATA_ATTRIBUTE, getData());

		return data;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		return (this.classForName.hashCode() + getName().hashCode() + getData().hashCode());
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object object)
	{
		if (object == null)
		{
			return false;
		}

		if (this == object)
		{
			return true;
		}

		if (!(object instanceof Slide))
		{
			return false;
		}

		final Slide slide = (Slide) object;

		if (!this.classForName.equals(slide.classForName))
		{
			return false;
		}

		if (!getName().equals(slide.getName()))
		{
			return false;
		}

		if (!getData().equals(slide.getData()))
		{
			return false;
		}

		return true;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return toJSON().toString();
	}
}