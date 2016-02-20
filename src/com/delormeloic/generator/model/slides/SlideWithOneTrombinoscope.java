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
 * This class represents a slide with one trombinoscope.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class SlideWithOneTrombinoscope extends Slide
{
	/**
	 * The class for name.
	 */
	public static final String CLASS_FOR_NAME = "SlideWithOneTrombinoscope";

	/**
	 * The header attribute.
	 */
	public static final String HEADER_ATTRIBUTE = "header";

	/**
	 * The footer attribute.
	 */
	public static final String FOOTER_ATTRIBUTE = "footer";

	/**
	 * The formations attribute.
	 */
	public static final String FORMATIONS_ATTRIBUTE = "formations";

	/**
	 * The header.
	 */
	private final BooleanProperty header;

	/**
	 * The footer.
	 */
	private final BooleanProperty footer;

	/**
	 * The formations.
	 */
	private final List<Formation> formations;

	/**
	 * Create a slide with one trombinoscope.
	 * 
	 * @param name
	 *            The name.
	 * @param data
	 *            The data.
	 */
	public SlideWithOneTrombinoscope(String name, JSONObject data)
	{
		super(CLASS_FOR_NAME, name);
		this.header = new SimpleBooleanProperty(data.getBoolean(HEADER_ATTRIBUTE));
		this.footer = new SimpleBooleanProperty(data.getBoolean(FOOTER_ATTRIBUTE));
		this.formations = new ArrayList<Formation>(FormationParserHelper.parseFormations(data.getJSONArray(FORMATIONS_ATTRIBUTE)));
	}

	/**
	 * Create a slide with one trombinoscope.
	 * 
	 * @param name
	 *            The name.
	 */
	public SlideWithOneTrombinoscope(String name)
	{
		super(CLASS_FOR_NAME, name);
		this.header = new SimpleBooleanProperty(IConstants.DEFAULT_HEADER_VALUE);
		this.footer = new SimpleBooleanProperty(IConstants.DEFAULT_FOOTER_VALUE);
		this.formations = new ArrayList<Formation>();
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
	 * Get the formations.
	 * 
	 * @return The formations.
	 */
	public List<Formation> getFormations()
	{
		return this.formations;
	}

	/**
	 * @see com.delormeloic.generator.model.slides.Slide#getData()
	 */
	@Override
	public JSONObject getData()
	{
		final JSONArray formationsData = new JSONArray();
		for (Formation formation : this.formations)
		{
			formationsData.put(formation.toJSON());
		}

		final JSONObject data = new JSONObject();
		data.put(HEADER_ATTRIBUTE, getHeader());
		data.put(FOOTER_ATTRIBUTE, getFooter());
		data.put(FORMATIONS_ATTRIBUTE, formationsData);

		return data;
	}
}