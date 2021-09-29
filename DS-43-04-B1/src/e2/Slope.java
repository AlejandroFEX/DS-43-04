package e2;

import java.util.Objects;

public class Slope {
    /**
     * Traverses the slope map making the right and down movements and
     * returns the number of trees found along the way .
     * @param slopeMap A square matrix representing the slope with spaces
     * represented as "." and trees represented as "#".
     * @param right Movement to the right
     * @param down Downward movement
     * @return Number of trees
     * @throws IllegalArgumentException if the matrix is incorrect because :
     * - It is not square .
     * - It has characters other than "." and "#"
     * - right >= number of columns or right < 1
     * - down >= number of rows of the matrix or down < 1
     */
    public static int downTheSlope ( char [][] slopeMap , int right , int down ) {
        int fin =slopeMap.length;
        int countArbol=0;
        int a=0,b=0;
        for (int i=0;i<fin;i++){
            //bucle ir a la derecha
            for (int j=0;j<right;j++){
                if (a+j==fin){



                }
                if((slopeMap[a+j][b]).equals("#")){
                    countArbol++;
                }
            }
            a=a+right;
            for(int k=0;k<down;k++){
                if (slopeMap[a][b+k].equals('#')){
                    countArbol++;
                }
            }
            b=b+down;
        }




        return 0;
        }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this==o) return true;
        if (o==null|| getClass()!= o.getClass()) return false;
    }

    public static void main(String[] args) {
        char[][] map = {
                {'.', '.', '#', '#', '.', '.', '.', '.', '.', '.', '.'},
                {'#', '.', '.', '.', '#', '.', '.', '.', '#', '.', '.'},
                {'.', '#', '.', '.', '.', '.', '#', '.', '.', '#', '.'},
                {'.', '.', '#', '.', '#', '.', '.', '.', '#', '.', '#'},
                {'.', '#', '.', '.', '.', '#', '#', '.', '.', '#', '.'},
                {'.', '.', '#', '.', '#', '#', '.', '.', '.', '.', '.'},
                {'.', '#', '.', '#', '.', '#', '.', '.', '.', '.', '#'},
                {'.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
                {'#', '.', '#', '#', '.', '.', '.', '#', '.', '.', '.'},
                {'#', '.', '.', '.', '#', '#', '.', '.', '.', '.', '#'},
                {'.', '#', '.', '.', '#', '.', '.', '.', '#', '.', '#'}
        };
        downTheSlope(map,2,3);
    }
}
