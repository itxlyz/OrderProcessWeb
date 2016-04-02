package orderProcess.action;

 

import org.apache.log4j.Logger;

import orderProcess.bean.OrderBean;
import orderProcess.dao.OrderDao;
import orderProcess.form.BaseForm;
import orderProcess.form.PlaceOrderForm;
import orderProcess.form.QueryOrderForm;

public class QueryOrderAction extends BaseAction{
	/**
	* ��־��¼.
	 */
	private static final Logger logger = Logger.getLogger(QueryOrderAction.class.getName());

	@Override
	public String execute(BaseForm form) throws Exception {
		
		//��ȡ������
		QueryOrderForm fm = (QueryOrderForm) form;
	    String id = fm.getId();
	    OrderDao dao = new OrderDao();
	    
	    //���ݶ����Ų�ѯ���ݼ�¼
	    OrderBean obean = dao.getByID(id);
	    
	    if(obean == null){
    		this.message = "δ�鵽����!";
    		logger.info(this.message);
            return "error";
            
    	}
	    
	    fm.getRequest().setAttribute("orderBean",obean);
	    logger.info("��ѯ�ɹ�");
	    return "success";
	    
	}

}
