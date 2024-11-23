/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.List;

/**
 *
 * @author JAMER
 */
public class Administrador extends User {

    public Administrador(int id, String nombre, String apellido, String correoElectronico, String telefono, String direccion, String rol) {
        super(id, nombre, apellido, correoElectronico, telefono, direccion, rol);
    }

    public void gestionarRoles(User usuario, String nuevoRol) {
        if (usuario != null && nuevoRol != null && !nuevoRol.isEmpty()) {
            usuario.setRol(nuevoRol);
            System.out.println("El rol del usuario " + usuario.getNombre() + " " + usuario.getApellido() + " ha sido actualizado a: " + nuevoRol);
        } else {
            System.out.println("Error: Rol o usuario no válido.");
        }
    }

    public void activarUsuario(User usuario) {
        if (usuario != null) {
            usuario.setActivo(true);
            System.out.println("El usuario " + usuario.getNombre() + " " + usuario.getApellido() + " ha sido activado.");
        } else {
            System.out.println("Error: Usuario no válido.");
        }
    }

    public void inactivarUsuario(User usuario) {
        if (usuario != null) {
            usuario.setActivo(false);
            System.out.println("El usuario " + usuario.getNombre() + " " + usuario.getApellido() + " ha sido inactivado.");
        } else {
            System.out.println("Error: Usuario no válido.");
        }
    }

    public void generarReporte(List<User> usuarios) {
        if (usuarios == null || usuarios.isEmpty()) {
            System.out.println("No hay datos para generar el reporte.");
            return;
        }

        System.out.println("----------------- Reporte de datos ----------------");
        System.out.println("ID | Nombre | Correo Electrónico | Rol | Estado | Productos publicados|");
        System.out.println("----------------------------------------------------");

        for (User usuario : usuarios) {
            String estado = usuario.isActivo() ? "Activo" : "Inactivo";
            System.out.println(usuario.getId() + " | " + usuario.getNombre() + " " + usuario.getApellido() + " | " + usuario.getCorreoElectronico() + " | " + usuario.getRol() + " | " + estado);
        }

        System.out.println("----------------------------------------------------");
    }

    public void activarProductoDeCliente(Cliente cliente, Producto producto) {
        if (cliente != null && producto != null) {
            cliente.activarProducto(producto);
        } else {
            System.out.println("Error: Cliente o producto no válido.");
        }
    }

    public void inactivarProductoDeCliente(Cliente cliente, Producto producto) {
        if (cliente != null && producto != null) {
            cliente.inactivarProducto(producto);
        } else {
            System.out.println("Error: Cliente o producto no válido.");
        }
    }

}
