<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Applications List</title>
</head>
<body>
<header>
    <h1>Applications List</h1>
</header>
<main>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">RESUME</th>
            <th scope="col">APPLICATION STATE</th>
            <th scope="col">APPLICANT</th>
            <th scope="col">JOB LISTING</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${Applications}" var="application">
            <tr>
                <td>${application.id}</td>
                <td>${application.resume}</td>
                <td>${application.applicationState}</td>
                <td>${application.applicant.firstName} ${application.applicant.lastName}</td>
                <td>${application.jobListing.jobTitle}</td>
                <td>
                    <a onclick="return confirm('Are you sure to delete this Application?')" href="deleteApplication?id=${application.id}">
                        Delete
                    </a>
                </td>
                <td>
                    <a href="editApplication?id=${application.id}">
                        Edit
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</main>
<footer>
    <a href="createApplication">Application Creation</a>
</footer>
</body>
</html>

