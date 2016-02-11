package com.delormeloic.generator.view.slidesforms;

import java.io.File;

import com.delormeloic.generator.model.slides.Footer;
import com.delormeloic.generator.view.converters.FontStringConverter;
import com.delormeloic.generator.view.helpers.Base64Helper;
import com.delormeloic.generator.view.helpers.FontsHelper;
import com.delormeloic.generator.view.helpers.FormBuilderHelper;
import com.delormeloic.generator.view.helpers.TextHelper;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;

/**
 * This class represents a footer form.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class FooterForm implements IFormable, EventHandler<ActionEvent>
{
	/**
	 * The left image button.
	 */
	private Button leftImageButton;

	/**
	 * The right image button.
	 */
	private Button rightImageButton;

	/**
	 * The footer.
	 */
	private final Footer footer;

	/**
	 * Create a footer form.
	 * 
	 * @param footer
	 *            The footer.
	 */
	public FooterForm(Footer footer)
	{
		this.footer = footer;
	}

	/**
	 * @see com.delormeloic.generator.view.slidesforms.IFormable#toForm()
	 */
	@Override
	public Node toForm()
	{
		this.leftImageButton = new Button(TextHelper.getText("footerFormLeftImageButton"));
		this.leftImageButton.setOnAction(this);

		final TextField middleTextTextField = new TextField();
		middleTextTextField.textProperty().bindBidirectional(this.footer.getMiddleTextProperty());

		final ComboBox<Font> middleTextFontComboBox = new ComboBox<Font>(FontsHelper.getAllAvailableFonts());
		middleTextFontComboBox.setConverter(new FontStringConverter());
		middleTextFontComboBox.valueProperty().bindBidirectional(this.footer.getMiddleTextFontProperty());

		this.rightImageButton = new Button(TextHelper.getText("footerFormRightImageButton"));
		this.rightImageButton.setOnAction(this);

		final TitledPane leftImageTitledPane = new TitledPane(TextHelper.getText("footerFormLeftImageTitledPane"), this.leftImageButton);
		leftImageTitledPane.setCollapsible(false);
		final TitledPane middleTextTitledPane = new TitledPane(TextHelper.getText("footerFormMiddleTextTitledPane"), middleTextTextField);
		middleTextTitledPane.setCollapsible(false);
		final TitledPane middleTextFontTitledPane = new TitledPane(TextHelper.getText("footerFormMiddleTextFontTitledPane"), middleTextFontComboBox);
		middleTextFontTitledPane.setCollapsible(false);
		final TitledPane rightImageTitledPane = new TitledPane(TextHelper.getText("footerFormRightImageTitledPane"), this.rightImageButton);
		rightImageTitledPane.setCollapsible(false);

		final TitledPane leftTitledPane = FormBuilderHelper.buildTitledPane(TextHelper.getText("footerFormLeftTitledPane"), new TitledPane[] { leftImageTitledPane });
		final TitledPane middleTitledPane = FormBuilderHelper.buildTitledPane(TextHelper.getText("footerFormMiddleTitledPane"), new TitledPane[] { middleTextTitledPane, middleTextFontTitledPane });
		final TitledPane rightTitledPane = FormBuilderHelper.buildTitledPane(TextHelper.getText("footerFormRightTitledPane"), new TitledPane[] { rightImageTitledPane });

		return FormBuilderHelper.buildTitledPane(TextHelper.getText("dataForm"), new TitledPane[] { leftTitledPane, middleTitledPane, rightTitledPane });
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
			final Button selectedButton = (Button) event.getSource();
			final String encodedData = Base64Helper.encode(selectedFile);

			if (selectedButton == this.leftImageButton)
			{
				this.footer.getLeftImageProperty().set(encodedData);
			}

			if (selectedButton == this.rightImageButton)
			{
				this.footer.getRightImageProperty().set(encodedData);
			}
		}
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Footer";
	}
}