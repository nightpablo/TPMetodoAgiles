package Interfaz;


import javax.swing.JFrame;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Control.LicenciaJSON;
import Control.TitularJSON;
import Entidad.Titular;

import javax.swing.JButton;
import javax.swing.JPanel;

import javax.swing.border.TitledBorder;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class EmitirLicencia extends JDialog{

	private JTable table;
	private JTextField textField;

	public EmitirLicencia(JFrame principal, Titular titularentrada, boolean[] claseselegidas) {
		super(principal);
		setTitle("Emision de licencia");
	
		
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
		gridBagLayout.rowHeights = new int[]{20, 0, 238, 63, 0, 44, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNombreYApellido = new JLabel("Nombre y Apellido:");
		GridBagConstraints gbc_lblNombreYApellido = new GridBagConstraints();
		gbc_lblNombreYApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreYApellido.gridx = 1;
		gbc_lblNombreYApellido.gridy = 1;
		getContentPane().add(lblNombreYApellido, gbc_lblNombreYApellido);
		
		JLabel label = new JLabel(titularentrada.getApellidos()+", "+titularentrada.getNombres());
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 2;
		gbc_label.gridy = 1;
		getContentPane().add(label, gbc_label);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridwidth = 4;
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 2;
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
		
		JLabel lblNewLabel = new JLabel("Example 5 a\u00F1os");
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
		gbc_panel.gridy = 3;
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
		gbc_panel_1.gridy = 3;
		getContentPane().add(panel_1, gbc_panel_1);
		
		JLabel lblObservaciones = new JLabel("Observaciones:");
		GridBagConstraints gbc_lblObservaciones = new GridBagConstraints();
		gbc_lblObservaciones.anchor = GridBagConstraints.EAST;
		gbc_lblObservaciones.insets = new Insets(0, 0, 5, 5);
		gbc_lblObservaciones.gridx = 1;
		gbc_lblObservaciones.gridy = 4;
		getContentPane().add(lblObservaciones, gbc_lblObservaciones);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 4;
		getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton button = new JButton("Imprimir");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Titular i = new TitularJSON().crear(titularentrada);
				new LicenciaJSON().crear(i.getId_titular(),i.getClases(),0,i.getFecha_nac(),5,textField.getText());
				
				JOptionPane.showMessageDialog(null, "Se creó un nuevo titular y se emitió una licencia");
				dispose();
			}
		});
		button.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.anchor = GridBagConstraints.EAST;
		gbc_button.insets = new Insets(0, 0, 0, 5);
		gbc_button.gridx = 2;
		gbc_button.gridy = 5;
		getContentPane().add(button, gbc_button);
		
		JButton button_1 = new JButton("Cancelar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button_1.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 0, 5);
		gbc_button_1.anchor = GridBagConstraints.WEST;
		gbc_button_1.gridx = 3;
		gbc_button_1.gridy = 5;
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
