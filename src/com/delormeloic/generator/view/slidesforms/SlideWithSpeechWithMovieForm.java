package com.delormeloic.generator.view.slidesforms;

import java.io.File;

import com.delormeloic.generator.model.slides.SlideWithSpeechWithMovie;
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
 * This class represents a slide with a speech with a movie form.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class SlideWithSpeechWithMovieForm extends SlideForm implements EventHandler<ActionEvent>
{
	/**
	 * The movie button.
	 */
	private Button movieButton;

	/**
	 * Create a slide with a speech with a movie form.
	 * 
	 * @param slideWithSpeechWithMovie
	 *            The slide with a speech with a movie.
	 */
	public SlideWithSpeechWithMovieForm(SlideWithSpeechWithMovie slideWithSpeechWithMovie)
	{
		super(slideWithSpeechWithMovie);
	}

	/**
	 * @see com.delormeloic.generator.view.slidesforms.IFormable#toForm()
	 */
	@Override
	public Node toForm()
	{
		final SlideWithSpeechWithMovie slideWithSpeechWithMovie = (SlideWithSpeechWithMovie) this.slide;

		final TextField nameTextField = new TextField();
		final CheckBox headerCheckBox = new CheckBox();
		final CheckBox footerCheckBox = new CheckBox();
		final TextField titleTextField = new TextField();
		final ComboBox<Font> titleFontComboBox = new ComboBox<Font>();
		final TextArea speechTextArea = new TextArea();
		final ComboBox<Font> speechFontComboBox = new ComboBox<Font>();
		this.movieButton = new Button(TextHelper.getText("slideWithSpeechWithMovieFormMovieButton"));

		titleFontComboBox.getItems().addAll(FontsHelper.getAllAvailableFonts());
		titleFontComboBox.setConverter(new FontStringConverter());
		speechTextArea.setWrapText(true);
		speechFontComboBox.getItems().addAll(FontsHelper.getAllAvailableFonts());
		speechFontComboBox.setConverter(new FontStringConverter());
		this.movieButton.setOnAction(this);

		nameTextField.textProperty().bindBidirectional(slideWithSpeechWithMovie.getNameProperty());
		headerCheckBox.selectedProperty().bindBidirectional(slideWithSpeechWithMovie.getHeaderProperty());
		footerCheckBox.selectedProperty().bindBidirectional(slideWithSpeechWithMovie.getFooterProperty());
		titleTextField.textProperty().bindBidirectional(slideWithSpeechWithMovie.getTitleProperty());
		titleFontComboBox.valueProperty().bindBidirectional(slideWithSpeechWithMovie.getTitleFontProperty());
		speechTextArea.textProperty().bindBidirectional(slideWithSpeechWithMovie.getSpeechProperty());
		speechFontComboBox.valueProperty().bindBidirectional(slideWithSpeechWithMovie.getSpeechFontProperty());

		final Node[] nameField = new Node[] { new Label(TextHelper.getText("slideWithSpeechWithMovieFormNameField")), nameTextField };
		final Node[] headerField = new Node[] { new Label(TextHelper.getText("slideWithSpeechWithMovieFormHeaderField")), headerCheckBox };
		final Node[] footerField = new Node[] { new Label(TextHelper.getText("slideWithSpeechWithMovieFormFooterField")), footerCheckBox };
		final Node[] titleField = new Node[] { new Label(TextHelper.getText("slideWithSpeechWithMovieFormTitleField")), titleTextField };
		final Node[] titleFontField = new Node[] { new Label(TextHelper.getText("slideWithSpeechWithMovieFormTitleFontField")), titleFontComboBox };
		final Node[] speechField = new Node[] { new Label(TextHelper.getText("slideWithSpeechWithMovieFormSpeechField")), speechTextArea };
		final Node[] speechFontField = new Node[] { new Label(TextHelper.getText("slideWithSpeechWithMovieFormSpeechFontField")), speechFontComboBox };
		final Node[] imageButtonField = new Node[] { new Label(TextHelper.getText("slideWithSpeechWithMovieFormMovieButtonField")), this.movieButton };

		return GridPaneHelper.buildGridPane(new Node[][] { nameField, GridPaneHelper.getSeparators(2), headerField, footerField, GridPaneHelper.getSeparators(2), titleField, titleFontField, GridPaneHelper.getSeparators(2), speechField, speechFontField, GridPaneHelper.getSeparators(2), imageButtonField });
	}

	/**
	 * @see javafx.event.EventHandler#handle(javafx.event.Event)
	 */
	@Override
	public void handle(ActionEvent event)
	{
		final FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Movies", "*.mp4"));

		final File selectedFile = fileChooser.showOpenDialog(null);
		if (selectedFile != null)
		{
			((SlideWithSpeechWithMovie) this.slide).getMovieProperty().set(Base64Helper.encode(selectedFile));
		}
	}
}