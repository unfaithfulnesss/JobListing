<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Job Posters List</title>
</head>
<body>
<header>
    <h1>Job Posters List</h1>
</header>
<main>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">FIRST NAME</th>
            <th scope="col">LAST NAME</th>
            <th scope="col">EMAIL</th>
            <th scope="col">COMPANY</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${JobPosters}" var="JobPoster">
            <tr>
                <td>${JobPoster.id}</td>
                <td>${JobPoster.firstName}</td>
                <td>${JobPoster.lastName}</td>
                <td>${JobPoster.email}</td>

                <td>
                    <a onclick="return confirm('Are you sure to delete this JobPoster?')" href="deleteJobPoster?id=${JobPoster.id}">
                        Delete
                    </a>
                </td>
                <td>
                    <a href="editJobPoster?id=${JobPoster.id}">
                        Edit
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</main>
<footer>
    <a href="createJobPoster">Job Poster Creation</a>
</footer>
</body>
</html>

