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
      //                      {16, 17, 18, 19, 20, 21, 8},
      //                      {15, 14, 13, 12, 11, 10, 9}};

        System.out.println("Before printing the elements");
        PrintMatrix(Matrix1, Matrix1.length, Matrix1[0].length);
        // PrintMatrix(Matrix2);

        System.out.println("After spirally printing the elements");
        SpiralTheMatrix(Matrix1, Matrix1.length, Matrix1[0].length);
        // RotateTheMatrix(Matrix2, Matrix2.length);
    }

    static void SpiralTheMatrix(int[][] Matrix, int row, int column){
        int Count;
        row--;
        column--;

        for(int rowLength = 0, columnLength = 0; rowLength <= row && columnLength <= column; row--, column--, rowLength++, columnLength++) {

            for(Count = columnLength; Count <= column; Count++) {
                System.out.print(Matrix[rowLength][Count] + " ");
                // System.out.println(Count);
            }

            for(Count = rowLength+1; Count <= row; Count++) {
                System.out.print(Matrix[Count][column] + " ");
                // System.out.println(Count);
            }

            if(rowLength != row && columnLength != column) {
                for(Count = column - 1; Count >= columnLength; Count--) {
                  System.out.print(Matrix[row][Count] + " ");
                  // System.out.println(Count);
                }

                for(Count = row - 1; Count > rowLength; Count--) {
                  System.out.print(Matrix[Count][columnLength] + " ");
                  // System.out.println(Count);
                }
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
