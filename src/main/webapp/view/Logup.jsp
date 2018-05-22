<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Bienvenido al sistema de registro de CEUS</h2>
	
	<div id="reg-pro"><p>Puedes registrarte añadiendo tu nombre y email</p>
		<form action="../AddUsuarioController" method="Post">
			<label>Nombre:</label><input type="text" name="nombre" placeholder="nombre"/>
			<label>email:</label><input type="text" name="email" placeholder="example@somewhere.com"/>
			<input type="submit" value="Registrate">
		</form>
	</div>
	<div id="google"><p>Si lo prefieres puedes registrarte atraves de Google</p>
		<a href="../googleAuth">Google</a>
	</div>
</body>
</html>