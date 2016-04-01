package Coba.action.login;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JTextField;

import Coba.Admin.Admin;
import Coba.Admin.AdminPreparedStatement;
import Coba.Anggota.Anggota;
import Coba.Anggota.AnggotaPreparedStatement;
import Coba.main.MainAdminGui;
import Coba.main.MainAnggotaGui;

public class LoginClickListener implements ActionListener {

	private JTextField UserTextField;
	private JTextField PasswordTextField;

	public LoginClickListener(JTextField UserTextField, JTextField PasswordTextField) {
		this.UserTextField = UserTextField;
		this.PasswordTextField = PasswordTextField;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		try {
			AnggotaPreparedStatement prep = new AnggotaPreparedStatement();
			List<Anggota> Anggota = prep.selAnggota();
			for (Anggota ag : Anggota) {
				if (UserTextField.getText().matches(ag.getNIA())) {
					if (PasswordTextField.getText().matches(ag.getPassword())) {

						MainAnggotaGui gui1 = new MainAnggotaGui();
						gui1.show();
					}
				}

			}

			AdminPreparedStatement prep1 = new AdminPreparedStatement();
			List<Admin> adm = prep1.selAdmin();
			for (Admin admin : adm) {
				if (UserTextField.getText().matches(admin.getNIP())) {
					if (PasswordTextField.getText().matches(admin.getPassword())) {

						MainAdminGui gui = new MainAdminGui();
						gui.show();
					}
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
