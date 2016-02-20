package com.delormeloic.generator.model.helpers;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.delormeloic.generator.model.slides.data.Formation;

/**
 * This class represents a formation parser helper.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class FormationParserHelper
{
	/**
	 * Parse a JSONArray into a list of formations.
	 * 
	 * @param formations
	 *            The formations.
	 * @return The list of formations.
	 */
	public static List<Formation> parseFormations(JSONArray formations)
	{
		final List<Formation> parsedFormations = new ArrayList<Formation>();
		for (int offset = 0; offset < formations.length(); offset++)
		{
			parsedFormations.add(parseFormation(formations.getJSONObject(offset)));
		}

		return parsedFormations;
	}

	/**
	 * Parse a JSONObject into a formation.
	 * 
	 * @param formation
	 *            The formation.
	 * @return The formation.
	 */
	private static Formation parseFormation(JSONObject formation)
	{
		return new Formation(formation);
	}
}