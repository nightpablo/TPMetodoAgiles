package Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JSplitPane;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;
import javax.swing.JDesktopPane;
import javax.swing.JEditorPane;
import javax.swing.JLabel;

public class InterfazPrueba {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazPrueba window = new InterfazPrueba();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfazPrueba() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 800, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Emision de licencia");
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(70, 80, 600, 200);
		
		 frame.getContentPane().add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Calcular vigencia de licencia", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Calcular costo de vigencia", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_2 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(61)
							.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
							.addGap(53))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
							.addGap(6)))
					.addGap(18))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(3)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(15))
		);
		
		JButton btnImprimir = new JButton("Imprimir");
		panel_2.add(btnImprimir);
		
		JButton btnCancelar = new JButton("Cancelar");
		panel_2.add(btnCancelar);
		
		JButton btnCalcularCosto = new JButton("Calcular Costo");
		panel_1.add(btnCalcularCosto);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		panel_1.add(lblNewLabel_1);
		
		JButton btnCalcularVigencia = new JButton("Calcular Vigencia");
		panel.add(btnCalcularVigencia);
		
		JLabel lblNewLabel = new JLabel("New label");
		panel.add(lblNewLabel);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		frame.getContentPane().setLayout(groupLayout);
	
		/*
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Clase A", "Ciclomotores motocicleta y triciclo motorizados",false},
				{"Clase B", "Automoviles y camionetas con acoplado",true},
				{"Clase C", "Camiones sin acoplados y los comprendidos en la clase B",true},
				{"Clase D", "Servicio de transporte y de pasajero emergencia seguridad y los comprendidos en la clase d o c segun el caso",true},
				{"Clase E", "Camiones articulados o con acoplado, maquinaria especial no agricola, y los comprendidos en la clase B y C",true},
				{"Clase F", "Automotores especialmente adaptado para discapacitados",true},
				{"Clase G", "Tractores agricolas y maquinaria especial agricola",true},
			},
			new String[] {
				"Clase", "Descripcion", " "
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
	*/
		
		DefaultTableModel  model = new  DefaultTableModel() {
			@Override
			public Class<?> getColumnClass(int column) {
				switch(column) {
				case 0:
				return String.class;
				case 1:
					return String.class;
				case 2:
					return Boolean.class;
				
				default: 
					return String.class;
				}
			}
		
		};
		
		table.setModel(model);
		model.addColumn("Clase");
		model.addColumn("Descripcion");
		model.addColumn("");
		for(int i=0;i<=6;i++) {
			model.addRow(new Object [0]);
			model.addRow(new Object [1]);
		}
		model.setValueAt("Clase A", 0, 0);
		model.setValueAt("Ciclomotores motocicleta y triciclo motorizados", 0, 1);
		model.setValueAt("Clase B", 1, 0);
		model.setValueAt("Automoviles y camionetas con acoplado", 1, 1);
		model.setValueAt("Clase C", 2, 0);
		model.setValueAt("Camiones sin acoplados y los comprendidos en la clase B", 2, 1);
		model.setValueAt("Clase D", 3, 0);
		model.setValueAt( "Servicio de transporte y de pasajero emergencia seguridad y los comprendidos en la clase d o c segun el caso", 3, 1);
		model.setValueAt("Clase E", 4, 0);
		model.setValueAt( "Camiones articulados o con acoplado, maquinaria especial no agricola, y los comprendidos en la clase B y C", 4, 1);
		model.setValueAt("Clase F", 5, 0);
		model.setValueAt("Automotores especialmente adaptado para discapacitados", 5, 1);
		model.setValueAt("Clase G", 6, 0);
		model.setValueAt("Tractores agricolas y maquinaria especial agricola", 6, 1);
	
	}

	private Container getContentPane() {
		// TODO Auto-generated method stub
		return null;
	}

	private void setTitle(String string) {
		// TODO Auto-generated method stub
		
	}



}
