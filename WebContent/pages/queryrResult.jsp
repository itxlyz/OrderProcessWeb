<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import=" orderProcess.bean.OrderBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单查询</title>
</head>
<body>
  <%
      OrderBean bean = (OrderBean)request.getAttribute("orderBean");
   %>
 <br>Id                           ：<%=bean.getId()== null? "" : bean.getId()%>
 <br>Current Step                 ：<%=bean.getStepFormat()== null? "" : bean.getStepFormat()%>
 <br>Order Start Time             ：<%=bean.getStartTime()== null? "" : bean.getStartTime()%>
 <br>Order End Time               ：<%=bean.getEndTime()== null? "" : bean.getEndTime()%>%>
 <br>Scheduling Start Time        ：<%=bean.getStartTimeStep1()== null? "" : bean.getStartTimeStep1()%>
 <br>Scheduling end Time          ：<%=bean.getEndTimeStep1()== null? "" : bean.getEndTimeStep1()%>
 <br>Pre-Processing Start Time    ：<%=bean.getStartTimeStep2()== null? "" : bean.getStartTimeStep2()%>
 <br>Pre-Processing end Time      ：<%=bean.getEndTimeStep2()== null? "" : bean.getEndTimeStep2()%>
 <br>Processing Start Time        ： <%=bean.getStartTimeStep3()== null? "" : bean.getStartTimeStep3()%>
 <br>Processing end Time          ：<%=bean.getEndTimeStep3()== null? "" : bean.getEndTimeStep3()%>
 <br>Post-Processing Start Time   ：<%=bean.getStartTimeStep4()== null? "" : bean.getStartTimeStep4()%>
 <br>Post-Processing end Time     ：<%=bean.getEndTimeStep4()== null? "" : bean.getEndTimeStep4()%>
 
 

</body>
</html>