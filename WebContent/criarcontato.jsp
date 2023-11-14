<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="mtw" uri="http://www.mentaframework.org/tags-mtw/"%>
<%@ page import="java.util.List" %>
<%@ page import="mec.model.Contato" %>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.jsp.PageContext" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Criar Contato</title>
    <link rel="icon" href="imagens/favicon.png">
    <link rel="stylesheet" href="style.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
</head>
<%
    String contextPath = request.getContextPath();
%>
<body>
    <div class="container">
        <h1>Criar Novo Contato</h1>
        <mtw:form action="ContatoAction.create.mtw" klass="form">

            <label>Nome:</label>
            <mtw:input type="text" name="nome" maxlength="25" />
            <mtw:outError field="nome">
            <font color="red"><mtw:out /></font>
        </mtw:outError>
            <br>

            <label>Email:</label>
            <mtw:input type="email" name="email" maxlength="25"/>
            <mtw:outError field="email">
            <font color="red"><mtw:out /></font>
            </mtw:outError>
            <br>

            <label>Telefone:</label>
            <mtw:input type="text" name="telefone" maxlength="14"/>
            <mtw:outError field="telefone">
            <font color="red"><mtw:out /></font>
            </mtw:outError>
            <br>

            <label>Rua:</label>
            <mtw:input type="text" name="rua" maxlength="40"/>
            <mtw:outError field="rua">
            <font color="red"><mtw:out /></font>
            </mtw:outError>
            <br>

            <label>Nº da Residência:</label>
            <mtw:input type="text" name="numero" maxlength="10" />
            <mtw:outError field="numero">
            <font color="red"><mtw:out /></font>
            </mtw:outError>
            <br>

            <label>Bairro:</label>
            <mtw:input type="text" name="bairro" maxlength="40" />
            <mtw:outError field="bairro">
            <font color="red"><mtw:out /></font>
            </mtw:outError>
            <br>

            <label>Estado:</label>
            <mtw:input type="text" name="estado" maxlength="20" />
            <mtw:outError field="estado">
            <font color="red"><mtw:out /></font>
            </mtw:outError>
            <br>
            
            <label>Cidade:</label>
            <mtw:input type="text" name="cidade" maxlength="30" />
            <mtw:outError field="cidade">
            <font color="red"><mtw:out /></font>
            </mtw:outError>
            <br>

            <mtw:submit value="Salvar" klass="btn btn-primary"/>
        </mtw:form>
        <br>
        <a href="<%= contextPath %>/ContatoAction.list.mtw" class="btn btn-cancel">Cancelar</a>
    </div>
</body>
</html>
