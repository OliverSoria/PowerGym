
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
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;


public class Historial extends JFrame implements ActionListener {
	JFrame frameConsulta;
	JTable tabla;
	JButton cerrar;
	
	Historial() {
		
		myConsultarEmpleados();
	}

	void myConsultarEmpleados() {
		String tablaDB = null;
		String titulo = null;		
				
		
		frameConsulta = new JFrame();
		frameConsulta.setTitle("Historial de Accesos");
		frameConsulta.setLayout(null);
		frameConsulta.setResizable(false);
		// Medidas de la ventana
		frameConsulta.setSize(650, 400);
		frameConsulta.setVisible(true);
		frameConsulta.setLocationRelativeTo(null);
		frameConsulta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		cerrar = new JButton("Cerrar");
		cerrar.addActionListener(this);
		
		// Medias del boton
		cerrar.setBounds(280, 320, 80, 30);
		
		frameConsulta.add(cerrar);
				
		Vector<Object> columnNames = new Vector<Object>();
        Vector<Object> data = new Vector<Object>();
        
        try {
        	String url = "jdbc:mysql://localhost/gym";
            String userid = "root";
            String password = "toor";
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection( url, userid, password );
           
            String sql = "select Identificacion, Usuario, Fecha, Hora, Estatus from historial";
         
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( sql );
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            for (int i = 1; i <= columns; i++) {
                columnNames.addElement( md.getColumnName(i) );
            }

            while (rs.next()) {
            	Vector<Object> row = new Vector<Object>(columns);

                for (int i = 1; i <= columns; i++) {
                    row.addElement( rs.getObject(i) );
                }

                data.addElement( row );
            }

            rs.close();
            stmt.close();
            connection.close();
        }
        catch(Exception ex) {
            System.out.println( ex + "   :D" );
        }

        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
        	@Override
            public Class getColumnClass(int column) {
                for (int row = 0; row < getRowCount(); row++) {
                    Object o = getValueAt(row, column);

                    if (o != null) {
                        return o.getClass();
                    }
                }

                return Object.class;
            }
        };
        
        tabla = new JTable(model);										
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);		
		JScrollPane scrollPane = new JScrollPane(tabla);					
        // Medidas de la tabla
		scrollPane.setBounds(10, 10, 620, 260);								
        frameConsulta.add(scrollPane);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Cerrar")) {
			frameConsulta.dispose();
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
				new Historial();
			}
		});
	}
}
