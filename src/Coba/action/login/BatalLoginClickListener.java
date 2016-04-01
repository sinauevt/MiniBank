package Coba.action.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class BatalLoginClickListener implements ActionListener {
	private JTextField UserTextField;
	private JTextField PasswordTextField;

	public BatalLoginClickListener(JTextField UserTextField, JTextField PasswordTextField) {
		this.UserTextField = UserTextField;
		this.PasswordTextField = PasswordTextField;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		UserTextField.setText("");
		PasswordTextField.setText("");

	}

}
