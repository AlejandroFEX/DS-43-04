package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class PisoTest {
private Piso piso;
private Piso piso2;

//Ordenacion o=new Ordenacion();
    @BeforeEach
    void setUp(){

        piso= new Piso();

        piso.addPiso(1, "100 50", 10, 100);
        piso.addPiso(2, "150 50 75", 12, 150);
        piso.addPiso(0, "200 50", 14, 90);

    }
    @Test
    void addPiso() {
        assertThrows(IllegalArgumentException.class, ()-> piso.addPiso(1,"114",10,100));
    }

    @Test
    void testEquals() {
        piso.addPiso(4,"100 50",10,100);
        assertEquals(piso.getPiso(0),piso.getPiso(3));
        assertNotEquals(piso.getPiso(0), piso.getPiso(2));
    }

    @Test
    void testHashCode() {
        piso.addPiso(4,"100 50",10,100);
        assertEquals(piso.getPiso(0).hashCode(),piso.getPiso(3).hashCode());
        assertNotEquals(piso.getPiso(0),piso.getPiso(2));
    }
    @Test
    void testSortRef(){
        piso.sort();
        piso2 = new Piso();
        piso2.addPiso(0, "200 50", 14, 90);
        piso2.addPiso(1, "100 50", 10, 100);
        piso2.addPiso(2, "150 50 75", 12, 150);

        assertEquals(piso.getPiso(0),piso2.getPiso(0));
        assertEquals(piso.getPiso(1),piso2.getPiso(1));
        assertEquals(piso.getPiso(2),piso2.getPiso(2));

    }
    @Test
    void testSortPrecioMa(){
        piso.ord(Piso.Tipo.PRECIOMA);
        piso.sort();
        piso2 = new Piso();
        piso2.addPiso(2, "150 50 75", 12, 150);
        piso2.addPiso(0, "200 50", 14, 90);
        piso2.addPiso(1, "100 50", 10, 100);


        assertEquals(piso.getPiso(0),piso2.getPiso(0));
        assertEquals(piso.getPiso(1),piso2.getPiso(1));
        assertEquals(piso.getPiso(2),piso2.getPiso(2));

    }
    @Test
    void testSortPrecioMe(){
        piso.ord(Piso.Tipo.PRECIOME);
        piso.sort();
        piso2 = new Piso();
        piso2.addPiso(1, "100 50", 10, 100);
        piso2.addPiso(0, "200 50", 14, 90);
        piso2.addPiso(2, "150 50 75", 12, 150);

        assertEquals(piso.getPiso(0),piso2.getPiso(0));
        assertEquals(piso.getPiso(1),piso2.getPiso(1));
        assertEquals(piso.getPiso(2),piso2.getPiso(2));

    }
    @Test
    void testSortCod(){
        piso.ord(Piso.Tipo.COD);
        piso.sort();
        piso2 = new Piso();
        piso2.addPiso(1, "100 50", 10, 100);
        piso2.addPiso(2, "150 50 75", 12, 150);
        piso2.addPiso(0, "200 50", 14, 90);

        assertEquals(piso.getPiso(0),piso2.getPiso(0));
        assertEquals(piso.getPiso(1),piso2.getPiso(1));
        assertEquals(piso.getPiso(2),piso2.getPiso(2));
    }
    @Test
    void testSortTamaMa(){
        piso.ord(Piso.Tipo.TAMAMA);
        piso.sort();
        piso2 = new Piso();
        piso2.addPiso(2, "150 50 75", 12, 150);
        piso2.addPiso(1, "100 50", 10, 100);
        piso2.addPiso(0, "200 50", 14, 90);

        assertEquals(piso.getPiso(0),piso2.getPiso(0));
        assertEquals(piso.getPiso(1),piso2.getPiso(1));
        assertEquals(piso.getPiso(2),piso2.getPiso(2));
    }
    @Test
    void testSortTamaMe(){
        piso.ord(Piso.Tipo.TAMAME);
        piso.sort();

        piso2 = new Piso();
        piso2.addPiso(0, "200 50", 14, 90);
        piso2.addPiso(1, "100 50", 10, 100);
        piso2.addPiso(2, "150 50 75", 12, 150);

        assertEquals(piso.getPiso(0),piso2.getPiso(0));
        assertEquals(piso.getPiso(1),piso2.getPiso(1));
        assertEquals(piso.getPiso(2),piso2.getPiso(2));
    }
    @Test
    void testSortPrecioSinGaraje(){
        piso.ord(Piso.Tipo.PRECIOSINGARA);
        piso.sort();
        piso2 = new Piso();
        piso2.addPiso(0, "200 50", 14, 90);
        piso2.addPiso(2, "150 50 75", 12, 150);
        piso2.addPiso(1, "100 50", 10, 100);
        assertEquals(piso.getPiso(0),piso2.getPiso(0));
        assertEquals(piso.getPiso(1),piso2.getPiso(1));
        assertEquals(piso.getPiso(2),piso2.getPiso(2));
    }
}