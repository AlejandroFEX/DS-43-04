package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlquilerTest {
    private Alquiler piso;
    @BeforeEach
    void setUp() {
        piso = new Alquiler();
        piso.addPiso(0,"200 50",10,100);
        piso.addPiso(1,"100 ",11,90);
        piso.addPiso(2,"150 50 75",12,150);
        for (Piso pisoa: piso.pisos) {
            System.out.println(pisoa);
        }
    }

    @Test
    void imprimir() {


    }




}