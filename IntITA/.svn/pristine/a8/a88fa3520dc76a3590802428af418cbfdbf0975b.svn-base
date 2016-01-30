/**
 * 
 */
package scheduleAlgorithmCPU;

/**
 * @author Barakuda
 *
 */
public class HungarianAlgorithmImpl implements HungarianAlgorithm {
	
	public int[] algorithmCPU(int[][] matrix){
		int m=matrix.length;
		int n=m;
		boolean []used=new boolean[m+1];
		int[]result=new int[m+1];
		int[] minv=new int[m+1];
		int[] way=new int[m+1];
		int[] u=new int[n+1];
		int[] v=new int[m+1];
		int[] p=new int[m+1];
			for(int x=1;x<matrix.length+1;x++){
					 way[x]=u[x]=v[x]=p[x]=0;				  
				  }
		
		for(int i=1;i<=n;++i){
			p[0]=i;
			int j0=0;
					  for(int x=1;x<minv.length;x++){
						  minv[x]=Integer.MAX_VALUE;				  
					  }
						  for(int s=1;s<used.length;s++){
							  used[s]=false;				  
						  } 
		    do{	
			  used[j0]=true;
			  int i0=p[j0],delta=Integer.MAX_VALUE,j1=0;
			     
			  for(int j=1;j<=m;++j){
			    	 int cur=matrix[i0][j]-u[i0]-v[j];
			    	 if(cur<minv[j]){
			    		 minv[j]=cur; way[j]=j0;
			    		 }
			    	  if(minv[j]<delta){
			    		  delta=minv[j]; j1=j;
			    		  }
			  }
			  for(int j=1;j<=m;++j){
				  if(used[j]){
					  u[p[j]]+=delta;v[j]-=delta;
				  }else{
						  minv[j]-=delta;
				  }
			  }
			 j0=j1;	
			}while(p[j0]!=0);
		
		do{
			int j1 =way[j0];
			p[j0]=p[j1];
			j0=j1;
		}while(j0!=0);
	}	
		
	for(int j=1;j<=m;++j){
		result[p[j]]=j;
		System.out.println("column-"+p[j]+" row-"+j);
	}
	return result;	
	}
}

	


