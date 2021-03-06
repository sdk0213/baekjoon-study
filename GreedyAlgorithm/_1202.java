package GreedyAlgorithm;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;


/*
        // jewelry[][] 를 오름차순으로 정렬(1.무게 2.가격)
        // bag[i] 를 오름차순으로 정렬
        // while(){
        //    bag[i] 오름차순 정렬순서대로 jewelry[][] 해당 무게에 가장 높은 가격을 검색후 bag[i]에다가 넣고(넣었다고 치고) 삭제
        //  }
        // 검색할때는 bag[i] 보다 작은것들을 전부 검색해야하고 그중에서 가장 값어치 있는것을 넣어야함
        // 5의 공간의 가방에 들어갈 쥬얼리를 찾을때는 1,2,3,4,5 중(정렬되어있음) 에 가장 가치가 높은것을 찾으면됨
*/



class Jewel_Info implements Comparable<Jewel_Info>{
    int Jewel_Info_Weight;
    int Jewel_Info_Price;

    public Jewel_Info(int Jewel_Info_Weight,int Jewel_Info_Price){
        this.Jewel_Info_Weight = Jewel_Info_Weight;
        this.Jewel_Info_Price = Jewel_Info_Price;
    }
    public int compareTo(Jewel_Info ObjforCompare) {
        return this.Jewel_Info_Weight - ObjforCompare.Jewel_Info_Weight;
    }
}
public class _1202{

    public static void main(String args[]){


        Scanner inputScanner = new Scanner(System.in);
        int Jeweler_had_Jewel = inputScanner.nextInt();
        int SangDuk_had_Bag = inputScanner.nextInt();
        Jewel_Info jewel_Info[] = new Jewel_Info[Jeweler_had_Jewel];
        int SangDuk_had_Bag_Info[] = new int[SangDuk_had_Bag];
        Queue<Integer> priorityQueue = new PriorityQueue<Integer>();


        for (int i = 0; i < Jeweler_had_Jewel; i++)
            jewel_Info[i] = new Jewel_Info(inputScanner.nextInt(), inputScanner.nextInt());
        for (int i = 0; i < SangDuk_had_Bag; i++)
            SangDuk_had_Bag_Info[i] = inputScanner.nextInt();
        Arrays.sort(jewel_Info);
        Arrays.sort(SangDuk_had_Bag_Info);
        
        long SangDuk_Get_Money = 0;
        int j = 0;
        for (int Putin = 0; Putin < SangDuk_had_Bag; Putin++) {
            
            while( (j < Jeweler_had_Jewel)  && (jewel_Info[j].Jewel_Info_Weight <= SangDuk_had_Bag_Info[Putin]) ){
                priorityQueue.add(jewel_Info[j].Jewel_Info_Price);
                j++;
            }
            if(!priorityQueue.isEmpty()){
                SangDuk_Get_Money += Math.abs(priorityQueue.poll());
            }
        }

        System.out.println(SangDuk_Get_Money);
    

        inputScanner.close();


    }
}
