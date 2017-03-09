class MainClass {
    public static void main(String args[]) {
        int[][] Matrix = { {1, 2, 3, 4},
                           {4, 6, 7, 8},
                           {9, 10, 11, 12},
                           {13, 14, 15, 16}};
        PrintMatrix(Matrix);
    }

    void PrintMatrix(int[][] Matrix) {
        for(int iCount = 0; iCount < Matrix.length; iCount++) {
            for(int jCount = 0; jCount < Matrix.length; jCount++) {
                System.out.print(Matrix[iCount][jCount] + "   ");
            }
            System.out.println("");
        }
    }
}
