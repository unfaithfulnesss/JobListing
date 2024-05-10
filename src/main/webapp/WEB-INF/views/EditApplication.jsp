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
    <title>Application Edition</title>
</head>
<body>
<header>
    <h1>Application Edition</h1>
</header>
<main>
    <form action="updateApplication" method="post">
        <div hidden="hidden" >
            <label for="id">ID : </label>
            <input type="text" id="id" name="id" value="${Applications.id}">
        </div>
        <div>
            <label for="resume">RESUME: </label>
            <input type="text" id="resume" name="resume" value="${Applications.resume}">
        </div>

        <div>
            <label for="applicationState">Application State :</label>
            <select name="applicationState" id="applicationState">
                <c:forEach items="${Applications.applicationState.values()}" var="applicationState">
                    <option value="${applicationState}">${applicationState}</option>
                </c:forEach>
            </select>
        </div>

        <div>
            <label for="applicant">Applicant:</label>
            <select name="applicant" id="applicant">
                <c:forEach items="${Applicants}" var="applicant">
                    <option value="${Applications.applicant.id}">${Applications.applicant.lastName}</option>
                </c:forEach>
            </select>

        </div>
        <div>
            <label for="jobListing">Job Listing:</label>
            <select name="jobListing" id="jobListing">
                <c:forEach items="${JobListings}" var="jobListing">
                    <option value="${Applications.jobListing.id}">${Applications.jobListing.jobTitle}</option>
                </c:forEach>
            </select>

        </div>

        <div>
            <input type="submit" value="Save">
        </div>
    </form>
</main>
<footer>
    <a href="applicationsList">Applications List</a>
</footer>
</body>
</html>
