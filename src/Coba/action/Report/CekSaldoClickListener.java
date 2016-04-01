package Coba.action.Report;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.sql.SQLException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.JTextField;

import Coba.Anggota.Anggota;
import Coba.Report.CekSaldo;
import Coba.Report.CekSaldoPreparedStatement;

public class CekSaldoClickListener implements ActionListener {
	private JTextField NIATextField;
	private JTextField PasswordTextField;

	public CekSaldoClickListener(JTextField NIATextField, JTextField PasswordTextField) {
		this.NIATextField = NIATextField;
		this.PasswordTextField = PasswordTextField;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		CekSaldoPreparedStatement prep = new CekSaldoPreparedStatement();
		try {
			List<Anggota> ang = prep.selAnggota();
			for (Anggota anggota : ang)
				if (NIATextField.getText().equals(anggota.getNIA())) {
					if (PasswordTextField.getText().equals(anggota.getPassword())) {

						List<CekSaldo> cek = prep.Selectceksaldo();
						for (CekSaldo Saldo : cek)
							if (NIATextField.getText().equals(Saldo.getNIA())) {
								Map<String, Object> parameters = new HashMap<String, Object>();
								parameters.put("NIA", "1200001");
								MysqlDataSource mysqlDataSource = new MysqlDataSource();
								mysqlDataSource.setUser("root");
								mysqlDataSource.setPassword("");
								mysqlDataSource.setDatabaseName("dbbankmini");
								mysqlDataSource.setServerName("localhost");
								mysqlDataSource.setPortNumber(3306);

								try {
									JasperPrint jasperPrint = JasperFillManager.fillReport(
											"C:\\Users\\Turmuzi\\workspace\\reportbank\\ReportSaldo.jasper", parameters,
											mysqlDataSource.getConnection());
									JasperViewer.viewReport(jasperPrint);
								} catch (JRException e) {
									e.printStackTrace();
								} catch (SQLException e) {
									e.printStackTrace();
								} finally {
									try {
										mysqlDataSource.getConnection().close();
									} catch (SQLException e) {
										e.printStackTrace();
									}
								}
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