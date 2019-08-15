package hp.base;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;

public abstract class BaseHpTest<T, V,U> implements BaseTest<U, V> {

	Logger log = Logger.getLogger(BaseHpTest.class);

	/**
	 * 启动测试
	 */
	@Override
	public V Run(U u) throws Exception {
		return exceute((Class) u, CreateIdinfer());
	}

	// 使用反射调用需要测试的类的execute方法
	private V exceute(Class clazz, T createIdinfer) throws Exception {
		Object obj=clazz.newInstance();
		try {
			Method method = obj.getClass().getMethod("exceute", createIdinfer.getClass());
			return (V) method.invoke(obj, createIdinfer);
		} catch (Throwable e) {
			log.error(e.getMessage(), e);
			Throwable cause = e.getCause();
			if (cause instanceof Error) {
				throw (Error) cause;
			} else if (cause instanceof RuntimeException) {
				throw (RuntimeException) cause;
			} else {
				throw e;
			}
		}

	}
	
	// 构造入参参数
	public abstract T CreateIdinfer();
}
