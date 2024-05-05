<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Applicants List</title>
</head>
<body>
<header>
    <h1>Applicants List</h1>
</header>
<main>
    <table class="table table-striped">
        <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">FIRST NAME</th>
                <th scope="col">LAST NAME</th>
                <th scope="col">EMAIL</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${applicants}" var="applicant">
                <tr>
                    <td>${applicant.id}</td>
                    <td>${applicant.firstName}</td>
                    <td>${applicant.lastName}</td>
                    <td>${applicant.email}</td>
                    <td>
                        <a onclick="return confirm('Are you sure to delete this Applicant?')" href="deleteApplicant?id=${applicant.id}">
                            Delete
                        </a>
                    </td>
                    <td>
                        <a href="editApplicant?id=${applicant.id}">
                            Edit
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</main>
<footer>
    <a href="createApplicant">Applicant Creation</a>
</footer>
</body>
</html>

