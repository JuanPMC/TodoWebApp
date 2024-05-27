<%@ include file="commun/header.jspf" %>
<%@ include file="commun/nav.jspf" %>

	<div class="container">
		<h1>Adding a todo</h1>
		<form:form method="POST" modelAttribute="todo">
		
		<fieldset class="mb-3">				
			<form:label path="description">Description</form:label>
			<form:input type="text" path="description" required="required"/>
			<form:errors path="description" cssClass="text-warning"/>
		</fieldset>
		
		<fieldset class="mb-3">				
			<form:label path="dew_date">Target Date</form:label>
			<form:input type="text" path="dew_date" required="required"/>
			<form:errors path="dew_date" cssClass="text-warning"/>
		</fieldset>

			<form:input type="hidden" path="id" />
			<form:input type="hidden" path="done" />
			<input class="btn-success" type="submit" value="add todo" >
		</form:form>
	</div>
		
<%@ include file="commun/footer.jspf" %>