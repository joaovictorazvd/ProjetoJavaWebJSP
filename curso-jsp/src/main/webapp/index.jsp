<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Curso JSP</title>
<style type="text/css">
form {
	position: absolute;
	top: 40%;
	left: 33%;
	right: 33%;
}

h4 {
	position: absolute;
	top: 30%;
	left: 33%;
	right: 33%;
}

.msg {
	position: absolute;
	top: 60%;
	left: 33%;
	right: 33%;
	font-size: 15px;
	color: red;
}
</style>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
</head>

<h4>Curso de JSP do JV</h4>
<body>
	<form action="ServletLogin" method="post"
		class="row g-3 needs-validation" novalidate>
		<input type="hidden" value="<%=request.getParameter("url")%>"
			name="url">
		<div class="col-md-6">
			<label class="form-label">Login</label> <input class="form-control"
				name="login" type="text" required="required">
			<div class="valid-feedback">Ok!</div>
			<div class="invalid-feedback">Obrigatório!</div>
		</div>
		<div class="col-md-6">
			<label class="form-label">Senha</label> <input class="form-control"
				name="senha" type="password" required="required">
			<div class="valid-feedback">Ok!</div>
			<div class="invalid-feedback">Obrigatório!</div>
		</div>
		<input type="submit" value="Enviar" class="btn btn-primary">

	</form>
	<h4 class="msg">${msg}</h4>
	<script type="text/javascript">
	(()=> { 'use strict'
	  const forms = document.querySelectorAll('.needs-validation')
	  Array.from(forms).forEach(form => {
	    form.addEventListener('submit', event => {
	      if (!form.checkValidity()) {
	        event.preventDefault()
	        event.stopPropagation()
	      }
	
	      form.classList.add('was-validated')
	    }, false)
	  })
	})()
	</script>
</body>
</html>
