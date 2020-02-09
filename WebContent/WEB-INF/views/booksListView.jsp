<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
     <link crossorigin="anonymous" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" rel="stylesheet">
     <link rel="stylesheet" href="style.css" type="text/css">	
    <title>Biblioteka</title>
 </head>
 <body>
 	<div class="bg">
	    <jsp:include page="_header.jsp"></jsp:include>
	 	<div class="container">
	 		<div class="jumbotron">
			    <h3>Lista książek</h3>
			 
			    <p style="color: red;">${errorString}</p>
			 	
			    <table class="table table-striped">
			    	<tbody>
				    	<tr>
					    	<th scope="row" class="text-center"><h3>Autor</h3></th>
					    	<th scope="row" class="text-center"><h3>Tytuł</h3></th>
					    	<th scope="row" class="text-center"><h3>Rok wydania</h3></th>
					    	<th scope="row" class="text-center"><h3>Status</h3></th>
				    	</tr>
			       	<c:forEach items="${booksList}" var="book" >
			          <tr>
			         	 <td class="text-center">${book.author}</td>
			             <td class="text-center">${book.title}</td>
			             <td class="text-center">${book.year}</td>
			             <td class="text-center">
			             	<c:choose>
							    <c:when test="${book.getStatus() == true}">
							    	<form action="${pageContext.request.contextPath}/BookList" method="post">
							        <button type="submit" class="btn btn-success" name="id" value="${book.getBookId()}">Rezerwuj</button>
							        <br />
							    </c:when>    
							    <c:otherwise>
							        <span class="badge badge-danger">Niedostępne</span>
							        <br />
							    </c:otherwise>
							</c:choose>
			             </td>
			          </tr>
			       </c:forEach>
			    </table>
			    <p style="color: red;">${errorString}</p>
		    </div>
	    </div>
   	</div>
   	<jsp:include page="_footer.jsp"></jsp:include>
 
 </body>	
</html>