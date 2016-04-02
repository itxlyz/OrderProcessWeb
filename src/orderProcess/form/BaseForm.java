package orderProcess.form;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
/**
 * Form����
 *
 */
public class BaseForm extends ActionForm {
    private static final long serialVersionUID = 1L;
    private HttpServletRequest request;
    private HttpServletResponse response;
	private HttpSession session;
	

	
    /**
     * ���HttpRequest
     * @param aRequest
     */
	public HttpServletRequest getRequest() {
		return request;
	}
    /**
     * Ϊ���ر���iRequest��ֵ
     * @param aRequest
     */
	public void setRequest(HttpServletRequest aRequest) {
		this.request = aRequest;
	}
    /**
     * ���HttpSession
     * @return
     */
    public HttpSession getSession() {
    	if(session == null)
    		session = request.getSession();
        return session;
    }
    /**
     * ��֤������Ч��
     */
	public ActionErrors validate(ActionMapping aMapping,HttpServletRequest aRequest){
        return null;
    }
    
    /**���HttpResponse
     * @return Returns the response.
     */
    public HttpServletResponse getResponse() {
        return this.response;
    }
    /**Ϊ���ر���iResponse��ֵ
     * @param aResponse 
     */
    public void setResponse(HttpServletResponse aResponse) {
        this.response = aResponse;
    }
    
}
 