package Coba.Transfer;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Coba.common.BankConstantsDefinition;

public class TransferPreparedStatement {
	private Connection getConn() throws ClassNotFoundException, SQLException {
		Class.forName(BankConstantsDefinition.DATABASE_DRIVER);
		Connection Conn = DriverManager.getConnection(BankConstantsDefinition.DATABASE_CONNECTION_URL,
				BankConstantsDefinition.DATABASE_CONNECTION_USERNAME,
				BankConstantsDefinition.DATABASE_CONNECTION_PASSWORD);
		return Conn;

	}

	public List<Transfer> selectTransfer() throws ClassNotFoundException, SQLException {
		List<Transfer> Transfer = new ArrayList<Transfer>();
		PreparedStatement transfer = getConn().prepareStatement("select NOTS,Tanggal,NIA,NIAtujuan,Uang from transfer");
		ResultSet rs = transfer.executeQuery();
		while (rs.next()) {
			Transfer si = new Transfer();
			si.setNOTS(rs.getString("NOTS"));
			si.setTanggal(rs.getString("Tanggal"));
			si.setNIA1(rs.getString("NIA"));
			si.setNIA2(rs.getString("NIAtujuan"));
			si.setUang(rs.getString("Uang"));
			Transfer.add(si);
		}
		return Transfer;

	}

	public int Update1(Transfer Update) throws ClassNotFoundException, SQLException {
		PreparedStatement pUpdate = getConn().prepareStatement("Update simpanan set Total_Saldo=? where NIA=?");
		pUpdate.setString(1, Update.getUang());
		pUpdate.setString(2, Update.getNIA1());

		return pUpdate.executeUpdate();
	}

	public int Update2(Transfer Update2) throws ClassNotFoundException, SQLException {
		PreparedStatement pUpdate = getConn().prepareStatement("Update simpanan set Total_Saldo=? where NIA=?");
		pUpdate.setString(1, Update2.getUang());
		pUpdate.setString(2, Update2.getNIA2());

		return pUpdate.executeUpdate();
	}

	public int insert(Transfer insert) throws ClassNotFoundException, SQLException {
		PreparedStatement pInsert = getConn()
				.prepareStatement("insert into transfer(NOTS,Tanggal,NIA,NIAtujuan,Uang) values(?,?,?,?,?)");
		pInsert.setString(1, insert.getNOTS());
		pInsert.setString(2, insert.getTanggal());
		pInsert.setString(3, insert.getNIA1());
		pInsert.setString(4, insert.getNIA2());
		pInsert.setString(5, insert.getUang());
		return pInsert.executeUpdate();

	}

	public List<Transfer> selectSaldo1() throws ClassNotFoundException, SQLException {
		List<Transfer> Transim = new ArrayList<Transfer>();
		PreparedStatement Sel = getConn().prepareStatement("select NIA,Total_Saldo from simpanan");
		ResultSet rs = Sel.executeQuery();
		while (rs.next()) {
			Transfer tras = new Transfer();
			tras.setNIA1(rs.getString("NIA"));
			tras.setNIA2(rs.getString("NIA"));
			tras.setUang(rs.getString("Total_Saldo"));
			Transim.add(tras);
		}
		return Transim;

	}

}
