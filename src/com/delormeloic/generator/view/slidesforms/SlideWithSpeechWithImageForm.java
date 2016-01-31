package com.delormeloic.generator.view.slidesforms;

import java.io.File;

import com.delormeloic.generator.model.slides.SlideWithSpeechWithImage;
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
		final CheckBox headerCheckBox = new CheckBox();
		final CheckBox footerCheckBox = new CheckBox();
		final TextField titleTextField = new TextField();
		final ComboBox<Font> titleFontComboBox = new ComboBox<Font>();
		final TextArea speechTextArea = new TextArea();
		final ComboBox<Font> speechFontComboBox = new ComboBox<Font>();
		this.imageButton = new Button(TextHelper.getText("slideWithSpeechWithImageFormImageButton"));

		titleFontComboBox.getItems().addAll(FontsHelper.getAllAvailableFonts());
		titleFontComboBox.setConverter(new FontStringConverter());
		speechTextArea.setWrapText(true);
		speechFontComboBox.getItems().addAll(FontsHelper.getAllAvailableFonts());
		speechFontComboBox.setConverter(new FontStringConverter());
		this.imageButton.setOnAction(this);

		nameTextField.textProperty().bindBidirectional(slideWithSpeechWithImage.getNameProperty());
		headerCheckBox.selectedProperty().bindBidirectional(slideWithSpeechWithImage.getHeaderProperty());
		footerCheckBox.selectedProperty().bindBidirectional(slideWithSpeechWithImage.getFooterProperty());
		titleTextField.textProperty().bindBidirectional(slideWithSpeechWithImage.getTitleProperty());
		titleFontComboBox.valueProperty().bindBidirectional(slideWithSpeechWithImage.getTitleFontProperty());
		speechTextArea.textProperty().bindBidirectional(slideWithSpeechWithImage.getSpeechProperty());
		speechFontComboBox.valueProperty().bindBidirectional(slideWithSpeechWithImage.getSpeechFontProperty());

		final Node[] nameField = new Node[] { new Label(TextHelper.getText("slideWithSpeechWithImageFormNameField")), nameTextField };
		final Node[] headerField = new Node[] { new Label(TextHelper.getText("slideWithSpeechWithImageFormHeaderField")), headerCheckBox };
		final Node[] footerField = new Node[] { new Label(TextHelper.getText("slideWithSpeechWithImageFormFooterField")), footerCheckBox };
		final Node[] titleField = new Node[] { new Label(TextHelper.getText("slideWithSpeechWithImageFormTitleField")), titleTextField };
		final Node[] titleFontField = new Node[] { new Label(TextHelper.getText("slideWithSpeechWithImageFormTitleFontField")), titleFontComboBox };
		final Node[] speechField = new Node[] { new Label(TextHelper.getText("slideWithSpeechWithImageFormSpeechField")), speechTextArea };
		final Node[] speechFontField = new Node[] { new Label(TextHelper.getText("slideWithSpeechWithImageFormSpeechFontField")), speechFontComboBox };
		final Node[] imageButtonField = new Node[] { new Label(TextHelper.getText("slideWithSpeechWithImageFormImageButtonField")), this.imageButton };

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
			((SlideWithSpeechWithImage) this.slide).getImageProperty().set(Base64Helper.encode(selectedFile));
		}
	}
}