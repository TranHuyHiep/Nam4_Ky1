<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <form action="ptb2.php" method="POST">
        <input type="number" name="a"> x^2 + <input type="number" name="b"> x + <input type="number" name="c"> = 0
        <input type="submit" value="Giải">
    </form> <br>
    <?php
    include("giai.php");
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $a = $_POST["a"];
        $b = $_POST["b"];
        $c = $_POST["c"];
        giai($a, $b, $c);
    }
    ?>
</body>

</html>