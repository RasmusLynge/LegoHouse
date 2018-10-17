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
public class HouseOrder {

    int idOrder, user_Id;
    boolean isShipped = false;

    int length, width, height;
    boolean windowDoor;

    public HouseOrder(int idOrder, int length, int width, int height, boolean windowDoor, boolean isShipped) {
        this.idOrder = idOrder;
        this.length = length;
        this.width = width;
        this.height = height;
        this.windowDoor = windowDoor;
        this.isShipped = isShipped;
    }

    
    public int getIdOrder() {
        return idOrder;
    }

    public boolean isIsShipped() {
        return isShipped;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public void setIsShipped(boolean isShipped) {
        this.isShipped = isShipped;
    }

    
// Må jeg ændre til String her?
    public int getLenght() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isWindowDoor() {
        return windowDoor;
    }

    public void setLenght(int lenght) {
        this.length = lenght;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWindowDoor(boolean windowDoor) {
        this.windowDoor = windowDoor;
    }
    
    
    public String toString() {
        return "Order Nr: " + getIdOrder() + " Shipped: " + (isShipped ? "yes" : "no");
        
    }
    

}
