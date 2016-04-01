package Coba.tran.gui;

import javax.swing.JInternalFrame;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;

import Coba.TramsaksiAMB.TransaksiAMBPreparedStatement;
import Coba.TramsaksiAMB.TransaksiAmbil;
import Coba.action.transaksiAMB.TransaksiAMBClickListener;
import Coba.action.transaksiSIM.TransaksiSIMcekNIAClick;
import Coba.action.transaksiSIM.TransaksiSIMclearClick;
import Coba.common.BankConstantsDefinition;
import Coba.data.gui.AbstractFrameConstructor;

public class TransaksiAmbilGui extends AbstractFrameConstructor {
	private JInternalFrame TransaksiAMBFrame;
	private JLabel NoTSLabel;
	private JLabel NIALabel;
	private JLabel NamaLabel;
	private JLabel AlamatLabel;
	private JLabel TanggalLabel;
	private JLabel UangLabel;

	private JTextField NoTSTextField;
	private JTextField NIATextField;
	private JTextField NamaTextField;
	private JTextField AlamatTextField;
	private JTextField TanggalTextField;
	private JTextField UangTextField;

	private JButton SimpanButton;
	private JButton BatalButton;
	private JButton CekButton;

	public TransaksiAmbilGui() {
		super();
	}

	@Override
	protected void construcgui() {
		// TODO Auto-generated method stub

		TransaksiAMBFrame = new JInternalFrame(BankConstantsDefinition.FRAME_TRANSAKSIAMB_TITLE, true, true, true,
				true);
		TransaksiAMBFrame.setBounds(50, 0, 500, 300);
		TransaksiAMBFrame.setLayout(null);
		TransaksiAMBFrame.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);

		NoTSLabel = new JLabel(BankConstantsDefinition.LABEL_TRANSAKSIAMB_NOAMB);
		NIALabel = new JLabel(BankConstantsDefinition.LABEL_TRANSAKSIAMB_NIA);
		NamaLabel = new JLabel(BankConstantsDefinition.LABEL_TRANSAKSISIM_NAMA);
		AlamatLabel = new JLabel(BankConstantsDefinition.LABEL_TRANSAKSISIM_ALAMAT);
		TanggalLabel = new JLabel(BankConstantsDefinition.LABEL_TRANSAKSIAMB_TANGAL);
		UangLabel = new JLabel(BankConstantsDefinition.LABEL_TRANSAKSIAMB_UANG);

		NoTSTextField = new JTextField(20);
		NIATextField = new JTextField(20);
		NamaTextField = new JTextField(20);
		AlamatTextField = new JTextField(20);
		TanggalTextField = new JTextField(20);
		UangTextField = new JTextField(20);

		SimpanButton = new JButton(BankConstantsDefinition.BUTTON_COMMON_SIMPAN);
		BatalButton = new JButton(BankConstantsDefinition.BUTTON_COMMON_BATAL);
		CekButton = new JButton(BankConstantsDefinition.BUTTON_COMMON_CEK);

	}

	@Override
	protected void addFrameComponent() {
		// TODO Auto-generated method stub

		TransaksiAMBFrame.add(NoTSLabel);
		TransaksiAMBFrame.add(NIALabel);
		TransaksiAMBFrame.add(NamaLabel);
		TransaksiAMBFrame.add(AlamatLabel);
		TransaksiAMBFrame.add(TanggalLabel);
		TransaksiAMBFrame.add(UangLabel);

		TransaksiAMBFrame.add(NoTSTextField);
		TransaksiAMBFrame.add(NIATextField);
		TransaksiAMBFrame.add(NamaTextField);
		TransaksiAMBFrame.add(AlamatTextField);
		TransaksiAMBFrame.add(TanggalTextField);
		TransaksiAMBFrame.add(UangTextField);

		TransaksiAMBFrame.add(SimpanButton);
		TransaksiAMBFrame.add(BatalButton);
		TransaksiAMBFrame.add(CekButton);

		NoTSLabel.setBounds(10, 10, 100, 20);
		NIALabel.setBounds(10, 35, 100, 20);
		NamaLabel.setBounds(10, 60, 100, 20);
		AlamatLabel.setBounds(10, 85, 100, 20);
		TanggalLabel.setBounds(10, 135, 100, 20);
		UangLabel.setBounds(10, 160, 100, 20);

		NoTSTextField.setBounds(150, 10, 100, 20);
		NIATextField.setBounds(150, 35, 100, 20);
		NamaTextField.setBounds(150, 60, 200, 20);
		AlamatTextField.setBounds(150, 85, 100, 40);
		TanggalTextField.setBounds(150, 135, 200, 20);
		UangTextField.setBounds(150, 160, 200, 20);

		SimpanButton.setBounds(150, 185, 90, 20);
		BatalButton.setBounds(250, 185, 90, 20);
		CekButton.setBounds(270, 35, 83, 20);

	}

	@Override
	protected void addFrameAction() {
		// TODO Auto-generated method stub
		TransaksiAMBPreparedStatement prep1 = new TransaksiAMBPreparedStatement();
		try {
			List<TransaksiAmbil> Saldo = prep1.selectDetamb();
			for (TransaksiAmbil SIM : Saldo) {

				int a = Integer.parseInt(SIM.getNoTS());
				int b = a + 1;
				NoTSTextField.setText(String.valueOf(b));
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

		Date now = new Date();

		TanggalTextField.setText(String.valueOf(new SimpleDateFormat("yyyyMMdd").format(now)));

		SimpanButton.addActionListener(new TransaksiAMBClickListener(NoTSTextField, NIATextField, NamaTextField,
				AlamatTextField, TanggalTextField, UangTextField));
		CekButton.addActionListener(new TransaksiSIMcekNIAClick(NIATextField, NamaTextField, AlamatTextField));
		BatalButton.addActionListener(
				new TransaksiSIMclearClick(NIATextField, NamaTextField, AlamatTextField, UangTextField));

	}

	public JInternalFrame getTransaksiAMBFrame() {

		return TransaksiAMBFrame;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		TransaksiAMBFrame.setVisible(true);
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		TransaksiAMBFrame.setVisible(false);
	}

}
