package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import control.Connection;
import control.Main;
import control.UserFunctions;

import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JComboBox;
import java.awt.FlowLayout;

public class WindowMenuUser extends JFrame{
	public JPanel panelMultiple;
	public JPanel panel_2;
	JPanel panelSonido;
	JPanel panelContenidoSonido;
	JPanel panelHumedad;
	JPanel panelPerfilUsuario;
	JPanel panelLuz;
	JPanel panelTemperatura;
	JComboBox comboBox;
	String []cmbxSexo = {"HOMBRE", "MUJER"};
	String nombre;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCorreo;
	private JTextField txtFechaN;
	
	UserFunctions uf = new UserFunctions();
	
	@SuppressWarnings("serial")
	public WindowMenuUser() throws IOException {
		setResizable(false);
		getContentPane().setLayout(null);
		setBounds(100, 100, 800, 600);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 784, 561);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBounds(0, 0, 270, 561);
		panelMenu.setBackground(new Color(13, 72, 162));
		panel.add(panelMenu);
		panelMenu.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(13, 72, 162));
		panel_1.setBounds(0, 0, 270, 101);
		panelMenu.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BaboonController");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Ebrima", Font.BOLD, 18));
		lblNewLabel.setBounds(0, 33, 270, 40);
		panel_1.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(40, 71, 190, 2);
		panel_1.add(separator);
		
		JPanel panelPerfil = new JPanel();
		panelPerfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelPerfil.setBackground(new Color(20, 101, 193));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelPerfil.setBackground(new Color(20, 91, 173));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				panelMultiple.removeAll();
				panelMultiple.repaint();
				panelMultiple.revalidate();
				panelPerfilUsuario.setVisible(true);
				panelMultiple.add(panelPerfilUsuario);
				consultPerfil();
			}
			
		});
		panelPerfil.setBackground(new Color(20, 91, 173));
		panelPerfil.setBounds(0, 210, 270, 60);
		panelMenu.add(panelPerfil);
		panelPerfil.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("PERFIL");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Ebrima", Font.BOLD, 16));
		lblNewLabel_1.setBounds(0, 0, 270, 60);
		panelPerfil.add(lblNewLabel_1);
		
		JPanel panelDeHumedad = new JPanel();
		panelDeHumedad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelDeHumedad.setBackground(new Color(20, 101, 193));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelDeHumedad.setBackground(new Color(20, 91, 173));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				panelMultiple.removeAll();
				panelMultiple.repaint();
				panelMultiple.revalidate(); 
				panelHumedad.setVisible(true);
				panelMultiple.add(panelHumedad);
				
			}
		});
		panelDeHumedad.setBackground(new Color(20, 91, 173));
		panelDeHumedad.setBounds(0, 271, 270, 60);
		panelMenu.add(panelDeHumedad);
		panelDeHumedad.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Datos de humedad");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Ebrima", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(0, 0, 270, 60);
		panelDeHumedad.add(lblNewLabel_1_1);
		
		panelSonido = new JPanel();
		
		panelSonido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelSonido.setBackground(new Color(20, 101, 193));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelSonido.setBackground(new Color(20, 91, 173));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				panelMultiple.removeAll();
				panelMultiple.repaint();
				panelMultiple.revalidate(); 
				panelContenidoSonido.setVisible(true);
				panelMultiple.add(panelContenidoSonido);
				
			}
		});
		panelSonido.setBackground(new Color(20, 91, 173));
		panelSonido.setBounds(0, 332, 270, 60);
		panelMenu.add(panelSonido);
		panelSonido.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Datos de sonido");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Ebrima", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(0, 0, 270, 60);
		panelSonido.add(lblNewLabel_1_1_1);
		
		JPanel panelExit = new JPanel();
		panelExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelExit.setBackground(new Color(20, 101, 193));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelExit.setBackground(new Color(20, 91, 173));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		panelExit.setBackground(new Color(20, 91, 173));
		panelExit.setBounds(0, 454, 270, 60);
		panelMenu.add(panelExit);
		panelExit.setLayout(null);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("SALIR");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Ebrima", Font.BOLD, 16));
		lblNewLabel_1_1_1_1.setBounds(0, 0, 270, 60);
		panelExit.add(lblNewLabel_1_1_1_1);
		
		JPanel panelDeLuz = new JPanel();
		panelDeLuz.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelDeLuz.setBackground(new Color(20, 101, 193));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelDeLuz.setBackground(new Color(20, 91, 173));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				panelMultiple.removeAll();
				panelMultiple.repaint();
				panelMultiple.revalidate();
				panelLuz.setVisible(true);
				panelMultiple.add(panelLuz);
				
			}
		});
		panelDeLuz.setLayout(null);
		panelDeLuz.setBackground(new Color(20, 91, 173));
		panelDeLuz.setBounds(0, 149, 270, 60);
		panelMenu.add(panelDeLuz);
		
		JLabel lblLuz = new JLabel("Datos de luz");
		lblLuz.setHorizontalAlignment(SwingConstants.CENTER);
		lblLuz.setForeground(Color.WHITE);
		lblLuz.setFont(new Font("Ebrima", Font.BOLD, 16));
		lblLuz.setBounds(0, 0, 270, 60);
		panelDeLuz.add(lblLuz);
		
		JPanel panelDeTemperatura = new JPanel();
		panelDeTemperatura.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelDeTemperatura.setBackground(new Color(20, 101, 193));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelDeTemperatura.setBackground(new Color(20, 91, 173));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				panelMultiple.removeAll();
				panelMultiple.repaint();
				panelMultiple.revalidate();
				panelTemperatura.setVisible(true);
				panelMultiple.add(panelTemperatura);
				
			}
		});
		panelDeTemperatura.setLayout(null);
		panelDeTemperatura.setBackground(new Color(20, 91, 173));
		panelDeTemperatura.setBounds(0, 393, 270, 60);
		panelMenu.add(panelDeTemperatura);
		
		JLabel lblTemperatura = new JLabel("Datos de temperatura");
		lblTemperatura.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemperatura.setForeground(Color.WHITE);
		lblTemperatura.setFont(new Font("Ebrima", Font.BOLD, 16));
		lblTemperatura.setBounds(0, 0, 270, 60);
		panelDeTemperatura.add(lblTemperatura);
		
		panelDeTemperatura.setLayout(null);
		panelDeTemperatura.setBackground(new Color(20, 91, 173));
		panelDeTemperatura.setBounds(0, 393, 270, 60);
		panelMenu.add(panelDeTemperatura);
		

		
		panelMultiple = new JPanel();
		panelMultiple.setBackground(Color.WHITE);
		panelMultiple.setBounds(269, 0, 515, 561);
		panel.add(panelMultiple);
		panelMultiple.setLayout(null);
		
		JPanel panelEst = new JPanel();
		panelEst.setLayout(null);
		panelEst.setBackground(new Color(25, 118, 209));
		panelEst.setBounds(0, 41, 515, 120);
		panelMultiple.add(panelEst);
		
		JLabel lblNewLabel_3_1 = new JLabel("Bienvenido a tu panel");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Ebrima", Font.BOLD, 18));
		lblNewLabel_3_1.setBounds(0, 0, 515, 119);
		panelEst.add(lblNewLabel_3_1);
		
		JPanel panelBnv = new JPanel();
		panelBnv.setBackground(Color.WHITE);
		panelBnv.setBounds(20, 182, 160, 44);
		panelMultiple.add(panelBnv);
		panelBnv.setLayout(null);
		
		JLabel lblBienvenido = new JLabel("Bienvenido");
		lblBienvenido.setBounds(0, 0, 160, 44);
		panelBnv.add(lblBienvenido);
		lblBienvenido.setFont(new Font("Ebrima", Font.BOLD, 18));
		
		panelContenidoSonido = new JPanel();
		panelContenidoSonido.setBackground(Color.WHITE);
		panelContenidoSonido.setBounds(0, 0, 515, 561);
		panelMultiple.add(panelContenidoSonido);
		panelContenidoSonido.setLayout(null);
		panelContenidoSonido.setVisible(false);
		
		JPanel panel_4_1_1 = new JPanel();
		panel_4_1_1.setBounds(0, 41, 515, 120);
		panel_4_1_1.setBackground(new Color(25, 118, 209));
		panelContenidoSonido.add(panel_4_1_1);
		panel_4_1_1.setLayout(null);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("DATOS DE SONIDO");
		lblNewLabel_3_1_1.setBounds(0, 0, 515, 119);
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_1.setFont(new Font("Ebrima", Font.BOLD, 18));
		panel_4_1_1.add(lblNewLabel_3_1_1);
		
		
		panelHumedad = new JPanel();
		panelHumedad.setBounds(0, 0, 515, 561);
		panelMultiple.add(panelHumedad);
		panelHumedad.setLayout(null);
		panelHumedad.setVisible(false);
		
		JPanel panelLblHumedad = new JPanel();
		panelLblHumedad.setBounds(0, 41, 515, 120);
		panelLblHumedad.setLayout(null);
		panelLblHumedad.setBackground(new Color(25, 118, 209));
		panelHumedad.add(panelLblHumedad);
		
		JLabel lblCarreras = new JLabel("DATOS HUMEDAD");
		lblCarreras.setHorizontalAlignment(SwingConstants.CENTER);
		lblCarreras.setForeground(Color.WHITE);
		lblCarreras.setFont(new Font("Ebrima", Font.BOLD, 18));
		lblCarreras.setBounds(0, 0, 515, 119);
		panelLblHumedad.add(lblCarreras);
		
		
		panelPerfilUsuario = new JPanel();
		panelPerfilUsuario.setBackground(Color.WHITE);
		panelPerfilUsuario.setBounds(0, 0, 515, 561);
		panelMultiple.add(panelPerfilUsuario);
		panelPerfilUsuario.setLayout(null);
		panelPerfilUsuario.setVisible(false);
		
		JPanel panelLblPerfil = new JPanel();
		panelLblPerfil.setBounds(0, 41, 515, 120);
		panelLblPerfil.setBackground(new Color(25, 118, 209));
		panelPerfilUsuario.add(panelLblPerfil);
		panelLblPerfil.setLayout(null);
		
		JLabel lblPerfil = new JLabel("PERFIL");
		lblPerfil.setHorizontalAlignment(SwingConstants.CENTER);
		lblPerfil.setBounds(0, 0, 515, 120);
		lblPerfil.setForeground(Color.WHITE);
		lblPerfil.setFont(new Font("Ebrima", Font.BOLD, 18));
		panelLblPerfil.add(lblPerfil);
		
		JPanel panelLblNombre = new JPanel();
		panelLblNombre.setBackground(Color.WHITE);
		panelLblNombre.setBounds(20, 181, 160, 25);
		panelPerfilUsuario.add(panelLblNombre);
		panelLblNombre.setLayout(null);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setFont(new Font("Ebrima", Font.BOLD, 16));
		lblNombre.setBounds(0, 0, 160, 25);
		panelLblNombre.add(lblNombre);
		
		JPanel paneltxtNombre = new JPanel();
		paneltxtNombre.setBounds(189, 181, 190, 25);
		panelPerfilUsuario.add(paneltxtNombre);
		paneltxtNombre.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Ebrima", Font.PLAIN, 16));
		txtNombre.setBorder(null);
		txtNombre.setBounds(0, 0, 190, 25);
		paneltxtNombre.add(txtNombre);
		txtNombre.setColumns(10);
		
		JSeparator separatorNombre = new JSeparator();
		separatorNombre.setBackground(Color.BLACK);
		separatorNombre.setBounds(189, 205, 170, 2);
		panelPerfilUsuario.add(separatorNombre);
		
		JPanel panelLblApellido = new JPanel();
		panelLblApellido.setLayout(null);
		panelLblApellido.setBackground(Color.WHITE);
		panelLblApellido.setBounds(20, 217, 160, 25);
		panelPerfilUsuario.add(panelLblApellido);
		
		JLabel lblApellido = new JLabel("APELLIDO");
		lblApellido.setFont(new Font("Ebrima", Font.BOLD, 16));
		lblApellido.setBounds(0, 0, 160, 25);
		panelLblApellido.add(lblApellido);
		
		JPanel paneltxtApellido = new JPanel();
		paneltxtApellido.setLayout(null);
		paneltxtApellido.setBounds(189, 217, 190, 25);
		panelPerfilUsuario.add(paneltxtApellido);
		
		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Ebrima", Font.PLAIN, 16));
		txtApellido.setColumns(10);
		txtApellido.setBorder(null);
		txtApellido.setBounds(0, 0, 190, 25);
		paneltxtApellido.add(txtApellido);
		
		JSeparator separatorNombre_1 = new JSeparator();
		separatorNombre_1.setBackground(Color.BLACK);
		separatorNombre_1.setBounds(189, 241, 170, 2);
		panelPerfilUsuario.add(separatorNombre_1);
		
		comboBox = new JComboBox(cmbxSexo);
		comboBox.setFont(new Font("Ebrima", Font.PLAIN, 14));
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(189, 253, 170, 25);
		panelPerfilUsuario.add(comboBox);
		
		JPanel panelLblSexo = new JPanel();
		panelLblSexo.setLayout(null);
		panelLblSexo.setBackground(Color.WHITE);
		panelLblSexo.setBounds(20, 253, 160, 25);
		panelPerfilUsuario.add(panelLblSexo);
		
		JLabel lblSexo = new JLabel("SEXO");
		lblSexo.setFont(new Font("Ebrima", Font.BOLD, 16));
		lblSexo.setBounds(0, 0, 160, 25);
		panelLblSexo.add(lblSexo);
		
		JPanel panelLblCorreo = new JPanel();
		panelLblCorreo.setLayout(null);
		panelLblCorreo.setBackground(Color.WHITE);
		panelLblCorreo.setBounds(20, 289, 160, 25);
		panelPerfilUsuario.add(panelLblCorreo);
		
		JLabel lblCorreo = new JLabel("CORREO");
		lblCorreo.setFont(new Font("Ebrima", Font.BOLD, 16));
		lblCorreo.setBounds(0, 0, 160, 25);
		panelLblCorreo.add(lblCorreo);
		
		JPanel panelLblFechaN = new JPanel();
		panelLblFechaN.setLayout(null);
		panelLblFechaN.setBackground(Color.WHITE);
		panelLblFechaN.setBounds(20, 325, 160, 25);
		panelPerfilUsuario.add(panelLblFechaN);
		
		JLabel lblFechaN = new JLabel("FECHA NACIMIENTO");
		lblFechaN.setFont(new Font("Ebrima", Font.BOLD, 16));
		lblFechaN.setBounds(0, 0, 160, 25);
		panelLblFechaN.add(lblFechaN);
		
		JPanel paneltxtCorreo = new JPanel();
		paneltxtCorreo.setLayout(null);
		paneltxtCorreo.setBounds(189, 289, 190, 25);
		panelPerfilUsuario.add(paneltxtCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setFont(new Font("Ebrima", Font.PLAIN, 16));
		txtCorreo.setColumns(10);
		txtCorreo.setBorder(null);
		txtCorreo.setBounds(0, 0, 190, 25);
		paneltxtCorreo.add(txtCorreo);
		
		JPanel paneltxtFechaN = new JPanel();
		paneltxtFechaN.setLayout(null);
		paneltxtFechaN.setBounds(189, 326, 190, 25);
		panelPerfilUsuario.add(paneltxtFechaN);
		
		txtFechaN = new JTextField();
		txtFechaN.setFont(new Font("Ebrima", Font.PLAIN, 16));
		txtFechaN.setColumns(10);
		txtFechaN.setBorder(null);
		txtFechaN.setBounds(0, 0, 190, 25);
		paneltxtFechaN.add(txtFechaN);
		
		JPanel panelGuardar = new JPanel();
		panelGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelGuardar.setBackground(new Color(20, 101, 193));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelGuardar.setBackground(new Color(20, 91, 173));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				JSONObject obj = new JSONObject();
				JSONArray jrr = new JSONArray();
				JSONParser jp = new JSONParser();
				
				try {
					FileReader file = new FileReader("userbase.json");
					jrr =  (JSONArray)jp.parse(file);
				} catch (ParseException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				for(int i=0; i<jrr.size(); i++) {
					JSONObject row = (JSONObject) jrr.get(i);
					String nick = (String) row.get("username");
					if(nick.equals(Main.nickname)) {
						String password = (String) row.get("password");
						obj.put("password", password);
						obj.put("role", "user");
						obj.put("username", Main.nickname);
						obj.put("correo", txtCorreo.getText());
						if(comboBox.getSelectedItem().equals("HOMBRE")) {
							obj.put("sexo", "hombre");
						}else if(comboBox.getSelectedItem().equals("MUJER")){
							obj.put("sexo", "mujer");
						}
						obj.put("fecha_nacim", txtFechaN.getText());
						obj.put("nombre", txtNombre.getText());
						obj.put("apellido", txtApellido.getText());
						
						if(nick!=null) {
							jrr.remove(i);
						}
					}
				}
				jrr.add(obj);
				
				try {
					FileWriter file = new FileWriter("userbase.json");
					file.write(jrr.toJSONString());
					file.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Guardado", "InfoBox: " + "Success", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		panelGuardar.setLayout(null);
		panelGuardar.setBackground(new Color(20, 91, 173));
		panelGuardar.setBounds(189, 361, 170, 44);
		panelPerfilUsuario.add(panelGuardar);
		
		JLabel lblGuardar = new JLabel("GUARDAR");
		lblGuardar.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuardar.setForeground(Color.WHITE);
		lblGuardar.setFont(new Font("Ebrima", Font.BOLD, 16));
		lblGuardar.setBounds(0, 0, 170, 44);
		panelGuardar.add(lblGuardar);
		
		JSeparator separatorNombre_1_1_1 = new JSeparator();
		separatorNombre_1_1_1.setBackground(Color.BLACK);
		separatorNombre_1_1_1.setBounds(189, 350, 170, 2);
		panelPerfilUsuario.add(separatorNombre_1_1_1);
		
		JSeparator separatorNombre_1_1_1_1 = new JSeparator();
		separatorNombre_1_1_1_1.setBackground(Color.BLACK);
		separatorNombre_1_1_1_1.setBounds(189, 313, 170, 2);
		panelPerfilUsuario.add(separatorNombre_1_1_1_1);
		
		panelLuz= new JPanel();
		panelLuz.setBackground(Color.WHITE);
		panelLuz.setBounds(0, 0, 515, 561);
		panelMultiple.add(panelLuz);
		panelLuz.setLayout(null);
		panelLuz.setVisible(false);
		
		JPanel panel_4_1_1_1 = new JPanel();
		panel_4_1_1_1.setBounds(0, 41, 515, 120);
		panel_4_1_1_1.setBackground(new Color(25, 118, 209));
		panelLuz.add(panel_4_1_1_1);
		panel_4_1_1_1.setLayout(null);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("DATOS DE LUZ");
		lblNewLabel_3_1_1_1.setBounds(0, 0, 515, 119);
		lblNewLabel_3_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_1_1.setFont(new Font("Ebrima", Font.BOLD, 18));
		panel_4_1_1_1.add(lblNewLabel_3_1_1_1);
		
		
		JPanel panelInfo = new JPanel();
		panelInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelInfo.setBackground(new Color(20, 101, 193));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelInfo.setBackground(new Color(20, 91, 173));
		
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				panelMultiple.removeAll();
				panelMultiple.repaint();
				panelMultiple.revalidate(); 
				panelLuz.setVisible(true);
				panelMultiple.add(panelLuz);
				tablaInfo();
			}
		});
		panelInfo.setLayout(null);
		panelInfo.setBackground(new Color(20, 91, 173));
		panelInfo.setBounds(10, 171, 170, 44);
		panelLuz.add(panelInfo);
		
		JLabel lblResultados_1 = new JLabel("INFO");
		lblResultados_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultados_1.setForeground(Color.WHITE);
		lblResultados_1.setFont(new Font("Ebrima", Font.BOLD, 16));
		lblResultados_1.setBounds(0, 0, 170, 44);
		panelInfo.add(lblResultados_1);
		
		panelTemperatura = new JPanel();
		panelTemperatura.setBackground(Color.WHITE);
		panelTemperatura.setBounds(0, 0, 515, 561);
		panelMultiple.add(panelTemperatura);
		panelTemperatura.setLayout(null);
		
		JPanel panel_4_1_1_1_1 = new JPanel();
		panel_4_1_1_1_1.setLayout(null);
		panel_4_1_1_1_1.setBackground(new Color(25, 118, 209));
		panel_4_1_1_1_1.setBounds(0, 41, 515, 120);
		panelTemperatura.add(panel_4_1_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("DATOS TEMPERATURA");
		lblNewLabel_3_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_1_1_1.setFont(new Font("Ebrima", Font.BOLD, 18));
		lblNewLabel_3_1_1_1_1.setBounds(0, 0, 515, 119);
		panel_4_1_1_1_1.add(lblNewLabel_3_1_1_1_1);
		
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.MAGENTA);
		panel_2.setBounds(0, 0, 515, 561);
	}
	
	
	public void consultPerfil() {
		txtNombre.setText("TU NOMBRE");
		txtApellido.setText("TU APELLIDO");
		txtCorreo.setText("TU CORREO");
		txtFechaN.setText("dd/mm/yyyy");
		
		JSONObject obj = new JSONObject();
		JSONArray jrr = new JSONArray();
		JSONParser jp = new JSONParser();
		
		try {
			FileReader file = new FileReader("userbase.json");
			jrr =  (JSONArray)jp.parse(file);
		} catch (ParseException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int size = jrr.size();
		
		for(int i=0; i<size; i++) {
			JSONObject row = (JSONObject) jrr.get(i);
			String name = (String) row.get("username");
			if(name.equals(Main.nickname)) {
				String nameU = (String) row.get("nombre");
				String apellidoU = (String) row.get("apellido");
				String sexo = (String) row.get("sexo");
				String correoU = (String) row.get("correo");
				String fecha_nacimU = (String) row.get("fecha_nacim");
				if(nameU != null) {
					txtNombre.setText(nameU);
				}
				if(nameU != null) {
					txtApellido.setText(apellidoU);
				}
				if(sexo != null) {
					if(sexo.equals("mujer")) {
						comboBox.setSelectedIndex(1);
					}else {
						comboBox.setSelectedIndex(0);
					}
				}
				txtCorreo.setText(correoU);
				if(fecha_nacimU != null) {
					txtFechaN.setText(fecha_nacimU);
				}
			}
		}
	}

	public void tablaInfo() {
		JSONObject obj = new JSONObject();
		JSONArray jrr = new JSONArray();
		Object ob = null;
		JSONParser jp = new JSONParser();
		
	}
}