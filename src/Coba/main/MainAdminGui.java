package Coba.main;

import java.awt.BorderLayout;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Coba.Report.gui.CekSaldoGui;
import Coba.Report.gui.ReportAnggotaGui;
import Coba.Transfer.gui.TransferGui;
import Coba.action.data.MainBankMenuClickListener;
import Coba.common.BankConstantsDefinition;
import Coba.data.gui.AbstractFrameConstructor;
import Coba.data.gui.AdminGui;
import Coba.data.gui.AnggotaGui;
import Coba.data.gui.GantiPasswordAnggotaGui;
import Coba.tran.gui.TransaksiAmbilGui;
import Coba.tran.gui.TransaksiSimpanGui;

public class MainAdminGui extends AbstractFrameConstructor {

	private JFrame MainFrame;
	private JDesktopPane MainJDesktopPane;
	private JMenuBar MainJMenuBar;
	private JMenu ViewJMenu1;
	private JMenu ViewJMenu2;
	private JMenu ViewJMenu3;
	private JMenu ViewJMenu4;
	private JMenu ViewJMenu5;
	private JMenu ViewJMenu6;
	private JMenuItem ViewMenuItemAnggota;
	private JMenuItem ViewMenuItemAdmin;
	private JMenuItem ViewMenuItemTranSIM;
	private JMenuItem ViewMenuItemTranAMB;
	private JMenuItem ViewMenuItemLapAnggota;
	private JMenuItem ViewMenuItemTransfer;
	private JMenuItem ViewMenuItemGantipssAnggota;
	private JMenuItem ViewMenuItemCekSaldo;

	private TransaksiSimpanGui TransSIM;
	private AnggotaGui anggota;
	private AdminGui admin;
	private TransaksiAmbilGui TransAMB;
	private ReportAnggotaGui lapanggota;
	private TransferGui Transfer;
	private GantiPasswordAnggotaGui GantipssAnggota;
	private CekSaldoGui Ceksaldo;

	public MainAdminGui() {
		super();
	}

	@Override
	protected void construcgui() {
		// TODO Auto-generated method stub

		anggota = new AnggotaGui();
		admin = new AdminGui();
		TransSIM = new TransaksiSimpanGui();
		TransAMB = new TransaksiAmbilGui();
		lapanggota = new ReportAnggotaGui();
		Transfer = new TransferGui();
		GantipssAnggota = new GantiPasswordAnggotaGui();
		Ceksaldo = new CekSaldoGui();

		MainJDesktopPane = new JDesktopPane();

		MainJMenuBar = new JMenuBar();
		ViewJMenu1 = new JMenu(BankConstantsDefinition.MENU_MAINFRAME_VIEW);
		ViewMenuItemAnggota = new JMenuItem(BankConstantsDefinition.MENUITEM_MAINFRAME_VIEW_ANGGOTA);
		ViewMenuItemAdmin = new JMenuItem(BankConstantsDefinition.MENUITEM_MAINFRAME_VIEW_ADMIN);

		ViewJMenu2 = new JMenu(BankConstantsDefinition.MENU_MAINFRAME_VIEW2);
		ViewMenuItemTranSIM = new JMenuItem(BankConstantsDefinition.MENUITEM_MAINFRAME_VIEW_TRANSAKSISIM);
		ViewMenuItemTranAMB = new JMenuItem(BankConstantsDefinition.MENUITEM_MAINFRAME_VIEW_TRANSAKSIAMB);

		ViewJMenu3 = new JMenu(BankConstantsDefinition.MENU_MAINFRAME_VIEW3);
		ViewMenuItemLapAnggota = new JMenuItem(BankConstantsDefinition.MENUITEM_MAINfRAME_VIEW_LAPORAN_ANGGOTA);

		ViewJMenu4 = new JMenu(BankConstantsDefinition.MENU_MAINFRAME_VIEW4);
		ViewMenuItemTransfer = new JMenuItem(BankConstantsDefinition.MENUITEM_MAINFRAME_VIEW_TRANSFER);

		ViewJMenu5 = new JMenu(BankConstantsDefinition.MENU_MAINFRAME_VIEW5);
		ViewMenuItemGantipssAnggota = new JMenuItem(BankConstantsDefinition.MENUITEM_MAINFRAME_VIEW_GANTIPSSANGGOTA);

		ViewJMenu6 = new JMenu(BankConstantsDefinition.MENU_MAINFRAME_VIEW6);
		ViewMenuItemCekSaldo = new JMenuItem(BankConstantsDefinition.MENUITEM_MAINFRME_VIEW_CEKSALDO);

		MainFrame = new JFrame(BankConstantsDefinition.FRAME_MAINFRAME_TITLE);
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainFrame.setBounds(50, 50, 700, 500);

	}

	@Override
	protected void addFrameComponent() {
		// TODO Auto-generated method stub

		MainJDesktopPane.add(anggota.getAnggotaFrame());
		MainJDesktopPane.add(admin.getAdminFrame());
		MainJDesktopPane.add(TransSIM.getTransaksiSIMFrame());
		MainJDesktopPane.add(TransAMB.getTransaksiAMBFrame());
		MainJDesktopPane.add(lapanggota.getLaporanAnggotaFrame());
		MainJDesktopPane.add(Transfer.getTransferFrame());
		MainJDesktopPane.add(GantipssAnggota.getGantipssAnggotaFrame());
		MainJDesktopPane.add(Ceksaldo.getCekSaldoFrame());
		MainJDesktopPane.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
		ViewJMenu1.add(ViewMenuItemAdmin);
		ViewJMenu1.add(ViewMenuItemAnggota);
		ViewJMenu2.add(ViewMenuItemTranSIM);
		ViewJMenu2.add(ViewMenuItemTranAMB);
		ViewJMenu3.add(ViewMenuItemLapAnggota);
		ViewJMenu4.add(ViewMenuItemTransfer);
		ViewJMenu6.add(ViewMenuItemCekSaldo);
		ViewJMenu5.add(ViewMenuItemGantipssAnggota);

		MainJMenuBar.add(ViewJMenu1);
		MainJMenuBar.add(ViewJMenu2);
		MainJMenuBar.add(ViewJMenu3);
		MainJMenuBar.add(ViewJMenu4);
		MainJMenuBar.add(ViewJMenu6);
		MainJMenuBar.add(ViewJMenu5);

		MainFrame.setJMenuBar(MainJMenuBar);
		MainFrame.add(MainJDesktopPane, BorderLayout.CENTER);

	}

	@Override
	protected void addFrameAction() {
		// TODO Auto-generated method stub
		ViewMenuItemAdmin.addActionListener(new MainBankMenuClickListener(admin, null));
		ViewMenuItemAnggota.addActionListener(new MainBankMenuClickListener(anggota, null));
		ViewMenuItemTranSIM.addActionListener(new MainBankMenuClickListener(TransSIM, null));
		ViewMenuItemTranAMB.addActionListener(new MainBankMenuClickListener(TransAMB, null));
		ViewMenuItemLapAnggota.addActionListener(new MainBankMenuClickListener(lapanggota, null));
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
	}

}
