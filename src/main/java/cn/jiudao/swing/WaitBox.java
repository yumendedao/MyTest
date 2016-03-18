package cn.jiudao.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;


public class WaitBox extends JDialog {

	private static final long serialVersionUID = -2786597628692902088L;
	
	private static WaitBox box = null;
	private static volatile boolean rolling = false;
	
	private WaitBox() {
		super();
		init();
	}
	
	JProgressBar bar;
	JLabel label;
	private void init() {
		ImageIcon img;
		BackgroundPanel panel;
		Rectangle rect = null;
//		rect = SwingUtil.getFrameBounds(FrameShowAt.FIRST_SCREEN);
		super.setBounds(Double.valueOf(rect.getWidth()).intValue() / 2 - 260, 
				Double.valueOf(rect.getHeight()).intValue() / 2 - 141, 522, 282);
		super.setUndecorated(true);
		super.setAlwaysOnTop(true);
		super.getContentPane().setLayout(null);

		img = new ImageIcon("img/update.png");
		panel = new BackgroundPanel(img);
		panel.setBounds(0, 0, 521, 282);
		panel.setLayout(null);
		
		bar = new JProgressBar(JProgressBar.HORIZONTAL);
		bar.setBounds(157, 169, 195, 14);
		bar.setIndeterminate(false);
		bar.setStringPainted(false);
		bar.setMinimum(0);
		bar.setMaximum(100);
		bar.setValue(0);
		
		label = new JLabel();
		label.setForeground(new Color(0, 128, 0));
		label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setAlignmentX(LEFT_ALIGNMENT);
		label.setBounds(20, 193, 480, 29);
		
		panel.add(bar);
		panel.add(label);
		super.getContentPane().add(panel);
		
		this.addMouseListener(new MouseListener() {
			boolean roll = true;
			public void mouseReleased(MouseEvent e) { }
			public void mousePressed(MouseEvent e) { }
			public void mouseExited(MouseEvent e) { }
			public void mouseEntered(MouseEvent e) { }
			
			public void mouseClicked(MouseEvent e) {
				if (roll) {
					stopRoll();
				} else {
					startRoll();
				}
				roll = !roll;
			}
		});
	}
	
	private void startRoll() {
		bar.setIndeterminate(true);
		bar.setValue(0);
		rolling = true;
	}
	
	private void stopRoll() {
		bar.setIndeterminate(false);
		bar.setValue(100);
		bar.updateUI();
	}
	
	private static WaitBox getBox() {
		if (box == null)
			box = new WaitBox(); 
		return box; 
	}
	
	
	/**
	 * 显示进度条窗口
	 * @author wangwj<br>2015年3月13日
	 * @param text
	 */
	public static void show(String text) {
		WaitBox b;
		close();
		
		b = getBox();
		b.label.setText(text);
		b.setVisible(true);
		b.startRoll();
		rolling = true;
	}
	
	/**
	 * 隐藏进度条窗口
	 * @author wangwj<br>2015年3月13日
	 */
	public static void close() {
		if (!rolling) return;
		
		getBox().stopRoll();
		getBox().setVisible(false);
		getBox().dispose();
		rolling = false;
	}
	
	
	public static void main(String[] args) {
		WaitBox.show("updating master data ...");
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("closing");
				WaitBox.close();
			}
		}).start();
	}
	
	
	/*
	public static void main(String[] args) {
		
		Runnable t1, t2;
		
		t1 = new Runnable() {
			public void run() {
				try {
					show("aaa");
					Thread.sleep(3000);
					if (1 == 1)
						throw new RuntimeException();
					System.out.println("a1");
				} catch (Exception ex) {
					System.out.println("a3");
				} finally {
					System.out.println("a2");
					close();
				}
				
				show("bbb");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				close();
			}
		};
		
		new Thread(t1).start();
	}
	*/
}
