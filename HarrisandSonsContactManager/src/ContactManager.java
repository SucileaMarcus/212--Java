import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactManager extends JFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactManager window = new ContactManager();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ContactManager() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 664, 351);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnBusinessContact = new JButton("Business Contact");
		
		/** This method creates an instance of the BusinessContact() class and makes it visible*/
		btnBusinessContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BusinessContact businessContact = new BusinessContact();			
				businessContact.setVisible(true);
			}
		});
		btnBusinessContact.setBounds(350, 91, 148, 23);
		frame.getContentPane().add(btnBusinessContact);

		
		JButton btnPersonalContact = new JButton("Personal Contact");
		/** This method creates an instance of the PersonalContact() class and makes it visible*/
		btnPersonalContact.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				
				PersonalContact personalContact = new PersonalContact();				
				personalContact.setVisible(true);			
			}
		});
		btnPersonalContact.setBounds(151, 91, 130, 23);
		frame.getContentPane().add(btnPersonalContact);
	}
}
