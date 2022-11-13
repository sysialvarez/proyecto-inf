package control;

import java.awt.EventQueue;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import view.WindowLogin;
import view.WindowMenuUser;
import java.io.FileReader;
import java.io.FileWriter;


public class Main {
	public static String nickname = "";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowLogin frame = new WindowLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings("unchecked")
	public static void login(String login, String password) throws IOException {
		boolean check = false;
		JSONObject obj = new JSONObject();
		JSONArray jrr = new JSONArray();
		Object ob = null;
		JSONParser jp = new JSONParser();
		
		try {
			FileReader file = new FileReader("userbase.json");
			ob = jp.parse(file);
			jrr=(JSONArray) ob;
			file.close();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int size = jrr.size();
		obj.put("username", login);
		obj.put("password", password);
		
		for(int i=0; i<size; i++) {
			JSONObject row = (JSONObject) jrr.get(i);
			String name = (String) row.get("username");
			String psswd = (String) row.get("password");
			String role = (String) row.get("role");
			if(obj.get("username").equals(name)&&obj.get("password").equals(psswd)) {
				if(role.equals("admin")) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							
						}
					});
				}else if(role.equals("user")) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								WindowMenuUser frame = new WindowMenuUser();
								frame.setVisible(true);
								WindowLogin windowLogin = new WindowLogin();
								windowLogin.dispose();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
				check = true;
			}
			nickname = login;
		}
		if(!check) {
			JOptionPane.showMessageDialog(null, "Login o password incorrecto, prueba de nuevo", "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void registrarse(String login, String correo, String password) throws IOException {
		boolean newUser = true;
		
		if(newUser) {
			JSONObject obj = new JSONObject();
			JSONArray jrr = new JSONArray();
			JSONArray jrr2 = new JSONArray();
			JSONParser jp = new JSONParser();
			
			try {
				FileReader file = new FileReader("userbase.json");
				jrr =  (JSONArray)jp.parse(file);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			obj.put("username", login);
			obj.put("password", password);
			obj.put("correo", correo);
			obj.put("role", "user");
			
			int size = jrr.size();
			boolean registro = true;
			for(int i=0; i<size; i++) {
				JSONObject row = (JSONObject) jrr.get(i);
				String name = (String) row.get("username");
				String name2 = (String) obj.get("username");
				if(name.equals(name2)) {
					registro = false;
				}
			}
			if(!registro) {
				JOptionPane.showMessageDialog(null, "Usuario ya existe", "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);
			}else {
				jrr.add(obj);
				
				try {
					FileWriter file = new FileWriter("userbase.json");
					file.write(jrr.toJSONString());
					file.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null, "Has registrado en sistema, ahora puedes entrar", "InfoBox: " + "Success", JOptionPane.INFORMATION_MESSAGE);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							WindowLogin frame = new WindowLogin();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		}
	}
	public static void registrarAdmin(String login, String password) throws IOException {
		JOptionPane.showMessageDialog(null, "Has registrado usuario admin", "InfoBox: " + "Success", JOptionPane.INFORMATION_MESSAGE);
	}
	
}