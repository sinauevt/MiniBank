package Coba.main;

import java.awt.BorderLayout;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Coba.Report.gui.CekSaldoGui;
import Coba.Transfer.gui.TransferGui;
import Coba.action.data.MainBankMenuClickListener;
import Coba.common.BankConstantsDefinition;
import Coba.data.gui.AbstractFrameConstructor;
import Coba.data.gui.GantiPasswordAnggotaGui;

public class MainAnggotaGui extends AbstractFrameConstructor {
	private JFrame MainFrame;
	private JDesktopPane MainJDesktopPane;
	private JMenuBar MainJMenuBar;
	private JMenu ViewJMenu1;
	private JMenu ViewJMenu2;
	private JMenu ViewJMenu3;

	private JMenuItem ViewMenuItemTransfer;
	private JMenuItem ViewMenuItemGantipssAnggota;
	private JMenuItem ViewMenuItemCekSaldo;

	private TransferGui Transfer;
	private GantiPasswordAnggotaGui GantipssAnggota;
	private CekSaldoGui Ceksaldo;

	public MainAnggotaGui() {
		super();
	}

	@Override
	protected void construcgui() {
		// TODO Auto-generated method stub
		Transfer = new TransferGui();
		GantipssAnggota = new GantiPasswordAnggotaGui();
		Ceksaldo = new CekSaldoGui();

		MainJDesktopPane = new JDesktopPane();

		MainJMenuBar = new JMenuBar();
		ViewJMenu1 = new JMenu(BankConstantsDefinition.MENU_MAINFRAME_VIEW4);
		ViewMenuItemTransfer = new JMenuItem(BankConstantsDefinition.MENUITEM_MAINFRAME_VIEW_TRANSFER);

		ViewJMenu2 = new JMenu(BankConstantsDefinition.MENU_MAINFRAME_VIEW5);
		ViewMenuItemGantipssAnggota = new JMenuItem(BankConstantsDefinition.MENUITEM_MAINFRAME_VIEW_GANTIPSSANGGOTA);

		ViewJMenu3 = new JMenu(BankConstantsDefinition.MENU_MAINFRAME_VIEW6);
		ViewMenuItemCekSaldo = new JMenuItem(BankConstantsDefinition.MENUITEM_MAINFRME_VIEW_CEKSALDO);

		MainFrame = new JFrame(BankConstantsDefinition.FRAME_MAINFRAME_TITLE);
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainFrame.setBounds(50, 50, 700, 500);

	}

	@Override
	protected void addFrameComponent() {
		// TODO Auto-generated method stub

		MainJDesktopPane.add(Transfer.getTransferFrame());
		MainJDesktopPane.add(GantipssAnggota.getGantipssAnggotaFrame());
		MainJDesktopPane.add(Ceksaldo.getCekSaldoFrame());
		MainJDesktopPane.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);

		ViewJMenu1.add(ViewMenuItemTransfer);
		ViewJMenu3.add(ViewMenuItemCekSaldo);
		ViewJMenu2.add(ViewMenuItemGantipssAnggota);

		MainJMenuBar.add(ViewJMenu1);
		MainJMenuBar.add(ViewJMenu3);
		MainJMenuBar.add(ViewJMenu2);

		MainFrame.setJMenuBar(MainJMenuBar);
		MainFrame.add(MainJDesktopPane, BorderLayout.CENTER);
	}

	@Override
	protected void addFrameAction() {
		// TODO Auto-generated method stub
		ViewMenuItemTransfer.addActionListener(new MainBankMenuClickListener(Transfer, null));
		ViewMenuItemGantipssAnggota.addActionListener(new MainBankMenuClickListener(GantipssAnggota, null));
		ViewMenuItemCekSaldo.addActionListener(new MainBankMenuClickListener(Ceksaldo, null));
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		MainFrame.setVisible(true);
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		MainFrame.setVisible(false);
	}

}
