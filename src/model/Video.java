package model;

public class Video extends Contenido {
    private String url;
    private int duracionSegundos;

    public Video(int id, String titulo, String autor, String categoria, String url, int duracionSegundos) {
        super(id, titulo, autor, categoria);
        this.url = url;
        this.duracionSegundos = duracionSegundos;
    }

    @Override
    public void publicar() {
        this.publicado = true;
        System.out.println(" Video publicado: " + titulo);
    }

    @Override
    public void visualizar() {
        System.out.println(" Video: " + titulo );
        System.out.println("Autor: " + autor);
        System.out.println("Duración: " + duracionSegundos + " segundos");
        System.out.println("URL: " + url);
    }

    public String getUrl() { return url; }
    public int getDuracionSegundos() { return duracionSegundos; }
}
