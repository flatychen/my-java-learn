package flaty.sort;

/**
 * 
 * 
 * 插入排序
 * 
 * @author flatychen
 * 
 */
public class InsertSort extends AbstractSort implements Sortable {

	public void sort(Comparable [] c) {
		this.sort(c, 0, c.length);
	}

	@Override
	public void sort(Comparable[] c, int off, int len) {
		Comparable currentObj = null;
		for (int currentPos = off; currentPos < len; currentPos++) {
			currentObj = c[currentPos];
			int j = currentPos;
			// find the  right position
			for ( ; j > 0 ; j--) {
				if (super.less(currentObj, c[j-1]))
					c[j] = c[j-1];
				else break;
			}
			// insert 
			c[j] = currentObj;
		}
		
	}
	
	public void sort1(Comparable[] c, int off, int len) {
		for (int currentPos = off ; currentPos < len; currentPos++) {
			for ( int j = currentPos  ; j > currentPos && super.less(c[j-1], c[j]) ; j--) {
				super.swap(c, j-1, j);
			}
		}
		
	}
	
	

}
