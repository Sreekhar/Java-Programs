class MainClass {
    public static void main(String args[]) {
        int[][] Matrix1 = { {1, 2, 3},
                            {8, 9, 4},
                            {7, 6, 5}};

      //  int[][] Matrix2 = { {1, 2, 3, 4},
      //                      {12, 13, 14, 5},
      //                      {11, 16, 15, 6},
      //                      {10, 9, 8, 7}};

      //  int[][] Matrix3 = { {1, 2, 3, 4, 5, 6, 7},
      //                      {16, 17, 18, 19, 20, 21, 22},
      //                      {15, 14, 13, 12, 11, 10, 9}};

        System.out.println("Before rotating the elements");
        PrintMatrix(Matrix1, Matrix1.length, Matrix1[0].length);
        // PrintMatrix(Matrix2);

        SpiralTheMatrix(Matrix1, Matrix1.length, Matrix1[0].length);
        // RotateTheMatrix(Matrix2, Matrix2.length);

        System.out.println("After rotating the elements");
        PrintMatrix(Matrix1);
        // PrintMatrix(Matrix2);

    }

    static void RotateTheMatrix(int[][] Matrix, int row, int column){

        for(int iCount = 0, jCount = (column-1); iCount < (row/2) && jCount >= (column/2); iCount++, jCount--) {

            for(int Count = iCount; Count < jCount; Count++) {
                System.out.println(Matrix[iCount][Count] + " ");
            }

            for(int Count = iCount; Count < jCount; Count++) {
                System.out.println(Matrix[Count][jCount] + " ");
            }

            for(int Count = jCount; Count > iCount; Count--) {
                System.out.println(Matrix[jCount][Count] + " ");
            }

            for(int Count = jCount; Count > iCount; Count--) {
                System.out.println(Matrix[Count][iCount] + " ");
            }

        }
    }

    static void PrintMatrix(int[][] Matrix, int row, int column) {
        for(int iCount = 0; iCount < row; iCount++) {
            for(int jCount = 0; jCount < column; jCount++) {
                System.out.print(Matrix[iCount][jCount] + "   ");
            }
            System.out.println("");
        }
    }
}
