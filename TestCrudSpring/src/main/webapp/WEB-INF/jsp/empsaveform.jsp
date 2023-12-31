<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Employee Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1>Add Employee</h1>

        <f:form method="post" action="/empsave" modelAttribute="employee">
            <table class="table table-striped">
                <tr>
                    <td>Name</td>
                    <td>
                        <f:input path="name" class="form-control" />
                    </td>
                </tr>
                <tr>
                    <td>Gender</td>
                    <td>
                        <f:radiobutton path="gender" value="Male" label="Male" />
                        <f:radiobutton path="gender" value="Female" label="Female" />
                    </td>
                </tr>
                <tr>
                    <td>Salary</td>
                    <td>
                        <f:input path="salary" class="form-control" />
                    </td>
                </tr>
                <tr>
                    <td>Designation</td>
                    <td>
                        <f:input path="designation" class="form-control" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Save" class="btn btn-primary" />
                    </td>
                </tr>
            </table>
        </f:form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
