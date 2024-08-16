
import javax.swing.*;
import java.awt.*;
import javax.swing.JComponent;

public class MainWindow {
    JFrame MakeScreen(){
        JFrame fr = new JFrame();
        fr.setSize(600, 600);
        fr.setDefaultCloseOperation(3);
    fr.setVisible(true);

    return(fr);
    }
    JPanel MakePanel(JFrame fr){
        JPanel pn = new JPanel();
        fr.add(pn);
        return(pn);
    }
    public void ClearScreen(JFrame fr, JPanel pn) {
        fr.getContentPane().removeAll();
        pn.removeAll();
    }

    public void AddRect(JFrame fr, JPanel pn, DrawRectangle rect){

        fr.getContentPane().add(rect);
       // pn.add(rect);
        //pn.paintComponents(rect.getGraphics());
        SwingUtilities.updateComponentTreeUI(fr);
        //rect.updateUI();
        // pn.updateUI();
       // fr.getContentPane().update(rect.getGraphics());
    }
    public void UpdateScreen(JFrame fr){
        SwingUtilities.updateComponentTreeUI(fr);
        fr.getContentPane().repaint();
    }

}
