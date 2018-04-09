<%@ page language="java" contentType="text/html;charset=UTF-8"
         import="java.text.*,java.util.*"%>
<%@ page import="java.util.Date" %>
<html>
<head>
    <title>Show time</title>
</head>
<body>
Hello :
<%
    SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
    String str = format.format(new Date());
%>
<%=str %>
</body>
</html>