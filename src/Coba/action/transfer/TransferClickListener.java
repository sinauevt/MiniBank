package Coba.action.transfer;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JTextField;
import Coba.Transfer.Transfer;
import Coba.Transfer.TransferPreparedStatement;

public class TransferClickListener implements ActionListener {

	private JTextField NOTSTextField;
	private JTextField TanggalTextField;
	private JTextField NIA1TextField;
	private JTextField NIA2TextField;
	private JTextField UangTextField;

	public TransferClickListener(JTextField NOTSTextField, JTextField TanggalTextField, JTextField NIA1TextField,
			JTextField NIA2TextField, JTextField UangTextField) {

		this.NOTSTextField = NOTSTextField;
		this.TanggalTextField = TanggalTextField;
		this.NIA1TextField = NIA1TextField;
		this.NIA2TextField = NIA2TextField;
		this.UangTextField = UangTextField;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		TransferPreparedStatement prep = new TransferPreparedStatement();
		try {

			List<Transfer> Saldo = prep.selectSaldo1();
			for (Transfer SIM : Saldo) {
				if (NIA1TextField.getText().matches(SIM.getNIA1())) {

					int a = Integer.parseInt(SIM.getUang());
					int b = Integer.parseInt(UangTextField.getText());
					int c = a - b;
					Transfer update1 = new Transfer();
					update1.setNIA1(NIA1TextField.getText());
					update1.setUang(String.valueOf(c));
					if (prep.Update1(update1) >= 1) {
					}

				}
			}

			List<Transfer> Saldo2 = prep.selectSaldo1();
			for (Transfer SIM2 : Saldo2) {
				if (NIA2TextField.getText().matches(SIM2.getNIA2())) {

					int a = Integer.parseInt(SIM2.getUang());
					int b = Integer.parseInt(UangTextField.getText());
					int c = a + b;
					Transfer update2 = new Transfer();
					update2.setNIA2(NIA2TextField.getText());
					update2.setUang(String.valueOf(c));
					if (prep.Update2(update2) >= 1) {
					}
				}
			}

			Transfer transfer = new Transfer();
			transfer.setNOTS(NOTSTextField.getText());
			transfer.setTanggal(TanggalTextField.getText());
			transfer.setNIA1(NIA1TextField.getText());
			transfer.setNIA2(NIA2TextField.getText());
			transfer.setUang(UangTextField.getText());
			if (prep.insert(transfer) >= 1) {
			}

		} catch (

		ClassNotFoundException a)

		{
			a.printStackTrace();
		} catch (

		SQLException a)

		{
			a.printStackTrace();
		}

		NIA1TextField.setText("");
		NIA2TextField.setText("");
		UangTextField.setText("");

		int a = Integer.parseInt(NOTSTextField.getText());
		int b = a + 1;
		NOTSTextField.setText(String.valueOf(b));
	}
}