package Coba.Report.gui;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Coba.action.Report.CekSaldoClickListener;
import Coba.common.BankConstantsDefinition;
import Coba.data.gui.AbstractFrameConstructor;

public class CekSaldoGui extends AbstractFrameConstructor {

	private JInternalFrame CekSaldoFrame;

	private JLabel NIALabel;
	private JLabel PasswordLabel;

	private JTextField NIATextField;
	private JTextField PasswordTextField;

	private JButton CekSaldoButton;

	public CekSaldoGui() {
		super();
	}

	@Override
	protected void construcgui() {
		// TODO Auto-generated method stub

		CekSaldoFrame = new JInternalFrame(BankConstantsDefinition.FRAME_CEKSALDO_TITLE, true, true, true, true);
		CekSaldoFrame.setBounds(50, 0, 500, 200);
		CekSaldoFrame.setLayout(null);
		CekSaldoFrame.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);

		NIALabel = new JLabel(BankConstantsDefinition.LABEL_CEKSALDO_NIA);
		PasswordLabel = new JLabel(BankConstantsDefinition.LABEL_CEKSALDO_PASSWORD);
		NIATextField = new JTextField(20);
		PasswordTextField = new JTextField(20);

		CekSaldoButton = new JButton(BankConstantsDefinition.BUTTON_COMMON_CEKSALDO);
	}

	@Override
	protected void addFrameComponent() {
		// TODO Auto-generated method stub
		CekSaldoFrame.add(NIALabel);
		CekSaldoFrame.add(PasswordLabel);

		CekSaldoFrame.add(NIATextField);
		CekSaldoFrame.add(PasswordTextField);

		CekSaldoFrame.add(CekSaldoButton);

		NIALabel.setBounds(10, 10, 70, 20);
		PasswordLabel.setBounds(10, 35, 70, 20);

		NIATextField.setBounds(100, 10, 130, 20);
		PasswordTextField.setBounds(100, 35, 130, 20);

		CekSaldoButton.setBounds(230, 35, 100, 20);
	}

	@Override
	protected void addFrameAction() {
		// TODO Auto-generated method stub
		CekSaldoButton.addActionListener(new CekSaldoClickListener(NIATextField, PasswordTextField));
	}

	public JInternalFrame getCekSaldoFrame() {
		return CekSaldoFrame;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		CekSaldoFrame.setVisible(true);
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		CekSaldoFrame.setVisible(false);
	}

}
