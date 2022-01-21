package com.flintcore.datos;

import java.sql.*;
import java.util.*;

import com.flintcore.dominios.cliente;

public class ClienteDAO {
    private static final String SQL_SELECT = "SELECT id_cliente, name, l_name, age, mail, currenty "
            .concat("FROM cliente");

    private static final String SQL_SELECTED_ID = SQL_SELECT.concat(" WHERE id_cliente = ?");

    private static final String SQL_INSERT = "INSERT INTO cliente (name, l_name, age, mail, currenty) "
            .concat("VALUES (?,?,?,?,?)");

    private static final String SQL_UPDATE = "UPDATE cliente"
            .concat("SET name=?, l_name=?, age =?, mail =?, currenty =? WHERE id_cliente = ?");

    private static final String SQL_DELETE = "DELETE FROM cliente WHERE id_cliente = ?";

    // #region Listado
    public List<cliente> listClients() {
        // Asigno las variables
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        cliente client = null;
        List<cliente> list = new ArrayList<>();

        try {
            // Inicializo los datos
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_SELECT);
            rs = stm.executeQuery();

            // Start checking of elements
            while (rs.next()) {
                int id = rs.getInt("id_cliente");
                String name = rs.getString("name");
                String lname = rs.getString("l_name");
                int age = rs.getInt("age");
                String mail = rs.getString("mail");
                double sald = rs.getDouble("currenty");

                client = new cliente(id, name, lname, age, mail, sald);
                list.add(client);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            Conexion.close(rs);
            Conexion.close(stm);
            Conexion.close(conn);
        }

        return list;
    }
    // #endregion

    // #region Encontrar
    public cliente findClient(cliente cl) {

        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_SELECTED_ID);
            stm.setInt(1, cl.getIdCliente());
            rs = stm.executeQuery();
            rs.absolute(0);

            // Start checking
            String name = rs.getString("name");
            String lname = rs.getString("l_name");
            int age = rs.getInt("age");
            String mail = rs.getString("mail");
            double sald = rs.getDouble("currenty");

            // Concat the values of database in the input client
            cl.setName(name);
            cl.setLname(lname);
            cl.setAge(age);
            cl.setMail(mail);
            cl.setCurrent(sald);

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            Conexion.close(rs);
            Conexion.close(stm);
            Conexion.close(conn);
        }

        return cl;
    }
    // #endregion

    // #region Insertado
    public int insertar(cliente cl) {

        Connection conn = null;
        PreparedStatement stm = null;
        //verificate values
        int check = 0;

        try {
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_SELECTED_ID);

            stm.setString(1, cl.getName());
            stm.setString(2, cl.getLname());
            stm.setInt(3, cl.getAge());
            stm.setString(4, cl.getMail());
            stm.setDouble(5, cl.getCurrent());

            check = stm.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            Conexion.close(stm);
            Conexion.close(conn);
        }

        return check;
    }
    // #endregion

    //#region Actualizado
    public int actualizar(cliente cl) {

        Connection conn = null;
        PreparedStatement stm = null;
        //verificate values
        int check = 0;

        try {
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_UPDATE);

            stm.setString(1, cl.getName());
            stm.setString(2, cl.getLname());
            stm.setInt(3, cl.getAge());
            stm.setString(4, cl.getMail());
            stm.setDouble(5, cl.getCurrent());
            stm.setInt(6, cl.getIdCliente());

            check = stm.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            Conexion.close(stm);
            Conexion.close(conn);
        }

        return check;
    }
    //#endregion

    //#region Borrado
    public int Borrar(cliente cl){
        
        Connection conn = null;
        PreparedStatement stm = null;
        //verificate values
        int check = 0;

        try {
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_DELETE);

            stm.setInt(1, cl.getIdCliente());
            check = stm.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            Conexion.close(stm);
            Conexion.close(conn);
        }

        return check;
    }
    //#endregion
}
