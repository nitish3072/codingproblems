package scaler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static scaler.GCD.gcd;

public class DeleteoneForMaxGCD {

    public int solve(ArrayList<Integer> A) {
        int[] prefix = new int[A.size()];
        int[] suffix = new int[A.size()];
        prefix[0] = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            prefix[i] = gcd(prefix[i - 1], A.get(i));
        }
        suffix[A.size() - 1] = A.get(A.size() - 1);
        for (int i = A.size() - 2; i >= 0; i--) {
            suffix[i] = gcd(suffix[i + 1], A.get(i));
        }
        int ans = Math.max(suffix[1], prefix[A.size() - 2]);
        for (int i = 1; i < A.size()-1; i++) {
            ans = Math.max(ans, gcd(prefix[i-1], suffix[i+1]));
        }
        return ans;
    }

    public static void main(String[] args) {
        DeleteoneForMaxGCD deleteoneForMaxGCD = new DeleteoneForMaxGCD();
        List<Integer> list = Arrays.asList(208610688,48106344,135402124,34168992,95013776,35218040,117231114,172905590,66652014,45970782,222323244,203402914,35292972,159829956,154584716,107190226,71335264,42786172,203327982,3484338,28062034,64179258,210993,94938844,155858560,123562868,223447224,116744056,55711942,88082566,45671054,16072914,165299992,136601036,44659472,219063702,202953322,188341582,116931386,127759060,131318330,49867246,92278758,40875406,218314382,135889182,6893744,97111872,56236466,96662280,52340002,195010530,44884268,167435554,155746162,201679478,54138370,103481092,25814074,186093622,208498290,31883566,122101694,128058788,133566290,55749408,178675354,186056156,155071774,35180574,82050540,7755462,29448276,100333948,130156884,67850926,44509608,17084496,216703344,197295956,174479162,18058612,51290954,173917172,51815478,218426780,184032992,148140564,108951128);
        System.out.println(deleteoneForMaxGCD.solve(new ArrayList<>(list)));
    }
}
