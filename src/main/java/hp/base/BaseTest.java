package hp.base;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import hp.Utils.HpUtils;

/**
 * 统一 的测试接口
 * @author Administrator
 *
 */
public abstract class BaseTest<T,V> implements Base<T,V>{
	private static Logger log=Logger.getLogger(BaseTest.class);
	/**
	 * 数据输出
	 */
	public void outPut(Object o){
		try {
			if(o instanceof List) {
				HpUtils.outList((List)o, "List输出结果为");
			}else if(o instanceof Map) {
				HpUtils.outMap((Map)o, "Map输出结果为");
			}else  if(o instanceof Set) {
				HpUtils.outSet((Set)o, "Set输出结果为");
			}
			else {
				new RuntimeException("不支持的输出类型");
			}
		}catch(Exception ex) {
			log.error("输出是报错");
		}

	}
	
}
