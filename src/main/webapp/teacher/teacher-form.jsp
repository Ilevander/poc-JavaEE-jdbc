<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>User Management Application</title>

    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">

</head>
<body>
<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
        <div>
            <a href="https://www.javaguides.net" class="navbar-brand"> School Management</a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Teachers</a></li>
        </ul>

        <ul class="navbar-nav navbar-collapse justify-content-end">
            <li><a href="<%=request.getContextPath()%>/logout" class="nav-link">Logout</a></li>
        </ul>
    </nav>
</header>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${teacher != null}">
                <form action="update" method="post">
            </c:if>
            <c:if test="${teacher == null}">
                <form action="insert" method="post">
            </c:if>

            <caption>
                <h2>
                    <c:if test="${teacher != null}">
                        Edit Teacher
                    </c:if>
                    <c:if test="${teacher == null}">
                        Add New Teacher
                    </c:if>
                </h2>
            </caption>

            <c:if test="${teacher != null}">
                <input type="hidden" name="id" value="<c:out value='${teacher.id}' />" />
            </c:if>

            <fieldset class="form-group">
                <label>First Name</label>
                <input type="text" value="<c:out value='${teacher.firstName}' />" class="form-control" name="firstName" required="required" minlength="2">
            </fieldset>

            <fieldset class="form-group">
                <label>Last Name</label>
                <input type="text" value="<c:out value='${teacher.lastName}' />" class="form-control" name="lastName" required="required" minlength="2">
            </fieldset>

            <fieldset class="form-group">
                <label>Subject</label>
                <input type="text" value="<c:out value='${teacher.subject}' />" class="form-control" name="subject" required="required">
            </fieldset>

            <fieldset class="form-group">
                <label>Email</label>
                <input type="email" value="<c:out value='${teacher.email}' />" class="form-control" name="email" required="required">
            </fieldset>

            <fieldset class="form-group">
                <label>Username</label>
                <input type="text" value="<c:out value='${teacher.username}' />" class="form-control" name="username" required="required">
            </fieldset>

            <fieldset class="form-group">
                <label>Password</label>
                <input type="password" value="<c:out value='${teacher.password}' />" class="form-control" name="password" required="required">
            </fieldset>

            <button type="submit" class="btn btn-success">Save</button>
            </form>
        </div>
    </div>
</div>

<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>
