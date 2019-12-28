package A01_Array;

import java.io.*;

public class SparaseArray {
    public static void main(String[] args) throws IOException {

        // 创建二维数组，随机棋子
        int[][] array = new int[11][11];
        array[1][2] = 1;
        array[2][3] = 2;
        array[3][4] = 1;

        // 转换为稀疏数组
        // 1.1 获取稀疏数组的总行数
        int sum = 0;
        for (int[] arr : array) {
            for (int i : arr) {
                if (i != 0) sum++;
            }
        }
        // 1.2 创建稀疏数组
        int[][] my = new int[sum + 1][3];
        // 1.3 确定第零行的数据
        my[0][0] = array.length;
        my[0][1] = array[0].length;
        my[0][2] = sum;
        int count = 1;
        // 1.3 遍历原数组获取数据
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] != 0) {
                    my[count][0] = i;
                    my[count][1] = j;
                    my[count][2] = array[i][j];
                    count++;
                }
            }
        }

        // 遍历稀疏数组
        /*for (int[] ints : my) {
            for (int anInt : ints) {
                System.out.print(anInt + "  ");
            }
            System.out.println();
        }*/

        // 序列化
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("1.txt")));
        for (int[] ints : my) {
            for (int anInt : ints) {
                bw.write(anInt + " ");
            }
            bw.newLine();
        }
        bw.close();

        // 反序列化

        BufferedReader br = new BufferedReader(new FileReader("1.txt"));
        String len;
        int countRow = 0;
        while ((len = br.readLine()) != null) {
            countRow++;
        }
        bw.close();

        int[][] t = new int[countRow][3];
        BufferedReader br2 = new BufferedReader(new FileReader("1.txt"));
        String len2;
        int a = 0;
        while ((len2 = br2.readLine()) != null) {
            String[] s = len2.split(" ");
            t[a][0] = Integer.parseInt(s[0]);
            t[a][1] = Integer.parseInt(s[1]);
            t[a][2] = Integer.parseInt(s[2]);
            a++;
        }

        for (int[] ints : t) {
            for (int anInt : ints) {
                System.out.print(anInt + "  ");
            }
            System.out.println();
        }


        // 稀疏数组 -》二位数组
        // 1.1 创建二位数组
        int row = t[0][0];
        int col = t[0][1];
        int[][] newArray = new int[row][col];
        // 1.2 遍历稀疏数组，给二位数组赋值
        for (int i = 1; i < t.length; i++) {
            newArray[t[i][0]][t[i][1]] = t[i][2];
        }

        // 遍历二位数组
        for (int[] ints : newArray) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }

    }
}
