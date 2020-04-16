import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PersonalContact extends JFrame {

	
	private JPanel contentPane;
	private JTable table_Personal;
	private JTextField tbFname;
	private JTextField tbLname;
	private JTextField tbAddress1;
	private JTextField tbAddress2;
	private JTextField tbPostCode;
	private JTextField tbTelNumber;
	private JTextField tbEmail;
	private JTextField tbCity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonalContact frame = new PersonalContact();
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
	public PersonalContact() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 706, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {			
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
		});
		scrollPane.setBounds(53, 92, 483, 220);
		contentPane.add(scrollPane);
		DbConn d = new DbConn();		
		
		
		tbFname = new JTextField();
		tbFname.setColumns(10);
		tbFname.setEnabled(false);
		
		tbLname = new JTextField();
		tbLname.setColumns(10);
		tbLname.setEnabled(false);
			
		tbAddress1 = new JTextField();
		tbAddress1.setColumns(10);
		tbAddress1.setEnabled(false);
		
		tbAddress2 = new JTextField();
		tbAddress2.setColumns(10);
		tbAddress2.setEnabled(false);
		
		tbPostCode = new JTextField();
		tbPostCode.setColumns(10);
		tbPostCode.setEnabled(false);
		
		tbTelNumber = new JTextField();
		tbTelNumber.setColumns(10);
		tbTelNumber.setEnabled(false);
		
		tbEmail = new JTextField();
		tbEmail.setColumns(10);
		tbEmail.setEnabled(false);
		
		tbCity = new JTextField();
		tbCity.setColumns(10);
		tbCity.setEnabled(false);
		
		JLabel lblNewLabel = new JLabel("First Name");
		
		JLabel lblLastName = new JLabel("Last Name");
		
		JLabel lblEmail = new JLabel("Email");
		
		JLabel lblAddress = new JLabel("Address 1");
		
		JLabel lblNewLabel_1_1 = new JLabel("Address 2");
		
		JLabel lblNewLabel_1_1_1 = new JLabel("City");
		
		JLabel lblNewLabel_1_2 = new JLabel("Post Code");
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Tel Number");
		
		
		JButton btnUpdate = new JButton("Update");
		JButton btnRefresh = new JButton("Refresh");
		JButton btnAddNew = new JButton("Add New");
		JButton btnDelete = new JButton("Delete");
		JButton btnSaveSelected = new JButton("Save Selected");
		JButton btnSave = new JButton("Save");
	
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int id = Integer.parseInt(table_Personal.getValueAt(table_Personal.getSelectedRow(), 0).toString());
				d.DeletePersonal(id);
				table_Personal.setModel(DbUtils.resultSetToTableModel(d.GetAllPersonal()));
				tbFname.setText("");
				tbLname.setText("");
				tbEmail.setText("");
				tbAddress1.setText("");
				tbAddress2.setText("");
				tbCity.setText("");
				tbPostCode.setText("");
				tbTelNumber.setText("");
			}
		});
				
		btnRefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table_Personal.setModel(DbUtils.resultSetToTableModel(d.GetAllPersonal()));
			}
		});		
		
		btnAddNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tbFname.setEnabled(true);
				tbLname.setEnabled(true);
				tbEmail.setEnabled(true);
				tbAddress1.setEnabled(true);
				tbAddress2.setEnabled(true);
				tbCity.setEnabled(true);
				tbPostCode.setEnabled(true);
				tbTelNumber.setEnabled(true);	
				tbFname.setText("");
				tbLname.setText("");
				tbEmail.setText("");
				tbAddress1.setText("");
				tbAddress2.setText("");
				tbCity.setText("");
				tbPostCode.setText("");
				tbTelNumber.setText("");				
				btnUpdate.setEnabled(false);
				btnSaveSelected.setEnabled(false);
				btnSave.setEnabled(true);
				btnDelete.setEnabled(false);
				btnAddNew.setEnabled(false);
								
			}
		});		
				
		btnSaveSelected.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Fname = tbFname.getText();
				String Lname = tbLname.getText();
				String Email = tbEmail.getText();
				String Address1 = tbAddress1.getText();
				String Address2 = tbAddress2.getText();
				String PostCode = tbPostCode.getText();
				String City = tbCity.getText();
				String TelNumber = tbTelNumber.getText();
				int id = Integer.parseInt(table_Personal.getValueAt(table_Personal.getSelectedRow(), 0).toString());					
				d.UpdatePersonal(Fname, Lname, Email, Address1, Address2, PostCode, City, TelNumber, id);
				table_Personal.setModel(DbUtils.resultSetToTableModel(d.GetAllPersonal()));
				btnUpdate.setEnabled(true);
				btnAddNew.setEnabled(true);
				btnSave.setEnabled(false);
				btnDelete.setEnabled(true);
				btnSaveSelected.setEnabled(false);
				tbFname.setText("");
				tbLname.setText("");
				tbEmail.setText("");
				tbAddress1.setText("");
				tbAddress2.setText("");
				tbCity.setText("");
				tbPostCode.setText("");
				tbTelNumber.setText("");
				tbFname.setEnabled(false);
				tbLname.setEnabled(false);
				tbEmail.setEnabled(false);
				tbAddress1.setEnabled(false);
				tbAddress2.setEnabled(false);
				tbCity.setEnabled(false);
				tbPostCode.setEnabled(false);
				tbTelNumber.setEnabled(false);
			}
		});	
		btnSaveSelected.setEnabled(false);		
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tbFname.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter First Name!");
				}
				else if (tbLname.getText().isEmpty()){
						JOptionPane.showMessageDialog(null, "Please enter Last Name!");
				}
				else if (tbEmail.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Please enter Email!");
				}
				else if (tbAddress1.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Please enter Address!");
				}
				else if (tbCity.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Please enter City!");
				}
				else if (tbPostCode.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Please enter Post Code!");
				}
				else if (tbTelNumber.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Please enter Telephone Number!");
				}
				else
				{				
				String Fname = tbFname.getText();
				String Lname = tbLname.getText();
				String Email = tbEmail.getText();
				String Address1 = tbAddress1.getText();
				String Address2 = tbAddress2.getText();
				String PostCode = tbPostCode.getText();
				String City = tbCity.getText();
				String TelNumber = tbTelNumber.getText();
				d.InsertPersonal(Fname, Lname, Email, Address1, Address2, PostCode, City, TelNumber);
				table_Personal.setModel(DbUtils.resultSetToTableModel(d.GetAllPersonal()));
				btnUpdate.setEnabled(true);
				btnAddNew.setEnabled(true);
				btnSave.setEnabled(false);
				btnDelete.setEnabled(true);
				btnSaveSelected.setEnabled(false);
				tbFname.setText("");
				tbLname.setText("");
				tbEmail.setText("");
				tbAddress1.setText("");
				tbAddress2.setText("");
				tbCity.setText("");
				tbPostCode.setText("");
				tbTelNumber.setText("");
				tbFname.setEnabled(false);
				tbLname.setEnabled(false);
				tbEmail.setEnabled(false);
				tbAddress1.setEnabled(false);
				tbAddress2.setEnabled(false);
				tbCity.setEnabled(false);
				tbPostCode.setEnabled(false);
				tbTelNumber.setEnabled(false);
				}
			}
		});
		
		btnSave.setEnabled(false);
				
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tbFname.setEnabled(true);
				tbLname.setEnabled(true);
				tbEmail.setEnabled(true);
				tbAddress1.setEnabled(true);
				tbAddress2.setEnabled(true);
				tbCity.setEnabled(true);
				tbPostCode.setEnabled(true);
				tbTelNumber.setEnabled(true);	
				btnUpdate.setEnabled(false);
				btnAddNew.setEnabled(false);
				btnSave.setEnabled(false);
				btnDelete.setEnabled(false);
				btnSaveSelected.setEnabled(true);
				btnSave.setEnabled(false);
			
			}
		});

		table_Personal = new JTable();
		table_Personal.setModel(DbUtils.resultSetToTableModel(d.GetAllPersonal()));
		table_Personal.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tbFname.setText(table_Personal.getValueAt(table_Personal.getSelectedRow(),1).toString());
				tbLname.setText(table_Personal.getValueAt(table_Personal.getSelectedRow(),2).toString());
				tbEmail.setText(table_Personal.getValueAt(table_Personal.getSelectedRow(),3).toString());
				tbAddress1.setText(table_Personal.getValueAt(table_Personal.getSelectedRow(),4).toString());
				tbAddress2.setText(table_Personal.getValueAt(table_Personal.getSelectedRow(),5).toString());
				tbPostCode.setText(table_Personal.getValueAt(table_Personal.getSelectedRow(),6).toString());
				tbCity.setText(table_Personal.getValueAt(table_Personal.getSelectedRow(),7).toString());
				tbTelNumber.setText(table_Personal.getValueAt(table_Personal.getSelectedRow(),8).toString());
				
			}
		});
		scrollPane.setViewportView(table_Personal);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tbFname.setEnabled(false);
				tbLname.setEnabled(false);
				tbEmail.setEnabled(false);
				tbAddress1.setEnabled(false);
				tbAddress2.setEnabled(false);
				tbCity.setEnabled(false);
				tbPostCode.setEnabled(false);
				tbTelNumber.setEnabled(false);
				btnAddNew.setEnabled(true);
				btnDelete.setEnabled(true);
				btnUpdate.setEnabled(true);
				btnSave.setEnabled(false);
				btnSaveSelected.setEnabled(false);			
			}
		});
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 656, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblLastName, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
								.addComponent(lblAddress, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblEmail, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(tbAddress2)
								.addComponent(tbPostCode)
								.addComponent(tbEmail)
								.addComponent(tbLname, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
								.addComponent(tbFname, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
							.addGap(29)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(lblNewLabel_1_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblNewLabel_1_2_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
								.addComponent(lblNewLabel_1_1_1))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(tbCity)
								.addComponent(tbAddress1)
								.addComponent(tbTelNumber))
							.addGap(27)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnSave, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnCancel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnDelete, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnAddNew, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnMainMenu, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(btnSaveSelected, 0, 0, Short.MAX_VALUE)
									.addComponent(btnUpdate, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
									.addComponent(btnRefresh, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(tbFname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_2)
						.addComponent(btnAddNew)
						.addComponent(btnUpdate)
						.addComponent(tbAddress1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLastName)
						.addComponent(tbLname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_2_1)
						.addComponent(btnSaveSelected)
						.addComponent(btnSave)
						.addComponent(tbTelNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(tbEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tbCity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_1)
						.addComponent(btnDelete))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddress)
						.addComponent(tbPostCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancel)
						.addComponent(btnMainMenu))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1)
						.addComponent(tbAddress2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addComponent(btnRefresh)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
