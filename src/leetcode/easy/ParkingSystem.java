package leetcode.easy;

/**
 * https://leetcode.com/problems/design-parking-system/submissions/
 */
public class ParkingSystem {

    private int big;
    private int medium;
    private int small;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        if(carType==1 && big>0) {
            big--;
            return true;
        } else if(carType==2 && medium>0) {
            medium--;
            return true;
        } else if(carType==3 && small>0) {
            small--;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        ParkingSystem obj = new ParkingSystem(1, 1, 0);
        boolean param_1 = obj.addCar(1);

    }

}
