package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneController {

    private PhoneModel pm = new PhoneModel(this);
    @FXML
    private Button clearButton;

    @FXML
    private ImageView imvPhoneImage1;

    @FXML
    private ImageView imvPhoneImage2;

    @FXML
    private ComboBox<String> namesCB;

    @FXML
    private TextField txtNumberDisplay;
    private Image logo;
    private Image onCall;
    private Image offCall;
    private HashMap<String, String> contacts = new HashMap<>();

    @FXML
    public void initialize(){
        logo = new Image("/phone.png");
        onCall = new Image("/onCall.png");
        offCall = new Image("/offCall.png");

        imvPhoneImage1.setImage(logo);
        imvPhoneImage2.setImage(offCall);

        contacts.put("Simon", "0111541567");
        contacts.put("Dominoes", "0111545706");
        contacts.put("Sarah", "01435644552");
        contacts.put("Taxi", "01115660330");

        ObservableList<String> contactList= FXCollections.observableArrayList(getContactNames());
        namesCB.setItems(contactList);
    }

    public ArrayList<String> getContactNames() {
        ArrayList<String> list = new ArrayList<>();
        list.addAll(contacts.keySet());
        return list;
    }

    public void setOffCall() {
        imvPhoneImage2.setImage(offCall);
    }

    public void setOnCall() {
        imvPhoneImage2.setImage(onCall);
    }

    @FXML
    void onButtonPressed(ActionEvent event) {
        Button btn = (Button)(event.getSource());
        pm.addDigit(btn.getText());
        updateNumberDisplay();
    }

    @FXML
    void onClearButtonPressed(ActionEvent event) {
        txtNumberDisplay.setText("");
        pm.resetNumber();
    }

    @FXML
    void onMakeCall(ActionEvent event) {
        pm.makeCall(pm.getNumber());
    }

    @FXML
    void onNameSelectionMade(ActionEvent event) {
        String selectedName = namesCB.getSelectionModel().getSelectedItem();
        String phoneNumber = contacts.get(selectedName);
        pm.setNumber(phoneNumber);
        txtNumberDisplay.setText(phoneNumber);
    }

    private void updateNumberDisplay() {
        txtNumberDisplay.setText(pm.getNumber());
    }
}
