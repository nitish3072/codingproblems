package leetcode.medium;

import java.util.Arrays;

public class RotatingtheBox {

    public char[][] rotateTheBox(char[][] box) {
        char[][] rotatedBox = new char[box[0].length][box.length];
        for (int i = 0; i < box.length; i++) {
            for (int j = box[i].length - 1; j >= 0; j--) {
                rotatedBox[j][box.length-i-1] = '.';
            }
        }
        for (int i = 0; i < box.length; i++) {
            int ballsUpto = box[i].length - 1;
            for (int j = box[i].length - 1; j >= 0; j--) {
                if (box[i][j] == '*') {
                    ballsUpto = j - 1;
                    rotatedBox[j][box.length - i - 1] = '*';
                } else if (box[i][j] == '.') {
                    rotatedBox[j][box.length - i - 1] = '.';
                } else {
                    rotatedBox[ballsUpto--][box.length - i - 1] = '#';
                }
            }
        }
        return rotatedBox;
    }

    public static void main(String[] args) {
        RotatingtheBox rotatingtheBox = new RotatingtheBox();
        char[][] box = {{'#','.','*','.'}, {'#','#','*','.'}};
        System.out.println(Arrays.deepToString(rotatingtheBox.rotateTheBox(box)));
    }

}
