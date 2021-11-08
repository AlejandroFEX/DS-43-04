package e2;

public class Piso {
private int ref;
private String precio;// string para dividir los precios
private int tamano;
private int codigoP;

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

@Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
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




}
