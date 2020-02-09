<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>

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
	 		
			      <p style="color: red;">${errorString}</p>
			      
			      <div class="login-form">
				    <form action="${pageContext.request.contextPath}/login" method="post">
				        <h2 class="text-center">Zaloguj się</h2>       
				        <p style="color: red;">${errorString}</p>
				        <div class="form-group">
				            <input type="text" class="form-control" placeholder="Imię" name="name" value= "${student.name}" required="required">
				        </div>
				        <div class="form-group">
				            <input type="text" class="form-control" placeholder="Nazwisko" name="surname" value= "${student.surname}" required="required">
				        </div>
				        <div class="form-group">
				            <input type="password" class="form-control" placeholder="Numer indeksu" name= "index_number" value= "${student.index_number}" required="required">
				        </div>
				        <div class="form-group">
				            <button type="submit" class="btn btn-primary btn-block">Zaloguj</button>
				        </div>
				        <div class="clearfix">
				            <label class="pull-left checkbox-inline"><input type="checkbox" name="rememberMe" value= "Y">Pamiętaj mnie</label>
				        </div>        
				    </form>
				</div>
	 		</div>
	   </div>
	   <jsp:include page="_footer.jsp"></jsp:include>
   </body>
</html>