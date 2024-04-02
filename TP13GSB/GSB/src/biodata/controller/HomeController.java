
package biodata.controller;

import biodata.connexion.Connect;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Callback;


import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author Balbali
 * @version  1.5
 * @since 1.0
 */
public class HomeController implements Initializable {

    @FXML
    private TextField txtnom;
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtAdresse;
    @FXML
    private DatePicker txtDOB;
    @FXML
    private Button btnSave;

    @FXML
    Label lblStatus;

    @FXML
    TableView tblData;


    /**
     * Initializes the controller class.
     */
    PreparedStatement preparedStatement;
    Connection connection;

    public HomeController() {
        connection = (Connection) Connect.connect();
    }

    /**
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        /*txtGender.getItems().addAll("M.", "Mme", "Mlle");
        txtGender.getSelectionModel().select("M.");
        fetColumnList();
        fetRowList();*/

    }

    /**
     *
     * @param event
     */
    @FXML
    private void HandleEvents(MouseEvent event) {
        //check if not empty
        if (txtnom.getText().isEmpty() || txtAdresse.getText().isEmpty() || txtDOB.getValue().equals(null)) {
            lblStatus.setTextFill(Color.TOMATO);
            lblStatus.setText("Entrer toutes les informations");
        } else {
            saveData();
        }

    }

    /**
     * supprimer le contenu des champs
     */
    private void clearFields() {
        txtId.clear();
        txtnom.clear();
        txtAdresse.clear();
    }

    /**
     *
     * @return une chaîne de contenu des champs
     */
    private String saveData() {

        try {
            String st = "INSERT INTO tablebiodata ( nom, adresse, date_de_naissance) VALUES (?,?,?)";
            preparedStatement = (PreparedStatement) connection.prepareStatement(st);
            preparedStatement.setString(2, txtnom.getText());
           // preparedStatement.setString(2, txtLastname.getText());
            preparedStatement.setString(3, txtAdresse.getText());
          //  preparedStatement.setString(4, txtGender.getValue().toString());
            preparedStatement.setString(4, txtDOB.getValue().toString());

            preparedStatement.executeUpdate();
            lblStatus.setTextFill(Color.GREEN);
            lblStatus.setText("Ajouté avec succès");

            fetRowList();
            //clear fields
            clearFields();
            return "Succès";

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            lblStatus.setTextFill(Color.TOMATO);
            lblStatus.setText(ex.getMessage());
            return "Exception";
        }
    }

    /**
     *
     */
    private ObservableList<ObservableList> data;
    String SQL = "SELECT * from tablebiodata";

    //only fetch columns

    /**
     * récupère les colonnes
     */
    private void fetColumnList() {

        try {
            ResultSet rs = connection.createStatement().executeQuery(SQL);

            //SQL FOR SELECTING ALL OF CUSTOMER
            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                //We are using non property style for making dynamic table
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1).toUpperCase());
                col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                tblData.getColumns().removeAll(col);
                tblData.getColumns().addAll(col);

                System.out.println("Colonne [" + i + "] ");

            }

        } catch (Exception e) {
            System.out.println("Erreur " + e.getMessage());

        }
    }



    /**
     * récupère les lignes et les données de la liste
     */
    private void fetRowList() {
        data = FXCollections.observableArrayList();
        ResultSet rs;
        try {
            rs = connection.createStatement().executeQuery(SQL);

            while (rs.next()) {
                //Iterate Row
                ObservableList row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                System.out.println("Ligne [1] ajoutée " + row);
                data.add(row);

            }

            tblData.setItems(data);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
