/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JAMER
 */
public class Cliente extends User {

    private String tiendaNombre;
    private String celular;
    private List<Producto> productosPublicados;

    public Cliente(int id, String nombre, String apellido, String correoElectronico, String telefono, String direccion, String rol) {
        super(id, nombre, apellido, correoElectronico, telefono, direccion, rol);
        this.productosPublicados = new ArrayList<>();
    }

    public void publicarProducto(int codigo, String nombre, String descripcion, double precio, int stock) {
        Producto nuevoProducto = new Producto(codigo, nombre, descripcion, precio, stock, this.tiendaNombre);
        productosPublicados.add(nuevoProducto);
        System.out.println("Producto publicado con éxito: " + nuevoProducto);
    }

    public void editarProducto(int codigo, String nuevoNombre, String nuevaDescripcion, double nuevoPrecio, int nuevoStock) {
        Producto productoAEditar = null;
        for (Producto producto : productosPublicados) {
            if (producto.getCodigo() == codigo) {
                productoAEditar = producto;
                break;
            }
        }
        if (productoAEditar != null) {
            productoAEditar.setNombre(nuevoNombre);
            productoAEditar.setDescripcion(nuevaDescripcion);
            productoAEditar.setPrecio(nuevoPrecio);
            productoAEditar.setStock(nuevoStock);
            System.out.println("Producto editado con éxito: " + productoAEditar);
        } else {
            System.out.println("Producto de código: " + codigo + " no encontrado.");
        }
    }
    
    public void activarProducto(Producto producto) {
        if (producto != null) {
            producto.setActivo(true);
            System.out.println("El producto " + producto.getNombre() + " ha sido activado.");
        } else {
            System.out.println("Error: Producto no válido.");
        }
    }

    public void inactivarProducto(Producto producto) {
        if (producto != null) {
            producto.setActivo(false);
            System.out.println("El producto " + producto.getNombre() + " ha sido inactivado.");
        } else {
            System.out.println("Error: Producto no válido.");
        }
    }
}
