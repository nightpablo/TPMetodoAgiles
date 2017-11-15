package Interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.*;

import Entidad.Titular;

public class MenuPrincipal extends JFrame {

	public JPanel panel;


	public MenuPrincipal() {
		super();
		setResizable(true);
		setSize(1380, 760);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		Home(); 
		} 

	private void Home() {
		
		getContentPane().removeAll();
		getContentPane().repaint();
		setTitle("Menu Principal");
		
		getContentPane().setLayout(null);
		
		JButton ayuda = new JButton(" AYUDA ");
		ayuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new EmitirLicencia(MenuPrincipal.this,new Titular(),new boolean[] {true, false, false, false, true, true,true}).setVisible(true);
			}
		});
		
		ayuda.setBounds(1197, 616, 115, 37);
		ayuda.setFont(new Font("Arial", Font.PLAIN, 14));
		ayuda.setForeground(SystemColor.desktop);
		getContentPane().add(ayuda);
		
		JLabel lblBienvenido = new JLabel("BIENVENIDO...");
		lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenido.setFont(new Font("Imprint MT Shadow", Font.BOLD, 38));
		lblBienvenido.setBounds(518, 317, 357, 37);
		getContentPane().add(lblBienvenido);
		
		JButton inicio = new JButton(" INICIO ");
		inicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		inicio.setFont(new Font("Times New Roman", Font.BOLD, 18));
		inicio.setBounds(1140, 34, 172, 57);
		getContentPane().add(inicio);
		inicio.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				AltaTitular altaTitular = new AltaTitular(MenuPrincipal.this);
				altaTitular.setVisible(true);
				
			}
		});
		
	
		
		
		JButton btnImg = new JButton("");
		btnImg.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Imagenes/licConducir.png")));
		btnImg.setSelectedIcon(new ImageIcon(MenuPrincipal.class.getResource("/Imagenes/licConducir.png")));
		btnImg.setFont(new Font("Arial", Font.PLAIN, 14));
		btnImg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnImg.setBounds(30, 34, 222, 193);
		getContentPane().add(btnImg);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(30, 506, 1268, 15);
		getContentPane().add(separator);
		
		JLabel lblSistemaDeEmision = new JLabel("Sistema de Emisi\u00F3n de Licencias");
		lblSistemaDeEmision.setFont(new Font("Sitka Heading", Font.ITALIC, 45));
		lblSistemaDeEmision.setBounds(394, 181, 631, 64);
		getContentPane().add(lblSistemaDeEmision);
		
		JLabel label_2 = new JLabel("   ");
		label_2.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Imagenes/SFC.png")));
		//label_2.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Imagenes/usuario.gif")));
		label_2.setBounds(-17, 520, 559, 118);
		getContentPane().add(label_2);
		
		JLabel lblWwwselicencecom = new JLabel("www.selicence.com");
		lblWwwselicencecom.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblWwwselicencecom.setForeground(new Color(0, 0, 128));
		lblWwwselicencecom.setBounds(1123, 679, 189, 14);
		getContentPane().add(lblWwwselicencecom);
		
		JLabel lblSelicence = new JLabel("Selicence");
		lblSelicence.setFont(new Font("Viner Hand ITC", Font.BOLD, 75));
		lblSelicence.setBounds(845, 518, 413, 86);
		getContentPane().add(lblSelicence);
		
		JLabel lblNewLabel = new JLabel("Aprendiendo Juntos...");
		lblNewLabel.setFont(new Font("Perpetua", Font.BOLD, 25));
		lblNewLabel.setBounds(844, 588, 259, 37);
		getContentPane().add(lblNewLabel);
		
		JButton btnListadoDeLicencias = new JButton("Listado de Licencias");
		btnListadoDeLicencias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListadosDeLicencias listadoDeLicencias = new ListadosDeLicencias(MenuPrincipal.this);
				listadoDeLicencias.setVisible(true);
				
			}
		});
		btnListadoDeLicencias.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnListadoDeLicencias.setBounds(1140, 118, 175, 57);
		getContentPane().add(btnListadoDeLicencias);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		inicio.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
