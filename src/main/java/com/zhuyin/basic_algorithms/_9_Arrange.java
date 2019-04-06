package com.zhuyin.basic_algorithms;


/**
 * @author ZY
 *	
 *	题目：有1、2、3、4个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？
 *	程序分析：可填在百位、十位、个位的数字都是1、2、3、4。组成所有的排列后再去掉不满足条件的排列。
 *
 */
public class _9_Arrange {
	public static void main(String[] args) {
		/*int count=0;
		int n=0;
		for(int i=1;i<5;i++){
			for(int j=1;j<5;j++){
				if (i==j) {	//十位与百位相同则跳过
					continue;
				}else {
					for(int k=1;k<5;k++){
						if (i!=k&&j!=k) {	//百位与十位不相同的情况下，百位与个位不能相同且十位与个位不能相同
							n=i*100+j*10+k;
							System.out.print(n+" ");
							if ((++count)%5==0) {
								System.out.println();
							}
						}
					}
				}
			}
		}
		System.out.println();
		System.out.println("总共有"+count+"种排列方式");*/
		method();
	}

	private static void method() {
		int count = 0;
		int n = 0;
		for (int i = 1; i < 5; i++) {
			for (int j = 1; j < 5; j++) {
				if (i != j) { // 十位与百位不能相同
					for (int k = 1; k < 5; k++) {
						if (i != k && j != k) { // 百位与十位不相同的情况下，百位与个位不能相同且十位与个位不能相同
							n = i * 100 + j * 10 + k;
							System.out.print(n + " ");
							if ((++count) % 5 == 0) {
								System.out.println();
							}
						}
					}
				}
			}
		}
		System.out.println();
		System.out.println("总共有" + count + "种排列方式");
	}
}
