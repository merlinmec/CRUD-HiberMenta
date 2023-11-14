<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="mec.model.Contato"%>
<%@taglib prefix="mtw" uri="http://www.mentaframework.org/tags-mtw/"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Contato</title>
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
        <h1>Editar Contato</h1>
        <mtw:form action="/ContatoAction.update.mtw" klass="form">
        <mtw:input type="hidden" name="id" value="${contato.idcon}" />
        
        <label>Nome:</label>
        <mtw:input type="text" name="nome" value="${contato.nome}" maxlength="25" />
        <mtw:outError field="nome">
            <font color="red"><mtw:out /></font>
        </mtw:outError>
        <br>
        
        <label>Email:</label>
        <mtw:input type="email" name="email" value="${contato.email}" maxlength="25" />
        <mtw:outError field="email">
            <font color="red"><mtw:out /></font>
        </mtw:outError>
        <br>

        <label>Telefone:</label>
        <mtw:input type="text" name="telefone" value="${contato.telefone}" maxlength="14"/>
        <mtw:outError field="telefone">
            <font color="red"><mtw:out /></font>
        </mtw:outError>
        <br>

        <label>Rua:</label>
        <mtw:input type="text" name="rua" value="${contato.rua}" maxlength="10" />
        <mtw:outError field="rua">
            <font color="red"><mtw:out /></font>
        </mtw:outError>
        <br>

        <label>Nº da Residência:</label>
        <mtw:input type="text" name="numero" value="${contato.numero}" maxlength="10" />
        <mtw:outError field="numero">
            <font color="red"><mtw:out /></font>
        </mtw:outError>
        <br>

        <label>Bairro:</label>
        <mtw:input type="text" name="bairro" value="${contato.bairro}" maxlength="40" />
        <mtw:outError field="bairro">
            <font color="red"><mtw:out /></font>
        </mtw:outError>
        <br>

        <label>Estado:</label>
        <mtw:input type="text" name="estado" value="${contato.estado}"  maxlength="20" />
        <mtw:outError field="estado">
            <font color="red"><mtw:out /></font>
        </mtw:outError>
        <br>
        
        <label>Cidade:</label>
        <mtw:input type="text" name="cidade" value="${contato.cidade}" maxlength="30" />
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

