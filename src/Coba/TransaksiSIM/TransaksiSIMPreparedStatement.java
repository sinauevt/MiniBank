package Coba.TransaksiSIM;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import Coba.common.BankConstantsDefinition;

public class TransaksiSIMPreparedStatement {

	private Connection getConn() throws ClassNotFoundException, SQLException {
		Class.forName(BankConstantsDefinition.DATABASE_DRIVER);
		Connection Conn = DriverManager.getConnection(BankConstantsDefinition.DATABASE_CONNECTION_URL,
				BankConstantsDefinition.DATABASE_CONNECTION_USERNAME,
				BankConstantsDefinition.DATABASE_CONNECTION_PASSWORD);
		return Conn;

	}

	public List<TransaksiSimpan> selectSIM() throws ClassNotFoundException, SQLException {
		List<TransaksiSimpan> Transim = new ArrayList<TransaksiSimpan>();
		PreparedStatement Sel = getConn().prepareStatement("select NOTs,NIA,Total_Saldo from simpanan");
		ResultSet rs = Sel.executeQuery();
		while (rs.next()) {
			TransaksiSimpan si = new TransaksiSimpan();
			si.setNoTS(rs.getString("NOTs"));
			si.setNIA(rs.getString("NIA"));
			si.setUang(rs.getString("Total_Saldo"));
			Transim.add(si);
		}
		return Transim;

	}

	public List<TransaksiSimpan> selectDetsim() throws ClassNotFoundException, SQLException {
		List<TransaksiSimpan> Transimm = new ArrayList<TransaksiSimpan>();
		PreparedStatement seldet = getConn().prepareStatement("select NOTs,NIA,Tanggal,Total_Uang from detailsimpan");
		ResultSet rss = seldet.executeQuery();
		while (rss.next()) {
			TransaksiSimpan simdett = new TransaksiSimpan();
			simdett.setNoTS(rss.getString("NOTs"));
			simdett.setNIA(rss.getString("NIA"));
			simdett.setTanggal(rss.getString("Tanggal"));
			simdett.setUang(rss.getString("Total_Uang"));
			Transimm.add(simdett);

		}
		return Transimm;
	}

	public int Update(TransaksiSimpan Updatesim) throws ClassNotFoundException, SQLException {
		PreparedStatement pUpdate = getConn().prepareStatement("Update simpanan set Total_Saldo=? where NIA=?");
		pUpdate.setString(1, Updatesim.getUang());
		pUpdate.setString(2, Updatesim.getNIA());

		return pUpdate.executeUpdate();
	}

	public int insert(TransaksiSimpan insertSIM) throws ClassNotFoundException, SQLException {
		PreparedStatement pInsert = getConn()
				.prepareStatement("insert into simpanan(NOTs,NIA,Total_Saldo) values(?,?,?)");
		pInsert.setString(1, insertSIM.getNoTS());
		pInsert.setString(2, insertSIM.getNIA());
		pInsert.setString(3, insertSIM.getUang());
		return pInsert.executeUpdate();

	}

	public int insertt(TransaksiSimpan insertSIMdet) throws ClassNotFoundException, SQLException {
		PreparedStatement pInsertt = getConn()
				.prepareStatement("insert into detailsimpan (NOTs,NIA,Tanggal,Total_Uang) values(?,?,?,?)");
		pInsertt.setString(1, insertSIMdet.getNoTS());
		pInsertt.setString(2, insertSIMdet.getNIA());
		pInsertt.setString(3, insertSIMdet.getTanggal());
		pInsertt.setString(4, insertSIMdet.getUang());
		return pInsertt.executeUpdate();
	}

	public List<TransaksiSimpan> selectAnggota() throws ClassNotFoundException, SQLException {
		List<TransaksiSimpan> Transim = new ArrayList<TransaksiSimpan>();
		PreparedStatement Sel = getConn().prepareStatement("select NIA,Nama,Alamat from anggota");
		ResultSet rs = Sel.executeQuery();
		while (rs.next()) {
			TransaksiSimpan si = new TransaksiSimpan();
			si.setNIA(rs.getString("NIA"));
			si.setNama(rs.getString("Nama"));
			si.setAlamat(rs.getString("Alamat"));
			Transim.add(si);
		}
		return Transim;

	}
	// TODO Auto-generated method stub

}
