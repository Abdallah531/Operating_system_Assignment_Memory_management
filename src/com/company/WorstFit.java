package com.company;

import java.util.Scanner;

public class WorstFit {
    int numofprocess,numofpart;
    int[] allocatprocess;
    String[] allocatpart;

    public WorstFit(int numofprocess, int numofpart) {
        this.numofprocess = numofprocess;
        this.numofpart = numofpart;
        allocatprocess = new int[numofprocess];
        allocatpart = new String[numofprocess];
    }

    public void worstFit(Process process [], Partition part[])
    {
        int cont = numofpart;
        String [] nameofpart = new String[numofpart];
        for(int i = 0 ; i < numofprocess;i++)
        {
            allocatprocess[i]=-1;
            allocatpart[i]=" ";
        }
        for(int i = 0 ; i < numofpart;i++)
        {
            nameofpart[i]=part[i].name;
        }

        for(int i = 0 ; i < numofprocess;i++)
        {
            int worstIndex = -1;
            for(int j = 0 ; j < numofpart;j++)
            {
                if(part[j].size>=process[i].size)
                {
                    if (worstIndex==-1)
                        worstIndex = j;
                    else if (part[worstIndex].size < part[j].size) {
                        worstIndex = j;
                    }
                }
            }
            if (worstIndex != -1)
            {
                allocatpart[i]=part[worstIndex].name;
                allocatprocess[i]=worstIndex;

                part[worstIndex].name= "partition"+cont;
                cont++;

                part[worstIndex].size-=process[i].size;

            }
        }
        System.out.println("----Worst Fit----");

        for(int i = 0 ; i < numofpart ; i++)
        {
            for(int j = 0 ; j < numofprocess ; j++)
            {
                if(allocatprocess[j] == i )
                {
                    System.out.println(allocatpart[j] + " ("+process[j].size + "KB) ==> "+process[j].name);
                }
            }
            if(part[i].size>0)System.out.println(part[i].name + " ("+part[i].size + "KB) ==> External fragment" );
        }
        for(int j = 0 ; j < numofprocess ; j++)
        {
            if(allocatprocess[j] == -1 )
            {
                System.out.println(process[j].name + " Can not be allocated");
            }
        }

        int compactedPartion=0;
        System.out.println(" Do you want to compact? 1.yes 2.no " );

        Scanner input = new Scanner(System.in);
        int com = input.nextInt();

        if (com == 1) {
            for(int i = 0 ; i < numofpart ; i++)
            {
                for(int j = 0 ; j < numofprocess ; j++)
                {
                    if(allocatprocess[j] == i )
                    {
                        System.out.println(allocatpart[j] + " ("+process[j].size + "KB) ==> "+process[j].name);
                    }
                }

                if(part[i].size>0){
                    part[i].fragmented=true;
                    compactedPartion+=part[i].size;}
            }
            for(int j = 0 ; j < numofprocess ; j++)
            {
                if(allocatprocess[j] == -1 )
                {
                    if(compactedPartion>process[j].size){
                        allocatpart[j]="Partition"+cont;

                        System.out.println(allocatpart[j] +" ("+process[j].size + "KB) ==> "+process[j].name);
                        compactedPartion-=process[j].size;
                        allocatprocess[j] = 1;
                        cont++;
                        break;
                    }
                    else
                        System.out.println(process[j].name + " Can not be allocated");
                }
            }
            System.out.println( "Partition"+cont+" (" +compactedPartion+"KB)==>  external Fragmentation");
        } else if (com == 2){  System.exit(0);}
        else
        {
            System.out.println(" You Enter The  Wrong Number " );
        }
    }
}

