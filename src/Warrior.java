import java.util.Random;

import static java.lang.Math.sqrt;

public class Warrior {
    int hp;
    int team;
    int damage;
    int range;
    double speed;
    double locationx;
    double locationy;
    int aitype;
    //AI types
    //1 = tries to stay at range away as much as possible
    //2 = will be running headfirst at the enemy and minimizing the range
    //3 = will stay at range+1 away
    int color = 0;
    //COLORS
    //0 = black
    //1 = red
    //2 = blue
    //3 = green
    //4 = orange
    Warrior target; // bruh
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    public void setAI(int num){
        aitype = num;
    }
    public void setHP(int num){
        hp = num;
    }
    public void setTeam(int num){
        team = num;
    }
    public void setDamage(int num){
        damage = num;
    }
    public void setSpeed(double num){
        speed = num;
    }
    public void setRange(int num){
        range = num;
    }
    public void setLocation(int x, int y){
        locationx = x;
        locationy = y;
    }
    public void setColor(int num){
        color = num;
    }
    public void setStats(int hp, int dmg, int t, int range, double spd){
        setHP(hp);
        setDamage(dmg);
        setTeam(t);
        setRange(range);
        setSpeed(spd);
    }

    public void DecreaseHP(int num){
        hp -= num;
    }
    public void printStats(){
        System.out.print("Hp: ");
        System.out.println(hp);
        System.out.print("DMG: ");
        System.out.println(damage);
        System.out.print("Team: ");
        System.out.println(team);

    }
    int ReturnX(){
        return((int)Math.round(locationx));
    }
    int ReturnY(){
        return((int)Math.round(locationy));
    }
    int ReturnClr(){
        return(color);
    }
    public void attack(Warrior target){
        target.DecreaseHP(damage);
    }

    public void checkAndAttack(Warrior target){
        if(target.locationx * target.locationx + target.locationy * target.locationy <= range) {
            attack(target);
        }
    }

    public void SetTarget(Warrior bruh){
        target = bruh;
    }
    Warrior ReturnTarget(){
        return(target);
    }
    Random rand = new Random();
    public void RandomMovement(int Range){
        locationx += rand.nextInt(Range);
        locationy += rand.nextInt(Range);
    }

    public void MoveWithTarget(Warrior target){
        if(aitype == 1){
            double dist = sqrt(Math.pow((locationx-target.locationx), 2) + Math.pow((locationy-target.locationy), 2));
            double vectorx = (target.locationx - locationx) / dist;
            double vectory = (target.locationy - locationy) / dist;
            //System.out.println(dist);
            if(dist<range) {

                //System.out.println(vectorx);
                //System.out.println(vectory);
                //System.out.println(locationx);
                //System.out.println(locationy);
                locationx -= vectorx;
                locationy -= vectory;
                //System.out.println(locationx);
                //System.out.println(locationy);

            } else if (dist<range+1) {

            } else {
                locationx += vectorx*speed;
                locationy += vectory*speed;
            }

        } else if (aitype == 2) {

        } else if (aitype == 3) {

        } else if (aitype == 4) {
            //int upperbound = (int)(speed*10) * 2;
            //int lowerbound = (int)(speed*10) * -1;
            int upperbound = 25;
            int lowerbound = -25;
            locationx += getRandomNumber(lowerbound, upperbound);
            locationy += getRandomNumber(lowerbound, upperbound);
        }
    }

}
