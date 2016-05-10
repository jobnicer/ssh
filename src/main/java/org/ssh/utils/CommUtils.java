package org.ssh.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.ssh.common.entity.DTO;

/**
 * 
 * 工程中使用到的工具
 * 
 * @author xj
 * 
 * @date 2010-6-1
 * 
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class CommUtils {

	/**
	 * @Title: getSysDateStr
	 * @Description: 获取当前的系统时间
	 * @param format
	 * @return
	 */
	public static String getSysDateStr(String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		// 获取系统时间
		Date date = new Date();
		String strResult = sdf.format(date);
		return strResult;
	}

	/**
	 * 将Date型对象转换成指定格式 YYYY/MM/DD HH:MM:SS
	 * 
	 * @param date
	 * @return
	 */
	public static String chgDateToStrYmdhms(Date date) {

		if (date == null) {
			return "";
		}

		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String strResult = format.format(date);
		return strResult;

	}

	/**
	 * 将Date型对象转换成指定格式 YYYY/MM/DD
	 * 
	 * @param date
	 * @return
	 */
	public static String chgDateToStrYmd(Date date) {

		if (date == null) {
			return "";
		}

		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		String strResult = format.format(date);
		return strResult;

	}

	/**
	 * 将Date型对象转换成指定格式 HH:MM:SS
	 * 
	 * @param date
	 * @return
	 */
	public static String chgDateToStrHms(Date date) {

		if (date == null) {
			return "";
		}

		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		String strResult = format.format(date);
		return strResult;

	}

	/**
	 * 将String类型转换成Date类型对象
	 * 
	 * @param strDate
	 * @return
	 * @throws
	 */
	public static Date chgStrToDate(String strDate) {
		Date dateTmp = null;
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
			if (strDate.indexOf("-", 0) != -1) {
				if (strDate.length() <= 10) {
					simpleDateFormat.applyPattern("yyyy-MM-dd");
				} else {
					String strTemp[] = strDate.split(":");
					if (strTemp.length < 3) {
						simpleDateFormat.applyPattern("yyyy-MM-dd HH:mm");
					} else {
						simpleDateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
					}
				}
			} else if (strDate.indexOf("/", 0) != -1) {
				if (strDate.length() <= 10) {
					simpleDateFormat.applyPattern("yyyy/MM/dd");
				} else {
					String strTemp[] = strDate.split(":");
					if (strTemp.length < 3) {
						simpleDateFormat.applyPattern("yyyy/MM/dd HH:mm");
					} else {
						simpleDateFormat.applyPattern("yyyy/MM/dd HH:mm:ss");
					}
				}
			}
			dateTmp = simpleDateFormat.parse(strDate);
		} catch (ParseException e) {

		}
		return dateTmp;
	}

	/**
	 * 根据指定格式转化Date
	 * 
	 * @param strDate
	 * @param format
	 *            指定转换格式
	 * @return
	 * @throws Exception
	 */
	public static String getFormatDate(Date date, String format) {
		String dateStrTmp = null;
		try {
			if (format == "")
				format = "yyyy/MM/dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
			dateStrTmp = simpleDateFormat.format(date);
		} catch (Exception e) {

		}
		return dateStrTmp;
	}

	/**
	 * 判断传入字符是否是Ip地址
	 * 
	 * @param ipaddress
	 * @return
	 */
	public static boolean isIpaddress(String ipaddress) {
		String regexp = "[0,255]{1,3}\\.[0,255]{1,3}\\.[0,255]{1,3}\\.[0,255]{1,3}";
		Pattern pattern = Pattern.compile(regexp);
		Matcher matcher = pattern.matcher(ipaddress);
		return matcher.matches();
	}

	/**
	 * 判断传入字符是否为数字
	 * 
	 * @param strNumber
	 * @return
	 */
	public static boolean isNumber(String strNumber) {
		if (strNumber == null || "".compareTo(strNumber) == 0) {
			return false;
		}
		return StringUtils.isNumeric(strNumber);
	}

	/**
	 * Object对象转换为String
	 * 
	 * @param obj
	 * @return 转换后的字符串
	 */
	public static String chgObjToStr(Object obj) {
		return (obj == null) ? "" : obj.toString();
	}

	/**
	 * String对象转换为int型
	 * 
	 * @param Str
	 * @return 转换后的int数
	 */
	public static int chgStrToInt(String str) {
		return isNotNull(str) ? Integer.parseInt(str) : 0;
	}

	/**
	 * 判断传入的字符串是否为空
	 * 
	 * @param paramValue
	 *            转入需要判断的字符串
	 * @return 字符串为空则true反之false
	 */
	public static boolean isNotNull(String paramValue) {
		boolean ret = true;

		if (paramValue == null || paramValue.length() == 0) {
			ret = false;
		}

		return ret;
	}

	/**
	 * @Title: chgArrayToStr
	 * @Description: 将数组转换为字符串
	 * @param array
	 * @param joinkey
	 * @return
	 */
	public static String chgArrayToStr(Object[] array, String joinkey) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < array.length; i++) {
			if (i + 1 == array.length) {
				sb.append(array[i]);
			} else {
				sb.append(array[i]);
				sb.append(joinkey);
			}
		}
		return sb.toString();
	}

	/**
	 * @Title: chgArrayToList
	 * @Description: 将数组转换为列表
	 * @param array
	 * @return
	 */
	public static ArrayList chgArrayToList(Object[] array) {
		List list = Arrays.asList(array);
		return (new ArrayList(list));
	}

	/**
	 * @Title: getDtoValue
	 * @Description: 根据KEY值获取DTO中存放的值(String型)
	 * @param dto
	 * @param key
	 * @return
	 */
	public static String getDtoValue(DTO dto, String key) {
		Object obj = dto.get(key);
		if (obj == null) {
			return "";
		}
		if (obj.getClass().isArray()) {
			Object[] array = (Object[]) obj;
			return (String) array[0];

		} else {

			return (String) obj;
		}
	}

	/**
	 * @Title: getDtoValue
	 * @Description: 根据KEY值获取DTO中存放的值（原始类型）
	 * @param dto
	 * @param key
	 * @return
	 */
	public static Object getDtoRealValue(String key, DTO dto) {
		Object obj = dto.get(key);
		if (obj == null) {
			return "";
		}
		if (obj.getClass().isArray()) {
			Object[] array = (Object[]) obj;
			return array[0];

		} else {
			return obj;
		}
	}

	/**
	 * 写审计工具方法
	 * 
	 * @return
	 */
	/*public static Exception writeActionaudit(String table, String type,
			String content, CommonDao commonDao) {
		ImfActionaudit aa = new ImfActionaudit();
		aa.setActiontable(table);
		aa.setActiontime(new Date());
		aa.setActiontype(type);
		aa.setDscription(content);
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null) {
			aa.setUsername(session.getAttribute("user").toString());
		} else {
			aa.setUsername("未知账号");
		}
		if (session.getAttribute("clientIp") != null) {
			aa.setIp(session.getAttribute("clientIp").toString());
		} else {
			aa.setIp("未知IP");
		}

		try {
			commonDao.save(aa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e;

		}
		return null;

	}*/
}
