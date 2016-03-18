package cn.jiudao.biz.daemon;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPosDaemon extends Thread implements PosDaemon {
	protected final List<DaemonEventListener> listeners = new ArrayList<DaemonEventListener>();
	protected boolean running;
	protected Class<? extends DaemonEventListener> listenerClass = null;
	protected long interval = 1000L; 
	
	protected AbstractPosDaemon() {
		//设置daemon属性, 程序结束时Deamon线程会立即退出
		setDaemon(true);
		
		//设置线程异常处理
		setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			public void uncaughtException(Thread t, Throwable ex) {
				onDaemonError(ex.getMessage(), ex);
			}
		});
	}
	
	protected void onDaemonError(String message, Throwable ex) {
		synchronized (listeners) {
			for (DaemonEventListener l : listeners) {
				if (l == null)
					continue;
				
				l.daemonError(message, ex);
			}
		}
	}
	
	protected void onDaemonStart() {
		synchronized (listeners) {
			for (DaemonEventListener l : listeners) {
				if (l == null)
					continue;
				
				l.daemonStart();
			}
		}
	}
	
	protected void onDaemonStop() {
		synchronized (listeners) {
			for (DaemonEventListener l : listeners) {
				if (l == null)
					continue;
				
				l.daemonStop();
			}
		}
	}
	
	//检查注册的时间处理是否适合当前Daemon
	protected boolean isListenerMatch(DaemonEventListener listener) {
		if (listenerClass == null)
			return true;
		
		for (Class<?> cls : listener.getClass().getInterfaces()) {
			if (listenerClass.equals(cls)) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public synchronized void startDaemon() {
		if (isRunning())
			return;
		
		super.start();
		
		running = true;
		onDaemonStart();
	}
	
	@Override
	public synchronized void stopDaemon() {
		if (!isRunning())
			return;
		
		super.interrupt();
		
		running = false;
		onDaemonStop();
	}
	
	@Override
	public synchronized boolean isRunning() {
		return running;
	}
	
	@Override
	public void addListener(DaemonEventListener listener) {
		if (!isListenerMatch(listener))
			return;
		
		synchronized (listeners) {
			if (!listeners.contains(listener))
				listeners.add(listener);
		}
	};

	@Override
	public void addListeners(final List<DaemonEventListener> listeners) {
		synchronized (listeners) {
			for (DaemonEventListener listener : listeners) {
				if (!isListenerMatch(listener))
					continue;
				
				if (!listeners.contains(listener))
					this.listeners.add(listener);
			}
		}
	}
	
	@Override
	public void removeListener(DaemonEventListener listener) {
		synchronized (listeners) {
			listeners.remove(listener);
		}
	};

	@Override
	public void purgeListeners() {
		synchronized (listeners) {
			listeners.clear();
		}
	}
	
	@Override
	public void runASAP() {
		// 暂未实现
	};
	
	/**
	 * PosDaemon后台线程
	 */
	@Override
	abstract public void run();
	
	@Override
	public long getId() {
		return super.getId();
	}
	
	/**
	 * 屏蔽Thread.start方法, 应调用PosDaemon.startDaemon方法
	 */
	@Override
	@Deprecated
	public synchronized void start() {
		// do nothing!
	}
}
