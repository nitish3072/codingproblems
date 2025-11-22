package scaler.dp4;

public class LetsParty {

    public int solve(int A) {
        int sum = 1;
        for(int j=1;j<A;j++){
            sum += j;
        }
        return sum;
    }

    public static void main(String[] args) {
        LetsParty s = new LetsParty();
        System.out.println(s.solve(5));
    }

}
