CREATE DATABASE  IF NOT EXISTS `qlcafe` /*!40100 DEFAULT CHARACTER SET utf8mb3 COLLATE utf8mb3_bin */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `qlcafe`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: qlcafe
-- ------------------------------------------------------
-- Server version	8.2.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `hangsanxuat`
--

DROP TABLE IF EXISTS `hangsanxuat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hangsanxuat` (
  `MaHangSanXuat` int NOT NULL AUTO_INCREMENT,
  `TenHangSanXuat` varchar(55) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`MaHangSanXuat`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hangsanxuat`
--

LOCK TABLES `hangsanxuat` WRITE;
/*!40000 ALTER TABLE `hangsanxuat` DISABLE KEYS */;
INSERT INTO `hangsanxuat` VALUES (1,'Apple'),(2,'Samsung'),(3,'Oppo'),(4,'Xiaomi'),(5,'áss'),(6,'Thứ khác'),(14,'Đồ ăn nhanh'),(15,'Realme'),(16,'Vivo'),(17,'Vsmart'),(18,'Mobell'),(19,'Itell'),(22,'hu'),(23,'sad'),(25,'sss'),(26,'sssss');
/*!40000 ALTER TABLE `hangsanxuat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khoanggia`
--

DROP TABLE IF EXISTS `khoanggia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khoanggia` (
  `MaKhoangGia` int NOT NULL AUTO_INCREMENT,
  `TenKhoangGia` varchar(55) COLLATE utf8mb3_unicode_ci NOT NULL,
  PRIMARY KEY (`MaKhoangGia`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khoanggia`
--

LOCK TABLES `khoanggia` WRITE;
/*!40000 ALTER TABLE `khoanggia` DISABLE KEYS */;
INSERT INTO `khoanggia` VALUES (1,'Dưới 2 triệu'),(2,'Từ 2 - 4 triệu'),(3,'Từ 4 - 7 triệu'),(4,'Từ 7 - 13 triệu'),(5,'Từ 13 - 20 triệu'),(6,'Từ 20 - 30 triệu'),(7,'Trên 30 triệu'),(8,'Trên 35');
/*!40000 ALTER TABLE `khoanggia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kieudang`
--

DROP TABLE IF EXISTS `kieudang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kieudang` (
  `MaKieuDang` int NOT NULL AUTO_INCREMENT,
  `TenKieuDang` varchar(55) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  PRIMARY KEY (`MaKieuDang`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kieudang`
--

LOCK TABLES `kieudang` WRITE;
/*!40000 ALTER TABLE `kieudang` DISABLE KEYS */;
INSERT INTO `kieudang` VALUES (1,'Viên thuốc'),(2,'Giọt nước'),(3,'Tai thỏ'),(4,'Tràn viền'),(5,'Ẩn camera'),(6,'Gập'),(7,'Chấm tròn'),(8,'Cổ điển'),(9,'Xoay camera');
/*!40000 ALTER TABLE `kieudang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mausac`
--

DROP TABLE IF EXISTS `mausac`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mausac` (
  `MaMauSac` int NOT NULL AUTO_INCREMENT,
  `TenMauSac` varchar(55) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  PRIMARY KEY (`MaMauSac`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mausac`
--

LOCK TABLES `mausac` WRITE;
/*!40000 ALTER TABLE `mausac` DISABLE KEYS */;
INSERT INTO `mausac` VALUES (0,'Cam'),(1,'Trắng'),(2,'Đen'),(3,'Vàng'),(4,'Đỏ'),(5,'Tím'),(6,'Xanh Dương'),(7,'Xanh Lá'),(9,'Kem'),(11,'Vàng đồng'),(12,'Xanh rêu'),(13,'Hồng');
/*!40000 ALTER TABLE `mausac` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nghenghiep`
--

DROP TABLE IF EXISTS `nghenghiep`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nghenghiep` (
  `MaNgheNghiep` int NOT NULL AUTO_INCREMENT,
  `TenNgheNGhiep` varchar(55) COLLATE utf8mb3_unicode_ci NOT NULL,
  PRIMARY KEY (`MaNgheNghiep`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nghenghiep`
--

LOCK TABLES `nghenghiep` WRITE;
/*!40000 ALTER TABLE `nghenghiep` DISABLE KEYS */;
INSERT INTO `nghenghiep` VALUES (1,'Học sinh, sinh viên'),(2,'Công nhân'),(3,'Văn Phòng'),(4,'Lập trình viên'),(5,'Streamer'),(6,'Gamer'),(7,'Phượt thủ'),(8,'Nhiếp ảnh gia'),(9,'Nội trợ');
/*!40000 ALTER TABLE `nghenghiep` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sanpham`
--

DROP TABLE IF EXISTS `sanpham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sanpham` (
  `MaSanPham` int NOT NULL AUTO_INCREMENT,
  `TenSanPham` varchar(55) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `MaHangSanXuat` int NOT NULL,
  `MaKieuDang` int NOT NULL,
  `MaMauSac` int NOT NULL,
  `MaTinhNang` int NOT NULL,
  `MaKhoangGia` int NOT NULL,
  `DonGia` int NOT NULL,
  `DVT` varchar(55) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  PRIMARY KEY (`MaSanPham`),
  KEY `sanpham_ibfk_1_idx` (`MaHangSanXuat`) /*!80000 INVISIBLE */,
  KEY `sanpham_ibfk_3_idx` (`MaMauSac`),
  KEY `sanpham_ibfk_4_idx` (`MaKieuDang`),
  KEY `sanpham_ibfk_5_idx` (`MaKhoangGia`),
  KEY `sanpham_ibfk_2_idx` (`MaTinhNang`) /*!80000 INVISIBLE */
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sanpham`
--

LOCK TABLES `sanpham` WRITE;
/*!40000 ALTER TABLE `sanpham` DISABLE KEYS */;
INSERT INTO `sanpham` VALUES (1,'Iphone 15 Pro Max',1,1,8,6,7,33900000,'Cái'),(2,'Oppo Find N3 5G',3,6,11,1,7,44990000,'Cái'),(3,'Oppo Find N3 Flip 5G',3,6,14,1,6,22900000,'Cái'),(4,'Samsung Galaxy S23 Ultra 5G',2,8,12,5,6,23900000,'Cái'),(5,'Xiaomi 13T Pro 5G',4,1,8,6,7,33900000,'Cái'),(6,'Samsung Galaxy Z Fold 5 5G',2,6,1,1,7,36900000,'Cái'),(7,'Samsung Galaxy Z Fold 4 5G',2,6,2,1,6,22900000,'Cái'),(8,'Iphone 14 Pro Max',1,1,5,5,6,27490000,'Cái'),(9,'Oppo Reno10 Pro+ 5G',3,8,5,2,5,19900000,'Cái'),(10,'Iphone XR',1,3,4,7,4,7000000,'Cái'),(11,'Iphone 11 Pro Max',1,3,13,7,4,10900000,'Cái'),(12,'LG V30',6,4,2,7,2,3900000,'Cái'),(13,'Sony Xperia 10',7,1,8,6,7,33900000,'Cái'),(14,'Sony Xperia 5',7,1,8,6,7,33900000,'Cái'),(15,'LG V50 ThinQ',6,1,8,6,7,33900000,'Cái'),(16,'Itel L6502',13,1,8,6,7,33900000,'Cái'),(17,'Itel it9010',13,1,8,6,7,33900000,'Cái'),(18,'Nokia 1280',8,1,8,6,7,33900000,'Cái'),(19,'Nokia C5',8,1,8,6,7,33900000,'Cái'),(20,'Mobel Rock 4 4G',12,1,8,6,7,33900000,'Cái'),(21,'Mobel F309 4G',12,1,8,6,7,33900000,'Cái'),(22,'Masstel FAMI 60 4G',14,1,8,6,7,33900000,'Cái'),(23,'Masstel Lux 20',14,1,8,6,7,33900000,'Cái'),(24,'Vsmart Active 3',11,1,8,6,7,33900000,'Cái'),(25,'Vsmart Live',11,1,8,6,7,33900000,'Cái'),(26,'Vivo Y17s',10,1,8,6,7,33900000,'Cái'),(27,'Vivo V25E',10,1,8,6,7,33900000,'Cái'),(28,'Realme C53',9,1,8,6,7,33900000,'Cái'),(29,'Realme 11 Pro+ 5G',9,1,8,6,7,33900000,'Cái'),(30,'Vivo V29 5G',10,1,8,6,7,33900000,'Cái'),(31,'Vivo Y02T',10,1,8,6,7,33900000,'Cái'),(32,'Iphone 13',1,1,8,6,7,33900000,'Cái'),(33,'Iphone XS Max',1,1,8,6,7,33900000,'Cái'),(34,'SamSung Galaxy A05',2,1,8,6,7,33900000,'Cái'),(35,'Asus ROG Phone 6',15,1,8,6,7,33900000,'Cái'),(36,'Asus ROG Phone 7 Ultimate',15,1,8,6,7,33900000,'Cái'),(37,'Xiaomi Redmi K20 Pro',4,1,8,6,7,33900000,'Cái'),(38,'Xiaomi Redmi K50',4,1,8,6,7,33900000,'Cái'),(39,'Oppo A53',3,1,8,6,7,33900000,'Cái');
/*!40000 ALTER TABLE `sanpham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sothich`
--

DROP TABLE IF EXISTS `sothich`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sothich` (
  `MaSoThich` int NOT NULL AUTO_INCREMENT,
  `TenSoThich` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  PRIMARY KEY (`MaSoThich`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sothich`
--

LOCK TABLES `sothich` WRITE;
/*!40000 ALTER TABLE `sothich` DISABLE KEYS */;
INSERT INTO `sothich` VALUES (1,'Du lịch'),(2,'Chơi game'),(3,'Đọc tin tức'),(4,'Nghe nhạc'),(5,'Công nghệ');
/*!40000 ALTER TABLE `sothich` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taikhoan`
--

DROP TABLE IF EXISTS `taikhoan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `taikhoan` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_vietnamese_ci NOT NULL,
  `password` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_vietnamese_ci NOT NULL,
  `lv` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taikhoan`
--

LOCK TABLES `taikhoan` WRITE;
/*!40000 ALTER TABLE `taikhoan` DISABLE KEYS */;
INSERT INTO `taikhoan` VALUES (6,'long','1',1),(7,'nhanvien','1',2),(10,'nhanvien2','1',2),(11,'admin','1',1),(12,'long1','1',2);
/*!40000 ALTER TABLE `taikhoan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tinhnang`
--

DROP TABLE IF EXISTS `tinhnang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tinhnang` (
  `MaTinhNang` int NOT NULL AUTO_INCREMENT,
  `TenTinhNang` varchar(55) COLLATE utf8mb3_unicode_ci NOT NULL,
  PRIMARY KEY (`MaTinhNang`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `nghenghiep_sothich`;
CREATE TABLE `qlcafe`.`nghenghiep_sothich` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_nghenghiep` INT NULL,
  `id_sothich` INT NULL,
  FOREIGN KEY (id_nghenghiep) REFERENCES nghenghiep(MaNgheNghiep),
  FOREIGN KEY (id_sothich) REFERENCES sothich(MaSoThich),

  PRIMARY KEY (`id`));
  
INSERT INTO `qlcafe`.`nghenghiep_sothich` (`id`, `id_nghenghiep`, `id_sothich`) VALUES ('1', '1', '1');
INSERT INTO `qlcafe`.`nghenghiep_sothich` (`id`, `id_nghenghiep`, `id_sothich`) VALUES ('2', '1', '2');
INSERT INTO `qlcafe`.`nghenghiep_sothich` (`id`, `id_nghenghiep`, `id_sothich`) VALUES ('3', '2', '3');
INSERT INTO `qlcafe`.`nghenghiep_sothich` (`id`, `id_nghenghiep`, `id_sothich`) VALUES ('4', '4', '5');
INSERT INTO `qlcafe`.`nghenghiep_sothich` (`id`, `id_nghenghiep`, `id_sothich`) VALUES ('5', '1', '5');


ALTER TABLE sanpham
ADD COLUMN id_nghenghiep_sothich INT,
ADD FOREIGN KEY (id_nghenghiep_sothich) REFERENCES nghenghiep_sothich(id);


UPDATE `qlcafe`.`sanpham` SET `id_nghenghiep_sothich` = '1' WHERE (`MaSanPham` = '1');
UPDATE `qlcafe`.`sanpham` SET `id_nghenghiep_sothich` = '2' WHERE (`MaSanPham` = '2');
UPDATE `qlcafe`.`sanpham` SET `id_nghenghiep_sothich` = '3' WHERE (`MaSanPham` = '3');
UPDATE `qlcafe`.`sanpham` SET `id_nghenghiep_sothich` = '4' WHERE (`MaSanPham` = '4');
UPDATE `qlcafe`.`sanpham` SET `id_nghenghiep_sothich` = '5' WHERE (`MaSanPham` = '5');
UPDATE `qlcafe`.`sanpham` SET `id_nghenghiep_sothich` = '1' WHERE (`MaSanPham` = '6');
UPDATE `qlcafe`.`sanpham` SET `id_nghenghiep_sothich` = '2' WHERE (`MaSanPham` = '7');
UPDATE `qlcafe`.`sanpham` SET `id_nghenghiep_sothich` = '3' WHERE (`MaSanPham` = '8');
UPDATE `qlcafe`.`sanpham` SET `id_nghenghiep_sothich` = '4' WHERE (`MaSanPham` = '9');
UPDATE `qlcafe`.`sanpham` SET `id_nghenghiep_sothich` = '5' WHERE (`MaSanPham` = '10');
UPDATE `qlcafe`.`sanpham` SET `id_nghenghiep_sothich` = '1' WHERE (`MaSanPham` = '11');
UPDATE `qlcafe`.`sanpham` SET `id_nghenghiep_sothich` = '2' WHERE (`MaSanPham` = '12');
UPDATE `qlcafe`.`sanpham` SET `id_nghenghiep_sothich` = '3' WHERE (`MaSanPham` = '13');
UPDATE `qlcafe`.`sanpham` SET `id_nghenghiep_sothich` = '4' WHERE (`MaSanPham` = '14');
UPDATE `qlcafe`.`sanpham` SET `id_nghenghiep_sothich` = '5' WHERE (`MaSanPham` = '15');
UPDATE `qlcafe`.`sanpham` SET `id_nghenghiep_sothich` = '1' WHERE (`MaSanPham` = '16');
UPDATE `qlcafe`.`sanpham` SET `id_nghenghiep_sothich` = '2' WHERE (`MaSanPham` = '17');
UPDATE `qlcafe`.`sanpham` SET `id_nghenghiep_sothich` = '3' WHERE (`MaSanPham` = '18');
UPDATE `qlcafe`.`sanpham` SET `id_nghenghiep_sothich` = '4' WHERE (`MaSanPham` = '19');
UPDATE `qlcafe`.`sanpham` SET `id_nghenghiep_sothich` = '5' WHERE (`MaSanPham` = '20');
UPDATE `qlcafe`.`sanpham` SET `id_nghenghiep_sothich` = '1' WHERE (`MaSanPham` = '21');
UPDATE `qlcafe`.`sanpham` SET `id_nghenghiep_sothich` = '2' WHERE (`MaSanPham` = '22');
UPDATE `qlcafe`.`sanpham` SET `id_nghenghiep_sothich` = '3' WHERE (`MaSanPham` = '23');
UPDATE `qlcafe`.`sanpham` SET `id_nghenghiep_sothich` = '4' WHERE (`MaSanPham` = '24');
UPDATE `qlcafe`.`sanpham` SET `id_nghenghiep_sothich` = '5' WHERE (`MaSanPham` = '25');
UPDATE `qlcafe`.`sanpham` SET `id_nghenghiep_sothich` = '1' WHERE (`MaSanPham` = '26');
UPDATE `qlcafe`.`sanpham` SET `id_nghenghiep_sothich` = '2' WHERE (`MaSanPham` = '27');
UPDATE `qlcafe`.`sanpham` SET `id_nghenghiep_sothich` = '3' WHERE (`MaSanPham` = '28');
UPDATE `qlcafe`.`sanpham` SET `id_nghenghiep_sothich` = '4' WHERE (`MaSanPham` = '29');
UPDATE `qlcafe`.`sanpham` SET `id_nghenghiep_sothich` = '5' WHERE (`MaSanPham` = '30');
UPDATE `qlcafe`.`sanpham` SET `id_nghenghiep_sothich` = '1' WHERE (`MaSanPham` = '31');
UPDATE `qlcafe`.`sanpham` SET `id_nghenghiep_sothich` = '2' WHERE (`MaSanPham` = '32');
UPDATE `qlcafe`.`sanpham` SET `id_nghenghiep_sothich` = '3' WHERE (`MaSanPham` = '33');
UPDATE `qlcafe`.`sanpham` SET `id_nghenghiep_sothich` = '4' WHERE (`MaSanPham` = '34');
UPDATE `qlcafe`.`sanpham` SET `id_nghenghiep_sothich` = '5' WHERE (`MaSanPham` = '35');
UPDATE `qlcafe`.`sanpham` SET `id_nghenghiep_sothich` = '1' WHERE (`MaSanPham` = '36');
UPDATE `qlcafe`.`sanpham` SET `id_nghenghiep_sothich` = '2' WHERE (`MaSanPham` = '37');
UPDATE `qlcafe`.`sanpham` SET `id_nghenghiep_sothich` = '3' WHERE (`MaSanPham` = '38');

--
-- Dumping data for table `tinhnang`
--

LOCK TABLES `tinhnang` WRITE;
/*!40000 ALTER TABLE `tinhnang` DISABLE KEYS */;
INSERT INTO `tinhnang` VALUES (1,'Chụp ảnh, quay phim'),(2,'Chơi game'),(3,'Hai sim hai sóng'),(4,'Pin khủng'),(5,'Live stream'),(6,'Mỏng nhẹ'),(7,'None');
/*!40000 ALTER TABLE `tinhnang` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-27  8:11:52
