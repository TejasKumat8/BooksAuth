<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Book</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f4f4f9; padding: 20px; }
        h1 { color: #333; }
        .container { background-color: #fff; padding: 20px; border-radius: 5px; max-width: 500px; margin: auto; }
        .form-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; }
        input[type="text"], select { width: 100%; padding: 8px; box-sizing: border-box; }
        .btn { background-color: #5cb85c; color: white; padding: 10px 15px; border: none; border-radius: 4px; cursor: pointer; }
        .btn-cancel { background-color: #d9534f; text-decoration: none; display: inline-block; padding: 10px 15px; color: white; border-radius: 4px; }
        .error { color: red; margin-bottom: 15px; }
    </style>
</head>
<body>
    <div class="container">
        <h1>Add New Book</h1>
        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>
        <form action="${pageContext.request.contextPath}/library/add" method="post">
            <div class="form-group">
                <label for="title">Title:</label>
                <input type="text" id="title" name="title" required>
            </div>
            <div class="form-group">
                <label for="genre">Genre:</label>
                <input type="text" id="genre" name="genre" required>
            </div>
            <div class="form-group">
                <label for="authorId">Author:</label>
                <select id="authorId" name="authorId" required>
                    <c:forEach var="author" items="${authors}">
                        <option value="${author.id}">${author.name}</option>
                    </c:forEach>
                </select>
            </div>
            <button type="submit" class="btn">Save</button>
            <a href="${pageContext.request.contextPath}/library" class="btn-cancel">Cancel</a>
        </form>
    </div>
</body>
</html>
