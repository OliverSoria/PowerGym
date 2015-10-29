
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

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Administrador extends JFrame implements ActionListener {
	JFrame frameAdmin;
	JPanel panelAdmin;
	JButton altaEmpleado;
	JButton altaUsuario;
	JButton altaAdministrador;
	JButton consultaEmpleados;
	JButton consultaUsuaios;
	JButton consultaAdministrador;
	JButton bajaEmpleado;
	JButton bajaUsuario;
	JButton bajaAdministrador;
	JButton modificarEmpleado;
	JButton modificarUsuario;
	JButton modificarAdministrador;
	JButton nominaEmpleado;
	JButton accesos;
	JButton regresar;

	Administrador() {
		myAdministrador();
	}
	
	void myAdministrador() {
		frameAdmin = new JFrame("Administrador");
		panelAdmin = new JPanel();
		// Medidas de los marcos del rededor
		panelAdmin.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
		// Numero de filas, columnas, interlineado horizontal, interlineado vertical
		panelAdmin.setLayout(new GridLayout(5, 20, 40, 40));
		frameAdmin.setResizable(false);
		// Medidas de la ventana
		frameAdmin.setSize(900, 400);
		frameAdmin.setVisible(true);
		frameAdmin.setLocationRelativeTo(null);
		frameAdmin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		altaEmpleado = new JButton("Alta de Empleados");
		altaUsuario = new JButton("Alta de Usuarios");
		altaAdministrador = new JButton("Alta de Administradores");
		consultaEmpleados = new JButton("Consultar Empleados");
		consultaUsuaios = new JButton("Consultar Usuarios");
		consultaAdministrador = new JButton("Consultar Administradores");
		bajaEmpleado = new JButton("Baja de Empleados");
		bajaUsuario = new JButton("Baja de Usuarios");
		bajaAdministrador = new JButton("Baja de Administrador");
		modificarUsuario = new JButton("Modificar Usuario");
		modificarEmpleado = new JButton("Modificar Empleado");
		modificarAdministrador = new JButton("Modificar Administrador");
		nominaEmpleado = new JButton("Nomina de Empleados");
		accesos = new JButton("Historial de Accesos");
		regresar = new JButton("Regresar");
		
		altaEmpleado.addActionListener(this);
		altaUsuario.addActionListener(this);
		altaAdministrador.addActionListener(this);
		
		consultaEmpleados.addActionListener(this);
		consultaUsuaios.addActionListener(this);
		consultaAdministrador.addActionListener(this);
		
		bajaEmpleado.addActionListener(this);
		bajaUsuario.addActionListener(this);
		bajaAdministrador.addActionListener(this);
		
		modificarUsuario.addActionListener(this);
		modificarEmpleado.addActionListener(this);
		modificarAdministrador.addActionListener(this);
		
		nominaEmpleado.addActionListener(this);
		accesos.addActionListener(this);
		regresar.addActionListener(this);
				
		panelAdmin.add(altaEmpleado);
		panelAdmin.add(altaUsuario);
		panelAdmin.add(altaAdministrador);
		
		panelAdmin.add(consultaEmpleados);
		panelAdmin.add(consultaUsuaios);
		panelAdmin.add(consultaAdministrador);
		
		panelAdmin.add(modificarUsuario);
		panelAdmin.add(modificarEmpleado);
		panelAdmin.add(modificarAdministrador);
		
		panelAdmin.add(bajaEmpleado);
		panelAdmin.add(bajaUsuario);
		panelAdmin.add(bajaAdministrador);
		
		panelAdmin.add(nominaEmpleado);
		panelAdmin.add(accesos);
		panelAdmin.add(regresar);
		
		frameAdmin.add(panelAdmin);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Alta de Empleados")) {
			new Alta("Empleado");
		} else if (e.getActionCommand().equals("Alta de Usuarios")) {
			new Alta("Usuario");
		} else if (e.getActionCommand().equals("Alta de Administradores")) {
			new Alta("Administrador");
		} else if (e.getActionCommand().equals("Consultar Empleados")) {
			new Consulta("Empleado");
		} else if (e.getActionCommand().equals("Consultar Usuarios")) {
			new Consulta("Usuario");
		} else if (e.getActionCommand().equals("Consultar Administradores")) {
			new Consulta("Administrador");
		} else if (e.getActionCommand().equals("Baja de Empleados")) {
			new Buscar("Empleado", "Baja");
		} else if (e.getActionCommand().equals("Baja de Usuarios")) {
			new Buscar("Usuario", "Baja");
		} else if (e.getActionCommand().equals("Baja de Administrador")) {
			new Buscar("Administrador", "Baja");
		} else if (e.getActionCommand().equals("Modificar Usuario")) {
			new Buscar("Usuario", "Modificar");
		} else if (e.getActionCommand().equals("Modificar Empleado")) {
			new Buscar("Empleado", "Modificar");
		} else if (e.getActionCommand().equals("Modificar Administrador")) {
			new Buscar("Administrador", "Modificar");
		} else if (e.getActionCommand().equals("Nomina de Empleados")) {
			JOptionPane.showMessageDialog(null, "Nomina en construccion", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		} else if (e.getActionCommand().equals("Historial de Accesos")) {
			new Historial();
		} else if (e.getActionCommand().equals("Regresar")) {
			frameAdmin.dispose();
			Inicio.tfUsuario.setText("");
			Inicio.tfPassword.setText("");
			Inicio.frameInicio.show();
		}
	}
		
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Administrador();
			}
		
		});
	}
}
