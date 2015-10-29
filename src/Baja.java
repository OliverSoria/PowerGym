
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

import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Baja {
	String identificador;
	String usuario;
	
	Baja(String identificador, String usuario) {
		this.identificador = identificador;
		this.usuario = usuario;
		myBaja(identificador, usuario);
	}
	
	void myBaja(String identificador, String usuario) {
		String titulo = "Baja de " + identificador;
		String mensaje = "Confirmar baja de " + usuario;
		
		int result = JOptionPane.showConfirmDialog(
                null, mensaje, titulo, JOptionPane.YES_NO_OPTION);
		
		if (result == JOptionPane.YES_OPTION) {
			Conexion c = new Conexion();
			
			try {
				c.baja(identificador, usuario);
				JOptionPane.showMessageDialog(null, "Eliminación Exitosa", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				Buscar.usuario.setText("");
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,
						"Error en el sistema",
						"¡Error!", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		} else if (result == JOptionPane.NO_OPTION) {
			// No se hace nada
		}
	}
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		new Baja("Usuario", "sammy23");
	}
}
