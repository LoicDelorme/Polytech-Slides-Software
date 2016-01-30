package com.delormeloic.generator.view.slidesforms;

import com.delormeloic.generator.model.slides.SlideWithTitle;
import com.delormeloic.generator.view.converters.FontStringConverter;
import com.delormeloic.generator.view.helpers.FontsHelper;
import com.delormeloic.generator.view.helpers.GridPaneHelper;
import com.delormeloic.generator.view.helpers.TextHelper;

import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

/**
 * This class represents a slide with a title form.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class SlideWithTitleForm extends SlideForm
{
	/**
	 * Create a slide with a title form.
	 * 
	 * @param slideWithTitle
	 *            The slide with a title.
	 */
	public SlideWithTitleForm(SlideWithTitle slideWithTitle)
	{
		super(slideWithTitle);
	}

	/**
	 * @see com.delormeloic.generator.view.slidesforms.IFormable#toForm()
	 */
	@Override
	public Node toForm()
	{
		final SlideWithTitle slideWithTitle = (SlideWithTitle) this.slide;

		final TextField nameTextField = new TextField();
		final CheckBox headerCheckBox = new CheckBox();
		final CheckBox footerCheckBox = new CheckBox();
		final TextField titleTextField = new TextField();
		final ComboBox<Font> titleFontComboBox = new ComboBox<Font>();

		titleFontComboBox.getItems().addAll(FontsHelper.getAllAvailableFonts());
		titleFontComboBox.setConverter(new FontStringConverter());

		nameTextField.textProperty().bindBidirectional(slideWithTitle.getNameProperty());
		headerCheckBox.selectedProperty().bindBidirectional(slideWithTitle.getHeaderProperty());
		footerCheckBox.selectedProperty().bindBidirectional(slideWithTitle.getFooterProperty());
		titleTextField.textProperty().bindBidirectional(slideWithTitle.getTitleProperty());
		titleFontComboBox.valueProperty().bindBidirectional(slideWithTitle.getTitleFontProperty());

		final Node[] nameField = new Node[] { new Label(TextHelper.getText("slideWithTitleFormNameField")), nameTextField };
		final Node[] headerField = new Node[] { new Label(TextHelper.getText("slideWithTitleFormHeaderField")), headerCheckBox };
		final Node[] footerField = new Node[] { new Label(TextHelper.getText("slideWithTitleFormFooterField")), footerCheckBox };
		final Node[] titleField = new Node[] { new Label(TextHelper.getText("slideWithTitleFormTitleField")), titleTextField };
		final Node[] titleFontField = new Node[] { new Label(TextHelper.getText("slideWithTitleFormTitleFontField")), titleFontComboBox };

		return GridPaneHelper.buildGridPane(new Node[][] { nameField, GridPaneHelper.getSeparators(2), headerField, footerField, GridPaneHelper.getSeparators(2), titleField, titleFontField });
	}
}