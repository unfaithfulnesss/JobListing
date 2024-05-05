<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Category Edition</title>
</head>
<body>
<header>
    <h1>Category Edition</h1>
</header>
<main>
    <form action="updateCategory" method="post">
        <div hidden="hidden" >
            <label for="id">ID : </label>
            <input type="text" id="id" name="id" value="${Categories.id}">
        </div>
        <div>
            <label for="name">Category Name : </label>
            <input type="text" id="name" name="name" value="${Categories.name}">
        </div>
        <div>
            <input type="submit" value="Update">
        </div>
    </form>
</main>
<footer>
    <a href="CategoriesList">Categories List</a>
</footer>
</body>
</html>


