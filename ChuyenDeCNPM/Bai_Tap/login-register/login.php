<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f8f9fa;
        }

        .login-form {
            max-width: 400px;
            background-color: #fff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .form-group {
            margin-bottom: 20px;
        }

        label {
            font-weight: bold;
        }

        .btn-login {
            width: 100%;
        }
        
    </style>
</head>

<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $username = $_POST["username-login"];
    $password = $_POST["password-login"];

    if ($username != "" && $password != "") {
        if ($username === "hieptran" && $password === "123123") {
            header("Location: ptb2.php");
            exit;
        } else {
            $loginError = "Tên đăng nhập hoặc mật khẩu không đúng.";
        }
    }
}
?>

<body>
    <div class="login-form">
        <h1 class="mb-4">Login</h1>
        <form id="login-form" method="POST" action="login.php">
            <div class="form-group">
                <label for="username-login">Username</label>
                <input type="text" name="username-login" id="username-login" class="form-control" size="40">
            </div>
            <div class="form-group">
                <label for="password-login">Password</label>
                <input type="password" name="password-login" id="password-login" class="form-control" size="40">
            </div>
            <div class="form-group">
                <input type="checkbox" id="rememberme" class="form-check-input">
                <label for="rememberme" class="form-check-label">Remember Me</label>
            </div>
            <div class="form-group">
                <?php
                

                if (isset($loginError)) {
                    echo "<p style='color: red;'>$loginError</p>";
                }
                ?>
                <input type="submit" class="btn btn-primary btn-login" value="Login">
            </div>
            <div class="form-group text-right">
                Don't have an account? <a href="register.php">Register</a>
            </div>
        </form>
    </div>
</body>

</html>
