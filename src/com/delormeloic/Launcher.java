package com.delormeloic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.UUID;

import com.delormeloic.generator.controller.BasicController;
import com.delormeloic.generator.controller.IController;
import com.delormeloic.generator.model.IModel;
import com.delormeloic.generator.model.JSONPlainTextFileModel;
import com.delormeloic.generator.view.IView;
import com.delormeloic.generator.view.JavaFXView;
import com.delormeloic.generator.view.helpers.TextHelper;
import com.delormeloic.utils.logger.Logger;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * This class represents the launcher of the application.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class Launcher extends Application
{
	/**
	 * The entry of the application.
	 * 
	 * @param args
	 *            Some arguments.
	 */
	public static void main(String[] args)
	{
		try
		{
			Logger.setDefaultPrintWriter(new PrintWriter(new File("log/" + UUID.randomUUID().toString())));
		}
		catch (FileNotFoundException e)
		{
			Logger.severe(e);
		}

		launch(args);
	}

	/**
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		primaryStage.getIcons().add(new Image(this.getClass().getResourceAsStream("/com/delormeloic/generator/view/resources/images/polytech_icon.png")));
		final Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();

		final IController controller = new BasicController();
		final IView view = new JavaFXView(controller, primaryStage, TextHelper.getText("applicationTitle"), screenSize.getWidth(), screenSize.getHeight());
		final IModel model = new JSONPlainTextFileModel(controller);

		controller.bindModel(model);
		controller.bindView(view);

		view.showWindow();
	}
}