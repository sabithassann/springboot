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
        <h1>Edit Product</h1>
        <f:form method="post" action="/editempsave" modelAttribute="employee">
            <f:hidden path="id" />
            <table class="table table-striped">
                <tr>
                    <td>Name</td>
                    <td><f:input path="name" class="form-control"/></td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td><f:input path="price" class="form-control"/></td>
                </tr>
                <tr>
                    <td>Quantity</td>
                    <td><f:input path="quantity" class="form-control"/></td>
                </tr>
                <tr>
                    <td>Brand</td>
                    <td>
                        <f:select path="brand" class="form-control">
                            <f:option value="Mouse">Mouse</f:option>
                            <f:option value="Keyboard">Keyboard</f:option>
                            <f:option value="Monitor">Monitor</f:option>
                            <f:option value="Laptop">Laptop</f:option>
                        </f:select>
                    </td>
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

