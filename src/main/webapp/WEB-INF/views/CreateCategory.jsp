<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/5.3.3/css/bootstrap.min.css">
    <title>Category Creation</title>
</head>
<body>
<header>
    <h1>Category Creation</h1>
</header>
<main>
    <form action="saveCategory" method="post">
        <div>
            <label for="name">Category Name : </label>
            <input type="text" id="name" name="name">
        </div>
        <div>
            <input type="submit" value="Save">
        </div>
    </form>
</main>
<footer>
    <a href="CategoriesList">Categories List</a>
</footer>
</body>
</html>
