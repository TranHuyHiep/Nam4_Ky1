<?php

    if (isset($_GET['name']) ) {
        $name = $_GET['name'];
        if ($name == 'delete') deleteName();
        if ($name == 'create') createUser();
        if ($name == 'edit') editUser();
        if ($name == 'confirmEdit') confirmEditUser();
    }


    function deleteName()
    {
        if(isset($_GET['value'])) {
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
    
            $query = "delete from users where username='" . $value . "'";
    
            $connect->query($query);
            header('Location: http://localhost:1337/login-register/qlnguoidung/qlnguoidung.php');
        }
        echo "Đã xảy ra lỗi";
    }

    function createUser() {
        if(
            isset($_GET['username']) &&
            isset($_GET['password']) &&
            isset($_GET['fullname']) &&
            isset($_GET['email']) &&
            isset($_GET['sex']) &&
            isset($_GET['birthday'])
        ) { 
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

            $username = $_GET['username'];
            $password = $_GET['password'];
            $fullname = $_GET['fullname'];
            $email = $_GET['email'];
            $sex = $_GET['sex'];
            $birthday = $_GET['birthday'];

            $query = "INSERT INTO users (username, password, fullname, email, sex, birthday) VALUES ('$username', '$password', '$fullname', '$email', '$sex', '$birthday')";
            $connect->query($query);
            header('Location: http://localhost:1337/login-register/qlnguoidung/qlnguoidung.php');
        }
        echo "Đã xảy ra lỗi";
    }

    function editUser() {
        if(isset($_GET['value'])) {
            $value = $_GET['value'];
            $url = "Location: http://localhost:1337/login-register/qlnguoidung/form.php?name=edit&value=$value";
            header($url);
        }
    }

    function confirmEditUser() {
        if(
            isset($_GET['username']) &&
            isset($_GET['password']) &&
            isset($_GET['fullname']) &&
            isset($_GET['email']) &&
            isset($_GET['sex']) &&
            isset($_GET['birthday'])
        ) { 
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

            $username = $_GET['username'];
            $password = $_GET['password'];
            $fullname = $_GET['fullname'];
            $email = $_GET['email'];
            $sex = $_GET['sex'];
            $birthday = $_GET['birthday'];

            $query = "UPDATE users SET username='$username', password='$password', fullname='$fullname', email='$email', sex='$sex', birthday='$birthday' WHERE username='$username'";
            $connect->query($query);
            header('Location: http://localhost:1337/login-register/qlnguoidung/qlnguoidung.php');
        }
        echo "Đã xảy ra lỗi";
    }
?>