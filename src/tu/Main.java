/**
 * 
 */
package tu;

import java.util.ArrayList;

/**
 * @author NTTu
 *
 */
public class Main {

	/**
	 * @param args
	 * @return 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] listofname = {"L1.txt" , "L2.txt","L3.txt","L4.txt"};
		
		ReconstructorFileA reconstructorFileA = new ReconstructorFileA();
		ArrayList<Integer> fileA = reconstructorFileA.creatfileA();
		
		for(int i = 0; i < listofname.length; i++){
			reconstructorFileA.reconstruct(fileA, listofname[i] );
		}
		
		reconstructorFileA.interpolate(fileA);
		
		for (int k = 0; k < fileA.size(); k++){
			int h = fileA.get(k);
			System.out.println(h+" ");
		}
	}

}
