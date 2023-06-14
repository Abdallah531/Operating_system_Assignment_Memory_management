package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

//        Partition[] PART = new Partition[6];
//        Process[]pro=new Process[4];
//        Partition part = new Partition("Partition0",90);
//        PART[0]=part;
//         part = new Partition("Partition1",20);
//        PART[1]=part;
//         part = new Partition("Partition2",5);
//        PART[2]=part;
//         part = new Partition("Partition3",30);
//        PART[3]=part;
//         part = new Partition("Partition4",120);
//        PART[4]=part;
//         part = new Partition("Partition5",80);
//        PART[5]=part;
//        Process process = new Process("P1",15);
//         pro[0]=process;
//         process = new Process("P2",90);
//        pro[1]=process;
//         process = new Process("P3",30);
//        pro[2]=process;
//        process = new Process("P4",100);
//        pro[3]=process;


//        //FirstFit FF = new FirstFit(4,6);
//        //WorstFit F = new WorstFit(4,6);
//        BestFit F = new BestFit(4,6);
//        F.bestFit(pro,PART);
//        //FF.firstfit(pro,PART);
//        //F.worstFit(pro,PART);
//       // BestFit bb=new BestFit(5,6);

        System.out.println("Enter Number of Partition : ");
        int numofpart = input.nextInt();
        Partition[] Part = new Partition[numofpart];
        Partition[] Part1 = new Partition[numofpart];
        Partition[] Part2 = new Partition[numofpart];
        for(int i = 0 ; i < numofpart;i++)
        {
            System.out.println("Partition name and its size : ");
            String nameofpart = input.next();
            int sizee = input.nextInt();
            Part[i]= new Partition(nameofpart,sizee);
            Part1[i]= new Partition(nameofpart,sizee);
            Part2[i]= new Partition(nameofpart,sizee);

        }
        System.out.println("Enter Number of Processes : ");
        int numofprocess = input.nextInt();
        Process[]Proc=new Process[numofprocess];
        Process[]Proc1=new Process[numofprocess];
        Process[]Proc2=new Process[numofprocess];
        for(int i = 0 ; i < numofprocess;i++)
        {
            System.out.println("Process name and its size : ");
            String nameofprocess = input.next();
            int size = input.nextInt();
            Proc[i]= new Process(nameofprocess,size);
            Proc1[i]= new Process(nameofprocess,size);
            Proc2[i]= new Process(nameofprocess,size);
        }

        FirstFit FF = new FirstFit(numofprocess,numofpart);
        WorstFit F = new WorstFit(numofprocess,numofpart);
        BestFit FFF = new BestFit(numofprocess,numofpart);

        System.out.println("Select the policy you want to apply:");
        System.out.println("1. First fit");
        System.out.println("2. Best fit");
        System.out.println("3. Worst fit");
        System.out.println("0. Exit");


        while (true){
            System.out.println("Select policy:");
            int policy = input.nextInt();
            if (policy == 1)
            {
                FF.firstfit(Proc,Part);
            } else if (policy == 2) {
                FFF.bestFit(Proc1,Part1);
            } else if (policy == 3) {
                F.worstFit(Proc2,Part2);
            } else if (policy == 0) {
                System.exit(0);
            }
        }

    }
}