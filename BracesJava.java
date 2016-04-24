package paranthesis;

import java.util.Scanner;

public class IhaveMain {
static int tests;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc=new Scanner(System.in);
tests=Integer.parseInt(sc.nextLine());
for(int joker=0;joker<tests;joker++){
	String s=sc.nextLine();
	if(s.length()%2!=0){
		System.out.println("NO");
	}
	else{
		int a[]=new int[s.length()];
		for(int i=0;i<a.length;i++){
			a[i]=Integer.MIN_VALUE;
		}
		int p=-1,popcount=0;
		for(int i=0;i<s.length();i++){
			char c=s.charAt(i);
			if(c=='{'){
				p++;
				a[p]=1;
				
				
			}
			else if(c=='['){
				p++;
				a[p]=2;
				
			}
			else if(c=='('){
				p++;
				a[p]=3;
				
			}
			else if(c=='}'){
				if(p!=-1){
				if(a[p]==Integer.MIN_VALUE)
				p--;
				if(a[p]==1){
					a[p]=Integer.MIN_VALUE;
					p--;
					popcount++;
				}
				else{
				//	System.out.println("1");
					break;
				}
			}
			}
			else if(c==']'){
				if(p!=-1){
				if(a[p]==Integer.MIN_VALUE)
					p--;
				if(a[p]==2){
					a[p]=Integer.MIN_VALUE;
					p--;
					popcount++;
				}
				else{
		//	System.out.println("2");
					break;
				}
				}
			}
			else if(c==')'){
				if(p!=-1){
				if(a[p]==Integer.MIN_VALUE)
					p--;
				if(a[p]==3){
					a[p]=Integer.MIN_VALUE;
					p--;
					popcount++;
				}
				else{
				//	System.out.println("3");
					break;
				}
				}
			}
		}
		if(popcount==s.length()/2){
			System.out.println("YES");
		}
		else{
			System.out.println("NO");
		}
		
	}
	
	
}
	}

}
