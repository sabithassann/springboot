<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Product Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1>Add Product</h1>

        <f:form method="post" action="/empsave" modelAttribute="employee">
            <table class="table table-striped">
                <tr>
                    <td>Name</td>
                    <td>
                        <f:input path="name" class="form-control" />
                    </td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td>
                        <f:input path="price" class="form-control" />
                    </td>
                </tr>
                <tr>
                    <td>Quantity</td>
                    <td>
                        <f:input path="quantity" class="form-control" />
                    </td>
                </tr>
                <tr>
                    <td>Brands</td>
                    <td>
                        <f:select path="brand" class="form-control">
                            <f:option value="Mouse">Mouse</f:option>
                            <f:option value="Keyboard">Keyboard</f:option>
                            <f:option value="Monitor">Monitor</f:option>
                            <f:option value="Laptop">Laptop</f:option>
                        </f:select>
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

