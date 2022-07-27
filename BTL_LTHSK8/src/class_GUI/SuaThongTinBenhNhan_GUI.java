package class_GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import class_DAO.BenhNhan_DAO;
import class_Entity.BenhNhan;

public class SuaThongTinBenhNhan_GUI extends JFrame implements ActionListener,WindowListener{
	private Box b,bSua,bMaTen,bSDTGTNS,bGhiChu,bDiaChi,berror,bbtn,bTitle;
	private JLabel lblMa,lblTen,lblSDT,lblGT,lblNgaySinh,lblGhiChu,lblDiaChi,lblTitle;
	private JTextField txtMa,txtTen,txtsdt,txtGhiChu,txterror,txtDiaChi,txtTuoi;
	private JRadioButton radNam,radNu;
	private JButton btnSua,btnXoaTrang;
	private Color lightBlue = new Color(51,204,255);
	private Color veryLightGreen = new Color(102,255,102);
	private Color veryLightRed = new Color(255,102,102);
	private Color lightRed = new Color(204,0,0);
	private DefaultTableCellRenderer cellRenderer;
	private Border lineLightBlueBorder = BorderFactory.createLineBorder(lightBlue);
	private String[] header = {"Mã Bệnh Nhân","Tên Bệnh Nhân","Giới Tính","Tuổi","Địa Chỉ","Số Điện Thoại"};
	private ButtonGroup buttongroup;
	private ImageIcon iconThem,iconXoaTrang;
	private static BenhNhan_DAO bn_dao;
	private String maBN; 
	public SuaThongTinBenhNhan_GUI(String ma) {
		this.maBN = ma;
		bn_dao = new BenhNhan_DAO();
		iconXoaTrang = new ImageIcon(new ImageIcon("images/XoaTrang.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		iconThem = new ImageIcon(new ImageIcon("images/ThemBN.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		b = Box.createVerticalBox();
		bSua = Box.createVerticalBox();
		bMaTen = Box.createHorizontalBox();
		bSDTGTNS = Box.createHorizontalBox();
		bGhiChu = Box.createHorizontalBox();
		bbtn = Box.createHorizontalBox();
		bDiaChi = Box.createHorizontalBox();
		berror = Box.createHorizontalBox();
		radNam = new JRadioButton("Nam");
		radNu = new JRadioButton("Nữ");
		buttongroup = new ButtonGroup();
		buttongroup.add(radNam);
		buttongroup.add(radNu);
		bTitle = Box.createHorizontalBox();
		
		bMaTen.add(Box.createHorizontalStrut(10));
		bMaTen.add(lblMa = new JLabel("Mã Bệnh Nhân:"));
		bMaTen.add(txtMa = new JTextField());
		bMaTen.add(Box.createHorizontalStrut(50));
		bMaTen.add(lblTen = new JLabel("Tên Bệnh Nhân:"));
		bMaTen.add(txtTen = new JTextField());
		bMaTen.add(Box.createHorizontalStrut(10));
		bSDTGTNS.add(Box.createHorizontalStrut(10));
		bSDTGTNS.add(lblSDT = new JLabel("Số Điện Thoại:"));
		bSDTGTNS.add(txtsdt = new JTextField());
		bSDTGTNS.add(Box.createHorizontalStrut(100));
		bSDTGTNS.add(lblGT = new JLabel("Giới Tính:"));
		bSDTGTNS.add(radNam);
		bSDTGTNS.add(radNu);
		bSDTGTNS.add(Box.createHorizontalStrut(100));
		bSDTGTNS.add(lblNgaySinh = new JLabel("Tuổi"));
		bSDTGTNS.add(txtTuoi = new JTextField());
		bSDTGTNS.add(Box.createHorizontalStrut(10));
		bDiaChi.add(Box.createHorizontalStrut(10));
		bDiaChi.add(lblDiaChi = new JLabel("Địa Chỉ:"));
		bDiaChi.add(txtDiaChi = new JTextField());
		bDiaChi.add(Box.createHorizontalStrut(10));
		bGhiChu.add(Box.createHorizontalStrut(10));
		bGhiChu.add(lblGhiChu = new JLabel("Ghi Chú:"));
		bGhiChu.add(txtGhiChu = new JTextField());
		bGhiChu.add(Box.createHorizontalStrut(10));
		berror.add(Box.createHorizontalStrut(10));
		berror.add(txterror = new JTextField());
		berror.add(Box.createHorizontalStrut(10));
		bbtn.add(btnSua = new JButton("Sửa Thông Tin"));
		bbtn.add(Box.createHorizontalStrut(30));
		bbtn.add(btnXoaTrang = new JButton("Xóa Trắng"));
		txtMa.setEditable(false);
		
		lblMa.setPreferredSize(new Dimension(100,24));
		lblTen.setPreferredSize(lblMa.getPreferredSize());
		lblSDT.setPreferredSize(lblMa.getPreferredSize());
		lblNgaySinh.setPreferredSize(lblMa.getPreferredSize());
		lblDiaChi.setPreferredSize(lblMa.getPreferredSize());
		lblGhiChu.setPreferredSize(lblMa.getPreferredSize());
		
		txtTen.setBorder(null);
		txtsdt.setBorder(null);
		txtDiaChi.setBorder(null);
		txterror.setBorder(null);
		txterror.setEditable(false);
		txtTuoi.setBorder(null);
		txtGhiChu.setBorder(null);
		btnSua.setBackground(veryLightGreen);
		btnXoaTrang.setBackground(veryLightRed);
		btnSua.setIcon(iconThem);
		btnXoaTrang.setIcon(iconXoaTrang);
		
		bSua.add(Box.createVerticalStrut(10));
		bTitle.add(lblTitle = new JLabel("SỬA THÔNG TIN BỆNH NHÂN"));
		bSua.add(bTitle);
		bSua.add(Box.createVerticalStrut(10));
		bSua.add(bMaTen);
		bSua.add(Box.createVerticalStrut(10));
		bSua.add(bSDTGTNS);
		bSua.add(Box.createVerticalStrut(10));
		bSua.add(bDiaChi);
		bSua.add(Box.createVerticalStrut(10));
		bSua.add(bGhiChu);
		bSua.add(Box.createVerticalStrut(10));
		bSua.add(berror);
		bSua.add(Box.createVerticalStrut(10));
		bSua.add(bbtn);
		bSua.add(Box.createVerticalStrut(10));
		lblTitle.setForeground(veryLightRed);
		lblTitle.setFont(new Font("Times new roman",Font.BOLD,20));
		
		b.add(bSua);
		
		add(b);
		setSize(800,300);
		setLocationRelativeTo(null);
		
		bn_dao.taiDSBenhNHan();
		taiDuLieuVaoTextField();
		
		btnSua.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		this.addWindowListener(this);
	}
	public boolean kiemTraCuuPhap() {
		String ma = txtMa.getText().trim();
		String ten = txtTen.getText().trim();
		String sdt = txtsdt.getText().trim();
		String tuoi = txtTuoi.getText().trim();
		String diachi = txtDiaChi.getText().trim();
		String ghichu = txtGhiChu.getText().trim();
		if(ma.equals("")||ten.equals("")||sdt.equals("")||tuoi.equals("")||diachi.equals("")||ghichu.equals("")) {
			thongBaoLoi("Vui lòng nhập đầy đủ thông tin !!!", txtMa);
			return false;
		}
		if(!ma.matches("BN\\d{4}")) {
			thongBaoLoi("Mã Bệnh Nhân phải là: 'BNxxxx', x là số !!!", txtMa);
			return false;
		}
		if(!sdt.matches("[0]{1}[0-9]{9,10}")) {
			thongBaoLoi("Số điện thoại không hợp lệ !!!", txtsdt);
			return false;
		}
		try {
			if(Integer.parseInt(tuoi) <= 0) {
				thongBaoLoi("Tuổi không hợp lệ !!!", txtTuoi);
				return false;
			}	
		} catch (Exception e) {
			thongBaoLoi("Tuổi không hợp lệ !!!", txtTuoi);
			return false;
		}
		if(!radNam.isSelected())
			if(!radNu.isSelected()) {
				thongBaoLoi("Bạn chưa chọn giới tính !!!", txtsdt);
				return false;
			}
		return true;
	}
	public void thongBaoLoi(String mess, JTextField txt) {
		txterror.setForeground(Color.RED);
		txt.requestFocus();
		txterror.setText(mess);
	}
	public BenhNhan layBenhNhanTuTextField() {
		String ma = txtMa.getText().trim();
		String ten = txtTen.getText().trim();
		String sdt = txtsdt.getText().trim();
		int tuoi = Integer.parseInt(txtTuoi.getText().trim().toString());
		String diachi = txtDiaChi.getText().trim();
		String ghichu = txtGhiChu.getText().trim();
		String gt = "nam";
		if(radNu.isSelected())
			gt = "nữ";
		BenhNhan bn = new BenhNhan(ma, ten, gt, sdt, diachi, tuoi, ghichu);
		return bn;
	}
	public void xoaTrangTextField() {
		txtMa.setText("");
		txtTen.setText("");
		txtTuoi.setText("");
		txtsdt.setText("");
		txtDiaChi.setText("");
		txtGhiChu.setText("");
		radNam.setSelected(false);
		radNu.setSelected(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btnXoaTrang))
			xoaTrangTextField();
		if(obj.equals(btnSua)) {
			if(kiemTraCuuPhap()) {
				BenhNhan bn = layBenhNhanTuTextField();
				int tl = JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa bệnh nhân này !!!", "Cảnh Báo !!!", JOptionPane.YES_NO_OPTION);
				if(tl == JOptionPane.YES_OPTION) {
					if(bn_dao.suaBenhNhan(bn)) {
						/*model.addRow(new Object[] {
								bn.getMaBenhNhan(),bn.getTenBenhNhan(),bn.getGioiTinh(),bn.getTuoi(),bn.getDiaChi(),bn.getSdt()
						});*/
						DanhSachBenhNhan_GUI.reloadTable();
						ThemBenhNhan_GUI.reloadTable();
						thongBaoLoi("Sửa thành công 1 bệnh nhân", txtMa);
						txterror.setForeground(Color.BLUE);
						xoaTrangTextField();
						Load.NV_GUI.setEnabled(true);
						this.setVisible(false);
					}else
						thongBaoLoi("Trùng mã bệnh nhân !!!", txtMa);
				}
			}
		}
		
	}
	public void taiDuLieuVaoTextField() {
		BenhNhan bn = bn_dao.timBenhNhan(maBN);
		txtMa.setText(bn.getMaBenhNhan());
		txtTen.setText(bn.getTenBenhNhan());
		txtsdt.setText(bn.getSdt());
		txtTuoi.setText(String.valueOf(bn.getTuoi()));
		txtDiaChi.setText(bn.getDiaChi());
		txtGhiChu.setText(bn.getGhiChu());
		radNam.setSelected(true);
		if(bn.getGioiTinh().equals("nữ"))
			radNu.setSelected(true);
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		Load.NV_GUI.setEnabled(true);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
