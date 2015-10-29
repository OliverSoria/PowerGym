
/*

PowerGym

Copyright 2015 Oliver Soria Pelaez, Evelin Maricela Navarrete Ramos

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.

*/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Inicio extends JFrame implements ActionListener {
	public static JFrame frameInicio;
	public static JTextField tfUsuario;
	public static JPasswordField tfPassword;
	JButton inicio;
	JButton salir;

	Inicio() {
		myInicio();
	}
	
	void myInicio() {
		frameInicio = new JFrame("Inicio de Sesión");
		frameInicio.setLayout(null);
		frameInicio.setResizable(false);
		// Medidas de la ventana
		frameInicio.setSize(700, 350);
		frameInicio.setVisible(true);
		frameInicio.setLocationRelativeTo(null);
		frameInicio.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		inicio = new JButton("Inicio");
		salir = new JButton("Salir");
		
		inicio.addActionListener(this);
		salir.addActionListener(this);
		
		JLabel usuario = new JLabel("Usuario:");
		JLabel password = new JLabel("Contraseña:");
		JLabel imagen = new JLabel();		
				
		final ImageIcon logo = new ImageIcon(getClass().getResource("/POWER.png"));
		imagen.setIcon(logo);
				
		tfUsuario = new JTextField();
		tfPassword = new JPasswordField();
		
		tfUsuario.addActionListener(this);
		tfPassword.addActionListener(this);
		
		// Medidas de la imagen
		imagen.setBounds(10, 10, 400, 300);
		
		// Medidas de las etiquetas
		usuario.setBounds(400, 50, 120, 25);
		password.setBounds(400, 160, 120, 25);
		
		//Medidas de los campos
		tfUsuario.setBounds(470,50,200,20);
		tfPassword.setBounds(470, 160, 200, 20);
		
		//Medias de los botones
		salir.setBounds(420,240, 90, 30);
		inicio.setBounds(550, 240, 90, 30);
		
		frameInicio.add(usuario);
		frameInicio.add(password);
		frameInicio.add(tfUsuario);
		frameInicio.add(tfPassword);
		frameInicio.add(salir);
		frameInicio.add(inicio);
		frameInicio.add(imagen);
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Salir")) {
			System.exit(0);
		} else if(e.getActionCommand().equals("Inicio")) {
			String usuario;
			String password;
			
			String usrId = "";
			String pwdId = "";
			
			
			if(!tfUsuario.getText().equals("")) {
				if(!tfPassword.getText().equals("")) {
					Conexion c = new Conexion();
					usuario = tfUsuario.getText();
					password = tfPassword.getText();
										
					try {
						pwdId = c.login("Administrador", password, "Password");
						usrId = c.login("Administrador", usuario, "Usuario");
						
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null,
								"Error en el sistema",
								"¡Error!", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}
					
					if(pwdId.equals(usrId)) {
						frameInicio.hide();
						new Administrador();
					} else {
						try {
							pwdId = c.login("Empleado", password, "Password");
							usrId = c.login("Empleado", usuario, "Usuario");
							
							if(pwdId.equals(usrId)) {
								new Empleado(usuario);
								Inicio.tfPassword.setText("");
								Inicio.tfUsuario.setText("");
							} else {
								pwdId = c.login("Usuario", password, "Password");
								usrId = c.login("Usuario", usuario, "Usuario");
								
								if(pwdId.equals(usrId)) {
									if(c.registro("Usuario", usuario)) {
										JOptionPane.showMessageDialog(null,
												"Bienvenido " + usuario,
												"Aviso", JOptionPane.INFORMATION_MESSAGE);
									} else {
										JOptionPane.showMessageDialog(null,
												"Hasta pronto " + usuario,
												"Aviso", JOptionPane.INFORMATION_MESSAGE);
									}
									tfPassword.setText("");
									tfUsuario.setText("");
								} else {
									JOptionPane.showMessageDialog(null, "Datos incorrectos", "Mensaje", JOptionPane.ERROR_MESSAGE);
									tfPassword.setText("");
									tfUsuario.setText("");
								}
							}
						} catch (SQLException e1) {
							JOptionPane.showMessageDialog(null,
									"Error en el sistema", "¡Error!", JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Campos vacios", "Mensaje", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Campos vacios", "Mensaje", JOptionPane.ERROR_MESSAGE);
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
				new Inicio();
			}
		});
	}
}
