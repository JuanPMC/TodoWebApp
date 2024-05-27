<%@ include file="commun/header.jspf" %>
<%@ include file="commun/nav.jspf" %>
<div class="container">
		User: ${name}
		<hr>
		<h1>Todos</h1>
		<table class="table">
			<thead>
				<tr>
					<td>Id</td>
					<td>Description</td>
					<td>Dew Date</td>
					<td>Done</td>
					<td></td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.id}</td>
						<td>${todo.description}</td>
						<td>${todo.dew_date}</td>
						<td>${todo.done}</td>
						<td><a href="todo-delete?id=${todo.id}"><button class="btn btn-danger">Delete</button></a><a href="edit-todo?id=${todo.id}"><button class="btn btn-warning">Edit</button></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a  href="/addTodo"><button class="btn btn-success">Add Todo</button></a>
	</div>
	
<%@ include file="commun/footer.jspf" %>