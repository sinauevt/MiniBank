 package Coba.action.transaksiSIM;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Coba.TransaksiSIM.TransaksiSIMPreparedStatement;
import Coba.TransaksiSIM.TransaksiSimpan;

public class TransaksiSIMClickListener implements ActionListener {

	private JTextField NoTSTextField;
	private JTextField NIATextField;
	private JTextField NamaTextField;
	private JTextField AlamatTextField;
	private JTextField TanggalTextField;
	private JTextField UangTextField;

	public TransaksiSIMClickListener(JTextField NoTSTextField, JTextField NIATextField, JTextField NamaTextField,
			JTextField AlamatTextField, JTextField TanggalTextField, JTextField UangTextField) {
		this.NoTSTextField = NoTSTextField;
		this.NIATextField = NIATextField;
		this.NamaTextField = NamaTextField;
		this.AlamatTextField = AlamatTextField;
		this.TanggalTextField = TanggalTextField;
		this.UangTextField = UangTextField;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		TransaksiSIMPreparedStatement prep1 = new TransaksiSIMPreparedStatement();
		try {
			List<TransaksiSimpan> Saldo = prep1.selectSIM();
			for (TransaksiSimpan SIM : Saldo)
				if (NIATextField.getText().matches(SIM.getNIA())) {

					int a = Integer.parseInt(SIM.getUang());
					int b = Integer.parseInt(UangTextField.getText());
					int c = a + b;

					TransaksiSimpan up = new TransaksiSimpan();
					up.setNIA(NIATextField.getText());
					up.setUang(String.valueOf(c));
					if (prep1.Update(up) >= 1) {
					}
				} else {

					TransaksiSimpan SIMM = new TransaksiSimpan();
					SIMM.setNoTS(NoTSTextField.getText());
					SIMM.setNIA(NIATextField.getText());
					SIMM.setUang(UangTextField.getText());
					if (prep1.insert(SIMM) >= 1) {
					}

				}

			TransaksiSimpan SIMdet = new TransaksiSimpan();
			SIMdet.setNoTS(NoTSTextField.getText());
			SIMdet.setNIA(NIATextField.getText());
			SIMdet.setTanggal(TanggalTextField.getText());
			SIMdet.setUang(UangTextField.getText());
			if (prep1.insertt(SIMdet) >= 1) {
				JOptionPane.showMessageDialog(null, "Data Sudah Ditambah ke DataBase", "informasi",
						JOptionPane.WARNING_MESSAGE);

			}
		} catch (ClassNotFoundException a) {
			a.printStackTrace();
		} catch (SQLException a) {
			a.printStackTrace();
		}
		NIATextField.setText("");
		NamaTextField.setText("");
		AlamatTextField.setText("");
		UangTextField.setText("");

		int a = Integer.parseInt(NoTSTextField.getText());
		int b = a + 1;
		NoTSTextField.setText(String.valueOf(b));
	}

}