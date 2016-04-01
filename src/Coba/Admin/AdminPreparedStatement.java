package Coba.Admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Coba.common.BankConstantsDefinition;

public class AdminPreparedStatement {
	private Connection getConn() throws ClassNotFoundException, SQLException {
		Class.forName(BankConstantsDefinition.DATABASE_DRIVER);
		Connection conn = DriverManager.getConnection(BankConstantsDefinition.DATABASE_CONNECTION_URL,
				BankConstantsDefinition.DATABASE_CONNECTION_USERNAME,
				BankConstantsDefinition.DATABASE_CONNECTION_PASSWORD);
		return conn;
	}

	public List<Admin> selAdmin() throws ClassNotFoundException, SQLException {
		List<Admin> admin = new ArrayList<Admin>();
		PreparedStatement Sel = getConn().prepareStatement("select NIP,Nama,Tlp,Password from admin");
		ResultSet rs = Sel.executeQuery();
		while (rs.next()) {
			Admin ad = new Admin();
			ad.setNIP(rs.getString("NIP"));
			ad.setNama(rs.getString("Nama"));
			ad.setTlp(rs.getString("Tlp"));
			ad.setPassword(rs.getString("Password"));
			admin.add(ad);
		}
		return admin;
	}

	public int insert(Admin adm) throws ClassNotFoundException, SQLException {
		PreparedStatement pInsert = getConn()
				.prepareStatement("insert into admin(NIP,Nama,Tlp,Password) values(?,?,?,?)");
		pInsert.setString(1, adm.getNIP());
		pInsert.setString(2, adm.getNama());
		pInsert.setString(3, adm.getTlp());
		pInsert.setString(4, adm.getPassword());

		return pInsert.executeUpdate();
	}

	public int Update(Admin Upadm) throws ClassNotFoundException, SQLException {
		PreparedStatement pUpdate = getConn().prepareStatement("Update admin set Password=? where NIP=?");
		pUpdate.setString(1, Upadm.getPassword());
		pUpdate.setString(2, Upadm.getNIP());

		return pUpdate.executeUpdate();
	}
}