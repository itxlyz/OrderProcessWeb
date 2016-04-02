package orderProcess.bean;

import java.lang.reflect.Field;

import org.apache.log4j.Logger;

 

import java.sql.Timestamp;


public class OrderBean {
	
	private final static Logger logger = Logger.getLogger(OrderBean.class);
	
	
	//订单号
	private String id;
	
	//目前订单步骤
	private String step;
	
	//订单开始时间
	private Timestamp startTime;
	
	//订单处理完成时间
	private Timestamp endTime;
	
	//订单开始时间
	private Timestamp startTimeStep1;
	
	//订单处理完成时间
	private Timestamp endTimeStep1;
	
	//订单开始时间
	private Timestamp startTimeStep2;
	
	//订单处理完成时间
	private Timestamp endTimeStep2;
	
	//订单开始时间
	private Timestamp startTimeStep3;
	
	//订单处理完成时间
	private Timestamp endTimeStep3;
	
	//订单开始时间
	private Timestamp startTimeStep4;
	
	//订单处理完成时间
	private Timestamp endTimeStep4;
	
 
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public Timestamp getStartTimeStep1() {
		return startTimeStep1;
	}

	public void setStartTimeStep1(Timestamp startTimeStep1) {
		this.startTimeStep1 = startTimeStep1;
	}

	public Timestamp getEndTimeStep1() {
		return endTimeStep1;
	}

	public void setEndTimeStep1(Timestamp endTimeStep1) {
		this.endTimeStep1 = endTimeStep1;
	}

	public Timestamp getStartTimeStep2() {
		return startTimeStep2;
	}

	public void setStartTimeStep2(Timestamp startTimeStep2) {
		this.startTimeStep2 = startTimeStep2;
	}

	public Timestamp getEndTimeStep2() {
		return endTimeStep2;
	}

	public void setEndTimeStep2(Timestamp endTimeStep2) {
		this.endTimeStep2 = endTimeStep2;
	}

	public Timestamp getStartTimeStep3() {
		return startTimeStep3;
	}

	public void setStartTimeStep3(Timestamp startTimeStep3) {
		this.startTimeStep3 = startTimeStep3;
	}

	public Timestamp getEndTimeStep3() {
		return endTimeStep3;
	}

	public void setEndTimeStep3(Timestamp endTimeStep3) {
		this.endTimeStep3 = endTimeStep3;
	}

	public Timestamp getStartTimeStep4() {
		return startTimeStep4;
	}

	public void setStartTimeStep4(Timestamp startTimeStep4) {
		this.startTimeStep4 = startTimeStep4;
	}

	public Timestamp getEndTimeStep4() {
		return endTimeStep4;
	}

	public void setEndTimeStep4(Timestamp endTimeStep4) {
		this.endTimeStep4 = endTimeStep4;
	}
	
	/**
	 * toString.
	 */
	 
    public String toString() {
        StringBuilder sb = new StringBuilder();
        try {
            Field[] fields = this.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = null;
                if (field != null) {
                    value = field.get(this);
                }
                sb.append(field.getName());
                sb.append("=");
                sb.append(value);
                sb.append(",");
            }
        } catch (SecurityException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        } catch (IllegalArgumentException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        } catch (IllegalAccessException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }
        if (sb.length() > 0) {
            sb.delete(sb.length() - 1, sb.length());
        }
        return sb.toString();
    }
	
    
	public String getStepFormat() {
		if ("01".equals(step)) {
			return "Scheduling";
		} else if ("02".equals(step)) {
			return "Pre-Processing";
		} else if ("03".equals(step)) {
			return "Processing";
		} else if ("04".equals(step)) {
			return "Post-Processing";
		} else if ("05".equals(step)) {
			return "Complete";
		} else if ("06".equals(step)) {
			return "Failed";
		} else {
			return step;
		}
	}

}
