<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <!-- Bootstrap CSS CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1>All Student</h1>

        <table class="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Department</th>
                    <th>Marks</th>
                    <th>Gender</th>
                    <th>Hobby</th>
                    <th>Date Of Birth</th>
                    
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="std" items="${stdList}">
                    <tr>
                        <td>${std.roll}</td>
                        <td>${std.name}</td>
                        <td>${std.department}</td>
                        <td>${std.marks}</td>
                        <td>${std.gender}</td>
                        <td>${std.hobby}</td>
                        <td>${std.dob}</td>
                        
                        <td>
                            <a href="/stdeditform/${std.roll}" class="btn btn-primary">Edit</a>
                            <a href="/deletestd/${std.roll}" class="btn btn-danger">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <a href="/stdsaveform" class="btn btn-success">Add Student</a>
    </div>

    <!-- Bootstrap JS CDN -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
