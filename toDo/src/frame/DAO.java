package frame;

import java.util.ArrayList;

/**
 * Generic DAO Interface
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 20. ¿ÀÈÄ 2:09:59
 */
public interface DAO<K,V> {
	
	public void insert(V v) throws Exception;		
	public void delete(K k) throws Exception;
	public void delete() throws Exception;
	public void update(K k) throws Exception;
	public V select(K k) throws Exception;
	public ArrayList<V> select() throws Exception;
	
}
