package com.delormeloic.generator.view.slidesforms;

import java.io.File;

import com.delormeloic.generator.model.slides.SlideWithSpeechWithImage;
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
import javafx.scene.text.Font;
import javafx.stage.FileChooser;

/**
 * This class represents a slide with a speech with an image form.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class SlideWithSpeechWithImageForm extends SlideForm implements EventHandler<ActionEvent>
{
	/**
	 * The image button.
	 */
	private Button imageButton;

	/**
	 * Create a slide with a speech with an image form.
	 * 
	 * @param slideWithSpeechWithImage
	 *            The slide with a speech with an image.
	 */
	public SlideWithSpeechWithImageForm(SlideWithSpeechWithImage slideWithSpeechWithImage)
	{
		super(slideWithSpeechWithImage);
	}

	/**
	 * @see com.delormeloic.generator.view.slidesforms.IFormable#toForm()
	 */
	@Override
	public Node toForm()
	{
		final SlideWithSpeechWithImage slideWithSpeechWithImage = (SlideWithSpeechWithImage) this.slide;

		final TextField nameTextField = new TextField();
		nameTextField.textProperty().bindBidirectional(slideWithSpeechWithImage.getNameProperty());

		final CheckBox headerCheckBox = new CheckBox();
		headerCheckBox.selectedProperty().bindBidirectional(slideWithSpeechWithImage.getHeaderProperty());

		final CheckBox footerCheckBox = new CheckBox();
		footerCheckBox.selectedProperty().bindBidirectional(slideWithSpeechWithImage.getFooterProperty());

		final TextField titleTextField = new TextField();
		titleTextField.textProperty().bindBidirectional(slideWithSpeechWithImage.getTitleProperty());

		final ComboBox<Font> titleFontComboBox = new ComboBox<Font>(FontsHelper.getAllAvailableFonts());
		titleFontComboBox.setConverter(new FontStringConverter());
		titleFontComboBox.valueProperty().bindBidirectional(slideWithSpeechWithImage.getTitleFontProperty());

		final TextArea speechTextArea = new TextArea();
		speechTextArea.setWrapText(true);
		speechTextArea.textProperty().bindBidirectional(slideWithSpeechWithImage.getSpeechProperty());

		final ComboBox<Font> speechFontComboBox = new ComboBox<Font>(FontsHelper.getAllAvailableFonts());
		speechFontComboBox.setConverter(new FontStringConverter());
		speechFontComboBox.valueProperty().bindBidirectional(slideWithSpeechWithImage.getSpeechFontProperty());

		this.imageButton = new Button(TextHelper.getText("slideWithSpeechWithImageFormImageButton"));
		this.imageButton.setOnAction(this);

		final TitledPane nameTitledPane = new TitledPane(TextHelper.getText("slideWithSpeechWithImageFormNameTitledPane"), nameTextField);
		nameTitledPane.setCollapsible(false);
		final TitledPane headerTitledPane = new TitledPane(TextHelper.getText("slideWithSpeechWithImageFormHeaderTitledPane"), headerCheckBox);
		headerTitledPane.setCollapsible(false);
		final TitledPane footerTitledPane = new TitledPane(TextHelper.getText("slideWithSpeechWithImageFormFooterTitledPane"), footerCheckBox);
		footerTitledPane.setCollapsible(false);
		final TitledPane titleTextTitledPane = new TitledPane(TextHelper.getText("slideWithSpeechWithImageFormTitleTextTitledPane"), titleTextField);
		titleTextTitledPane.setCollapsible(false);
		final TitledPane titleTextFontTitledPane = new TitledPane(TextHelper.getText("slideWithSpeechWithImageFormTitleTextFontTitledPane"), titleFontComboBox);
		titleTextFontTitledPane.setCollapsible(false);
		final TitledPane speechTextTitledPane = new TitledPane(TextHelper.getText("slideWithSpeechWithImageFormSpeechTextTitledPane"), speechTextArea);
		speechTextTitledPane.setCollapsible(false);
		final TitledPane speechTextFontTitledPane = new TitledPane(TextHelper.getText("slideWithSpeechWithImageFormSpeechTextFontTitledPane"), speechFontComboBox);
		speechTextFontTitledPane.setCollapsible(false);
		final TitledPane imageButtonTitledPane = new TitledPane(TextHelper.getText("slideWithSpeechWithImageFormImageButtonTitledPane"), this.imageButton);
		nameTitledPane.setCollapsible(false);

		final TitledPane generalInformationTitledPane = FormBuilderHelper.buildTitledPane(TextHelper.getText("slideWithSpeechWithImageFormGeneralInformationTitledPane"), new TitledPane[] { nameTitledPane, headerTitledPane, footerTitledPane });
		final TitledPane titleTitledPane = FormBuilderHelper.buildTitledPane(TextHelper.getText("slideWithSpeechWithImageFormTitleTitledPane"), new TitledPane[] { titleTextTitledPane, titleTextFontTitledPane });
		final TitledPane speechTitledPane = FormBuilderHelper.buildTitledPane(TextHelper.getText("slideWithSpeechWithImageFormSpeechTitledPane"), new TitledPane[] { speechTextTitledPane, speechTextFontTitledPane, imageButtonTitledPane });

		return FormBuilderHelper.buildTitledPane(TextHelper.getText("dataForm"), new TitledPane[] { generalInformationTitledPane, titleTitledPane, speechTitledPane });
	}

	/**
	 * @see javafx.event.EventHandler#handle(javafx.event.Event)
	 */
	@Override
	public void handle(ActionEvent event)
	{
		final FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images", "*.jpg", "*.png"));

		final File selectedFile = fileChooser.showOpenDialog(null);
		if (selectedFile != null)
		{
			((SlideWithSpeechWithImage) this.slide).getImageProperty().set(Base64Helper.encode(selectedFile));
		}
	}
}