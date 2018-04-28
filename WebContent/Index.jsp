<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sale of products</title>

<style rel="stylesheet" type="text/css" />
html, body { padding: 0; margin: 0;}
p {padding: 0; margin: 0;}
#geral {width: 100%; height: 100%;}
#fundo {width: 100%; height: 200px; background-image: url(fundologin.png); position: absolute; top: 50%; margin-top: -100px;}
#logoform {width: 455px; height: 200px; margin: 0 auto;}
#logo {float:left; margin-top: 35px;}
#form {float:right; margin-top: 40px; font-family: Tahoma; font-size: 10px;}
</style>

</head>
<body>
Sale of products<br/> 
Login de Usuários <br/> <br/>

<%
    String mensagem = (String) request.getAttribute("mensagem");
%>

<div id="geral">
	<div id="fundo">
    	<div id="logoform">
            <form id="form" method="post" action="ValidateLogin">
            	<p>Login</p>
       		    <p><input type="text" name="login" /></p>
                <p>Password</p>
            	<p><input type="password" name="password" /></p>
            	<p><input type="submit" value="Validar" /></p>
            </form>
        </div>
<% if (mensagem != null) {%>
    <p> <%= mensagem %> </p>
<% }%>
        
    </div>
</div>

</body>
</html>
