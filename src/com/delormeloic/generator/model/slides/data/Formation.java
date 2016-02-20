package com.delormeloic.generator.model.slides.data;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.delormeloic.generator.model.helpers.StudentParserHelper;
import com.delormeloic.generator.model.slides.IConstants;
import com.delormeloic.generator.model.slides.ISerializable;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * This class represents a formation.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class Formation implements ISerializable
{
	/**
	 * The name attribute.
	 */
	public static final String NAME_ATTRIBUTE = "name";

	/**
	 * The introduction attribute.
	 */
	public static final String INTRODUCTION_ATTRIBUTE = "introduction";

	/**
	 * The students attribute.
	 */
	public static final String STUDENTS_ATTRIBUTE = "students";

	/**
	 * The conclusion attribute.
	 */
	public static final String CONCLUSION_ATTRIBUTE = "conclusion";

	/**
	 * The name.
	 */
	private final StringProperty name;

	/**
	 * The introduction.
	 */
	private final StringProperty introduction;

	/**
	 * The students.
	 */
	private final List<Student> students;

	/**
	 * The conclusion.
	 */
	private final StringProperty conclusion;

	/**
	 * Create a formation.
	 */
	public Formation()
	{
		this.name = new SimpleStringProperty(IConstants.DEFAULT_TEXT);
		this.introduction = new SimpleStringProperty(IConstants.DEFAULT_TEXT);
		this.students = new ArrayList<Student>();
		this.conclusion = new SimpleStringProperty(IConstants.DEFAULT_TEXT);
	}

	/**
	 * Create a formation.
	 * 
	 * @param data
	 *            The data.
	 */
	public Formation(JSONObject data)
	{
		this.name = new SimpleStringProperty(data.getString(NAME_ATTRIBUTE));
		this.introduction = new SimpleStringProperty(data.getString(INTRODUCTION_ATTRIBUTE));
		this.students = new ArrayList<Student>(StudentParserHelper.parseStudents(data.getJSONArray(STUDENTS_ATTRIBUTE)));
		this.conclusion = new SimpleStringProperty(data.getString(CONCLUSION_ATTRIBUTE));
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
	 * Get the introduction.
	 * 
	 * @return The introduction.
	 */
	public String getIntroduction()
	{
		return this.introduction.get();
	}

	/**
	 * Get the introduction property.
	 * 
	 * @return The introduction property.
	 */
	public StringProperty getIntroductionProperty()
	{
		return this.introduction;
	}

	/**
	 * Get the students.
	 * 
	 * @return The list of students.
	 */
	public List<Student> getStudents()
	{
		return this.students;
	}

	/**
	 * Get the conclusion.
	 * 
	 * @return The conclusion.
	 */
	public String getConclusion()
	{
		return this.conclusion.get();
	}

	/**
	 * Get the conclusion property.
	 * 
	 * @return The conclusion property.
	 */
	public StringProperty getConclusionProperty()
	{
		return this.conclusion;
	}

	/**
	 * @see com.delormeloic.generator.model.slides.ISerializable#toJSON()
	 */
	@Override
	public JSONObject toJSON()
	{
		final JSONArray studentsData = new JSONArray();
		for (Student student : this.students)
		{
			studentsData.put(student.toJSON());
		}

		final JSONObject data = new JSONObject();
		data.put(NAME_ATTRIBUTE, getName());
		data.put(INTRODUCTION_ATTRIBUTE, getIntroduction());
		data.put(STUDENTS_ATTRIBUTE, studentsData);
		data.put(CONCLUSION_ATTRIBUTE, getConclusion());

		return data;
	}
}