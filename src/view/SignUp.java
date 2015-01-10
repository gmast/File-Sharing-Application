import java.awt.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Thu Sep 25 01:20:50 EDT 2014
 */



/**
 * @author Vikas Piddempally
 */
public class SignUp  {

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Vikas Piddempally
		frame = new JFrame();
		panel_SignUpContainer = new JPanel();
		panel_FormEntries = new JPanel();
		lbl_UserName = new JLabel();
		txt_UserName = new JTextField();
		lbl_Password = new JLabel();
		txt_Password = new JTextField();
		lbl_Email = new JLabel();
		txt_Email = new JTextField();
		lbl_Phpne = new JLabel();
		txt_PhoneNumber = new JTextField();
		panel2 = new JPanel();
		btn_SignUp = new JButton();
		btn_Cancel = new JButton();

		//======== frame ========
		{
			frame.setTitle("SignUp");
			Container frameContentPane = frame.getContentPane();
			frameContentPane.setLayout(new BorderLayout(5, 5));

			//======== panel_SignUpContainer ========
			{
				panel_SignUpContainer.setBackground(Color.white);

				// JFormDesigner evaluation mark
				panel_SignUpContainer.setBorder(new javax.swing.border.CompoundBorder(
					new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
						"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
						javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
						java.awt.Color.red), panel_SignUpContainer.getBorder())); panel_SignUpContainer.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

				panel_SignUpContainer.setLayout(new BorderLayout(5, 5));

				//======== panel_FormEntries ========
				{
					panel_FormEntries.setBackground(Color.white);
					panel_FormEntries.setLayout(new GridBagLayout());
					((GridBagLayout)panel_FormEntries.getLayout()).columnWidths = new int[] {0, 81, 0};
					((GridBagLayout)panel_FormEntries.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0};
					((GridBagLayout)panel_FormEntries.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
					((GridBagLayout)panel_FormEntries.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0E-4};

					//---- lbl_UserName ----
					lbl_UserName.setText("UserName");
					panel_FormEntries.add(lbl_UserName, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 5, 5), 0, 0));
					panel_FormEntries.add(txt_UserName, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 5, 0), 0, 0));

					//---- lbl_Password ----
					lbl_Password.setText("Password");
					panel_FormEntries.add(lbl_Password, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 5, 5), 0, 0));
					panel_FormEntries.add(txt_Password, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 5, 0), 0, 0));

					//---- lbl_Email ----
					lbl_Email.setText("Email");
					panel_FormEntries.add(lbl_Email, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 5, 5), 0, 0));
					panel_FormEntries.add(txt_Email, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 5, 0), 0, 0));

					//---- lbl_Phpne ----
					lbl_Phpne.setText("Phone Number");
					panel_FormEntries.add(lbl_Phpne, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 0, 5), 0, 0));
					panel_FormEntries.add(txt_PhoneNumber, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 0, 0), 0, 0));
				}
				panel_SignUpContainer.add(panel_FormEntries, BorderLayout.CENTER);

				//======== panel2 ========
				{
					panel2.setLayout(new FlowLayout());

					//---- btn_SignUp ----
					btn_SignUp.setText("Sign Up");
					panel2.add(btn_SignUp);

					//---- btn_Cancel ----
					btn_Cancel.setText("Cancel");
					panel2.add(btn_Cancel);
				}
				panel_SignUpContainer.add(panel2, BorderLayout.SOUTH);
			}
			frameContentPane.add(panel_SignUpContainer, BorderLayout.CENTER);
			frame.pack();
			frame.setLocationRelativeTo(frame.getOwner());
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Vikas Piddempally
	private JFrame frame;
	private JPanel panel_SignUpContainer;
	private JPanel panel_FormEntries;
	private JLabel lbl_UserName;
	private JTextField txt_UserName;
	private JLabel lbl_Password;
	private JTextField txt_Password;
	private JLabel lbl_Email;
	private JTextField txt_Email;
	private JLabel lbl_Phpne;
	private JTextField txt_PhoneNumber;
	private JPanel panel2;
	private JButton btn_SignUp;
	private JButton btn_Cancel;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
