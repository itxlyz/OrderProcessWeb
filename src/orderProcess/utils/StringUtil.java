package orderProcess.utils;

public class StringUtil {
	/**
	 * 去除指定字符串中首尾不可见字符.
	 * @param str
	 * @return 更新后的字符串
	 */
	public static String trim(String str) {
		return (str != null ? str.trim() : null);
	}

}

