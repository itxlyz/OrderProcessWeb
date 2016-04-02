package orderProcess.action;

 

import org.apache.log4j.Logger;

import orderProcess.bean.OrderBean;
import orderProcess.dao.OrderDao;
import orderProcess.form.BaseForm;
import orderProcess.form.PlaceOrderForm;
import orderProcess.form.QueryOrderForm;

public class QueryOrderAction extends BaseAction{
	/**
	* 日志记录.
	 */
	private static final Logger logger = Logger.getLogger(QueryOrderAction.class.getName());

	@Override
	public String execute(BaseForm form) throws Exception {
		
		//获取订单号
		QueryOrderForm fm = (QueryOrderForm) form;
	    String id = fm.getId();
	    OrderDao dao = new OrderDao();
	    
	    //根据订单号查询数据记录
	    OrderBean obean = dao.getByID(id);
	    
	    if(obean == null){
    		this.message = "未查到数据!";
    		logger.info(this.message);
            return "error";
            
    	}
	    
	    fm.getRequest().setAttribute("orderBean",obean);
	    logger.info("查询成功");
	    return "success";
	    
	}

}
