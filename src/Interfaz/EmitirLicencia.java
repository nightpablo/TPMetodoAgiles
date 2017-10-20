package Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.DefaultListCellRenderer;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import Entidad.Titular;

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
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class EmitirLicencia extends JDialog{

	private JTable table;

	public EmitirLicencia(JFrame principal, Titular titularentrada, boolean[] claseselegidas) {
		super(principal);
//		setBounds(200, 200, 800, 300);
		setTitle("Emision de licencia");
	
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
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 100, 500, 500, 100, 20, 0};
		gridBagLayout.rowHeights = new int[]{20, 238, 63, 44, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridwidth = 4;
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 1;
		getContentPane().add(panel_2, gbc_panel_2);
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1195, 233);
		panel_2.add(scrollPane);
		scrollPane.setAutoscrolls(true);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		table.setModel(model);
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.setBorder(new TitledBorder(null, "Calcular vigencia de licencia", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{20, 171, 10, 126, 0};
		gbl_panel.rowHeights = new int[]{31, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnCalcularVigencia = new JButton("Calcular Vigencia");
		btnCalcularVigencia.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_btnCalcularVigencia = new GridBagConstraints();
		gbc_btnCalcularVigencia.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnCalcularVigencia.insets = new Insets(0, 0, 0, 5);
		gbc_btnCalcularVigencia.gridx = 1;
		gbc_btnCalcularVigencia.gridy = 0;
		panel.add(btnCalcularVigencia, gbc_btnCalcularVigencia);
		
		JLabel lblNewLabel = new JLabel("Example dd/mm/aaaa");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 2;
		getContentPane().add(panel, gbc_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.setBorder(new TitledBorder(null, "Calcular costo de vigencia", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{20, 151, 10, 56, 0};
		gbl_panel_1.rowHeights = new int[]{31, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnCalcularCosto = new JButton("Calcular Costo");
		btnCalcularCosto.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_btnCalcularCosto = new GridBagConstraints();
		gbc_btnCalcularCosto.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnCalcularCosto.insets = new Insets(0, 0, 0, 5);
		gbc_btnCalcularCosto.gridx = 1;
		gbc_btnCalcularCosto.gridy = 0;
		panel_1.add(btnCalcularCosto, gbc_btnCalcularCosto);
		
		JLabel lblNewLabel_1 = new JLabel("Example $100");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 0;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.gridx = 3;
		gbc_panel_1.gridy = 2;
		getContentPane().add(panel_1, gbc_panel_1);
		
		JButton button = new JButton("Imprimir");
		button.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.anchor = GridBagConstraints.EAST;
		gbc_button.insets = new Insets(0, 0, 0, 5);
		gbc_button.gridx = 2;
		gbc_button.gridy = 3;
		getContentPane().add(button, gbc_button);
		
		JButton button_1 = new JButton("Cancelar");
		button_1.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 0, 5);
		gbc_button_1.anchor = GridBagConstraints.WEST;
		gbc_button_1.gridx = 3;
		gbc_button_1.gridy = 3;
		getContentPane().add(button_1, gbc_button_1);
		model.addColumn("Clase");
		model.addColumn("Descripcion");
		model.addColumn("");
		for(int i=0;i<7;i++) {
			System.out.println(claseselegidas[i]);
			model.addRow(new Object [] {"","",claseselegidas[i]});
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
	
		table.getColumnModel().getColumn(0).setMaxWidth(100);
		DefaultTableCellRenderer def = new DefaultTableCellRenderer();
		def.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(def);
		
		table.getColumnModel().getColumn(1).setMaxWidth(1200);
		table.getColumnModel().getColumn(2).setMaxWidth(30);
		table.setFont(new Font("Arial", Font.PLAIN, 20));
		table.setRowHeight(30);
		
		pack();
	}

}
