package model;

public class Articulo extends Contenido {
    private String texto;

    public Articulo(int id, String titulo, String autor, String categoria, String texto) {
        super(id, titulo, autor, categoria);
        this.texto = texto;
    }

    @Override
    public void publicar() {
        this.publicado = true;
        System.out.println(" Artículo publicado: " + titulo);
    }

    @Override
    public void visualizar() {
        System.out.println(" Artículo: " + titulo  );
        System.out.println("Autor: " + autor);
        System.out.println("Categoría: " + categoria);
        System.out.println("Contenido: " + texto);
    }

    public String getTexto() { return texto; }
    public void setTexto(String texto) { this.texto = texto; }
}
