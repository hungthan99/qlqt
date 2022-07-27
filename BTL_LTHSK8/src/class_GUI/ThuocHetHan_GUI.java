package class_GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import class_Connection.Connect_DB;
import class_DAO.Thuoc_DAO;
import class_Entity.Thuoc;

public class ThuocHetHan_GUI extends JFrame implements ActionListener,MouseListener{
	private Box b,bTacVu,bTitle,bDanhSach;
	private JLabel lblTitle;
	private static DefaultTableModel model;
	private JTable tbl;
	private JScrollPane scroll;
	private JButton btnSua,btnXoa;
	private String[] header = {"Mã Thuốc","Tên Thuốc","Loại Thuốc","Đơn Vị","Ngày Sản Xuất","Ngày Hết Hạn","Số Lượng","Đơn Giá","Nhà Sản Xuất"};
	private Color lightBlue = new Color(51,204,255);
	private Color veryLightGreen = new Color(102,255,102);
	private Color veryLightRed = new Color(255,102,102);
	private DefaultTableCellRenderer cellRenderer;
	private ImageIcon iconSua,iconXoa;
	private static SimpleDateFormat sdf;
	private static DecimalFormat df;
	private static Thuoc_DAO ds;
	public void ThuocHetHan_GUI(JPanel pen) {
		b = Box.createVerticalBox();
		bTacVu = Box.createHorizontalBox();
		bTitle = Box.createHorizontalBox();
		bDanhSach = Box.createHorizontalBox();
		model = new DefaultTableModel(header,0);
		tbl = new JTable(model);
		scroll = new JScrollPane(tbl);
		iconSua = new ImageIcon(new ImageIcon("images/ThemBN.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		iconXoa = new ImageIcon(new ImageIcon("images/Xoa2.png").getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH));
		
		bTitle.add(lblTitle = new JLabel("THUỐC ĐÃ HẾT HẠN"));
		bDanhSach.add(scroll);
		bTacVu.add(btnSua = new JButton("Sửa Thông Tin Thuốc"));
		bTacVu.add(Box.createHorizontalStrut(20));
		bTacVu.add(btnXoa = new JButton("Xóa Thuốc"));
		
		lblTitle.setFont(new Font("Times New Roman",Font.BOLD,30));
		lblTitle.setForeground(veryLightRed);
		scroll.setPreferredSize(new Dimension(960,520));
		setColorHeaderTable(lightBlue);
		scroll.setBorder(BorderFactory.createLineBorder(Color.black));
		btnSua.setIcon(iconSua);
		btnXoa.setIcon(iconXoa);
		btnSua.setEnabled(false);
		btnXoa.setEnabled(false);
		btnSua.setBackground(veryLightGreen);
		btnXoa.setBackground(veryLightRed);
		
		b.add(bTitle);
		b.add(Box.createVerticalStrut(10));
		b.add(bDanhSach);
		b.add(Box.createVerticalStrut(10));
		b.add(bTacVu);
		
		pen.add(b);
		
		ds = new Thuoc_DAO();
		sdf = new SimpleDateFormat("dd/MM/yyyy");
		df = new DecimalFormat("#,###.00 VND");
		
		Connect_DB.getInstance().connect();
		docDuLieuVaoBang();
		
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		tbl.addMouseListener(this);
	}
	private static void docDuLieuVaoBang() {
		ds = new Thuoc_DAO();
		ArrayList<Thuoc> ls = ds.layTTThuoc();
		ArrayList<Thuoc> lsHH = new ArrayList<Thuoc>();
		for (Thuoc t : ls) {
			if (t.getNgayHH().toLocalDate().compareTo(LocalDate.now()) < 0) {
				lsHH.add(t); 
			}
		}
		for (Thuoc hh : lsHH) {
			model.addRow(new Object[] {hh.getMaThuoc(), hh.getTenThuoc(), hh.getLoaiThuoc(), hh.getDonVi(), 
					sdf.format(hh.getNgaySX()), sdf.format(hh.getNgayHH()), hh.getSoLuong(), df.format(hh.getDonGia()),
					hh.getNsx().getMaNSX()});
		}
	}
	public void setColorHeaderTable(Color color) {
		cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setBackground(color);

        /**
                   * Cyclically modify the header column
         */
        for(int i=0;i<9;i++){

            //i is the column of the table header
            TableColumn column = tbl.getTableHeader().getColumnModel().getColumn(i);
             column.setHeaderRenderer(cellRenderer);

             //Header text is centered
             cellRenderer.setHorizontalAlignment(cellRenderer.CENTER);   

        }
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(btnSua)) {
			int row = tbl.getSelectedRow();
			if(row == -1)
				JOptionPane.showMessageDialog(this, "Vui lòng chọn thuốc cần sửa !!!");
			else {
				String ma = model.getValueAt(row, 0).toString().trim();
				SuaThongTinThuoc_GUI t = new SuaThongTinThuoc_GUI(ds.getThuoc(ma));
				t.setVisible(true);
				Load.NV_GUI.setEnabled(false);
			}
		} else if (obj.equals(btnXoa)) {
			int row = tbl.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn thuốc cần xóa!");
			} else {
				if (JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa thuốc này?", "Cảnh báo!", 
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					String ma = model.getValueAt(row, 0).toString();
					if(ds.xoaThuoc(ma)) {
						ThemThuocMoi_GUI.reloadTable();
						DanhSachThuoc_GUI.reloadData();
						reload();
						ThuocSapHetTonKho_GUI.reload();
					}
				}
			}
		}
	}
	
	public static void reload() {
		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}
		docDuLieuVaoBang();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int row = tbl.getSelectedRow();
		if(row != -1) {
			btnSua.setEnabled(true);
			btnXoa.setEnabled(true);
		}
		if(row == -1) {
			btnSua.setEnabled(false);
			btnXoa.setEnabled(false);
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
