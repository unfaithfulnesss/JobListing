<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags  -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <!--Core CSS -->
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/5.3.3/css/bootstrap.min.css">

    <title>Applicants List</title>
</head>
<body>
<header>
    <h1>Applicants List</h1>
</header>
<main>
    <div class="s-card demo-table">
        <table class="table is-striped is-fullwidth">
        <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">FIRST NAME</th>
                <th scope="col">LAST NAME</th>
                <th scope="col">EMAIL</th>
                <th class="is-end">
                    <div class="dark-inverted">
                        Actions
                    </div>
                </th>
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
                        <a href="editApplicant?id=${applicant.id}">
                            Edit
                        </a>
                    </td>


                </tr>
            </c:forEach>
        </tbody>
    </table>
    </div>
</main>
<footer>
    <a href="createApplicant">Applicant Creation</a>
</footer>
</body>
</html>

