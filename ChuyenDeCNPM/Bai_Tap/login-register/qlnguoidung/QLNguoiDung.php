<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        table {
            margin-top: 20px;
        }
    </style>
</head>

<body>
    <div class="container">
        <h1 class="mt-5">DANH SÁCH SINH VIÊN</h1>
        <a href="form.php" class="btn btn-primary mb-3">Tạo mới sinh viên</a>

        <?php
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

        $query = "SELECT * FROM users";
        $result = $connect->query($query);

        if ($result->num_rows > 0) {
            $results_per_page = 3; // Đổi số bản ghi trên mỗi trang tại đây
            $total_results = $result->num_rows;
            $total_pages = ceil($total_results / $results_per_page);

            $current_page = isset($_GET['page']) ? $_GET['page'] : 1;
            $offset = ($current_page - 1) * $results_per_page;

            $query = "SELECT * FROM users LIMIT $results_per_page OFFSET $offset";
            $result = $connect->query($query);

            // ... (Hiển thị bảng dữ liệu)
            $str = "<table class='table table-bordered table-striped'>
                    <thead>
                        <tr>
                            <th>Username</th>
                            <th>Password</th>
                            <th>Fullname</th>
                            <th>Email</th>
                            <th>Sex</th>
                            <th>Birthday</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>";

            while ($row = mysqli_fetch_assoc($result)) {
                $str .= "<tr>";
                $str .= "<td>" . $row['username'] . "</td>";
                $str .= "<td>" . $row['password'] . "</td>";
                $str .= "<td>" . $row['fullname'] . "</td>";
                $str .= "<td>" . $row['email'] . "</td>";
                $str .= "<td>" . $row['sex'] . "</td>";
                $str .= "<td>" . $row['birthday'] . "</td>";
                $str .= "<td><a class='btn btn-primary' href='crud.php?name=edit&value=" . $row['username'] . "'>Edit</a></td>";
                $str .= "<td><a class='btn btn-danger' href='crud.php?name=delete&value=" . $row['username'] . "'>Delete</a></td>";
                $str .= "</tr>";
            }

            $str .= "</tbody></table>";
            echo $str;

            // Tạo các liên kết phân trang
            echo "<nav aria-label='Page navigation'>
                    <ul class='pagination justify-content-center'>";

            if ($current_page > 1) {
                echo "<li class='page-item'><a class='page-link' href='?page=" . ($current_page - 1) . "' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>";
            }

            for ($i = 1; $i <= $total_pages; $i++) {
                if ($i == $current_page) {
                    echo "<li class='page-item active'><span class='page-link'>$i<span class='sr-only'>(current)</span></span></li>";
                } else {
                    echo "<li class='page-item'><a class='page-link' href='?page=$i'>$i</a></li>";
                }
            }

            if ($current_page < $total_pages) {
                echo "<li class='page-item'><a class='page-link' href='?page=" . ($current_page + 1) . "' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>";
            }

            echo "</ul></nav>";
        } else {
            echo "<div class='alert alert-info mt-4'>Không có dữ liệu</div>";
        }

        mysqli_close($connect);

        ?>
</body>

<script>

</script>

</html>