<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>jspPage</title>
</head>
<body>
    <form action="${pageContext.request.contextPath }/inserImgFtp" method="post" enctype="multipart/form-data">
        <input type="text" name="id"/>
		<input type="file" name="img" />
        <input type="submit">上传图片</input>
    </form> <br>
  <%--   <img alt="展示" src="${pageContext.request.contextPath }/getImg?id=901361730017472">  --%>
</body>
</html>