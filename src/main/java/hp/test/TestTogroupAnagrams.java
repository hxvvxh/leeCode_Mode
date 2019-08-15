package hp.test;

import java.util.List;

import org.testng.annotations.Test;

import StringAndChan.groupAnagrams;
import hp.base.Base;
import hp.base.BaseHpTest;


public class TestTogroupAnagrams extends BaseHpTest<String[], List<List<String>>,groupAnagrams> {



	@Override
	public String[] CreateIdinfer() {
		return new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
	}

	@Override
	public List<List<String>> Run(groupAnagrams u) throws Exception {
		return super.Run(u);
	}


	
	



}
