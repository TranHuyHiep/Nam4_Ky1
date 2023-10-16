<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

</head>

<body>
    <?php

    require_once("SinhVienIT.php");

    $list = [];
    $list[0] = new SinhVienIT("1", "Hiep", "Nam", "Ha Giang", 10, 10);
    $list[1] = new SinhVienIT("2", "Hao", "Gay", "Bac Giang", 10, 5);
    $list[2] = new SinhVienIT("3", "Duc", "Nu", "Nam Dinh", 10, 3);
    $list[3] = new SinhVienIT("4", "Thuong", "Gay", "Ha Noi", 8, 10);
    $list[4] = new SinhVienIT("5", "Loc", "Nam", "Lao Cai", 8, 10);

    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $hoTen = $_POST["hoTen"];
        $gioiTinh = $_POST["gioiTinh"];
        $diaChi = $_POST["diaChi"];
        $php = $_POST["php"];
        $java = $_POST["java"];

        if ($hoTen != "" && $gioiTinh != "" && $diaChi != "" && $php != "" && $java != "") {
            $list[count($list)] = new SinhVienIT(count($list) + 1, $hoTen, $gioiTinh, $diaChi, $php, $java);
        }
    }
    $str = "<table border='1' style='padding: 5px; font-size: 20px;'>";
    $str .= "<tr style='background-color: yellow;'>
                <th style='padding: 10px;'>Mã Sinh Viên</th>
                <th style='padding: 10px;'>Họ Tên</th>
                <th style='padding: 10px;'>Giới Tính</th>
                <th style='padding: 10px;'>Địa chỉ</th>
                <th style='padding: 10px;'>Điểm PHP</th>
                <th style='padding: 10px;'>Điểm Java</th>
                <th style='padding: 10px;'>Điểm Trung Bình</th>
                <th style='padding: 10px;'>Xếp loại</th>
            </tr>";
    for ($i = 0; $i < count($list); $i++) {
        $str .= "<tr>";
        $str .= "<td style='padding: 10px; text-align: center;'>" . $list[$i]->getMaSinhVien() . "</td>";
        $str .= "<td style='padding: 5px;'>" . $list[$i]->getHoTen() . "</td>";
        $str .= "<td style='padding: 5px;'>" . $list[$i]->getGioiTinh() . "</td>";
        $str .= "<td style='padding: 5px;'>" . $list[$i]->getDiaChi() . "</td>";
        $str .= "<td style='padding: 5px; text-align: center;'>" . $list[$i]->getPhp() . "</td>";
        $str .= "<td style='padding: 5px; text-align: center;'>" . $list[$i]->getJava() . "</td>";
        $str .= "<td style='padding: 5px; text-align: center;'>" . $list[$i]->tinhDiemTrungBinh() . "</td>";
        $str .= "<td style='padding: 5px; text-align: center;'>" . $list[$i]->xepLoai() . "</td>";
        $str .= "</tr>";
    }
    $str .= "</table>";
    echo $str;
    ?>

    <form action="QLSinhVien.php" method="POST">
        <table>
            <tr>
                <td>
                    <h3>Họ tên</h3>
                </td>
                <td>
                    <input type="text" name="hoTen">
                </td>
            </tr>
            <tr>
                <td>
                    <h3>Giới Tính</h3>
                </td>
                <td>
                    <input type="text" name="gioiTinh">
                </td>
            </tr>
            <tr>
                <td>
                    <h3>Địa chỉ</h3>
                </td>
                <td>
                    <input type="text" name="diaChi">
                </td>
            </tr>
            <tr>
                <td>
                    <h3>Điểm Php</h3>
                </td>
                <td>
                    <input type="text" name="php">
                </td>
            </tr>
            <tr>
                <td>
                    <h3>Điểm java</h3>
                </td>
                <td>
                    <input type="text" name="java">
                </td>
            </tr>
        </table>
        <input type="submit" value="Confirm">
    </form>

</body>

</html>