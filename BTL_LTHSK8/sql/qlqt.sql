USE [QLQT]
GO
/****** Object:  Table [dbo].[BenhNhan]    Script Date: 7/27/2022 3:40:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BenhNhan](
	[maBN] [nvarchar](10) NOT NULL,
	[tenBN] [nvarchar](20) NOT NULL,
	[gioiTinh] [nvarchar](5) NOT NULL,
	[sdt] [varchar](20) NOT NULL,
	[diaChi] [nvarchar](50) NOT NULL,
	[ghiChu] [nvarchar](50) NULL,
	[tuoi] [int] NOT NULL,
 CONSTRAINT [PK_BenhNhan] PRIMARY KEY CLUSTERED 
(
	[maBN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CT_HoaDon]    Script Date: 7/27/2022 3:40:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CT_HoaDon](
	[maHD] [nvarchar](10) NOT NULL,
	[maThuoc] [varchar](10) NOT NULL,
	[soLuong] [int] NOT NULL,
	[thanhTien] [money] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 7/27/2022 3:40:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[maHD] [nvarchar](10) NOT NULL,
	[ngayLap] [date] NULL,
	[ghiChu] [nvarchar](30) NULL,
	[maNV] [nvarchar](10) NULL,
	[thanhTien] [money] NULL,
	[maBN] [nvarchar](10) NOT NULL,
 CONSTRAINT [pk_HoaDon] PRIMARY KEY CLUSTERED 
(
	[maHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 7/27/2022 3:40:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[maNV] [nvarchar](10) NOT NULL,
	[tenNV] [nvarchar](20) NULL,
	[gioiTinh] [nvarchar](5) NULL,
	[sdt] [nvarchar](15) NULL,
	[tuoi] [int] NULL,
	[loaiNV] [nvarchar](20) NOT NULL,
	[diaChi] [nvarchar](50) NOT NULL,
 CONSTRAINT [pk_NhanVien] PRIMARY KEY CLUSTERED 
(
	[maNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaSanXuat]    Script Date: 7/27/2022 3:40:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaSanXuat](
	[maNSX] [varchar](10) NOT NULL,
	[tenNSX] [nvarchar](20) NOT NULL,
	[sdt] [varchar](20) NOT NULL,
	[diaChi] [nvarchar](30) NOT NULL,
 CONSTRAINT [pk_NhaSanXuat] PRIMARY KEY CLUSTERED 
(
	[maNSX] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 7/27/2022 3:40:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[maNV] [nvarchar](10) NOT NULL,
	[matKhau] [varchar](20) NOT NULL,
 CONSTRAINT [pk_TaiKhoan] PRIMARY KEY CLUSTERED 
(
	[maNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Thuoc]    Script Date: 7/27/2022 3:40:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Thuoc](
	[maThuoc] [varchar](10) NOT NULL,
	[tenThuoc] [nvarchar](20) NOT NULL,
	[donVi] [nvarchar](10) NOT NULL,
	[loaiThuoc] [nvarchar](20) NOT NULL,
	[donGia] [money] NOT NULL,
	[ngaySX] [date] NOT NULL,
	[ngayHH] [date] NOT NULL,
	[maNSX] [varchar](10) NOT NULL,
	[soLuong] [int] NOT NULL,
	[ghiChu] [nvarchar](50) NULL,
 CONSTRAINT [pk_Thuoc] PRIMARY KEY CLUSTERED 
(
	[maThuoc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[BenhNhan] ([maBN], [tenBN], [gioiTinh], [sdt], [diaChi], [ghiChu], [tuoi]) VALUES (N'BN0001', N'Võ Ngọc Phương Uyên', N'nữ', N'0931819547', N'Phường 8, quận 7, thành phố HCM', N'đau họng,có đờm', 18)
INSERT [dbo].[BenhNhan] ([maBN], [tenBN], [gioiTinh], [sdt], [diaChi], [ghiChu], [tuoi]) VALUES (N'BN0002', N'Phạm Thị Lan', N'nữ', N'0964499728', N'Phường 7, quận 6, thành phố HCM', N'tiểu tường', 20)
INSERT [dbo].[BenhNhan] ([maBN], [tenBN], [gioiTinh], [sdt], [diaChi], [ghiChu], [tuoi]) VALUES (N'BN0003', N'Nguyễn Thị Thanh Ly', N'nữ', N'0915134023', N'Phường 7, quận 4, thành phố HCM', N'các bệnh liên quan đến hô hấp', 45)
INSERT [dbo].[BenhNhan] ([maBN], [tenBN], [gioiTinh], [sdt], [diaChi], [ghiChu], [tuoi]) VALUES (N'BN0004', N'Vũ Đình Đoàn', N'nam', N'0948993704', N'Phường 8, quận 4, thành phố HCM', N'viêm da đầu', 35)
INSERT [dbo].[BenhNhan] ([maBN], [tenBN], [gioiTinh], [sdt], [diaChi], [ghiChu], [tuoi]) VALUES (N'BN0005', N'Trần Minh Thái', N'nam', N'0967594094', N'Phường 8, quận 7, thành phố HCM', N'sốt cao', 23)
INSERT [dbo].[BenhNhan] ([maBN], [tenBN], [gioiTinh], [sdt], [diaChi], [ghiChu], [tuoi]) VALUES (N'BN0006', N'Phạm Thị Mơ', N'nữ', N'0958674549', N'Phường 1, quận 2, thành phố HCM', N'hay thiếu ngủ,đau đầu', 25)
INSERT [dbo].[BenhNhan] ([maBN], [tenBN], [gioiTinh], [sdt], [diaChi], [ghiChu], [tuoi]) VALUES (N'BN0007', N'Trần Khắc An', N'nam', N'0984803092', N'Phường 7, quận 3, thành phố HCM', N'hay đi ngoài', 40)
INSERT [dbo].[BenhNhan] ([maBN], [tenBN], [gioiTinh], [sdt], [diaChi], [ghiChu], [tuoi]) VALUES (N'BN0008', N'Tạ Thị Mỹ Duyên', N'nữ', N'0997990483', N'Phường 7, quận 10, thành phố HCM', N'nhức đầu, đau họng , mất ngủ thường xuyên', 50)
INSERT [dbo].[BenhNhan] ([maBN], [tenBN], [gioiTinh], [sdt], [diaChi], [ghiChu], [tuoi]) VALUES (N'BN0009', N'Nguyễn Kim Hường', N'nữ', N'0974129128', N'Phường 9, quận 4, thành phố HCM', N'thường bị ù tai, chảy máu ngoài', 34)
INSERT [dbo].[BenhNhan] ([maBN], [tenBN], [gioiTinh], [sdt], [diaChi], [ghiChu], [tuoi]) VALUES (N'BN0010', N'Uông Mai Thành Long', N'nam', N'0963061028', N'Phường 2, quận 10, thành phố HCM', N'đau dạ dày , có đờm trong họng', 26)
INSERT [dbo].[BenhNhan] ([maBN], [tenBN], [gioiTinh], [sdt], [diaChi], [ghiChu], [tuoi]) VALUES (N'BN0011', N'Nguyễn Ngọc Như', N'nữ', N'0992058196', N'Phường 1, quận 10, thành phố HCM', N'nhức mỏi toàn thân', 55)
INSERT [dbo].[BenhNhan] ([maBN], [tenBN], [gioiTinh], [sdt], [diaChi], [ghiChu], [tuoi]) VALUES (N'BN0012', N'Bùi Trọng Ân', N'nam', N'0923784873', N'Phường 6, quận 9, thành phố HCM', N'đau ngực trai khi hit thở , hô hấp thấp', 32)
INSERT [dbo].[BenhNhan] ([maBN], [tenBN], [gioiTinh], [sdt], [diaChi], [ghiChu], [tuoi]) VALUES (N'BN0013', N'Nguyễn Tô Ni', N'nữ', N'0954802819', N'Phường 2, quận 1, thành phố HCM', N'các chiệu chứng về chuyển hóa thấp', 26)
INSERT [dbo].[BenhNhan] ([maBN], [tenBN], [gioiTinh], [sdt], [diaChi], [ghiChu], [tuoi]) VALUES (N'BN0014', N'Nguyễn Thành Phát', N'nam', N'0938341289', N'Phường 2, quận 8, thành phố HCM', N'có nguy cơ nhiễm trùng  tiết  niệu', 34)
INSERT [dbo].[BenhNhan] ([maBN], [tenBN], [gioiTinh], [sdt], [diaChi], [ghiChu], [tuoi]) VALUES (N'BN0015', N'Nguyễn Trần Triệu Vĩ', N'nam', N'0929453204', N'Phường 9, quận 2, thành phố HCM', N'đi ngoài , đau bụng thường xuyên', 44)
INSERT [dbo].[BenhNhan] ([maBN], [tenBN], [gioiTinh], [sdt], [diaChi], [ghiChu], [tuoi]) VALUES (N'BN0016', N'Lê Hồng Phát', N'nam', N'0932614286', N'Phường 6, quận 3, thành phố HCM', N'khó ngủ, ho ra đờm', 27)
INSERT [dbo].[BenhNhan] ([maBN], [tenBN], [gioiTinh], [sdt], [diaChi], [ghiChu], [tuoi]) VALUES (N'BN0017', N'Trần Như Thiện Tâm', N'nữ', N'0944975933', N'Phường 2, quận 11, thành phố HCM', N'đau họng, hắt xì , mất ngủ', 36)
INSERT [dbo].[BenhNhan] ([maBN], [tenBN], [gioiTinh], [sdt], [diaChi], [ghiChu], [tuoi]) VALUES (N'BN0018', N'Huỳnh Song Hậu', N'nam', N'0938788040', N'Phường 4, quận 5, thành phố HCM', N'thường chảy máu mũi, dễ mắc bệnh ngoài da', 40)
INSERT [dbo].[BenhNhan] ([maBN], [tenBN], [gioiTinh], [sdt], [diaChi], [ghiChu], [tuoi]) VALUES (N'BN0019', N'Trần Duy Phụng', N'nam', N'0926669846', N'Phường 9, quận 3, thành phố HCM', N'đau bụng, đi ra máu', 45)
INSERT [dbo].[BenhNhan] ([maBN], [tenBN], [gioiTinh], [sdt], [diaChi], [ghiChu], [tuoi]) VALUES (N'BN0020', N'Phan Quốc Khải', N'nam', N'0947754624', N'Phường 7, quận 7, thành phố HCM', N'nóng bụng, khó đi, đau rát khi vệ sinh', 46)
INSERT [dbo].[BenhNhan] ([maBN], [tenBN], [gioiTinh], [sdt], [diaChi], [ghiChu], [tuoi]) VALUES (N'BN0021', N'Võ Văn Tình', N'nam', N'0990027300', N'Phường 5, quận 8, thành phố HCM', N'khó thở , thường chảy máu', 30)
INSERT [dbo].[BenhNhan] ([maBN], [tenBN], [gioiTinh], [sdt], [diaChi], [ghiChu], [tuoi]) VALUES (N'BN0022', N'Nguyễn Nhựt Hào', N'nam', N'0918921954', N'Phường 5, quận 10, thành phố HCM', N'hay quên, đau đầu ', 35)
INSERT [dbo].[BenhNhan] ([maBN], [tenBN], [gioiTinh], [sdt], [diaChi], [ghiChu], [tuoi]) VALUES (N'BN0023', N'Nguyễn Văn Tình', N'nữ', N'0916438748', N'Phường 7, quận 8, thành phố HCM', N'thường đau bụng, đầy hơi', 25)
INSERT [dbo].[BenhNhan] ([maBN], [tenBN], [gioiTinh], [sdt], [diaChi], [ghiChu], [tuoi]) VALUES (N'BN0024', N'Bùi Thị Bình', N'nữ', N'0980790088', N'Phường 3, quận 9, thành phố HCM', N'hay đau ngực trái', 26)
INSERT [dbo].[BenhNhan] ([maBN], [tenBN], [gioiTinh], [sdt], [diaChi], [ghiChu], [tuoi]) VALUES (N'BN0025', N'Nguyễn Văn Vĩnh', N'nam', N'0991384268', N'Phường 4, quận 2, thành phố HCM', N'mỏi vai', 21)
INSERT [dbo].[BenhNhan] ([maBN], [tenBN], [gioiTinh], [sdt], [diaChi], [ghiChu], [tuoi]) VALUES (N'BN0026', N'Trương Quang Vũ', N'nam', N'0940623221', N'Phường 5, quận 4, thành phố HCM', N'đau nhức xương khớp', 36)
INSERT [dbo].[BenhNhan] ([maBN], [tenBN], [gioiTinh], [sdt], [diaChi], [ghiChu], [tuoi]) VALUES (N'BN0027', N'Nguyên Thị Ngân', N'nữ', N'0942667491', N'Phường 4, quận 8, thành phố HCM', N'đau dạ dày', 25)
INSERT [dbo].[BenhNhan] ([maBN], [tenBN], [gioiTinh], [sdt], [diaChi], [ghiChu], [tuoi]) VALUES (N'BN0028', N'Mai Thị Đào', N'nữ', N'0991704789', N'Phường 2, quận 2, thành phố HCM', N'thường chảy máu mũi', 22)
INSERT [dbo].[BenhNhan] ([maBN], [tenBN], [gioiTinh], [sdt], [diaChi], [ghiChu], [tuoi]) VALUES (N'BN0029', N'Trần Minh Thư', N'nữ', N'0941655612', N'Phường 6, quận 9, thành phố HCM', N'tiêu hóa thấp , khó tiêu hóa', 15)
INSERT [dbo].[BenhNhan] ([maBN], [tenBN], [gioiTinh], [sdt], [diaChi], [ghiChu], [tuoi]) VALUES (N'BN0030', N'Trần Quang Đức', N'nam', N'0980962751', N'Phường 2, quận 7, thành phố HCM', N'ho ra đờm, sốt', 26)
INSERT [dbo].[BenhNhan] ([maBN], [tenBN], [gioiTinh], [sdt], [diaChi], [ghiChu], [tuoi]) VALUES (N'BN0031', N'Trần Thu Hà', N'nữ', N'0966745816', N'Phường 2, quận 6, thành phố HCM', N'khó thở, hay đau ở ngực', 27)
INSERT [dbo].[BenhNhan] ([maBN], [tenBN], [gioiTinh], [sdt], [diaChi], [ghiChu], [tuoi]) VALUES (N'BN0032', N'Trần Việt Long', N'nam', N'0937544967', N'Phường 9, quận 2, thành phố HCM', N'thường xuyên mất ngủ', 22)
INSERT [dbo].[BenhNhan] ([maBN], [tenBN], [gioiTinh], [sdt], [diaChi], [ghiChu], [tuoi]) VALUES (N'BN0033', N'Võ Tấn Thanh', N'nữ', N'0948720781', N'Phường 9, quận 7, thành phố HCM', N'viêm da ở tay và chân', 26)
INSERT [dbo].[BenhNhan] ([maBN], [tenBN], [gioiTinh], [sdt], [diaChi], [ghiChu], [tuoi]) VALUES (N'BN0034', N'Nguyễn Hữu Duy', N'nam', N'0919449901', N'Phường 3, quận 8, thành phố HCM', N'đau họng , hắt xì', 16)
INSERT [dbo].[BenhNhan] ([maBN], [tenBN], [gioiTinh], [sdt], [diaChi], [ghiChu], [tuoi]) VALUES (N'BN0035', N'Nguyễn Minh Trí', N'nam', N'0962551528', N'Phường 3, quận 10, thành phố HCM', N'tiêu hóa thấp , đau bụng ', 38)
INSERT [dbo].[BenhNhan] ([maBN], [tenBN], [gioiTinh], [sdt], [diaChi], [ghiChu], [tuoi]) VALUES (N'BN0036', N'Lê Đào Tuyết My', N'nữ', N'0954447089', N'Phường 7, quận 6, thành phố HCM', N'ho , hát xì, sốt', 20)
INSERT [dbo].[BenhNhan] ([maBN], [tenBN], [gioiTinh], [sdt], [diaChi], [ghiChu], [tuoi]) VALUES (N'BN0037', N'Nguyên Trọng Nghĩa', N'nam', N'0956337848', N'Phường 5, quận 2, thành phố HCM', N'khó ngủ, đi ngoài nhiều', 25)
INSERT [dbo].[BenhNhan] ([maBN], [tenBN], [gioiTinh], [sdt], [diaChi], [ghiChu], [tuoi]) VALUES (N'BN0038', N'Nguyễn Mạnh Thìn', N'nam', N'0926698238', N'Phường 9, quận 7, thành phố HCM', N'đau nhức tay , cẳng tay', 35)
INSERT [dbo].[BenhNhan] ([maBN], [tenBN], [gioiTinh], [sdt], [diaChi], [ghiChu], [tuoi]) VALUES (N'BN0039', N'Cao Hoài Nam', N'nam', N'0973838031', N'Phường 1, quận 5, thành phố HCM', N'đau khớp tay và chân', 40)
INSERT [dbo].[BenhNhan] ([maBN], [tenBN], [gioiTinh], [sdt], [diaChi], [ghiChu], [tuoi]) VALUES (N'BN0040', N'Nguyễn Thành Tâm', N'nam', N'0935721481', N'Phường 8, quận 4, thành phố HCM', N'đau ngực trái , đau bụng', 29)
GO
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0001', N'T0007', 3, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0002', N'T0005', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0001', N'T0008', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0001', N'T0017', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0002', N'T0015', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0002', N'T0024', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0003', N'T0001', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0003', N'T0017', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0004', N'T0017', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0004', N'T0005', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0005', N'T0029', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0006', N'T0040', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0006', N'T0038', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0007', N'T0007', 6, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0008', N'T0012', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0009', N'T0018', 2, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0009', N'T0019', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0010', N'T0014', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0011', N'T0001', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0012', N'T0029', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0013', N'T0002', 3, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0013', N'T0019', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0013', N'T0026', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0015', N'T0024', 3, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0016', N'T0018', 3, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0016', N'T0009', 3, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0017', N'T0009', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0019', N'T0041', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0019', N'T0026', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0020', N'T0010', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0022', N'T0025', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0023', N'T0032', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0027', N'T0001', 3, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0027', N'T0025', 3, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0027', N'T0010', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0051', N'T0017', 3, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0052', N'T0030', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0052', N'T0003', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0053', N'T0022', 3, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0055', N'T0040', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0055', N'T0034', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0056', N'T0027', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0057', N'T0036', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0058', N'T0025', 3, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0061', N'T0025', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0061', N'T0009', 6, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0063', N'T0005', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0064', N'T0021', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0065', N'T0022', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0065', N'T0034', 3, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0066', N'T0021', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0067', N'T0027', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0068', N'T0024', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0069', N'T0029', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0069', N'T0029', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0070', N'T0001', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0072', N'T0041', 3, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0073', N'T0008', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0074', N'T0030', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0074', N'T0022', 3, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0075', N'T0002', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0024', N'T0002', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0024', N'T0035', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0024', N'T0040', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0078', N'T0002', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0078', N'T0011', 3, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0080', N'T0025', 6, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0081', N'T0020', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0081', N'T0037', 6, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0082', N'T0010', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0083', N'T0026', 7, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0085', N'T0017', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0086', N'T0022', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0086', N'T0016', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0086', N'T0037', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0090', N'T0018', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0090', N'T0019', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0091', N'T0038', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0092', N'T0039', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0093', N'T0041', 3, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0093', N'T0022', 3, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0094', N'T0023', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0095', N'T0024', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0095', N'T0011', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0096', N'T0015', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0097', N'T0025', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0100', N'T0005', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0100', N'T0024', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0100', N'T0039', 3, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0101', N'T0004', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0103', N'T0009', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0105', N'T0007', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0106', N'T0025', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0106', N'T0003', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0108', N'T0015', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0111', N'T0020', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0111', N'T0002', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0112', N'T0037', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0113', N'T0009', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0114', N'T0037', 4, NULL)
GO
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0115', N'T0022', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0117', N'T0036', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0117', N'T0034', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0118', N'T0012', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0121', N'T0041', 3, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0122', N'T0023', 6, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0124', N'T0022', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0124', N'T0002', 3, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0125', N'T0039', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0126', N'T0001', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0094', N'T0009', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0130', N'T0034', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0132', N'T0006', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0133', N'T0008', 6, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0134', N'T0034', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0135', N'T0001', 6, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0135', N'T0037', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0135', N'T0011', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0136', N'T0024', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0136', N'T0007', 7, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0137', N'T0003', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0003', N'T0015', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0004', N'T0025', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0005', N'T0035', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0006', N'T0037', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0007', N'T0008', 6, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0008', N'T0010', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0009', N'T0016', 9, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0010', N'T0031', 7, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0011', N'T0021', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0012', N'T0009', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0013', N'T0018', 3, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0014', N'T0011', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0015', N'T0032', 3, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0016', N'T0017', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0017', N'T0020', 9, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0018', N'T0009', 6, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0019', N'T0025', 11, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0020', N'T0026', 10, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0021', N'T0039', 7, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0022', N'T0040', 11, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0023', N'T0006', 6, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0025', N'T0026', 8, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0026', N'T0034', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0028', N'T0041', 6, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0029', N'T0030', 8, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0030', N'T0038', 10, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0031', N'T0023', 7, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0032', N'T0013', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0033', N'T0023', 6, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0034', N'T0012', 8, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0035', N'T0025', 10, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0036', N'T0014', 6, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0037', N'T0022', 9, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0038', N'T0029', 7, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0039', N'T0004', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0040', N'T0033', 15, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0041', N'T0017', 8, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0042', N'T0002', 10, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0043', N'T0020', 7, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0044', N'T0003', 6, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0045', N'T0024', 8, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0046', N'T0022', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0047', N'T0040', 6, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0048', N'T0001', 10, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0049', N'T0005', 6, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0050', N'T0029', 8, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0051', N'T0015', 6, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0052', N'T0028', 8, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0053', N'T0002', 7, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0054', N'T0038', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0055', N'T0024', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0056', N'T0014', 6, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0057', N'T0018', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0058', N'T0005', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0059', N'T0018', 6, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0060', N'T0020', 8, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0061', N'T0013', 9, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0062', N'T0021', 6, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0063', N'T0033', 7, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0064', N'T0011', 10, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0065', N'T0035', 8, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0066', N'T0041', 14, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0067', N'T0002', 8, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0068', N'T0001', 8, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0069', N'T0029', 7, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0070', N'T0014', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0071', N'T0005', 8, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0072', N'T0016', 6, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0073', N'T0034', 6, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0074', N'T0029', 9, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0075', N'T0017', 7, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0076', N'T0019', 6, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0077', N'T0021', 7, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0079', N'T0014', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0080', N'T0008', 15, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0081', N'T0018', 10, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0082', N'T0027', 7, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0083', N'T0009', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0085', N'T0024', 4, NULL)
GO
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0014', N'T0012', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0087', N'T0036', 8, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0088', N'T0014', 7, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0089', N'T0007', 9, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0090', N'T0002', 7, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0091', N'T0001', 6, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0092', N'T0018', 8, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0093', N'T0040', 6, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0094', N'T0041', 7, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0095', N'T0032', 8, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0096', N'T0027', 9, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0097', N'T0016', 10, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0098', N'T0025', 8, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0099', N'T0001', 7, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0100', N'T0016', 6, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0101', N'T0029', 8, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0102', N'T0036', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0103', N'T0008', 8, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0104', N'T0004', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0105', N'T0024', 6, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0106', N'T0036', 6, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0107', N'T0017', 7, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0108', N'T0003', 6, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0109', N'T0005', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0110', N'T0016', 6, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0111', N'T0015', 8, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0112', N'T0028', 7, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0113', N'T0016', 7, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0114', N'T0025', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0115', N'T0021', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0116', N'T0011', 8, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0117', N'T0016', 6, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0118', N'T0029', 9, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0119', N'T0024', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0120', N'T0001', 10, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0121', N'T0005', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0122', N'T0036', 6, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0122', N'T0009', 8, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0123', N'T0011', 7, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0124', N'T0021', 6, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0125', N'T0035', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0126', N'T0023', 8, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0127', N'T0033', 10, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0128', N'T0022', 10, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0129', N'T0010', 11, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0130', N'T0008', 6, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0131', N'T0017', 7, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0132', N'T0028', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0133', N'T0029', 7, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0134', N'T0024', 7, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0136', N'T0027', 8, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0137', N'T0036', 6, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0139', N'T0041', 8, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0140', N'T0003', 8, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0141', N'T0011', 10, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0142', N'T0025', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0143', N'T0034', 7, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0144', N'T0036', 6, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0145', N'T0024', 6, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0146', N'T0029', 9, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0147', N'T0039', 7, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0148', N'T0002', 7, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0149', N'T0018', 8, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0150', N'T0005', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0151', N'T0001', 11, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0152', N'T0031', 10, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0028', N'T0040', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0019', N'T0008', 3, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0029', N'T0033', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0030', N'T0002', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0031', N'T0020', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0031', N'T0003', 3, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0033', N'T0001', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0034', N'T0011', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0034', N'T0035', 3, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0037', N'T0020', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0037', N'T0040', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0138', N'T0001', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0138', N'T0025', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0039', N'T0010', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0039', N'T0025', 3, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0040', N'T0040', 3, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0041', N'T0020', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0043', N'T0022', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0044', N'T0012', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0049', N'T0035', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0050', N'T0010', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0139', N'T0002', 3, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0027', N'T0011', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0027', N'T0031', 3, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0140', N'T0005', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0140', N'T0038', 3, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0142', N'T0009', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0143', N'T0005', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0143', N'T0041', 2, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0144', N'T0029', 3, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0144', N'T0025', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0145', N'T0013', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0145', N'T0031', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0146', N'T0014', 4, NULL)
GO
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0147', N'T0006', 2, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0149', N'T0041', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0149', N'T0029', 3, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0149', N'T0001', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0150', N'T0010', 3, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0150', N'T0041', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0150', N'T0034', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0151', N'T0021', 3, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0151', N'T0015', 4, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0152', N'T0031', 3, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0152', N'T0003', 5, NULL)
INSERT [dbo].[CT_HoaDon] ([maHD], [maThuoc], [soLuong], [thanhTien]) VALUES (N'HD0152', N'T0020', 5, NULL)
GO
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0001', CAST(N'2020-07-15' AS Date), NULL, N'NV0002', NULL, N'BN0040')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0002', CAST(N'2020-06-14' AS Date), NULL, N'NV0001', NULL, N'BN0005')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0003', CAST(N'2020-09-16' AS Date), NULL, N'NV0001', NULL, N'BN0016')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0004', CAST(N'2020-09-01' AS Date), NULL, N'NV0003', NULL, N'BN0025')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0005', CAST(N'2020-08-04' AS Date), NULL, N'NV0004', NULL, N'BN0022')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0006', CAST(N'2020-01-26' AS Date), NULL, N'NV0003', NULL, N'BN0031')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0007', CAST(N'2020-04-10' AS Date), NULL, N'NV0002', NULL, N'BN0004')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0008', CAST(N'2020-05-06' AS Date), NULL, N'NV0001', NULL, N'BN0017')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0009', CAST(N'2020-02-02' AS Date), NULL, N'NV0001', NULL, N'BN0006')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0010', CAST(N'2020-05-10' AS Date), NULL, N'NV0002', NULL, N'BN0019')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0011', CAST(N'2020-02-03' AS Date), NULL, N'NV0004', NULL, N'BN0020')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0012', CAST(N'2020-06-19' AS Date), NULL, N'NV0002', NULL, N'BN0021')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0013', CAST(N'2020-01-01' AS Date), NULL, N'NV0004', NULL, N'BN0039')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0014', CAST(N'2020-05-07' AS Date), NULL, N'NV0002', NULL, N'BN0026')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0015', CAST(N'2020-05-12' AS Date), NULL, N'NV0001', NULL, N'BN0030')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0016', CAST(N'2020-02-07' AS Date), NULL, N'NV0001', NULL, N'BN0036')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0017', CAST(N'2020-05-22' AS Date), NULL, N'NV0002', NULL, N'BN0028')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0018', CAST(N'2020-08-11' AS Date), NULL, N'NV0002', NULL, N'BN0035')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0019', CAST(N'2020-05-23' AS Date), NULL, N'NV0003', NULL, N'BN0007')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0020', CAST(N'2020-02-09' AS Date), NULL, N'NV0003', NULL, N'BN0015')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0021', CAST(N'2020-06-11' AS Date), NULL, N'NV0004', NULL, N'BN0013')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0022', CAST(N'2020-07-22' AS Date), NULL, N'NV0004', NULL, N'BN0008')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0023', CAST(N'2020-03-23' AS Date), NULL, N'NV0001', NULL, N'BN0001')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0024', CAST(N'2020-03-23' AS Date), NULL, N'NV0001', NULL, N'BN0003')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0025', CAST(N'2020-10-14' AS Date), NULL, N'NV0002', NULL, N'BN0009')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0026', CAST(N'2020-06-15' AS Date), NULL, N'NV0003', NULL, N'BN0011')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0027', CAST(N'2020-12-02' AS Date), NULL, N'NV0004', NULL, N'BN0025')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0028', CAST(N'2020-07-06' AS Date), NULL, N'NV0001', NULL, N'BN0033')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0029', CAST(N'2020-01-06' AS Date), NULL, N'NV0002', NULL, N'BN0012')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0030', CAST(N'2020-04-21' AS Date), NULL, N'NV0003', NULL, N'BN0032')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0031', CAST(N'2020-04-14' AS Date), NULL, N'NV0002', NULL, N'BN0037')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0032', CAST(N'2020-03-02' AS Date), NULL, N'NV0004', NULL, N'BN0002')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0033', CAST(N'2020-07-06' AS Date), NULL, N'NV0004', NULL, N'BN0010')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0034', CAST(N'2020-02-08' AS Date), NULL, N'NV0001', NULL, N'BN0024')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0035', CAST(N'2020-07-16' AS Date), NULL, N'NV0002', NULL, N'BN0013')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0036', CAST(N'2020-11-15' AS Date), NULL, N'NV0001', NULL, N'BN0034')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0037', CAST(N'2020-08-19' AS Date), NULL, N'NV0002', NULL, N'BN0013')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0038', CAST(N'2020-08-20' AS Date), NULL, N'NV0004', NULL, N'BN0023')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0039', CAST(N'2020-04-18' AS Date), NULL, N'NV0004', NULL, N'BN0014')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0040', CAST(N'2020-11-18' AS Date), NULL, N'NV0003', NULL, N'BN0029')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0041', CAST(N'2020-02-11' AS Date), NULL, N'NV0002', NULL, N'BN0018')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0042', CAST(N'2020-12-11' AS Date), NULL, N'NV0001', NULL, N'BN0034')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0043', CAST(N'2020-03-21' AS Date), NULL, N'NV0002', NULL, N'BN0031')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0044', CAST(N'2020-01-07' AS Date), NULL, N'NV0001', NULL, N'BN0002')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0045', CAST(N'2020-05-01' AS Date), NULL, N'NV0002', NULL, N'BN0013')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0046', CAST(N'2020-01-18' AS Date), NULL, N'NV0003', NULL, N'BN0001')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0047', CAST(N'2020-09-21' AS Date), NULL, N'NV0004', NULL, N'BN0036')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0048', CAST(N'2020-06-09' AS Date), NULL, N'NV0002', NULL, N'BN0023')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0049', CAST(N'2020-08-21' AS Date), NULL, N'NV0002', NULL, N'BN0025')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0050', CAST(N'2020-10-21' AS Date), NULL, N'NV0001', NULL, N'BN0008')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0051', CAST(N'2020-02-14' AS Date), NULL, N'NV0002', NULL, N'BN0006')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0052', CAST(N'2020-05-05' AS Date), NULL, N'NV0003', NULL, N'BN0023')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0053', CAST(N'2020-06-08' AS Date), NULL, N'NV0004', NULL, N'BN0015')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0054', CAST(N'2020-09-30' AS Date), NULL, N'NV0004', NULL, N'BN0028')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0055', CAST(N'2020-10-15' AS Date), NULL, N'NV0001', NULL, N'BN0003')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0056', CAST(N'2020-10-28' AS Date), NULL, N'NV0002', NULL, N'BN0004')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0057', CAST(N'2020-11-03' AS Date), NULL, N'NV0001', NULL, N'BN0029')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0058', CAST(N'2020-11-23' AS Date), NULL, N'NV0002', NULL, N'BN0030')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0059', CAST(N'2020-12-07' AS Date), NULL, N'NV0001', NULL, N'BN0027')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0060', CAST(N'2020-12-30' AS Date), NULL, N'NV0003', NULL, N'BN0040')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0061', CAST(N'2021-01-06' AS Date), NULL, N'NV0002', NULL, N'BN0002')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0062', CAST(N'2021-01-08' AS Date), NULL, N'NV0003', NULL, N'BN0004')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0063', CAST(N'2021-01-08' AS Date), NULL, N'NV0003', NULL, N'BN0008')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0064', CAST(N'2021-01-15' AS Date), NULL, N'NV0002', NULL, N'BN0032')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0065', CAST(N'2021-01-15' AS Date), NULL, N'NV0002', NULL, N'BN0033')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0066', CAST(N'2021-01-15' AS Date), NULL, N'NV0002', NULL, N'BN0003')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0067', CAST(N'2021-01-26' AS Date), NULL, N'NV0001', NULL, N'BN0001')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0068', CAST(N'2021-01-26' AS Date), NULL, N'NV0001', NULL, N'BN0009')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0069', CAST(N'2021-01-29' AS Date), NULL, N'NV0004', NULL, N'BN0039')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0070', CAST(N'2021-02-05' AS Date), NULL, N'NV0003', NULL, N'BN0025')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0071', CAST(N'2021-02-06' AS Date), NULL, N'NV0003', NULL, N'BN0034')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0072', CAST(N'2021-02-07' AS Date), NULL, N'NV0004', NULL, N'BN0012')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0073', CAST(N'2021-02-14' AS Date), NULL, N'NV0001', NULL, N'BN0007')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0074', CAST(N'2021-02-16' AS Date), NULL, N'NV0002', NULL, N'BN0005')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0075', CAST(N'2021-02-17' AS Date), NULL, N'NV0002', NULL, N'BN0019')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0076', CAST(N'2021-02-18' AS Date), NULL, N'NV0002', NULL, N'BN0032')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0077', CAST(N'2021-02-19' AS Date), NULL, N'NV0003', NULL, N'BN0003')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0078', CAST(N'2021-02-20' AS Date), NULL, N'NV0003', NULL, N'BN0028')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0079', CAST(N'2021-02-21' AS Date), NULL, N'NV0003', NULL, N'BN0018')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0080', CAST(N'2021-02-28' AS Date), NULL, N'NV0004', NULL, N'BN0025')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0081', CAST(N'2021-03-01' AS Date), NULL, N'NV0001', NULL, N'BN0002')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0082', CAST(N'2021-03-02' AS Date), NULL, N'NV0001', NULL, N'BN0027')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0083', CAST(N'2021-03-06' AS Date), NULL, N'NV0004', NULL, N'BN0005')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0085', CAST(N'2021-03-07' AS Date), NULL, N'NV0001', NULL, N'BN0040')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0086', CAST(N'2021-03-10' AS Date), NULL, N'NV0002', NULL, N'BN0035')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0087', CAST(N'2021-03-11' AS Date), NULL, N'NV0003', NULL, N'BN0021')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0088', CAST(N'2021-03-12' AS Date), NULL, N'NV0004', NULL, N'BN0004')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0089', CAST(N'2021-03-15' AS Date), NULL, N'NV0001', NULL, N'BN0016')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0090', CAST(N'2021-03-16' AS Date), NULL, N'NV0002', NULL, N'BN0006')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0091', CAST(N'2021-03-20' AS Date), NULL, N'NV0002', NULL, N'BN0004')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0092', CAST(N'2021-03-21' AS Date), NULL, N'NV0001', NULL, N'BN0018')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0093', CAST(N'2021-03-22' AS Date), NULL, N'NV0003', NULL, N'BN0019')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0094', CAST(N'2021-03-25' AS Date), NULL, N'NV0004', NULL, N'BN0029')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0095', CAST(N'2021-03-27' AS Date), NULL, N'NV0004', NULL, N'BN0039')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0096', CAST(N'2021-03-29' AS Date), NULL, N'NV0003', NULL, N'BN0033')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0097', CAST(N'2021-04-02' AS Date), NULL, N'NV0001', NULL, N'BN0022')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0098', CAST(N'2021-04-03' AS Date), NULL, N'NV0001', NULL, N'BN0011')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0099', CAST(N'2021-04-04' AS Date), NULL, N'NV0001', NULL, N'BN0028')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0100', CAST(N'2021-04-05' AS Date), NULL, N'NV0002', NULL, N'BN0036')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0101', CAST(N'2021-04-06' AS Date), NULL, N'NV0002', NULL, N'BN0024')
GO
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0102', CAST(N'2021-04-07' AS Date), NULL, N'NV0002', NULL, N'BN0001')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0103', CAST(N'2021-04-08' AS Date), NULL, N'NV0002', NULL, N'BN0040')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0104', CAST(N'2021-04-09' AS Date), NULL, N'NV0003', NULL, N'BN0017')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0105', CAST(N'2021-04-10' AS Date), NULL, N'NV0003', NULL, N'BN0018')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0106', CAST(N'2021-04-11' AS Date), NULL, N'NV0003', NULL, N'BN0003')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0107', CAST(N'2021-04-12' AS Date), NULL, N'NV0003', NULL, N'BN0026')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0108', CAST(N'2021-04-13' AS Date), NULL, N'NV0003', NULL, N'BN0039')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0109', CAST(N'2021-04-14' AS Date), NULL, N'NV0004', NULL, N'BN0028')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0110', CAST(N'2021-04-15' AS Date), NULL, N'NV0004', NULL, N'BN0008')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0111', CAST(N'2021-04-15' AS Date), NULL, N'NV0004', NULL, N'BN0014')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0112', CAST(N'2019-12-22' AS Date), NULL, N'NV0004', NULL, N'BN0016')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0113', CAST(N'2019-12-15' AS Date), NULL, N'NV0001', NULL, N'BN0019')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0114', CAST(N'2019-11-21' AS Date), NULL, N'NV0003', NULL, N'BN0011')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0115', CAST(N'2019-11-13' AS Date), NULL, N'NV0003', NULL, N'BN0015')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0116', CAST(N'2019-10-30' AS Date), NULL, N'NV0004', NULL, N'BN0030')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0117', CAST(N'2019-10-12' AS Date), NULL, N'NV0001', NULL, N'BN0021')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0118', CAST(N'2019-09-27' AS Date), NULL, N'NV0001', NULL, N'BN0039')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0119', CAST(N'2019-09-09' AS Date), NULL, N'NV0002', NULL, N'BN0001')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0120', CAST(N'2019-08-26' AS Date), NULL, N'NV0003', NULL, N'BN0002')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0121', CAST(N'2019-07-10' AS Date), NULL, N'NV0004', NULL, N'BN0008')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0122', CAST(N'2019-06-09' AS Date), NULL, N'NV0001', NULL, N'BN0003')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0123', CAST(N'2019-05-05' AS Date), NULL, N'NV0003', NULL, N'BN0028')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0124', CAST(N'2019-04-01' AS Date), NULL, N'NV0004', NULL, N'BN0010')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0125', CAST(N'2019-03-22' AS Date), NULL, N'NV0003', NULL, N'BN0037')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0126', CAST(N'2019-02-19' AS Date), NULL, N'NV0001', NULL, N'BN0035')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0127', CAST(N'2019-01-27' AS Date), NULL, N'NV0002', NULL, N'BN0026')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0128', CAST(N'2018-12-25' AS Date), NULL, N'NV0001', NULL, N'BN0014')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0129', CAST(N'2018-12-01' AS Date), NULL, N'NV0002', NULL, N'BN0023')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0130', CAST(N'2018-11-15' AS Date), NULL, N'NV0003', NULL, N'BN0001')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0131', CAST(N'2018-10-28' AS Date), NULL, N'NV0004', NULL, N'BN0021')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0132', CAST(N'2018-09-20' AS Date), NULL, N'NV0004', NULL, N'BN0027')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0133', CAST(N'2018-08-12' AS Date), NULL, N'NV0003', NULL, N'BN0024')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0134', CAST(N'2018-07-06' AS Date), NULL, N'NV0001', NULL, N'BN0040')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0135', CAST(N'2018-06-24' AS Date), NULL, N'NV0001', NULL, N'BN0035')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0136', CAST(N'2018-05-18' AS Date), NULL, N'NV0002', NULL, N'BN0031')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0137', CAST(N'2018-04-28' AS Date), NULL, N'NV0003', NULL, N'BN0032')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0138', CAST(N'2018-03-22' AS Date), NULL, N'NV0004', NULL, N'BN0011')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0139', CAST(N'2018-02-23' AS Date), NULL, N'NV0002', NULL, N'BN0001')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0140', CAST(N'2018-01-15' AS Date), NULL, N'NV0001', NULL, N'BN0009')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0141', CAST(N'2017-12-31' AS Date), NULL, N'NV0002', NULL, N'BN0034')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0142', CAST(N'2017-11-30' AS Date), NULL, N'NV0004', NULL, N'BN0032')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0143', CAST(N'2017-10-25' AS Date), NULL, N'NV0003', NULL, N'BN0029')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0144', CAST(N'2017-09-10' AS Date), NULL, N'NV0002', NULL, N'BN0026')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0145', CAST(N'2017-08-23' AS Date), NULL, N'NV0002', NULL, N'BN0020')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0146', CAST(N'2017-04-22' AS Date), NULL, N'NV0002', NULL, N'BN0017')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0147', CAST(N'2017-04-11' AS Date), NULL, N'NV0001', NULL, N'BN0013')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0148', CAST(N'2017-03-31' AS Date), NULL, N'NV0003', NULL, N'BN0009')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0149', CAST(N'2017-03-20' AS Date), NULL, N'NV0004', NULL, N'BN0005')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0150', CAST(N'2017-02-21' AS Date), NULL, N'NV0003', NULL, N'BN0003')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0151', CAST(N'2017-01-23' AS Date), NULL, N'NV0001', NULL, N'BN0002')
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [ghiChu], [maNV], [thanhTien], [maBN]) VALUES (N'HD0152', CAST(N'2017-01-02' AS Date), NULL, N'NV0002', NULL, N'BN0001')
GO
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [gioiTinh], [sdt], [tuoi], [loaiNV], [diaChi]) VALUES (N'NV0001    ', N'Trần Huy Thắng', N'nam', N'0568933641', 20, N'NV', N'Phường 5, Quận 10, TPHCM')
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [gioiTinh], [sdt], [tuoi], [loaiNV], [diaChi]) VALUES (N'NV0002', N'Trần Lê Tuấn Anh', N'nam', N'0576934856', 20, N'NV', N'Phường 4, Gò Vấp, TPHCM')
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [gioiTinh], [sdt], [tuoi], [loaiNV], [diaChi]) VALUES (N'NV0003', N'Thân Trọng Hùng', N'nam', N'0564876359', 20, N'NV', N'Phường 2, Quận 4, TPHCM')
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [gioiTinh], [sdt], [tuoi], [loaiNV], [diaChi]) VALUES (N'NV0004', N'Cao Thành Đạt', N'nam', N'0457892467', 20, N'NV', N'Phường 3, Quận 7, TPHCM')
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [gioiTinh], [sdt], [tuoi], [loaiNV], [diaChi]) VALUES (N'NV0005', N'Trịnh Diễm Quyên', N'nữ', N'0905955648', 30, N'QL', N'Phường 4, Quận 1, thành phố HCM')
GO
INSERT [dbo].[NhaSanXuat] ([maNSX], [tenNSX], [sdt], [diaChi]) VALUES (N'NSX0001', N'LG Chem, Ltd.', N'0934550045', N'DC')
INSERT [dbo].[NhaSanXuat] ([maNSX], [tenNSX], [sdt], [diaChi]) VALUES (N'NSX0002', N'Usarichpharm', N'0936772833', N'TP. Hồ Chí Minh')
INSERT [dbo].[NhaSanXuat] ([maNSX], [tenNSX], [sdt], [diaChi]) VALUES (N'NSX0003', N'Bệnh viện Y học', N'0934550045', N'Củ Chi')
INSERT [dbo].[NhaSanXuat] ([maNSX], [tenNSX], [sdt], [diaChi]) VALUES (N'NSX0004', N'Baxalta Manufa', N'0938325293', N'Paris')
INSERT [dbo].[NhaSanXuat] ([maNSX], [tenNSX], [sdt], [diaChi]) VALUES (N'NSX0005', N'Công ty Pharma USA', N'0933234061', N'TP.Hồ Chí Minh')
INSERT [dbo].[NhaSanXuat] ([maNSX], [tenNSX], [sdt], [diaChi]) VALUES (N'NSX0006', N'y tế Thanh Hóa', N'0939971852', N'Thanh Hóa')
INSERT [dbo].[NhaSanXuat] ([maNSX], [tenNSX], [sdt], [diaChi]) VALUES (N'NSX0007', N'dược phẩm Khang Minh', N'0932390212', N'Tp. Hồ Chí Minh')
INSERT [dbo].[NhaSanXuat] ([maNSX], [tenNSX], [sdt], [diaChi]) VALUES (N'NSX0008', N'Công ty Bidiphar 1', N'0939361639', N'Bình Định')
INSERT [dbo].[NhaSanXuat] ([maNSX], [tenNSX], [sdt], [diaChi]) VALUES (N'NSX0009', N'Công ty Trung ương 2', N'0934754208', N'Hà Nội')
INSERT [dbo].[NhaSanXuat] ([maNSX], [tenNSX], [sdt], [diaChi]) VALUES (N'NSX0010', N'Công ty BV Pharma', N'0933193546', N'TP. Hồ Chí Minh')
INSERT [dbo].[NhaSanXuat] ([maNSX], [tenNSX], [sdt], [diaChi]) VALUES (N'NSX0011', N'Medica Korea', N'0939055149', N'Hàn Quốc')
INSERT [dbo].[NhaSanXuat] ([maNSX], [tenNSX], [sdt], [diaChi]) VALUES (N'NSX0012', N'Công ty Meyer ', N'0935689371', N'Bến Tre')
INSERT [dbo].[NhaSanXuat] ([maNSX], [tenNSX], [sdt], [diaChi]) VALUES (N'NSX0013', N'Chi nhánh Vidipha', N'0937552934', N'Bình Dương')
INSERT [dbo].[NhaSanXuat] ([maNSX], [tenNSX], [sdt], [diaChi]) VALUES (N'NSX0014', N'Công ty  LD Stada', N'0938493048', N'TP. Hồ Chí minh')
INSERT [dbo].[NhaSanXuat] ([maNSX], [tenNSX], [sdt], [diaChi]) VALUES (N'NSX0015', N'Công ty IMEXPHARM', N'0937430389', N'Đồng Tháp')
INSERT [dbo].[NhaSanXuat] ([maNSX], [tenNSX], [sdt], [diaChi]) VALUES (N'NSX0016', N'Công ty dược VP', N'0938750442', N'Vĩnh phúc')
INSERT [dbo].[NhaSanXuat] ([maNSX], [tenNSX], [sdt], [diaChi]) VALUES (N'NSX0017', N'Công ty Mediplantex', N'0932494236', N'Hà Nội')
INSERT [dbo].[NhaSanXuat] ([maNSX], [tenNSX], [sdt], [diaChi]) VALUES (N'NSX0018', N'Viện Dược liệu', N'0937509470', N'Hà Nội')
INSERT [dbo].[NhaSanXuat] ([maNSX], [tenNSX], [sdt], [diaChi]) VALUES (N'NSX0019', N'Công ty Mediplantex', N'0935951237', N'Hà Nội')
INSERT [dbo].[NhaSanXuat] ([maNSX], [tenNSX], [sdt], [diaChi]) VALUES (N'NSX0020', N'Genentech Inc', N'0935541781', N'USA')
GO
INSERT [dbo].[TaiKhoan] ([maNV], [matKhau]) VALUES (N'NV0001    ', N'123')
INSERT [dbo].[TaiKhoan] ([maNV], [matKhau]) VALUES (N'NV0005   ', N'123')
GO
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [donVi], [loaiThuoc], [donGia], [ngaySX], [ngayHH], [maNSX], [soLuong], [ghiChu]) VALUES (N'T0001     ', N'Halothane', N'Viên      ', N'thuốc ức chế', 12000.0000, CAST(N'2019-01-02' AS Date), CAST(N'2022-01-02' AS Date), N'NSX0003', 34, N'không sử dụng cho trẻ em, phụ nữ co thai')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [donVi], [loaiThuoc], [donGia], [ngaySX], [ngayHH], [maNSX], [soLuong], [ghiChu]) VALUES (N'T0002     ', N'Amoxicillin', N'Viên      ', N'thuốc kháng sinh', 13000.0000, CAST(N'2019-01-02' AS Date), CAST(N'2020-03-05' AS Date), N'NSX0010', 365, N'không sử dụng cho trẻ em, phụ nữ co thai')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [donVi], [loaiThuoc], [donGia], [ngaySX], [ngayHH], [maNSX], [soLuong], [ghiChu]) VALUES (N'T0003     ', N'Cefixime ', N'Viên      ', N'thuốc kháng sinh', 14000.0000, CAST(N'2019-01-02' AS Date), CAST(N'2029-01-02' AS Date), N'NSX0019', 344, N'không sử dụng cho trẻ em, phụ nữ co thai')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [donVi], [loaiThuoc], [donGia], [ngaySX], [ngayHH], [maNSX], [soLuong], [ghiChu]) VALUES (N'T0004     ', N'Cefpodoxime', N'Viên      ', N'thuốc kháng sinh', 15000.0000, CAST(N'2019-01-02' AS Date), CAST(N'2021-01-02' AS Date), N'NSX0002', 56, N'không sử dụng cho trẻ em, phụ nữ co thai')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [donVi], [loaiThuoc], [donGia], [ngaySX], [ngayHH], [maNSX], [soLuong], [ghiChu]) VALUES (N'T0005     ', N'Azithromycin', N'Viên      ', N'thuốc kháng sinh', 16000.0000, CAST(N'2019-01-02' AS Date), CAST(N'2021-01-02' AS Date), N'NSX0012', 56, N'không sử dụng cho trẻ em, phụ nữ co thai')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [donVi], [loaiThuoc], [donGia], [ngaySX], [ngayHH], [maNSX], [soLuong], [ghiChu]) VALUES (N'T0006     ', N'Terpin codein ', N'Viên      ', N'thuốc ho', 17000.0000, CAST(N'2019-01-02' AS Date), CAST(N'2023-01-02' AS Date), N'NSX0015', 7, N' Không dùng bệnh nhân có hoặc nghi ngờ liệt ruột.')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [donVi], [loaiThuoc], [donGia], [ngaySX], [ngayHH], [maNSX], [soLuong], [ghiChu]) VALUES (N'T0007     ', N'Neocodion', N'Viên      ', N'thuốc ho', 112000.0000, CAST(N'2019-01-02' AS Date), CAST(N'2023-01-02' AS Date), N'NSX0020', 34, N'không dung vưới bệnh nhân mẫn cảm với codeine')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [donVi], [loaiThuoc], [donGia], [ngaySX], [ngayHH], [maNSX], [soLuong], [ghiChu]) VALUES (N'T0008     ', N'Terpin Zoat', N'Viên      ', N'thuốc ho', 23000.0000, CAST(N'2019-01-02' AS Date), CAST(N'2025-01-02' AS Date), N'NSX0009', 77, N'khôn dùng bệnh nhân suy hô hấp.')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [donVi], [loaiThuoc], [donGia], [ngaySX], [ngayHH], [maNSX], [soLuong], [ghiChu]) VALUES (N'T0009     ', N'VITAHALO', N'viên', N'thuốc bổ', 8000.0000, CAST(N'2018-12-06' AS Date), CAST(N'2022-12-14' AS Date), N'NSX0007', 45, N'không sử dụng cho ng mẫn cảm với thành phân thuốc')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [donVi], [loaiThuoc], [donGia], [ngaySX], [ngayHH], [maNSX], [soLuong], [ghiChu]) VALUES (N'T0010     ', N'Esomeprazol', N'Viên      ', N'thuốc dạ dày', 545000.0000, CAST(N'2018-01-02' AS Date), CAST(N'2019-01-02' AS Date), N'NSX0013', 99, N'không dùng bệnh nhân dị dưng với omeprazole')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [donVi], [loaiThuoc], [donGia], [ngaySX], [ngayHH], [maNSX], [soLuong], [ghiChu]) VALUES (N'T0011     ', N'Pantoprazol ', N'Viên      ', N'thuốc dạ dày', 55000.0000, CAST(N'2015-01-02' AS Date), CAST(N'2016-01-02' AS Date), N'NSX0004', 66, N'không dùng bệnh nhân dị dưng với lansoprazole')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [donVi], [loaiThuoc], [donGia], [ngaySX], [ngayHH], [maNSX], [soLuong], [ghiChu]) VALUES (N'T0012     ', N'Men Sachaces', N'Viên      ', N'thuốc dạ dày', 55000.0000, CAST(N'2014-01-02' AS Date), CAST(N'2016-01-02' AS Date), N'NSX0005', 55, N'không dùng bệnh nhân dị dưng với pantoprazole')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [donVi], [loaiThuoc], [donGia], [ngaySX], [ngayHH], [maNSX], [soLuong], [ghiChu]) VALUES (N'T0013     ', N'Metfotmin', N'Viên      ', N'thuốc dạ dày', 77000.0000, CAST(N'2010-01-02' AS Date), CAST(N'2014-01-02' AS Date), N'NSX0014', 55, N'không dùng bệnh nhân dị dưng với rabeprazole')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [donVi], [loaiThuoc], [donGia], [ngaySX], [ngayHH], [maNSX], [soLuong], [ghiChu]) VALUES (N'T0014     ', N'Amoxicillin', N'vỉ        ', N'thuốc kháng sinh', 14000.0000, CAST(N'2019-01-02' AS Date), CAST(N'2029-01-02' AS Date), N'NSX0001', 44, N'sử dụng xa bữa ăn')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [donVi], [loaiThuoc], [donGia], [ngaySX], [ngayHH], [maNSX], [soLuong], [ghiChu]) VALUES (N'T0015     ', N'Amoni', N'vỉ        ', N'thuốc dạ dày', 20000.0000, CAST(N'2019-12-02' AS Date), CAST(N'2022-12-02' AS Date), N'NSX0016', 33, N'không dùng bệnh nhân dị ứng với thành phần thuốc')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [donVi], [loaiThuoc], [donGia], [ngaySX], [ngayHH], [maNSX], [soLuong], [ghiChu]) VALUES (N'T0016     ', N'Ginknex', N'vỉ        ', N'thuốc kháng sinh', 11000.0000, CAST(N'2019-05-09' AS Date), CAST(N'2028-12-08' AS Date), N'NSX0006', 44, N'sử dụng sau khí ăn')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [donVi], [loaiThuoc], [donGia], [ngaySX], [ngayHH], [maNSX], [soLuong], [ghiChu]) VALUES (N'T0017     ', N'Centhionin', N'vỉ        ', N'thuốc bổ', 20000.0000, CAST(N'2020-06-08' AS Date), CAST(N'2024-05-06' AS Date), N'NSX0008', 44, N'tránh sử dụng quá liều')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [donVi], [loaiThuoc], [donGia], [ngaySX], [ngayHH], [maNSX], [soLuong], [ghiChu]) VALUES (N'T0018     ', N'Hoạt huyết nhất nhất', N'vỉ        ', N'thuốc kháng sinh', 10000.0000, CAST(N'2018-04-05' AS Date), CAST(N'2030-07-09' AS Date), N'NSX0017', 33, N'sử dụng xa bữa ăn trước hoặc sau')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [donVi], [loaiThuoc], [donGia], [ngaySX], [ngayHH], [maNSX], [soLuong], [ghiChu]) VALUES (N'T0019     ', N'Centasia', N'vỉ        ', N'thuốc ho', 12000.0000, CAST(N'2019-03-01' AS Date), CAST(N'2027-01-02' AS Date), N'NSX0018', 22, N'tránh sử dụng quá liều')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [donVi], [loaiThuoc], [donGia], [ngaySX], [ngayHH], [maNSX], [soLuong], [ghiChu]) VALUES (N'T0020     ', N'Sorbitol', N'vỉ        ', N'thuốc ức chế', 14000.0000, CAST(N'2020-02-03' AS Date), CAST(N'2022-06-08' AS Date), N'NSX0011', 33, N'sử dụng 1 lần trong ngày là tối đa')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [donVi], [loaiThuoc], [donGia], [ngaySX], [ngayHH], [maNSX], [soLuong], [ghiChu]) VALUES (N'T0021     ', N'Cenditan', N'vỉ        ', N'thuốc kháng sinh', 15000.0000, CAST(N'2020-02-03' AS Date), CAST(N'2026-04-05' AS Date), N'NSX0002', 221, N'tránh xa tầm tay của trẻ nhỏ')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [donVi], [loaiThuoc], [donGia], [ngaySX], [ngayHH], [maNSX], [soLuong], [ghiChu]) VALUES (N'T0022     ', N'Chorlatcyn', N'vỉ        ', N'thuốc ho', 20000.0000, CAST(N'2020-01-02' AS Date), CAST(N'2022-08-09' AS Date), N'NSX0013', 11, N'cần phân loại chuẩn cho trẻ em và người lớn')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [donVi], [loaiThuoc], [donGia], [ngaySX], [ngayHH], [maNSX], [soLuong], [ghiChu]) VALUES (N'T0023     ', N'Guzman', N'vỉ        ', N'thuốc bổ', 10000.0000, CAST(N'2020-05-06' AS Date), CAST(N'2022-06-07' AS Date), N'NSX0020', 88, N'sử dụng vừa đủ liểu theo tiểu chuẩn')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [donVi], [loaiThuoc], [donGia], [ngaySX], [ngayHH], [maNSX], [soLuong], [ghiChu]) VALUES (N'T0024     ', N'Acemuc', N'vỉ        ', N'thuốc bổ', 10000.0000, CAST(N'2020-06-07' AS Date), CAST(N'2025-07-08' AS Date), N'NSX0009', 88, N'sử dụng vừa đủ liểu theo tiểu chuẩn')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [donVi], [loaiThuoc], [donGia], [ngaySX], [ngayHH], [maNSX], [soLuong], [ghiChu]) VALUES (N'T0025     ', N'Bisoprolol', N'vỉ        ', N'thuốc dạ dày', 10000.0000, CAST(N'2020-05-06' AS Date), CAST(N'2025-05-06' AS Date), N'NSX0007', 77, N'tránh xa vòng tay trẻ em dưới 12 tuổi')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [donVi], [loaiThuoc], [donGia], [ngaySX], [ngayHH], [maNSX], [soLuong], [ghiChu]) VALUES (N'T0026     ', N'Bormhexin', N'vỉ        ', N'thuốc dạ dày', 10000.0000, CAST(N'2020-01-02' AS Date), CAST(N'2025-05-06' AS Date), N'NSX0011', 37, N'sử dụng theo lời bác sĩ')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [donVi], [loaiThuoc], [donGia], [ngaySX], [ngayHH], [maNSX], [soLuong], [ghiChu]) VALUES (N'T0027     ', N'Piroxocam', N'vỉ        ', N'thuốc tiếu hóa', 20000.0000, CAST(N'2020-03-04' AS Date), CAST(N'2025-01-02' AS Date), N'NSX0001', 59, N'sử dụng đúng liều lượng theo lời bá sĩ')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [donVi], [loaiThuoc], [donGia], [ngaySX], [ngayHH], [maNSX], [soLuong], [ghiChu]) VALUES (N'T0028     ', N'Toussolene', N'vỉ        ', N'thuốc tiếu hóa', 10000.0000, CAST(N'2020-04-07' AS Date), CAST(N'2025-06-07' AS Date), N'NSX0004', 78, N'tác dụng phụ: buồn nôn, khó chiu ở dạ dày')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [donVi], [loaiThuoc], [donGia], [ngaySX], [ngayHH], [maNSX], [soLuong], [ghiChu]) VALUES (N'T0029     ', N'Dogwazin', N'vỉ        ', N'thuốc tiếu hóa', 10000.0000, CAST(N'2019-04-05' AS Date), CAST(N'2025-05-06' AS Date), N'NSX0015', 106, N'sử dụng cẩn thận co trẻ em')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [donVi], [loaiThuoc], [donGia], [ngaySX], [ngayHH], [maNSX], [soLuong], [ghiChu]) VALUES (N'T0030     ', N'Vitamin PP', N'vỉ        ', N'thuốc bổ', 12000.0000, CAST(N'2019-06-07' AS Date), CAST(N'2026-04-05' AS Date), N'NSX0008', 78, N'sử dụng đúng liểu lượng theo hướng dẫn')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [donVi], [loaiThuoc], [donGia], [ngaySX], [ngayHH], [maNSX], [soLuong], [ghiChu]) VALUES (N'T0031     ', N'Ibuparavic', N'vỉ        ', N'thuốc bổ', 20000.0000, CAST(N'2019-06-07' AS Date), CAST(N'2027-03-04' AS Date), N'NSX0002', 9, N'bảo quản nơi khô ráo tránh làm hư thuốc')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [donVi], [loaiThuoc], [donGia], [ngaySX], [ngayHH], [maNSX], [soLuong], [ghiChu]) VALUES (N'T0032     ', N'Aryzaltec', N'vỉ        ', N'thuốc ức chế', 13000.0000, CAST(N'2019-04-05' AS Date), CAST(N'2026-05-06' AS Date), N'NSX0016', 43, N'sử dụng theo liều theo lời bác sĩ')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [donVi], [loaiThuoc], [donGia], [ngaySX], [ngayHH], [maNSX], [soLuong], [ghiChu]) VALUES (N'T0033     ', N'Cetirizin', N'vỉ        ', N'thuốc cảm', 14000.0000, CAST(N'2019-03-04' AS Date), CAST(N'2025-08-09' AS Date), N'NSX0007', 9, N'tránh xa vòng tay của trẻ em cưới 5 tuổi')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [donVi], [loaiThuoc], [donGia], [ngaySX], [ngayHH], [maNSX], [soLuong], [ghiChu]) VALUES (N'T0034     ', N'Bromhexin', N'vỉ        ', N'thuốc dạ dày', 15000.0000, CAST(N'2019-04-05' AS Date), CAST(N'2015-03-04' AS Date), N'NSX0019', 22, N'tránh xa vòng tay của trẻ em dưới 12 tuổi')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [donVi], [loaiThuoc], [donGia], [ngaySX], [ngayHH], [maNSX], [soLuong], [ghiChu]) VALUES (N'T0035     ', N'Calcium', N'vỉ        ', N'thuốc ức chế', 15000.0000, CAST(N'2019-04-09' AS Date), CAST(N'2025-05-06' AS Date), N'NSX0003', 45, N'chú ý khi sử dụng thuốc')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [donVi], [loaiThuoc], [donGia], [ngaySX], [ngayHH], [maNSX], [soLuong], [ghiChu]) VALUES (N'T0036     ', N'Terpin Benzoat', N'vỉ        ', N'thuốc cảm', 13000.0000, CAST(N'2020-01-02' AS Date), CAST(N'2030-06-07' AS Date), N'NSX0013', 35, N'sử dụng đủ liều lượng 1 ngày')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [donVi], [loaiThuoc], [donGia], [ngaySX], [ngayHH], [maNSX], [soLuong], [ghiChu]) VALUES (N'T0037     ', N'Kizemit', N'vỉ        ', N'thuốc cảm', 13000.0000, CAST(N'2020-05-06' AS Date), CAST(N'2025-05-06' AS Date), N'NSX0007', 56, N'không dùng cho người mẫn cảm với thành phần thuốc')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [donVi], [loaiThuoc], [donGia], [ngaySX], [ngayHH], [maNSX], [soLuong], [ghiChu]) VALUES (N'T0038     ', N'Ipalzac', N'vỉ        ', N'thuốc kháng sinh', 12000.0000, CAST(N'2020-08-09' AS Date), CAST(N'2025-05-06' AS Date), N'NSX0014', 23, N'sử dụng chú ý các tác dụng phụ có thể xảy ra')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [donVi], [loaiThuoc], [donGia], [ngaySX], [ngayHH], [maNSX], [soLuong], [ghiChu]) VALUES (N'T0039     ', N'Barasitamon', N'vỉ        ', N'thuốc ngủ', 12000.0000, CAST(N'2020-06-07' AS Date), CAST(N'2030-06-07' AS Date), N'NSX0006', 28, N'uống không quá 2 viên 1 ngày')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [donVi], [loaiThuoc], [donGia], [ngaySX], [ngayHH], [maNSX], [soLuong], [ghiChu]) VALUES (N'T0040     ', N'Taginyl', N'vỉ        ', N'thuốc trừ sâu', 12000.0000, CAST(N'2020-07-08' AS Date), CAST(N'2030-05-06' AS Date), N'NSX0003', 15, N'chú ý chỉ sử dụng trên thực vận')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [donVi], [loaiThuoc], [donGia], [ngaySX], [ngayHH], [maNSX], [soLuong], [ghiChu]) VALUES (N'T0041     ', N'Phosphalugel', N'hộp       ', N'thuốc dạ dày', 23000.0000, CAST(N'2019-12-12' AS Date), CAST(N'2022-12-08' AS Date), N'NSX0016', 57, N'sử dụng tối đa 6 gói 1 ngày(người lớn)')
GO
ALTER TABLE [dbo].[CT_HoaDon]  WITH CHECK ADD  CONSTRAINT [fk_CT_HoaDon] FOREIGN KEY([maHD])
REFERENCES [dbo].[HoaDon] ([maHD])
GO
ALTER TABLE [dbo].[CT_HoaDon] CHECK CONSTRAINT [fk_CT_HoaDon]
GO
ALTER TABLE [dbo].[CT_HoaDon]  WITH CHECK ADD  CONSTRAINT [fk2_CT_HoaDon] FOREIGN KEY([maThuoc])
REFERENCES [dbo].[Thuoc] ([maThuoc])
GO
ALTER TABLE [dbo].[CT_HoaDon] CHECK CONSTRAINT [fk2_CT_HoaDon]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [fk_HoaDon] FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNV])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [fk_HoaDon]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [fk2_HoaDon] FOREIGN KEY([maBN])
REFERENCES [dbo].[BenhNhan] ([maBN])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [fk2_HoaDon]
GO
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD  CONSTRAINT [fk_TaiKhoan] FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNV])
GO
ALTER TABLE [dbo].[TaiKhoan] CHECK CONSTRAINT [fk_TaiKhoan]
GO
ALTER TABLE [dbo].[Thuoc]  WITH CHECK ADD  CONSTRAINT [fk_Thuoc] FOREIGN KEY([maNSX])
REFERENCES [dbo].[NhaSanXuat] ([maNSX])
GO
ALTER TABLE [dbo].[Thuoc] CHECK CONSTRAINT [fk_Thuoc]
GO
