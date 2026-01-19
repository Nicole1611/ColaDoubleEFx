package com.mycompany.coladoubleefx.model;

import java.util.Deque;
import java.util.ArrayDeque;

public class TaskManager {
 
    private Deque<String> tareas;

    public TaskManager() {
        tareas = new ArrayDeque<>();
    }

    // --- CONSULTAS ---
    public boolean isEmpty() {
        return tareas.isEmpty();
    }

    public String peekInicio() {
        if (tareas.isEmpty())
            return "NO HAY TAREAS.";
        return tareas.peekFirst();
    }

    public String peekFinal() {
        if (tareas.isEmpty())
            return "NO HAY TAREAS.";
        return tareas.peekLast();
    }

    // --- MÉTODOS PARA AGREGAR ---
    public void agregarUrgente(String tarea) {
        tareas.addFirst(tarea);
    }

    public void agregarNormal(String tarea) {
        tareas.addLast(tarea);
    }

    // --- MÉTODOS PARA ELIMINAR ---
    public String completarPorInicio() {
        if (tareas.isEmpty()) 
            return "NO HAY TAREA POR ELIMINAR.";
        return tareas.removeFirst();
    }

    public String completarPorFinal() {
        if (tareas.isEmpty()) 
            return "NO HAY TAREA POR ELIMINAR.";
        return tareas.removeLast();
    }

    // --- MOSTRAR ---
    public void mostrar() {
        if (tareas.isEmpty()) {
            System.out.println("NO HAY TAREAS.");
            return;
        }
        for (String t : tareas) {
            System.out.print("[" + t + "] ");
        }
        System.out.println();
    }
    
    public Deque<String> getTareas() {
        return tareas;
    }

}
