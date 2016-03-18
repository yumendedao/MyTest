package cn.jiudao.biz.daemon;

import java.util.List;

/**
 * Pos后台线程接口
 * PosDaemon
 * @author wangwj<br>2015年4月7日
 */
public interface PosDaemon {
	/**
	 * 是否在运行
	 * @author wangwj<br>2015年4月7日
	 * @return
	 */
	public boolean isRunning();
	
	/**
	 * 启动
	 * @author wangwj<br>2015年4月7日
	 */
	public void startDaemon();
	
	/**
	 * 停止
	 * @author wangwj<br>2015年4月7日
	 */
	public void stopDaemon();
	
	/**
	 * 立即执行 run as soon as possible
	 * @author wangwj<br>2015年4月8日
	 */
	public void runASAP();
	
	/**
	 * 注册事件处理
	 * @author wangwj<br>2015年4月7日
	 * @param listener
	 */
	public void addListener(DaemonEventListener listener);
	
	/**
	 * 注册多个事件处理
	 * @author wangwj<br>2015年4月7日
	 * @param listeners
	 */
	public void addListeners(List<DaemonEventListener> listeners);
	
	/**
	 * 移除事件处理
	 * @author wangwj<br>2015年4月7日
	 * @param listener
	 */
	public void removeListener(DaemonEventListener listener);
	
	/**
	 * 清楚所有事件处理
	 * @author wangwj<br>2015年4月7日
	 */
	public void purgeListeners();
}
