<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>成功</title>
</head>
<body>
   <%
      String id = (String)request.getAttribute("id") ;
 
   %>
   下单成功 ，订单号为<%=id%>
   
   <a href="<%=request.getContextPath()%>/pages/queryOrder.jsp">查询</a>
</body>
</html>