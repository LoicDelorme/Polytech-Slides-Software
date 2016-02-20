package com.delormeloic.generator.model.slides;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.delormeloic.generator.model.helpers.FormationParserHelper;
import com.delormeloic.generator.model.slides.data.Formation;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

/**
 * This class represents a slide with two trombinoscope.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class SlideWithTwoTrombinoscope extends Slide
{
	/**
	 * The class for name.
	 */
	public static final String CLASS_FOR_NAME = "SlideWithTwoTrombinoscope";

	/**
	 * The header attribute.
	 */
	public static final String HEADER_ATTRIBUTE = "header";

	/**
	 * The footer attribute.
	 */
	public static final String FOOTER_ATTRIBUTE = "footer";

	/**
	 * The left formations attribute.
	 */
	public static final String LEFT_FORMATIONS_ATTRIBUTE = "leftFormations";

	/**
	 * The right formations attribute.
	 */
	public static final String RIGHT_FORMATIONS_ATTRIBUTE = "rightFormations";

	/**
	 * The header.
	 */
	private final BooleanProperty header;

	/**
	 * The footer.
	 */
	private final BooleanProperty footer;

	/**
	 * The left formations.
	 */
	private final List<Formation> leftFormations;

	/**
	 * The right formations.
	 */
	private final List<Formation> rightFormations;

	/**
	 * Create a slide with two trombinoscope.
	 * 
	 * @param name
	 *            The name.
	 * @param data
	 *            The data.
	 */
	public SlideWithTwoTrombinoscope(String name, JSONObject data)
	{
		super(CLASS_FOR_NAME, name);
		this.header = new SimpleBooleanProperty(data.getBoolean(HEADER_ATTRIBUTE));
		this.footer = new SimpleBooleanProperty(data.getBoolean(FOOTER_ATTRIBUTE));
		this.leftFormations = new ArrayList<Formation>(FormationParserHelper.parseFormations(data.getJSONArray(LEFT_FORMATIONS_ATTRIBUTE)));
		this.rightFormations = new ArrayList<Formation>(FormationParserHelper.parseFormations(data.getJSONArray(RIGHT_FORMATIONS_ATTRIBUTE)));
	}

	/**
	 * Create a slide with two trombinoscope.
	 * 
	 * @param name
	 *            The name.
	 */
	public SlideWithTwoTrombinoscope(String name)
	{
		super(CLASS_FOR_NAME, name);
		this.header = new SimpleBooleanProperty(IConstants.DEFAULT_HEADER_VALUE);
		this.footer = new SimpleBooleanProperty(IConstants.DEFAULT_FOOTER_VALUE);
		this.leftFormations = new ArrayList<Formation>();
		this.rightFormations = new ArrayList<Formation>();
	}

	/**
	 * Get the header.
	 * 
	 * @return The header.
	 */
	public boolean getHeader()
	{
		return this.header.get();
	}

	/**
	 * Get the header property.
	 * 
	 * @return The header property.
	 */
	public BooleanProperty getHeaderProperty()
	{
		return this.header;
	}

	/**
	 * Get the footer.
	 * 
	 * @return The footer.
	 */
	public boolean getFooter()
	{
		return this.footer.get();
	}

	/**
	 * Get the footer property.
	 * 
	 * @return The footer property.
	 */
	public BooleanProperty getFooterProperty()
	{
		return this.footer;
	}

	/**
	 * Get the left formations.
	 * 
	 * @return The left formations.
	 */
	public List<Formation> getLeftFormations()
	{
		return this.leftFormations;
	}

	/**
	 * Get the right formations.
	 * 
	 * @return The right formations.
	 */
	public List<Formation> getRightFormations()
	{
		return this.rightFormations;
	}

	/**
	 * @see com.delormeloic.generator.model.slides.Slide#getData()
	 */
	@Override
	public JSONObject getData()
	{
		final JSONArray leftFormationsData = new JSONArray();
		for (Formation formation : this.leftFormations)
		{
			leftFormationsData.put(formation.toJSON());
		}

		final JSONArray rightFormationsData = new JSONArray();
		for (Formation formation : this.rightFormations)
		{
			rightFormationsData.put(formation.toJSON());
		}

		final JSONObject data = new JSONObject();
		data.put(HEADER_ATTRIBUTE, getHeader());
		data.put(FOOTER_ATTRIBUTE, getFooter());
		data.put(LEFT_FORMATIONS_ATTRIBUTE, leftFormationsData);
		data.put(RIGHT_FORMATIONS_ATTRIBUTE, rightFormationsData);

		return data;
	}
}