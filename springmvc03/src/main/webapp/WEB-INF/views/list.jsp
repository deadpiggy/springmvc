<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Spring MVC</title>
</head>
<body>
<h2>Spring MVC 高等级查询</h2>

<form action="list" method="post" name="f">
    <input name="name" type="text" placeholder="玩具名">
    <input name="beginDate" type="date">
    <input name="endDate" type="date">
    <input type="submit" value="查询">
</form>
<br><br>

<c:forEach items="${toys }" var="toy">
    ${toy.id } --- ${toy.name } --- ${toy.price } --- ${toy.createDate }
    <br>
</c:forEach>
<br>
<br>

</body>
</html>

