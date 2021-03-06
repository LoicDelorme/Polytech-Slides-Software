package com.delormeloic.generator.view.slidesforms;

import com.delormeloic.generator.model.slides.SlideWithTitle;
import com.delormeloic.generator.view.converters.FontStringConverter;
import com.delormeloic.generator.view.helpers.FontsHelper;
import com.delormeloic.generator.view.helpers.FormBuilderHelper;
import com.delormeloic.generator.view.helpers.TextHelper;

import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
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
		nameTextField.textProperty().bindBidirectional(slideWithTitle.getNameProperty());

		final CheckBox headerCheckBox = new CheckBox();
		headerCheckBox.selectedProperty().bindBidirectional(slideWithTitle.getHeaderProperty());

		final CheckBox footerCheckBox = new CheckBox();
		footerCheckBox.selectedProperty().bindBidirectional(slideWithTitle.getFooterProperty());

		final TextField titleTextField = new TextField();
		titleTextField.textProperty().bindBidirectional(slideWithTitle.getTitleProperty());

		final ComboBox<Font> titleFontComboBox = new ComboBox<Font>(FontsHelper.getAllAvailableFonts());
		titleFontComboBox.setConverter(new FontStringConverter());
		titleFontComboBox.valueProperty().bindBidirectional(slideWithTitle.getTitleFontProperty());

		final TitledPane nameTitledPane = new TitledPane(TextHelper.getText("slideFormNameTitledPane"), new HBox(nameTextField));
		nameTitledPane.setCollapsible(false);
		HBox.setHgrow(nameTextField, Priority.ALWAYS);
		final TitledPane headerTitledPane = new TitledPane(TextHelper.getText("slideFormHeaderTitledPane"), new HBox(headerCheckBox));
		headerTitledPane.setCollapsible(false);
		final TitledPane footerTitledPane = new TitledPane(TextHelper.getText("slideFormFooterTitledPane"), new HBox(footerCheckBox));
		footerTitledPane.setCollapsible(false);
		final TitledPane titleTextTitledPane = new TitledPane(TextHelper.getText("slideWithTitleFormTitleTextTitledPane"), new HBox(titleTextField));
		titleTextTitledPane.setCollapsible(false);
		HBox.setHgrow(titleTextField, Priority.ALWAYS);
		final TitledPane titleTextFontTitledPane = new TitledPane(TextHelper.getText("slideWithTitleFormTitleTextFontTitledPane"), new HBox(titleFontComboBox));
		titleTextFontTitledPane.setCollapsible(false);

		final TitledPane generalInformationTitledPane = FormBuilderHelper.buildTitledPane(TextHelper.getText("slideFormGeneralInformationTitledPane"), new TitledPane[] { nameTitledPane, headerTitledPane, footerTitledPane });
		final TitledPane titleTitledPane = FormBuilderHelper.buildTitledPane(TextHelper.getText("slideWithTitleFormTitleTitledPane"), new TitledPane[] { titleTextTitledPane, titleTextFontTitledPane });

		return FormBuilderHelper.buildTitledPane(TextHelper.getText("slideFormDataTitledPane"), new TitledPane[] { generalInformationTitledPane, titleTitledPane });
	}
}