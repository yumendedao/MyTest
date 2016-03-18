package cn.jiudao.biz.daemon;

import java.util.Date;

import cn.jiudao.statics.Application;

public class TimerTickDaemon extends AbstractPosDaemon {
	private static class SingletonHolder {
		private static TimerTickDaemon instance = new TimerTickDaemon();
	}
	
	public static TimerTickDaemon getInstance() {
		return SingletonHolder.instance;
	}
	
	private TimerTickDaemon() {
		super();
		listenerClass = TimerTickListener.class;
		//interval = 1000;
	}
	
	/**
	 * 注册时钟tick事件处理
	 * @author wangwj<br>2015年4月7日
	 * @param listener
	 */
	public void addTimerTickerListener(TimerTickListener listener) {
		super.addListener(listener);
	}
	
	@Override
	public void run() {
		TimerTickListener tl;
		
		while (true) {
			synchronized (listeners) {
				for (DaemonEventListener l : listeners) {
					Date now = Application.getServerTime();
					
					tl = (TimerTickListener)l;
					
					try {
						tl.timerTick(now);
//						System.out.println("tick-tock " + StringUtil.fullFormat.format(now));
					} catch (Exception ex) {
						l.daemonError(ex.getMessage(), ex);;
					}
				}
			}
			
			try {
				Thread.sleep(interval);
			} catch (InterruptedException ex) {
				onDaemonStop();
				break;
			}
		}
	}
}
