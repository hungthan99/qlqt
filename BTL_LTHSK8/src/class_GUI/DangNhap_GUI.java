package class_GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import class_DAO.TaiKhoan_DAO;
import class_Entity.TaiKhoan;

public class DangNhap_GUI extends JFrame implements ActionListener,MouseListener{
	private JPanel pNorth,pCen,pSouth;
	private JLabel lblTitle,lblTK,lblPass,lblmt,lblmota1,lblmota2,lblmota3,lblimage;
	private JTextField txtTK,txterror;
	private JPasswordField txtPass;
	private JButton btnDN,btnqmk;
	private Color lightBlue = new Color(51,204,255);
	private Color veryLightGreen = new Color(102,255,102);
	private Color veryLightRed = new Color(255,102,102);
	private ImageIcon imgTitle,imgdn,iconMain;
	private TaiKhoan_DAO tk_dao;
	public DangNhap_GUI() {
		imgTitle = new ImageIcon(new ImageIcon("images/iconApp.png").getImage().getScaledInstance(200, 200, Image.SCALE_AREA_AVERAGING));
		imgdn = new ImageIcon(new ImageIcon("images/Doctor.png").getImage().getScaledInstance(26, 26, Image.SCALE_AREA_AVERAGING));
		pNorth = new JPanel();
		pCen = new JPanel();
		pSouth = new JPanel();
		btnDN = new JButton("Đăng Nhập");
		btnqmk = new JButton("Quên mật khẩu ?");
		
		pNorth.add(lblTitle = new JLabel("QUAN LY NHA THUOC"));
		pCen.setLayout(null);
		pCen.add(lblTK = new JLabel("Tên Đăng Nhập:"));
		pCen.add(txtTK = new JTextField());
		pCen.add(lblPass = new JLabel("Mật Khẩu:"));
		pCen.add(txtPass = new JPasswordField());
		pCen.add(txterror = new JTextField());
		pCen.add(btnDN);
		pCen.add(btnqmk);
		pCen.add(lblmota1 = new JLabel("Giúp cho việc quản lý nhà thuốc dễ dàng hơn, tập"));
		pCen.add(lblmota2 = new JLabel("trung vào tính dễ sử dụng, chính xác về số liệu "));
		pCen.add(lblmota3 = new JLabel("và đầy đủ nghiệp vụ đặc thù của nhà thuốc."));
		pCen.add(lblimage = new JLabel());
		pSouth.add(lblmt = new JLabel("Phần mềm đươc phát triển bởi: Trần Huy Thắng, Thân Trọng Hùng, Trần Lê Tuấn Anh"));
		
		int x = 40; int y = 30; int w = 280; int h = 24;
		
		lblimage.setIcon(imgTitle);
		pNorth.setBackground(lightBlue);
		pNorth.setLayout(new FlowLayout(FlowLayout.LEFT));
		lblTitle.setFont(new Font("Impact",Font.PLAIN,23));
		lblTitle.setForeground(veryLightRed);
		lblTitle.setIcon(imgdn);
		lblTK.setBounds(x, y, w, h);
		txtTK.setBounds(x, y*2+10, w, h);
		lblPass.setBounds(x, y*3+10*2, w, h);
		txtPass.setBounds(x, y*4+10*3, w, h);
		txterror.setBounds(x, y*5+10*4, w, h);
		btnDN.setBounds(x, y*6+10*5, w, 30);
		btnqmk.setBounds(x, y*7+10*6, 100, h);
		lblmota1.setBounds(x, y*8+10*7, w, h);
		lblmota2.setBounds(x, y*9+10*6, w, h);
		lblmota3.setBounds(x, y*10+10*5, w, h);
		lblimage.setBounds(400, 30, 300, 300);
		txtTK.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		txtPass.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		txterror.setBorder(null);
		txterror.setEditable(false);
		txterror.setBackground(Color.WHITE);
		btnDN.setBackground(veryLightGreen);
		btnqmk.setForeground(veryLightRed);
		btnqmk.setBorder(null);
		btnqmk.setBackground(Color.WHITE);
		lblmota1.setFont(new Font("Calibri", Font.ITALIC, 14));
		lblmota2.setFont(new Font("Calibri", Font.ITALIC, 14));
		lblmota3.setFont(new Font("Calibri", Font.ITALIC, 14));
		
		pCen.setBackground(Color.WHITE);
		pSouth.setBackground(lightBlue);
		
		
		add(pNorth,BorderLayout.NORTH);
		add(pCen,BorderLayout.CENTER);
		add(pSouth,BorderLayout.SOUTH);
		
		iconMain = new ImageIcon("images/iconApp.png");
		setIconImage(iconMain.getImage());
		setTitle("Đăng Nhập");
		setSize(700, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		btnqmk.addMouseListener(this);
		btnDN.addActionListener(this);
		btnqmk.addActionListener(this);
	}
	public static void main(String[] args) {
		new DangNhap_GUI().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btnDN)) {
			if(kiemTraDuLieuNhap()) {
				Load.load(txtTK.getText().trim());
				StartApp.dn_gui.setVisible(false);
			}
		}
		if(obj.equals(btnqmk)) {
			JOptionPane.showMessageDialog(this, "Liên hệ với quản lý để lấy lại mật khẩu !!!");
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
		btnqmk.setForeground(lightBlue);
	}
	@Override
	public void mouseExited(MouseEvent e) {
		btnqmk.setForeground(veryLightRed);
		
	}
	public boolean kiemTraDuLieuNhap(){
		if(txtTK.getText().trim().equals("")||txtPass.getText().trim().equals("")) {
			thongBao("Vui lòng nhập đầy đủ thông tin !!!", txtTK);
			return false;
		}
		tk_dao = new TaiKhoan_DAO();
		tk_dao.taiDuLieuTuDB();
		TaiKhoan tk = tk_dao.getTaiKhoan(txtTK.getText().trim());
		if(tk==null) {
			thongBao("Không tồn tại mã nhân viên !!!", txtTK);
			return false;
		}
		if(!tk.getMatKhau().trim().equals(txtPass.getText().trim())) {
			thongBao("Sai mật khẩu !!!", txtPass);
			return false;
		}
		return true;
	}
	public void thongBao(String mess, JTextField txt) {
		txterror.setForeground(Color.RED);
		txterror.setText(mess);
		txt.requestFocus();
	}
	
}
