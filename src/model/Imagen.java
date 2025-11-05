package model;

public class Imagen extends Contenido {
    private String resolucion;
    private String rutaArchivo;

    public Imagen(int id, String titulo, String autor, String categoria, String resolucion, String rutaArchivo) {
        super(id, titulo, autor, categoria);
        this.resolucion = resolucion;
        this.rutaArchivo = rutaArchivo;
    }

    @Override
    public void publicar() {
        this.publicado = true;
        System.out.println(" Imagen publicada: " + titulo);
    }

    @Override
    public void visualizar() {
        System.out.println(" Imagen: " + titulo );
        System.out.println("Autor: " + autor);
        System.out.println("Resolución: " + resolucion);
        System.out.println("Ruta: " + rutaArchivo);
    }

    public String getResolucion() { return resolucion; }
    public String getRutaArchivo() { return rutaArchivo; }
}
