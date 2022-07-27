package class_GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import class_DAO.NhaSanXuat_DAO;
import class_Entity.NhaSanXuat;

public class ThemNhaSX_GUI extends JFrame implements ActionListener,MouseListener{
	private Box b,bTitle,bMaTen,bDiaChiSDT,bbtn,bError,bThem,bDS;
	private JLabel lblTitle,lblMa,lblTen,lblSDT,lblDiaChi;
	private JTextField txtMa,txtTen,txtSDT,txtDiaChi,txtError;
	private JButton btnThem,btnXoaTrang;
	private Color lightBlue = new Color(51,204,255);
	private Color veryLightGreen = new Color(102,255,102);
	private Color veryLightRed = new Color(255,102,102);
	private ImageIcon iconThem,iconXoaTrang;
	private static DefaultTableModel model;
	private JTable tbl;
	private JScrollPane scroll;
	private String[] header = {"Mã Nhà Sản Xuất","Tên Nhà Sản Xuất","Số Điện Thoại","Địa Chỉ"};
	private DefaultTableCellRenderer cellRenderer;
	private Border lineLightBlueBorder = BorderFactory.createLineBorder(lightBlue);
	private static NhaSanXuat_DAO nsx_dao;
	public void ThemNhaSX_GUI(JPanel pen){
		nsx_dao = new NhaSanXuat_DAO();
		iconThem = new ImageIcon(new ImageIcon("images/themNSX.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		iconXoaTrang = new ImageIcon(new ImageIcon("images/XoaTrang.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		b = Box.createVerticalBox();
		bTitle = Box.createHorizontalBox();
		bMaTen = Box.createHorizontalBox();
		bDiaChiSDT = Box.createHorizontalBox();
		bbtn = Box.createHorizontalBox();
		bError = Box.createHorizontalBox();
		bThem = Box.createVerticalBox();
		bDS = Box.createHorizontalBox();
		
		bTitle.add(lblTitle = new JLabel("THÊM NHÀ SẢN XUẤT"));	
		bMaTen.add(Box.createHorizontalStrut(10));
		bMaTen.add(lblMa = new JLabel("Mã Nhà Sản Xuất:"));
		bMaTen.add(txtMa = new JTextField());
		bMaTen.add(Box.createHorizontalStrut(10));
		bMaTen.add(lblTen = new JLabel("Tên Nhà Sản Xuất:"));
		bMaTen.add(txtTen = new JTextField());
		bMaTen.add(Box.createHorizontalStrut(10));
		bDiaChiSDT.add(Box.createHorizontalStrut(10));
		bDiaChiSDT.add(lblSDT = new JLabel("Số Điện Thoại:"));
		bDiaChiSDT.add(txtSDT = new JTextField());
		bDiaChiSDT.add(Box.createHorizontalStrut(10));
		bDiaChiSDT.add(lblDiaChi = new JLabel("Địa Chỉ:"));
		bDiaChiSDT.add(txtDiaChi = new JTextField());
		bDiaChiSDT.add(Box.createHorizontalStrut(10));
		bError.add(Box.createHorizontalStrut(10));
		bError.add(txtError = new JTextField());
		bError.add(Box.createHorizontalStrut(10));
		bbtn.add(btnThem = new JButton("Thêm"));
		bbtn.add(Box.createHorizontalStrut(30));
		bbtn.add(btnXoaTrang = new JButton("Xóa Trắng"));
		
		lblTitle.setFont(new Font("Times new roman",Font.BOLD,24));
		lblMa.setPreferredSize(new Dimension(110,24));
		lblTen.setPreferredSize(lblMa.getPreferredSize());
		lblSDT.setPreferredSize(lblMa.getPreferredSize());
		lblDiaChi.setPreferredSize(lblMa.getPreferredSize());
		lblTitle.setForeground(veryLightRed);
		btnThem.setIcon(iconThem);
		btnXoaTrang.setIcon(iconXoaTrang);
		btnThem.setBackground(lightBlue);
		btnXoaTrang.setBackground(veryLightRed);
		txtMa.setBorder(null);
		txtTen.setBorder(null);
		txtDiaChi.setBorder(null);
		txtSDT.setBorder(null);
		txtError.setBorder(null);
		txtError.setEditable(false);
		bThem.setBorder(BorderFactory.createTitledBorder(lineLightBlueBorder, "Thêm Nhà Sản Xuất"));
		bDS.setBorder(BorderFactory.createTitledBorder(lineLightBlueBorder, "Danh Sách Nhà Sản Xuất"));
		
		model = new DefaultTableModel(header,0);
		tbl = new JTable(model);
		scroll = new JScrollPane(tbl);
		setColorHeaderTable(lightBlue);
		scroll.setPreferredSize(new Dimension(940,350));
		
		bThem.add(Box.createVerticalStrut(10));
		bThem.add(bTitle);
		bThem.add(Box.createVerticalStrut(10));
		bThem.add(bMaTen);
		bThem.add(Box.createVerticalStrut(10));
		bThem.add(bDiaChiSDT);
		bThem.add(Box.createVerticalStrut(10));
		bThem.add(bError);
		bThem.add(Box.createVerticalStrut(10));
		bThem.add(bbtn);
		bThem.add(Box.createVerticalStrut(10));
		
		bDS.add(Box.createHorizontalStrut(10));
		bDS.add(scroll);
		bDS.add(Box.createHorizontalStrut(10));
		
		b.add(Box.createVerticalStrut(10));
		b.add(bThem);
		b.add(Box.createVerticalStrut(10));
		b.add(bDS);
		b.add(Box.createVerticalStrut(10));
		
		pen.add(b);
		
		taiDuLieuVaoBang();
		
		btnThem.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		tbl.addMouseListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btnThem)) {
			if(kiemTraDuLieuNhap()) {
				NhaSanXuat nsx = layNSXTuTextField();
				if(nsx_dao.themNhaSanXuat(nsx)) {
					reLoadTable();
					DanhSachNSX_GUI.reLoadTable();
					DanhSachThuoc_GUI.reloadData();
					ThemThuocMoi_GUI.reloadTable();
					thongBao("Thêm thành công một nhà sản xuất", txtMa);
					xoaTrangTextField();
					txtError.setForeground(Color.BLUE);
				}
			}
		}
		if(obj.equals(btnXoaTrang))
			xoaTrangTextField();
	}
	public void setColorHeaderTable(Color color) {
		cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setBackground(color);

        /**
                   * Cyclically modify the header column
         */
        for(int i=0;i<4;i++){

            //i is the column of the table header
            TableColumn column = tbl.getTableHeader().getColumnModel().getColumn(i);
             column.setHeaderRenderer(cellRenderer);

             //Header text is centered
             cellRenderer.setHorizontalAlignment(cellRenderer.CENTER);   

        }
	}
	public boolean kiemTraDuLieuNhap() {
		String ma = txtMa.getText().trim();
		String ten = txtTen.getText().trim();
		String diachi = txtDiaChi.getText().trim();
		String sdt = txtSDT.getText().trim();
		if(ma.equals("")||ten.equals("")||sdt.equals("")||diachi.equals("")) {
			thongBao("Vui lòng nhập đầy đủ thông tin !!!", txtMa);
			return false;
		}
		if(!ma.matches("NSX\\d{4}")) {
			thongBao("Mã nhà sản xuất có dạng: 'NSXxxxx', x là số !!!", txtMa);
			return false;
		}
		if(!sdt.matches("[0]{1}[0-9]{9,10}")){
				thongBao("Số điện thoại không hợp lệ !!!", txtSDT);
				return false;
		}
		return true;
	}
	public void thongBao(String mess, JTextField txt) {
		txtError.setForeground(Color.RED);
		txtError.setText(mess);
		txt.requestFocus();
	}
	public NhaSanXuat layNSXTuTextField() {
		String ma = txtMa.getText().trim();
		String ten = txtTen.getText().trim();
		String diachi = txtDiaChi.getText().trim();
		String sdt = txtSDT.getText().trim();
		NhaSanXuat nsx = new NhaSanXuat(ma, ten, sdt, diachi);
		return nsx;
	}
	public static void taiDuLieuVaoBang() {
		nsx_dao = new NhaSanXuat_DAO();
		ArrayList<NhaSanXuat> dsnsx = nsx_dao.layTTNhaSanXuat();
		for(NhaSanXuat n : dsnsx)
			model.addRow(new Object[]{
					n.getMaNSX(),n.getTenNSX(),n.getSdt(),n.getDiaChi()
			});
		
	}
	public static void reLoadTable() {
		while(model.getRowCount()>0)
			model.removeRow(0);
		taiDuLieuVaoBang();
	}
	public void xoaTrangTextField() {
		txtMa.setText("");
		txtTen.setText("");
		txtSDT.setText("");
		txtDiaChi.setText("");
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int row = tbl.getSelectedRow();
		if(row != -1) {
			txtMa.setText(model.getValueAt(row, 0).toString());
			txtTen.setText(model.getValueAt(row, 1).toString());
			txtSDT.setText(model.getValueAt(row, 2).toString());
			txtDiaChi.setText(model.getValueAt(row, 3).toString());
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
}

