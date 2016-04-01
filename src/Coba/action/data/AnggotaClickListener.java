package Coba.action.data;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Coba.Anggota.Anggota;
import Coba.Anggota.AnggotaPreparedStatement;

public class AnggotaClickListener implements ActionListener {

	private JTextField NIATextField;
	private JTextField NamaTextField;
	private JTextField AlamatTextField;
	private JTextField TlpTextField;
	private JTextField PasswordTextField;

	public AnggotaClickListener(JTextField NIATextField, JTextField NamaTextField, JTextField AlamatTextField,
			JTextField TlpTextField, JTextField PasswordTextField) {

		this.NIATextField = NIATextField;
		this.NamaTextField = NamaTextField;
		this.AlamatTextField = AlamatTextField;
		this.TlpTextField = TlpTextField;
		this.PasswordTextField = PasswordTextField;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		AnggotaPreparedStatement prep = new AnggotaPreparedStatement();

		try {
			// INSERT
			Anggota mhsInsert = new Anggota();
			mhsInsert.setNIA(NIATextField.getText());
			mhsInsert.setNama(NamaTextField.getText());
			mhsInsert.setAlamat(AlamatTextField.getText());
			mhsInsert.setTlp(TlpTextField.getText());
			mhsInsert.setPassword(PasswordTextField.getText());
			if (prep.insert(mhsInsert) >= 1) {
				JOptionPane.showMessageDialog(null, "Data Sudah Ditambah ke DataBase", "informasi",
						JOptionPane.WARNING_MESSAGE);

			} else {
				System.out.println("Insert Mahasiswa Gagal!");
			}

		} catch (ClassNotFoundException a) {
			a.printStackTrace();
		} catch (SQLException a) {
			a.printStackTrace();
		}
		NIATextField.setText("");
		NamaTextField.setText("");
		AlamatTextField.setText("");
		TlpTextField.setText("");
		PasswordTextField.setText("");

	}

}
