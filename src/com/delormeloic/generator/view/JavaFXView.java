package com.delormeloic.generator.view;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import com.delormeloic.generator.controller.IController;
import com.delormeloic.generator.model.IModel;
import com.delormeloic.generator.view.converters.SlideFormCallback;
import com.delormeloic.generator.view.helpers.DialogHelper;
import com.delormeloic.generator.view.helpers.TextHelper;
import com.delormeloic.generator.view.slidesforms.BackgroundForm;
import com.delormeloic.generator.view.slidesforms.FooterForm;
import com.delormeloic.generator.view.slidesforms.HeaderForm;
import com.delormeloic.generator.view.slidesforms.IFormable;
import com.delormeloic.generator.view.slidesforms.SlideForm;
import com.delormeloic.utils.logger.Logger;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 * This class represents a JavaFX view.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class JavaFXView extends BorderPane implements IView, EventHandler<ActionEvent>, ChangeListener<IFormable>
{
	/**
	 * The file chooser extension description.
	 */
	public static final String FILE_CHOOSER_EXTENSION_DESCRIPTION = TextHelper.getText("javaFXViewFileChooserDescription") + " (" + IModel.DEFAULT_FILE_EXTENSION_PATTERN + ")";

	/**
	 * The default extension filter.
	 */
	public static final ExtensionFilter EXTENSION_FILTER = new FileChooser.ExtensionFilter(FILE_CHOOSER_EXTENSION_DESCRIPTION, IModel.DEFAULT_FILE_EXTENSION_PATTERN);

	/**
	 * The controller.
	 */
	private final IController controller;

	/**
	 * The stage.
	 */
	private final Stage stage;

	/**
	 * The menu bar.
	 */
	private final CustomMenuBar menuBar;

	/**
	 * The formables items.
	 */
	private final ListView<IFormable> formables;

	/**
	 * The slides forms.
	 */
	private final ListView<SlideForm> slidesForms;

	/**
	 * The add slide button.
	 */
	private final Button addSlideButton;

	/**
	 * The remove slide button.
	 */
	private final Button removeSlideButton;

	/**
	 * The move up slide button.
	 */
	private final Button moveUpSlideButton;

	/**
	 * The move down slide button.
	 */
	private final Button moveDownSlideButton;

	/**
	 * The slide form pane.
	 */
	private final VBox slideFormPane;

	/**
	 * Create a JavaFX view.
	 * 
	 * @param controller
	 *            The controller.
	 * @param stage
	 *            The stage.
	 * @param title
	 *            The title.
	 * @param width
	 *            The width.
	 * @param height
	 *            The height.
	 */
	public JavaFXView(IController controller, Stage stage, String title, double width, double height)
	{
		this.controller = controller;
		this.stage = stage;

		this.menuBar = new CustomMenuBar(this.controller, this);
		this.formables = new ListView<IFormable>();
		this.slidesForms = new ListView<SlideForm>();
		this.addSlideButton = new Button(null, new ImageView(new Image(this.getClass().getResourceAsStream("/com/delormeloic/generator/view/resources/images/add_slide.png"))));
		this.removeSlideButton = new Button(null, new ImageView(new Image(this.getClass().getResourceAsStream("/com/delormeloic/generator/view/resources/images/remove_slide.png"))));
		this.moveUpSlideButton = new Button(null, new ImageView(new Image(this.getClass().getResourceAsStream("/com/delormeloic/generator/view/resources/images/move_up.png"))));
		this.moveDownSlideButton = new Button(null, new ImageView(new Image(this.getClass().getResourceAsStream("/com/delormeloic/generator/view/resources/images/move_down.png"))));
		this.slideFormPane = new VBox();

		this.formables.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		this.slidesForms.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		this.slidesForms.setCellFactory(new SlideFormCallback());
		this.addSlideButton.setOnAction(this);
		this.removeSlideButton.setOnAction(this);
		this.moveUpSlideButton.setOnAction(this);
		this.moveDownSlideButton.setOnAction(this);
		this.slideFormPane.setAlignment(Pos.TOP_LEFT);

		this.slideFormPane.setPadding(new Insets(8, 10, 8, 8));

		final Region region = new Region();
		final HBox buttonsHBox = new HBox();
		buttonsHBox.setAlignment(Pos.CENTER_LEFT);
		buttonsHBox.getChildren().addAll(this.addSlideButton, this.removeSlideButton, region, this.moveUpSlideButton, this.moveDownSlideButton);
		HBox.setHgrow(region, Priority.ALWAYS);

		final VBox dataVBox = new VBox();
		dataVBox.setAlignment(Pos.CENTER);
		dataVBox.setSpacing(5);
		dataVBox.setPadding(new Insets(8, 10, 8, 8));
		dataVBox.getChildren().addAll(this.formables, this.slidesForms, buttonsHBox);
		VBox.setVgrow(this.slidesForms, Priority.ALWAYS);

		this.setTop(this.menuBar);
		this.setLeft(dataVBox);
		this.setCenter(this.slideFormPane);

		disableMenuItems();
		computeDisabledButtons(-1);
		this.addSlideButton.setDisable(true);

		this.stage.getIcons().add(new Image(this.getClass().getResourceAsStream("/com/delormeloic/generator/view/resources/images/polytech_icon.png")));
		this.stage.setTitle(title);
		this.stage.setScene(new Scene(this, width, height));
	}

	/**
	 * @see com.delormeloic.generator.view.IView#showWindow()
	 */
	@Override
	public void showWindow()
	{
		this.stage.show();
	}

	/**
	 * @see com.delormeloic.generator.view.IView#closeWindow()
	 */
	@Override
	public void closeWindow()
	{
		this.stage.close();
	}

	/**
	 * @see com.delormeloic.generator.view.IView#displayNewProjectWindow()
	 */
	@Override
	public void displayNewProjectWindow()
	{
		try
		{
			final File selectedFile = displayFileChooserWindow(TextHelper.getText("javaFXViewNewProjectWindowInitialName"), TextHelper.getText("javaFXViewNewProjectWindowTitle"), true);
			if (selectedFile != null)
			{
				this.controller.notifyCreateNewProject(selectedFile);
			}
		}
		catch (IOException e)
		{
			Logger.severe(e);
			displayErrorPopUpWindow(e.getMessage());
		}
	}

	/**
	 * @see com.delormeloic.generator.view.IView#displayOpenProjectWindow()
	 */
	@Override
	public void displayOpenProjectWindow()
	{
		try
		{
			final File selectedFile = displayFileChooserWindow(TextHelper.getText("javaFXViewOpenProjectWindowTitle"), null, false);
			if (selectedFile != null)
			{
				this.controller.notifyOpenProject(selectedFile);
			}
		}
		catch (IOException e)
		{
			Logger.severe(e);
			displayErrorPopUpWindow(e.getMessage());
		}
	}

	/**
	 * @see com.delormeloic.generator.view.IView#displaySaveAsProjectWindow()
	 */
	@Override
	public void displaySaveAsProjectWindow()
	{
		try
		{
			final File selectedFile = displayFileChooserWindow(TextHelper.getText("javaFXViewSaveAsProjectWindowInitialName"), TextHelper.getText("javaFXViewSaveAsProjectWindowTitle"), true);
			if (selectedFile != null)
			{
				this.controller.notifySaveAsProject(selectedFile);
			}
		}
		catch (IOException e)
		{
			Logger.severe(e);
			displayErrorPopUpWindow(e.getMessage());
		}
	}

	/**
	 * Display a file chooser window.
	 * 
	 * @param initialName
	 *            The initial name.
	 * @param title
	 *            The title.
	 * @param isSaveDialog
	 *            If it is a save dialog.
	 * @return The selected file or NULL.
	 */
	private File displayFileChooserWindow(String initialName, String title, boolean isSaveDialog)
	{
		final FileChooser fileChooser = new FileChooser();
		fileChooser.setInitialFileName(initialName);
		fileChooser.setTitle(title);
		fileChooser.getExtensionFilters().add(EXTENSION_FILTER);

		return (isSaveDialog ? fileChooser.showSaveDialog(this.stage) : fileChooser.showOpenDialog(this.stage));
	}

	/**
	 * @see com.delormeloic.generator.view.IView#displayInformationPopUpWindow(java.lang.String, java.lang.String)
	 */
	@Override
	public void displayInformationPopUpWindow(String title, String text)
	{
		DialogHelper.displayInformationDialog(title, text);
	}

	/**
	 * @see com.delormeloic.generator.view.IView#displayErrorPopUpWindow(java.lang.String)
	 */
	@Override
	public void displayErrorPopUpWindow(String text)
	{
		DialogHelper.displayErrorDialog(text);
	}

	/**
	 * @see com.delormeloic.generator.view.IView#displayFatalErrorPopUpWindow(java.lang.String)
	 */
	@Override
	public void displayFatalErrorPopUpWindow(String text)
	{
		DialogHelper.displayFatalErrorDialog(text);
	}

	/**
	 * @see com.delormeloic.generator.view.IView#setData(com.delormeloic.generator.view.slidesforms.HeaderForm, com.delormeloic.generator.view.slidesforms.FooterForm, com.delormeloic.generator.view.slidesforms.BackgroundForm, java.util.List)
	 */
	@Override
	public void setData(HeaderForm headerForm, FooterForm footerForm, BackgroundForm backgroundForm, List<SlideForm> slidesForms)
	{
		clearData();

		enableMenuItems();
		this.addSlideButton.setDisable(false);

		this.slidesForms.getItems().addAll(slidesForms);
		this.formables.getItems().addAll(headerForm, footerForm, backgroundForm);

		this.slidesForms.getSelectionModel().selectedItemProperty().addListener(this);
		this.formables.getSelectionModel().selectedItemProperty().addListener(this);
	}

	/**
	 * @see com.delormeloic.generator.view.IView#clearData()
	 */
	@Override
	public void clearData()
	{
		disableMenuItems();
		computeDisabledButtons(-1);
		this.addSlideButton.setDisable(true);

		this.slidesForms.getSelectionModel().selectedItemProperty().removeListener(this);
		this.formables.getSelectionModel().selectedItemProperty().removeListener(this);

		this.slidesForms.getItems().clear();
		this.formables.getItems().clear();
		this.slideFormPane.getChildren().clear();
	}

	/**
	 * @see com.delormeloic.generator.view.IView#addSlideForm(com.delormeloic.generator.view.slidesforms.SlideForm)
	 */
	@Override
	public void addSlideForm(SlideForm slideForm)
	{
		this.slidesForms.getSelectionModel().selectedItemProperty().removeListener(this);
		this.slidesForms.getItems().add(slideForm);
		this.slidesForms.getSelectionModel().select(slideForm);
		this.slidesForms.getSelectionModel().selectedItemProperty().addListener(this);

		this.computeDisabledButtons(this.slidesForms.getItems().size() - 1);
		this.slideFormPane.getChildren().clear();
		this.slideFormPane.getChildren().add(slideForm.toForm());
	}

	/**
	 * @see com.delormeloic.generator.view.IView#moveUpSlideForm(com.delormeloic.generator.view.slidesforms.SlideForm)
	 */
	@Override
	public void moveUpSlideForm(SlideForm slideForm)
	{
		moveSlideForm(slideForm, -1);
	}

	/**
	 * @see com.delormeloic.generator.view.IView#moveDownSlideForm(com.delormeloic.generator.view.slidesforms.SlideForm)
	 */
	@Override
	public void moveDownSlideForm(SlideForm slideForm)
	{
		moveSlideForm(slideForm, 1);
	}

	/**
	 * Move a slide form.
	 * 
	 * @param slideForm
	 *            The slide form to move.
	 * @param offset
	 *            The offset.
	 */
	private void moveSlideForm(SlideForm slideForm, int offset)
	{
		this.slidesForms.getSelectionModel().selectedItemProperty().removeListener(this);
		this.slidesForms.getSelectionModel().clearSelection();
		final int index = this.slidesForms.getItems().indexOf(slideForm);
		Collections.swap(this.slidesForms.getItems(), index, index + offset);
		this.slidesForms.getSelectionModel().select(slideForm);
		this.slidesForms.getSelectionModel().selectedItemProperty().addListener(this);

		this.computeDisabledButtons(index + offset);
	}

	/**
	 * @see com.delormeloic.generator.view.IView#removeSlideForm(com.delormeloic.generator.view.slidesforms.SlideForm)
	 */
	@Override
	public void removeSlideForm(SlideForm slideForm)
	{
		this.slidesForms.getSelectionModel().selectedItemProperty().removeListener(this);
		this.slidesForms.getSelectionModel().clearSelection();
		this.slidesForms.getItems().remove(slideForm);
		this.slidesForms.getSelectionModel().selectedItemProperty().addListener(this);

		this.computeDisabledButtons(-1);
		this.slideFormPane.getChildren().clear();
	}

	/**
	 * Enable the menu items.
	 */
	private void enableMenuItems()
	{
		this.menuBar.enableSaveProjectMenuItem();
		this.menuBar.enableSaveAsProjectMenuItem();
		this.menuBar.enableCloseProjectMenuItem();
	}

	/**
	 * Disable the menu items.
	 */
	private void disableMenuItems()
	{
		this.menuBar.disableSaveProjectMenuItem();
		this.menuBar.disableSaveAsProjectMenuItem();
		this.menuBar.disableCloseProjectMenuItem();
	}

	/**
	 * @see javafx.event.EventHandler#handle(javafx.event.Event)
	 */
	@Override
	public void handle(ActionEvent event)
	{
		final Button selectedButton = (Button) event.getSource();

		if (selectedButton == this.addSlideButton)
		{
			clearFormablesSelection();
			clearSlidesFormsSelection();

			computeDisabledButtons(-1);
			this.slideFormPane.getChildren().clear();
			this.slideFormPane.getChildren().add(new SlideChooser(this.controller));
			return;
		}

		if (selectedButton == this.removeSlideButton)
		{
			this.controller.notifyRemoveSlideForm(this.slidesForms.getSelectionModel().getSelectedItem());
			return;
		}

		if (selectedButton == this.moveUpSlideButton)
		{
			this.controller.notifyMoveUpSlideForm(this.slidesForms.getSelectionModel().getSelectedItem());
			return;
		}

		if (selectedButton == this.moveDownSlideButton)
		{
			this.controller.notifyMoveDownSlideForm(this.slidesForms.getSelectionModel().getSelectedItem());
			return;
		}
	}

	/**
	 * Clear the formables selection.
	 */
	private void clearFormablesSelection()
	{
		this.formables.getSelectionModel().selectedItemProperty().removeListener(this);
		this.formables.getSelectionModel().clearSelection();
		this.formables.getSelectionModel().selectedItemProperty().addListener(this);
	}

	/**
	 * Clear the slides forms selection.
	 */
	private void clearSlidesFormsSelection()
	{
		this.slidesForms.getSelectionModel().selectedItemProperty().removeListener(this);
		this.slidesForms.getSelectionModel().clearSelection();
		this.slidesForms.getSelectionModel().selectedItemProperty().addListener(this);
	}

	/**
	 * Compute disabled buttons.
	 * 
	 * @param selectedItemIndex
	 *            The selected item index.
	 */
	private void computeDisabledButtons(int selectedItemIndex)
	{
		if (selectedItemIndex == -1)
		{
			this.removeSlideButton.setDisable(true);
			this.moveUpSlideButton.setDisable(true);
			this.moveDownSlideButton.setDisable(true);
			return;
		}

		if ((selectedItemIndex == 0) && (this.slidesForms.getItems().size() == 1))
		{
			this.removeSlideButton.setDisable(false);
			this.moveUpSlideButton.setDisable(true);
			this.moveDownSlideButton.setDisable(true);
			return;
		}

		if ((selectedItemIndex == 0) && (this.slidesForms.getItems().size() > 1))
		{
			this.removeSlideButton.setDisable(false);
			this.moveUpSlideButton.setDisable(true);
			this.moveDownSlideButton.setDisable(false);
			return;
		}

		if (selectedItemIndex == (this.slidesForms.getItems().size() - 1))
		{
			this.removeSlideButton.setDisable(false);
			this.moveUpSlideButton.setDisable(false);
			this.moveDownSlideButton.setDisable(true);
			return;
		}

		this.removeSlideButton.setDisable(false);
		this.moveUpSlideButton.setDisable(false);
		this.moveDownSlideButton.setDisable(false);
	}

	/**
	 * @see javafx.beans.value.ChangeListener#changed(javafx.beans.value.ObservableValue, java.lang.Object, java.lang.Object)
	 */
	@Override
	public void changed(ObservableValue<? extends IFormable> observable, IFormable oldValue, IFormable newValue)
	{
		if (newValue instanceof SlideForm)
		{
			clearFormablesSelection();
			computeDisabledButtons(this.slidesForms.getItems().indexOf(newValue));
		}
		else
		{
			clearSlidesFormsSelection();
			computeDisabledButtons(-1);
		}

		this.slideFormPane.getChildren().clear();
		this.slideFormPane.getChildren().add(newValue.toForm());
	}
}