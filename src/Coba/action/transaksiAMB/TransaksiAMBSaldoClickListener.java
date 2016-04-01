package Coba.action.transaksiAMB;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class TransaksiAMBSaldoClickListener implements ActionListener {
	private JTextField UangTextField;
	private JTextField SaldoTextField;
	private JTextField TotalSaldoTextField;

	public TransaksiAMBSaldoClickListener(JTextField SaldoTextField, JTextField UangTextField,
			JTextField TotalSaldoTextField) {
		this.SaldoTextField = SaldoTextField;
		this.UangTextField = UangTextField;
		this.TotalSaldoTextField = TotalSaldoTextField;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		int a = Integer.parseInt(SaldoTextField.getText());
		int b = Integer.parseInt(UangTextField.getText());
		int c = a - b;
		TotalSaldoTextField.setText(String.valueOf(c));
	}

}
