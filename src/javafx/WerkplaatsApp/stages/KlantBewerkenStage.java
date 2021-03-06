package javafx.WerkplaatsApp.stages;

import java.util.Optional;

import javafx.WerkplaatsApp.domein.Bedrijf;
import javafx.WerkplaatsApp.domein.Klant;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class KlantBewerkenStage extends Stage{
	private Label labID, labID2, labv, laba, labadr, labpc, labwp, labtel, labmail;
	private TextField tfv, tfa, tfadr, tfpc, tfwp, tftel, tfmail;
	private Button annuleer, toevoegen;
	private Bedrijf hetBedrijf;
	private Klant deKlant;
	
	public KlantBewerkenStage(Stage stage, Klant k, Bedrijf b){
		deKlant = k;
		hetBedrijf = b;
		initOwner(stage);
		HBox top = new HBox();
		top.setPrefWidth(100);
		top.setPadding(new Insets (5,0,0,10));
		labID = new Label("Klantnummer");
		labID.setPrefWidth(90);
		labID2 = new Label("" + k.getKlantnummer());
		top.getChildren().addAll(labID, labID2);
		
		VBox labels = new VBox(13);
		labels.setPrefWidth(100);
		labels.setPadding(new Insets(10,0,0,10));
		labv = new Label("Voornaam");
		laba = new Label("Achternaam");
		labadr = new Label("Adres");
		labpc = new Label("Postcode");
		labwp = new Label("Woonplaats");
		labtel = new Label("Telefoon");
		labmail = new Label("E-mailadres");
		labels.getChildren().addAll(labv, laba, labadr, labpc, labwp, labtel, labmail);
		
		VBox texts = new VBox(5);
		texts.setPrefWidth(200);
		texts.setPadding(new Insets(5,10,0,0));
		tfv = new TextField(this.deKlant.getVoornaam());
		tfa = new TextField(deKlant.getAchternaam());
		tfadr = new TextField(deKlant.getAdresOUD());
		tfpc = new TextField(deKlant.getPostcode());
		tfwp = new TextField(deKlant.getWoonplaats());
		tftel = new TextField("" + this.deKlant.getTelefoonNummer());
		tfmail = new TextField(deKlant.getEmail());
		texts.getChildren().addAll(tfv, tfa, tfadr, tfpc, tfwp,tftel, tfmail);
		
		HBox center = new HBox();
		center.getChildren().addAll(labels,texts);
		
		HBox kp = new HBox(10);
		kp.setPadding(new Insets (10,10,0,0));
		kp.setAlignment(Pos.CENTER_RIGHT);
		kp.setPrefWidth(300);
		annuleer = new Button("Annuleer");
		annuleer.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent e){
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Waarschuwing!");
					alert.setHeaderText("Annuleren klantgegevens bewerken!");
					alert.setContentText("Weet u zeker dat u het bewerken van de klantgegevens wilt annuleren?\n\nDe wijzigingen zullen niet worden opgeslagen.");
					ButtonType annuleer = new ButtonType("Annuleer", ButtonData.CANCEL_CLOSE);
					ButtonType ok = new ButtonType("OK", ButtonData.APPLY);
					alert.getButtonTypes().setAll(annuleer,ok);
					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == annuleer){
						alert.close();
					}
					else{
						KlantBewerkenStage.this.close();
					}
				}
		});
		toevoegen = new Button("Wijzigen");
		toevoegen.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent e){
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Klantgegevens bevestigen");
					alert.setHeaderText("Controleer s.v.p. de gewijzigde gegevens:\n");
					alert.setContentText("\t\t"+ labID.getText() + "\t\t" + labID2.getText()
										+ "\n\t\t"+labv.getText() + "\t\t" + tfv.getText()
										+ "\n\t\t"+laba.getText() + "\t\t" + tfa.getText()
										+ "\n\t\t"+labadr.getText() + "\t\t\t" + tfadr.getText()
										+ "\n\t\t"+labpc.getText() + "\t\t\t" + tfpc.getText()
										+ "\n\t\t"+labwp.getText() + "\t\t" + tfwp.getText()
										+ "\n\t\t"+labtel.getText() + "\t\t\t" + tftel.getText()
										+ "\n\t\t"+labmail.getText() + "\t\t" + tfmail.getText()
										+ "\n\n\t\tZijn bovenstaande gegevens juist?");
					ButtonType annuleer = new ButtonType("Annuleer", ButtonData.CANCEL_CLOSE);
					ButtonType bevestigen = new ButtonType("Bevestigen", ButtonData.APPLY);
					alert.getButtonTypes().setAll(annuleer, bevestigen);
					
					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == annuleer){
						alert.close();
					}
					else{
						k.setVoornaam(tfv.getText());
						k.setAchternaam(tfa.getText());
						k.setAdresOUD(tfadr.getText());
						k.setPostcode(tfpc.getText());
						k.setWoonplaats(tfwp.getText());
						String s = tftel.getText();
						int i = Integer.parseInt(s);
						k.setTelefoonNummer(i);
						k.setEmail(tfmail.getText());
						
						alert.close();
						Alert success = new Alert(AlertType.INFORMATION);
						success.setTitle("Klantgegevens gewijzigd!");
						success.setHeaderText("Klantgegevens wijzigen geslaagd!");
						success.setContentText("De klantenbestand is succesvol bijgewerkt!"
								+ "\n\nWilt u terugkeren naar het hoofdmenu?");
						ButtonType toevoegen = new ButtonType("Meer gegevens wijzigen", ButtonData.NO );
						ButtonType hoofdmenu = new ButtonType("Terugkeren naar het hoofdmenu", ButtonData.APPLY);
						success.getButtonTypes().setAll(toevoegen,hoofdmenu);
						
						Optional<ButtonType> result2 = success.showAndWait();
						if (result2.get() == toevoegen){
							tfv.setText(""); tfa.setText(""); tfadr.setText(""); tfpc.setText(""); tfwp.setText(""); tftel.setText(""); tfmail.setText("");
							success.close();
							KlantBewerkenStage.this.close();
							
						}
						else{
							KlantBewerkenStage.this.close();
							stage.close();
						}	
					}
				}
		});
		kp.getChildren().addAll(annuleer, toevoegen);
		
		VBox totaal = new VBox();
		totaal.getChildren().addAll(top, center, kp);
		
		Scene scene = new Scene(totaal, 300, 300);
		setTitle("Klantgegevens bewerken");
		setResizable(false);
		setScene(scene);	
	}
	
	public static void main (String[] args){
		Application.launch(args);
	}
}
