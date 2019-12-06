package flaty.sort;

/**
 * 
 * 
 * 选择排序
 * 
 * @author flatychen
 * 
 */
public class  SelectionSort extends AbstractSort implements Sortable {

	public void sort(Comparable[] c) {

		int minPos = 0;
		
		for (int currentPos = 0; currentPos < c.length; currentPos++) {
			minPos = currentPos;
			// find the min object
			for (int j = currentPos + 1; j < c.length; j++) {
				if (super.less(c[j], c[minPos]))
					minPos = j;
			}
			super.swap(c, minPos, currentPos);
		}

	}

	@Override
	public void sort(Comparable[] c, int off, int len) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
