package com.zhuyin.threadpool.callable;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<Map<String, Object>> {

	@Override
	public Map<String, Object> call() {
		Map<String, Object>retMap = Maps.newHashMap();
		retMap.put("stt", 0);
		retMap.put("msg", "成功");
		return retMap;
	}

}
