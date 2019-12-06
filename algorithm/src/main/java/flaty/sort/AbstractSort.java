package flaty.sort;

/**
 * 
 * 排序基础类
 * 
 * @author flatychen
 * 
 */
public abstract class AbstractSort {

	/**
	 * 交换位置
	 * 
	 * @param c
	 * @param i
	 * @param j
	 * @author flatychen
	 */
	protected void swap(Comparable[] c, int i, int j) {
		this.validateIndex(c.length, i, j);
		Comparable<Object> t = c[i];
		c[i] = c[j];
		c[j] = t;
	}

	/**
	 * a 是否小于 b
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @author flatychen
	 */
	protected boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0 ? true : false;
	}
	
	/**
	 * a 是否小于 b
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @author flatychen
	 */
	protected boolean lessOrEquals(Comparable a, Comparable b) {
		return a.compareTo(b) < 0 ? true : false;
	}

	private void validateIndex(int length, int i, int j) {
		if (i < 0 || j < 0 || i >= length || j >= length) {
			throw new IndexOutOfBoundsException(": 数组越界");
		}
	}

}
