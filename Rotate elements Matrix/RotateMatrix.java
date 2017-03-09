class MainClass {
    public static void main(String args[]) {
        int[][] Matrix1 = { {1, 2, 3},
                            {8, 9, 4},
                            {7, 6, 5}};

      //  int[][] Matrix2 = { {1, 2, 3, 4},
      //                      {12, 13, 14, 5},
      //                      {11, 16, 15, 6},
      //                      {10, 9, 8, 7}};

        System.out.println("Before rotating the elements");
        PrintMatrix(Matrix1);
        // PrintMatrix(Matrix2);

        RotateTheMatrix(Matrix1, Matrix1.length);
        // RotateTheMatrix(Matrix2, Matrix2.length);

        System.out.println("After rotating the elements");
        PrintMatrix(Matrix1);
        // PrintMatrix(Matrix2);

    }

    static void RotateTheMatrix(int[][] Matrix, int length){
        int temp1, temp2;

        for(int iCount = 0, jCount = (length-1); iCount < (length/2) && jCount >= (length/2); iCount++, jCount--) {
            temp1 = Matrix[iCount][iCount];
            for(int Count = iCount; Count < jCount; Count++) {
                temp2 = Matrix[iCount][Count + 1];
                Matrix[iCount][Count + 1] = temp1;
                temp1 = temp2;
            }

            for(int Count = iCount; Count < jCount; Count++) {
                temp2 = Matrix[Count + 1][jCount];
                Matrix[Count + 1][jCount] = temp1;
                temp1 = temp2;
            }

            for(int Count = jCount; Count > iCount; Count--) {
                temp2 = Matrix[jCount][Count - 1];
                Matrix[jCount][Count - 1] = temp1;
                temp1 = temp2;
            }

            for(int Count = jCount; Count > iCount; Count--) {
                temp2 = Matrix[Count - 1][iCount];
                Matrix[Count - 1][iCount] = temp1;
                temp1 = temp2;
            }

        }
    }

    static void PrintMatrix(int[][] Matrix) {
        for(int iCount = 0; iCount < Matrix.length; iCount++) {
            for(int jCount = 0; jCount < Matrix.length; jCount++) {
                System.out.print(Matrix[iCount][jCount] + "   ");
            }
            System.out.println("");
        }
    }
}
