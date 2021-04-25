package appli;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class MainController {
    public Label HelloWorld;

    public void sayHelloWorld(ActionEvent actionEvent) {


        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);

        // process the file, and limit periods to given time interval
        var teamsProcessor = new TEAMSProcessor(selectedFile,"19/01/2021 à 10:15:00", "19/01/2021 à 11:45:00");
/*
        var allpeople = teamsProcessor.get_allpeople();
        for (People people : allpeople) {
            System.out.println( people );
        }
*/
        System.out.println( teamsProcessor.toHTMLCode() );

        try {
            FileWriter myWriter = new FileWriter("index.html");
            myWriter.write(teamsProcessor.toHTMLCode());
            myWriter.close();  File htmlFile = new File("index.html");
            Desktop.getDesktop().browse(htmlFile.toURI()); } catch (IOException e)
            {
                e.printStackTrace(); }

    }
}
