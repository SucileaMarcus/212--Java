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

/**
* Business Contact class inherits from JFrame class
* It contains all the methods needed to implement CRUD
*/ 
public class BusinessContact extends JFrame {
    
	
	private JPanel contentPane; 
	private JTable table_Business;
	private JTextField tbFname; /**text box Fname */
	private JTextField tbLname; /** text box Lname */
	private JTextField tbAddress1; /** text box Address1 */
	private JTextField tbAddress2; /** text box Address2 */
	private JTextField tbPostCode; /** text box PostCode */
	private JTextField tbTelNumber; /** text box TelNumber */
	private JTextField tbEmail; /** text box Email */
	private JTextField tbCity; /** text box City */

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BusinessContact frame = new BusinessContact();
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
	public BusinessContact() {
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
		
		/** instances of JLabel */
		JLabel lblNewLabel = new JLabel("First Name");		
		JLabel lblLastName = new JLabel("Last Name");
		JLabel lblEmail = new JLabel("Email");
		JLabel lblAddress = new JLabel("Address 1");
		JLabel lblNewLabel_1_1 = new JLabel("Address 2");
		JLabel lblNewLabel_1_1_1 = new JLabel("City");
		JLabel lblNewLabel_1_2 = new JLabel("Post Code");
		JLabel lblNewLabel_1_2_1 = new JLabel("Tel Number");
		
		/** instances of JButton */
		JButton btnUpdate = new JButton("Update");
		JButton btnRefresh = new JButton("Refresh");
		JButton btnAddNew = new JButton("Add New");
		JButton btnDelete = new JButton("Delete");
		JButton btnSaveSelected = new JButton("Save Selected");
		JButton btnSave = new JButton("Save");
		JButton btnCancel = new JButton("Cancel");
		
		table_Business = new JTable();
		table_Business.setModel(DbUtils.resultSetToTableModel(d.GetAllBusiness()));
		/** This method populates the text boxes based on the pressed column and rows from table_Business */
		table_Business.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tbFname.setText(table_Business.getValueAt(table_Business.getSelectedRow(),1).toString());
				tbLname.setText(table_Business.getValueAt(table_Business.getSelectedRow(),2).toString());
				tbEmail.setText(table_Business.getValueAt(table_Business.getSelectedRow(),3).toString());
				tbAddress1.setText(table_Business.getValueAt(table_Business.getSelectedRow(),4).toString());
				tbAddress2.setText(table_Business.getValueAt(table_Business.getSelectedRow(),5).toString());
				tbPostCode.setText(table_Business.getValueAt(table_Business.getSelectedRow(),6).toString());
				tbCity.setText(table_Business.getValueAt(table_Business.getSelectedRow(),7).toString());
				tbTelNumber.setText(table_Business.getValueAt(table_Business.getSelectedRow(),8).toString());
				
			}
		});
		scrollPane.setViewportView(table_Business);
			
		/** This method disables all buttons but btnSaveNew */
		btnAddNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/** text boxes enabled */
				tbFname.setEnabled(true);
				tbLname.setEnabled(true);
				tbEmail.setEnabled(true);
				tbAddress1.setEnabled(true);
				tbAddress2.setEnabled(true);
				tbCity.setEnabled(true);
				tbPostCode.setEnabled(true);
				tbTelNumber.setEnabled(true);	
				/** text boxes emptied */
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
		
		/** This method adds new entry by calling the method InsertBusiness() from class DbConn */
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/** checks if the text box is empty */
				if (tbFname.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter First Name!");
				}
				/** checks if the text box is empty */
				else if (tbLname.getText().isEmpty()){
						JOptionPane.showMessageDialog(null, "Please enter Last Name!");
				}
				/** checks if the text box is empty */
				else if (tbEmail.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Please enter Email!");
				}
				/** checks if the text box is empty */
				else if (tbAddress1.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Please enter Address!");
				}
				/** checks if the text box is empty */
				else if (tbCity.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Please enter City!");
				}
				/** checks if the text box is empty */
				else if (tbPostCode.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Please enter Post Code!");
				}
				/** checks if the text box is empty */
				else if (tbTelNumber.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Please enter Telephone Number!");
				}
				/** assigns values to the variables */
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
				/** InsertBusiness() method is called from the DbConn class */
				d.InsertBusiness(Fname, Lname, Email, Address1, Address2, PostCode, City, TelNumber);
				/** table_Business re-populated */
				table_Business.setModel(DbUtils.resultSetToTableModel(d.GetAllBusiness()));
				btnUpdate.setEnabled(true);
				btnAddNew.setEnabled(true);
				btnSave.setEnabled(false);
				btnDelete.setEnabled(true);
				btnSaveSelected.setEnabled(false);
				/** text boxes emptied */
				tbFname.setText("");
				tbLname.setText("");
				tbEmail.setText("");
				tbAddress1.setText("");
				tbAddress2.setText("");
				tbCity.setText("");
				tbPostCode.setText("");
				tbTelNumber.setText("");
				/** text boxes disabled */
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
		
		/** This method disables all buttons but btnSaveSelected */
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/** text boxes enabled */
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

		/** This method updates the selected entry 
		 * by calling the updateBusiness() method from dbConn 
		 * and re-populates the table_Business 		
		 */
		btnSaveSelected.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/** assigns values to variables */
				String Fname = tbFname.getText();
				String Lname = tbLname.getText();
				String Email = tbEmail.getText();
				String Address1 = tbAddress1.getText();
				String Address2 = tbAddress2.getText();
				String PostCode = tbPostCode.getText();
				String City = tbCity.getText();
				String TelNumber = tbTelNumber.getText();
				int id = Integer.parseInt(table_Business.getValueAt(table_Business.getSelectedRow(), 0).toString());
				/** Calls the UpdateBusiness() method from DbConn class passing the parameters initialized above */
				d.UpdateBusiness(Fname, Lname, Email, Address1, Address2, PostCode, City, TelNumber, id);
				/** Re-populates the table_Business */
				table_Business.setModel(DbUtils.resultSetToTableModel(d.GetAllBusiness()));
				btnUpdate.setEnabled(true);
				btnAddNew.setEnabled(true);
				btnDelete.setEnabled(true);
				btnSaveSelected.setEnabled(false);
				btnSave.setEnabled(false);
				/** text boxes emptied */
				tbFname.setText("");
				tbLname.setText("");
				tbEmail.setText("");
				tbAddress1.setText("");
				tbAddress2.setText("");
				tbCity.setText("");
				tbPostCode.setText("");
				tbTelNumber.setText("");
				/** text boxes disabled */
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
		
		/** This method Refreshes the table_Busines by calling the GetAllBusiness() method */
		btnRefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table_Business.setModel(DbUtils.resultSetToTableModel(d.GetAllBusiness()));
			}
		});		
			
		
		
		/** This method deletes entry based on the selected ID */
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override		    
			public void mouseClicked(MouseEvent e) {
				int id = Integer.parseInt(table_Business.getValueAt(table_Business.getSelectedRow(), 0).toString());
				/** Calls DeleteBusines() method from DbConn */
				d.DeleteBusiness(id);
				/** Re-populates the table_Business by calling the GetAllBusiness() method*/
				table_Business.setModel(DbUtils.resultSetToTableModel(d.GetAllBusiness()));
				/** text boxes emptied */
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
		
		/** This method disables btnAddNew and btnUpdate */
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
				
		/** This method disposed the current JFrame class */
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
								.addComponent(btnMainMenu, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
								.addComponent(btnUpdate, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
								.addComponent(btnSaveSelected, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
								.addComponent(btnRefresh, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(89)))
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
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
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
							.addGap(55))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnRefresh)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
