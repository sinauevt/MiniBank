package Coba.action.data;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class ClearAnggota implements ActionListener {
	private JTextField NIATextField;
	private JTextField NamaTextField;
	private JTextField AlamatTextField;
	private JTextField TlpTextField;
	private JTextField PasswordTextField;

	public ClearAnggota(JTextField NIATextField, JTextField NamaTextField, JTextField AlamatTextField,
			JTextField TlpTextField, JTextField PasswordTextField) {
		this.NIATextField = NIATextField;
		this.NamaTextField = NamaTextField;
		this.AlamatTextField = AlamatTextField;
		this.TlpTextField = TlpTextField;
		this.PasswordTextField = PasswordTextField;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		NIATextField.setText("");
		NamaTextField.setText("");
		AlamatTextField.setText("");
		TlpTextField.setText("");
		PasswordTextField.setText("");

	}

}
