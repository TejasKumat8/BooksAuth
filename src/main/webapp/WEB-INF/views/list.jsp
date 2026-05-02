<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Library Setup</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f4f4f9; padding: 20px; }
        h1 { color: #333; }
        .btn { background-color: #5cb85c; color: white; padding: 10px 15px; text-decoration: none; border-radius: 4px; display: inline-block; margin-bottom: 20px; }
        table { width: 100%; border-collapse: collapse; margin-top: 10px; background-color: #fff; }
        th, td { border: 1px solid #ddd; padding: 10px; text-align: left; }
        th { background-color: #f2f2f2; }
        .edit-btn { background-color: #0275d8; color: white; padding: 5px 10px; text-decoration: none; border-radius: 3px; }
    </style>
</head>
<body>
    <h1>Library Management - Books</h1>
    <a href="${pageContext.request.contextPath}/library/add" class="btn">Add New Book</a>
    
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Genre</th>
                <th>Author</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="book" items="${books}">
                <tr>
                    <td>${book.bookId}</td>
                    <td>${book.title}</td>
                    <td>${book.genre}</td>
                    <td>${book.authorName}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/library/update/${book.bookId}" class="edit-btn">Edit</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
