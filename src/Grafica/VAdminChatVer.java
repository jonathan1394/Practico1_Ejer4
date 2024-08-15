package Grafica;

import java.awt.BorderLayout;
import Controladores.ControladorAdminChatVer;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controladores.ControladorAdminChatVer;

import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VAdminChatVer extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private boolean hayError;
	private ControladorAdminChatVer C;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VAdminChatVer frame = new VAdminChatVer();
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
	public VAdminChatVer() {
		C= new ControladorAdminChatVer(this);
		setBounds(100, 100, 322, 557);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 288, 500);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextArea Texto = new JTextArea();
		Texto.setBounds(0, 0, 288, 454);
		panel.add(Texto);


		JButton BtnVerMensajes = new JButton("Ver Mensajes");
		BtnVerMensajes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String S = C.ListarMensaje();
					Texto.setText(S);
				}catch(Exception e1) {
					e1.getMessage();
				}
			}
		});

		
		BtnVerMensajes.setBounds(10, 464, 268, 26);
		panel.add(BtnVerMensajes);
		
		JScrollPane scrollPane = new JScrollPane(Texto);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(0, 0, 288, 454);
		panel.add(scrollPane);
		

	}

	public void setHayError(boolean hayError) {
		this.hayError = hayError;
	}

	public boolean getHayError() {
		return this.hayError;
	}
}
