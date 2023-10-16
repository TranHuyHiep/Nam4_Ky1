<?php 
class SinhVien {
    private $maSinhVien;
    private $hoTen;
    private $gioiTinh;
    private $diaChi;

    public function __construct($maSinhVien, $hoTen, $gioiTinh, $diaChi)
    {
        $this->maSinhVien = $maSinhVien;
        $this->hoTen = $hoTen;
        $this->gioiTinh = $gioiTinh;
        $this->diaChi = $diaChi;
    }

    public function getMaSinhVien() {
        return $this->maSinhVien;
    }

    public function getHoTen() {
        return $this->hoTen;
    }

    public function getGioiTinh() {
        return $this->gioiTinh;
    }

    public function getDiaChi() {
        return $this->diaChi;
    }

    public function setMaSinhVien($maSinhVien) {
        $this->maSinhVien = $maSinhVien;
    }

    public function setHoTen($hoTen) {
        $this->hoTen = $hoTen;
    }

    public function setGioiTinh($gioiTinh) {
        $this->gioiTinh = $gioiTinh;
    }

    public function setDiaChi($diaChi) {
        $this->diaChi = $diaChi;
    }
}

?>