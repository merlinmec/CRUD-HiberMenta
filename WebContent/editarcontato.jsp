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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
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
			<mtw:select name="estado" list="estadosMap" defValue="${contato.estado}" emptyFieldValue="Selecione um Estado"  id ="estado" />
			<br>
			
		<label>Cidade:</label>
		<mtw:select name="cidade" list="cidadesMap" defValue ="${contato.cidade}" emptyFieldValue="Selecione o Estado e depois a Cidade" id ="cidade"/>
		
        <mtw:submit value="Salvar" klass="btn btn-primary"/>
    </mtw:form>
    <br>
    <a href="<%= contextPath %>/ContatoAction.list.mtw" class="btn btn-cancel">Cancelar</a>
    </div>
<script type="text/javascript">
    $(document).ready(function () {
        $("#estado").change(function () {
            $("#cidade").empty();

            let est = $("#estado").val();
            let url = "ContatoAction.cidadesMapJSON.mtw?id=" + est;

            $.getJSON(url, function (data) {
                $.each(data, function (key, value) {
                    $("#cidade").append('<option value="' + key + '">' + value + '</option>');
                });
            }).fail(function (data) {
                $("#cidade").append("<option>Cidade Inválida</option>");
            });
        });
    });
</script>

</body>
</html>

