<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JobListing Creation</title>
</head>
<body>
<header>
    <h1>JobListing Creation</h1>
</header>
<main>
    <form action="saveJobListing" method="post">
        <div>
            <label for="jobTitle">Job title : </label>
            <input type="text" id="jobTitle" name="jobTitle">
        </div>
        <div>
            <label for="description">Description : </label>
            <input type="text" id="description" name="description">
        </div>
        <div>
            <label for="company">Company : </label>
            <input type="text" id="company" name="company">
        </div>
        <div>
            <label for="salary">Salary : </label>
            <input type="number" id="salary" name="salary">
        </div>
        <div>
            <label for="jobType">Job Type : </label>
            <input type="text" id="jobType" name="jobType">
        </div>
        <div>
            <label for="datePosted">Date Posted : </label>
            <input type="date" id="datePosted" name="datePosted">
        </div>
        <div>
            <label for="category">Category:</label>
            <select name="category" id="category">
                <c:forEach items="${categories}" var="category">
                    <option value="${category.id}">${category.name}</option>
                </c:forEach>
            </select>

        </div>
        <div>
            <label for="jobPoster">Job Poster:</label>
            <select name="jobPoster" id="jobPoster">
                <c:forEach items="${jobPosters}" var="jobPoster">
                    <option value="${jobPoster.id}">${jobPoster.lastName}</option>
                </c:forEach>
            </select>

        </div>
        <div>
            <input type="submit" value="Save">
        </div>
    </form>
</main>
<footer>
    <a href="JobListingsList">JobListings List</a>
</footer>
</body>
</html>
