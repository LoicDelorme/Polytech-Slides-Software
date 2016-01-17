package com.delormeloic.generator.view.slidesforms;

import com.delormeloic.generator.model.slides.Header;
import com.delormeloic.generator.view.converters.FontStringConverter;
import com.delormeloic.generator.view.helpers.FontsHelper;
import com.delormeloic.generator.view.helpers.GridPaneHelper;
import com.delormeloic.generator.view.helpers.SpinnerHelper;
import com.delormeloic.generator.view.helpers.TextHelper;

import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
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
		final ComboBox<Font> middleTextFontComboBox = new ComboBox<Font>();
		final Spinner<Integer> middleTextSizeSpinner = new Spinner<Integer>();

		middleTextFontComboBox.getItems().addAll(FontsHelper.getAllAvailableFonts());
		middleTextFontComboBox.setConverter(new FontStringConverter());
		middleTextSizeSpinner.setValueFactory(SpinnerHelper.getDefaultTextSizeSpinnerValueFactory());

		middleTextTextField.textProperty().bindBidirectional(this.header.getMiddleTextProperty());
		middleTextFontComboBox.valueProperty().bindBidirectional(this.header.getMiddleTextFontProperty());
		middleTextSizeSpinner.getValueFactory().valueProperty().bindBidirectional(this.header.getMiddleTextSizeProperty().asObject());

		final Node[] middleTextField = new Node[] { new Label(TextHelper.getText("headerFormMiddleTextField")), middleTextTextField };
		final Node[] middleTextFontField = new Node[] { new Label(TextHelper.getText("headerFormMiddleTextFontField")), middleTextFontComboBox };
		final Node[] middleTextSizeField = new Node[] { new Label(TextHelper.getText("headerFormMiddleTextSizeField")), middleTextSizeSpinner };

		return GridPaneHelper.buildGridPane(new Node[][] { middleTextField, middleTextFontField, middleTextSizeField });
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