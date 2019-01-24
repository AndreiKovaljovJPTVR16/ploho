<%-- 
    Document   : page5
    Created on : Dec 10, 2018, 2:15:58 PM
    Author     : pupil
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    </head>
    <body>
        <h1>Библиотека</h1>
            <h2>Добавить книгу</h2> 
            <form class="form-horizontal" action="addNewBook" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Form Name</legend>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="textinput">Название книги</label>
  <div class="controls">
    <input name="${book.name}" type="text" placeholder="" class="input-xlarge">
    
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="textinput">Автор книги</label>
  <div class="controls">
    <input name="${book.author}" type="text" placeholder="" class="input-xlarge">
    
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="textinput">ISBN</label>
  <div class="controls">
    <input name="${book.isbn}" type="text" placeholder="" class="input-xlarge">
    
  </div>
</div>

<!-- Button -->
<div class="control-group">
  
  <div class="controls">
    <button id="singlebutton" name="send" class="btn btn-primary">Добавить</button>
  </div>
</div>

<a href="index.html">Главная</a>

</fieldset>
</form>

            
    </body>
</html>
