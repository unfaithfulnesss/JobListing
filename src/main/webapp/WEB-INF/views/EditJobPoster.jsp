<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JobPoster Edition</title>
</head>
<body>
<header>
    <h1>JobPoster Edition</h1>
</header>
<main>
    <form action="updateJobPoster" method="post">
        <div hidden="hidden" >
            <label for="id">ID : </label>
            <input type="text" id="id" name="id" value="${JobPosters.id}">
        </div>
        <div>
            <label for="firstName">First Name : </label>
            <input type="text" id="firstName" name="firstName" value="${JobPosters.firstName}">
        </div>
        <div>
            <label for="lastName">Last Name : </label>
            <input type="text" id="lastName" name="lastName" value="${JobPosters.lastName}">
        </div>
        <div>
            <label for="email">Email : </label>
            <input type="email" id="email" name="email" value="${JobPosters.email}">
        </div>
        <div>
            <label for="company">Company : </label>
            <input type="text" id="company" name="company" value="${JobPosters.company}">
        </div>
        <div>
            <input type="submit" value="Update">
        </div>
    </form>
</main>
<footer>
    <a href="JobPostersList">JobPosters List</a>
</footer>
</body>
</html>


