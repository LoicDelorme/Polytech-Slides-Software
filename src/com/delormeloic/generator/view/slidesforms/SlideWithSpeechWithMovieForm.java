package com.delormeloic.generator.view.slidesforms;

import java.io.File;

import com.delormeloic.generator.model.slides.SlideWithSpeechWithMovie;
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
		nameTextField.textProperty().bindBidirectional(slideWithSpeechWithMovie.getNameProperty());

		final CheckBox headerCheckBox = new CheckBox();
		headerCheckBox.selectedProperty().bindBidirectional(slideWithSpeechWithMovie.getHeaderProperty());

		final CheckBox footerCheckBox = new CheckBox();
		footerCheckBox.selectedProperty().bindBidirectional(slideWithSpeechWithMovie.getFooterProperty());

		final TextField titleTextField = new TextField();
		titleTextField.textProperty().bindBidirectional(slideWithSpeechWithMovie.getTitleProperty());

		final ComboBox<Font> titleFontComboBox = new ComboBox<Font>(FontsHelper.getAllAvailableFonts());
		titleFontComboBox.setConverter(new FontStringConverter());
		titleFontComboBox.valueProperty().bindBidirectional(slideWithSpeechWithMovie.getTitleFontProperty());

		final TextArea speechTextArea = new TextArea();
		speechTextArea.setWrapText(true);
		speechTextArea.textProperty().bindBidirectional(slideWithSpeechWithMovie.getSpeechProperty());

		final ComboBox<Font> speechFontComboBox = new ComboBox<Font>(FontsHelper.getAllAvailableFonts());
		speechFontComboBox.setConverter(new FontStringConverter());
		speechFontComboBox.valueProperty().bindBidirectional(slideWithSpeechWithMovie.getSpeechFontProperty());

		this.movieButton = new Button(TextHelper.getText("slideWithSpeechWithMovieFormMovieButton"));
		this.movieButton.setOnAction(this);

		final TitledPane nameTitledPane = new TitledPane(TextHelper.getText("slideWithSpeechWithMovieFormNameTitledPane"), nameTextField);
		nameTitledPane.setCollapsible(false);
		final TitledPane headerTitledPane = new TitledPane(TextHelper.getText("slideWithSpeechWithMovieFormHeaderTitledPane"), headerCheckBox);
		headerTitledPane.setCollapsible(false);
		final TitledPane footerTitledPane = new TitledPane(TextHelper.getText("slideWithSpeechWithMovieFormFooterTitledPane"), footerCheckBox);
		footerTitledPane.setCollapsible(false);
		final TitledPane titleTextTitledPane = new TitledPane(TextHelper.getText("slideWithSpeechWithMovieFormTitleTextTitledPane"), titleTextField);
		titleTextTitledPane.setCollapsible(false);
		final TitledPane titleTextFontTitledPane = new TitledPane(TextHelper.getText("slideWithSpeechWithMovieFormTitleTextFontTitledPane"), titleFontComboBox);
		titleTextFontTitledPane.setCollapsible(false);
		final TitledPane speechTextTitledPane = new TitledPane(TextHelper.getText("slideWithSpeechWithMovieFormSpeechTextTitledPane"), speechTextArea);
		speechTextTitledPane.setCollapsible(false);
		final TitledPane speechTextFontTitledPane = new TitledPane(TextHelper.getText("slideWithSpeechWithMovieFormSpeechTextFontTitledPane"), speechFontComboBox);
		speechTextFontTitledPane.setCollapsible(false);
		final TitledPane imageButtonTitledPane = new TitledPane(TextHelper.getText("slideWithSpeechWithMovieFormMovieButtonTitledPane"), this.movieButton);
		nameTitledPane.setCollapsible(false);

		final TitledPane generalInformationTitledPane = FormBuilderHelper.buildTitledPane(TextHelper.getText("slideWithSpeechWithMovieFormGeneralInformationTitledPane"), new TitledPane[] { nameTitledPane, headerTitledPane, footerTitledPane });
		final TitledPane titleTitledPane = FormBuilderHelper.buildTitledPane(TextHelper.getText("slideWithSpeechWithMovieFormTitleTitledPane"), new TitledPane[] { titleTextTitledPane, titleTextFontTitledPane });
		final TitledPane speechTitledPane = FormBuilderHelper.buildTitledPane(TextHelper.getText("slideWithSpeechWithMovieFormSpeechTitledPane"), new TitledPane[] { speechTextTitledPane, speechTextFontTitledPane, imageButtonTitledPane });

		return FormBuilderHelper.buildTitledPane(TextHelper.getText("dataForm"), new TitledPane[] { generalInformationTitledPane, titleTitledPane, speechTitledPane });
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