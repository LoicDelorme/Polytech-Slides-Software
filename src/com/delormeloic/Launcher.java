package com.delormeloic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.Thread.UncaughtExceptionHandler;
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
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * This class represents the launcher of the application.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class Launcher extends Application implements UncaughtExceptionHandler
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

		Application.launch(args);
	}

	/**
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		Thread.setDefaultUncaughtExceptionHandler(this);
		final Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();

		final IController controller = new BasicController();
		final IView view = new JavaFXView(controller, primaryStage, TextHelper.getText("applicationTitle"), screenSize.getWidth(), screenSize.getHeight());
		final IModel model = new JSONPlainTextFileModel(controller);

		controller.bindModel(model);
		controller.bindView(view);

		view.showWindow();
	}

	/**
	 * @see java.lang.Thread.UncaughtExceptionHandler#uncaughtException(java.lang.Thread, java.lang.Throwable)
	 */
	@Override
	public void uncaughtException(Thread t, Throwable e)
	{
		Logger.severe(new Exception(e));
	}
}