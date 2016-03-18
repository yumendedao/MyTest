package com.mytest.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

// 测试失败
public class TestThread {

	private static SimpleDateFormat sdf = new SimpleDateFormat("ss");
	// private static SimpleDateFormat sdf2 = new SimpleDateFormat("hh:MM:ss");

	private static Object lockObject = 0;

	private static int waitBoxWait = 4;
	private static int bizWait = 3;
	private static int mainWait = 1;
	// private static long mainSleep = 10;
	private static int lockWait = 15;

	public static void main(String[] args) {

		System.out.println("thread1 main  start  time=" + time());

		final Thread waitBoxThread = new Thread(new Runnable() {
			public void run() {
				System.out.println("witeBox start time=" + time());
				sleep(waitBoxWait);
				System.out.println("witeBox end 执行了" + waitBoxWait + "秒的cord time=" + time());
			}
		});

		Thread bizThread = new Thread(new Runnable() {
			public void run() {
				System.out.println("bizThread start  time=" + time());
				synchronized (lockObject) {
					System.out.println("bizThread 得到锁  time=" + time());
//					sleep(bizWait);
					try {
						System.out.println("bizThread  end  唤醒主线程   lockObject.notify()  在锁释放前   执行了" + bizWait + "秒的code   time=" + time());
						lockObject.notify();
					} catch (IllegalMonitorStateException e) {
						e.printStackTrace();
					}
				}

			}
		});
		
		
		synchronized (lockObject) {
			System.out.println("main 获得锁");
			waitBoxThread.start();
			bizThread.start();

			System.out.println("lockObject  wait start 对象锁等待" + lockWait + "   time=" + time());
			try {
				lockObject.wait(lockWait * 1000);
//				Thread.currentThread().wait(lockWait * 1000);
				// lockObject.notify();
				System.out.println();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("lockObject wait end 对象锁  time=" + time());

			// waitBoxThread.abort();
//			sleep(mainWait);
//			if (waitBoxThread.isAlive()) {
//				System.out.println("waitBoxThread  未结束，强制中断");
				waitBoxThread.interrupt();
//				System.out.println("waitBoxThread  中断 temi=" + time());
//			} else {
//				System.out.println("waitBoxThread  已经结束，不需要中断");
//			}
		}

		System.out.println("main  end  time=" + time());
	}

	private static String time() {
		Date currentDate = new Date(System.currentTimeMillis());
		return sdf.format(currentDate);
	}

	private static void sleep(int second) {
		try {
			TimeUnit.SECONDS.sleep(second);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private static void sleep(Thread thread, int second) {
		try {
			TimeUnit.SECONDS.sleep(second);
			System.out.println(thread.getName() +"  sleep " + second +" 秒");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
