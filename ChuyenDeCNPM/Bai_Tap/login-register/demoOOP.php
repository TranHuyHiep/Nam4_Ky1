<?php
    class SinhVien {
        private $maSinhVien;
        var $hoTen;
        private $gioiTinh;

        public function __construct($maSinhVien, $hoTen, $gioiTinh = "nam") {
            $this->maSinhVien = $maSinhVien;
            $this->hoTen = $hoTen;
            $this->gioiTinh = $gioiTinh;
        }

        public function getName() {
            return $this->hoTen;
        }
        
        public function getMaSinhVien() {
            return $this->maSinhVien;
        }

        public function getGioiTinh() {
            return $this->gioiTinh;
        }

        public function thongTinSinhVien() {
            echo "Thong tin sinh vien la $this->maSinhVien - $this->hoTen - $this->gioiTinh"; 
        }
    }

    $sv = new SinhVien("333", "Duc", "nu");
    $sv->hoTen = "Tran Huy Hiep";
    $sv->thongTinSinhVien();
?>