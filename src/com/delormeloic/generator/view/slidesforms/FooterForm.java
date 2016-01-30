package com.delormeloic.generator.view.slidesforms;

import java.io.File;

import com.delormeloic.generator.model.slides.Footer;
import com.delormeloic.generator.view.converters.FontStringConverter;
import com.delormeloic.generator.view.helpers.Base64Helper;
import com.delormeloic.generator.view.helpers.FontsHelper;
import com.delormeloic.generator.view.helpers.GridPaneHelper;
import com.delormeloic.generator.view.helpers.TextHelper;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
		final TextField middleTextTextField = new TextField();
		final ComboBox<Font> middleTextFontComboBox = new ComboBox<Font>();
		this.rightImageButton = new Button(TextHelper.getText("footerFormRightImageButton"));

		this.leftImageButton.setOnAction(this);
		middleTextFontComboBox.getItems().addAll(FontsHelper.getAllAvailableFonts());
		middleTextFontComboBox.setConverter(new FontStringConverter());
		this.rightImageButton.setOnAction(this);

		middleTextTextField.textProperty().bindBidirectional(this.footer.getMiddleTextProperty());
		middleTextFontComboBox.valueProperty().bindBidirectional(this.footer.getMiddleTextFontProperty());

		final Node[] leftImageField = new Node[] { new Label(TextHelper.getText("footerFormLeftImageField")), this.leftImageButton };
		final Node[] middleTextField = new Node[] { new Label(TextHelper.getText("footerFormMiddleTextField")), middleTextTextField };
		final Node[] middleTextFontField = new Node[] { new Label(TextHelper.getText("footerFormMiddleTextFontField")), middleTextFontComboBox };
		final Node[] rightImageField = new Node[] { new Label(TextHelper.getText("footerFormRightImageField")), this.rightImageButton };

		return GridPaneHelper.buildGridPane(new Node[][] { leftImageField, GridPaneHelper.getSeparators(2), middleTextField, middleTextFontField, GridPaneHelper.getSeparators(2), rightImageField });
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