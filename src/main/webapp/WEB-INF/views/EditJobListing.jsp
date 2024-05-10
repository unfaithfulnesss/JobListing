<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/5.3.3/css/bootstrap.min.css">
    <title>Job Listing Edition</title>
</head>
<body>
<header>
    <h1>Job Listing Edition</h1>
</header>
<main>
    <form action="updateJobListing" method="post">
        <div hidden="hidden" >
            <label for="id">ID : </label>
            <input type="text" id="id" name="id" value="${jobListing.id}">
        </div>
        <div>
            <label for="jobTitle">Job title : </label>
            <input type="text" id="jobTitle" name="jobTitle" value="${jobListing.jobTitle}">
        </div>
        <div>
            <label for="description">Description : </label>
            <input type="text" id="description" name="description" value="${jobListing.description}">
        </div>
        <div>
            <label for="company">Company : </label>
            <input type="text" id="company" name="company" value="${jobListing.company}">
        </div>
        <div>
            <label for="salary">Salary : </label>
            <input type="number" id="salary" name="salary" value="${jobListing.salary}">
        </div>
        <div>
            <label for="jobType">Job Type : </label>
            <select name="jobType" id="jobType">
            <c:forEach var="type" items="${jobListing.jobType.values()}">
                <option value="${type}">${type}</option>
            </c:forEach>
            </select>
        </div>
        <div>
            <label for="datePosted">Date Posted : </label>
            <input type="date" id="datePosted" name="datePosted" value="${jobListing.datePosted}">
        </div>
        <div>
            <label for="category">Category:</label>
            <select name="category" id="category">
                <c:forEach items="${categories}" var="category">
                    <option value="${jobListing.category.id}">${jobListing.category.name}</option>
                </c:forEach>
            </select>

        </div>
        <div>
            <label for="jobPoster">Job Poster:</label>
            <select name="jobPoster" id="jobPoster">
                <c:forEach items="${jobPosters}" var="jobPoster">
                    <option value="${jobListing.jobPoster.id}">${jobListing.jobPoster.lastName}</option>
                </c:forEach>
            </select>

        </div>
        <div>
            <input type="submit" value="Update">
        </div>
    </form>
</main>
<footer>
    <a href="JobListingsList">Job Listings List</a>
</footer>
</body>
</html>
