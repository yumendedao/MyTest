package cn.jiudao.biz.daemon;

import java.util.Date;

/**
 * 时间同步事件处理
 * TimeSyncListener
 * @author wangwj<br>2015年4月1日
 */
public interface TimeSyncListener extends DaemonEventListener {
	/**
	 * 时间同步成功时触发
	 * @author wangwj<br>2015年4月1日
	 * @param serverTime 服务器时间
	 */
	public void syncSuccess(Date serverTime);
	
	/**
	 * 时间同步失败时触发
	 * @author wangwj<br>2015年4月1日
	 * @param message 错误信息
	 * @param cause 造成同步失败的异常
	 */
	public void syncFailure(String message, Throwable cause);
}
