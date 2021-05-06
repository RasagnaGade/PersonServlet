<html>
<body>
	<%@ page errorPage="ShowError.jsp"%>
	<h3 align=center>Elementary Mathematics</h3>
<%
		String str1 = request.getParameter("t1");
		String str2 = request.getParameter("t2");
		double nr = Double.parseDouble(str1);
		double dr = Double.parseDouble(str2);
%>
	<center>
		Numerator is:<%=nr%><br> Denominator is:<%=dr%><br>
		Quotient is:<%=nr / dr%>
	</center>

</body></html>
