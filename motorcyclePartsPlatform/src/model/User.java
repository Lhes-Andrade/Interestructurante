/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Scanner;
import java.util.List;

/**
 *
 * @author JAMER
 */
public class User {

    private Scanner teclado;
    private int id;
    private String nombre;
    private String apellido;
    private String correoElectronico;
    private String telefono;
    private String direccion;
    private String rol;
    private boolean autenticado;
    private boolean activo;

    public User(int id, String nombre, String apellido, String correoElectronico,
            String telefono, String direccion, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.direccion = direccion;
        this.rol = rol;
        this.activo = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (telefono.length() > 8) {
            System.out.println("El número de teléfono debe ser de 8 dígitos máximo.");
        } else {
            this.telefono = telefono;
        }
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    private Object getContrasena() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private Object getContraseña() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void setContraseña(String nuevaContraseña) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

// ----------------  MÉTODOS  ---------------------------
    // Método de registro de datos (directamente en la clase User)
    public static User registrar(int id, String nombre, String apellido, String correoElectronico,
            String telefono, String direccion, String rol) {
        // Validaciones previas
        if (correoElectronico == null || correoElectronico.isEmpty()) {
            System.out.println("El correo electrónico no puede estar vacío.");
            return null;
        }

        if (telefono == null || telefono.length() != 8) {
            System.out.println("El número de teléfono debe ser de 8 dígitos.");
            return null;
        }

        // Crear el usuario y devolverlo
        User newUser = new User(id, nombre, apellido, correoElectronico, telefono, direccion, rol);
        System.out.println("Usuario registrado exitosamente: " + newUser.getNombre() + " " + newUser.getApellido());
        return newUser;
    }

    // Método para el login del usuario
    public static boolean iniciarSesion(List<User> users, String correoElectronico, String contrasena) {
        for (User user : users) {
            if (user.getCorreoElectronico().equals(correoElectronico) && user.getContrasena().equals(contrasena)) {
                System.out.println("Login exitoso. Bienvenido, " + user.getNombre() + "!");
                return true; // Usuario autenticado correctamente
            }
        }
        System.out.println("Credenciales incorrectas. Intenta nuevamente.");
        return false; // No se encontró un usuario con las credenciales proporcionadas
    }

    public void cerrarSesion() {
        if (this.autenticado) {
            this.autenticado = false;  // Marcamos al usuario como no autenticado
            System.out.println("Sesión cerrada exitosamente. ¡Hasta pronto, " + this.getNombre() + "!");
        } else {
            System.out.println("El usuario no está autenticado.");
        }
    }

    // Método para restablecer la contraseña
    public static boolean restablecerContraseña(List<User> users, String correoElectronico, String contraseñaActual, String nuevaContraseña) {
        for (User user : users) {
            if (user.getCorreoElectronico().equals(correoElectronico)) {
                if (user.getContraseña().equals(contraseñaActual)) {
                    user.setContraseña(nuevaContraseña);  // Actualiza la contraseña
                    System.out.println("Contraseña restablecida con éxito.");
                    return true; // Contraseña actualizada correctamente
                } else {
                    System.out.println("La contraseña actual es incorrecta.");
                    return false; // Contraseña actual no coincide
                }
            }
        }
        System.out.println("No se encontró un usuario con ese correo electrónico.");
        return false; // No se encontró el usuario con el correo electrónico proporcionado
    }

    // Método para agregar un comentario
    public void comentar() {
        System.out.println("Ingresa el comentario: ");
        String comentario = teclado.next();
        System.out.println(comentario);
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + " " + apellido + ", Correo: " + correoElectronico;
    }

}
