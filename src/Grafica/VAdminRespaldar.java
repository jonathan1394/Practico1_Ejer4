package Grafica;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Controladores.ControladorAdminRespaldar;
import Excepciones.PersistenciaException;

import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;

public class VAdminRespaldar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private boolean hayError;
	private ControladorAdminRespaldar c;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VAdminRespaldar frame = new VAdminRespaldar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws PersistenciaException 
	 * @throws RemoteException 
	 */
	public VAdminRespaldar() {
		c = new ControladorAdminRespaldar(this);
		
		setBounds(100, 100, 322, 557);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 288, 500);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 0, 288, 454);
		panel.add(textArea);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(0, 0, 288, 454);
		panel.add(scrollPane);
		
		try {
			textArea.setText(c.ListarMensaje());
		} catch (RemoteException | PersistenciaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JButton BtnVerMensajes = new JButton("Respaldar");
		BtnVerMensajes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.Guardar();
				} catch (RemoteException | PersistenciaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		BtnVerMensajes.setBounds(10, 464, 268, 26);
		panel.add(BtnVerMensajes);
		

	}

	public void setHayError(boolean hayError) {
		this.hayError = hayError;
	}

	public boolean getHayError() {
		// TODO Auto-generated method stub
		return this.hayError;
	}
	
}
