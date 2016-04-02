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
	* ��־��¼.
	 */
	private static final Logger logger = Logger.getLogger(PlaceOrderAction.class.getName());

	public String execute(BaseForm form) throws Exception {
		
		PlaceOrderForm fm = (PlaceOrderForm) form;
	    String merInfo = fm.getMerInfo();
	    OrderBean obean = new OrderBean(); 
	     
	     //���ɶ�����
	    String id =	UUID.randomUUID().toString().replaceAll("-", "");
	    logger.info("id Ϊ:" +id);
	    if(id ==null){
	    	return "error";
	    }
	    
	    obean.setId(id);
	    obean.setStartTime(new Timestamp(System.currentTimeMillis()));
	    
		//�����߳�
		Thread t = new Thread(new OrderProcessTask(obean));
		t.start();
		logger.info("��ʼ�µ�");
	    fm.getRequest().setAttribute("id", id);
	    return "success";
	}
	

}
