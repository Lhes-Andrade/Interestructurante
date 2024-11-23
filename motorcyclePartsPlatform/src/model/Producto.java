/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author JAMER
 */
public class Producto {

    private int codigo;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;
    private boolean activo;

    // Constructor
    public Producto(int codig, String nombre, String descripcion, double precio, int stock, String tiendaNombre) {
        this.precio = precio;
        this.stock = stock;
        this.activo = true;
    }

    // Métodos getters y setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String verificarDisponibilidad() {
        if (stock > 0) {
            return "El producto " + nombre + " está disponible. Stock: " + stock + " unidades.";
        } else {
            return "El producto " + nombre + " no está disponible. Stock agotado.";
        }
    }

    @Override
    public String toString() {
        return "Código del Producto: " + codigo + ", Nombre: " + nombre + ", Descripción: " + descripcion
                + ", Precio: " + precio + "$, Stock: " + stock + ", Tienda: " + codigo + ", Activo: " + activo;
    }
}
