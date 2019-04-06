package com.zhuyin.threadpool.callable;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<Map<String, Object>> {

	public Map<String, Object> call() throws Exception {
		Map<String, Object>retMap = new HashMap<String, Object>();
		retMap.put("stt", "00");
		retMap.put("msg", "成功");
		return retMap;
	}

}
