package e2;

import java.util.Objects;


public class Slopes {
    /**
     * Traverses the slope map making the right and down movements and
     * returns the number of trees found along the way .
     *
     * @param slopeMap A square matrix representing the slope with spaces
     *                 represented as "." and trees represented as "#".
     * @param right    Movement to the right
     * @param down     Downward movement
     * @return Number of trees
     * @throws IllegalArgumentException if the matrix is incorrect because :
     *                                  - It is not square .
     *                                  - It has characters other than "." and "#"
     *                                  - right >= number of columns or right < 1
     *                                  - down >= number of rows of the matrix or down < 1
     */
    public static int downTheSlope(char[][] slopeMap, int right, int down) {
        //Excepciones
        for (char[] chars : slopeMap) {
            if (slopeMap.length != chars.length) {

                throw new IllegalArgumentException();
            }
        }
        int fin = slopeMap.length;//dimension de la matriz
        for (int k = 0; k < fin; k++) {
            for (int j = 0; j < fin; j++) {
                if ((0 != Character.compare('#', slopeMap[k][j])) && (0 != Character.compare('.', slopeMap[k][j]))) {
                    throw new IllegalArgumentException();
                }
            }
        }
        if (right < 1 || down < 1)
            throw new IllegalArgumentException();
        if (right >= fin || down >= fin)
            throw new IllegalArgumentException();

        // [fila][columna]
        int countArbol = 0;
        int a = 0, b = 0, desp = 0;
        for (int i = 0; i < fin; i++) {
            //bucle ir a la derecha
            for (int j = 0; j < right; j++) {
                if (a + j == fin) {
                    a = -j;
                }
                if (Character.compare('#', slopeMap[b][a + j]) == 0) {//caracteres iguales
                    countArbol++;
                }
            }
            if (b + 1 == fin) {
                return countArbol;
            }
            a = a + right;
            for (int k = 0; k < down; k++) {//bucle para bajar
                if (b + k == fin)
                    return countArbol;
                if (Character.compare('#', slopeMap[b + k][a]) == 0) {
                    countArbol++;
                }
            }
            b = b + down;
        }
        return countArbol;
    }

    /**
     * Traverses the slope map making the right and down movements and
     * returns the number of trees found along the way .
     * Since it " jumps " from the initial position to the final position ,
     * only takes into account the trees on those initial / final positions .
     * <p>
     * Params , return value and thrown expections as in downTheSlope ...
     */
    public static int jumpTheSlope(char[][] slopeMap, int right, int down) {
        //Excepciones
        for (char[] chars : slopeMap) {
            if (slopeMap.length != chars.length) {

                throw new IllegalArgumentException();
            }
        }
        int fin = slopeMap.length;//dimension de la matriz
        for (int k = 0; k < fin; k++) {
            for (int j = 0; j < fin; j++) {
                if ((0 != Character.compare('#', slopeMap[k][j])) && (0 != Character.compare('.', slopeMap[k][j]))) {
                    throw new IllegalArgumentException();
                }
            }
        }
        if (right < 1 || down < 1)
            throw new IllegalArgumentException();
        if (right >= fin || down >= fin)
            throw new IllegalArgumentException();

        // [fila][columna]
        int countArbol = 0;
        int a = 0, b = 0, desp = 0;
        for (int i = 0; i < fin; i++) {
            a = a + right;
            if (a >= fin) {
                a = a - fin ;
            }
            b = b + down;
            if (Character.compare('#', slopeMap[b][a]) == 0) {
                countArbol++;
            }
            if (b + down >= fin) {
                return countArbol;
            }
        }
        return countArbol;
    }
}