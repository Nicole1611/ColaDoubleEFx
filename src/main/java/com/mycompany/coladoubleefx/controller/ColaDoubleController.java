/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.coladoubleefx.controller;

import com.mycompany.coladoubleefx.model.TaskManager;
import com.mycompany.coladoubleefx.view.CanvaColaDouble;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;
import java.util.List;

public class ColaDoubleController {

    @FXML private TextField txtTarea;
    @FXML private Label lblEstado;
    @FXML private StackPane canvasPane;

    private TaskManager manager;
    private CanvaColaDouble canvas;

    @FXML
    public void initialize() {
        manager = new TaskManager();
        canvas = new CanvaColaDouble();
        canvasPane.getChildren().add(canvas);
        refreshCanvas();
    }

    @FXML
    private void agregarUrgente() {
        String tarea = txtTarea.getText();
        if (tarea.isEmpty()) {
            lblEstado.setText("Ingrese una tarea");
            return;
        }
        manager.agregarUrgente(tarea);
        lblEstado.setText("Tarea urgente agregada");
        txtTarea.clear();
        refreshCanvas();
    }

    @FXML
    private void agregarNormal() {
        String tarea = txtTarea.getText();
        if (tarea.isEmpty()) {
            lblEstado.setText("Ingrese una tarea");
            return;
        }
        manager.agregarNormal(tarea);
        lblEstado.setText("Tarea normal agregada");
        txtTarea.clear();
        refreshCanvas();
    }

    @FXML
    private void eliminarInicio() {
        lblEstado.setText(manager.completarPorInicio());
        refreshCanvas();
    }

    @FXML
    private void eliminarFinal() {
        lblEstado.setText(manager.completarPorFinal());
        refreshCanvas();
    }

    @FXML
    private void verInicio() {
        lblEstado.setText("Inicio: " + manager.peekInicio());
    }

    @FXML
    private void verFinal() {
        lblEstado.setText("Final: " + manager.peekFinal());
    }

    @FXML
    private void mostrarIsEmpty() {
        lblEstado.setText(manager.isEmpty() ? "Cola vacía" : "Cola con tareas");
    }

    private void refreshCanvas() {
        canvas.setValues(obtenerTareas());
        canvas.render();
    }

    private List<String> obtenerTareas() {
        List<String> lista = new ArrayList<>();
        manager.mostrar(); // lógica interna
        manager.getTareas().forEach(lista::add);
        return lista;
    }
}
