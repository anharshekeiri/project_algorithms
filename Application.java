/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algraithms_project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.text.DateFormat;

/**
 *
 * @author Anhar shekeiri the Queen of CS 
 */
public class Application {

    /**
     * @param args the command line arguments
     *  @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

//        
        // TODO code application logic here
        File file = new File("C:\\Users\\WEN 10\\Desktop\\algorithim2022_project3\\algorithim2022_project\\algorithOutput.txt");
        FileWriter output = new FileWriter(file);
        PrintWriter print = new PrintWriter(output);
        //       
        Scanner in = new Scanner(System.in);
        int n = 0, m = 0, Input_User = -1;
                // menu do while 
        do {
            System.out.println("\t\t**count time for three Different Minimum Spanning Tree Algorithms **");
            System.out.println("1- Kruskal's Algorithm & Prim's Algorithm (based on Priority Queue)");
            System.out.println("2- Prim's Algorithm (based on Min Heap) & Prim's Algorithm (based on Priority Queue)");
            System.out.print("> Enter your choice : ");
            //here the user chouce 1 or 2 
            Input_User = in.nextInt();
            if (Input_User != 1 && Input_User != 2) {
                System.out.println("*YOUR INPUT SHOULD BE 1 OR 2 TRY AGAEN !*");
            }
            // menu break condition 
        } while (Input_User != 1 && Input_User != 2);
        
        if (Input_User == 1 || Input_User == 2) {
            System.out.println("> Available cases (where n represents # of vertices and m represents # of edges: )");
            System.out.println(" 1-  n=1,000  - m=10,000");
            System.out.println(" 2-  n=1,000  - m=15,000");
            System.out.println(" 3-  n=1,000  - m=25,000");
            System.out.println(" 4-  n=5,000  - m=15,000");
            System.out.println(" 5-  n=5,000  - m=25,000");
            System.out.println(" 6-  n=10,000 - m=15,000");
            System.out.println(" 7-  n=10,000 - m=25,000");
            System.out.println(" 8-  n=20,000 - m=200,000");
            System.out.println(" 9-  n=20,000 - m=300,000");
            System.out.println("10-  n=50,000 - m=1,000,000");
//this is the sample given in document 

            for( int choice=1;choice<11;choice++){
                System.out.println("i "+choice);
               
                switch (choice) {
                    case 1: {
                        n = 1000;
                        m = 10000;
                    }
                    break;
                    case 2: {
                        n = 1000;
                        m = 15000;
                    }
                    break;
                    case 3: {
                        n = 1000;
                        m = 25000;
                    }
                    break;
                    case 4: {
                        n = 5000;
                        m = 15000;
                    }
                    break;
                    case 5: {
                        n = 5000;
                        m = 25000;
                    }
                    break;
                    case 6: {
                        n = 10000;
                        m = 15000;
                    }
                    break;
                    case 7: {
                        n = 10000;
                        m = 25000;
                    }
                    break;
                    case 8: {
                        n = 20000;
                        m = 200000;
                    }
                    break;
                    case 9: {
                        n = 20000;
                        m = 300000;
                    }
                    break;
                    case 10: {
                        n = 50000;
                        m = 1000000;
                    }
                    break;
                }
        
                if(Input_User == 1)
                {
                    Graph undirGraph = new Graph(m,n, false);

                    undirGraph.makeGraph();
                
                    long start_timekrskal =System.currentTimeMillis();
                    kruskalAlg k = new kruskalAlg(undirGraph);
                    k.DisplayResultingMST();
                   
                    long finesh_timekrskal =System.currentTimeMillis();
                   
                    System.out.println("kruskal time "+(finesh_timekrskal-start_timekrskal));
              
                    long start_timePQ =System.currentTimeMillis();
                    PQPrimAlg pq=new PQPrimAlg(undirGraph);
                    pq.DisplayResultingMST();
                   
                    long finesh_timePQ =System.currentTimeMillis();
                    System.out.println("PQ time "+(finesh_timePQ-start_timePQ));
                    //here will print itration  vertex , Edge , time for this itretion and cost for MST in file to used in Exal 
                    print.print(choice+"  "+n+"  "+m+"  "+(finesh_timekrskal-start_timekrskal)
                            +"  "+(finesh_timePQ-start_timePQ) + "  "+ pq.mst_cost);
                    print.println();
                     
                }
                else if(Input_User == 2)
                {
                    Graph undirGraph = new Graph(m,n, false);
                    undirGraph.makeGraph();
                    
                 
                    long start_timekrsMH =System.currentTimeMillis();
                    MHPrimAlg p = new MHPrimAlg(undirGraph);
                    p.DisplayResultingMST();
                    // k.printGraph(k.MSTresultList);
                    long finesh_timekrsMH =System.currentTimeMillis();
                    // System.out.println("kruskal time "+(finesh_timekrskal-start_timekrskal));
                  
                    System.out.println("Main Heap time "+(finesh_timekrsMH-start_timekrsMH));

                    
                    long start_timePQ =System.currentTimeMillis();
                    PQPrimAlg pq=new PQPrimAlg(undirGraph);
                    pq.DisplayResultingMST();
                 
                    long finesh_timePQ =System.currentTimeMillis();
                    System.out.println("PQ time "+(finesh_timePQ-start_timePQ));
                     //here will print itration  vertex , Edge , time for this itretion and cost for MST in file to used in Exel
                    print.print(choice+" "+n+" "+m+" "+(finesh_timekrsMH-start_timekrsMH)
                            +" "+(finesh_timePQ-start_timePQ) + " "+ pq.mst_cost);
                    print.println();
                    
                }
            }
            print.close();     
        }
    }
}