<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Categories List</title>
</head>
<body>
<header>
    <h1>Categories List</h1>
</header>
<main>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">CATEGORY NAME</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${Categories}" var="Category">
            <tr>
                <td>${Category.id}</td>
                <td>${Category.name}</td>
                <td>
                    <a onclick="return confirm('Are you sure to delete this Category?')" href="deleteCategory?id=${Category.id}">
                        Delete
                    </a>
                </td>
                <td>
                    <a href="editCategory?id=${Category.id}">
                        Edit
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</main>
<footer>
    <a href="createCategory">Category Creation</a>
</footer>
</body>
</html>

