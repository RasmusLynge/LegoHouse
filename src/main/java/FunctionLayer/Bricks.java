/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author Rasmu
 */
public class Bricks {
    
    private int large;
    private int medium;
    private int small;
    private boolean windowDoor;
    
    public Bricks() {
        this.large = 0;
        this.medium = 0;
        this.small = 0;
        this.windowDoor = false;
    }

    public int getFour() {
        return large;   
    }

    public int getTwo() {
        return medium;
    }

    public int getOne() {
        return small;
    }

    public boolean windowDoor() {
        return windowDoor;
    }
    

    public void addBricks(int four, int two, int one) {
        this.large += four;
        this.medium += two;
        this.small += one;    
        
    }

    /*
        En dør fjerner ni 4x2 og udkifter med seks 2x2 og et vuindue udskifter seks 4x2 med 4 2x2.
     */
    public void addWindowDoor() {
        this.large -= 15;
        this.medium += 10;
        this.windowDoor = true;
    }
    
}
