
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
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Empleado extends JFrame implements ActionListener {
	String usuario;
	JFrame frameEmpleado;
	JButton salir;
	JButton alta;
	JButton registro;
	
	Empleado(String usuario) {
		this.usuario = usuario;
		myEmpleado(usuario);
	}

	void myEmpleado(String usuario) {
		frameEmpleado = new JFrame("Empleado");
		frameEmpleado.setLayout(null);
		frameEmpleado.setResizable(false);
		// Medidas de la ventana
		frameEmpleado.setSize(350, 350);
		frameEmpleado.setVisible(true);
		frameEmpleado.setLocationRelativeTo(null);
		frameEmpleado.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
		salir = new JButton("Salir");
		alta = new JButton("Alta de usuario");
		registro = new JButton("Registrar entrada/salida");
		
		salir.addActionListener(this);
		alta.addActionListener(this);
		registro.addActionListener(this);
		
		// Medias de los botones
		salir.setBounds(20, 20, 160, 30);
		alta.setBounds(20, 80, 160, 30);
		registro.setBounds(20, 140, 160, 30);
		
		frameEmpleado.add(salir);
		frameEmpleado.add(alta);
		frameEmpleado.add(registro);
			
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Salir")) {
			frameEmpleado.dispose();
		} else if (e.getActionCommand().equals("Alta de usuario")) {
			frameEmpleado.dispose();
			new Alta("Usuario");
						
			try {
				Inicio.tfPassword.setText("");
				Inicio.tfUsuario.setText("");
			} catch (NullPointerException ex) {
				// Ventana creada por Empelado
			}
			
			
			
		} else if (e.getActionCommand().equals("Registrar entrada/salida")) {
			Conexion c = new Conexion();
			
			try {
				if(c.registro("Empleado", usuario)) {
				
				JOptionPane.showMessageDialog(null,
						"Bienvenido " + usuario,
						"Aviso", JOptionPane.INFORMATION_MESSAGE);
					frameEmpleado.dispose();
				} else {
					JOptionPane.showMessageDialog(null,
						"Hasta pronto " + usuario,
						"Aviso", JOptionPane.INFORMATION_MESSAGE);
					frameEmpleado.dispose();
				}
			} catch (HeadlessException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Inicio.tfPassword.setText("");
			Inicio.tfUsuario.setText("");
		}
	}
		
	public static void main (String args[]) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Empleado("222");
			}
		});
	}

}
