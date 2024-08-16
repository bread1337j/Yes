import javax.swing.*;
import java.awt.desktop.ScreenSleepEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Main {
    int ID = 0;
    Warrior[] warriors = new Warrior[100];

    Warrior MakeWarrior(int hp, int dmg, int t, int range, double spd, int x, int y, int ai, int clr){
        //AI types
        //1 = tries to stay at range away as much as possible
        //2 = will be running headfirst at the enemy and minimizing the range
        //3 = will stay at range+1 away
        //4 = will move randomly
        //COLORS
        //0 = black
        //1 = red
        //2 = blue
        //3 = green
        //4 = orange
        //5 = invisible
        ID += 1;
        warriors[ID] = new Warrior();
        warriors[ID].setStats(hp, dmg,t,range,spd);
        warriors[ID].setLocation(x,y);
        warriors[ID].setAI(ai);
        warriors[ID].setColor(clr);

        return(warriors[ID]);

    }

    public void DrawWarriors(JFrame fr, JPanel pn, MainWindow screen){

        for (Warrior w : warriors) {
            if(w!=null) {
                try {
                    if (w.color!=5) {
                        DrawRectangle rect = new DrawRectangle();
                        rect.setDims(w.ReturnX(), w.ReturnY(), 5, 5);
                        rect.setColor(w.ReturnClr());
                        screen.AddRect(fr, pn, rect);
                    }
                }catch(Error e){}
            }
        }
    }
    public void Tick(JFrame fr, JPanel pn, MainWindow screen){


        //screen.UpdateScreen(fr);
        //fr.update(fr.getGraphics());

        for (Warrior w : warriors) {
            if(w!=null) {
                try {
                    if (w.target==null) {
                        for (Warrior b : warriors){
                            if (b!=null) {
                                if (b.team != w.team) {
                                    w.SetTarget(b);
                                }
                            }
                        }
                    }
                    w.MoveWithTarget(w.ReturnTarget());
                }catch(Error e){}
            }
        }



    }

    public static void main(String[] args) throws InterruptedException {
        Main lol = new Main();
        Random rand = new Random();
        //Warrior test = lol.MakeWarrior(100,10,1,10,0.1,101,299,1,0);
        //Warrior test2 = lol.MakeWarrior(100,10,1,10,0.1,104,399,1,2);
        for (int i = 0; i < 50; i++) {
            lol.MakeWarrior(100,10,1,10,4,rand.nextInt(600),rand.nextInt(600),1,rand.nextInt(4));
        }


        //Warrior test = new Warrior();
        //test.setStats(100, 10, 1, 10, 0.1);
        //test.setLocation(0,0);
        //test.DecreaseHP(5);
        //test.printStats();
        //test.printStats();

        Warrior testbutEVIL = lol.MakeWarrior(200,20,0,15,0.1,275,275,4,5);
        //testbutEVIL.setStats(100, 20, 0, 15, 0.1);
        //testbutEVIL.setLocation(15, 0);
        //testbutEVIL.checkAndAttack(test);
        //test.checkAndAttack(testbutEVIL);

        //test.printStats();
        //testbutEVIL.printStats();


        MainWindow screen = new MainWindow();
        JFrame fr = screen.MakeScreen();
        JPanel pn = screen.MakePanel(fr);
        screen.ClearScreen(fr, pn);
        DrawRectangle rect = new DrawRectangle();
        //rect.setDims(100,100,200,100);
        screen.AddRect(fr, pn, rect);
        //screen.ClearScreen(fr);

        int i = 0;
        //lol.DrawWarriors(fr, pn, screen);
        while(true){
            lol.DrawWarriors(fr, pn, screen);
            Thread.sleep(25);
            lol.Tick(fr, pn, screen);

        }
    }

}