package Coba.Transfer.gui;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Coba.Transfer.Transfer;
import Coba.Transfer.TransferPreparedStatement;
import Coba.action.transfer.TransferClickListener;
import Coba.common.BankConstantsDefinition;
import Coba.data.gui.AbstractFrameConstructor;

public class TransferGui extends AbstractFrameConstructor {
	private JInternalFrame TransferFrame;
	private JLabel NOTSLabel;
	private JLabel TanggalLabel;
	private JLabel NIA1Label;
	private JLabel NIA2Label;
	private JLabel UangLabel;

	private JTextField NOTSTextField;
	private JTextField TanggalTextField;
	private JTextField NIA1TextField;
	private JTextField NIA2TextField;
	private JTextField UangTextField;

	private JButton TransferButton;
	private JButton BatalButton;

	public TransferGui() {
		super();
	}

	@Override
	protected void construcgui() {
		// TODO Auto-generated method stub
		TransferFrame = new JInternalFrame(BankConstantsDefinition.FRAME_TRANSFER_TITLE, true, true, true, true);
		TransferFrame.setBounds(50, 0, 500, 300);
		TransferFrame.setLayout(null);
		TransferFrame.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);

		NOTSLabel = new JLabel(BankConstantsDefinition.LABEL_TRANSFER_NOTS);
		TanggalLabel = new JLabel(BankConstantsDefinition.LABEL_TRANSFER_TANGGAL);
		NIA1Label = new JLabel(BankConstantsDefinition.LABEL_TRANSFER_NIA1);
		NIA2Label = new JLabel(BankConstantsDefinition.LABEL_TRANSFER_NIA2);
		UangLabel = new JLabel(BankConstantsDefinition.LABLE_TRANSFER_UANG);

		NOTSTextField = new JTextField(20);
		TanggalTextField = new JTextField(20);
		NIA1TextField = new JTextField(20);
		NIA2TextField = new JTextField(20);
		UangTextField = new JTextField(20);

		TransferButton = new JButton(BankConstantsDefinition.BUTTON_COMMON_TRANFER);
		BatalButton = new JButton(BankConstantsDefinition.BUTTON_COMMON_BATAL);

	}

	@Override
	protected void addFrameComponent() {
		// TODO Auto-generated method stub

		TransferFrame.add(NOTSLabel);
		TransferFrame.add(TanggalLabel);
		TransferFrame.add(NIA1Label);
		TransferFrame.add(NIA2Label);
		TransferFrame.add(UangLabel);

		TransferFrame.add(NOTSTextField);
		TransferFrame.add(TanggalTextField);
		TransferFrame.add(NIA1TextField);
		TransferFrame.add(NIA2TextField);
		TransferFrame.add(UangTextField);

		TransferFrame.add(TransferButton);
		TransferFrame.add(BatalButton);

		NOTSLabel.setBounds(10, 10, 100, 20);
		TanggalLabel.setBounds(10, 35, 100, 20);
		NIA1Label.setBounds(10, 60, 100, 20);
		NIA2Label.setBounds(10, 85, 100, 20);
		UangLabel.setBounds(10, 110, 100, 20);

		NOTSTextField.setBounds(150, 10, 200, 20);
		TanggalTextField.setBounds(150, 35, 200, 20);
		NIA1TextField.setBounds(150, 60, 200, 20);
		NIA2TextField.setBounds(150, 85, 200, 20);
		UangTextField.setBounds(150, 110, 200, 20);

		TransferButton.setBounds(150, 130, 80, 20);
		BatalButton.setBounds(250, 130, 80, 20);

	}

	@Override
	protected void addFrameAction() {
		// TODO Auto-generated method stub
		TransferPreparedStatement prep = new TransferPreparedStatement();
		try {

			List<Transfer> Saldo = prep.selectTransfer();
			for (Transfer SIM : Saldo) {
				int a = Integer.parseInt(SIM.getNOTS());
				int b = a + 1;
				NOTSTextField.setText(String.valueOf(b));
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

		TransferButton.addActionListener(new TransferClickListener(NOTSTextField, TanggalTextField, NIA1TextField,
				NIA2TextField, UangTextField));

	}

	public JInternalFrame getTransferFrame() {
		return TransferFrame;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		TransferFrame.setVisible(true);
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		TransferFrame.setVisible(false);
	}

}
