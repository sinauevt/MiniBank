package Coba.action.transaksiAMB;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Coba.TramsaksiAMB.TransaksiAMBPreparedStatement;
import Coba.TramsaksiAMB.TransaksiAmbil;

public class TransaksiAMBClickListener implements ActionListener {
	private JTextField NoTSTextField;
	private JTextField NIATextField;
	private JTextField NamaTextField;
	private JTextField AlamatTextField;
	private JTextField TanggalTextField;
	private JTextField UangTextField;

	public TransaksiAMBClickListener(JTextField NoTSTextField, JTextField NIATextField, JTextField NamaTextField,
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
		TransaksiAMBPreparedStatement prep1 = new TransaksiAMBPreparedStatement();
		try {
			List<TransaksiAmbil> Saldo = prep1.selectAMB();
			for (TransaksiAmbil SIM : Saldo)
				if (NIATextField.getText().matches(SIM.getNIA())) {

					int a = Integer.parseInt(SIM.getSaldo());
					int b = Integer.parseInt(UangTextField.getText());
					int c = a - b;

					TransaksiAmbil up = new TransaksiAmbil();
					up.setNIA(NIATextField.getText());
					up.setUang(String.valueOf(c));
					if (prep1.Update(up) >= 1) {
					}

					TransaksiAmbil SIMdet = new TransaksiAmbil();
					SIMdet.setNoTS(NoTSTextField.getText());
					SIMdet.setNIA(NIATextField.getText());
					SIMdet.setTanggal(TanggalTextField.getText());
					SIMdet.setUang(UangTextField.getText());
					if (prep1.Insrt(SIMdet) >= 1) {
						JOptionPane.showMessageDialog(null, "Data Sudah Ditambah ke DataBase", "informasi",
								JOptionPane.WARNING_MESSAGE);

					} else {
						System.out.println("Insert Mahasiswa Gagal!");
					}
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
