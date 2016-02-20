package com.delormeloic.generator.view.slidesforms;

import java.io.File;

import com.delormeloic.generator.model.slides.SlideWithContentWithSpeech;
import com.delormeloic.generator.view.converters.FontStringConverter;
import com.delormeloic.generator.view.helpers.Base64Helper;
import com.delormeloic.generator.view.helpers.FontsHelper;
import com.delormeloic.generator.view.helpers.FormBuilderHelper;
import com.delormeloic.generator.view.helpers.TextHelper;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;

/**
 * This class represents a slide with a content with a speech form.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public abstract class SlideWithContentWithSpeechForm extends SlideForm implements EventHandler<ActionEvent>
{
	/**
	 * The content text field.
	 */
	private TextField contentTextField;

	/**
	 * The content button.
	 */
	private Button contentButton;

	/**
	 * Create a slide with a content with a speech form.
	 * 
	 * @param slideWithContentWithSpeech
	 *            The slide with a content with a speech.
	 */
	public SlideWithContentWithSpeechForm(SlideWithContentWithSpeech slideWithContentWithSpeech)
	{
		super(slideWithContentWithSpeech);
	}

	/**
	 * Get the content loaded text text field.
	 * 
	 * @return The content loaded text text field.
	 */
	public abstract String getContentLoadedTextTextField();

	/**
	 * Get the content title titled pane.
	 * 
	 * @return The content title titled pane.
	 */
	public abstract String getContentTitleTitledPane();

	/**
	 * Get the extension filter.
	 * 
	 * @return The extension filter.
	 */
	public abstract FileChooser.ExtensionFilter getExtensionFilter();

	/**
	 * @see com.delormeloic.generator.view.slidesforms.IFormable#toForm()
	 */
	@Override
	public Node toForm()
	{
		final SlideWithContentWithSpeech slideWithContentWithSpeech = (SlideWithContentWithSpeech) this.slide;

		final TextField nameTextField = new TextField();
		nameTextField.textProperty().bindBidirectional(slideWithContentWithSpeech.getNameProperty());

		final CheckBox headerCheckBox = new CheckBox();
		headerCheckBox.selectedProperty().bindBidirectional(slideWithContentWithSpeech.getHeaderProperty());

		final CheckBox footerCheckBox = new CheckBox();
		footerCheckBox.selectedProperty().bindBidirectional(slideWithContentWithSpeech.getFooterProperty());

		final TextArea speechTextArea = new TextArea();
		speechTextArea.setWrapText(true);
		speechTextArea.textProperty().bindBidirectional(slideWithContentWithSpeech.getSpeechProperty());

		final ComboBox<Font> speechFontComboBox = new ComboBox<Font>(FontsHelper.getAllAvailableFonts());
		speechFontComboBox.setConverter(new FontStringConverter());
		speechFontComboBox.valueProperty().bindBidirectional(slideWithContentWithSpeech.getSpeechFontProperty());

		this.contentTextField = new TextField(String.format(getContentLoadedTextTextField(), (slideWithContentWithSpeech.getContent().isEmpty() ? 0 : 1)));
		this.contentTextField.setEditable(false);

		this.contentButton = new Button(TextHelper.getText("slideWithContentWithSpeechFormContentButton"));
		this.contentButton.setOnAction(this);

		final TitledPane nameTitledPane = new TitledPane(TextHelper.getText("slideFormNameTitledPane"), new HBox(nameTextField));
		nameTitledPane.setCollapsible(false);
		HBox.setHgrow(nameTextField, Priority.ALWAYS);
		final TitledPane headerTitledPane = new TitledPane(TextHelper.getText("slideFormHeaderTitledPane"), new HBox(headerCheckBox));
		headerTitledPane.setCollapsible(false);
		final TitledPane footerTitledPane = new TitledPane(TextHelper.getText("slideFormFooterTitledPane"), new HBox(footerCheckBox));
		footerTitledPane.setCollapsible(false);
		final TitledPane speechTextTitledPane = new TitledPane(TextHelper.getText("slideWithContentWithSpeechFormSpeechTextTitledPane"), new HBox(speechTextArea));
		speechTextTitledPane.setCollapsible(false);
		HBox.setHgrow(speechTextArea, Priority.ALWAYS);
		final TitledPane speechTextFontTitledPane = new TitledPane(TextHelper.getText("slideWithContentWithSpeechFormSpeechTextFontTitledPane"), new HBox(speechFontComboBox));
		speechTextFontTitledPane.setCollapsible(false);
		final TitledPane contentButtonTitledPane = new TitledPane(getContentTitleTitledPane(), new HBox(this.contentTextField, this.contentButton));
		contentButtonTitledPane.setCollapsible(false);
		HBox.setHgrow(this.contentTextField, Priority.ALWAYS);

		final TitledPane generalInformationTitledPane = FormBuilderHelper.buildTitledPane(TextHelper.getText("slideFormGeneralInformationTitledPane"), new TitledPane[] { nameTitledPane, headerTitledPane, footerTitledPane });
		final TitledPane speechTitledPane = FormBuilderHelper.buildTitledPane(TextHelper.getText("slideWithContentWithSpeechFormSpeechTitledPane"), new TitledPane[] { speechTextTitledPane, speechTextFontTitledPane });
		final TitledPane contentTitledPane = FormBuilderHelper.buildTitledPane(TextHelper.getText("slideWithContentWithSpeechFormContentTitledPane"), new TitledPane[] { contentButtonTitledPane });

		return FormBuilderHelper.buildTitledPane(TextHelper.getText("slideFormDataTitledPane"), new TitledPane[] { generalInformationTitledPane, speechTitledPane, contentTitledPane });
	}

	/**
	 * @see javafx.event.EventHandler#handle(javafx.event.Event)
	 */
	@Override
	public void handle(ActionEvent event)
	{
		final FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(getExtensionFilter());

		final File selectedFile = fileChooser.showOpenDialog(null);
		if (selectedFile != null)
		{
			((SlideWithContentWithSpeech) this.slide).getContentProperty().set(Base64Helper.encode(selectedFile));
			this.contentTextField.setText(String.format(getContentLoadedTextTextField(), 1));
		}
	}
}