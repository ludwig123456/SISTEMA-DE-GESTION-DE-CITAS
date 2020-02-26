/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.fisi.proyectoclinica.vistas.factory;

import com.edu.fisi.proyectoclinica.vistas.LogMedicoController;
import com.edu.fisi.proyectoclinica.vistas.MainAdminController;
import com.edu.fisi.proyectoclinica.vistas.MainMedicoController;
import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Soporte-Bolsista
 */
public class FactoryMedicoController extends FactoryVentanas {
    
    @Override
    public Ventana MetodoFabrica() {
  
        try {
            //FXMLLoader f = load(Objects.requireNonNull(getClass().getClassLoader().getResource("com/edu/fisi/proyectoclinica/vistas/MainAdmin.fxml")));
            String titulo = "Clinica Aquiles Matto - Medico";
            FXMLLoader fxmlLoader = new FXMLLoader(MainAdminController.class.getResource("LogMedico.fxml"));
            Parent root = fxmlLoader.load();
            //MainAdminController .instanciar().getEscritorio().getChildren().add(((Ventana) fxmlLoader.getController()));
            LogMedicoController main= (LogMedicoController) fxmlLoader.getController();
                        
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            root.setOnMousePressed(evento -> {
                main.setxOffset(evento.getSceneX());
                main.setyOffset(evento.getSceneY());
            });
            root.setOnMouseDragged(evento -> {
                stage.setX(evento.getScreenX() - main.getxOffset());
                stage.setY(evento.getScreenY() - main.getyOffset());
            });
            stage.setTitle(titulo);
            stage.setScene(new Scene(root));
            stage.show();
            return main;
        } catch (IOException ex) {
            Logger.getLogger(FactoryMedicoController.class.getName()).log(Level.SEVERE, null, ex);
        }
      return null;
    }
    
}