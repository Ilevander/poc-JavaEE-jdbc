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
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: #007F73;">
        <div>
            <a href="#" class="navbar-brand">School Management POC</a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list" class="nav-link" style="color: #FFC700;">Students</a></li>
        </ul>

        <ul class="navbar-nav navbar-collapse justify-content-end">
            <li><a href="<%=request.getContextPath()%>/logout" class="nav-link" style="color: #FFC700;">Logout</a></li>
        </ul>
    </nav>
</header>
<div class="container col-md-5" >
    <div class="card" style="background-color: #FFF455;">
        <div class="card-body">
            <c:if test="${student != null}">
                <form action="update" method="post">
            </c:if>
            <c:if test="${student == null}">
                <form action="insert" method="post">
            </c:if>

            <caption>
                <h2 style="color: #007F73;">
                    <c:if test="${student != null}">
                        Edit Student
                    </c:if>
                    <c:if test="${student == null}">
                        Add New Student
                    </c:if>
                </h2>
            </caption>

            <c:if test="${student != null}">
                <input type="hidden" name="id" value="<c:out value='${student.id}' />" />
            </c:if>

            <fieldset class="form-group">
                <label style="color: #007F73;">First Name</label>
                <input type="text" value="<c:out value='${student.firstName}' />" class="form-control" name="firstName" required="required" minlength="2">
            </fieldset>

            <fieldset class="form-group">
                <label style="color: #007F73;">Last Name</label>
                <input type="text" value="<c:out value='${student.lastName}' />" class="form-control" name="lastName" required="required" minlength="2">
            </fieldset>

            <fieldset class="form-group">
                <label style="color: #007F73;">Age</label>
                <input type="text" value="<c:out value='${student.age}' />" class="form-control" name="age" required="required">
            </fieldset>

            <fieldset class="form-group">
                <label style="color: #007F73;">Email</label>
                <input type="email" value="<c:out value='${student.email}' />" class="form-control" name="email" required="required">
            </fieldset>

            <fieldset class="form-group">
                <label style="color: #007F73;">Username</label>
                <input type="text" value="<c:out value='${student.username}' />" class="form-control" name="username" required="required">
            </fieldset>

            <fieldset class="form-group">
                <label style="color: #007F73;">Password</label>
                <input type="password" value="<c:out value='${student.password}' />" class="form-control" name="password" required="required">
            </fieldset>

             <button type="submit" class="btn btn-success" style="background-color: #4CCD99; border-color: #007F73; color: #007F73; display: flex; justify-content: center; align-items: center;">Save</button>

            </form>
        </div>
    </div>
</div>


<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>
