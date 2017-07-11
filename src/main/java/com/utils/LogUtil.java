package com.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Name:LogUtil
 * Desc:返回指定名称日志
 * @author zhu
 * @date 2016年5月24日
 */
public class LogUtil {
	/**
	 * Desc:TODO
	 * @author zhu
	 * @date 2016年5月24日
	 */
	public static Log getLog(String logName){
		return LogFactory.getLog(logName);
	}
}
