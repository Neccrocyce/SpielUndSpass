package layout;
	
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;


public class MainFrame extends Application {
	/**
	 * [team][player][]
	 */
	private static int numOfPlayers;
	private static MainFrame instance = null;
	private double width, height, padding;
	private BorderPane root;	
	private BorderPane[] teamPane;
	private VBox gameTxtPane;
	private VBox[] teamHeadPane, teamPlayerPane;
	private HBox[] teamScorePane;
	private HBox[][] teamPlayerEachPane;
	private StackPane gamePane;
	private StackPane[] teamNamePane;
	private StackPane[][] teamScorePtsPane, teamPlayerTxtPane;
	private StackPane[][][] teamPlayerNamePane;
	
	private Label gameLabel;
	private Label[] gameText, teamNameLabel;
	private Label[][] teamScoreNumberLabel, teamPlayerTxtLabel;
	private Label[][][] teamPlayerNameLabel;
	
	private Text[] teamNameText;
	private Text[][] teamScoreText;
	private Text[][][] teamPlayerNameText;
	
	
	@Override
	public void start(Stage primaryStage) {
		//init arrays
		teamPane = new BorderPane[2];
		teamHeadPane = new VBox[2];
		teamPlayerPane = new VBox[2];
		teamNamePane = new StackPane[2];
		teamScorePane = new HBox[2];
		teamScorePtsPane = new StackPane[2][3];
		teamPlayerEachPane = new HBox[2][numOfPlayers];
		teamPlayerNamePane = new StackPane[2][numOfPlayers][2];
		teamPlayerTxtPane = new StackPane[2][numOfPlayers];
		
		gameText = new Label[3];
		teamNameLabel = new Label[2];
		teamScoreNumberLabel = new Label[2][3];
		teamPlayerNameLabel = new Label[2][numOfPlayers][2];
		teamPlayerTxtLabel = new Label[2][numOfPlayers];
		
		teamNameText = new Text[2];
		teamScoreText = new Text[2][3];
		teamPlayerNameText = new Text[2][numOfPlayers][2];
		
		//root
		primaryStage.setTitle("Spiel- und Spass");
		root = new BorderPane();
		Scene scene = new Scene(root, 1200, 675);	
		scene.getStylesheets().add(getClass().getResource("mainframe.css").toExternalForm());
		width = root.getWidth();
		height = root.getHeight();
		scene.widthProperty().addListener(new ChangeListener<Number>() {
		    @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) {
		        resize();
		    }
		});
		scene.heightProperty().addListener(new ChangeListener<Number>() {
		    @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneHeight, Number newSceneHeight) {
		        resize();
		    }
		});
		
		
		
		//gamePane, label
		gamePane = new StackPane();
		root.setCenter(gamePane);
		
		gameLabel = new Label();
		gameLabel.setEffect(createDefaultDropShadow());
		gamePane.getChildren().add(gameLabel);
		
		gameTxtPane = new VBox();
		gamePane.getChildren().add(gameTxtPane);
		
		gameText[0] = new Label("Titel des Spiels steht hier");
		gameText[0].setWrapText(true);
		gameText[0].setAlignment(Pos.TOP_CENTER);
		gameText[0].setTextAlignment(TextAlignment.CENTER);		
		gameTxtPane.getChildren().add(gameText[0]);
		
		gameText[1] = new Label("Hier könnte die Beschreibung des Spiels stehen. Diese kann auch sehr ausführlich sein, da dafür genug platz ist.");
		gameText[1].setWrapText(true);
		gameText[1].setAlignment(Pos.TOP_CENTER);
		gameText[1].setTextAlignment(TextAlignment.JUSTIFY);
		gameTxtPane.getChildren().add(gameText[1]);
		
		gameText[2] = new Label("00:00:00\t00:00:00");
		gameText[2].setAlignment(Pos.BOTTOM_CENTER);
		gameText[2].setTextAlignment(TextAlignment.CENTER);
		gameTxtPane.getChildren().add(gameText[2]);
		
		
		//teamPane
		for (int i = 0; i < 2; i++) {
			teamPane[i] = new BorderPane();
			teamPane[i].setPrefWidth(width / 4);
			
			//teamHeadPane
			teamHeadPane[i] = new VBox();
			teamPane[i].setTop(teamHeadPane[i]);
			
			//teamPlayersPane
			teamPlayerPane[i] = new VBox();
			teamPane[i].setCenter(teamPlayerPane[i]);
			
			//teamNamePane, -Label, -Text
			teamNamePane[i] = new StackPane();
			teamHeadPane[i].getChildren().add(teamNamePane[i]);
			teamNameLabel[i] = new Label();
			teamNameLabel[i].setEffect(createDefaultDropShadow());
			teamNamePane[i].getChildren().add(teamNameLabel[i]);
			teamNameText[i] = new Text("TEAM " + (i+1));
			teamNamePane[i].getChildren().add(teamNameText[i]);
			
			//teamScorePane
			teamScorePane[i] = new HBox();
			teamHeadPane[i].getChildren().add(teamScorePane[i]);
			for (int j = 0; j < 3; j++) {
				teamScorePtsPane[i][j] = new StackPane();
				teamScorePane[i].getChildren().add(teamScorePtsPane[i][j]);
				
				teamScoreNumberLabel[i][j] = new Label();
				teamScoreNumberLabel[i][j].setEffect(createDefaultDropShadow());
				teamScorePtsPane[i][j].getChildren().add(teamScoreNumberLabel[i][j]);
				teamScoreText[i][j] = new Text("0");
				teamScorePtsPane[i][j].getChildren().add(teamScoreText[i][j]);
			}
			
			//teamPlayerPane
			for (int j = 0; j < numOfPlayers; j++) {
				//teamPlayerEachPane
				teamPlayerEachPane[i][j] = new HBox();
				teamPlayerPane[i].getChildren().add(teamPlayerEachPane[i][j]);
				
				for (int k = 0; k < 2; k++) {
					//teamPlayerNamePane, -label, -text
					teamPlayerNamePane[i][j][k] = new StackPane();
					teamPlayerEachPane[i][j].getChildren().add(teamPlayerNamePane[i][j][k]);
					
					teamPlayerNameLabel[i][j][k] = new Label();
					teamPlayerNameLabel[i][j][k].setEffect(createDefaultDropShadow());
					teamPlayerNamePane[i][j][k].getChildren().add(teamPlayerNameLabel[i][j][k]);
					
					teamPlayerNameText[i][j][k] = new Text();
					teamPlayerNameText[i][j][k].setFill(Color.WHITE);
					teamPlayerNamePane[i][j][k].getChildren().add(teamPlayerNameText[i][j][k]);
				}
				//teamPlayerTxtPane, -label, -text
				teamPlayerTxtPane[i][j] = new StackPane();
				teamPlayerEachPane[i][j].getChildren().add(teamPlayerTxtPane[i][j]);
				
				teamPlayerTxtLabel[i][j] = new Label();
				teamPlayerTxtLabel[i][j].setEffect(createDefaultDropShadow());
				teamPlayerTxtPane[i][j].getChildren().add(teamPlayerTxtLabel[i][j]);
				
				
				teamPlayerNameText[i][j][0].setText("P\nl\n" + j);
				teamPlayerNameText[i][j][1].setText("0");
			}
			
			
//			teamPlayerEachPane[i][2].setStyle("-fx-background-color: black;");
//			gameText[0].setStyle("-fx-background-color: red;");
//			gameText[1].setStyle("-fx-background-color: blue;");
//			gameText[2].setStyle("-fx-background-color: white;");
//			gameTxtPane.setStyle("-fx-background-color: rgb(0, 80, 0, 0.5);");
//			gameTxtTitlePane.setStyle("-fx-background-color: linear-gradient(#61a2b1, #2A5058);");
			
			gameText[1].setText("Hier könnte die Beschreibung des Spiels stehen. Diese kann auch sehr lang sein, da sie dann immernoch dargestellt wird. Aufgrund der automatischen Schriftgrößenänderung stellt dies daher kein Problem dar. Sollte die Beschreibung allerding viel zu lang sein, dann könnte es sein dass der Text so klein ist, dass man ihn nicht mehr lesen kann. Allerdings müsste die Beschreibung dafür schon ziemlich lange sein oder die Auflösung des Bildschirms sehr gering.");
		}
		
		root.setLeft(teamPane[0]);
		root.setRight(teamPane[1]);
		teamNameText[0].setFill(Color.TOMATO);
		teamNameText[1].setFill(Color.CORNFLOWERBLUE);
		for (int i = 0; i < 2; i++) {	
			teamScoreText[0][i].setFill(Color.TOMATO);
			teamScoreText[1][i].setFill(Color.CORNFLOWERBLUE);			
		}
		teamScoreText[0][2].setFill(Color.WHITE);
		teamScoreText[1][2].setFill(Color.WHITE);
		
		
		
		primaryStage.setScene(scene);
		primaryStage.show();
		resize();
		instance = this;
	}
	
	private DropShadow createDefaultDropShadow () {
		return new DropShadow(100, 10, 10, new Color(0.1, 0.1, 0.1, 1));
	}
	
	private InnerShadow createDefaultInnerShadow () {
		InnerShadow is = new InnerShadow();
		is.setOffsetX(3.0);
		is.setOffsetY(3.0);
		is.setRadius(10);
		return is;
	}
	
	private InnerShadow createInnerShadow (double fontSize) {
		InnerShadow is = new InnerShadow();
		is.setOffsetX(fontSize / 25);
		is.setOffsetY(fontSize / 25);
		is.setRadius(fontSize / 7.5);
		return is;
	}
	
	private Font createFontPlank (double width, double height, String txt) {
		String[] lines = txt.split("\n");
		int maxLength = 0;
		for (String string : lines) {
			maxLength = string.length() > maxLength ? string.length() : maxLength;
		}
		double fontSize =  Math.min(1.25 * width / maxLength, height * 0.6 / (lines.length));
		return Font.font("Comic Sans MS", FontWeight.BOLD, fontSize);		
	}
	
	private Font createFontPaper (double fontSize) {
		return Font.font("Old English Text MT", FontWeight.NORMAL, fontSize);
	}
	
	private Font createFontPaperHeading () {
		return createFontPaper(teamNameText[0].getFont().getSize());
	}
	
	private Font createFontPaperGame (String txt) {
		double fontWidth = 0.45;		//Width of a character with font-Size 1
		double fontHeight = 1.25;	//Height of a character with font-Size 1
		double maxFontSize = (2.0/3.0) * teamNameText[0].getFont().getSize();
		int numberOfLinesTitle = gameText[0].getText().length() / (int) (gameText[0].getPrefWidth() / (gameText[0].getFont().getSize() * fontWidth)) + 1;
		double width = gameText[0].getPrefWidth();
		double height = this.height - 2 * StackPane.getMargin(gameTxtPane).getTop() - (numberOfLinesTitle * gameText[0].getFont().getSize() + maxFontSize) * fontHeight;
		double fontSize = Math.sqrt((height * width) / (txt.length() * fontWidth * fontHeight));
		return createFontPaper (Math.min(maxFontSize, fontSize));
		
		//height = numberOfLines * fontSize * fontHeight
		//width = (text.length * fontSize * fontWidth) / numberOfLines
	}
	
	private Font createFontPaperBottom () {
		return Font.font("Old English Text MT", FontWeight.NORMAL, (2.0/3.0) * teamNameText[0].getFont().getSize());
	}
	
	private double calcHeightOfFont (Label TextLabel) {
		String txt = TextLabel.getText();
		double fontSize = TextLabel.getFont().getSize();
		double width = TextLabel.getPrefWidth();
		int numberOfLines = txt.length() / (int) (width / (fontSize * 0.5)) + 1;
		return numberOfLines * fontSize * 1.25;
		//font-Size 50.625 and width 408: 15 letters
	}
	

	public static void setNumOfPlayers(int numOfPlayers) {
		MainFrame.numOfPlayers = (numOfPlayers % 2) == 0 ? numOfPlayers / 2 : numOfPlayers / 2 + 1;
	}
	
	public void resize() {
		width = root.getWidth();
		height = root.getHeight();
		padding = Math.min(height, width) / 25;
		
		//gameLabel
		gameLabel.setGraphic(new ImageView(new Image("file:data/images/paper4.png", width / 2, height, false, false)));
		StackPane.setMargin(gameTxtPane, new Insets(height/ 15, width / 12.5, height / 15, width / 12.5));
		
		//teamPane
		for (int i = 0; i < 2; i++) {
			teamPane[i].setPrefWidth(width / 4);
			//teamHead
			teamHeadPane[i].setPrefHeight(height / 4);
			teamNamePane[i].setPrefHeight(teamHeadPane[i].getPrefHeight() / 2);
			teamScorePane[i].setPrefHeight(teamNamePane[i].getPrefHeight());
			teamScorePane[i].setPadding(new Insets(padding / 2));
			teamScorePane[i].setSpacing((teamScorePane[i].getPrefHeight() - padding) / 10);
			HBox.setMargin(teamScorePtsPane[i][2], new Insets(0, 0, 0, teamPane[i].getPrefWidth() / 10));									
			teamNameLabel[i].setGraphic(new ImageView(new Image("file:data/images/plank_teamname.jpg", teamPane[i].getPrefWidth() - padding, teamNamePane[i].getPrefHeight() - padding, false, false)));
			
			for (int j = 0; j < 2; j++) {
				teamScorePtsPane[i][j].setPrefWidth(4 * (teamScorePane[i].getPrefHeight() - padding) / 5);
				teamScoreNumberLabel[i][j].setGraphic(new ImageView(new Image("file:data/images/plank_score.jpg", teamScorePtsPane[i][j].getPrefWidth(), teamScorePane[i].getPrefHeight() - padding, false, false)));
			}
			teamScorePtsPane[i][2].setPrefWidth(teamPane[i].getPrefWidth() - (padding + 2 * teamScorePtsPane[i][0].getPrefWidth() + 2 * teamScorePane[i].getSpacing() + HBox.getMargin(teamScorePtsPane[i][2]).getLeft()));
			teamScoreNumberLabel[i][2].setGraphic(new ImageView(new Image("file:data/images/plank_teamname.jpg", teamScorePtsPane[i][2].getPrefWidth(), teamScorePane[i].getPrefHeight() - padding, false, false)));
			
			//teamPlayer
			for (int j = 0; j < numOfPlayers; j++) {
				teamPlayerEachPane[i][j].setPrefHeight((height - teamHeadPane[i].getPrefHeight()) / numOfPlayers);
				teamPlayerEachPane[i][j].setPadding(new Insets(padding / 2));
				teamPlayerEachPane[i][j].setSpacing(teamScorePane[i].getSpacing());
				
				for (int k = 0; k < 2; k++) {
					teamPlayerNamePane[i][j][k].setPrefWidth(teamScorePtsPane[i][0].getPrefWidth());
					teamPlayerNameLabel[i][j][k].setGraphic(new ImageView(new Image("file:data/images/plank_player.jpg", teamPlayerNamePane[i][j][k].getPrefWidth(), teamPlayerEachPane[i][j].getPrefHeight() - padding, false, false)));
					
				}
				
				teamPlayerTxtPane[i][j].setPrefWidth(teamPane[i].getPrefWidth() - (padding + 2 * teamPlayerEachPane[i][j].getSpacing() + 2 * teamPlayerNamePane[i][j][0].getPrefWidth()));
				teamPlayerTxtLabel[i][j].setGraphic(new ImageView(new Image("file:data/images/paper_player2.png", teamPlayerTxtPane[i][j].getPrefWidth(), teamPlayerEachPane[i][j].getPrefHeight() - padding, false, false)));
			}
		}
		
		
		resizeText();
	}
	
	public void resizeText() {		
		for (int i = 0; i < 2; i++) {
			teamNameText[i].setFont(createFontPlank(teamPane[i].getPrefWidth(), teamNamePane[i].getPrefHeight(), teamNameText[i].getText()));
			teamNameText[i].setEffect(createInnerShadow(teamNameText[i].getFont().getSize()));
			
			for (int j = 0; j < 3 ; j++) {
				teamScoreText[i][j].setFont(createFontPlank(teamScorePtsPane[i][j].getPrefWidth(), teamScorePane[i].getPrefHeight(), teamScoreText[i][j].getText()));
				teamScoreText[i][j].setEffect(createInnerShadow(teamScoreText[i][j].getFont().getSize()));
			}
			
			for (int j = 0; j < numOfPlayers; j++) {
				for (int k = 0; k < 2; k++) {
					teamPlayerNameText[i][j][k].setFont(createFontPlank(teamPlayerNamePane[i][j][k].getPrefWidth(), teamPlayerEachPane[i][j].getPrefHeight() - padding, teamPlayerNameText[i][j][k].getText()));
					teamPlayerNameText[i][j][k].setEffect(createInnerShadow(teamPlayerNameText[i][j][k].getFont().getSize()));
				}
			}
		}
		
		gameText[0].setPrefWidth(width / 2 - 2 * StackPane.getMargin(gameTxtPane).getLeft());
		gameText[0].setFont(createFontPaperHeading());
		gameText[2].setPrefWidth(gameText[0].getPrefWidth());
		gameText[2].setFont(createFontPaperBottom());
		gameText[1].setFont(createFontPaperGame(gameText[1].getText()));
		
		
	}
	
	public void setScore (int team, int score) {
		teamScoreText[team][2].setText("" + score);
		resizeText();
	}
	
	public static void initialize (String[] args) {
		if (numOfPlayers == 0) {
			throw new IllegalStateException("numOfPlayers has not been set");
		}
		launch(args);
	}
	
	public static MainFrame getInstance () {
		return instance;
	}
}
