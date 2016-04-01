package Coba.Report;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Coba.Anggota.Anggota;
import Coba.common.BankConstantsDefinition;

public class CekSaldoPreparedStatement {
	private Connection getConn() throws ClassNotFoundException, SQLException {
		Class.forName(BankConstantsDefinition.DATABASE_DRIVER);
		Connection Conn = DriverManager.getConnection(BankConstantsDefinition.DATABASE_CONNECTION_URL,
				BankConstantsDefinition.DATABASE_CONNECTION_USERNAME,
				BankConstantsDefinition.DATABASE_CONNECTION_PASSWORD);
		return Conn;
	}

	public List<CekSaldo> Selectceksaldo() throws ClassNotFoundException, SQLException {
		List<CekSaldo> ceksaldo = new ArrayList<CekSaldo>();
		PreparedStatement cek = getConn().prepareStatement("select NIA,Total_Saldo from simpanan");
		ResultSet rs = cek.executeQuery();
		while (rs.next()) {
			CekSaldo saldo = new CekSaldo();
			saldo.setNIA(rs.getString("NIA"));
			saldo.setSaldo(rs.getString("Total_Saldo"));

			ceksaldo.add(saldo);

		}
		return ceksaldo;
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
}
