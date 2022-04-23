
package frame;

import java.util.ArrayList;

/**
 * Generic Search Interface
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 21. ¿ÀÀü 10:14:10
 */
public interface Search<V,B> {
	public ArrayList<V> search(B d) throws Exception;
}
