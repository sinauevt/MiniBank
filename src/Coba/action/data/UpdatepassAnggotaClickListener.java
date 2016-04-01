package Coba.action.data;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Coba.Anggota.Anggota;
import Coba.Anggota.AnggotaPreparedStatement;

public class UpdatepassAnggotaClickListener implements ActionListener {

	private JTextField NIATextField;
	private JTextField PasswordTextField;

	public UpdatepassAnggotaClickListener(JTextField NIATextField, JTextField PasswordTextField) {
		this.NIATextField = NIATextField;
		this.PasswordTextField = PasswordTextField;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		AnggotaPreparedStatement prep = new AnggotaPreparedStatement();
		try {

			Anggota up = new Anggota();
			up.setNIA(NIATextField.getText());
			up.setPassword(PasswordTextField.getText());
			if (prep.Update(up) > 1) {
				JOptionPane.showMessageDialog(null, "Password Berhasil Di Ganti", "informasi",
						JOptionPane.WARNING_MESSAGE);
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
