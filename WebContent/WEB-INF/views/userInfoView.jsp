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
        <div class="jumbotron">
            <div class="container">
                <h1 class="display-4">Witaj: ${user.name}</h1>
                Imię: <b>${user.name}</b>
    			<br />
    			Nazwisko: <b>${user.surname}</b>
    			<br />

            </div>
        </div>
    </div>
  </div>
 
   
 
     <jsp:include page="_footer.jsp"></jsp:include>
 
  </body>
</html>