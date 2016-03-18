package cn.jiudao.biz.daemon;

import java.util.Date;

/**
 * 内部时钟走时事件处理
 * TimerTickHandler
 * @author wangwj<br>2015年4月1日
 */
public interface TimerTickListener extends DaemonEventListener {
	/**
	 * 走时事件
	 * @author wangwj<br>2015年4月1日
	 * @param now 当前时间 
	 */
	public void timerTick(Date now);
}
