package com.delormeloic.generator.model.helpers;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.delormeloic.generator.model.slides.data.Student;

/**
 * This class represents a student parser helper.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class StudentParserHelper
{
	/**
	 * Parse a JSONArray into a list of students.
	 * 
	 * @param students
	 *            The students.
	 * @return The list of students.
	 */
	public static List<Student> parseStudents(JSONArray students)
	{
		final List<Student> parsedStudents = new ArrayList<Student>();
		for (int offset = 0; offset < students.length(); offset++)
		{
			parsedStudents.add(parseStudent(students.getJSONObject(offset)));
		}

		return parsedStudents;
	}

	/**
	 * Parse a JSONObject into a student.
	 * 
	 * @param student
	 *            The student.
	 * @return The student.
	 */
	private static Student parseStudent(JSONObject student)
	{
		return new Student(student);
	}
}