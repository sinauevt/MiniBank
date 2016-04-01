package Coba.data.gui;

import java.sql.SQLException;

import java.util.List;

import javax.swing.JButton;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Coba.Admin.Admin;
import Coba.Admin.AdminPreparedStatement;
import Coba.common.BankConstantsDefinition;

public class AdminGui extends AbstractFrameConstructor {
	private JInternalFrame AdminFrame;
	private JLabel NIPLabel;
	private JLabel NamaLabel;
	private JLabel TlpLabel;
	private JLabel PasswordLabel;

	private JTextField NIPTextField;
	private JTextField NamaTextField;
	private JTextField TlpTextField;
	private JTextField PasswordTextField;

	private JButton SimpanButton;
	private JButton BatalButton;

	public AdminGui() {
		super();
	}

	@Override
	protected void construcgui() {
		// TODO Auto-generated method stub
		AdminFrame = new JInternalFrame(BankConstantsDefinition.FRAME_ADMIN_TITLE, true, true, true, true);
		AdminFrame.setSize(400, 200);
		AdminFrame.setLayout(null);
		AdminFrame.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);

		NIPLabel = new JLabel(BankConstantsDefinition.LABEL_ADMIN_NIP);
		NamaLabel = new JLabel(BankConstantsDefinition.LABEL_ADMIN_NAMA);
		TlpLabel = new JLabel(BankConstantsDefinition.LABEL_ADMIN_TLP);
		PasswordLabel = new JLabel(BankConstantsDefinition.LABEL_ADMIN_PASSWORD);

		NIPTextField = new JTextField(20);
		NamaTextField = new JTextField(20);
		TlpTextField = new JTextField(20);
		PasswordTextField = new JTextField(20);

		SimpanButton = new JButton(BankConstantsDefinition.BUTTON_COMMON_SIMPAN);
		BatalButton = new JButton(BankConstantsDefinition.BUTTON_COMMON_BATAL);

	}

	@Override
	protected void addFrameComponent() {
		// TODO Auto-generated method stub

		AdminFrame.add(NIPLabel);
		AdminFrame.add(NamaLabel);
		AdminFrame.add(TlpLabel);
		AdminFrame.add(PasswordLabel);

		AdminFrame.add(NIPTextField);
		AdminFrame.add(NamaTextField);
		AdminFrame.add(TlpTextField);
		AdminFrame.add(PasswordTextField);

		AdminFrame.add(SimpanButton);
		AdminFrame.add(BatalButton);

		NIPLabel.setBounds(10, 10, 100, 20);
		NamaLabel.setBounds(10, 35, 100, 20);
		TlpLabel.setBounds(10, 60, 100, 20);
		PasswordLabel.setBounds(10, 85, 100, 20);

		NIPTextField.setBounds(150, 10, 200, 20);
		NamaTextField.setBounds(150, 35, 200, 20);
		TlpTextField.setBounds(150, 60, 200, 20);
		PasswordTextField.setBounds(150, 85, 200, 20);

		SimpanButton.setBounds(150, 110, 90, 20);
		BatalButton.setBounds(250, 110, 90, 20);
	}

	@Override
	protected void addFrameAction() {
		// TODOo-generated method stub
		AdminPreparedStatement prep1 = new AdminPreparedStatement();
		try {
			List<Admin> nia = prep1.selAdmin();
			for (Admin Ag : nia) {

				int a = Integer.parseInt(Ag.getNIP());
				int b = a + 1;
				NIPTextField.setText(String.valueOf(b));
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

	public JInternalFrame getAdminFrame() {
		return AdminFrame;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		AdminFrame.setVisible(true);
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		AdminFrame.setVisible(false);
	}

}
