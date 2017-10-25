/**
 * 
 */
package tu;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author NTTu
 *
 */
public class ReconstructorFileA {
	
	public ArrayList<Integer> readFile(String name) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		File file = new File(name);
		try{
			Scanner input = new Scanner(file);
			while(input.hasNext()){
				int e = input.nextInt();
				list.add(e);	
			}
			input.close();
	    }
		catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<Integer> creatfileA(){
		ArrayList<Integer> fileA = new ArrayList<Integer>();
		return fileA;
	} 
	public ArrayList<Integer> reconstruct( ArrayList<Integer> fileA, String nameoffile){
		ArrayList<Integer> list = readFile(nameoffile);
		int begin,skip;
		begin = list.get(0);
		skip = list.get(1);
		//Integer.MIN_VALUE = 0;
		
		if (fileA.size() < ((skip+1)*(list.size()-2))){
			int dif = (skip+1)*(list.size()-2)-fileA.size();
			for(int j = 0; j<dif+1;j++){
				fileA.add(0);
			}
		}
		
		for(int i = 2; i<list.size();i++){
			int element = list.get(i);
			int pos = begin+((i-2)*(skip+1));
			fileA.set(pos, element);
		}
		return fileA;
	
	}
	
	public ArrayList<Integer> interpolate(ArrayList<Integer> fileA){
		int firstEle = 0; 
		int lastEle = 0;
		int n = 0;
		int last = fileA.size()-1;
		for (int i=0; i<fileA.size()-1; i++ ){
			if(fileA.get(i)!=0 && fileA.get(i+1)==0){
				n=n+1;
				firstEle = fileA.get(i);
				
			}
			else if(fileA.get(i)==0 && fileA.get(i+1)==0){
				 n = n+1;
			}
			else if(fileA.get(i)==0 && fileA.get(i+1)!=0){
				lastEle = fileA.get(i+1);
				float diff = (firstEle - lastEle)/(n+1);
				for (int j=1;j<n+1;j++){
					int FixPoint = Math.round(lastEle+j*diff);
					fileA.set(i+1-j, FixPoint);
				}
				n=0;
			}
			
			else {
				n = 0;
				firstEle=0;
				lastEle=0;       
			}
			
			
		}
		if(fileA.get(last)==0){
			lastEle=0;
			n=0;
			last=last-1;
			int check=0;
			while(check==0){
				if (fileA.get(last)==0){
					last=last-1;
					n=n+1;
					check=0;
				}
				else {
					check=1;
				}
			}
			firstEle=fileA.get(last);
			float diff = (firstEle - lastEle)/(n+1);
			for (int j=2;j<n+1;j++){
				int FixPoint = Math.round(firstEle-j*diff);
				fileA.set(last+j, FixPoint);
			}
		}
		
		return fileA;
	}
	
	
	
		
		
	
}
