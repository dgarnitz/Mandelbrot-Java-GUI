package delegate;

import model.MandelbrotCalculator;
import model.Model;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.*;

public class MandelbrotPanel extends JPanel {

    public Boolean draw = false;
    public int x;
    public int y;
    public int width;
    public int height;


    @Override
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        renderMandelbrot(g);

        if(draw){       //can draw line or box depending on pan or zoom
            g.setColor(Color.GREEN);
            g.drawRect(x, y, width, height);
            System.out.println("Checking mouse box");
        }

    }

	public void renderMandelbrot(Graphics g){
        System.out.println("rendering mandelbrot");

        int x = Model.defaultX;
        int y = Model.defaultY;

        int[][] MC_data = Model.createMB();
        for(int i=0; i<y; i++){
            for(int j=0; j<x; j++){
                if(MC_data[i][j] >= Model.MAX_ITERATIONS) {
                    g.drawLine(j, i, j, i);
                    //System.out.println("creating MB with max IT of: " + Model.MAX_ITERATIONS); --> this outputted the correct values but it still didnt re-render

                    //NEED TO FIX rendering error that occurs when you lower max iterations then try to go back up
                }
            }
        }
	}
}
