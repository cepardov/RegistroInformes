/*
 * Copyright (C) 2015 cepardov
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package basedatos;
import java.io.IOException;
import java.net.Socket;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 * @author cepardov <cepardov@gmail.com>
 */

public final class DataBaseInstance {
    private static Connection conn;
    private static final String basedatos = "";//Nombre de base de datos
    private static final String usuario = "";//Usuario de base de datos
    private static final String contraseña = "";//Contraseña de base de datos
    private static final String host = "localhost";//host
    private static final String port="3306";//Puerto de base de datos
    
    //Driver
    private static final String driver="com.mysql.jdbc.Driver";
    
    //Conexión con bases de datos mysql
    private static final String url = "jdbc:mysql://"+host+"/"+basedatos;
    
    //Metodo conexion a base de datos [Seccion getInstanceConnection]
    public static Connection getInstanceConnection() {
        System.out.println("[i] Conectar base de datos mysql...");
        if (!(conn instanceof Connection)) {
            try {
                Class.forName(""+driver+"");
                conn = DriverManager.getConnection(url, usuario, contraseña);
                System.out.println("LISTO");
            } catch (ClassNotFoundException se) {
                System.out.println(" [!] Error: Módulo Base de datos  (Mysql:getInstanceConnection)\n\tCod.:" + se);
                JOptionPane.showMessageDialog(null,"Error de controlador durante la comunicacion con base de datos "+basedatos+"\n\n\tDriver Instalado:\n\t"+driver+"\nCodigo de error:\n"+se, "¡ups! Algo inesperado ha pasado", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            } catch (SQLException se) {
                System.out.println(" [!] Error: Módulo Base de datos  (Derby:getInstanceConnection)\n\tCod.:" + se);
                JOptionPane.showMessageDialog(null,"Lo sentimos estamos experimentando un fallo!\n"
                        + "Compruebe lo siguente:\n"
                        + "\t- Asegurese que está conectado a Internet\n"
                        + "\t- Si tiene un servidor local de base de datos asegure que está encendido y funcionando.\n"
                        + "\t- No ha podido resolver el problema?\n"
                        + "\t\tContacte con el administrador del sistema.", "Error en comunicación", JOptionPane.ERROR_MESSAGE);
                System.out.println("Error: "+se);
                System.exit(0);
            }
        }
        System.out.println(conn);
        return conn;
    }
    
    //Metodo conexion a base de datos [Seccion 45]
    public static void resultadoConexion(){
        JOptionPane.showMessageDialog(null,"Datos de la conexión:\n"
                + "URL:"+url+"\n"
                + "Puerto:"+port+"\n"
                + "Usuario:"+usuario+"\n"
                + "Codigo:\n"+conn,"Resultado de Pruebas", JOptionPane.INFORMATION_MESSAGE);
    }
    
    //Metodo conexion a base de datos [Seccion 54]
    public static void resultadoDesconexion(){
        if(conn!=null){
            JOptionPane.showMessageDialog(null,"La conexion no ha terminado correctamente\n"
                    + "aun conectado con codigo:\n"
                    + conn+ "\n"
                    + "ha base de datos"+basedatos,"Resultado de Pruebas", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,"La conexion ha terminado con exito","Resultado de Pruebas", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    //Metodo conexion a base de datos [Seccion 66]
    public static void closeConnection() {
        try {
            if (conn instanceof Connection) {
                conn.close();
                conn = null;
                System.out.println("[i] Base de datos desconectada con exito.");
            }

        } catch (SQLException se) {
            System.out.println(" [!] Error: Módulo Base de datos  (Derby:closeConnection)\n\tCod.:" + se);
            
            System.err.println("[i] Error al procesar cierre de conexion.");
            
            JOptionPane.showMessageDialog(null,"Error mientras se terminaba la comunicación con base de datos "+basedatos+"\nCodigo de error:\n"+se, "¡ups! Algo inesperado ha pasado", JOptionPane.WARNING_MESSAGE);
            System.err.println(se.getMessage());
        }
    }
    /**
     * Verifica conexión a internet especificamente a base de datos
     * @return <b>true</b> si la conexion es verdadera | <b>false</b>
     * si la conexión es falsa.
     */
    public boolean internet(){
        try{
            Socket s = new Socket(host,Integer.parseInt(port));
            if(s.isConnected()){
                System.out.println("Conexión Internet="+s.isConnected());
                s.close();
                return true;//Existe conección internet
            } else {
                System.out.println("Conexión Internet="+s.isConnected());
                s.close();
                return false;//Sin Internet
            }
        } catch (NumberFormatException | IOException se) {
            System.out.println("Conexión Internet="+se);
            return false;//Sin Internet
        }
    }
}