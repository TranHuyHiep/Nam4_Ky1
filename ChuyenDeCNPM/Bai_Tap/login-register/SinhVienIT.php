<?php 
require_once("SinhVien.php");

class SinhVienIT extends SinhVien {
    private $php;
    private $java;

    public function __construct($maSinhVien, $hoTen, $gioiTinh, $diaChi, $php, $java) {
        parent::__construct($maSinhVien, $hoTen, $gioiTinh, $diaChi);
        $this->php = $php;
        $this->java = $java;
    }
    
    public function getPhp() {
        return $this->php;
    }

    public function getJava() {
        return $this->java;
    }

    public function setPhp($php) {
        $this->php = $php;
    }

    public function setJava($java) {
        $this->java = $java;
    }

    public function tinhDiemTrungBinh() {
        return ($this->php + $this->java) / 2;
    }

    public function xepLoai() {
        $dtb = $this->tinhDiemTrungBinh();

        if($dtb >= 9) {
            return "Xuất sắc";
        } elseif($dtb >= 8) {
            return "Giỏi";
        } elseif($dtb > 7) {
            return "Khá";
        } else {
            return "Yếu";
        }
        
    }
}

?>