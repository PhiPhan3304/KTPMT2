/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.dht.fxenglishapp;

import com.dht.pojo.Category;
import com.dht.pojo.Question;
import com.dht.services.CategoryServices;
import com.dht.services.QuestionServices;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class FXQuestionsController implements Initializable {

    @FXML ComboBox<Category> categories;
    @FXML TableView <Question> questions;
    @FXML TextField txtSearch;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CategoryServices s = new CategoryServices();

        try {
            // TODO
            this.categories.setItems(FXCollections.observableList(s.getCates()));
        } catch (SQLException ex) {
            Logger.getLogger(FXQuestionsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        loadCol();
        loadData(null);
        this.txtSearch.textProperty().addListener(e -> {
            loadData(this.txtSearch.getText());
        });
        
        
    }
    public void loadData(String kw){
        QuestionServices s = new QuestionServices();
        
        try {
            List<Question> q = s.getQuestions(0,kw);
            questions.setItems(FXCollections.observableList(q));
        } catch (SQLException ex) {
            Logger.getLogger(FXQuestionsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void loadCol(){
     TableColumn colContent = new TableColumn(" Noi dung cau hoi ");
     colContent.setPrefWidth(300);
     colContent.setCellValueFactory(new PropertyValueFactory("content"));
     
     TableColumn colCats = new TableColumn(" Danh muc cau hoi ");
     colContent.setPrefWidth(150);
     colContent.setCellValueFactory(new PropertyValueFactory("categoryId"));
     
     this.questions.getColumns().addAll(colContent,colCats);
}

}
