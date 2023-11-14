<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HiberMenta</title>
    <link rel="icon" href="imagens/favicon.png">
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="container">
        <h1>CRUD HiberMenta</h1>
        <h2>Agenda de Contatos</h2>
        <% String contextPath = ((HttpServletRequest) request).getContextPath(); %>
        <a href="<%= contextPath %>/ContatoAction.list.mtw" class="btn btn-create ">Ver Contatos</a>
    </div>
</body>
</html>
