package class_GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import class_DAO.CT_HoaDon_DAO;
import class_DAO.HoaDon_DAO;

public class DoanhThuNam_GUI extends JFrame implements ItemListener,ActionListener{
	private Box b,bTitle,bNgayThang,bChart;
	private String TitleChart;
	private JLabel lblTitle,lblTitleChart,lblNam;
	private JComboBox<Integer> cbbNam;
	private static DefaultCategoryDataset dataset;
	private Color veryLightRed = new Color(255,102,102);
	private ImageIcon iconXem;
	private JButton btnXem;
	private Color lightBlue = new Color(51,204,255);
	private HoaDon_DAO hd_dao;
	public void DoanhThuNam_GUI(JPanel panel) {
		hd_dao = new HoaDon_DAO();
		iconXem = new ImageIcon(new ImageIcon("images/TKNam.png").getImage().getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING));
		b = Box.createVerticalBox();
		bTitle = Box.createHorizontalBox();
		bNgayThang = Box.createHorizontalBox();
		bChart = Box.createHorizontalBox();
		cbbNam = new JComboBox();
		JFreeChart pieChart = createChart();
		ChartPanel chartPanel = new ChartPanel(pieChart);
		addComboboxNam();
		LocalDate date = LocalDate.now();
		
		bTitle.add(lblTitle = new JLabel("DOANH THU NĂM"));
		bNgayThang.add(Box.createHorizontalStrut(150));
		bNgayThang.add(Box.createHorizontalStrut(50));
		bNgayThang.add(lblNam = new JLabel("Năm:"));
		bNgayThang.add(Box.createHorizontalStrut(10));
		bNgayThang.add(cbbNam);
		bNgayThang.add(Box.createHorizontalStrut(50));
		bNgayThang.add(btnXem = new JButton("Xem Biểu Đồ"));
		bNgayThang.add(Box.createHorizontalStrut(150));
		bChart.add(chartPanel);
		String ChartTitle = "Biểu Đồ Thống Kê Doanh Thu Năm" + cbbNam.getSelectedItem().toString();
		
		chartPanel.setBackground(Color.WHITE);
		lblTitle.setForeground(veryLightRed);
		lblTitle.setFont(new Font("Times new roman",Font.BOLD,30));
		btnXem.setIcon(iconXem);
		btnXem.setBackground(lightBlue);
		cbbNam.setBackground(Color.WHITE);
		
		chartPanel.setPreferredSize(new Dimension(900,500));
		
		
		b.add(bTitle);
		b.add(Box.createVerticalStrut(10));
		b.add(bNgayThang);
		b.add(Box.createVerticalStrut(10));
		b.add(bChart);
		
		panel.setBackground(Color.WHITE);
		panel.add(b);
		
		cbbNam.addItemListener(this);
		btnXem.addActionListener(this);
		
		hd_dao.layDuLieuTuDB();
	}
	public JFreeChart createChart() {
		JFreeChart barChart = ChartFactory.createBarChart("Biểu Đồ Thống Kê Doanh Năm", "Tháng", "Doanh thu(VND)",
				createDataset(), PlotOrientation.VERTICAL, false, false, false);
		return barChart;
	}

	private CategoryDataset createDataset() {
		dataset = new DefaultCategoryDataset();
		return dataset;
	}
	public void addComboboxNam() {
		LocalDate date = LocalDate.now();
		for (int i = date.getYear(); i >= 2017; i--) {
			cbbNam.addItem(i);
		}
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		
		
	}
	public void loadData() {
		int year = (int) cbbNam.getSelectedItem();
		for (int i = 1; i <= 12; i++) {
			LocalDate date = LocalDate.of(year, i, 1);
			dataset.addValue(hd_dao.layDoanhThuThang(date), "DoanhThu", i + "");
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btnXem)) {
			loadData();
		}
	}
}

