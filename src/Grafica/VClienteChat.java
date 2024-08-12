package Grafica;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VClienteChat extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
		setBounds(100, 100, 322, 557);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 288, 500);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 268, 408);
		panel.add(scrollPane);
		
		JButton BtnEnviar = new JButton("Enviar");
		BtnEnviar.setBounds(20, 467, 258, 26);
		panel.add(BtnEnviar);
		
		JTextField textField = new JTextField();
		textField.setBounds(10, 428, 268, 26);
		panel.add(textField);
		textField.setColumns(10);
	}

}
