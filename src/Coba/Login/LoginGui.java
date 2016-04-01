package Coba.Login;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Coba.action.login.BatalLoginClickListener;
import Coba.action.login.LoginClickListener;
import Coba.common.BankConstantsDefinition;
import Coba.data.gui.AbstractFrameConstructor;

public class LoginGui extends AbstractFrameConstructor {

	private JFrame LoginFrame;
	private JLabel WelcomeLabel;
	private JLabel UserLabel;
	private JLabel PasswordLabel;

	private JTextField UserTextField;
	private JTextField PasswordTextField;

	private JButton LoginButton;
	private JButton BatalButton;

	public LoginGui() {
		super();
	}

	@Override
	protected void construcgui() {
		// TODO Auto-generated method stub

		LoginFrame = new JFrame(BankConstantsDefinition.FRAME_MAINFRAME_TITLELOGIN);
		LoginFrame.setBounds(50, 50, 350, 200);
		LoginFrame.setLayout(null);
		LoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		WelcomeLabel = new JLabel(BankConstantsDefinition.LABEL_LOGIN_WELCOME);
		UserLabel = new JLabel(BankConstantsDefinition.LABEL_LOGIN_USER);
		PasswordLabel = new JLabel(BankConstantsDefinition.LABEL_LOGIN_PASSWORD);

		UserTextField = new JTextField(20);
		PasswordTextField = new JTextField(20);

		LoginButton = new JButton(BankConstantsDefinition.BUTTON_COMMON_LOGIN);
		BatalButton = new JButton(BankConstantsDefinition.BUTTON_COMMON_BATAL);
	}

	@Override
	protected void addFrameComponent() {
		// TODO Auto-generated method stub
		LoginFrame.add(WelcomeLabel);
		LoginFrame.add(UserLabel);
		LoginFrame.add(PasswordLabel);

		LoginFrame.add(UserTextField);
		LoginFrame.add(PasswordTextField);

		LoginFrame.add(LoginButton);
		LoginFrame.add(BatalButton);

		WelcomeLabel.setBounds(10, 10, 300, 20);
		UserLabel.setBounds(10, 50, 100, 20);
		PasswordLabel.setBounds(10, 75, 100, 20);

		UserTextField.setBounds(100, 50, 200, 20);
		PasswordTextField.setBounds(100, 75, 200, 20);

		LoginButton.setBounds(100, 100, 70, 20);
		BatalButton.setBounds(180, 100, 70, 20);
	}

	@Override
	protected void addFrameAction() {
		// TODO Auto-generated method stub
		LoginButton.addActionListener(new LoginClickListener(UserTextField, PasswordTextField));
		BatalButton.addActionListener(new BatalLoginClickListener(UserTextField, PasswordTextField));
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		LoginFrame.setVisible(true);
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		LoginFrame.setVisible(false);
	}

}
