package Coba.TramsaksiAMB;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Coba.common.BankConstantsDefinition;

public class TransaksiAMBPreparedStatement {

	private Connection getConn() throws ClassNotFoundException, SQLException {
		Class.forName(BankConstantsDefinition.DATABASE_DRIVER);
		Connection Conn = DriverManager.getConnection(BankConstantsDefinition.DATABASE_CONNECTION_URL,
				BankConstantsDefinition.DATABASE_CONNECTION_USERNAME,
				BankConstantsDefinition.DATABASE_CONNECTION_PASSWORD);
		return Conn;

	}

	public int Insrt(TransaksiAmbil insertAMBdet) throws ClassNotFoundException, SQLException {
		PreparedStatement aInsert = getConn()
				.prepareStatement("Insert into detailambil(NoTS,NIA,Tanggal,Total_Uang)values(?,?,?,?)");

		aInsert.setString(1, insertAMBdet.getNoTS());
		aInsert.setString(2, insertAMBdet.getNIA());
		aInsert.setString(3, insertAMBdet.getTanggal());
		aInsert.setString(4, insertAMBdet.getUang());
		return aInsert.executeUpdate();
	}

	public List<TransaksiAmbil> selectAMB() throws ClassNotFoundException, SQLException {
		List<TransaksiAmbil> Transim = new ArrayList<TransaksiAmbil>();
		PreparedStatement Sel = getConn().prepareStatement("select NOTs,NIA,Total_Saldo from simpanan");
		ResultSet rs = Sel.executeQuery();
		while (rs.next()) {
			TransaksiAmbil si = new TransaksiAmbil();
			si.setNoTS(rs.getString("NOTs"));
			si.setNIA(rs.getString("NIA"));
			si.setSaldo(rs.getString("Total_Saldo"));
			Transim.add(si);
		}
		return Transim;

	}

	public List<TransaksiAmbil> selectDetamb() throws ClassNotFoundException, SQLException {
		List<TransaksiAmbil> Transimm = new ArrayList<TransaksiAmbil>();
		PreparedStatement seldet = getConn().prepareStatement("select NOTs,NIA,Tanggal,Total_Uang from detailambil");
		ResultSet rss = seldet.executeQuery();
		while (rss.next()) {
			TransaksiAmbil simdett = new TransaksiAmbil();
			simdett.setNoTS(rss.getString("NOTs"));
			simdett.setNIA(rss.getString("NIA"));
			simdett.setTanggal(rss.getString("Tanggal"));
			simdett.setUang(rss.getString("Total_Uang"));
			Transimm.add(simdett);

		}
		return Transimm;
	}

	public int Update(TransaksiAmbil Updatesim) throws ClassNotFoundException, SQLException {
		PreparedStatement pUpdate = getConn().prepareStatement("Update simpanan set Total_Saldo=? where NIA=?");
		pUpdate.setString(1, Updatesim.getUang());
		pUpdate.setString(2, Updatesim.getNIA());

		return pUpdate.executeUpdate();
	}

	public int insert(TransaksiAmbil insertSIM) throws ClassNotFoundException, SQLException {
		PreparedStatement pInsert = getConn()
				.prepareStatement("insert into simpanan(NOTs,NIA,Total_Saldo) values(?,?,?)");
		pInsert.setString(1, insertSIM.getNoTS());
		pInsert.setString(2, insertSIM.getNIA());
		pInsert.setString(3, insertSIM.getUang());
		return pInsert.executeUpdate();

	}

	public List<TransaksiAmbil> selectAnggota() throws ClassNotFoundException, SQLException {
		List<TransaksiAmbil> Transim = new ArrayList<TransaksiAmbil>();
		PreparedStatement Sel = getConn().prepareStatement("select NIA,Nama,Alamat from anggota");
		ResultSet rs = Sel.executeQuery();
		while (rs.next()) {
			TransaksiAmbil si = new TransaksiAmbil();
			si.setNIA(rs.getString("NIA"));
			si.setNama(rs.getString("Nama"));
			si.setAlamat(rs.getString("Alamat"));
			Transim.add(si);
		}
		return Transim;

	}

}
