package class_GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import class_DAO.NhanVien_DAO;
import class_DAO.TaiKhoan_DAO;
import class_Entity.NhanVien;
import class_Entity.TaiKhoan;

public class ThemNhanVien_GUI extends JFrame implements ActionListener,MouseListener{
	private JLabel lblnam,lblnu;
	private Box b,bTK,bDS,bMaTendiachi,bTuoiDiaChi,bbtn,berror;
	private JLabel lblMa,lblTen,lblGioiTinh,lblTuoi,lblDiaChi,lblsdt;
	private JRadioButton radnam,radnu;
	private ButtonGroup group;
	private JTextField txtTen,txtMa,txtTuoi,txtDiaChi,txtsdt;
	private JButton btnXoaTrang,btnThem;
	private static JTextField txterror;
	private static DefaultTableModel model;
	private JTable tbl;
	private JScrollPane scroll;
	private ImageIcon iconXoaTrang,iconThem;
	private String[] header = {"Mã Nhân Viên","Tên Nhân Viên","Giới Tính","Số Điện Thoại","Tuổi","Địa Chỉ"};
	private Color lightBlue = new Color(51,204,255);
	private Color veryLightGreen = new Color(102,255,102);
	private Color veryLightRed = new Color(255,102,102);
	private DefaultTableCellRenderer cellRenderer;
	private Border lineLightBlueBorder = BorderFactory.createLineBorder(lightBlue);
	private static NhanVien_DAO nv_dao;
	private static TaiKhoan_DAO tk_dao;
	public void ThemNhanVien_GUI(JPanel pen) {
		nv_dao = new NhanVien_DAO();
		iconThem = new ImageIcon(new ImageIcon("images/addnv.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		iconXoaTrang = new ImageIcon(new ImageIcon("images/XoaTrang.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		b = Box.createVerticalBox();
		bTK = Box.createVerticalBox();
		bMaTendiachi = Box.createHorizontalBox();
		bTuoiDiaChi = Box.createHorizontalBox();
		bbtn = Box.createHorizontalBox();
		bDS = Box.createHorizontalBox();
		berror = Box.createHorizontalBox();
		radnam = new JRadioButton();
		radnu = new JRadioButton();
		group = new ButtonGroup();
		group.add(radnam);
		group.add(radnu);
		model = new DefaultTableModel(header,0);
		tbl = new JTable(model);
		scroll = new JScrollPane(tbl);
		
		bMaTendiachi.add(Box.createHorizontalStrut(10));
		bMaTendiachi.add(lblMa = new JLabel("Mã Nhân Viên:"));
		bMaTendiachi.add(txtMa = new JTextField());
		bMaTendiachi.add(Box.createHorizontalStrut(10));
		bMaTendiachi.add(lblTen = new JLabel("Tên Nhân Viên:"));
		bMaTendiachi.add(txtTen = new JTextField());
		bMaTendiachi.add(Box.createHorizontalStrut(10));
		bMaTendiachi.add(lblGioiTinh = new JLabel("Giới Tính:"));
		bMaTendiachi.add(lblnam = new JLabel("Nam"));
		bMaTendiachi.add(radnam);
		bMaTendiachi.add(Box.createHorizontalStrut(10));
		bMaTendiachi.add(lblnu = new JLabel("Nữ"));
		bMaTendiachi.add(radnu);
		bMaTendiachi.add(Box.createHorizontalStrut(10));
		
		bTuoiDiaChi.add(Box.createHorizontalStrut(10));
		bTuoiDiaChi.add(lblTuoi = new JLabel("Tuổi"));
		bTuoiDiaChi.add(txtTuoi = new JTextField());
		bTuoiDiaChi.add(Box.createHorizontalStrut(10));
		bTuoiDiaChi.add(lblsdt = new JLabel("Số Điện Thoại:"));
		bTuoiDiaChi.add(txtsdt = new JTextField());
		bTuoiDiaChi.add(Box.createHorizontalStrut(10));
		bTuoiDiaChi.add(lblDiaChi = new JLabel("Địa Chỉ:"));
		bTuoiDiaChi.add(txtDiaChi = new JTextField());
		bTuoiDiaChi.add(Box.createHorizontalStrut(10));
		
		berror.add(Box.createHorizontalStrut(10));
		berror.add(txterror = new JTextField());
		berror.add(Box.createHorizontalStrut(10));
		
		bbtn.add(btnThem = new JButton("Thêm Nhân Viên"));
		bbtn.add(Box.createHorizontalStrut(30));
		bbtn.add(btnXoaTrang = new JButton("Xóa Trắng"));
		
		bDS.add(Box.createHorizontalStrut(10));
		bDS.add(scroll);
		bDS.add(Box.createHorizontalStrut(10));
		
		bTK.add(bMaTendiachi);
		bTK.add(Box.createVerticalStrut(10));
		bTK.add(bTuoiDiaChi);
		bTK.add(Box.createVerticalStrut(10));
		bTK.add(berror);
		bTK.add(Box.createVerticalStrut(10));
		bTK.add(bbtn);
		
		b.add(bTK);
		b.add(Box.createVerticalStrut(10));
		b.add(bDS);
	
		pen.add(b);
		
		lblMa.setPreferredSize(new Dimension(100,24));
		lblTen.setPreferredSize(new Dimension(100,24));
		lblGioiTinh.setPreferredSize(new Dimension(100,24));
		lblTuoi.setPreferredSize(new Dimension(100,24));
		lblDiaChi.setPreferredSize(new Dimension(100,24));
		lblsdt.setPreferredSize(new Dimension(100,24));
		
		txtMa.setBorder(null);
		txtTen.setBorder(null);
		txtTuoi.setBorder(null);
		txtDiaChi.setBorder(null);
		txterror.setBorder(null);
		txterror.setEditable(false);
		txtsdt.setBorder(null);
		
		btnThem.setIcon(iconThem);
		btnXoaTrang.setIcon(iconXoaTrang);
		
		btnThem.setBackground(lightBlue);
		btnXoaTrang.setBackground(veryLightRed);
		
		setColorHeaderTable(lightBlue);
		scroll.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		scroll.setPreferredSize(new Dimension(940,430));
		bTK.setBorder(BorderFactory.createTitledBorder(lineLightBlueBorder, "Thêm Nhân Viên"));
		bDS.setBorder(BorderFactory.createTitledBorder(lineLightBlueBorder, "Danh Sách Nhân Viên"));
		
		taiDuLieuVaoTable();
		
		btnThem.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		tbl.addMouseListener(this);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int row = tbl.getSelectedRow();
		if(row != -1) {
			txtMa.setText(model.getValueAt(row, 0).toString());
			txtTen.setText(model.getValueAt(row, 1).toString());
			txtsdt.setText(model.getValueAt(row, 3).toString());
			txtTuoi.setText(model.getValueAt(row, 4).toString());
			txtDiaChi.setText(model.getValueAt(row, 5).toString());
			radnam.setSelected(true);
			if(model.getValueAt(row, 2).toString().equals("nữ"))
				radnu.setSelected(true);
		}
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btnThem)) {
			if(kiemTraDuLieuNhap()) {
				NhanVien nvv = layDuLieuTuTextField();
				if(nv_dao.getNhanVien(nvv.getMaNV().trim())==null) {
					thongBao("Tạo tài khoản cho nhân viên ....", txtMa);
					txterror.setForeground(Color.BLUE);
					TaoTaiKhoan_GUI g = new TaoTaiKhoan_GUI(nvv);
					g.setVisible(true);
					Load.NV_GUI.setEnabled(false);
				}else {
					thongBao("Trùng mã nhân viên !!!", txtMa);
				}
			}
		}
		if(obj.equals(btnXoaTrang)) {
			txtMa.setText("");
			txtTen.setText("");
			txtDiaChi.setText("");
			txtsdt.setText("");
			txtTuoi.setText("");
		}
	}
	public void setColorHeaderTable(Color color) {
		cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setBackground(color);

        /**
                   * Cyclically modify the header column
         */
        for(int i=0;i<6;i++){

            //i is the column of the table header
            TableColumn column = tbl.getTableHeader().getColumnModel().getColumn(i);
             column.setHeaderRenderer(cellRenderer);

             //Header text is centered
             cellRenderer.setHorizontalAlignment(cellRenderer.CENTER);   

        }
	}
	public static void taiDuLieuVaoTable() {
		nv_dao = new NhanVien_DAO();
		tk_dao = new TaiKhoan_DAO();
		ArrayList<NhanVien> dsnv = nv_dao.taiDuLieuTuDB();
		for(NhanVien nv : dsnv)
			if(nv.getLoaiNV().trim().equals("NV")) {
				model.addRow(new Object[] {
						nv.getMaNV(),nv.getTenNV(),nv.getGioiTinh(),nv.getSdt(),nv.getTuoi(),nv.getDiaChi()
				});
			}
	}
	public NhanVien layDuLieuTuTextField() {
		String ma = txtMa.getText().trim();
		String ten = txtTen.getText().trim();
		String gt = "nam";
		if(radnu.isSelected())
			gt = "nữ";
		int tuoi = Integer.parseInt(txtTuoi.getText().trim());
		String diachi = txtDiaChi.getText().trim();
		String sdt = txtsdt.getText().trim();
		NhanVien nv = new NhanVien(ma,ten,gt,sdt,tuoi,"NV",diachi);
		return nv;
	}
	public boolean kiemTraDuLieuNhap() {
		String ma = txtMa.getText().trim();
		String ten = txtTen.getText().trim();
		String diachi = txtDiaChi.getText().trim();
		String gt = "";
		String sdt = txtsdt.getText().trim();
		if(radnam.isSelected())
			gt = "nam";
		if(radnu.isSelected())
			gt = "nữ";
		if(ma.equals("")||ten.equals("")||diachi.equals("")||txtTuoi.getText().trim().equals("")||sdt.equals("")) {
			thongBao("Vui lòng nhập đầy đủ dữ liệu !!!", txtMa);
			return false;
		}
		if(!ma.matches("NV\\d{4}")) {
			thongBao("Mã nhân viên có dạng: 'NVxxxx', trong đó x là số !!!", txtMa);
			return false;
		}
		try {
			if(Integer.parseInt(txtTuoi.getText().trim()) < 18) {
				thongBao("Tuổi phải từ 18 trở lên !!!", txtTuoi);
				return false;
			}
		}catch (Exception e) {
			thongBao("Tuổi không hợp lệ !!!", txtTuoi);
			return false;
		}
		if(gt.equals("")) {
			thongBao("Bạn chưa chọn giới tính !!!", txtMa);
			return false;
		}
		if(!sdt.matches("[0]{1}[0-9]{9,10}")) {
			thongBao("Số điện thoại không hợp lệ !!!", txtsdt);
			return false;
		}
		return true;
	}
	public void thongBao(String mess,JTextField txt) {
		txterror.setForeground(Color.RED);
		txterror.setText(mess);
		txt.requestFocus();
	}
	public static void capNhatTable() {
		while(model.getRowCount()>0)
			model.removeRow(0);
		taiDuLieuVaoTable();
	}
	public void xoaRongTextField() {
		txtMa.setText("");
		txtTen.setText("");
		txtTuoi.setText("");
		txtsdt.setText("");
		txtDiaChi.setText("");
		radnam.setSelected(true);
	}
	public static void thanhCong(String mess) {
		txterror.setForeground(Color.BLUE);
		txterror.setText(mess);
	}
}
