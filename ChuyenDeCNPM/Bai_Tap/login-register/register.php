<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $username = $_POST["usernameRegiser"];
    $password = $_POST["passwordRegister"];


    header("Location: login.php");
}
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            background-color: #f8f9fa;
        }

        .register-form {
            max-width: 600px;
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

        .btn-register {
            width: 100%;
        }
    </style>
</head>

<body>
    <div class="register-form">
        <h1 class="mb-4">Signup for New Account</h1>
        <form id="signup-form" action="register.php" method="POST">
            <div class="form-group">
                <label for="usernameRegister">Username*</label>
                <input type="text" name="usernameRegister" id="usernameRegister" class="form-control" onchange="checkUsername()" required>
            </div>
            <div class="form-group">
                <label for="emailRegister">User Email*</label>
                <input type="email" name="emailRegister" id="emailRegister" class="form-control" onchange="checkEmail()" required>
            </div>
            <div class="form-group">
                <table>
                    <tr>
                        <td>
                            <label for="title">Select title</label>
                        </td>
                        <td colspan="2">
                            <label for="fullnameRegister">Full name*</label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <select name="title" id="title" class="form-control">
                                <option value="Mr.">Mr.</option>
                                <option value="Ms.">Ms.</option>
                            </select>
                        </td>
                        <td colspan="2">
                            <input type="text" name="fullnameRegister" id="fullnameRegister" size="42" class="form-control" onchange="checkFullName()" required>
                        </td>
                    </tr>
                </table>
            </div>
            <div class="form-group">
                <label for="passwordRegister">Password*</label>
                <input type="password" name="passwordRegister" id="passwordRegister" class="form-control" onchange="checkPassword()" required>
            </div>
            <div class="form-group">
                <label for="repasswordRegister">Repeat Password*</label>
                <input type="password" name="repasswordRegister" id="repasswordRegister" class="form-control" onchange="checkRepassword()" required>
            </div>
            <div class="form-group">
                <h3>Company detail</h3>
                <p>Provide detail about your company</p>
                <label for="companyName"><strong>Company name</strong></label>
                <input type="text" name="companyName" id="companyName" class="form-control">
            </div>
            <div class="form-group">
                <input type="checkbox" id="agree" class="form-check-input" required>
                <label for="agree" class="form-check-label">I agree with registration</label>
            </div>
            <div class="form-group">
                <input type="submit" class="btn btn-primary btn-register" value="Register" onclick="register()">
            </div>
            <div class="form-group text-right">
                Already have an account? <a href="login.php">Login</a>
            </div>
        </form>
    </div>

    <script>
        function checkUsername() {
            var username = document.getElementById("usernameRegister").value;
            var usernameRegex = /^[a-zA-Z0-9_]{4,16}$/;
            if (!usernameRegex.test(username)) {
                alert("Invalid Username! Includes only letters and numbers, with a length of 4 - 16 characters");
                return true;
            }
            return false;
        }

        function checkFullName() {
            var fullname = document.getElementById("fullnameRegister").value;
            var fullnameRegex = /^[a-zA-Z_ ]{4,36}$/;
            if (!fullnameRegex.test(fullname)) {
                alert("Ivalid Full Name!");
                return true;
            }
            return false;
        }

        function checkEmail() {
            var email = document.getElementById("emailRegister").value;
            var emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
            if (!emailRegex.test(email)) {
                alert("Ivalid Email!");
                return true;
            }
            return false;
        }

        function checkPassword() {
            var password = document.getElementById("passwordRegister").value;
            var passwordRegex = /^[a-zA-Z0-9._-]{6,30}$/;
            if (!passwordRegex.test(password)) {
                alert("Password must be longer 6 characters!");
                return true;
            }
            return false;
        }

        function checkRepassword() {
            var repassword = document.getElementById("repasswordRegister").value;
            var password = document.getElementById("passwordRegister").value;

            if (password !== repassword) {
                alert("Re-Password must be the same Password");
                return true;
            }
            return false;
        }

        function register() {
            if (checkUsername() || checkFullName() || checkEmail() || checkPassword() || checkRepassword()) {
                event.preventDefault();
            }
        }
    </script>
</body>

</html>