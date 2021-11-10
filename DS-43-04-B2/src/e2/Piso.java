package e2;
import java.util.*;

public class Piso implements Comparable<Piso> {
    public enum Tipo{
        REF, PRECIOMA,PRECIOME,COD, TAMAMA,TAMAME,PRECIOSINGARA
    }
    Tipo x = null;
    public int ref;
    String precio;// string para dividir los precios
    int tamano;
    int codigoP;
    private ArrayList<Piso> pisos = new ArrayList<>();

    public int getRef() {
        return ref;
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


    public void ord(Tipo o) {
        x = o;
    }


    public void sort() {
        if ((x == Tipo.REF)||x==null)
            Collections.sort(pisos);
        else if (x == Tipo.PRECIOMA)
            pisos.sort(new SortByPrecioMayor());
        else if (x == Tipo.PRECIOME)
            pisos.sort(new SortByPrecioMenor());
        else if (x == Tipo.COD)
            pisos.sort(new SortByCodigo());
        else if (x == Tipo.TAMAMA)
            pisos.sort(new SortByTamanoMayor());
        else if (x == Tipo.TAMAME)
            pisos.sort(new SortByTamame());
        else if (x==Tipo.PRECIOSINGARA)
            pisos.sort(new SortByPrecioSinGaraje());
    }

    @Override
    public int compareTo(Piso o) {
        return ref -o.ref;
    }

    static class SortByCodigo implements Comparator<Piso> {
        public int compare(Piso o1, Piso o2) {
            return o1.codigoP - o2.codigoP;
        }
    }
    static class SortByTamanoMayor implements Comparator<Piso> {
        public int compare(Piso o1, Piso o2) {
            return o2.tamano - o1.tamano;
        }
    }

    static class SortByTamame implements Comparator<Piso> {
        public int compare(Piso o1, Piso o2) {
            return o1.tamano - o2.tamano;
        }
    }

    static class SortByPrecioMenor implements Comparator<Piso> {
        public int compare(Piso o1, Piso o2) {
            String[] a = o1.precio.split("\\s+");
            String[] b = o2.precio.split("\\s+");
            int x = 0;
            for (String value : a) {
                x = x + Integer.parseInt(value);
            }
            int y = 0;
            for (String s : b) {
                y = y + Integer.parseInt(s);
            }
            return x - y;
        }
    }

    static class SortByPrecioMayor implements Comparator<Piso> {
        public int compare(Piso o1, Piso o2) {
            String[] a = o1.precio.split("\\s+");
            String[] b = o2.precio.split("\\s+");
            int x = 0;
            for (String s : a) {
                x = x + Integer.parseInt(s);
            }
            int y = 0;
            for (String s : b) {
                y = y + Integer.parseInt(s);
            }
            return y - x;
        }
    }

    static class SortByPrecioSinGaraje implements Comparator<Piso> {
        public int compare(Piso o1, Piso o2) {
            String[] a = o1.precio.split("\\s+");
            String[] b = o2.precio.split("\\s+");
            return Integer.parseInt(b[0])-Integer.parseInt(a[0]);
        }
    }
}

