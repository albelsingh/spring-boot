<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <%-- Id: ${showAliens[0].aid} Name : ${showAliens[0].aname} <br>
  Id: ${showAliens[1].aid} Name : ${showAliens[1].aname}
  ${showAliens}  --%>
  <h1>Below are the Aliens Details</h1>
   <c:forEach items="${showAliens}" var="rec">
      <h3>
      Id : <c:out value = "${rec.aid}"/>
      Name: <c:out value = "${rec.aname}"/><br>
       </h3>       
  </c:forEach>
 
</body>
</html>