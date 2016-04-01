package Coba.Anggota;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Coba.Anggota.Anggota;
import Coba.common.BankConstantsDefinition;

public class AnggotaPreparedStatement {
	private Connection getConn() throws ClassNotFoundException, SQLException {
		Class.forName(BankConstantsDefinition.DATABASE_DRIVER);
		Connection conn = DriverManager.getConnection(BankConstantsDefinition.DATABASE_CONNECTION_URL,
				BankConstantsDefinition.DATABASE_CONNECTION_USERNAME,
				BankConstantsDefinition.DATABASE_CONNECTION_PASSWORD);
		return conn;
	}

	public List<Anggota> selAnggota() throws ClassNotFoundException, SQLException {
		List<Anggota> Anggota = new ArrayList<Anggota>();
		PreparedStatement Sel = getConn().prepareStatement("select NIA,Nama,Alamat,Tlp,password from anggota");
		ResultSet rs = Sel.executeQuery();
		while (rs.next()) {
			Anggota ag = new Anggota();
			ag.setNIA(rs.getString("NIA"));
			ag.setNama(rs.getString("Nama"));
			ag.setAlamat(rs.getString("Alamat"));
			ag.setTlp(rs.getString("Tlp"));
			ag.setPassword(rs.getString("password"));
			Anggota.add(ag);
		}
		return Anggota;

	}

	public int insert(Anggota mhs) throws ClassNotFoundException, SQLException {
		PreparedStatement pInsert = getConn()
				.prepareStatement("insert into anggota(NIA,Nama,Alamat,Tlp,password) values(?,?,?,?,?)");
		pInsert.setString(1, mhs.getNIA());
		pInsert.setString(2, mhs.getNama());
		pInsert.setString(3, mhs.getAlamat());
		pInsert.setString(4, mhs.getTlp());
		pInsert.setString(5, mhs.getPassword());

		return pInsert.executeUpdate();
	}

	public int Update(Anggota UpdateAng) throws ClassNotFoundException, SQLException {
		PreparedStatement pUpdate = getConn().prepareStatement("Update anggota set password=? where NIA=?");
		pUpdate.setString(1, UpdateAng.getPassword());
		pUpdate.setString(2, UpdateAng.getNIA());

		return pUpdate.executeUpdate();
	}

}
