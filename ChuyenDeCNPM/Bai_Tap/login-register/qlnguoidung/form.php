<?php

$username = '';
$password = '';
$fullname = '';
$email = '';
$sex = '';
$birthday = '';

if (isset($_GET['value']) && isset($_GET['name'])) {
    if ($_GET['name'] == 'edit') {
        $value = $_GET['value'];
        $dbservername = "localhost";
        $dbusername = "root";
        $dbpassword = "";
        $dbport = "1337";
        $dbname = "cong_nghe_phan_mem";

        //cach 1: 
        //create connection
        $connect = mysqli_connect($dbservername, $dbusername, $dbpassword, $dbname);

        //check connection
        if (!$connect) {
            die("Connection failed: " . mysqli_connect_error());
        } else {
            // echo "Connected successfullly";
        }

        // Thực hiện truy vấn để lấy dữ liệu từ cơ sở dữ liệu
        $sql = "SELECT * FROM users WHERE username='$value'";
        $result = $connect->query($sql);

        if ($result->num_rows > 0) {
            $row = $result->fetch_assoc();

            // Gán dữ liệu vào biến
            $username = $row['username'];
            $password = $row['password'];
            $fullname = $row['fullname'];
            $email = $row['email'];
            $sex = $row['sex'];
            $birthday = $row['birthday'];
        } else {
            echo "Không tìm thấy bản ghi";
        }

        $connect->close();
    }
}

?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bootstrap Form</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
    <div class="container mt-5">
        <form action="crud.php" class="col-md-6 offset-md-3">
            <input type="hidden" name="name" value="<?php echo (isset($_GET['value']) && isset($_GET['name']) && $_GET['name'] == 'edit') ? 'confirmEdit' : 'create' ?>">

            <div class="form-group">
                <label for="username">Username</label>
                <input type="text" name="username" id="username" class="form-control" value="<?php echo $username; ?>" <?php if (isset($_GET['value']) && isset($_GET['name'])) echo "readonly" ?>>
            </div>

            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" name="password" id="password" class="form-control" value="<?php echo $password; ?>">
            </div>

            <div class="form-group">
                <label for="fullname">Fullname</label>
                <input type="text" name="fullname" id="fullname" class="form-control" value="<?php echo $fullname; ?>">
            </div>

            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" name="email" id="email" class="form-control" value="<?php echo $email; ?>">
            </div>

            <div class="form-group">
                <label for="sex">Sex</label>
                <input type="text" name="sex" id="sex" class="form-control" value="<?php echo $sex; ?>">
            </div>

            <div class="form-group">
                <label for="birthday">BirthDay</label>
                <input type="date" name="birthday" id="birthday" class="form-control" value="<?php echo $birthday; ?>">
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>