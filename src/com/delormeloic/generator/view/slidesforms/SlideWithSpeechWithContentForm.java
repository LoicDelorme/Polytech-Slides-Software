package com.delormeloic.generator.view.slidesforms;

import java.io.File;

import com.delormeloic.generator.model.slides.SlideWithSpeechWithContent;
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
 * This class represents a slide with a speech with a content form.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public abstract class SlideWithSpeechWithContentForm extends SlideForm implements EventHandler<ActionEvent>
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
	 * Create a slide with a speech with a content form.
	 * 
	 * @param slideWithSpeechWithContent
	 *            The slide with a speech with a content.
	 */
	public SlideWithSpeechWithContentForm(SlideWithSpeechWithContent slideWithSpeechWithContent)
	{
		super(slideWithSpeechWithContent);
	}

	/**
	 * Get the content loaded text.
	 * 
	 * @return The content loaded text.
	 */
	public abstract String getContentLoadedText();

	/**
	 * Get the content button text.
	 * 
	 * @return The content button text.
	 */
	public abstract String getContentButtonText();

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
		final SlideWithSpeechWithContent slideWithSpeechWithContent = (SlideWithSpeechWithContent) this.slide;

		final TextField nameTextField = new TextField();
		nameTextField.textProperty().bindBidirectional(slideWithSpeechWithContent.getNameProperty());

		final CheckBox headerCheckBox = new CheckBox();
		headerCheckBox.selectedProperty().bindBidirectional(slideWithSpeechWithContent.getHeaderProperty());

		final CheckBox footerCheckBox = new CheckBox();
		footerCheckBox.selectedProperty().bindBidirectional(slideWithSpeechWithContent.getFooterProperty());

		final TextField titleTextField = new TextField();
		titleTextField.textProperty().bindBidirectional(slideWithSpeechWithContent.getTitleProperty());

		final ComboBox<Font> titleFontComboBox = new ComboBox<Font>(FontsHelper.getAllAvailableFonts());
		titleFontComboBox.setConverter(new FontStringConverter());
		titleFontComboBox.valueProperty().bindBidirectional(slideWithSpeechWithContent.getTitleFontProperty());

		final TextArea speechTextArea = new TextArea();
		speechTextArea.setWrapText(true);
		speechTextArea.textProperty().bindBidirectional(slideWithSpeechWithContent.getSpeechProperty());

		final ComboBox<Font> speechFontComboBox = new ComboBox<Font>(FontsHelper.getAllAvailableFonts());
		speechFontComboBox.setConverter(new FontStringConverter());
		speechFontComboBox.valueProperty().bindBidirectional(slideWithSpeechWithContent.getSpeechFontProperty());

		this.contentTextField = new TextField(String.format(getContentLoadedText(), (slideWithSpeechWithContent.getContent().isEmpty() ? 0 : 1)));
		this.contentTextField.setEditable(false);

		this.contentButton = new Button(TextHelper.getText("slideWithSpeechWithContentFormContentButton"));
		this.contentButton.setOnAction(this);

		final TitledPane nameTitledPane = new TitledPane(TextHelper.getText("slideWithSpeechWithContentFormNameTitledPane"), new HBox(nameTextField));
		nameTitledPane.setCollapsible(false);
		HBox.setHgrow(nameTextField, Priority.ALWAYS);
		final TitledPane headerTitledPane = new TitledPane(TextHelper.getText("slideWithSpeechWithContentFormHeaderTitledPane"), new HBox(headerCheckBox));
		headerTitledPane.setCollapsible(false);
		final TitledPane footerTitledPane = new TitledPane(TextHelper.getText("slideWithSpeechWithContentFormFooterTitledPane"), new HBox(footerCheckBox));
		footerTitledPane.setCollapsible(false);
		final TitledPane titleTextTitledPane = new TitledPane(TextHelper.getText("slideWithSpeechWithContentFormTitleTextTitledPane"), new HBox(titleTextField));
		titleTextTitledPane.setCollapsible(false);
		HBox.setHgrow(titleTextField, Priority.ALWAYS);
		final TitledPane titleTextFontTitledPane = new TitledPane(TextHelper.getText("slideWithSpeechWithContentFormTitleTextFontTitledPane"), new HBox(titleFontComboBox));
		titleTextFontTitledPane.setCollapsible(false);
		final TitledPane speechTextTitledPane = new TitledPane(TextHelper.getText("slideWithSpeechWithContentFormSpeechTextTitledPane"), new HBox(speechTextArea));
		speechTextTitledPane.setCollapsible(false);
		HBox.setHgrow(speechTextArea, Priority.ALWAYS);
		final TitledPane speechTextFontTitledPane = new TitledPane(TextHelper.getText("slideWithSpeechWithContentFormSpeechTextFontTitledPane"), new HBox(speechFontComboBox));
		speechTextFontTitledPane.setCollapsible(false);
		final TitledPane contentButtonTitledPane = new TitledPane(getContentButtonText(), new HBox(this.contentTextField, this.contentButton));
		contentButtonTitledPane.setCollapsible(false);
		HBox.setHgrow(this.contentTextField, Priority.ALWAYS);

		final TitledPane generalInformationTitledPane = FormBuilderHelper.buildTitledPane(TextHelper.getText("slideWithSpeechWithContentFormGeneralInformationTitledPane"), new TitledPane[] { nameTitledPane, headerTitledPane, footerTitledPane });
		final TitledPane titleTitledPane = FormBuilderHelper.buildTitledPane(TextHelper.getText("slideWithSpeechWithContentFormTitleTitledPane"), new TitledPane[] { titleTextTitledPane, titleTextFontTitledPane });
		final TitledPane speechTitledPane = FormBuilderHelper.buildTitledPane(TextHelper.getText("slideWithSpeechWithContentFormSpeechTitledPane"), new TitledPane[] { speechTextTitledPane, speechTextFontTitledPane, contentButtonTitledPane });

		return FormBuilderHelper.buildTitledPane(TextHelper.getText("dataForm"), new TitledPane[] { generalInformationTitledPane, titleTitledPane, speechTitledPane });
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
			((SlideWithSpeechWithContent) this.slide).getContentProperty().set(Base64Helper.encode(selectedFile));
			this.contentTextField.setText(String.format(getContentLoadedText(), 1));
		}
	}
}