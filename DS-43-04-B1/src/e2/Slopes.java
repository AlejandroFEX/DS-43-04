package e2;

import java.util.Objects;


public class Slopes {
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
       // [fila][columna]
        int fin =slopeMap.length;
        int countArbol=0;
        int a=0,b=0,desp=0;

        for (int i=0;i<fin;i++){
            //bucle ir a la derecha
            for (int j=0;j<right;j++){
                if (a+j==fin){
                    a=-j;
                }

                if(Character.compare('#',slopeMap[b][a+j])==0){//caracteres iguales
                  // System.out.println("b "+ b+"  a+j "+a+j);
                    countArbol ++;
                }

            }

            a=a+right;
            //if (a+right>fin)
           //     a=a+right-fin+1;
            //a
            for(int k=0;k<down;k++){//bucle para bajar
                if(b+k==fin-1)
                    return countArbol;
                if (Character.compare('#',slopeMap[b+k][a])==0){
                    countArbol++;
                   //System.out.println("b+k "+ b+k +"  a "+a);
                }
            }
            b=b+down;
        }
      return 0;
        }
    /**
     * Traverses the slope map making the right and down movements and
     * returns the number of trees found along the way .
     * Since it " jumps " from the initial position to the final position ,
     * only takes into account the trees on those initial / final positions .
     *
     * Params , return value and thrown expections as in downTheSlope ...
     */
    public static int jumpTheSlope ( char [][] slopeMap , int right , int down ) {
        return 1;
    }

    public static void main(String[] args) {
        char[][] Minimap = {
                {'.', '.', '#', '.', '#'},
                {'#', '.', '.', '.', '.'},
                {'#', '#', '.', '.', '#'},
                {'#', '#', '.', '.', '.'},
                {'.', '#', '.', '#', '.'}
        };
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

        System.out.println(downTheSlope(map,1,1));

    }



}
