package orderProcess.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import orderProcess.form.BaseForm;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
 
public abstract class BaseAction extends Action {
	
	/**
	 * 回写结果页面的信息
	 */
	protected String message;
	
	/**
	 * 返回的action
	 */
	protected String action;
	
    public abstract String execute(BaseForm form) throws Exception;
    
    public  final ActionForward execute(
            ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)
            throws Exception{
    	this.message = null;
    	this.action = null;
    	
    	BaseForm genForm = new BaseForm();
        if(form != null)
            genForm = (BaseForm)form;
        genForm.setRequest(request);
        genForm.setResponse(response);
        
        response.resetBuffer();
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache,no-store,max-age=0");
        response.setDateHeader("Expires", 0);
        
        String str = null;
        try{
        	str = execute(genForm);
        }catch (Exception e) {
        	System.out.println(message);
        	this.message = "系统繁忙";
        	str ="error";
		}
        
         if(this.message != null ){
        	genForm.getRequest().setAttribute("message", this.message);
        	System.out.println(this+message);
         }
//        if(this.action == null || this.action.length() == 0){
//        	genForm.getRequest().setAttribute("action", this.action);
//        }
        
        return mapping.findForward(str);
    }

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void enableCache(HttpServletResponse response){
		if(response == null)
			return ;
		response.setHeader("Pragma", "");
		response.setHeader("Cache-Control", "");
	}
}
