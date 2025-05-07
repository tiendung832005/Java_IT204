<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 5/6/2025
  Time: 4:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            margin: 0;
            padding: 20px;
            background-color: #f4f4f4;
        }

        .container {
            width: 80%;
            max-width: 600px;
            margin: 0 auto;
            background: white;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 5px;
        }

        h2 {
            text-align: center;
            color: #333;
        }

        .form-group {
            margin-bottom: 15px;
        }

        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        input[type="text"],
        input[type="password"],
        input[type="number"],
        textarea {
            width: 100%;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }

        .required::after {
            content: " *";
            color: red;
        }

        .btn {
            display: inline-block;
            background: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }

        .btn:hover {
            background: #45a049;
        }

        .error {
            color: red;
            font-size: 14px;
            margin-top: 5px;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Đăng ký tài khoản</h2>
    <form action="register" method="post" id="registerForm">
        <div class="form-group">
            <label for="username" class="required">Tên đăng nhập</label>
            <input type="text" id="username" name="username" required>
        </div>

        <div class="form-group">
            <label for="password" class="required">Mật khẩu</label>
            <input type="password" id="password" name="password" required>
        </div>

        <div class="form-group">
            <label for="fullname" class="required">Họ và tên</label>
            <input type="text" id="fullname" name="fullname" required>
        </div>

        <div class="form-group">
            <label for="age">Tuổi</label>
            <input type="number" id="age" name="age" min="1" max="120">
        </div>

        <div class="form-group">
            <label for="address">Địa chỉ</label>
            <textarea id="address" name="address" rows="3"></textarea>
        </div>

        <div class="form-group">
            <button type="submit" class="btn">Đăng ký</button>
        </div>
    </form>
</div>

<script>
    document.getElementById('registerForm').addEventListener('submit', function(event) {
        let valid = true;
        const username = document.getElementById('username').value.trim();
        const password = document.getElementById('password').value.trim();
        const fullname = document.getElementById('fullname').value.trim();

        // Xóa tất cả thông báo lỗi cũ
        const errorElements = document.querySelectorAll('.error');
        errorElements.forEach(el => el.remove());

        // Kiểm tra username
        if (username === '') {
            showError('username', 'Vui lòng nhập tên đăng nhập');
            valid = false;
        }

        // Kiểm tra password
        if (password === '') {
            showError('password', 'Vui lòng nhập mật khẩu');
            valid = false;
        }

        // Kiểm tra fullname
        if (fullname === '') {
            showError('fullname', 'Vui lòng nhập họ và tên');
            valid = false;
        }

        if (!valid) {
            event.preventDefault();
        }
    });

    function showError(inputId, message) {
        const input = document.getElementById(inputId);
        const errorDiv = document.createElement('div');
        errorDiv.className = 'error';
        errorDiv.innerHTML = message;
        input.parentNode.appendChild(errorDiv);
    }
</script>
</body>
</html>
