package hp.base;
/**
 * 定义执行器  并定义入参类型T  和出参了类型V
 * @author Administrator
 *
 * @param <T>
 * @param <V>
 */
public interface Base<T,V> {
	V exceute(T obj);
}
