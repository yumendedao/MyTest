package cn.jiudao.biz.daemon;

import java.util.Date;

/**
 * 本地系统时间被修改事件处理
 * LocalTimeModifiedHandler
 * @author wangwj<br>2015年4月1日
 */
public interface LocalTimeModifiedListener extends DaemonEventListener {
	/**
	 * 本地系统时间被修改时触发
	 * 检查时间的周期为一秒, 若下一周期获得的当前时间比前一周期获得的时间早(向前调整时间)或晚1.5秒以上,
	 * 则判定系统时间被修改
	 * @author wangwj<br>2015年4月1日
	 * @param prevTime 前一检查周期的系统时间
	 * @param now 当前系统时间
	 */
	public void timeModified(Date prevTime, Date now);
}
