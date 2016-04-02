package orderProcess.form;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
/**
 * Form基类
 *
 */
public class BaseForm extends ActionForm {
    private static final long serialVersionUID = 1L;
    private HttpServletRequest request;
    private HttpServletResponse response;
	private HttpSession session;
	

	
    /**
     * 获得HttpRequest
     * @param aRequest
     */
	public HttpServletRequest getRequest() {
		return request;
	}
    /**
     * 为本地变量iRequest赋值
     * @param aRequest
     */
	public void setRequest(HttpServletRequest aRequest) {
		this.request = aRequest;
	}
    /**
     * 获得HttpSession
     * @return
     */
    public HttpSession getSession() {
    	if(session == null)
    		session = request.getSession();
        return session;
    }
    /**
     * 验证数据有效性
     */
	public ActionErrors validate(ActionMapping aMapping,HttpServletRequest aRequest){
        return null;
    }
    
    /**获得HttpResponse
     * @return Returns the response.
     */
    public HttpServletResponse getResponse() {
        return this.response;
    }
    /**为本地变量iResponse赋值
     * @param aResponse 
     */
    public void setResponse(HttpServletResponse aResponse) {
        this.response = aResponse;
    }
    
}
 