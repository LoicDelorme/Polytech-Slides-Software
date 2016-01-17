package com.delormeloic.generator.view;

import java.io.IOException;

import com.delormeloic.generator.controller.IController;
import com.delormeloic.generator.view.helpers.TextHelper;
import com.delormeloic.utils.logger.Logger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

/**
 * This class represents a custom menu bar.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class CustomMenuBar extends MenuBar implements EventHandler<ActionEvent>
{
	/**
	 * The "File" menu.
	 */
	private final Menu fileMenu;

	/**
	 * The "New project" menu item.
	 */
	private final MenuItem newProject = new MenuItem(TextHelper.getText("customMenuBarNewProjectMenuItem"));

	/**
	 * The "Open project" menu item.
	 */
	private final MenuItem openProject = new MenuItem(TextHelper.getText("customMenuBarOpenProjectMenuItem"));

	/**
	 * The "Save project" menu item.
	 */
	private final MenuItem saveProject = new MenuItem(TextHelper.getText("customMenuBarSaveProjectMenuItem"));

	/**
	 * The "Save project as" menu item.
	 */
	private final MenuItem saveAsProject = new MenuItem(TextHelper.getText("customMenuBarSaveAsProjectMenuItem"));

	/**
	 * The "Close project" menu item.
	 */
	private final MenuItem closeProject = new MenuItem(TextHelper.getText("customMenuBarCloseProjectMenuItem"));

	/**
	 * The "Exit" menu item.
	 */
	private final MenuItem exit = new MenuItem(TextHelper.getText("customMenuBarExitProjectMenuItem"));

	/**
	 * The "?" menu.
	 */
	private final Menu informationMenu;

	/**
	 * The "Github Project" menu item.
	 */
	private final MenuItem githubProject = new MenuItem(TextHelper.getText("customMenuBarGithubProjectMenuItem"));

	/**
	 * The "Contact" menu item.
	 */
	private final MenuItem contact = new MenuItem(TextHelper.getText("customMenuBarContactMenuItem"));

	/**
	 * The "About" menu item.
	 */
	private final MenuItem about = new MenuItem(TextHelper.getText("customMenuBarAboutMenuItem"));

	/**
	 * The controller.
	 */
	private final IController controller;

	/**
	 * The view.
	 */
	private final IView view;

	/**
	 * Create a custom menu bar.
	 * 
	 * @param controller
	 *            The controller.
	 * @param view
	 *            The view.
	 */
	public CustomMenuBar(IController controller, IView view)
	{
		this.controller = controller;
		this.view = view;
		this.fileMenu = new Menu(TextHelper.getText("customMenuBarFileMenu"), null, this.newProject, this.openProject, this.saveProject, this.saveAsProject, this.closeProject, new SeparatorMenuItem(), this.exit);
		this.informationMenu = new Menu(TextHelper.getText("customMenuBarAboutMenu"), null, this.githubProject, this.contact, new SeparatorMenuItem(), this.about);

		initializeSetOnAction();
		initializeSetAccelerator();

		this.getMenus().addAll(this.fileMenu, this.informationMenu);
	}

	/**
	 * Initialize the on action behaviors.
	 */
	private void initializeSetOnAction()
	{
		this.newProject.setOnAction(this);
		this.openProject.setOnAction(this);
		this.saveProject.setOnAction(this);
		this.saveAsProject.setOnAction(this);
		this.closeProject.setOnAction(this);
		this.exit.setOnAction(this);
		this.githubProject.setOnAction(this);
		this.contact.setOnAction(this);
		this.about.setOnAction(this);
	}

	/**
	 * Initialize the accelerators.
	 */
	private void initializeSetAccelerator()
	{
		this.newProject.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));
		this.openProject.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));
		this.saveProject.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
		this.saveAsProject.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN, KeyCombination.SHIFT_DOWN));
		this.closeProject.setAccelerator(new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN, KeyCombination.SHIFT_DOWN));
		this.exit.setAccelerator(new KeyCodeCombination(KeyCode.Q, KeyCombination.CONTROL_DOWN));
	}

	/**
	 * Enable the "Save project" menu item.
	 */
	public void enableSaveProjectMenuItem()
	{
		enableMenuItem(this.saveProject);
	}

	/**
	 * Enable the "Save as project" menu item.
	 */
	public void enableSaveAsProjectMenuItem()
	{
		enableMenuItem(this.saveAsProject);
	}

	/**
	 * Enable the "Close project" menu item.
	 */
	public void enableCloseProjectMenuItem()
	{
		enableMenuItem(this.closeProject);
	}

	/**
	 * Disable the "Save project" menu item.
	 */
	public void disableSaveProjectMenuItem()
	{
		disableMenuItem(this.saveProject);
	}

	/**
	 * Disable the "Save as project" menu item.
	 */
	public void disableSaveAsProjectMenuItem()
	{
		disableMenuItem(this.saveAsProject);
	}

	/**
	 * Disable the "Close project" menu item.
	 */
	public void disableCloseProjectMenuItem()
	{
		disableMenuItem(this.closeProject);
	}

	/**
	 * Enable a menu item.
	 * 
	 * @param menuItem
	 *            The menu item to enable.
	 */
	private void enableMenuItem(MenuItem menuItem)
	{
		menuItem.setDisable(false);
	}

	/**
	 * Disable a menu item.
	 * 
	 * @param menuItem
	 *            The menu item to disable.
	 */
	private void disableMenuItem(MenuItem menuItem)
	{
		menuItem.setDisable(true);
	}

	/**
	 * @see javafx.event.EventHandler#handle(javafx.event.Event)
	 */
	@Override
	public void handle(ActionEvent event)
	{
		final MenuItem selectedMenuItem = (MenuItem) event.getSource();

		if (selectedMenuItem == this.newProject)
		{
			this.view.displayNewProjectWindow();
			return;
		}

		if (selectedMenuItem == this.openProject)
		{
			this.view.displayOpenProjectWindow();
			return;
		}

		if (selectedMenuItem == this.saveProject)
		{
			try
			{
				this.controller.notifySaveProject();
			}
			catch (IOException e)
			{
				Logger.severe(e);
				this.view.displayErrorPopUpWindow(e.getMessage());
			}

			return;
		}

		if (selectedMenuItem == this.saveAsProject)
		{
			this.view.displaySaveAsProjectWindow();
			return;
		}

		if (selectedMenuItem == this.closeProject)
		{
			try
			{
				disableSaveProjectMenuItem();
				disableSaveAsProjectMenuItem();
				disableCloseProjectMenuItem();
				this.controller.notifyCloseProject();
			}
			catch (IOException e)
			{
				Logger.severe(e);
				this.view.displayErrorPopUpWindow(e.getMessage());
			}

			return;
		}

		if (selectedMenuItem == this.exit)
		{
			this.view.closeWindow();
			return;
		}

		if (selectedMenuItem == this.githubProject)
		{
			this.view.displayInformationPopUpWindow(TextHelper.getText("customMenuBarGithubProjectTitle"), TextHelper.getText("customMenuBarGithubProjectText"));
			return;
		}

		if (selectedMenuItem == this.contact)
		{
			this.view.displayInformationPopUpWindow(TextHelper.getText("customMenuBarContactTitle"), TextHelper.getText("customMenuBarContactText"));
			return;
		}

		if (selectedMenuItem == this.about)
		{
			this.view.displayInformationPopUpWindow(TextHelper.getText("customMenuBarAboutTitle"), TextHelper.getText("customMenuBarAboutText"));
			return;
		}
	}
}