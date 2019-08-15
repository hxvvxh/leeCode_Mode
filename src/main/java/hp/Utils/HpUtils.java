package hp.Utils;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multiset;

public class HpUtils {

	
	
	
	public static void outMap(Object map,String mess) {
		System.out.println("*********"+mess+"*********");
		if(map instanceof Map) {
			((Map) map).forEach((k,v)->{
				System.out.println("key:"+k+"********"+"value："+v);
			});
		}else if(map instanceof Multimap){
			((Multimap) map).asMap().forEach((k,v)->{
				System.out.println("key:"+k+"********"+"value："+v);
			});
		}
		
	}
	
	public static void outList(Object list,String mess) {
		System.out.println("*********"+mess+"*********");
		if(list instanceof List) {
			((List) list).forEach(c->{
	        	System.out.println(c);
	        });
		}else {
			System.out.println("******************");
		}
	}
	
	public static void outSet(Object set,String mess) {
		System.out.println("*********"+mess+"*********");
		if(set instanceof Set) {
			((Set) set).forEach(c->{
	        	System.out.println(c);
	        });
		}else if(set instanceof Multiset){
			((Multiset) set).forEach(c->{
				System.out.println(c);
			});
		}
	}
	
	public static Map<Integer,String> createMap(int i) {
		Map map=Maps.newHashMap();
		for(int j=0;j<i;j++) {
			map.put(j,String.valueOf(j));
		}
		return map;
	}
	
	public static Multimap<Integer,String> createMultiMap(int i) {
		Multimap<Integer,String> map=ArrayListMultimap.create();
		for(int j=0;j<=i;j++) {
			for(int k=0;k<=j;k++) {
				map.put(j,String.valueOf(k));	
			}
		}
		return map;
	}
	
	
	public static Multiset createSet(int i) {
		Multiset<Integer> set=HashMultiset.create();
		for(int j=0;j<=i;j++) {
			set.add(j, j);
		}
		return set;
	}
	
	
}
