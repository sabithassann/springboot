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
        <f:form method="post" action="/editstdsave" modelAttribute="student">
            <f:hidden path="roll" />
            <table class="table table-striped">
                <tr>
                    <td>Name</td>
                    <td><f:input path="name" class="form-control"/></td>
                </tr>
                <tr>
                    <td>Department</td>
                    <td>
                        <f:select path="department" class="form-control">
                            <f:option value="Java" label="Java"/>
                            <f:option value="C#" label="C#"/>
                            <f:option value="Wdpf" label="Wdpf"/>
                            <f:option value="Nt" label="Nt"/>
                        </f:select>
                    </td>
                </tr>
                <tr>
                    <td>Marks</td>
                    <td><f:input path="marks" class="form-control"/></td>
                </tr>
                
                <tr>
                    <td>Gender</td>
                    <td>
                        <f:radiobutton path="gender" value="Male" label="Male" />
                        <f:radiobutton path="gender" value="Female" label="Female" />
                    </td>
                </tr>
                
                <tr>
    <td>Hobby</td>
    <td>
        <f:checkbox path="hobby" value="Fishing" /> Fishing<br/>
        <f:checkbox path="hobby" value="Reading" /> Reading<br/>
        <f:checkbox path="hobby" value="Gaming" /> Gaming<br/>
        <f:checkbox path="hobby" value="Sleeping" /> Sleeping<br/>
    </td>
</tr>

<tr>
                    <td>Date of Birth</td>
                    <td>
                        <f:input path="dob" class="form-control" type="date" />
                    </td>
                </tr>
                

            </table>
                
            <div class="row">
                <div class="col">
                    <input type="submit" value="Edit" class="btn btn-primary"/>
                </div>
                <div class="col">
                    <a href="/viewallstd" class="btn btn-secondary">View All</a>
                </div>
            </div>
        </f:form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
