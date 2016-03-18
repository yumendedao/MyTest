package cn.jiudao.statics;

import java.util.Date;

/**
 * jwms-client-swing:cn.jiudao.statics.Application
 * @ClassName: Application
 * @Description 全局变量
 * @author guxingchun
 * @date 2015年8月31日 下午2:12:22
 */
public class Application {
	
	public static final String bizNamespace = "pcsc";
	
	public static volatile Long timeDiff = 0L;
	public static Date getServerTime() {
		synchronized(timeDiff) {
			Date now = new Date();
			return new Date(now.getTime() + timeDiff);
		}
	}
}
