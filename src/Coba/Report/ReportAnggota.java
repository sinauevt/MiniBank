package Coba.Report;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.sql.SQLException;

import java.util.HashMap;
import java.util.Map;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class ReportAnggota implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
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
					"C:\\Users\\Turmuzi\\workspace\\reportbank\\Anggota.jasper", parameters,
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
