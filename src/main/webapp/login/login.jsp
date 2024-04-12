<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Login Form</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        body {
            background-color: #4CCD99; /* Light green background */
        }

        .container {
            margin-top: 50px; /* Space from the top */
            background-color: #FFF455; /* Light yellow background */
            padding: 20px;
            border-radius: 10px;
        }

        h1 {
            color: #007F73; /* Dark green text color */
            text-align: center;
            margin-bottom: 30px; /* Space after the heading */
        }

        label {
            color: #007F73; /* Dark green label text color */
        }

        .form-control {
            border-color: #007F73; /* Dark green border for form inputs */
        }

        .btn-primary {
            background-color: #FFC700; /* Yellow button color */
            border-color: #FFC700; /* Yellow button border color */
        }
    </style>
</head>

<body>

    <jsp:include page="../common/header.jsp"></jsp:include>
    <div class="container col-md-8 col-md-offset-3">
        <h1>Login Form</h1>
        <form action="<%=request.getContextPath()%>/login" method="post">

            <div class="form-group">
                <label for="username">User Name:</label>
                <input type="text" class="form-control" id="username" placeholder="User Name" name="username" required>
            </div>

            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" class="form-control" id="password" placeholder="Password" name="password" required>
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
    <jsp:include page="../common/footer.jsp"></jsp:include>
</body>

</html>
