package orderProcess.task;

import java.sql.Timestamp;
import java.util.Random;

import orderProcess.bean.OrderBean;
import orderProcess.dao.OrderDao;
import orderProcess.utils.PropertyField;

import org.apache.log4j.Logger;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class OrderProcessTask extends Thread {
	/**
	* 日志记录.
	 */
	private static final Logger logger = Logger.getLogger(OrderDao.class.getName());

	
	private OrderBean bean;
	private boolean result;
	TransactionTemplate txTemplate ;

	public OrderProcessTask(OrderBean bean) {
		this.bean = bean;
	}

	public void run() {
		OrderDao dao = new OrderDao();
        //将订单信息插入数据库
		int insert =dao.insert(bean);
		
		if( insert !=1){
			logger.info("订单入库失败，ID ="+ bean.getId());
			return;
		}
		
		// 事务开始
		txTemplate.execute(new TransactionCallbackWithoutResult() {

			protected void doInTransactionWithoutResult(TransactionStatus status) {
				try {
					for (int i = 1; i <= 5; i++) {

						// 判断当前执行步骤和开始时间
						switch (i) {
						case 1:
							bean.setStep(PropertyField.STEP_SCHEDULING);
							bean.setStartTimeStep1(new Timestamp(System
									.currentTimeMillis()));
						case 2:
							bean.setStep(PropertyField.STEP_PRE_PROCESSING);
							bean.setStartTimeStep2(new Timestamp(System
									.currentTimeMillis()));
						case 3:
							bean.setStep(PropertyField.STEP_PROCESSING);
							bean.setStartTimeStep3(new Timestamp(System
									.currentTimeMillis()));
						case 4:
							bean.setStep(PropertyField.STEP_POST_PROCESSING);
							bean.setStartTimeStep4(new Timestamp(System
									.currentTimeMillis()));
						}

						Thread.sleep(50000);

						result = getStepResult();
						

						// 设置当前步骤结束时间
						switch (i) {
						case 1:
							bean.setEndTimeStep1(new Timestamp(System
									.currentTimeMillis()));
						case 2:
							bean.setEndTimeStep2(new Timestamp(System
									.currentTimeMillis()));
						case 3:
							bean.setEndTimeStep3(new Timestamp(System
									.currentTimeMillis()));
						case 4:
							bean.setEndTimeStep4(new Timestamp(System
									.currentTimeMillis()));
						}

						if (!result) {
							logger.info("step " +bean.getStep() +"失败，开始回滚");
							status.setRollbackOnly(); // 回滚
							bean.setStep(PropertyField.STEP_FAILED);
							break;

						}
					}
				} catch (Exception e) {
					logger.info("系统异常，开始回滚");
					status.setRollbackOnly(); // 回滚
					bean.setStep(PropertyField.STEP_FAILED);

				}

			}
		});
		
		logger.info("订单处理成");
		// 执行完订单处理，订单信息入库
		bean.setStep(result ? PropertyField.STEP_COMPLETE
				: PropertyField.STEP_FAILED);
		bean.setEndTime(new Timestamp(System.currentTimeMillis()));

		int update = dao.update(bean);

		if (update != 1) {
			logger.info("update 失败，ID ="+ bean.getId());
			return;
		}
		logger.info("订单处理成，更新数据库成功");
		
	}

	// 失败率5%
	private boolean getStepResult() {
		Random rand = new Random();
		int random = (rand.nextInt(100) + 1);
		return random <= 5 ? false : true;
	}

	public TransactionTemplate getTxTemplate() {
		return txTemplate;
	}

	public void setTxTemplate(TransactionTemplate txTemplate) {
		this.txTemplate = txTemplate;
	}
}