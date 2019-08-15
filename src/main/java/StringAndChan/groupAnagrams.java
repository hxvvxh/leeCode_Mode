package StringAndChan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import hp.base.BaseCode;
/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
 * @author Administrator
 *
 */
public class groupAnagrams extends BaseCode<String[],List<List<String>>>{

	@Override
	public List<List<String>> exceute(String[] obj) {
		
		Map<String,List<String>> map=Maps.newHashMap();
		ArrayList<String> objLis=Lists.newArrayList(obj);
	
		objLis.forEach(c->{
			//记录原始值
			String charbef=c;
			
			char[] charLis=c.toLowerCase().toCharArray();
			Arrays.sort(charLis);
			//排序之后的Str对象
			String sortStr=String.valueOf(charLis);
			//判断排序后 map中是否存在结果
			if(map.containsKey(sortStr)) {
				List l=map.get(sortStr);
				l.add(charbef);
				//存在 说明有相同的值 放入list中
				map.put(sortStr,l);
				
			}else {
				List list=Lists.newArrayList();
				list.add(charbef);
				//不存在则创建list放入
				map.put(sortStr,list);
			}
		});
		ArrayList<List<String>> ls=Lists.newArrayList();
		map.values().forEach(c->ls.add(c));
		
		//返回前输出
		outPut(ls);
		return ls;
	}

}
