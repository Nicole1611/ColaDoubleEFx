
package com.mycompany.coladoubleefx.view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.Collections;
import java.util.List;

public class CanvaColaDouble extends Canvas {

    private List<String> values = Collections.emptyList();

    private final double margin = 24;
    private final double nodeW = 140;
    private final double nodeH = 48;
    private final double spacing = 36;
    private final double baseY = 110;

    public CanvaColaDouble() {
        setWidth(900);
        setHeight(260);
    }

    public void setValues(List<String> values) {
        this.values = values == null ? Collections.emptyList() : values;
    }

    public void render() {
        int n = values.size();
        double neededW = (n == 0)
                ? 900
                : margin * 2 + n * nodeW + (n - 1) * spacing + 180;

        setWidth(Math.max(900, neededW));
        setHeight(260);

        GraphicsContext g = getGraphicsContext2D();
        g.setFill(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setFill(Color.BLACK);
        g.setFont(Font.font(16));
        g.fillText("Cola Doble de Tareas", margin, 28);

        g.setFill(Color.GRAY);
        g.setFont(Font.font(12));
        g.fillText("Inicio ⇄ Final", margin, 48);

        if (n == 0) {
            g.setFont(Font.font(14));
            g.fillText("No hay tareas registradas.", margin, baseY);
            return;
        }

        drawFrente(g);

        double x = margin;
        for (int i = 0; i < n; i++) {
            drawNode(g, x, baseY, values.get(i));

            if (i < n - 1) {
                double midY = baseY + nodeH / 2;
                double x2 = x + nodeW + spacing;

                g.setStroke(Color.DARKGRAY);
                g.setLineWidth(2);
                g.strokeLine(x + nodeW, midY, x2, midY);
                arrowHead(g, x + nodeW, midY, x2, midY);
            }

            x += nodeW + spacing;
        }
    }

    private void drawFrente(GraphicsContext g) {
        double fx = margin;
        double fy = baseY - 45;

        g.setFill(Color.DARKGRAY);
        g.setFont(Font.font(12));
        g.fillText("Inicio", fx, fy);

        g.setStroke(Color.DARKGRAY);
        g.setLineWidth(2);
        g.strokeLine(fx + 20, fy + 6, fx + 20, baseY - 8);
        arrowHead(g, fx + 20, baseY - 8, fx + 20, baseY);
    }

    private void drawNode(GraphicsContext g, double x, double y, String text) {
        g.setStroke(Color.BLACK);
        g.setLineWidth(2);
        g.strokeRoundRect(x, y, nodeW, nodeH, 16, 16);

        g.setFill(Color.BLACK);
        g.setFont(Font.font(13));
        g.fillText(text, x + 12, y + 30);
    }

    private void arrowHead(GraphicsContext g, double x1, double y1, double x2, double y2) {
        double angle = Math.atan2(y2 - y1, x2 - x1);
        double len = 10;

        g.strokeLine(
            x2, y2,
            x2 - len * Math.cos(angle - Math.PI / 8),
            y2 - len * Math.sin(angle - Math.PI / 8)
        );
        g.strokeLine(
            x2, y2,
            x2 - len * Math.cos(angle + Math.PI / 8),
            y2 - len * Math.sin(angle + Math.PI / 8)
        );
    }
}

