package leetcode.medium;

/**
 * https://leetcode.com/problems/angle-between-hands-of-a-clock/submissions/
 */
public class AngleBetweenHandsClock {

    public double angleClock(int hour, int minutes) {
        double angleHour = ((double)(hour==12 ? 0 : hour) * 360.0 / 12.0 + (double) minutes / 2.0);
        double angleMinutes = (minutes * 6.0);
        return Math.abs(angleHour - angleMinutes) > 180 ? 360 - Math.abs(angleHour - angleMinutes) : Math.abs(angleHour - angleMinutes);
    }

    public static void main(String[] args) {
        AngleBetweenHandsClock angleBetweenHandsClock = new AngleBetweenHandsClock();
        System.out.println(angleBetweenHandsClock.angleClock(1, 57));
    }
}
