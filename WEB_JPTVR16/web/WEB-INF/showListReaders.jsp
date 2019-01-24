<%-- 
    Document   : page3
    Created on : Dec 10, 2018, 11:16:11 AM
    Author     : pupil
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Библиотека<</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    </head>
    <body>
        <h1 class="h1">Список читателей ${info}</h1>
        
        <a href="index.html">Главная</a>
        
        <ul>
            
            <c:forEach var="reader" items="${listReaders}">
                <li>${reader.code}, ${reader.name}, ${reader.surname} </li>
            </c:forEach>
        </ul>
    </body>
</html>
