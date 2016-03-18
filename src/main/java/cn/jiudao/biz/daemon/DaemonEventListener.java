package cn.jiudao.biz.daemon;

/**
 * 后台线程事件接口
 * DeamonEventListener
 * @author wangwj<br>2015年4月2日
 */
public interface DaemonEventListener {
	/**
	 * 后台线程启动
	 * @author wangwj<br>2015年4月2日
	 */
	public void daemonStart();
	
	/**
	 * 后台线程停止
	 * @author wangwj<br>2015年4月2日
	 */
	public void daemonStop();
	
	/**
	 * 后台线程错误
	 * @author wangwj<br>2015年4月2日
	 * @param message
	 * @param cause
	 */
	public void daemonError(String message, Throwable cause);
}
