/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Pia;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UsuarioDeNomina {

    private int numDeEmpleado = 0;
    private String nombre = "";
    private String puesto = "";
    private float sueldo = 0;
    private int telefono = 0;
    private String password = "1945";
    public void agregar() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", password);
            System.out.println("Connected to the PostgreSQL server successfully.");
            PreparedStatement comando = conn.prepareStatement("INSERT INTO "
                    + "UsuarioDeNominas "
                    + "(numDeEmpleado, nombre, "
                    + "puesto, sueldo, "
                    + "telefono) "
                    + "VALUES "
                    + "(?,?,?,?,?);");
            comando.setInt(1, this.numDeEmpleado);
            comando.setString(2, this.nombre);
            comando.setString(3, this.puesto);
            comando.setFloat(4, this.sueldo);
            comando.setInt(5, this.telefono);
            comando.executeUpdate();
                System.out.println("AGREGAR");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDeNomina.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {

        
            Logger.getLogger(UsuarioDeNomina.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void editar() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", password);
            PreparedStatement comando = conn.prepareStatement("UPDATE "
                    + "UsuarioDeNominas "
                    + "SET nombre = ?, "
                    + "puesto = ?, "
                    + "sueldo = ?, "
                    + "telefono = ? "
                    + "WHERE "
                    + "numDeEmpleado = ?;");

            comando.setString(1, this.nombre);
            comando.setString(2, this.puesto);
            comando.setFloat(3, this.sueldo);
            comando.setInt(4, this.telefono);
            comando.setInt(5, this.numDeEmpleado);
            comando.executeUpdate();
              System.out.println("EDICION");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDeNomina.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {

            
            Logger.getLogger(UsuarioDeNomina.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void eliminar() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", password);
            System.out.println("Connected to the PostgreSQL server successfully.");
            PreparedStatement comando = conn.prepareStatement("DELETE FROM "
                    + "UsuarioDeNominas "
                    + "WHERE "
                    + "numDeEmpleado = ?;");

            comando.setInt(1, this.numDeEmpleado);
            comando.executeUpdate();
                    System.out.println("ELIMINAR");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDeNomina.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDeNomina.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ResultSet consultar() {
        ResultSet rs = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", password);
            System.out.println("Connected to the PostgreSQL server successfully.");
            PreparedStatement comando = conn.prepareStatement("SELECT numDeEmpleado, "
                    + "nombre, "
                    + "puesto, "
                    + "sueldo, "
                    + "telefono "
                    + "FROM UsuarioDeNominas ");
            rs = comando.executeQuery();
              System.out.println("CONSULTA LOGRADA");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDeNomina.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(UsuarioDeNomina.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;

    }
    
//select * From usuariodenominas WHERE numdeempleado = 1435;
    public ResultSet buscar(){
        ResultSet rs = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", password);
            System.out.println("Connected to the PostgreSQL server successfully.");
             PreparedStatement comando = conn.prepareStatement("SELECT * FROM"
                    + " UsuarioDeNominas "
                    + " WHERE "
                    + " numdeempleado = ?;");
            comando.setInt(1, this.numDeEmpleado);
            rs = comando.executeQuery();
            rs.next();
            System.out.println("BUSQUEDA");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDeNomina.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(UsuarioDeNomina.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;

       
    }
    
    /**
     * @return the numDeEmpleado
     */
    public int getNumDeEmpleado() {
        return numDeEmpleado;
    }

    /**
     * @param numDeEmpleado the numDeEmpleado to set
     */
    public void setNumDeEmpleado(int numDeEmpleado) {
        this.numDeEmpleado = numDeEmpleado;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the puesto
     */
    public String getPuesto() {
        return puesto;
    }

    /**
     * @param puesto the puesto to set
     */
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    /**
     * @return the sueldo
     */
    public float getSueldo() {
        return sueldo;
    }

    /**
     * @param sueldo the sueldo to set
     */
    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    /**
     * @return the telefono
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
