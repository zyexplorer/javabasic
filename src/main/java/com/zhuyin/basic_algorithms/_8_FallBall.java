package com.zhuyin.basic_algorithms;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.zhuyin.tools.NumberTool;

/**
 * 问题：一球从100米高度自由落下，每次落地后反跳回原高度的一半，再落下，求它在第10次落地时，共经过多少米？第10次反弹多高？
 * 
 * @author ZY
 *
 */
public class _8_FallBall {
	public static void main(String[] args) {
		/*for(int i=1;i<=10;i++){
			List<Double> list = fallBall(i);
			System.out.println("第"+i+"次落地时，共经过"+list.get(1)+"米");
			System.out.println("第"+i+"次反弹高度为"+list.get(0)+"米");
		}*/
		int number=NumberTool.inputOneIntNumber();
		List<Double> list = fallBall(number);
		System.out.println("第10次落地时，共经过"+list.get(1)+"米");
		System.out.println("第10次反弹高度为"+list.get(0)+"米");
	}
	
	public static void main1(String[] args) {
		//sum1表示纯下落的路程，sum2表示纯反弹的路程
		double sum1 = 0, sum2 = 0, hight = 100.0;
		for (int i = 0; i < 10; i++) {
			sum1 = sum1 + hight;
			hight = hight / 2;
			if (i < 9){
				sum2 = sum2 + hight;
			}
		}
		System.out.println("第10次落地时，共经过" + (sum1 + sum2) + "米");		//299.609375
		System.out.println("第十次反弹高度为" + hight + "米");	//0.09765625

	}
	
	public static void main4(String[] args) {
		//下落	 1	   2	3	  4	    ……	n
		//		100   50    25	 12.5   ……
		//反弹	1		2		3		4	……	n
		//		50		25		12.5	
		int n=10;
		double sum1=0,sum2=0,height=100d;
		for(int i=1;i<=n;i++){
			sum1+=height*Math.pow(0.5, i-1);
			sum2+=height*0.5*Math.pow(0.5, i-1);
			System.out.println("第"+i+"次下落高度为："+height*Math.pow(0.5, i-1));
			System.out.println("第"+i+"次反弹高度为："+height*Math.pow(0.5, i));
		}
		System.out.println("第10次落地时，共经过" + (sum1 + sum2-height*Math.pow(0.5, 10)) + "米");		//299.609375
		System.out.println("第10次反弹高度为" + height*Math.pow(0.5, 10) + "米");	//0.09765625
	}
	
	
	
	private static List<Double> fallBall(int n) {
		List<Double>list=new ArrayList<Double>();	//放外面比较好，不会在每次循环的时候new对象
		BigDecimal height=new BigDecimal(100),sum=new BigDecimal(0),hn=new BigDecimal(0),h=new BigDecimal(0),s=new BigDecimal(0);
		//List<Double>list=null;
		for(int i=1;i<=n;i++){
			//list=new ArrayList<>();	//放里面不好，每次循环都会new一个集合，耗内存
			if (i==1) {
				sum=height;
				height=height.divide(new BigDecimal(2));
				hn=height;
				/*list.add(hn.doubleValue());
				list.add(sum.doubleValue());*/
				h=hn;
				s=sum;
				System.out.println(sum);
			}else {
				sum=sum.add(height.multiply(new BigDecimal(2)));
				height=height.divide(new BigDecimal(2));
				if (i==n) {
					hn=height;
					/*list.add(hn.doubleValue());
					list.add(sum.doubleValue());*/
					h=hn;
					s=sum;
				}
				System.out.println(sum);
			}	
		}
		list.add(h.doubleValue());
		list.add(s.doubleValue());
		return list;
	}
	
}
