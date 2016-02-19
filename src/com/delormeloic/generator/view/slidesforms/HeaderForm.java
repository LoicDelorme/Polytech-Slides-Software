package com.delormeloic.generator.view.slidesforms;

import com.delormeloic.generator.model.slides.Header;
import com.delormeloic.generator.view.converters.FontStringConverter;
import com.delormeloic.generator.view.helpers.FontsHelper;
import com.delormeloic.generator.view.helpers.FormBuilderHelper;
import com.delormeloic.generator.view.helpers.TextHelper;

import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;

/**
 * This class represents an header form.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class HeaderForm implements IFormable
{
	/**
	 * The header.
	 */
	private final Header header;

	/**
	 * Create an header form.
	 * 
	 * @param header
	 *            The header.
	 */
	public HeaderForm(Header header)
	{
		this.header = header;
	}

	/**
	 * @see com.delormeloic.generator.view.slidesforms.IFormable#toForm()
	 */
	@Override
	public Node toForm()
	{
		final TextField middleTextTextField = new TextField();
		middleTextTextField.textProperty().bindBidirectional(this.header.getMiddleTextProperty());

		final ComboBox<Font> middleTextFontComboBox = new ComboBox<Font>(FontsHelper.getAllAvailableFonts());
		middleTextFontComboBox.setConverter(new FontStringConverter());
		middleTextFontComboBox.valueProperty().bindBidirectional(this.header.getMiddleTextFontProperty());

		final TitledPane middleTextTitledPane = new TitledPane(TextHelper.getText("headerFormMiddleTextTitledPane"), new HBox(middleTextTextField));
		middleTextTitledPane.setCollapsible(false);
		HBox.setHgrow(middleTextTextField, Priority.ALWAYS);
		final TitledPane middleTextFontTitledPane = new TitledPane(TextHelper.getText("headerFormMiddleTextFontTitledPane"), new HBox(middleTextFontComboBox));
		middleTextFontTitledPane.setCollapsible(false);

		final TitledPane middleTitledPane = FormBuilderHelper.buildTitledPane(TextHelper.getText("headerFormMiddleTitledPane"), new TitledPane[] { middleTextTitledPane, middleTextFontTitledPane });

		return FormBuilderHelper.buildTitledPane(TextHelper.getText("slideFormDataTitledPane"), new TitledPane[] { middleTitledPane });
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Header";
	}
}