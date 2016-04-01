package Coba.data.gui;

import javax.swing.JButton;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Coba.action.data.UpdatepassAnggotaClickListener;
import Coba.common.BankConstantsDefinition;

public class GantiPasswordAnggotaGui extends AbstractFrameConstructor {
	private JInternalFrame GantipssAnggotaFrame;
	private JLabel NIALabel;
	private JLabel PasswordLabel;

	private JTextField NIATextField;
	private JTextField PasswordTextField;

	private JButton GantiButton;
	private JButton BatalButton;

	public GantiPasswordAnggotaGui() {
		super();

	}

	@Override
	protected void construcgui() {
		// TODO Auto-generated method stub
		GantipssAnggotaFrame = new JInternalFrame(BankConstantsDefinition.FRAME_GANTIPASSANGGOTA_TITLE);
		GantipssAnggotaFrame.setSize(400, 200);
		GantipssAnggotaFrame.setLayout(null);
		GantipssAnggotaFrame.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);

		NIALabel = new JLabel(BankConstantsDefinition.LABEL_GANTIPASSANGGOTA_NIA);
		PasswordLabel = new JLabel(BankConstantsDefinition.LABEL_GANTIPASSANGGOTA_PASSWORD);

		NIATextField = new JTextField(20);
		PasswordTextField = new JTextField(20);

		GantiButton = new JButton(BankConstantsDefinition.BUTTON_COMMON_GANTI);
		BatalButton = new JButton(BankConstantsDefinition.BUTTON_COMMON_BATAL);
	}

	@Override
	protected void addFrameComponent() {
		// TODO Auto-generated method stub
		GantipssAnggotaFrame.add(NIALabel);
		GantipssAnggotaFrame.add(PasswordLabel);

		GantipssAnggotaFrame.add(NIATextField);
		GantipssAnggotaFrame.add(PasswordTextField);

		GantipssAnggotaFrame.add(GantiButton);
		GantipssAnggotaFrame.add(BatalButton);

		NIALabel.setBounds(10, 10, 100, 20);
		PasswordLabel.setBounds(10, 35, 100, 20);

		NIATextField.setBounds(150, 10, 200, 20);
		PasswordTextField.setBounds(150, 35, 200, 20);

		GantiButton.setBounds(150, 60, 100, 20);
		BatalButton.setBounds(250, 60, 100, 20);
	}

	@Override
	protected void addFrameAction() {
		// TODO Auto-generated method stub
		GantiButton.addActionListener(new UpdatepassAnggotaClickListener(NIATextField,PasswordTextField));
	}
	

	public JInternalFrame getGantipssAnggotaFrame() {
		return GantipssAnggotaFrame;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		GantipssAnggotaFrame.setVisible(true);
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		GantipssAnggotaFrame.setVisible(false);
	}
}
