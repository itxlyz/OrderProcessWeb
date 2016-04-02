<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单查询</title>
</head>
<body>
<form name="QueryOrderForm"   action="<%=request.getContextPath()%>/QueryOrder.do"
      method="POST">
   订单号为<input type='text' id='id' name='id' size='16' class="changeC" maxlength='16'/>
            <input type="submit" class="type_button" value="查询"/> 
           
</form>
</body>
</html>