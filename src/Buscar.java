
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

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Buscar extends JFrame implements ActionListener {
	String identificador;
	String accion;
	JFrame frameSelector;
	public static JTextField usuario;
	JButton buscar;
		
	Buscar(String identificador, String accion) {
		this.identificador = identificador;
		this.accion = accion;
		mySelectorDeUsuario(identificador, accion);
	}
	
	void mySelectorDeUsuario(String identificador, String accion) {
		frameSelector = new JFrame("Buscar " + identificador);
		frameSelector.setLayout(null);
		frameSelector.setResizable(false);
		// Medidas de la ventana
		frameSelector.setSize(350, 150);
		frameSelector.setVisible(true);
		frameSelector.setLocationRelativeTo(null);
		frameSelector.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel info = new JLabel("Introduzca el nombre de " + identificador.toLowerCase() + ":");
		
		usuario = new JTextField();
		buscar = new JButton("Buscar");
		buscar.addActionListener(this);
		
		// Medias de la etiqueta
		info.setBounds(10, 10, 300, 20);
		
		// Medidas del campo
		usuario.setBounds(10, 50, 200, 22);
		
		//Medidas del boton
		buscar.setBounds(220, 50, 100, 24);
		
		frameSelector.add(info);
		frameSelector.add(usuario);
		frameSelector.add(buscar);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Buscar")) {
			Conexion c = new Conexion();
			String user = usuario.getText();
			System.out.println("usuario " + user);
			
			if(!usuario.getText().equals("")) {
				try {
					if(c.buscar(identificador, user)) {
						if(accion.equals("Modificar")) {
							new Modificar(identificador,c.id(identificador, user));
						} else if(accion.equals("Baja")) {
							new Baja(identificador, user);
						}
					} else {
						JOptionPane.showMessageDialog(null, "No se encontró el " + identificador.toLowerCase(), "¡Error!", JOptionPane.ERROR_MESSAGE);
					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null,
							"Error en el sistema",
							"¡Error!", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null,
						"No deje campos vacíos",
						"¡Error!", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Buscar("Administrador", "Modificar");
			}
		});
	}
}
