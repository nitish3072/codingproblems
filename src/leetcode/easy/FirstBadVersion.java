package leetcode.easy;

public class FirstBadVersion {

    public int firstBadVersion(int n) {
        int startIndex = 1;
        int endIndex = n;
        int center = 1;
        while (startIndex<endIndex) {
            center = (startIndex + endIndex)/2;
            if(isBadVersion(center)) {
                endIndex = (startIndex + endIndex)/2;
            } else {
                startIndex = center + 1;
            }
        }
        return center;
    }

    public Boolean isBadVersion(int n) {
        return true;
    }

    public static void main(String[] args) {
        FirstBadVersion firstBadVersion = new FirstBadVersion();
        int badVersion = firstBadVersion.firstBadVersion(2);
        System.out.println(badVersion);
    }

}
