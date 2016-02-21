package com.delormeloic.generator.view.slidesforms;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;

import com.delormeloic.generator.model.slides.IConstants;
import com.delormeloic.generator.model.slides.SlideWithOneTrombinoscope;
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
 * This class represents a slide with one trombinoscope form.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class SlideWithOneTrombinoscopeForm extends SlideForm implements EventHandler<ActionEvent>, ChangeListener<Formation>
{
	/**
	 * The formations.
	 */
	private ListView<Formation> formations;

	/**
	 * The add formation button.
	 */
	private Button addFormationButton;

	/**
	 * The move up formation button.
	 */
	private Button moveUpFormationButton;

	/**
	 * The move down formation button.
	 */
	private Button moveDownFormationButton;

	/**
	 * The remove formation button.
	 */
	private Button removeFormationButton;

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
	 * Create a slide with one trombinoscope form.
	 * 
	 * @param slideWithOneTrombinoscope
	 *            The slide with one trombinoscope.
	 */
	public SlideWithOneTrombinoscopeForm(SlideWithOneTrombinoscope slideWithOneTrombinoscope)
	{
		super(slideWithOneTrombinoscope);
	}

	/**
	 * @see com.delormeloic.generator.view.slidesforms.IFormable#toForm()
	 */
	@Override
	public Node toForm()
	{
		final SlideWithOneTrombinoscope slideWithOneTrombinoscope = (SlideWithOneTrombinoscope) this.slide;

		final TextField nameTextField = new TextField();
		nameTextField.textProperty().bindBidirectional(slideWithOneTrombinoscope.getNameProperty());

		final CheckBox headerCheckBox = new CheckBox();
		headerCheckBox.selectedProperty().bindBidirectional(slideWithOneTrombinoscope.getHeaderProperty());

		final CheckBox footerCheckBox = new CheckBox();
		footerCheckBox.selectedProperty().bindBidirectional(slideWithOneTrombinoscope.getFooterProperty());

		final Label formationsLabel = new Label(TextHelper.getText("slideWithOneTrombinoscopeFormFormationsLabel"));

		this.formations = new ListView<Formation>();
		this.formations.itemsProperty().bindBidirectional(slideWithOneTrombinoscope.getFormationsProperty());
		this.formations.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		this.formations.setCellFactory(new FormationCallback());
		this.formations.getSelectionModel().selectedItemProperty().addListener(this);

		this.addFormationButton = new Button(null, new ImageView(new Image(this.getClass().getResourceAsStream("/com/delormeloic/generator/view/resources/images/add_slide.png"))));
		this.addFormationButton.setOnAction(this);

		this.moveUpFormationButton = new Button(null, new ImageView(new Image(this.getClass().getResourceAsStream("/com/delormeloic/generator/view/resources/images/move_up.png"))));
		this.moveUpFormationButton.setOnAction(this);

		this.moveDownFormationButton = new Button(null, new ImageView(new Image(this.getClass().getResourceAsStream("/com/delormeloic/generator/view/resources/images/move_down.png"))));
		this.moveDownFormationButton.setOnAction(this);

		this.removeFormationButton = new Button(null, new ImageView(new Image(this.getClass().getResourceAsStream("/com/delormeloic/generator/view/resources/images/remove_slide.png"))));
		this.removeFormationButton.setOnAction(this);

		final Region region = new Region();
		final HBox buttonsHBox = new HBox(this.addFormationButton, this.removeFormationButton, region, this.moveUpFormationButton, this.moveDownFormationButton);
		buttonsHBox.setAlignment(Pos.CENTER_LEFT);
		HBox.setHgrow(region, Priority.ALWAYS);

		final VBox formationsVBox = new VBox(formationsLabel, this.formations, buttonsHBox);
		formationsVBox.setAlignment(Pos.CENTER);

		computeDisabledButtons(-1);

		final TitledPane nameTitledPane = new TitledPane(TextHelper.getText("slideFormNameTitledPane"), new HBox(nameTextField));
		nameTitledPane.setCollapsible(false);
		HBox.setHgrow(nameTextField, Priority.ALWAYS);
		final TitledPane headerTitledPane = new TitledPane(TextHelper.getText("slideFormHeaderTitledPane"), new HBox(headerCheckBox));
		headerTitledPane.setCollapsible(false);
		final TitledPane footerTitledPane = new TitledPane(TextHelper.getText("slideFormFooterTitledPane"), new HBox(footerCheckBox));
		footerTitledPane.setCollapsible(false);
		final TitledPane formationsListTitledPane = new TitledPane(TextHelper.getText("slideWithOneTrombinoscopeFormFormationsListTitledPane"), new HBox(formationsVBox));
		formationsListTitledPane.setCollapsible(false);
		this.formationTitledPane = buildFormationTitledPane();

		final TitledPane generalInformationTitledPane = FormBuilderHelper.buildTitledPane(TextHelper.getText("slideFormGeneralInformationTitledPane"), new TitledPane[] { nameTitledPane, headerTitledPane, footerTitledPane });
		final TitledPane formationsTitledPane = FormBuilderHelper.buildTitledPane(TextHelper.getText("slideWithOneTrombinoscopeFormFormationsTitledPane"), new TitledPane[] { formationsListTitledPane, this.formationTitledPane });

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

		this.studentsButton = new Button(TextHelper.getText("slideWithOneTrombinoscopeFormStudentsButton"));

		this.conclusionTextField = new TextField();

		final TitledPane nameTitledPane = new TitledPane(TextHelper.getText("slideWithOneTrombinoscopeFormNameTitledPane"), new HBox(this.nameTextField));
		nameTitledPane.setCollapsible(false);
		HBox.setHgrow(nameTitledPane, Priority.ALWAYS);
		final TitledPane introductionTitledPane = new TitledPane(TextHelper.getText("slideWithOneTrombinoscopeFormIntroductionTitledPane"), new HBox(this.introductionTextField));
		introductionTitledPane.setCollapsible(false);
		HBox.setHgrow(this.introductionTextField, Priority.ALWAYS);
		final TitledPane studentsTitledPane = new TitledPane(TextHelper.getText("slideWithOneTrombinoscopeFormStudentsTitledPane"), new HBox(this.studentsTextField, this.studentsButton));
		studentsTitledPane.setCollapsible(false);
		HBox.setHgrow(this.studentsTextField, Priority.ALWAYS);
		final TitledPane conclusionTitledPane = new TitledPane(TextHelper.getText("slideWithOneTrombinoscopeFormConclusionTitledPane"), new HBox(this.conclusionTextField));
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

		if (selectedButton == this.addFormationButton)
		{
			addFormation();
		}

		if (selectedButton == this.moveUpFormationButton)
		{
			moveUpFormation();
		}

		if (selectedButton == this.moveDownFormationButton)
		{
			moveDownFormation();
		}

		if (selectedButton == this.removeFormationButton)
		{
			removeFormation();
		}
	}

	/**
	 * Add a formation.
	 */
	private void addFormation()
	{
		final Formation formation = new Formation();
		this.formations.getItems().add(formation);
		this.formations.getSelectionModel().select(formation);
	}

	/**
	 * Move up a formation.
	 */
	private void moveUpFormation()
	{
		moveFormation(this.formations.getSelectionModel().getSelectedItem(), -1);
	}

	/**
	 * Move down a formation.
	 */
	private void moveDownFormation()
	{
		moveFormation(this.formations.getSelectionModel().getSelectedItem(), 1);
	}

	/**
	 * Move a formation.
	 * 
	 * @param formation
	 *            The formation to move.
	 * @param offset
	 *            The offset.
	 */
	private void moveFormation(Formation formation, int offset)
	{
		this.formations.getSelectionModel().selectedItemProperty().removeListener(this);
		final int index = this.formations.getItems().indexOf(formation);
		Collections.swap(this.formations.getItems(), index, index + offset);
		this.formations.getSelectionModel().select(formation);
		computeDisabledButtons(index + offset);
		this.formations.getSelectionModel().selectedItemProperty().addListener(this);
	}

	/**
	 * Remove a formation.
	 */
	private void removeFormation()
	{
		final Formation selectedFormation = this.formations.getSelectionModel().getSelectedItem();

		this.formations.getSelectionModel().selectedItemProperty().removeListener(this);
		this.formations.getItems().remove(selectedFormation);
		this.formations.getSelectionModel().clearSelection();
		this.formations.getSelectionModel().selectedItemProperty().addListener(this);

		unbindData(selectedFormation);
		this.formationTitledPane.setExpanded(false);
		this.formationTitledPane.setDisable(true);
		computeDisabledButtons(-1);
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
			this.removeFormationButton.setDisable(true);
			this.moveUpFormationButton.setDisable(true);
			this.moveDownFormationButton.setDisable(true);
			return;
		}

		if ((selectedItemIndex == 0) && (this.formations.getItems().size() == 1))
		{
			this.removeFormationButton.setDisable(false);
			this.moveUpFormationButton.setDisable(true);
			this.moveDownFormationButton.setDisable(true);
			return;
		}

		if ((selectedItemIndex == 0) && (this.formations.getItems().size() > 1))
		{
			this.removeFormationButton.setDisable(false);
			this.moveUpFormationButton.setDisable(true);
			this.moveDownFormationButton.setDisable(false);
			return;
		}

		if (selectedItemIndex == (this.formations.getItems().size() - 1))
		{
			this.removeFormationButton.setDisable(false);
			this.moveUpFormationButton.setDisable(false);
			this.moveDownFormationButton.setDisable(true);
			return;
		}

		this.removeFormationButton.setDisable(false);
		this.moveUpFormationButton.setDisable(false);
		this.moveDownFormationButton.setDisable(false);
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
		if (oldValue != null)
		{
			unbindData(oldValue);
		}
		else
		{
			this.formationTitledPane.setDisable(false);
		}

		bindData(newValue);
		computeDisabledButtons(this.formations.getItems().indexOf(newValue));
	}
}