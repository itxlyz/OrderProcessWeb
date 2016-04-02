package orderProcess.action;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.UUID;




import org.apache.log4j.Logger;

import orderProcess.bean.OrderBean;
import orderProcess.dao.OrderDao;
import orderProcess.form.BaseForm;
import orderProcess.form.PlaceOrderForm;
import orderProcess.task.OrderProcessTask;

public class PlaceOrderAction extends BaseAction{
	
	/**
	* 日志记录.
	 */
	private static final Logger logger = Logger.getLogger(PlaceOrderAction.class.getName());

	public String execute(BaseForm form) throws Exception {
		
		PlaceOrderForm fm = (PlaceOrderForm) form;
	    String merInfo = fm.getMerInfo();
	    OrderBean obean = new OrderBean(); 
	     
	     //生成订单号
	    String id =	UUID.randomUUID().toString().replaceAll("-", "");
	    logger.info("id 为:" +id);
	    if(id ==null){
	    	return "error";
	    }
	    
	    obean.setId(id);
	    obean.setStartTime(new Timestamp(System.currentTimeMillis()));
	    
		//启动线程
		Thread t = new Thread(new OrderProcessTask(obean));
		t.start();
		logger.info("开始下单");
	    fm.getRequest().setAttribute("id", id);
	    return "success";
	}
	

}
