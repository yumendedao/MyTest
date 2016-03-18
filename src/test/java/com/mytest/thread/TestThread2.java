package com.mytest.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TestThread2 {

	private static SimpleDateFormat sdf = new SimpleDateFormat("ss");
	// private static SimpleDateFormat sdf2 = new SimpleDateFormat("hh:MM:ss");

	private static ReentrantLock lock = new ReentrantLock();

	private static int waitBoxCodeTime = 4;
	private static int bizCodeTime = 4;
	private static int mainWait = 3;
//	private static long mainSleep = 10;
//	private static int lockWait = 5;
	private static Thread waitBoxThread;
	private static Thread bizThread;
//	private static Thread mainThread;

	public static void main(String[] args) {
		System.out.println("thread1 main  start  time=" + time());
		initThread();

		testLock();
		System.out.println("main  end  time=" + time());
	}

	private static void initThread() {
//		mainThread = Thread.currentThread();
		waitBoxThread = new Thread(new Runnable() {
			public void run() {
				System.out.println("witeBox start time=" + time());
				sleep(waitBoxThread, waitBoxCodeTime);
				System.out.println("witeBox end 执行了" + waitBoxCodeTime + "秒的cord time=" + time());
			}
		});
		bizThread = new Thread(new Runnable() {
			public void run() {
				System.out.println("bizThread start  time=" + time());
				System.out.println("bizThread 加锁");
				try {
					lock.lock();
					sleep(bizThread, bizCodeTime);
					System.out.println("bizThread  执行了" + bizCodeTime + "秒的code   time=" + time());
				} finally {
					System.out.println("bizThread end lock解锁 time=" + time());
					lock.unlock();
				}
			}
		});
	}

	private static void testLock() {
		try {
			// System.out.println("lock加锁");
			// lock.lock();
			waitBoxThread.start();
			bizThread.start();

			// 等待5秒，不论waitThread是否结束，都继续主线程
			if (!lock.tryLock(mainWait, TimeUnit.SECONDS)) {
				System.out.println("main 等待了 " + mainWait + "秒，lock未解锁，不再等待，直接解锁，并中断waitThread");
				bizThread.interrupt();
//				lock.unlock();
				lock.lock();
				System.out.println();
			} else {
				System.out.println("在指定的等待时机 " + mainWait + "秒内，获得了锁,main  继续");
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println("main  lock 解锁");
			System.out.println(lock.isLocked());
			if(lock.isLocked())
				lock.unlock();
		}
	}

	private static String time() {
		Date currentDate = new Date(System.currentTimeMillis());
		return sdf.format(currentDate);
	}

//	private static void sleep(int second) {
//		try {
//			TimeUnit.SECONDS.sleep(second);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}

	private static void sleep(Thread thread, int second) {
		try {
			TimeUnit.SECONDS.sleep(second);
			System.out.println(thread.getName() + "  sleep " + second + " 秒");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
