package Interfaz;


import javax.swing.JFrame;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Control.LicenciaJSON;
import Control.TitularJSON;
import Entidad.Licencia;
import Entidad.Titular;
import Utils.Impresion;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

@SuppressWarnings({ "serial", "deprecation" })
public class EmitirLicencia extends JDialog{

	private JTable table;
	private JTextField textField;
	private Integer vigenciacalculada;
	private Integer costo_calculado;
	private boolean se_emitio;
	private Titular nuevo_titular;
	private Licencia nueva_licencia;
	private boolean se_toco_clases;
	private boolean se_genero_comprobante;
	
	
	public EmitirLicencia(JFrame principal, Titular titularentrada, boolean[] claseselegidas) {
		super(principal);
		nuevo_titular = titularentrada;
		vigenciacalculada=0;
		se_emitio = false;
		se_toco_clases = true;
		se_genero_comprobante = false;
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
			@Override
			public boolean isCellEditable(int row, int column) {
				if(se_emitio)
					return false;
				return super.isCellEditable(row, column);
			}
		
		};
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 100, 500, 417, 209, 100, 0, 0};
		gridBagLayout.rowHeights = new int[]{20, 0, 238, 63, 0, 44, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNombreYApellido = new JLabel("Nombre y Apellido:");
		lblNombreYApellido.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNombreYApellido = new GridBagConstraints();
		gbc_lblNombreYApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreYApellido.gridx = 1;
		gbc_lblNombreYApellido.gridy = 1;
		getContentPane().add(lblNombreYApellido, gbc_lblNombreYApellido);
		
		JLabel label = new JLabel(nuevo_titular.getApellidos()+", "+nuevo_titular.getNombres());
		label.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 2;
		gbc_label.gridy = 1;
		getContentPane().add(label, gbc_label);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridwidth = 5;
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 2;
		getContentPane().add(panel_2, gbc_panel_2);
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1437, 233);
		panel_2.add(scrollPane);
		scrollPane.setAutoscrolls(true);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		table.setModel(model);
		table.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
		        int col = table.columnAtPoint(e.getPoint());
		        if(col==2) se_toco_clases = true;
			}
		});
		
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
		
		btnCalcularVigencia.setPreferredSize(new Dimension(200, 40));
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
		
		btnCalcularVigencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vigenciacalculada = new TitularJSON().calcularVigencia(nuevo_titular);
				lblNewLabel.setText(vigenciacalculada+" años");
			}
		});
		
		
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
		btnCalcularCosto.setPreferredSize(new Dimension(200, 40));
		btnCalcularCosto.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_btnCalcularCosto = new GridBagConstraints();
		gbc_btnCalcularCosto.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnCalcularCosto.insets = new Insets(0, 0, 0, 5);
		gbc_btnCalcularCosto.gridx = 1;
		gbc_btnCalcularCosto.gridy = 0;
		JLabel lblNewLabel_1 = new JLabel("Example $100");
		btnCalcularCosto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(vigenciacalculada==0) {
					JOptionPane.showMessageDialog(null, "¡Falta calcular la vigencia!");
					return;
				}
				se_toco_clases = false;
				String str = "";
				str += (boolean)table.getValueAt(0, 2)? "A," : "";
				str += (boolean)table.getValueAt(1, 2)? "B," : "";
				str += (boolean)table.getValueAt(2, 2)? "C," : "";
				str += (boolean)table.getValueAt(3, 2)? "D," : "";
				str += (boolean)table.getValueAt(4, 2)? "E," : "";
				str += (boolean)table.getValueAt(5, 2)? "F," : "";
				str += (boolean)table.getValueAt(6, 2)? "G," : "";
				str = str.substring(0, str.length()-1);
				
				costo_calculado = new TitularJSON().calcularCosto(str,vigenciacalculada);
				lblNewLabel_1.setText("$ " + costo_calculado );
			}
		});
		panel_1.add(btnCalcularCosto, gbc_btnCalcularCosto);
		
		
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
		lblObservaciones.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_lblObservaciones = new GridBagConstraints();
		gbc_lblObservaciones.anchor = GridBagConstraints.EAST;
		gbc_lblObservaciones.insets = new Insets(0, 0, 5, 5);
		gbc_lblObservaciones.gridx = 1;
		gbc_lblObservaciones.gridy = 4;
		getContentPane().add(lblObservaciones, gbc_lblObservaciones);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 4;
		getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnEmitir = new JButton("Emitir");
		btnEmitir.setPreferredSize(new Dimension(110, 40));
		btnEmitir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!(boolean)table.getValueAt(0, 2)
						&& !(boolean)table.getValueAt(1, 2)
						&& !(boolean)table.getValueAt(2, 2)
						&& !(boolean)table.getValueAt(3, 2)
						&& !(boolean)table.getValueAt(4, 2)
						&& !(boolean)table.getValueAt(5, 2)
						&& !(boolean)table.getValueAt(6, 2)) {
					JOptionPane.showMessageDialog(null, "¡Debe seleccionar al menos una clase!");
					return;
				}
				if(vigenciacalculada==0) {
					JOptionPane.showMessageDialog(null, "¡Falta calcular la vigencia!");
					return;
				}
				if(se_toco_clases) {
					JOptionPane.showMessageDialog(null, "¡Falta calcular el COSTO!");
					return;
				}
				String str = "";
				str += (boolean)table.getValueAt(0, 2)? "A," : "";
				str += (boolean)table.getValueAt(1, 2)? "B," : "";
				str += (boolean)table.getValueAt(2, 2)? "C," : "";
				str += (boolean)table.getValueAt(3, 2)? "D," : "";
				str += (boolean)table.getValueAt(4, 2)? "E," : "";
				str += (boolean)table.getValueAt(5, 2)? "F," : "";
				str += (boolean)table.getValueAt(6, 2)? "G," : "";
				str = str.substring(0, str.length()-1);
				
				if(!new TitularJSON().edadSuficiente(titularentrada, 
						str)) {
					JOptionPane.showMessageDialog(null, "¡La edad no es suficiente para las clases elegida!");
					return;
				}
				
				
				nuevo_titular.setClases(str);	
				nuevo_titular = new TitularJSON().crear(nuevo_titular);
				nueva_licencia = new LicenciaJSON().crear(nuevo_titular.getId_titular(),nuevo_titular.getClases(),0,5,textField.getText());
				
				JOptionPane.showMessageDialog(null, "Se creó un nuevo titular y se emitió una licencia");
				se_emitio = true;
				btnCalcularVigencia.setEnabled(false);
				btnCalcularCosto.setEnabled(false);
				btnEmitir.setEnabled(false);
				textField.setEditable(false);
				
			}
		});
		btnEmitir.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_btnEmitir = new GridBagConstraints();
		gbc_btnEmitir.anchor = GridBagConstraints.EAST;
		gbc_btnEmitir.insets = new Insets(0, 0, 0, 5);
		gbc_btnEmitir.gridx = 2;
		gbc_btnEmitir.gridy = 5;
		getContentPane().add(btnEmitir, gbc_btnEmitir);
		
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
		model.addColumn("Clase");
		model.addColumn("Descripcion");
		model.addColumn("");
		for(int i=0;i<7;i++) {
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
		
		table.getColumnModel().getColumn(1).setMaxWidth(1400);
		table.getColumnModel().getColumn(2).setMaxWidth(30);
		table.setFont(new Font("Arial", Font.PLAIN, 20));
		table.setRowHeight(30);
		
		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.setPreferredSize(new Dimension(110, 40));
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!se_emitio) {
					JOptionPane.showMessageDialog(null, "¡Se debe emitir la licencia primero!");
					return;
				}
				if(!se_genero_comprobante) {
					JOptionPane.showMessageDialog(null, "¡Se debe generar el comprobante de pago primero!");
					return;
				}

				try {
					String f = new File("").getCanonicalPath();
					f = f.replace("\\", "\\"+"\\");
					f+= "\\"+"\\"+"src"+"\\"+"\\"+"Imagenes"+"\\"+"\\";
					HashMap<String, Object> parameter = new HashMap<String, Object>();
					parameter.put("pathFrente",f+"FrenteLicencia.jpg");
					parameter.put("pathAtras",f+"ParteAtras.jpg");
					
					String ubicacion_jasper = "src/Utils/Licenciafrentratras.jasper";//Cambiar por el nombre de .jasper
					String nombre_pdf = "Licencia "+nuevo_titular.getApellidos()+", "+nuevo_titular.getNombres()+".pdf";
					
					Impresion imp = new Impresion();
					imp.setting(nuevo_titular, nueva_licencia,costo_calculado);
					JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(ubicacion_jasper);
					JasperPrint jasperprint = JasperFillManager.fillReport(report, parameter, imp);
					JRPdfExporter exporter = new JRPdfExporter();  
			        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperprint);
			        String myDocumentPath = System.getProperty("user.home") + "\\Documents";
			        myDocumentPath = myDocumentPath.replace("\\", "\\"+"\\");
			        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(myDocumentPath+"\\"+"\\"+nombre_pdf)); //Cambiar por el nombre del pdf que se generará
			        exporter.exportReport();
			        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+myDocumentPath+"\\"+"\\"+nombre_pdf);
				} catch (JRException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		JButton btnNewButton = new JButton("Generar Comprobante");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(!se_emitio) {
					JOptionPane.showMessageDialog(null, "¡Se debe emitir la licencia primero!");
					return;
				}
				se_genero_comprobante = true;
				try {
					String f = new File("").getCanonicalPath();
					f = f.replace("\\", "\\"+"\\");
					f+= "\\"+"\\"+"src"+"\\"+"\\"+"Imagenes"+"\\"+"\\"+"generarComprobante.jpg";
					HashMap<String, Object> parameter = new HashMap<String, Object>();
					parameter.put("path",f);
					
					String ubicacion_jasper = "src/Utils/Generar.jasper";//Cambiar por el nombre de .jasper
					String nombre_pdf = "Comprobante de Pago - "+nuevo_titular.getApellidos()+", "+nuevo_titular.getNombres()+".pdf";
					
					Impresion imp = new Impresion();
					imp.setting(nuevo_titular, nueva_licencia,costo_calculado);
					JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(ubicacion_jasper);
					JasperPrint jasperprint = JasperFillManager.fillReport(report, parameter, imp);
					JRPdfExporter exporter = new JRPdfExporter();  
			        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperprint); 
			        String myDocumentPath = System.getProperty("user.home") + "\\Documents";
			        myDocumentPath = myDocumentPath.replace("\\", "\\"+"\\");
			        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(myDocumentPath+"\\"+"\\"+nombre_pdf)); //Cambiar por el nombre del pdf que se generará
			        exporter.exportReport();
			        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+myDocumentPath+"\\"+"\\"+nombre_pdf);
				} catch (JRException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setPreferredSize(new Dimension(250, 40));
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 5;
		getContentPane().add(btnNewButton, gbc_btnNewButton);
		btnImprimir.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_btnImprimir = new GridBagConstraints();
		gbc_btnImprimir.insets = new Insets(0, 0, 0, 5);
		gbc_btnImprimir.gridx = 5;
		gbc_btnImprimir.gridy = 5;
		getContentPane().add(btnImprimir, gbc_btnImprimir);
		
		pack();
	}

}
