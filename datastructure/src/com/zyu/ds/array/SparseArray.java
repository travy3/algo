package com.zyu.ds.array;

public class SparseArray {
    public static void main(String[] args) {
        int nomalArray[][] = new int[11][11];
        nomalArray[1][2] = 1;
        nomalArray[2][3] = 2;
        for (int[] row : nomalArray) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //covert the 2-dimensional array to a sparse array
        //1 traverse the orignal two-dimensional array to get the number of non-zero data
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (nomalArray[i][j] != 0) {
                    sum++;
                }
            }
        }

        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;

        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (nomalArray[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = nomalArray[i][j];
                }
            }
        }
        System.out.println();
        for (int i = 0; i < sparseArray.length; i++) {
            System.out.printf("%d\t%d\t%d\n", sparseArray[i][0], sparseArray[i][1], sparseArray[i][2]);
        }

        int[][] nomalArray2 = sparseArrayToNomalArray(sparseArray);
    }

    private static int[][] sparseArrayToNomalArray(int[][] sparseArray) {
        int row = sparseArray[0][0];
        int col = sparseArray[0][1];
        int nonZeroCount = sparseArray[0][2];

        int[][] nomalArray = new int[row][col];
        for (int i = 1; i <= nonZeroCount; i++) {
            int rowIndex = sparseArray[i][0];
            int colIndex = sparseArray[i][1];
            int nonZeroValue = sparseArray[i][2];
            nomalArray[rowIndex][colIndex] = nonZeroValue;
        }

        System.out.println();
        for (int[] rowTmp : nomalArray) {
            for (int data : rowTmp) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        return nomalArray;
    }



}