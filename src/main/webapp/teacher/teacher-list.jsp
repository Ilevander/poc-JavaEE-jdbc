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
            <a href="https://www.javaguides.net" class="navbar-brand">School Management POC</a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list" class="nav-link" style="color: #FFC700;">Teachers</a></li>
        </ul>

        <ul class="navbar-nav navbar-collapse justify-content-end">
            <li><a href="<%=request.getContextPath()%>/logout" class="nav-link" style="color: #FFC700;">Logout</a></li>
        </ul>
    </nav>
</header>


<div class="row">
    <div class="container">
        <h3 class="text-center" style="color: #007F73;">List of Teachers</h3>
        <hr style="border-color: #4CCD99;">
        <div class="container text-left">
            <a href="<%=request.getContextPath()%>/new" class="btn btn-success" style="background-color: #FFC700; border-color: #007F73; color: #007F73;">Add Teacher</a>
        </div>
        <br>
        <table class="table table-bordered" style="border-color: #4CCD99;">
            <thead>
                <tr style="background-color: #4CCD99; color: #FFF455;">
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Subject</th>
                    <th>Email</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="teacher" items="${listTeachers}">
                    <tr>
                        <td style="color: #007F73;"><c:out value="${teacher.firstName}" /></td>
                        <td style="color: #007F73;"><c:out value="${teacher.lastName}" /></td>
                        <td style="color: #007F73;"><c:out value="${teacher.subject}" /></td>
                        <td style="color: #007F73;"><c:out value="${teacher.email}" /></td>
                        <td>
                            <a href="edit?id=<c:out value='${teacher.id}' />" class="btn btn-warning" style="background-color: #FFC700; border-color: #007F73; color: #007F73;">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="delete?id=<c:out value='${teacher.id}' />" class="btn btn-danger" style="background-color: #FFF455; border-color: #007F73; color: #007F73;">Delete</a>

                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>


<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>
