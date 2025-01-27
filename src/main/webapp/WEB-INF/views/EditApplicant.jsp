<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/5.3.3/css/bootstrap.min.css">
    <title>Applicant Edition</title>
</head>
<body>
<header>
    <h1>Applicant Edition</h1>
</header>
<main>
    <form action="updateApplicant" method="post">
        <div hidden="hidden">
            <label for="id">ID : </label>
            <input type="text" id="id" name="id" value="${applicants.id}">
        </div>
        <div>
            <label for="firstName">First Name : </label>
            <input type="text" id="firstName" name="firstName" value="${applicants.firstName}">
        </div>
        <div>
            <label for="lastName">Last Name : </label>
            <input type="text" id="lastName" name="lastName" value="${applicants.lastName}">
        </div>
        <div>
            <label for="email">Email : </label>
            <input type="email" id="email" name="email" value="${applicants.email}">
        </div>
        <div>
            <input type="submit" value="Update">
        </div>
    </form>
</main>
<footer>
    <a href="applicantsList">Applicants List</a>
</footer>
</body>
</html>


