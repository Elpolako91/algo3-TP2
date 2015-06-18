package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import fiuba.algo3.tp2.ModeloObservable;
import view.VistaMenuPrincipal;

public class ControladorMouse extends MouseAdapter {

    ModeloObservable modelo;

    VistaMenuPrincipal vista;

    public ControladorMouse(ModeloObservable modelo, VistaMenuPrincipal vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void mousePressed(MouseEvent mouseEvent) {

        // Ojo al piojo.
        // El manejo de las coordenadas del mouse debe ser encapsulado por la clase Posicion
        // modelo.inicializarModeloDato(new Posicion(mouseEvent.getX(), mouseEvent.getY()));

        modelo.inicializarModeloDato(vista.posicion);
    }
}
