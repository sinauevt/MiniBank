package Coba.data.gui;

import java.sql.SQLException;

import java.util.List;

import javax.swing.JButton;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Coba.Anggota.Anggota;
import Coba.Anggota.AnggotaPreparedStatement;
import Coba.action.data.AnggotaClickListener;
import Coba.action.data.ClearAnggota;
import Coba.common.BankConstantsDefinition;

public class AnggotaGui extends AbstractFrameConstructor {

	private JInternalFrame AnggotaFrame;
	private JLabel NIALabel;
	private JLabel NamaLabel;
	private JLabel AlamatLabel;
	private JLabel TlpLabel;
	private JLabel PasswordLabel;

	private JTextField NIATextField;
	private JTextField NamaTextField;
	private JTextField AlamatTextField;
	private JTextField TlpTextField;
	private JTextField PasswordTextField;

	private JButton SimpanButton;
	private JButton BatalButton;

	public AnggotaGui() {
		super();
	}

	@Override
	protected void construcgui() {
		// TODO Auto-generated method stub

		AnggotaFrame = new JInternalFrame(BankConstantsDefinition.FRAME_ANGGOTA_TITLE, true, true, true, true);
		AnggotaFrame.setSize(400, 200);
		AnggotaFrame.setLayout(null);
		AnggotaFrame.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);

		NIALabel = new JLabel(BankConstantsDefinition.LABEL_ANGGOTA_NIA);
		NamaLabel = new JLabel(BankConstantsDefinition.LABEL_ANGGOTA_NAMA);
		AlamatLabel = new JLabel(BankConstantsDefinition.LABEL_ANGGOTA_ALAMAT);
		TlpLabel = new JLabel(BankConstantsDefinition.LABEL_ANGGOTA_TLP);
		PasswordLabel = new JLabel(BankConstantsDefinition.LABEL_ANGGOTA_PASSWORD);

		NIATextField = new JTextField(20);
		NamaTextField = new JTextField(20);
		AlamatTextField = new JTextField(20);
		TlpTextField = new JTextField(20);
		PasswordTextField = new JTextField(20);

		SimpanButton = new JButton(BankConstantsDefinition.BUTTON_COMMON_SIMPAN);
		BatalButton = new JButton(BankConstantsDefinition.BUTTON_COMMON_BATAL);

	}

	@Override
	protected void addFrameComponent() {
		// TODO Auto-generated method stub

		AnggotaFrame.add(NIALabel);
		AnggotaFrame.add(NamaLabel);
		AnggotaFrame.add(AlamatLabel);
		AnggotaFrame.add(TlpLabel);
		AnggotaFrame.add(PasswordLabel);

		AnggotaFrame.add(NIATextField);
		AnggotaFrame.add(NamaTextField);
		AnggotaFrame.add(AlamatTextField);
		AnggotaFrame.add(TlpTextField);
		AnggotaFrame.add(PasswordTextField);

		AnggotaFrame.add(SimpanButton);
		AnggotaFrame.add(BatalButton);

		NIALabel.setBounds(10, 10, 100, 20);
		NamaLabel.setBounds(10, 35, 100, 20);
		AlamatLabel.setBounds(10, 60, 100, 20);
		TlpLabel.setBounds(10, 85, 100, 20);
		PasswordLabel.setBounds(10, 110, 100, 20);

		NIATextField.setBounds(150, 10, 200, 20);
		NamaTextField.setBounds(150, 35, 200, 20);
		AlamatTextField.setBounds(150, 60, 200, 20);
		TlpTextField.setBounds(150, 85, 200, 20);
		PasswordTextField.setBounds(150, 110, 200, 20);

		SimpanButton.setBounds(150, 135, 90, 20);
		BatalButton.setBounds(250, 135, 90, 20);
	}

	@Override
	protected void addFrameAction() {
		// TODO Auto-generated method stub
		AnggotaPreparedStatement prep1 = new AnggotaPreparedStatement();
		try {
			List<Anggota> nia = prep1.selAnggota();
			for (Anggota Ag : nia) {

				int a = Integer.parseInt(Ag.getNIA());
				int b = a + 1;
				NIATextField.setText(String.valueOf(b));
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

		SimpanButton.addActionListener(new AnggotaClickListener(NIATextField, NamaTextField, AlamatTextField,
				TlpTextField, PasswordTextField));
		BatalButton.addActionListener(
				new ClearAnggota(NIATextField, NamaTextField, AlamatTextField, TlpTextField, PasswordTextField));

	}

	public JInternalFrame getAnggotaFrame() {
		return AnggotaFrame;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		AnggotaFrame.setVisible(true);
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		AnggotaFrame.setVisible(false);
	}

}
