package cn.jiudao.swing;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Paint;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel {

    private static final long serialVersionUID = -6352788025440244338L;

    private ImageIcon image = null;

    public BackgroundPanel(ImageIcon image) {
        this.image = image;
    }
    int x = 0 ,y = 0;
    
    // 固定背景图片，允许这个JPanel可以在图片上添加其他组件
    final int R = 66;  
    final int G = 194;  
    final int B = 110;
    final Paint p = new GradientPaint(0.0f, 0.0f, new Color(R, G, B, 100),  
            getWidth(), getHeight(), new Color(R, G, B, 200), true);  
    protected void paintComponent(Graphics g) {
    	g.drawImage(image.getImage(), x, y, this.getWidth(), this.getHeight(), this);
    }
}
