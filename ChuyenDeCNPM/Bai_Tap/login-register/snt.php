<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Xây dựng hàm để kiểm tra một số có là số nguyên tố hay không</h1>
    <form action="snt.php" method="POST">
        <input type="number" name="num">
        <input type="submit" value="Click">
    </form>

    <?php
    include("giai.php");
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $num = $_POST["num"];
    
        if ($num != "") {
            snt($num);
        }
    }
    ?>
</body>
</html>