package ssh;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.ssh.utils.MyLog;

public class LogTest {
	
	private  final static String TEST_INFO = "测试信息";
	
	private  final static Logger logger =  LoggerFactory.getLogger("");
	
	private static String format(String template, Object... values) {
	        return String.format(template.replace("{}", "%s"), values);
	    }

	public static void main(String[] args) {
//		System.out.println(LogTest.format("{}输出成功！", LogTest.TEST_INFO));
		int a = 3;
		int b = 0;
		try {
			float c = a/b;
			System.out.println(c);
		} catch (Exception e) {
//			MyLog.error("除数为0");
			MyLog.error("除数为0",e);
//			MyLog.error(e, "{}除数为0{}", TEST_INFO, TEST_INFO);
//			logger.error(e.getMessage(),e);
//			logger.error("hello","a");
			MyLog.error("aa");
		}
	}
}
