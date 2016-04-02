<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>下单系统</title>
</head>
<body>
<form name="PlaceOrderForm"   action="<%=request.getContextPath()%>/PlaceOrder.do"
      method="POST">
   
            <input type="submit" class="type_button" value="下单"/> 
           
</form>
</body>
</html>