<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Job Listings List</title>
</head>
<body>
<header>
    <h1>Job Listings List</h1>
</header>
<main>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">FIRST NAME</th>
            <th scope="col">LAST NAME</th>
            <th scope="col">EMAIL</th>
            <th scope="col">EMAIL</th>
            <th scope="col">EMAIL</th>
            <th scope="col">EMAIL</th>
            <th scope="col">EMAIL</th>
            <th scope="col">EMAIL</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${JobListings}" var="jobListing">
            <tr>
                <td>${jobListing.id}</td>
                <td>${jobListing.jobTitle}</td>
                <td>${jobListing.description}</td>
                <td>${jobListing.company}</td>
                <td>${jobListing.salary}</td>
                <td>${jobListing.jobType}</td>
                <td>${jobListing.datePosted}</td>
                <td>${jobListing.jobPoster.firstName} ${jobListing.jobPoster.lastName}</td>
                <td>${jobListing.category.name}</td>
                <td>
                    <a onclick="return confirm('Are you sure to delete this JobListing?')" href="deleteJobListing?id=${jobListing.id}">
                        Delete
                    </a>
                </td>
                <td>
                    <a href="editJobListing?id=${jobListing.id}">
                        Edit
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</main>
<footer>
    <a href="createJobListing">Job Listing Creation</a>
</footer>
</body>
</html>

