package flaty.search;

/**
 * 
 * 
 * @author flatychen
 * 
 */
public class BinarySearch {

	public int search(Comparable[] c, Comparable key) {
		int lowPos = 0 , highPos = c.length,midPos = highPos/2;
		while( lowPos <= highPos){
			midPos =  ( lowPos + highPos )/2;
			int result = key.compareTo(c[midPos]);
			if(result == 0){
				return midPos;
			}else if(result < 0){
				highPos = midPos - 1;
			}else{
				lowPos = midPos + 1;
			}
			
		}
		return -1;
		
	}
	
	public int searchRecursive(Comparable[] c, Comparable key) {
		return this.searchRecursiveBody(c, 0, c.length, key);
	}
	
	
	private int searchRecursiveBody(Comparable[] c, int lowPos ,int highPos, Comparable key) {
		int midPos = (lowPos + highPos)/2;
		if( lowPos <= highPos){
			midPos =  ( lowPos + highPos )/2;
			int result = key.compareTo(c[midPos]);
			if(result == 0){
				return midPos;
			}else if(result < 0){
				return searchRecursiveBody(c,lowPos,midPos - 1,key);
			}else{
				return searchRecursiveBody(c,midPos + 1,highPos,key);
			}
			
		}else{
			return -1;
		}
		
	}
}
