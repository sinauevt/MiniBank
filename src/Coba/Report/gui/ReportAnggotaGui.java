package Coba.Report.gui;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import Coba.Report.ReportAnggota;
import Coba.common.BankConstantsDefinition;
import Coba.data.gui.AbstractFrameConstructor;

public class ReportAnggotaGui extends AbstractFrameConstructor {

	private JInternalFrame LaporanAnggotaFrame;
	private JLabel HeaderLabel;
	private JButton CetakButton;

	public ReportAnggotaGui() {
		super();
	}

	@Override
	protected void construcgui() {
		// TODO Auto-generated method stub
		LaporanAnggotaFrame = new JInternalFrame(BankConstantsDefinition.FRAME_LAPORAN_TITLE, true, true, true, true);
		LaporanAnggotaFrame.setBounds(50, 0, 400, 200);
		LaporanAnggotaFrame.setLayout(null);
		LaporanAnggotaFrame.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);

		HeaderLabel = new JLabel(BankConstantsDefinition.LABEL_LAPORAN_HEADER);

		CetakButton = new JButton(BankConstantsDefinition.BUTTON_COMMON_CETAK);

	}

	@Override
	protected void addFrameComponent() {
		// TODO Auto-generated method stub

		LaporanAnggotaFrame.add(HeaderLabel);

		LaporanAnggotaFrame.add(CetakButton);

		HeaderLabel.setBounds(30, 30, 300, 40);

		CetakButton.setBounds(30, 80, 90, 20);
	}

	@Override
	protected void addFrameAction() {
		// TODO Auto-generated method stub
		CetakButton.addActionListener(new ReportAnggota());
	}

	public JInternalFrame getLaporanAnggotaFrame() {
		return LaporanAnggotaFrame;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		LaporanAnggotaFrame.setVisible(true);

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		LaporanAnggotaFrame.setVisible(false);
	}

}
