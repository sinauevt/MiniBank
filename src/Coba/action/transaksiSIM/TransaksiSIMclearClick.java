package Coba.action.transaksiSIM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class TransaksiSIMclearClick implements ActionListener {

	private JTextField NIATextField;
	private JTextField NamaTextField;
	private JTextField AlamatTextField;
	private JTextField UangTextField;

	public TransaksiSIMclearClick(JTextField NIATextField, JTextField NamaTextField, JTextField AlamatTextField,
			JTextField UangTextField) {
		this.NIATextField = NIATextField;
		this.NamaTextField = NamaTextField;
		this.AlamatTextField = AlamatTextField;
		this.UangTextField = UangTextField;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		NIATextField.setText("");
		NamaTextField.setText("");
		AlamatTextField.setText("");
		UangTextField.setText("");

	}

}
