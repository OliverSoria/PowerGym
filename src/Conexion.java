
/*

This file is part of "PowerGym".

"PowerGym" is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

"PowerGym" is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with PowerGym.  If not, see <http://www.gnu.org/licenses/>.
"PowerGym"

*/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Conexion {
	private String url = "jdbc:mysql://localhost/gym";
	private String user = "root";
	private String password = "toor";
	private String con = "";
	private String con2 = "";
	private String con3;
		
	public void alta (String identificador, String nombre, String apellido, String telefono, String direccion, String correo, String id, String pass) 
			throws SQLException {
				
		Connection conexion = DriverManager.getConnection(url, user, password);
		
		String tabla = null;
		
		if(identificador.equals("Usuario")) {
			tabla = "usuarios";
		} else if (identificador.equals("Empleado")) {
			tabla = "empleados";
		} else if (identificador.equals("Administrador")) {
			tabla = "administradores";
		}
	    
		String registrar = "INSERT INTO " + tabla + " (Nombre, Apellido, Telefono, Direccion, Correo, Usuario, Password )" +
	    " values(?,?,?,?,?,?,?)";
		
		PreparedStatement ps = conexion.prepareStatement(registrar);
	    
	    ps.setString (1, nombre);
	    ps.setString (2, apellido);
	    ps.setString (3, telefono);
	    ps.setString (4, direccion);
	    ps.setString (5, correo);
	    ps.setString (5, correo);
	    ps.setString (6, id);
	    ps.setString (7, pass);
	    	    	    
		ps.execute();
		conexion.close();
	}
	
	public boolean buscar(String identificador, String usuario) throws SQLException {
		Connection conexion = DriverManager.getConnection(url, user, password);
		Statement s = conexion.createStatement();
		
		String tabla = null;
		
		if(identificador.equals("Usuario")) {
			tabla = "usuarios";
		} else if (identificador.equals("Empleado")) {
			tabla = "empleados";
		} else if (identificador.equals("Administrador")) {
			tabla = "administradores";
		}
		
		String queryCheck = "SELECT * from " + tabla + " WHERE Usuario='" + usuario + "'";
		System.out.println(queryCheck);
		ResultSet rs = s.executeQuery (queryCheck);
		
		while (rs.next())
		{
			con3 = rs.getString(7);
		}
		
		try {
			if (!con3.equals("1")) {
				return true;
			}
		} catch (NullPointerException e1) {
			return false;
		}
				
		conexion.close();
		
		return false;
	}
	
	public void modificar (String identificador, String id, String nombre, String apellido, String telefono, String direccion, String correo,
			String usuario, String pass) throws SQLException {
		
		Connection conexion = DriverManager.getConnection(url, user, password);			
		Statement s = conexion.createStatement();
		String tabla = null;
		String id_identificador = null;
		if(identificador.equals("Usuario")) {
			tabla = "usuarios";
			id_identificador = "id_usuario";
		} else if (identificador.equals("Empleado")) {
			tabla = "empleados";
			id_identificador = "id_empleado";
		} else if (identificador.equals("Administrador")) {
			tabla = "administradores";
			id_identificador = "id_administrador";
		} 
		
		String queryCheck = "UPDATE " + tabla + " SET Nombre='" + nombre + "', Apellido='" + apellido + "', Telefono='" + telefono 
				+ "', Direccion='" + direccion + "', Correo='" + correo + "', Usuario='" + usuario + "', Password='" + pass 
				+ "' WHERE " + id_identificador + "='" + id + "'";
		System.out.println(queryCheck);
		int rs = s.executeUpdate (queryCheck);			
		conexion.close();
	}
	
	public String info (String identificador, String id, String dato) throws SQLException {
		Connection conexion = DriverManager.getConnection(url, user, password);			
		Statement s = conexion.createStatement();
		String con2 = null;
		
		String tabla = null;
		String id_identificador = null;
		if(identificador.equals("Usuario")) {
			tabla = "usuarios";
			id_identificador = "id_usuario";
		} else if (identificador.equals("Empleado")) {
			tabla = "empleados";
			id_identificador = "id_empleado";
		} else if (identificador.equals("Administrador")) {
			tabla = "administradores";
			id_identificador = "id_administrador";
		} 
		
		String queryCheck = "SELECT " + dato + " from " + tabla + " WHERE " + id_identificador + " = '" + id + "'";
		ResultSet rs = s.executeQuery (queryCheck);			
		
		while (rs.next()) {
			con = rs.getString(1);
		}
										
		conexion.close();
		return con;
	}
	
	public String login (String identificador, String inf, String dato) throws SQLException {
		Connection conexion = DriverManager.getConnection(url, user, password);			
		Statement s = conexion.createStatement();
		String conX = "";
		
		String tabla = null;
		String id_identificador = null;
		if(identificador.equals("Usuario")) {
			tabla = "usuarios";
			id_identificador = "id_usuario";
		} else if (identificador.equals("Empleado")) {
			tabla = "empleados";
			id_identificador = "id_empleado";
		} else if (identificador.equals("Administrador")) {
			tabla = "administradores";
			id_identificador = "id_administrador";
		} 
		
		String queryCheck = "SELECT " + id_identificador + " from " + tabla + " WHERE " + dato + " = '" + inf + "'";
		ResultSet rs = s.executeQuery (queryCheck);			
		
		while (rs.next()) {
			conX = rs.getString(1);
		}
		System.out.println("antes = " + conX);								
		conexion.close();
		
		if(conX.equals("")) {
			double r = (Math.random() * 9);
			conX = Double.toString(r);
		}
		System.out.println("despues = " + conX);	
		return conX;
		
	}
	
	public String id (String identificador, String usuario) throws SQLException {
		Connection conexion = DriverManager.getConnection(url, user, password);			
		Statement s = conexion.createStatement();
				
		String tabla = null;
		String id_identificador = null;
		if(identificador.equals("Usuario")) {
			tabla = "usuarios";
			id_identificador = "id_usuario";
		} else if (identificador.equals("Empleado")) {
			tabla = "empleados";
			id_identificador = "id_empleado";
		} else if (identificador.equals("Administrador")) {
			tabla = "administradores";
			id_identificador = "id_administrador";
		} 
		
		String queryCheck = "SELECT " + id_identificador + " from " + tabla + " WHERE Usuario = '" + usuario + "'";
		ResultSet rs = s.executeQuery (queryCheck);			
		
		while (rs.next()) {
			con = rs.getString(1);
		}
										
		conexion.close();
		return con;
	}
	
	public void baja (String identificador, String usuario) throws SQLException {
		Connection conexion = DriverManager.getConnection(url, user, password);
		
		String tabla = null;
		
		if(identificador.equals("Usuario")) {
			tabla = "usuarios";
		} else if (identificador.equals("Empleado")) {
			tabla = "empleados";
		} else if (identificador.equals("Administrador")) {
			tabla = "administradores";
		} 
		
		   String borrar = "DELETE FROM " + tabla + " WHERE Usuario='" + usuario + "'";
		   System.out.println(borrar);
			    
		   PreparedStatement ps = conexion.prepareStatement(borrar);
							    	    
		ps.execute();
		conexion.close();
	}
	
	public boolean registro (String identificacion, String usuario) throws SQLException {
		Connection conexion = DriverManager.getConnection(url, user, password);
		int record = 0;
				
		String estatus;
		LocalDateTime myTime = LocalDateTime.now();
	    String time = myTime.toString();
	    String fecha = time.substring(0, 10);
		String hora = time.substring(11, 16);
		
		Statement s = conexion.createStatement();
		
		String queryCheck = "SELECT COUNT(Fecha) from historial WHERE Usuario = '" + usuario + "'";
		
		ResultSet rs = s.executeQuery (queryCheck);
		
		rs.next();
		record = rs.getInt(1);
				
		System.out.println("con = " + record);
					
		if(record % 2 == 0) {
			estatus = "Entrada";
		} else {
			estatus = "Salida";
		}
		
		String registrar = "INSERT INTO historial (Identificacion, Usuario, Fecha, Hora, Estatus)" +
		    " values(?,?,?,?,?)";
			
			PreparedStatement ps = conexion.prepareStatement(registrar);
		    
		    ps.setString (1, identificacion);
		    ps.setString (2, usuario);
		    ps.setString (3, fecha);
		    ps.setString (4, hora);
		    ps.setString (5, estatus);
		    			    	    	    
			ps.execute();
		
		conexion.close();
		
		if(record % 2 == 0) {
			return true;
		} 
		
		return false;
		
	}
	
	
}
