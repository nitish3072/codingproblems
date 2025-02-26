package scaler;

public class ExcelColumnNumber {

    public int titleToNumber(String A) {
        int result = 1;
        for (int i = 0; i < A.length()-1; i++) {
            result = result * 26 * (A.charAt(i) - 64);
        }
        result = (result == 1 ? 0 : result) + (A.charAt(A.length()-1) - 64);
        return result;
    }

    public static void main(String[] args) {
        ExcelColumnNumber excelColumnNumber = new ExcelColumnNumber();
        excelColumnNumber.titleToNumber("A");
    }
}
