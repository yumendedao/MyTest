package cn.jiudao.swing;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Enumeration;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;


public class Login {
	
	public static Login window;
	private JFrame frame;
	public static JPasswordField pwd;
	public static JTextField userTF;
//	public static User user;

	// private static final String EXCHANGE_NAME = "IPOSBASIC";
	private static final String BASIC = "BASIC";
	private static final String BASICLOG = "BASICLOG";
	private static JButton updateBtn;
	private static JButton loginBtn;
	private String[] uppercase = new String[] { "Q", "W", "E", "R", "T", "Y",
			"U", "I", "O", "P", "↑", "A", "S", "D", "F", "G", "H", "J", "K",
			"L", "Z", "X", "C", "V", "B", "N", "M", "Enter", "空", "←" };
	private String[] lowercase = new String[] { "q", "w", "e", "r", "t", "y",
			"u", "i", "o", "p", "↑", "a", "s", "d", "f", "g", "h", "j", "k",
			"l", "z", "x", "c", "v", "b", "n", "m", "Enter", "空", "←" };
	private String[] keypad = new String[] { "7", "8", "9", "4", "5", "6", "1",
			"2", "3", "", "0", "重置" };
	private static JButton[] but = new JButton[30];
	private static JButton[] but_num = new JButton[12];

	private static Font font14 = new Font("微软雅黑", Font.PLAIN, 14);
	private static Font font16 = new Font("微软雅黑", Font.BOLD, 16);
	private static Font font18 = new Font("微软雅黑", Font.BOLD, 24);

	int flag;
	boolean isCap = false;
	boolean isOne = false;
//	public static volatile Pos defaultPos = null;
//	public static volatile Shop defaultShop = null;
	public static volatile boolean mqAvailable = false;

	// 开账打印模版
	public static String opentitle = "";
	public static Integer opentitlefronts = 12;
	public static Integer openbodyfonts = 0;
	public static Integer openendfonts = 0;
	public static boolean opentitlebold = false;
	public static boolean openbodybold = false;
	public static boolean openendbold = false;
	// 单据打印模版
	public static String billtitle = "";
	public static Integer billtitlefronts = 12;
	public static Integer billbodyfonts = 0;
	public static Integer billendfonts = 0;
	public static boolean billtitlebold = false;
	public static boolean billbodybold = false;
	public static boolean billendbold = false;
	public static String billendcomment = "";
	// 交班打印模版
	public static String shifttitle = "";
	public static Integer shifttitlefronts = 12;
	public static Integer shiftbodyfonts = 0;
	public static Integer shiftendfonts = 0;
	public static boolean shifttitlebold = false;
	public static boolean shiftbodybold = false;
	public static boolean shiftendbold = false;
	// 关账打印模版
	public static String closingtitle = "";
	public static Integer closingtitlefronts = 12;
	public static Integer closingbodyfonts = 0;
	public static Integer closingendfonts = 0;
	public static boolean closingtitlebold = false;
	public static boolean closingbodybold = false;
	public static boolean closingendbold = false;
	public static String netInfo;
	private static String mac = "";
//	private static final String UPDATE = "UPDATE";
	private String Main_test = "";
	
	public Login(){
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setUndecorated(true); // 去除边框
		((JPanel) frame.getContentPane()).setOpaque(false);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();

		ImageIcon img1;
		if("test".equals(Main_test )){
			img1 = new ImageIcon("img/login_test.jpg");
		}else{
			img1 = new ImageIcon("img/login.jpg");
		}
		JLabel bg = new JLabel(img1);// 每次导入即声明一个对象
		frame.getLayeredPane().add(bg, new Integer(-30000));
		bg.setBounds(0, 0, img1.getIconWidth(), img1.getIconHeight());

		frame.setBounds(0, 0, screenSize.width, screenSize.height);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel picL = new JLabel("");

		ImageIcon icon = new ImageIcon("img/tls.png");
		picL.setIcon(icon);
		picL.setBounds(57, 118, 591, 216);
		frame.getContentPane().add(picL);

		JPanel panel_key = new JPanel();
		panel_key.setOpaque(false);
		panel_key.setBounds(57, 359, 710, 216);
		frame.getContentPane().add(panel_key);
		panel_key.setLayout(new GridLayout(3, 10, 0, 0));

		// 左边的键盘区
		for (int k = 0; k < 30; k++) {
			final int m = k;
			but[m] = new JButton(lowercase[m]);
			but[m].setFocusable(false);
			if (m != 27) {
				but[m].setFont(font18);
			} else {
				but[m].setFont(font16);
			}
			but[m].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 切换大小写
					if (m == 10) {
						if (flag == 0)
							userTF.requestFocus();
						else
							pwd.requestFocus();
						if (isCap) {
							isCap = false;
							setSmall();
						} else {
							isCap = true;
							setCap();
						}
					} else if (m == 27) {// 回车键
						loginBtn.doClick();
					} else if (m == 28) {// 空格键
						if (flag == 0) {
							userTF.requestFocus();
							userTF.setText(userTF.getText() + " ");
						} else {
							pwd.requestFocus();
							pwd.setText(String.valueOf(pwd.getPassword()) + " ");
						}
					} else if (m == 29) {// 删除键
						if (flag == 0) {
							userTF.requestFocus();
							if (userTF.getText() == null
									|| userTF.getText().length() < 1)
								userTF.setText("");
							else
								userTF.setText(userTF.getText().substring(0,
										userTF.getText().length() - 1));
						} else {
							pwd.requestFocus();
							if (String.valueOf(pwd.getPassword()) == null
									|| String.valueOf(pwd.getPassword())
											.length() < 2)
								pwd.setText("");
							else
								pwd.setText(String.valueOf(pwd.getPassword())
										.substring(
												0,
												String.valueOf(
														pwd.getPassword())
														.length() - 1));
						}
					} else {
						if (flag == 0) {
							userTF.requestFocus();
							userTF.setText(userTF.getText() + but[m].getText());
						} else {
							pwd.requestFocus();
							pwd.setText(String.valueOf(pwd.getPassword())
									+ but[m].getText());
						}
					}
				}
			});
			panel_key.add(but[m]);
		}

		JPanel panel_num = new JPanel();
		panel_num.setOpaque(false);
		panel_num.setBounds(777, 359, 209, 216);
		frame.getContentPane().add(panel_num);
		panel_num.setLayout(new GridLayout(4, 3, 0, 0));

		for (int k = 0; k < 12; k++) {
			final int m = k;
			but_num[m] = new JButton(keypad[m]);
			but_num[m].setFocusable(false);
			but_num[m].setFont(font18);
			but_num[m].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (flag == 0) {
						userTF.requestFocus();
						userTF.setText(userTF.getText() + but_num[m].getText());
					} else {
						pwd.requestFocus();
						pwd.setText(String.valueOf(pwd.getPassword())
								+ but_num[m].getText());
					}
					if (m == 11) {
						userTF.requestFocus();
						userTF.setText("");
						pwd.setText("");
					}
				}
			});
			panel_num.add(but_num[m]);
		}
		but_num[11].setFont(font16);
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setBounds(675, 118, 311, 216);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		userTF = new JTextField();
		userTF.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {

			}

			public void focusGained(FocusEvent e) {
				flag = 0; // 用户名域
			}
		});
		userTF.setBounds(105, 45, 140, 35);
		panel_2.add(userTF);
		userTF.setColumns(10);
//		setupAutoComplete(userTF);

		pwd = new JPasswordField();
		pwd.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
			}

			public void focusGained(FocusEvent e) {
				flag = 1; // 密码域
			}
		});
		pwd.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent event) {
				if (event.getKeyChar() == '\n') {
					if (posAdminCheck(userTF.getText().trim(),
							String.valueOf(pwd.getPassword()).trim())) {
						System.out.println("按下了回车键");
//						new Main(false);
						frame.dispose();
					} else {
						check();
					}
				}
			}
		});

		pwd.setBounds(105, 84, 140, 35);
		panel_2.add(pwd);
		pwd.setColumns(10);

		updateBtn = new JButton("更新");
		updateBtn.setFont(font14);
		updateBtn.setBackground(new Color(46, 139, 87));
		updateBtn.setBounds(182, 132, 63, 36);
		updateBtn.setOpaque(false);
		if("test".equals(Main_test)){
			updateBtn.setEnabled(false);
		}
		panel_2.add(updateBtn);
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onManualUpdate();
			}
		});

		JButton button_1 = new JButton("退出");
		button_1.setFont(font14);
		button_1.setBackground(new Color(240, 255, 255));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Logging.info("退出系统");
//				if (Util.os.startsWith("windows")){
//					dosShutdown();//执行此句话将在dos系统下，3庙内自动关机
//				}else if(Util.os.startsWith("mac")){
//					linShutdown();//linux下自動關機
//				}else{
//					linShutdown();//linux下自動關機
//				}
				System.exit(0);
			}
		});
		button_1.setBounds(97, 132, 63, 36);
		panel_2.add(button_1);

		loginBtn = new JButton("登录");
		loginBtn.setFont(font14);
		loginBtn.setBackground(new Color(240, 255, 255));
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				if (posAdminCheck(userTF.getText().trim(),
//						String.valueOf(pwd.getPassword()).trim())) {
//					loggerinfo.info(userTF.getText().trim() + "正在进行基础配置");
//					new Main(false);
//					frame.dispose();
//				} else {
//					check();
//				}
//				__elapsed("login-click");
				WaitBox.show("正在登录, 请稍候...");
				new Thread(new Runnable() {
					public void run() {
//						__elapsed("waitbox-thread-start");
						try {
							check();
						} finally {
							WaitBox.close();
						}
					}
				}).start();
			}
		});
		loginBtn.setBounds(10, 132, 63, 36);
		panel_2.add(loginBtn);

		JLabel version = new JLabel("v1.0.1");
		version.setForeground(Color.WHITE);
		version.setBounds(20, 198, 54, 15);
		panel_2.add(version);

//		Util.setColors(panel_key, new Color(245, 245, 220), new Color(0, 0, 0));
//		Util.setColors(panel_num, new Color(245, 245, 220), new Color(0, 0, 0));

	}
	
	/**
	 * @param fontName
	 * @param style
	 * @param size
	 *
	 *            初始化系统字体
	 */
	public static void initGlobalFontSetting(String fontName, int style, int size) {
		Font fnt = new Font(fontName, style, size);
		FontUIResource fontRes = new FontUIResource(fnt);
		for (Enumeration<?> keys = UIManager.getDefaults().keys(); keys
				.hasMoreElements();) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof FontUIResource)
				UIManager.put(key, fontRes);
		}
	}
	
	public void setCap() {
		for (int i = 0; i < 30; i++) {
			but[i].setText(uppercase[i]);
		}
	}

	public void setSmall() {
		for (int i = 0; i < 30; i++) {
			but[i].setText(lowercase[i]);
		}
	}

	private boolean posAdminCheck(String user, String pwd) {
		if (user.trim().equals("posadmin") && pwd.trim().equals("posadmin123")) {
			return true;
		}
		return false;
	}
	
	/**
	 * 验证登入用户
	 */
	public void check() {
//		user = loginCheck(userTF.getText().trim(),
//				String.valueOf(pwd.getPassword()).trim());
//		if (user == null) {
//			Util.showMessageDialog(NoticeMSG.SALE_N0302);
//			return;
//		}
//		
//		Shift shift = ShiftService.getShift();
//		if (shift != null) {
//			if (shift.getClosetime() == null) {
//				if (!user.getId().equals(shift.getShiftuser())) {
//					User user = UserService.getuser(shift.getShiftuser());
//					Util.showMessageDialog(user == null ? "其他人员未交班" : user.getFullname() + "未交班");
//					return;
//				}
//			}
//		}
//
//		if (defaultShop == null) {
//			Util.showMessageDialog(NoticeMSG.SALE_N0304);
//			loggerinfo.info(NoticeMSG.SALE_N0304);
//			return;
//		}
//		if (defaultPos == null) {
//			Util.showMessageDialog(NoticeMSG.SALE_N0305);
//			loggerinfo.info(NoticeMSG.SALE_N0305);
//			return;
//		} else if (!defaultPos.getMac().equals(mac)) {
//			Util.showMessageDialog("当前POS机MAC地址(" + mac + ")与服务器不匹配,基础数据将无法更新");
//			loggerinfo.info(NoticeMSG.SALE_N0306 + "(" + mac + ")");
//		}
//		
//		AbstractBill.setShop(Login.defaultShop);
//		AbstractBill.setPos(Login.defaultPos);
//		AbstractBill.setOper(Login.user);
//		
//		//读取主档数据, 缓存在内存中
//		loadCache();
//		
//		Client.openClient();
//		
//		frame.dispose();
//		loggerinfo.info(Login.user.getFullname() + "登录了系统");
	}
	
	protected static void onManualUpdate() {
//		Thread t;
//		final Map<String, Object> up = new HashMap<String, Object>();
//		up.put("shop", Login.defaultShop.getCode());
//		up.put("pos", Login.defaultPos.getCode());
//		up.put("mac", Login.defaultPos.getMac());
//		
//		loggerinfo.info("开始手动更新数据...");
//		WaitBox.show("正在更新...");
//		
//		t = new Thread(new Runnable() {
//			public void run() {
//				Delegate callback, notice; 
//				
//				callback = new Delegate() {
//					public void invoke(Object... params) {
//						Channel ch = (Channel) params[0];
//						Delivery d = (Delivery) params[1];
//						BasicUpdateLog log = null;
//						byte[] data = null;
//						JsonObject el;
//						Date start = new Date();
//						
//						// 默认UTF-8编码
//						el = JsonUtil.parse(d.getBody()).getAsJsonObject();
//						if (Main.backupBasic)
//							IOUtil.saveFile("json/BASIC_" + StringUtil.fileFormat.format(new Date()) + ".json", d.getBody());
//						
//						log = new BasicUpdateLog();
//						log.setShop(Login.defaultShop.getCode());
//						log.setPos(Login.defaultPos.getCode());
//						log.setMac(Login.defaultPos.getMac());
//						log.setDataSize(d.getBody().length);
//						log.setLogId(el.get("logId").getAsInt());
//						log.setCurrctime(new Date(el.get("currctime").getAsLong()));
//						log.setCurrutime(start);
//						
//						log = MQUpdate.updateMasterData(log, el);
//						log.setElapsed((int) (new Date().getTime() - start.getTime()));
//						
//						if (1 == log.getSuccess()) {
//							loggerinfo.info("数据处理成功! " + "数据ID: " + log.getLogId() + ", 数据长度: " 
//									+ Util.doubleToString(log.getDataSize() / 1024D, 2) + ", 耗时: " + (new Date().getTime() - start.getTime()) + "ms");
//						} else {
//							loggererror.error("发送更新回执失败! " + "数据ID: " + log.getLogId() + ", 数据长度: " 
//									+ Util.doubleToString(log.getDataSize() / 1024D, 2));
//						}
//						
//						try {
//							data = JsonUtil.g.toJson(log).getBytes("UTF-8");
//							
//							if (Main.backupBasic)
//								IOUtil.saveFile("json/BASICLOG_" + StringUtil.fileFormat.format(new Date()) + ".json", data);
//							
//							ch.basicPublish("", BASICLOG, null, data);
//						} catch (Exception ex) {
//							throw new PosMQException("发送更新回执失败!", ex);
//						}
//					}
//				};
//				
//				notice = new Delegate() {
//					public void invoke(Object... params) {
//						int i;
//						i = (int) params[0];
//						WaitBox.show("正在更新数据... 第" + (i + 1) + "次尝试");
//					}
//				};
//				
//				MQHelper.publish(null, true, null, false, null, null, "UPDATE", up, true, 15000, 3, callback, notice);
//				WaitBox.close();
//			}
//		});
//		
//		t.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
//			public void uncaughtException(Thread t, Throwable ex) {
//				String msg;
//				WaitBox.close();
//				
//				Util.logError(ex.getMessage(), ex);
//				
//				if (ex instanceof PosMQException)
//					msg = ErrorMSG.MQ_E0204;
//				else 
//					msg = ErrorMSG.MQ_E0204;
//				
//				Util.showModalMassageBox(msg);
//			}
//		});
//		
//		t.start();
	}
	
	public static void openLoginClient() {
		window = new Login();
		window.frame.setVisible(true);
		
		WaitBox.show("正在初始化...");
		new Thread(new Runnable() {
			public void run() {
				try {
//					Session.setFactory();
//					mac = Util.getMacAddress();
					//to debug without switch mq
//					defaultPos = PosService.getSalePos();
//					defaultShop = ShopService.getShop();
//					updateCheck();
				} finally {
					WaitBox.close();
				}
			}
		}).start();
	}
}
