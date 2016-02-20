package com.delormeloic.generator.view.slidesforms;

import java.io.File;

import com.delormeloic.generator.model.slides.SlideWithContent;
import com.delormeloic.generator.view.helpers.Base64Helper;
import com.delormeloic.generator.view.helpers.FormBuilderHelper;
import com.delormeloic.generator.view.helpers.TextHelper;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.FileChooser;

/**
 * This class represents a slide with a content form.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public abstract class SlideWithContentForm extends SlideForm implements EventHandler<ActionEvent>
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
	 * Create a slide with a content form.
	 * 
	 * @param slideWithContent
	 *            The slide with a content.
	 */
	public SlideWithContentForm(SlideWithContent slideWithContent)
	{
		super(slideWithContent);
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
		final SlideWithContent slideWithContent = (SlideWithContent) this.slide;

		final TextField nameTextField = new TextField();
		nameTextField.textProperty().bindBidirectional(slideWithContent.getNameProperty());

		final CheckBox headerCheckBox = new CheckBox();
		headerCheckBox.selectedProperty().bindBidirectional(slideWithContent.getHeaderProperty());

		final CheckBox footerCheckBox = new CheckBox();
		footerCheckBox.selectedProperty().bindBidirectional(slideWithContent.getFooterProperty());

		this.contentTextField = new TextField(String.format(getContentLoadedTextTextField(), (slideWithContent.getContent().isEmpty() ? 0 : 1)));
		this.contentTextField.setEditable(false);

		this.contentButton = new Button(TextHelper.getText("slideWithContentFormContentButton"));
		this.contentButton.setOnAction(this);

		final TitledPane nameTitledPane = new TitledPane(TextHelper.getText("slideFormNameTitledPane"), new HBox(nameTextField));
		nameTitledPane.setCollapsible(false);
		HBox.setHgrow(nameTextField, Priority.ALWAYS);
		final TitledPane headerTitledPane = new TitledPane(TextHelper.getText("slideFormHeaderTitledPane"), new HBox(headerCheckBox));
		headerTitledPane.setCollapsible(false);
		final TitledPane footerTitledPane = new TitledPane(TextHelper.getText("slideFormFooterTitledPane"), new HBox(footerCheckBox));
		footerTitledPane.setCollapsible(false);
		final TitledPane contentButtonTitledPane = new TitledPane(getContentTitleTitledPane(), new HBox(this.contentTextField, this.contentButton));
		contentButtonTitledPane.setCollapsible(false);
		HBox.setHgrow(this.contentTextField, Priority.ALWAYS);

		final TitledPane generalInformationTitledPane = FormBuilderHelper.buildTitledPane(TextHelper.getText("slideFormGeneralInformationTitledPane"), new TitledPane[] { nameTitledPane, headerTitledPane, footerTitledPane });
		final TitledPane contentTitledPane = FormBuilderHelper.buildTitledPane(TextHelper.getText("slideWithContentFormContentTitledPane"), new TitledPane[] { contentButtonTitledPane });

		return FormBuilderHelper.buildTitledPane(TextHelper.getText("slideFormDataTitledPane"), new TitledPane[] { generalInformationTitledPane, contentTitledPane });
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
			((SlideWithContent) this.slide).getContentProperty().set(Base64Helper.encode(selectedFile));
			this.contentTextField.setText(String.format(getContentLoadedTextTextField(), 1));
		}
	}
}