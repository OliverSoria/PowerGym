
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
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Alta extends JFrame implements ActionListener{
	String identificador;
	JFrame frameAlta;
	JTextField tfNombre;
	JTextField tfApellido;
	JTextField tfTelefono;
	JTextField tfDireccion;
	JTextField tfCorreo;
	JTextField tfId;
	JPasswordField tfPassword;
	JButton aceptar;
	JButton cancelar;

	Alta(String identificador) {
		this.identificador = identificador;
		myAltaEmpleado(identificador);
	}
	
	void myAltaEmpleado(String identificador) {
		frameAlta = new JFrame();
		frameAlta.setLayout(null);
		frameAlta.setResizable(false);
		frameAlta.setTitle("Alta de " + identificador);
		// Medidas de la ventana
		frameAlta.setSize(320, 400);
		frameAlta.setVisible(true);
		frameAlta.setLocationRelativeTo(null);
		frameAlta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel lblnombre = new JLabel("Nombre");
		JLabel lblapellido = new JLabel("Apellido");
		JLabel lbltelefono = new JLabel("Teléfono");
		JLabel lbldireccion = new JLabel("Dirección");
		JLabel lblcorreo = new JLabel("E-mail");
		JLabel lblid = new JLabel("Usuario");
		JLabel lblpassword = new JLabel("Contraseña");
		
		tfNombre = new JTextField();
		tfApellido = new JTextField();
		tfTelefono = new JTextField();
		tfDireccion = new JTextField();
		tfCorreo = new JTextField();
		tfId = new JTextField();
		tfPassword = new JPasswordField();
				
		aceptar = new JButton("Aceptar");
		cancelar = new JButton("Cancelar");
				
		aceptar.addActionListener(this);
		cancelar.addActionListener(this);
		
		// Medidas de las etiquetas
		lblnombre.setBounds(40, 10, 120, 20);
		lblapellido.setBounds(40, 50, 120, 20);
		lbltelefono.setBounds(40, 90, 120, 20);
		lbldireccion.setBounds(40, 130, 120, 20);
		lblcorreo.setBounds(40, 170, 120, 20);
		lblid.setBounds(40, 210, 120, 20);
		lblpassword.setBounds(40,250, 120, 20);
		
		// Medidas de los campos de texto
		tfNombre.setBounds(100, 10, 180, 20);
		tfApellido.setBounds(100, 50, 180, 20);
		tfTelefono.setBounds(100, 90, 180, 20);
		tfDireccion.setBounds(100, 130, 180, 20);
		tfCorreo.setBounds(100, 170, 180, 20);
		tfId.setBounds(100, 210, 180, 20);
		tfPassword.setBounds(100, 250, 180, 20);
		
		//Medidas de los botones
		cancelar.setBounds(65, 310, 80, 30);
		aceptar.setBounds(180, 310, 80, 30);
		
		frameAlta.add(lblnombre);
		frameAlta.add(lblapellido);
		frameAlta.add(lbltelefono);
		frameAlta.add(lbldireccion);
		frameAlta.add(lblcorreo);
		frameAlta.add(lblpassword);
		frameAlta.add(lblid);
		frameAlta.add(tfNombre);
		frameAlta.add(tfApellido);
		frameAlta.add(tfTelefono);
		frameAlta.add(tfDireccion);
		frameAlta.add(tfCorreo);
		frameAlta.add(tfId);
		frameAlta.add(tfPassword);
		frameAlta.add(aceptar);
		frameAlta.add(cancelar);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Cancelar")) {
			frameAlta.dispose();
		} else if(e.getActionCommand().equals("Aceptar")) {
			String nombre = tfNombre.getText();
			String apellido = tfApellido.getText();
			String telefono = tfTelefono.getText();
			String direccion = tfDireccion.getText();
			String correo = tfCorreo.getText();
			String id = tfId.getText();
			String password = tfPassword.getText();
			
			Conexion c = new Conexion();
			
			if(!tfNombre.getText().equals("")) {
				if(!tfApellido.getText().equals("")) {
					if(!tfTelefono.getText().equals("")) {
						if(!tfDireccion.getText().equals("")) {
							if(!tfCorreo.getText().equals("")) {
								if(!tfId.getText().equals("")) {
									if(!tfId.getText().equals("")) {
										try {
											c.alta(identificador, nombre, apellido, telefono, direccion, correo, id, password);
											JOptionPane.showMessageDialog(null,
													"Alta exitosa",
													"Aviso", JOptionPane.INFORMATION_MESSAGE);
											tfNombre.setText("");
											tfApellido.setText("");
											tfTelefono.setText("");
											tfDireccion.setText("");
											tfCorreo.setText("");
											tfId.setText("");
											tfPassword.setText("");
										} catch (SQLException e1) {
											JOptionPane.showMessageDialog(null,
													"Error en el sistema",
													"¡Error!", JOptionPane.ERROR_MESSAGE);
											tfNombre.setText("");
											tfApellido.setText("");
											tfTelefono.setText("");
											tfDireccion.setText("");
											tfCorreo.setText("");
											tfPassword.setText("");
											tfId.setText("");
											e1.printStackTrace();
										}
									}
								} else {
									JOptionPane.showMessageDialog(null,
											"No deje campos vacíos",
											"¡Error!", JOptionPane.ERROR_MESSAGE);
								}
							}  else {
								JOptionPane.showMessageDialog(null,
										"No deje campos vacíos",
										"¡Error!", JOptionPane.ERROR_MESSAGE);
							}
						}  else {
							JOptionPane.showMessageDialog(null,
									"No deje campos vacíos",
									"¡Error!", JOptionPane.ERROR_MESSAGE);
						}
					}  else {
						JOptionPane.showMessageDialog(null,
								"No deje campos vacíos",
								"¡Error!", JOptionPane.ERROR_MESSAGE);
					}
				}  else {
					JOptionPane.showMessageDialog(null,
							"No deje campos vacíos",
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
				new Alta("Administrador");
			}
		});
	}
}
