package Grafica;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controladores.ControladorAdminChatVer;
import Controladores.ControladorClienteChat;
import Excepciones.PersistenciaException;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VClienteChat extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private boolean hayError;
	private ControladorClienteChat C;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VClienteChat frame = new VClienteChat();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VClienteChat() {
		C = new ControladorClienteChat(this);
		setBounds(100, 100, 322, 557);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 288, 500);
		contentPane.add(panel);
		panel.setLayout(null);
		

		JTextArea TextoMensaje = new JTextArea();
		TextoMensaje.setBounds(1, 1, 264, 403);
		panel.add(TextoMensaje);
		TextoMensaje.setColumns(10);
		
		JTextField Texto = new JTextField();
		Texto.setBounds(1, 428, 286, 26);
		panel.add(Texto);
		Texto.setColumns(10);
		

		
		JButton BtnEnviar = new JButton("Enviar");
		BtnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String t = Texto.getText();
				C.Agregarmensaje(t);
				String s="";
				try {
					s = C.Cargarmensajes();
				} catch (RemoteException | PersistenciaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				TextoMensaje.setText(s);
				Texto.setText("");
				
			}
		});
		
		JScrollPane scrollPane = new JScrollPane(TextoMensaje);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(0, 0, 288, 418);
		panel.add(scrollPane);

		

		BtnEnviar.setBounds(20, 467, 258, 26);
		panel.add(BtnEnviar);
		

	}
	
	public void setHayError(boolean hayError) {
		this.hayError = hayError;
	}

	public boolean getHayError() {
		// TODO Auto-generated method stub
		return this.hayError;
	}
}
