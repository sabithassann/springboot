<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1>Edit Page</h1>
        <f:form method="post" action="/editempsave" modelAttribute="employee">
            <f:hidden path="id" />
            <table class="table table-striped">
                <tr>
                    <td>Name</td>
                    <td><f:input path="name" class="form-control"/></td>
                </tr>
                <tr>
                    <td>Gender</td>
                    <td>
                        <label class="form-check-label">
                            <f:radiobutton path="gender" value="Male" class="form-check-input"/>
                            Male
                        </label>
                        <label class="form-check-label">
                            <f:radiobutton path="gender" value="Female" class="form-check-input"/>
                            Female
                        </label>
                    </td>
                </tr>
                <tr>
                    <td>Salary</td>
                    <td><f:input path="salary" class="form-control"/></td>
                </tr>
                <tr>
                    <td>Designation</td>
                    <td><f:input path="designation" class="form-control"/></td>
                </tr>
            </table>
                
            <div class="row">
                <div class="col">
                    <input type="submit" value="Edit" class="btn btn-primary"/>
                </div>
                <div class="col">
                    <a href="/viewallemp" class="btn btn-secondary">View All</a>
                </div>
            </div>
        </f:form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
