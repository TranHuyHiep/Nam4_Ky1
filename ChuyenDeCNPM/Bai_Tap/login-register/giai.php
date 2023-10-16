<?php
function giai($a, $b, $c) {

$denta = $b * $b - 4 * $a * $c;
if ($denta < 0) { echo "Phuong trinh vo nghiem" ; } else if ($denta==0) { echo "Phuong trinh co nghiem kep x = " . (-$c) / (2 * $a); } else { echo "Phuong trinh co 2 nghiem phan biet x1 = " . (-$b - sqrt($denta)) / (2 * $a) . " x2 = " . (-$b + sqrt($denta)) / (2 * $a); }
}

function snt($a) {
    $ketqua = $a . " Day la so nguyen to";
    for($i=2; $i < $a; $i++) {
        if($a % $i == 0) {
            echo "so chia het: " .$i. "</br>";
            $ketqua = $a . " Khong la so nguyen to";
        }
    }
    echo $ketqua;
}

?>