package Coba.common;

public interface BankConstantsDefinition {
	String BUTTON_COMMON_SIMPAN = "Simpan";
	String BUTTON_COMMON_BATAL = "Batal";
	String BUTTON_COMMON_CEK = "Cek NIA";
	String BUTTON_COMMON_CEKSALDO = "Cek Saldo";
	String BUTTON_COMMON_GANTI = "Ganti";
	String BUTTON_COMMON_LOGIN = "Login";
	String BUTTON_COMMON_CETAK = "Cetak";
	String BUTTON_COMMON_TRANFER = "Tranfer";

	String FRAME_MAINFRAME_TITLE = "Bank Mini";

	String MENU_MAINFRAME_VIEW = "Data";
	String MENUITEM_MAINFRAME_VIEW_ANGGOTA = "Data Anggota";
	String MENUITEM_MAINFRAME_VIEW_ADMIN = "Data Admin";

	String FRAME_ANGGOTA_TITLE = "Tambah Data Anggota";
	String LABEL_ANGGOTA_NIA = "NIA";
	String LABEL_ANGGOTA_NAMA = "Nama";
	String LABEL_ANGGOTA_ALAMAT = "Alamat";
	String LABEL_ANGGOTA_TLP = "Tlp";
	String LABEL_ANGGOTA_PASSWORD = "Password";

	String FRAME_ADMIN_TITLE = "Tambah Admin";
	String LABEL_ADMIN_NIP = "NIP";
	String LABEL_ADMIN_NAMA = "Nama";
	String LABEL_ADMIN_TLP = "Tlp";
	String LABEL_ADMIN_PASSWORD = "Password";

	String MENU_MAINFRAME_VIEW2 = "Transaksi";
	String MENUITEM_MAINFRAME_VIEW_TRANSAKSISIM = "Transaksi Simpan";

	String FRAME_TRANSAKSISIM_TITLE = "Simpana ";
	String LABEL_TRANSAKSISIM_NOSIM = "No Transaksi";
	String LABEL_TRANSAKSISIM_NIA = "NIA";
	String LABEL_TRANSAKSISIM_NAMA = "Nama";
	String LABEL_TRANSAKSISIM_ALAMAT = "Alamat";
	String LABEL_TRANSAKSISIM_TANGGAL = "Tanggal";
	String LABEL_TRANSAKSISIM_SALDO = "Saldo";
	String LABEL_TRANSAKSISIM_UANG = "Jumlah Uang";
	String LABEL_TRANSAKSISIM_TOTAL_SALDO = "Total Saldo";

	String MENUITEM_MAINFRAME_VIEW_TRANSAKSIAMB = "Trnsaksi Ambil";
	String FRAME_TRANSAKSIAMB_TITLE = "Ambil";
	String LABEL_TRANSAKSIAMB_NOAMB = "No Transaksi";
	String LABEL_TRANSAKSIAMB_NIA = "NIA";
	String LABEL_TRANSAKSIAMB_NAMA = "Nama";
	String LABEL_TRANSAKSIAMB_ALAMAT = "Alamat";
	String LABEL_TRANSAKSIAMB_TANGAL = "Tanggal";
	String LABEL_TARNSAKSISIM_SALDO = "Saldo";
	String LABEL_TRANSAKSIAMB_UANG = "Jumlah Uang";
	String LABEL_TRANSAKSIAMB_TOTAL_SALDO = "Total Saldo";

	String MENU_MAINFRAME_VIEW3 = "Laporan";
	String MENUITEM_MAINfRAME_VIEW_LAPORAN_ANGGOTA = "Anggota";
	String FRAME_LAPORAN_TITLE = "Data Anggota";
	String LABEL_LAPORAN_TITE = "Laporan  Data Anggota";
	String LABEL_LAPORAN_HEADER = "DATA ANGGOTA";

	String MENU_MAINFRAME_VIEW4 = "Transfer";
	String MENUITEM_MAINFRAME_VIEW_TRANSFER = "Transfer";
	String FRAME_TRANSFER_TITLE = "Transfer";
	String LABEL_TRANSFER_NOTS = "No Transfer";
	String LABEL_TRANSFER_TANGGAL = "Tanggal";
	String LABEL_TRANSFER_NIA1 = "NIA";
	String LABEL_TRANSFER_NIA2 = "NIA Tujuan";
	String LABLE_TRANSFER_UANG = "Jumlah Uang";

	String MENU_MAINFRAME_VIEW5 = "Utility";
	String MENUITEM_MAINFRAME_VIEW_GANTIPSSANGGOTA = "Ganti Password Anggota";
	String FRAME_GANTIPASSANGGOTA_TITLE = "Ganti Password Anggota";
	String LABEL_GANTIPASSANGGOTA_NIA = "NIA";
	String LABEL_GANTIPASSANGGOTA_PASSWORD = "Password";

	String MENU_MAINFRAME_VIEW6 = "Cek Saldo";
	String MENUITEM_MAINFRME_VIEW_CEKSALDO = "Cek Saldo";
	String FRAME_CEKSALDO_TITLE = "Cek Saldo";
	String LABEL_CEKSALDO_NIA = "NIA";
	String LABEL_CEKSALDO_PASSWORD = "Password";
	String LABEL_CEKSALDO_SALDO = "Saldo";

	String FRAME_MAINFRAME_TITLELOGIN = "LOGIN";
	String LABEL_LOGIN_WELCOME = "Selamat Datang Silahkan Login Terlebih Dahulu";
	String LABEL_LOGIN_USER = "User";
	String LABEL_LOGIN_PASSWORD = "Password";

	String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	String DATABASE_CONNECTION_URL = "jdbc:mysql://localhost:3306/dbbankmini";
	String DATABASE_CONNECTION_USERNAME = "root";
	String DATABASE_CONNECTION_PASSWORD = "";
}