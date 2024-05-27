<%@ include file="commun/header.jspf" %>
<%@ include file="commun/nav.jspf" %>
	<div class="container">
	
		<h1>Welcome to login</h1>
		${error}
		<form method="POST" >
			Username: <input name="name" type="text">
			Password: <input name="password" type="password">
			<input type="submit" value="send" >
		</form>
	</div>	
	
<%@ include file="commun/footer.jspf" %>