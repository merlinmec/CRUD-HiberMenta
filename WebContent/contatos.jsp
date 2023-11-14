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
    <title>Contatos</title>
    <link rel="icon" href="imagens/favicon.png">
    <link rel="stylesheet" href="style.css">
</head>
<% String contextPath = ((HttpServletRequest) request).getContextPath(); %>
<body>
    <h1>Lista de Contatos</h1>
    <table class="table" style="width:100%">
        <thead>
            <tr>
                <th>ID</th>
                <th style="width:12%" >Nome</th>
                <th>Email</th>
                <th style="width:15%" >Telefone</th>
                <th style="width:15%" >Rua</th>
                <th>Nº da Residência</th>
                <th style="width:12%" >Bairro</th>
                <th>Cidade</th>
                <th>Estado</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            <mtw:list value="listacontatos">
                <mtw:loop var="contato">
                    <tr>
                        <td style="text-align:center">${contato.idcon}</td>
                        <td style="text-align:center">${contato.nome}</td>
                        <td style="text-align:center">${contato.email}</td>
                        <td style="text-align:center">${contato.telefone}</td>
                        <td style="text-align:center">${contato.rua}</td>
                        <td style="text-align:center">${contato.numero}</td>
                        <td style="text-align:center">${contato.bairro}</td>
                        <td style="text-align:center">${contato.cidade}</td>
                        <td style="text-align:center">${contato.estado}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/ContatoAction.select.mtw?id=${contato.idcon}" class="btn btn-edit">Editar</a>
							<a href="${pageContext.request.contextPath}/ContatoAction.delete.mtw?id=${contato.idcon}" class="btn btn-delete">Excluir</a>
                        </td>
                    </tr>
                </mtw:loop>
            </mtw:list>
        </tbody>
    </table>
    <br>
    <a href="<%= contextPath %>/ContatoAction.create.mtw" class="btn btn-create">Criar Novo Contato</a>
</body>
</html>
