package com.delormeloic.generator.view.slidesforms;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;

import com.delormeloic.generator.model.slides.IConstants;
import com.delormeloic.generator.model.slides.SlideWithTwoTrombinoscope;
import com.delormeloic.generator.model.slides.data.Formation;
import com.delormeloic.generator.model.slides.data.Student;
import com.delormeloic.generator.view.converters.FormationCallback;
import com.delormeloic.generator.view.helpers.Base64Helper;
import com.delormeloic.generator.view.helpers.FormBuilderHelper;
import com.delormeloic.generator.view.helpers.TextHelper;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;

/**
 * This class represents a slide with two trombinoscope form.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class SlideWithTwoTrombinoscopeForm extends SlideForm implements EventHandler<ActionEvent>, ChangeListener<Formation>
{
	/**
	 * The left formations.
	 */
	private ListView<Formation> leftFormations;

	/**
	 * The right formations.
	 */
	private ListView<Formation> rightFormations;

	/**
	 * The add left formation button.
	 */
	private Button addLeftFormationButton;

	/**
	 * The add right formation button.
	 */
	private Button addRightFormationButton;

	/**
	 * The move up left formation button.
	 */
	private Button moveUpLeftFormationButton;

	/**
	 * The move up right formation button.
	 */
	private Button moveUpRightFormationButton;

	/**
	 * The move down left formation button.
	 */
	private Button moveDownLeftFormationButton;

	/**
	 * The move down right formation button.
	 */
	private Button moveDownRightFormationButton;

	/**
	 * The remove left formation button.
	 */
	private Button removeLeftFormationButton;

	/**
	 * The remove right formation button.
	 */
	private Button removeRightFormationButton;

	/**
	 * The name text field.
	 */
	private TextField nameTextField;

	/**
	 * The introduction text field.
	 */
	private TextField introductionTextField;

	/**
	 * The students text field.
	 */
	private TextField studentsTextField;

	/**
	 * The students button.
	 */
	private Button studentsButton;

	/**
	 * The conclusion text field.
	 */
	private TextField conclusionTextField;

	/**
	 * The formation titled pane.
	 */
	private TitledPane formationTitledPane;

	/**
	 * Create a slide with two trombinoscope form.
	 * 
	 * @param slideWithTwoTrombinoscope
	 *            The slide with two trombinoscope.
	 */
	public SlideWithTwoTrombinoscopeForm(SlideWithTwoTrombinoscope slideWithTwoTrombinoscope)
	{
		super(slideWithTwoTrombinoscope);
	}

	/**
	 * @see com.delormeloic.generator.view.slidesforms.IFormable#toForm()
	 */
	@Override
	public Node toForm()
	{
		final SlideWithTwoTrombinoscope slideWithTwoTrombinoscope = (SlideWithTwoTrombinoscope) this.slide;

		final TextField nameTextField = new TextField();
		nameTextField.textProperty().bindBidirectional(slideWithTwoTrombinoscope.getNameProperty());

		final CheckBox headerCheckBox = new CheckBox();
		headerCheckBox.selectedProperty().bindBidirectional(slideWithTwoTrombinoscope.getHeaderProperty());

		final CheckBox footerCheckBox = new CheckBox();
		footerCheckBox.selectedProperty().bindBidirectional(slideWithTwoTrombinoscope.getFooterProperty());

		final Label leftFormationsLabel = new Label(TextHelper.getText("slideWithTwoTrombinoscopeFormLeftFormationsLabel"));

		this.leftFormations = new ListView<Formation>();
		this.leftFormations.itemsProperty().bindBidirectional(slideWithTwoTrombinoscope.getLeftFormationsProperty());
		this.leftFormations.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		this.leftFormations.setCellFactory(new FormationCallback());
		this.leftFormations.getSelectionModel().selectedItemProperty().addListener(this);

		this.addLeftFormationButton = new Button(null, new ImageView(new Image(this.getClass().getResourceAsStream("/com/delormeloic/generator/view/resources/images/add_slide.png"))));
		this.addLeftFormationButton.setOnAction(this);

		this.moveUpLeftFormationButton = new Button(null, new ImageView(new Image(this.getClass().getResourceAsStream("/com/delormeloic/generator/view/resources/images/move_up.png"))));
		this.moveUpLeftFormationButton.setOnAction(this);

		this.moveDownLeftFormationButton = new Button(null, new ImageView(new Image(this.getClass().getResourceAsStream("/com/delormeloic/generator/view/resources/images/move_down.png"))));
		this.moveDownLeftFormationButton.setOnAction(this);

		this.removeLeftFormationButton = new Button(null, new ImageView(new Image(this.getClass().getResourceAsStream("/com/delormeloic/generator/view/resources/images/remove_slide.png"))));
		this.removeLeftFormationButton.setOnAction(this);

		final Region leftRegion = new Region();
		final HBox leftButtonsHBox = new HBox(this.addLeftFormationButton, this.removeLeftFormationButton, leftRegion, this.moveUpLeftFormationButton, this.moveDownLeftFormationButton);
		leftButtonsHBox.setAlignment(Pos.CENTER_LEFT);
		HBox.setHgrow(leftRegion, Priority.ALWAYS);

		final VBox leftFormationsVBox = new VBox(leftFormationsLabel, this.leftFormations, leftButtonsHBox);
		leftFormationsVBox.setAlignment(Pos.CENTER);

		computeDisabledButtons(-1, this.leftFormations);

		final Label rightFormationsLabel = new Label(TextHelper.getText("slideWithTwoTrombinoscopeFormRightFormationsLabel"));

		this.rightFormations = new ListView<Formation>();
		this.rightFormations.itemsProperty().bindBidirectional(slideWithTwoTrombinoscope.getRightFormationsProperty());
		this.rightFormations.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		this.rightFormations.setCellFactory(new FormationCallback());
		this.rightFormations.getSelectionModel().selectedItemProperty().addListener(this);

		this.addRightFormationButton = new Button(null, new ImageView(new Image(this.getClass().getResourceAsStream("/com/delormeloic/generator/view/resources/images/add_slide.png"))));
		this.addRightFormationButton.setOnAction(this);

		this.moveUpRightFormationButton = new Button(null, new ImageView(new Image(this.getClass().getResourceAsStream("/com/delormeloic/generator/view/resources/images/move_up.png"))));
		this.moveUpRightFormationButton.setOnAction(this);

		this.moveDownRightFormationButton = new Button(null, new ImageView(new Image(this.getClass().getResourceAsStream("/com/delormeloic/generator/view/resources/images/move_down.png"))));
		this.moveDownRightFormationButton.setOnAction(this);

		this.removeRightFormationButton = new Button(null, new ImageView(new Image(this.getClass().getResourceAsStream("/com/delormeloic/generator/view/resources/images/remove_slide.png"))));
		this.removeRightFormationButton.setOnAction(this);

		final Region rightRegion = new Region();
		final HBox rightButtonsHBox = new HBox(this.addRightFormationButton, this.removeRightFormationButton, rightRegion, this.moveUpRightFormationButton, this.moveDownRightFormationButton);
		rightButtonsHBox.setAlignment(Pos.CENTER_LEFT);
		HBox.setHgrow(rightRegion, Priority.ALWAYS);

		final VBox rightFormationsVBox = new VBox(rightFormationsLabel, this.rightFormations, rightButtonsHBox);
		rightFormationsVBox.setAlignment(Pos.CENTER);

		computeDisabledButtons(-1, this.rightFormations);

		final TitledPane nameTitledPane = new TitledPane(TextHelper.getText("slideFormNameTitledPane"), new HBox(nameTextField));
		nameTitledPane.setCollapsible(false);
		HBox.setHgrow(nameTextField, Priority.ALWAYS);
		final TitledPane headerTitledPane = new TitledPane(TextHelper.getText("slideFormHeaderTitledPane"), new HBox(headerCheckBox));
		headerTitledPane.setCollapsible(false);
		final TitledPane footerTitledPane = new TitledPane(TextHelper.getText("slideFormFooterTitledPane"), new HBox(footerCheckBox));
		footerTitledPane.setCollapsible(false);
		final TitledPane formationsListsTitledPane = new TitledPane(TextHelper.getText("slideWithTwoTrombinoscopeFormFormationsListsTitledPane"), new HBox(leftFormationsVBox, rightFormationsVBox));
		formationsListsTitledPane.setCollapsible(false);
		this.formationTitledPane = buildFormationTitledPane();

		final TitledPane generalInformationTitledPane = FormBuilderHelper.buildTitledPane(TextHelper.getText("slideFormGeneralInformationTitledPane"), new TitledPane[] { nameTitledPane, headerTitledPane, footerTitledPane });
		final TitledPane formationsTitledPane = FormBuilderHelper.buildTitledPane(TextHelper.getText("slideWithTwoTrombinoscopeFormFormationsTitledPane"), new TitledPane[] { formationsListsTitledPane, this.formationTitledPane });

		return FormBuilderHelper.buildTitledPane(TextHelper.getText("slideFormDataTitledPane"), new TitledPane[] { generalInformationTitledPane, formationsTitledPane });
	}

	/**
	 * Build the formation titled pane.
	 * 
	 * @return The build titled pane.
	 */
	private TitledPane buildFormationTitledPane()
	{
		this.nameTextField = new TextField();

		this.introductionTextField = new TextField();

		this.studentsTextField = new TextField();
		this.studentsTextField.setEditable(false);

		this.studentsButton = new Button(TextHelper.getText("slideWithTwoTrombinoscopeFormStudentsButton"));

		this.conclusionTextField = new TextField();

		final TitledPane nameTitledPane = new TitledPane(TextHelper.getText("slideWithTwoTrombinoscopeFormNameTitledPane"), new HBox(this.nameTextField));
		nameTitledPane.setCollapsible(false);
		HBox.setHgrow(nameTitledPane, Priority.ALWAYS);
		final TitledPane introductionTitledPane = new TitledPane(TextHelper.getText("slideWithTwoTrombinoscopeFormIntroductionTitledPane"), new HBox(this.introductionTextField));
		introductionTitledPane.setCollapsible(false);
		HBox.setHgrow(this.introductionTextField, Priority.ALWAYS);
		final TitledPane studentsTitledPane = new TitledPane(TextHelper.getText("slideWithTwoTrombinoscopeFormStudentsTitledPane"), new HBox(this.studentsTextField, this.studentsButton));
		studentsTitledPane.setCollapsible(false);
		HBox.setHgrow(this.studentsTextField, Priority.ALWAYS);
		final TitledPane conclusionTitledPane = new TitledPane(TextHelper.getText("slideWithTwoTrombinoscopeFormConclusionTitledPane"), new HBox(this.conclusionTextField));
		conclusionTitledPane.setCollapsible(false);
		HBox.setHgrow(this.conclusionTextField, Priority.ALWAYS);

		final TitledPane formationTitledPane = FormBuilderHelper.buildTitledPane(null, new TitledPane[] { nameTitledPane, introductionTitledPane, studentsTitledPane, conclusionTitledPane });
		formationTitledPane.setExpanded(false);
		formationTitledPane.setDisable(true);

		return formationTitledPane;
	}

	/**
	 * @see javafx.event.EventHandler#handle(javafx.event.Event)
	 */
	@Override
	public void handle(ActionEvent event)
	{
		final Button selectedButton = (Button) event.getSource();

		if (selectedButton == this.addLeftFormationButton)
		{
			addFormation(this.leftFormations);
		}

		if (selectedButton == this.addRightFormationButton)
		{
			addFormation(this.rightFormations);
		}

		if (selectedButton == this.moveUpLeftFormationButton)
		{
			moveUpFormation(this.leftFormations);
		}

		if (selectedButton == this.moveUpRightFormationButton)
		{
			moveUpFormation(this.rightFormations);
		}

		if (selectedButton == this.moveDownLeftFormationButton)
		{
			moveDownFormation(this.leftFormations);
		}

		if (selectedButton == this.moveDownRightFormationButton)
		{
			moveDownFormation(this.rightFormations);
		}

		if (selectedButton == this.removeLeftFormationButton)
		{
			removeFormation(this.leftFormations);
		}

		if (selectedButton == this.removeRightFormationButton)
		{
			removeFormation(this.rightFormations);
		}
	}

	/**
	 * Add a formation.
	 * 
	 * @param formations
	 *            The formations list view.
	 */
	private void addFormation(ListView<Formation> formations)
	{
		final Formation formation = new Formation();
		formations.getItems().add(formation);
		formations.getSelectionModel().select(formation);
	}

	/**
	 * Move up a formation.
	 * 
	 * @param formations
	 *            The formations list view.
	 */
	private void moveUpFormation(ListView<Formation> formations)
	{
		moveFormation(formations, formations.getSelectionModel().getSelectedItem(), -1);
	}

	/**
	 * Move down a formation.
	 * 
	 * @param formations
	 *            The formations list view.
	 */
	private void moveDownFormation(ListView<Formation> formations)
	{
		moveFormation(formations, formations.getSelectionModel().getSelectedItem(), 1);
	}

	/**
	 * Move a formation.
	 * 
	 * @param formations
	 *            The formations list view.
	 * @param formation
	 *            The formation to move.
	 * @param offset
	 *            The offset.
	 */
	private void moveFormation(ListView<Formation> formations, Formation formation, int offset)
	{
		formations.getSelectionModel().selectedItemProperty().removeListener(this);
		final int index = formations.getItems().indexOf(formation);
		Collections.swap(formations.getItems(), index, index + offset);
		formations.getSelectionModel().select(formation);
		computeDisabledButtons(index + offset, formations);
		formations.getSelectionModel().selectedItemProperty().addListener(this);
	}

	/**
	 * Remove a formation.
	 * 
	 * @param formations
	 *            The formations list view.
	 */
	private void removeFormation(ListView<Formation> formations)
	{
		final Formation selectedFormation = formations.getSelectionModel().getSelectedItem();

		formations.getSelectionModel().selectedItemProperty().removeListener(this);
		formations.getItems().remove(selectedFormation);
		formations.getSelectionModel().clearSelection();
		formations.getSelectionModel().selectedItemProperty().addListener(this);

		unbindData(selectedFormation);
		this.formationTitledPane.setExpanded(false);
		this.formationTitledPane.setDisable(true);
		computeDisabledButtons(-1, formations);
	}

	/**
	 * Compute disabled buttons.
	 * 
	 * @param selectedItemIndex
	 *            The selected item index.
	 * @param formations
	 *            The formations.
	 */
	private void computeDisabledButtons(int selectedItemIndex, ListView<Formation> formations)
	{
		if (this.leftFormations == formations)
		{
			if (selectedItemIndex == -1)
			{
				this.removeLeftFormationButton.setDisable(true);
				this.moveUpLeftFormationButton.setDisable(true);
				this.moveDownLeftFormationButton.setDisable(true);
				return;
			}

			if ((selectedItemIndex == 0) && (this.leftFormations.getItems().size() == 1))
			{
				this.removeLeftFormationButton.setDisable(false);
				this.moveUpLeftFormationButton.setDisable(true);
				this.moveDownLeftFormationButton.setDisable(true);
				return;
			}

			if ((selectedItemIndex == 0) && (this.leftFormations.getItems().size() > 1))
			{
				this.removeLeftFormationButton.setDisable(false);
				this.moveUpLeftFormationButton.setDisable(true);
				this.moveDownLeftFormationButton.setDisable(false);
				return;
			}

			if (selectedItemIndex == (this.leftFormations.getItems().size() - 1))
			{
				this.removeLeftFormationButton.setDisable(false);
				this.moveUpLeftFormationButton.setDisable(false);
				this.moveDownLeftFormationButton.setDisable(true);
				return;
			}

			this.removeLeftFormationButton.setDisable(false);
			this.moveUpLeftFormationButton.setDisable(false);
			this.moveDownLeftFormationButton.setDisable(false);
		}
		else
		{
			if (selectedItemIndex == -1)
			{
				this.removeRightFormationButton.setDisable(true);
				this.moveUpRightFormationButton.setDisable(true);
				this.moveDownRightFormationButton.setDisable(true);
				return;
			}

			if ((selectedItemIndex == 0) && (this.rightFormations.getItems().size() == 1))
			{
				this.removeRightFormationButton.setDisable(false);
				this.moveUpRightFormationButton.setDisable(true);
				this.moveDownRightFormationButton.setDisable(true);
				return;
			}

			if ((selectedItemIndex == 0) && (this.rightFormations.getItems().size() > 1))
			{
				this.removeRightFormationButton.setDisable(false);
				this.moveUpRightFormationButton.setDisable(true);
				this.moveDownRightFormationButton.setDisable(false);
				return;
			}

			if (selectedItemIndex == (this.rightFormations.getItems().size() - 1))
			{
				this.removeRightFormationButton.setDisable(false);
				this.moveUpRightFormationButton.setDisable(false);
				this.moveDownRightFormationButton.setDisable(true);
				return;
			}

			this.removeRightFormationButton.setDisable(false);
			this.moveUpRightFormationButton.setDisable(false);
			this.moveDownRightFormationButton.setDisable(false);
		}
	}

	/**
	 * Unbind data.
	 * 
	 * @param formation
	 *            The formation to unbind.
	 */
	private void unbindData(Formation formation)
	{
		this.nameTextField.textProperty().unbindBidirectional(formation.getNameProperty());
		this.nameTextField.clear();

		this.introductionTextField.textProperty().unbindBidirectional(formation.getIntroductionProperty());
		this.introductionTextField.clear();

		this.studentsTextField.clear();

		this.conclusionTextField.textProperty().unbindBidirectional(formation.getConclusionProperty());
		this.conclusionTextField.clear();

		this.formationTitledPane.textProperty().unbind();
		this.formationTitledPane.setText(IConstants.DEFAULT_TEXT);
	}

	/**
	 * Bind data.
	 * 
	 * @param formation
	 *            The formation to bind.
	 */
	private void bindData(Formation formation)
	{
		this.nameTextField.textProperty().bindBidirectional(formation.getNameProperty());
		this.introductionTextField.textProperty().bindBidirectional(formation.getIntroductionProperty());
		this.studentsTextField.setText(String.format(TextHelper.getText("slideFormImagesLoaded"), formation.getStudents().size()));
		this.studentsButton.setOnAction(e ->
		{
			final DirectoryChooser directoryChooser = new DirectoryChooser();

			final File selectedDirectory = directoryChooser.showDialog(null);
			if (selectedDirectory != null)
			{
				final List<Student> students = formation.getStudents();
				students.clear();

				for (File file : selectedDirectory.listFiles())
				{
					final Matcher matcher = IConstants.DEFAULT_STUDENT_PATTERN.matcher(file.getName());
					if (matcher.find())
					{
						students.add(new Student(matcher.group(2), matcher.group(3), Base64Helper.encode(file)));
					}
				}

				this.studentsTextField.setText(String.format(TextHelper.getText("slideFormImagesLoaded"), students.size()));
			}
		});
		this.conclusionTextField.textProperty().bindBidirectional(formation.getConclusionProperty());
		this.formationTitledPane.textProperty().bind(formation.getNameProperty());
	}

	/**
	 * @see javafx.beans.value.ChangeListener#changed(javafx.beans.value.ObservableValue, java.lang.Object, java.lang.Object)
	 */
	@Override
	public void changed(ObservableValue<? extends Formation> observable, Formation oldValue, Formation newValue)
	{
		Formation possibleSelection = null;
		if (this.leftFormations.getItems().contains(newValue))
		{
			possibleSelection = this.rightFormations.getSelectionModel().getSelectedItem();
			clearRightSelection();
			computeDisabledButtons(-1, this.rightFormations);
			computeDisabledButtons(this.leftFormations.getItems().indexOf(newValue), this.leftFormations);
		}
		else
		{
			possibleSelection = this.leftFormations.getSelectionModel().getSelectedItem();
			clearLeftSelection();
			computeDisabledButtons(-1, this.leftFormations);
			computeDisabledButtons(this.rightFormations.getItems().indexOf(newValue), this.rightFormations);
		}

		if ((oldValue == null) && (possibleSelection == null))
		{
			this.formationTitledPane.setDisable(false);
		}
		else
		{
			if (possibleSelection != null)
			{
				unbindData(possibleSelection);
			}
			else
			{
				unbindData(oldValue);
			}
		}

		bindData(newValue);
	}

	/**
	 * Clear the left selection.
	 */
	private void clearLeftSelection()
	{
		this.leftFormations.getSelectionModel().selectedItemProperty().removeListener(this);
		this.leftFormations.getSelectionModel().clearSelection();
		this.leftFormations.getSelectionModel().selectedItemProperty().addListener(this);
	}

	/**
	 * Clear the right selection.
	 */
	private void clearRightSelection()
	{
		this.rightFormations.getSelectionModel().selectedItemProperty().removeListener(this);
		this.rightFormations.getSelectionModel().clearSelection();
		this.rightFormations.getSelectionModel().selectedItemProperty().addListener(this);
	}
}