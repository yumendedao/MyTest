package cn.jiudao.statics;

public class UIConstant {


	public static String posCode = "";
	public static String shopCode = "";
	public static String linedisplayCom = "";
	
	//mq login
	public static String serverIP = "localhost";
	public static String userName = "testuser";
	public static String passwd = "testuser";
	public static String vHost = "testhost";
	
	//debug 
	public static boolean disableTimeDaemon = false;		//是否禁用后台守护线程
	public static boolean disableBillCountDaemon = false;
	public static boolean disableMQDaemon = false;
	public static boolean backupBasic = false;				//是否启用更新数据json文件备份
	public static String timeSyncKey = "";					//pos时间同步mq通道key
	public static int timeAdjust = 0;
	
	public static String printCom = "/dev/ttyS0";
	public static Integer printBR = 9600;
	public static String printname = "";// usb票据打印NCR 7197 Receipt
	public static String iscomprint = ""; // 票据打印是否为串口打印
	public static String pro = "0"; // 默认促销提醒不开启
	protected static String showprice = "0"; // 显示商品下的单价 1为显示

	public static String test = "";

	protected static String width;
	protected static String heigth;
	
}
