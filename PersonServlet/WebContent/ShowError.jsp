<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page isErrorPage="true" %>
<h4>This is showErrors.jsp page showing the errors of errorPage.jsp</h4>
The following errors occured:<hr>
<%exception.printStackTrace(new java.io.PrintWriter(out)); %>
</body>
</html>