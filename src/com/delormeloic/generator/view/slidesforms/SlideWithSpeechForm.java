package com.delormeloic.generator.view.slidesforms;

import java.io.File;

import com.delormeloic.generator.model.slides.SlideWithSpeech;
import com.delormeloic.generator.view.converters.FontStringConverter;
import com.delormeloic.generator.view.helpers.Base64Helper;
import com.delormeloic.generator.view.helpers.FontsHelper;
import com.delormeloic.generator.view.helpers.GridPaneHelper;
import com.delormeloic.generator.view.helpers.TextHelper;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;

/**
 * This class represents a slide with a speech form.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class SlideWithSpeechForm extends SlideForm implements EventHandler<ActionEvent>
{
	/**
	 * The image button.
	 */
	private Button imageButton;

	/**
	 * Create a slide with a speech form.
	 * 
	 * @param slideWithSpeech
	 *            The slide with a speech.
	 */
	public SlideWithSpeechForm(SlideWithSpeech slideWithSpeech)
	{
		super(slideWithSpeech);
	}

	/**
	 * @see com.delormeloic.generator.view.slidesforms.IFormable#toForm()
	 */
	@Override
	public Node toForm()
	{
		final SlideWithSpeech slideWithSpeech = (SlideWithSpeech) this.slide;

		final TextField nameTextField = new TextField();
		final CheckBox headerCheckBox = new CheckBox();
		final CheckBox footerCheckBox = new CheckBox();
		final TextField titleTextField = new TextField();
		final ComboBox<Font> titleFontComboBox = new ComboBox<Font>();
		final TextArea speechTextArea = new TextArea();
		final ComboBox<Font> speechFontComboBox = new ComboBox<Font>();
		this.imageButton = new Button(TextHelper.getText("slideWithSpeechFormImageButton"));

		titleFontComboBox.getItems().addAll(FontsHelper.getAllAvailableFonts());
		titleFontComboBox.setConverter(new FontStringConverter());
		speechTextArea.setWrapText(true);
		speechFontComboBox.getItems().addAll(FontsHelper.getAllAvailableFonts());
		speechFontComboBox.setConverter(new FontStringConverter());
		this.imageButton.setOnAction(this);

		nameTextField.textProperty().bindBidirectional(slideWithSpeech.getNameProperty());
		headerCheckBox.selectedProperty().bindBidirectional(slideWithSpeech.getHeaderProperty());
		footerCheckBox.selectedProperty().bindBidirectional(slideWithSpeech.getFooterProperty());
		titleTextField.textProperty().bindBidirectional(slideWithSpeech.getTitleProperty());
		titleFontComboBox.valueProperty().bindBidirectional(slideWithSpeech.getTitleFontProperty());
		speechTextArea.textProperty().bindBidirectional(slideWithSpeech.getSpeechProperty());
		speechFontComboBox.valueProperty().bindBidirectional(slideWithSpeech.getSpeechFontProperty());

		final Node[] nameField = new Node[] { new Label(TextHelper.getText("slideWithSpeechFormNameField")), nameTextField };
		final Node[] headerField = new Node[] { new Label(TextHelper.getText("slideWithSpeechHeaderField")), headerCheckBox };
		final Node[] footerField = new Node[] { new Label(TextHelper.getText("slideWithSpeechFooterField")), footerCheckBox };
		final Node[] titleField = new Node[] { new Label(TextHelper.getText("slideWithSpeechFormTitleField")), titleTextField };
		final Node[] titleFontField = new Node[] { new Label(TextHelper.getText("slideWithSpeechFormTitleFontField")), titleFontComboBox };
		final Node[] speechField = new Node[] { new Label(TextHelper.getText("slideWithSpeechFormSpeechField")), speechTextArea };
		final Node[] speechFontField = new Node[] { new Label(TextHelper.getText("slideWithSpeechFormSpeechFontField")), speechFontComboBox };
		final Node[] imageButtonField = new Node[] { new Label(TextHelper.getText("slideWithSpeechFormImageButtonField")), this.imageButton };

		return GridPaneHelper.buildGridPane(new Node[][] { nameField, GridPaneHelper.getSeparators(2), headerField, footerField, GridPaneHelper.getSeparators(2), titleField, titleFontField, GridPaneHelper.getSeparators(2), speechField, speechFontField, GridPaneHelper.getSeparators(2), imageButtonField });
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
			((SlideWithSpeech) this.slide).getImageProperty().set(Base64Helper.encode(selectedFile));
		}
	}
}