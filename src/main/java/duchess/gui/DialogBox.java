package duchess.gui;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


/**
 * This class implements a DialogBox.
 */
public class DialogBox extends HBox {

    /** A circle used to clip images to a circle its size.*/
    final Circle circleClip = new Circle(50, 50, 50);

    /** The user's text or Duchess' reply.*/
    @FXML
    private Label dialog;

    /** The display picture of the user or Duchess.*/
    @FXML
    private ImageView displayPicture;

    /**
     * Constructs a DialogBox.
     * @param text The text by the user or Duchess.
     * @param img The display picture of the user or Duchess.
     */
    private DialogBox(String text, Image img) {
        super(30);
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainWindow.class.getResource("/view/DialogBox.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        dialog.setText(text);
        displayPicture.setImage(img);
        displayPicture.setClip(circleClip);
    }


    /**
     * Flips the dialog box such that the ImageView is on the left and text on the right.
     */
    private void flip() {
        this.setAlignment(Pos.TOP_LEFT);
        ObservableList<Node> tmp = FXCollections.observableArrayList(this.getChildren());
        FXCollections.reverse(tmp);
        this.getChildren().setAll(tmp);
    }

    /**
     * Gets the user dialog and colours the background blue and centers the text.
     * @param text The user's text.
     * @param iv The user's display picture.
     * @return The DialogBox of the user.
     */
    public static DialogBox getUserDialog(String text, Image iv) {
        var db = new DialogBox(text, iv);
        db.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, new CornerRadii(100), new Insets(12))));
        db.dialog.setTranslateY(40);
        return db;
    }

    /**
     * Gets the Duchess' dialog and colours the background green.
     * @param text The Duchess' text.
     * @param iv Duchess' display picture.
     * @return The DialogBox of the Duchess.
     */
    public static DialogBox getDuchessDialog(String text, Image iv) {
        var db = new DialogBox(text, iv);
        db.flip();
        db.setBackground(new Background(new BackgroundFill(Color.LAWNGREEN, new CornerRadii(100), new Insets(12))));
        return db;
    }
}
