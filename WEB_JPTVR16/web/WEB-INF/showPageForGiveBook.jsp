<%-- 
    Document   : page4
    Created on : Dec 10, 2018, 2:15:58 PM
    Author     : pupil
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Библиотека</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    </head>
    <body>
        <h1>Выдать книгу читателю</h1>
        <form action="giveBook" method="POST">
            <h2>Список книг</h2> 
            <select name="bookId">
                <c:forEach var="book" items="${listBooks}">
                <option value="${book.id}">${book.name}, ${book.author}, ${book.isbn}</option>
            </c:forEach>
        
    
  
            </select><br>
             <h2>Список читателей</h2> 
            <select name="readerId">
            <c:forEach var="reader" items="${listReaders}">
        <option value="${reader.id}">${reader.code}, ${reader.name}, ${reader.surname}</option>
            </c:forEach>
  
            </select> <br><br>
            <input type="submit">
        </form>
    </body>
</html>
