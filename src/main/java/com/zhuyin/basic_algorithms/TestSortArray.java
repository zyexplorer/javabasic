package com.zhuyin.basic_algorithms;

public class TestSortArray {
	public static void main(String[] args) {
		int[] array = { 12, 25, 6, 18, 37, 20, 44, 15, 12, 56, 33};
		sortArray(array);
		for (int i : array) {
			System.out.print(i + " ");
		}
	}

	private static void sortArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for(int j=i+1;j<array.length;j++){
				if(array[i]>array[j]){
					int temp=array[i];
					array[i]=array[j];
					array[j]=temp;
				}
			}
		}
	}
}
