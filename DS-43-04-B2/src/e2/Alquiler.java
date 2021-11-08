package e2;

import java.util.ArrayList;

public class Alquiler {

ArrayList<Piso> pisos =new ArrayList<>();

public void addPiso(int ref, String precio, int codigoP, int tamano){
    Piso piso= new Piso();
    piso.setRef(ref);
    piso.setPrecio(precio);
    piso.setCodigoP(codigoP);
    piso.setTamano(tamano);
    pisos.add(piso);
}


public void imprimir() {
        StringBuilder sb = new StringBuilder();
    for (Piso piso : pisos) {
        sb.append(piso);
    }
    System.out.println(sb.toString());

    }








    public static void main(String[] args) {

        Piso piso1= new Piso();
        piso1.setRef(0);
        piso1.setPrecio("200 50");
        piso1.setCodigoP(10);
        piso1.setTamano(100);

        Piso piso2= new Piso();
        piso2.setRef(1);
        piso2.setPrecio("300");
        piso2.setCodigoP(11);
        piso2.setTamano(110);

        Piso piso3= new Piso();
        piso3.setRef(2);
        piso3.setPrecio("150 50 75");
        piso3.setCodigoP(12);
        piso3.setTamano(90);
        //System.out.println(piso1.toString());
        Alquiler piso4= new Alquiler();
        piso4.addPiso(0,"200 50",10,100);
        piso4.toString();

        }
    }

