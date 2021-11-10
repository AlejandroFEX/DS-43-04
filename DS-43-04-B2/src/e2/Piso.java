package e2;
import java.util.*;

public class Piso {

    public int ref;
    String precio;// string para dividir los precios
    int tamano;
    int codigoP;
    private ArrayList<Piso> pisos = new ArrayList<>();

    public int getRef() {
        return ref;
    }

    public String getPrecio() {
        return precio;
    }

    public int getTamano(int i) {
        return tamano;
    }

    public int getCodigoP() {
        return codigoP;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public void setCodigoP(int codigoP) {
        this.codigoP = codigoP;
    }

    public void addPiso(int ref, String precio, int codigoP, int tamano) {
        //bucle para controlar que no hay distintos pisos con misma referencia
        // aunque sean de distinta ajecia
        for (Piso piso : pisos) {
            if (ref == piso.getRef()) {
                throw new IllegalArgumentException();
            }
        }
        Piso piso = new Piso();
        piso.setRef(ref);
        piso.setPrecio(precio);
        piso.setCodigoP(codigoP);
        piso.setTamano(tamano);
        pisos.add(piso);
    }

    Piso getPiso(int index) {
        if (index > pisos.size())
            return null;
        return pisos.get(index);
    }

    public void imprimir() {
        StringBuilder sb = new StringBuilder();
        for (Piso piso : pisos) {
            sb.append(piso).append("\n");
        }
        System.out.println(sb.toString());

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Piso)) return false;
        Piso piso = (Piso) o;
        return tamano == piso.tamano &&
                codigoP == piso.codigoP &&
                precio.equals(piso.precio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(precio, tamano, codigoP);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Referencia: ");
        sb.append(ref);
        sb.append(" Precio: ");
        sb.append(precio);
        sb.append(" Tamano: ");
        sb.append(tamano);
        sb.append(" Codigo Postal: ");
        sb.append(codigoP);

        return sb.toString();
    }

    public void sort(Integer x) {
        if ((x == null)) {
            Collections.sort(pisos, new Sortbyref());
        } else if (x == 1)
            Collections.sort(pisos, new Sortbyprecioma());
        else if (x == 2)
            Collections.sort(pisos, new Sortbypreciome());
        else if (x == 3)
            Collections.sort(pisos, new Sortbycod());
        else if (x == 4)
            Collections.sort(pisos, new Sortbytamama());
        else if (x == 5)
            Collections.sort(pisos, new Sortbytamame());
        else if (x==6)
            Collections.sort(pisos,new Sortbypreciosingarajema());
    }


    class Sortbyref implements Comparator<Piso> {

        public int compare(Piso o1, Piso o2) {
            return o1.ref - o2.ref;
        }
    }

    class Sortbycod implements Comparator<Piso> {
        public int compare(Piso o1, Piso o2) {
            return o1.codigoP - o2.codigoP;
        }
    }

    class Sortbytamama implements Comparator<Piso> {
        public int compare(Piso o1, Piso o2) {
            return o2.tamano - o1.tamano;
        }
    }

    class Sortbytamame implements Comparator<Piso> {
        public int compare(Piso o1, Piso o2) {
            return o1.tamano - o2.tamano;
        }
    }

    class Sortbypreciome implements Comparator<Piso> {
        public int compare(Piso o1, Piso o2) {
            String a[] = o1.precio.split("\\s+");
            String b[] = o2.precio.split("\\s+");
            int x = 0;
            for (int i = 0; i < a.length; i++) {
                x = x + Integer.parseInt(a[i]);
            }
            int y = 0;
            for (int i = 0; i < b.length; i++) {
                y = y + Integer.parseInt(b[i]);
            }
            return x - y;
        }
    }

    class Sortbyprecioma implements Comparator<Piso> {
        public int compare(Piso o1, Piso o2) {
            String a[] = o1.precio.split("\\s+");
            String b[] = o2.precio.split("\\s+");
            int x = 0;
            for (int i = 0; i < a.length; i++) {
                x = x + Integer.parseInt(a[i]);
            }
            int y = 0;
            for (int i = 0; i < b.length; i++) {
                y = y + Integer.parseInt(b[i]);
            }
            return y - x;
        }
    }

    class Sortbypreciosingarajema implements Comparator<Piso> {
        public int compare(Piso o1, Piso o2) {
            String a[] = o1.precio.split("\\s+");
            String b[] = o2.precio.split("\\s+");
            return Integer.parseInt(b[0])-Integer.parseInt(a[0]);
        }
    }
}

