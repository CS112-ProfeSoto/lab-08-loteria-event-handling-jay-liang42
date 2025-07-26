package cs112.lab08;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    ImageView cardImageView;
    Label messageLabel;

    //array of LoteriaCards to use for game:
    private static final LoteriaCard[] LOTERIA_CARDS = {
            new LoteriaCard("Las matematicas", "1.png", 1),
            new LoteriaCard("Las ciencias", "2.png", 2),
            new LoteriaCard("La Tecnología", "8.png", 8),
            new LoteriaCard("La ingeniería", "9.png", 9),
    };


    @Override
    public void start(Stage stage) throws IOException {
        LoteriaCard cardLogo = new LoteriaCard();

        //removed FXML code, fill this in with components, scene, stage, etc.
        Label titleLabel = new Label("Welcome to the Loteria!");
        cardImageView = new ImageView(cardLogo.getImage());
        messageLabel = new Label("Click the button below to randomly draw a card.");
        Button drawCardButton = new Button("Draw a random card");

        //Layout customization
        cardImageView.setFitWidth(200);
        cardImageView.setPreserveRatio(true);
        titleLabel.setFont(new Font(30.0));
        drawCardButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //Get card
                int rand = (int) (Math.random() * LOTERIA_CARDS.length);
                LoteriaCard randCard = LOTERIA_CARDS[rand];
                //Update card
                cardImageView.setImage(randCard.getImage());
                messageLabel.setText(randCard.getCardName());
            }
        });

        //Add components
        VBox vbox = new VBox();
        vbox.getChildren().addAll(titleLabel, cardImageView, messageLabel, drawCardButton);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(5.0);

        //Scene setup
        Scene scene = new Scene(vbox, 350, 500);
        stage.setTitle("Loteria Game");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}