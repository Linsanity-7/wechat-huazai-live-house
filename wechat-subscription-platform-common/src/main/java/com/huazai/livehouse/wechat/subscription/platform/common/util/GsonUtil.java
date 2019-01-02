package com.huazai.livehouse.wechat.subscription.platform.common.util;


import com.google.gson.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * Gson工具类
 *
 * @author 林尚华
 */
public class GsonUtil {
	private static Logger logger = LoggerFactory.getLogger(GsonUtil.class.getName());
	static private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

	public static String obj2Json(Object obj) {
		try {
			return gson.toJson(obj);
		} catch (Exception e) {
			logger.error("", e);
		}
		return null;
	}

	public static <T> T json2Obj(String json, Class<T> c) {
		try {
			if (json == null || json.isEmpty()) {
				return null;
			}
			return gson.fromJson(json, c);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("", e);
			return null;
		}
	}

	static public <T> ArrayList<T> json2List(String str, final Class<T> c) {
		if (str == null || str.isEmpty()) {
			return null;
		}
		try {
			JsonArray array = new JsonParser().parse(str).getAsJsonArray();
			ArrayList<T> list = new ArrayList<T>();
			for (final JsonElement elem : array) {
				list.add(gson.fromJson(elem, c));
			}
			return list;
		} catch (Exception e) {
			logger.error("", e);
			return null;
		}
	}
}
