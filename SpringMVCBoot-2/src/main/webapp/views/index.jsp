<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  
  <form action="addAlien" method="post">
  <pre>
  Enter Your Id   : <input type="text" name="aid"><br>
  Enter Your Name : <input type="text" name="aname"><br>
                    <input type="submit">
  </pre>
  </form>
  <hr>
     <form action="getAlien" method="GET">
  <pre>  
  Enter Your Id   : <input type="text" name="aid"><br>
                    <input type="submit" name="b1" value="submit"><br>
  </pre>
  </form>
  <hr>
  
  <form action="getAlienByName" method="GET">
  <pre>  
  Enter Your Name : <input type="text" name="aname"><br>
                    <input type="submit" name="b1" value="submit"><br>
  </pre>
  </form>
  <hr>
    <form action="getAliens" method="GET">
  <pre>
                    <input type="submit" name="b1" value="get Aliens"><br>
  </pre>
  </form>
</body>
</html>