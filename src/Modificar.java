
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

public class Modificar extends JFrame implements ActionListener{
	String identificador;
	String id;
	JFrame frameAltaEmpleado;
	JTextField tfNombre;
	JTextField tfApellido;
	JTextField tfTelefono;
	JTextField tfDireccion;
	JTextField tfCorreo;
	JTextField tfId;
	JPasswordField tfPassword;
	JButton aceptar;
	JButton cancelar;

	Modificar(String identificador, String id) throws SQLException {
		this.identificador = identificador;
		this.id = id;
		myAltaEmpleado(identificador, id);
	}
	
	void myAltaEmpleado(String identificador, String id) throws SQLException {
		Conexion c = new Conexion();
		frameAltaEmpleado = new JFrame();
		frameAltaEmpleado.setTitle("Modificar " + identificador);
		frameAltaEmpleado.setLayout(null);
		frameAltaEmpleado.setResizable(false);
		// Medidas de la ventana
		frameAltaEmpleado.setSize(320, 400);
		frameAltaEmpleado.setVisible(true);
		frameAltaEmpleado.setLocationRelativeTo(null);
		frameAltaEmpleado.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
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
		
		tfNombre.setText(c.info(identificador, id, "Nombre"));
		tfApellido.setText(c.info(identificador, id, "Apellido"));
		tfTelefono.setText(c.info(identificador, id, "Telefono"));
		tfDireccion.setText(c.info(identificador, id, "Direccion"));
		tfCorreo.setText(c.info(identificador, id, "Correo"));
		tfId.setText(c.info(identificador, id, "Usuario"));
		tfPassword.setText(c.info(identificador, id, "Password"));
		
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
		
		frameAltaEmpleado.add(lblnombre);
		frameAltaEmpleado.add(lblapellido);
		frameAltaEmpleado.add(lbltelefono);
		frameAltaEmpleado.add(lbldireccion);
		frameAltaEmpleado.add(lblcorreo);
		frameAltaEmpleado.add(lblpassword);
		frameAltaEmpleado.add(lblid);
		frameAltaEmpleado.add(tfNombre);
		frameAltaEmpleado.add(tfApellido);
		frameAltaEmpleado.add(tfTelefono);
		frameAltaEmpleado.add(tfDireccion);
		frameAltaEmpleado.add(tfCorreo);
		frameAltaEmpleado.add(tfId);
		frameAltaEmpleado.add(tfPassword);
		frameAltaEmpleado.add(aceptar);
		frameAltaEmpleado.add(cancelar);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Cancelar")) {
			frameAltaEmpleado.dispose();
		} else if(e.getActionCommand().equals("Aceptar")) {
			String nombre = tfNombre.getText();
			String apellido = tfApellido.getText();
			String telefono = tfTelefono.getText();
			String direccion = tfDireccion.getText();
			String correo = tfCorreo.getText();
			String usuario = tfId.getText();
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
											c.modificar(identificador, id, nombre, apellido, telefono, direccion, correo, usuario, password);
											JOptionPane.showMessageDialog(null,
													"Modificación Exitosa",
													"Aviso", JOptionPane.INFORMATION_MESSAGE);
											frameAltaEmpleado.dispose();
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
				try {
					new Modificar("Usuario", "1");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}
