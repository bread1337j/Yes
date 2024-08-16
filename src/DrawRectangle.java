import javax.swing.*;
import java.awt.*;

public class DrawRectangle extends JComponent {
    int x;
    int y;
    int sizex;
    int sizey;
    Color colorvar = Color.BLACK;
    public void setDims(int a, int b, int c, int d){
        x = a;
        y = b;
        sizex = c;
        sizey = d;
    }
    public void setColor(int clr){
        if(clr==1){
            colorvar = Color.RED;
        } else if (clr==2) {
            colorvar = Color.BLUE;
        }else if (clr==3) {
            colorvar = Color.GREEN;
        }else if (clr==4) {
            colorvar = Color.ORANGE;
        }
    }
    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(colorvar);
        g2.fillRect(x, y, sizex, sizey);
    }

}
