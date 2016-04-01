package Coba.action.transaksiSIM;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Coba.TransaksiSIM.TransaksiSIMPreparedStatement;
import Coba.TransaksiSIM.TransaksiSimpan;

public class TransaksiSIMcekNIAClick implements ActionListener {
	private JTextField NIATextField;
	private JTextField NamaTextField;
	private JTextField AlamatTextField;

	public TransaksiSIMcekNIAClick(JTextField NIATextField, JTextField NamaTextField, JTextField AlamatTextField) {
		this.NIATextField = NIATextField;
		this.NamaTextField = NamaTextField;
		this.AlamatTextField = AlamatTextField;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		TransaksiSIMPreparedStatement prep1 = new TransaksiSIMPreparedStatement();

		try {
			List<TransaksiSimpan> Anggota = prep1.selectAnggota();
			for (TransaksiSimpan simm : Anggota) {
				if (NIATextField.getText().matches(simm.getNIA())) {
					NamaTextField.setText(simm.getNama());
					AlamatTextField.setText(simm.getAlamat());
				} else if (prep1.selectAnggota().isEmpty()) {

					JOptionPane.showMessageDialog(null, "Angota Belum Terdaftar", "informasi",
							JOptionPane.WARNING_MESSAGE);
				}

			}

		} catch (

		ClassNotFoundException e)

		{
			e.printStackTrace();
		} catch (

		SQLException e)

		{
			e.printStackTrace();
		}

	}
}
