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
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Checkbox;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class EmitirLicencia extends JDialog{

	private JTable table;
	private JTextField textField;
	private Integer vigenciacalculada;
	private Integer costocalculado;
	private boolean se_emitio;
	private Titular nuevo_titular;
	private Licencia nueva_licencia;
	private Integer fecha_nacimiento;
	private Integer edad;
	private Checkbox a;
	private Checkbox b;
	private Checkbox c;
	private Checkbox d;
	private Checkbox e;
	private Checkbox f;
	private Checkbox g; 
	
	public EmitirLicencia(JFrame principal, Titular titularentrada, boolean[] claseselegidas) {
		super(principal);
		nuevo_titular = titularentrada;
		vigenciacalculada=0;
		costocalculado=0;
		se_emitio = false;
		setTitle("Emision de licencia");
		a = new Checkbox();
		b = new Checkbox();
		c = new Checkbox();
		d = new Checkbox();
		e = new Checkbox();
		f = new Checkbox();
		g = new Checkbox();
			
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
		gbc_panel_2.gridwidth = 4;
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 2;
		getContentPane().add(panel_2, gbc_panel_2);
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1250, 233);
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
		btnCalcularCosto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				costocalculado=1;
			}
		});
		btnCalcularCosto.setPreferredSize(new Dimension(200, 40));
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
				String str = "";
				str += (boolean)table.getValueAt(0, 2)? "A," : "";
				System.out.println(str);
				str += (boolean)table.getValueAt(1, 2)? "B," : "";
				System.out.println(str);
				str += (boolean)table.getValueAt(2, 2)? "C," : "";
				str += (boolean)table.getValueAt(3, 2)? "D," : "";
				str += (boolean)table.getValueAt(4, 2)? "E," : "";
				str += (boolean)table.getValueAt(5, 2)? "F," : "";
				str += (boolean)table.getValueAt(6, 2)? "G," : "";
				System.out.println(str);
				str = str.substring(0, str.length()-1);
				System.out.println(str);
				
				if(costocalculado==0)
				{
					JOptionPane.showMessageDialog(null, "¡Falta calcular el costo!");
					return;
				}
				
				//Validacion de las clases que pueden tener los titulares

				
			
				Date d = new Date();
				Calendar c = Calendar.getInstance();
				c.setTime(d);
			    Integer añoActual = c.get(Calendar.YEAR);
			    Integer mesActual = c.get(Calendar.MONTH)+1;
			    Integer diaActual = c.get(Calendar.DAY_OF_MONTH);
			    Integer añoNacimiento = Integer.parseInt(nuevo_titular.getFecha_nac().split("/")[2]);
			    Integer mesNacimiento = Integer.parseInt(nuevo_titular.getFecha_nac().split("/")[1]);
			    Integer diaNacimiento = Integer.parseInt(nuevo_titular.getFecha_nac().split("/")[0]);
			    
			   //System.out.println("Dia: "+ diaActual + "Mes: " + mesActual + "Año: "+ añoActual);
			   //System.out.println("DiaN: "+ diaNacimiento + "MesN: " + mesNacimiento+ "AñoN: "+ añoNacimiento);

			  //Validacion edad para clases C, D y E
			    //LLamar funcion controlarLicenciaProfesional
				if(str.contains("C")||str.contains("D")||str.contains("E"))
				{
					edad=añoActual-añoNacimiento;
					if(edad<21)
					{
						JOptionPane.showMessageDialog(null, "¡Para otorgar la/s licencia/s C, D o E debe ser mayor a 21 años!");
						return;
					}
					else if(edad==21 && mesActual<mesNacimiento)
					{
						JOptionPane.showMessageDialog(null, "¡Para otorgar la/s licencia/s C, D o E debe ser mayor a 21 años!");
						return;
					}
					else if(edad==21 && mesActual==mesNacimiento && diaActual<diaNacimiento)
					{
						JOptionPane.showMessageDialog(null, "¡Para otorgar la/s licencia/s C, D o E debe ser mayor a 21 años!");
						return;
					}
					else
					{
						LicenciaJSON lj = new LicenciaJSON();
						Boolean claseB =  lj.titularConAntiguedad(nuevo_titular, "B");
						if(claseB==false)
						{
							JOptionPane.showMessageDialog(null, "¡Para otorgar la/s licencia/s C, D o E debe tener "
									+ "antiguedad de por lo menos un año con clase B!");
							return;
						}
						
						if(edad>65)
						{
							Boolean claseC = lj.titularConAntiguedad(nuevo_titular, "C");
							Boolean claseD = lj.titularConAntiguedad(nuevo_titular, "D");
							Boolean claseE = lj.titularConAntiguedad(nuevo_titular, "E");
							
							if(claseC==false && claseD==false && claseE==false)
							{
								JOptionPane.showMessageDialog(null, "¡No se puede otorgar la/s licencia/s C, D o E a "
										+ "personas de más de 65 años por primera vez!");
								return;
							}
						}
						
					}
				}
				else
				{
					edad=añoActual-añoNacimiento;
					if(edad<17)
					{
						JOptionPane.showMessageDialog(null, "¡Para otorgar la/s licencia/s A, B, F o G debe ser mayor a 17 años!");
						return;
					}
					else if(edad==17 && mesActual<mesNacimiento)
					{
						JOptionPane.showMessageDialog(null, "¡Para otorgar la/s licencia/s A, B, F o G debe ser mayor a 17 años!");
						return;
					}
					else if(edad==17 && mesActual==mesNacimiento && diaActual<diaNacimiento)
					{
						JOptionPane.showMessageDialog(null, "¡Para otorgar la/s licencia/s A, B, F o G debe ser mayor a 17 años!");
						return;
					}
				}
				

				nuevo_titular.setClases(str);	
				nuevo_titular = new TitularJSON().crear(nuevo_titular);
				nueva_licencia = new LicenciaJSON().crear(nuevo_titular.getId_titular(),nuevo_titular.getClases(),0,nuevo_titular.getFecha_nac(),5,textField.getText());
				
				JOptionPane.showMessageDialog(null, "Se creó un nuevo titular y se emitió una licencia");
				se_emitio = true;
//				dispose();
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
		/*for(int i=0;i<7;i++) {
			model.addRow(new Object [] {"","",claseselegidas[i]});
		}*/
		
		
		model.addRow(new Object [] {"","",a.getState()});
		model.addRow(new Object [] {"","",b.getState()});
		model.addRow(new Object [] {"","",c.getState()});
		model.addRow(new Object [] {"","",d.getState()});
		model.addRow(new Object [] {"","",e.getState()});
		model.addRow(new Object [] {"","",f.getState()});
		model.addRow(new Object [] {"","",g.getState()});
		
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
		
		
		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.setPreferredSize(new Dimension(110, 40));
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!se_emitio) {
					JOptionPane.showMessageDialog(null, "¡Se debe emitir la licencia primero!");
					return;
				}

				try {
					String ubicacion_jasper = "src/Utils/report1.jasper";//Cambiar por el nombre de .jasper
					String nombre_pdf = "reporte1.pdf";
					
					Impresion imp = new Impresion();
					imp.setting(nuevo_titular, nueva_licencia);
					JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(ubicacion_jasper);
					JasperPrint jasperprint = JasperFillManager.fillReport(report, null, imp);
					JRPdfExporter exporter = new JRPdfExporter();  
			        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperprint); 
			        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(nombre_pdf)); //Cambiar por el nombre del pdf que se generará
			        exporter.exportReport();
			        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+nombre_pdf);
				} catch (JRException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnImprimir.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_btnImprimir = new GridBagConstraints();
		gbc_btnImprimir.insets = new Insets(0, 0, 0, 5);
		gbc_btnImprimir.gridx = 4;
		gbc_btnImprimir.gridy = 5;
		getContentPane().add(btnImprimir, gbc_btnImprimir);
		
		pack();
	}

}
