<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Application Creation</title>
</head>
<body>
<header>
    <h1>Application Creation</h1>
</header>
<main>
    <form action="saveApplication" method="post">
        <div>
            <label for="resume">RESUME: </label>
            <input type="text" id="resume" name="resume">
        </div>

        <div>
            <label for="applicationState">Application State :</label>
            <select name="applicationState" id="applicationState">
                <c:forEach items="${applicationStates}" var="applicationState">
                    <option value="${applicationState}">${applicationState}</option>
                </c:forEach>
            </select>
        </div>

        <div>
            <label for="applicant">Applicant:</label>
            <select name="applicant" id="applicant">
                <c:forEach items="${applicants}" var="applicant">
                    <option value="${applicant.id}">${applicant.lastName}</option>
                </c:forEach>
            </select>

        </div>
        <div>
            <label for="jobListing">Job Listing:</label>
            <select name="jobListing" id="jobListing">
                <c:forEach items="${jobListings}" var="jobListing">
                    <option value="${jobListing.id}">${jobListing.jobTitle}</option>
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
