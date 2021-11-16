package com.jiang.test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * accessOrder will put recently used last
 * @author  jiangzhiyu
 * @create 2021/11/16
 */
public class ProblemTwo extends LinkedHashMap<String,String> {

	private  int capacity;

	public ProblemTwo(int capacity){
		super(capacity, 0.75f , true);
		this.capacity = capacity;
	}

	public String get(String key){
		return super.get(key);
	}

	public String put(String key, String value){
		return super.put(key,value);
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<String,String> entry){
		return super.size() > capacity;
	}

	public static void main(String[] args) {
		ProblemTwo lruCache = new ProblemTwo(3);
		lruCache.put("1","a");
		lruCache.put("2","b");
		lruCache.put("3","c");
		lruCache.put("4","d");  // remove key 1
		lruCache.get("2");  //lru
		lruCache.put("5","e"); // remove key 3
		lruCache.forEach((s, s2) -> System.out.println("key:" + s + ",value:" + s2));
	}

	
}
