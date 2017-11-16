package Interfaz;


import javax.swing.JFrame;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Control.LicenciaJSON;
import Entidad.Licencia;
import Entidad.Titular;
import javax.swing.JButton;
import javax.swing.JPanel;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class ListadosDeLicencias extends JDialog{

	private JTable table;
	private ArrayList <Licencia> licenciasExpiradas = null;
	private ArrayList <Titular> titularesLicenciasExpiradas = null;
	
	public ListadosDeLicencias(JFrame principal) {
		super(principal);
		

		setTitle("Listado de Licencias");
	

			
		DefaultTableModel  model = new  DefaultTableModel() {
			@Override
			public Class<?> getColumnClass(int column) 
			{
				switch(column) {
					case 0:
						return String.class;
					case 1:
						return String.class;
					case 2:
						return String.class;
					case 3:
						return String.class;
					case 4:
						return String.class;
					case 5:
						return String.class;
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
		
		JLabel lblNombreYApellido = new JLabel("Listado de licencias que han expirado");
		lblNombreYApellido.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNombreYApellido = new GridBagConstraints();
		gbc_lblNombreYApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreYApellido.gridx = 1;
		gbc_lblNombreYApellido.gridy = 1;
		getContentPane().add(lblNombreYApellido, gbc_lblNombreYApellido);
		
		
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 2;
		gbc_label.gridy = 1;
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LicenciaJSON lj = new LicenciaJSON();
				licenciasExpiradas = lj.buscarLicenciasExpiradas();
				titularesLicenciasExpiradas = lj.buscarTitularesConLicenciasExpiradas(licenciasExpiradas);
				

			
				for(int i=0; i<licenciasExpiradas.size(); i++)
		        {
		        	model.addRow(new Object [] {"","","","","",""});			
						model.setValueAt(titularesLicenciasExpiradas.get(i).getTipo_DNI(), i, 0);
						model.setValueAt(titularesLicenciasExpiradas.get(i).getDNI(), i, 1);
						model.setValueAt(titularesLicenciasExpiradas.get(i).getNombres()+" "+
								titularesLicenciasExpiradas.get(i).getApellidos(), i, 2);
						model.setValueAt(licenciasExpiradas.get(i).getClases(), i, 3);
						model.setValueAt(licenciasExpiradas.get(i).getFecha_emision(), i, 4);
						model.setValueAt(licenciasExpiradas.get(i).getFin_vigencia(), i, 5);
		       }
			}
		});
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuscar.gridx = 2;
		gbc_btnBuscar.gridy = 1;
		getContentPane().add(btnBuscar, gbc_btnBuscar);
		
		
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
		scrollPane.setBounds(0, 0, 1250, 311);
		panel_2.add(scrollPane);
		scrollPane.setAutoscrolls(true);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		table.setModel(model);
		
				
	
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setPreferredSize(new Dimension(110, 40));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.anchor = GridBagConstraints.WEST;
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.gridx = 3;
		gbc_btnCancelar.gridy = 5;
		getContentPane().add(btnCancelar, gbc_btnCancelar);
		model.addColumn("Tipo DNI");
		model.addColumn("DNI");
		model.addColumn("Nombre y Apellido");
		model.addColumn("Clase solicitada");
		model.addColumn("Fecha de emisión");
		model.addColumn("Fecha de expiración");
		
		
		

	
	//	table.getColumnModel().getColumn(0).setMaxWidth(100);
		DefaultTableCellRenderer def = new DefaultTableCellRenderer();
		def.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(def);
		
		//table.getColumnModel().getColumn(1).setMaxWidth(1200);
		//table.getColumnModel().getColumn(2).setMaxWidth(30);
		table.setFont(new Font("Arial", Font.PLAIN, 20));
		table.setRowHeight(30);
		
		
		
		
		pack();
	}

}
