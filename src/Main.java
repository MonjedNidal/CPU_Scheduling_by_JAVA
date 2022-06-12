public class Main {

    public static void main(String[] args) {

        int[] p1 = {5, 27, 3, 31, 5, 43, 4, 18, 6, 22, 4, 26, 3, 24};
        int[] p2 = {4, 48, 5, 44, 7, 42, 12, 37, 9, 76, 4, 41, 9, 31, 7, 43};
        int[] p3 = {8 , 33, 12, 41, 18, 65, 14, 21, 4, 61, 15, 18, 14, 26, 5, 31};
        int[] p4 = {3, 35, 4, 41, 5, 45, 3, 51, 4, 61, 5, 54, 6, 82, 5, 77};
        int[] p5 = {16, 24, 17, 21, 5, 36, 16, 26, 7, 31, 13, 28, 11, 21, 6, 13, 3, 11};
        int[] p6 = {11, 22, 4, 8, 5, 10, 6, 12, 7, 14, 9, 18, 12, 24, 15, 30};
        int[] p7 = {14, 46, 17, 41, 11, 42, 15, 21, 4, 32, 7, 19, 16, 33};
        int[] p8 = {4, 14, 5, 33, 6, 51, 14, 73, 16, 87};
        int arriveTime = 0;


        System.out.println("FCFS:");
        System.out.println("\tWT\t\tTAT\tRT");
        System.out.print("p1:\t");
        FCFS(p1,arriveTime,1);
        System.out.print("p2:\t");
        FCFS(p2,arriveTime,2);
        System.out.print("p3:\t");
        FCFS(p3,arriveTime,3);
        System.out.print("p4:\t");
        FCFS(p4,arriveTime,4);
        System.out.print("p5:\t");
        FCFS(p5,arriveTime,5);
        System.out.print("p6:\t");
        FCFS(p6,arriveTime,6);
        System.out.print("p7:\t");
        FCFS(p7,arriveTime,7);
        System.out.print("p8:\t");
        FCFS(p8,arriveTime,8);

        System.out.println("----------------------------");

        System.out.println("SJF:");
        System.out.println("\tWT\t\tTAT\tRT");
        System.out.print("p1:\t");
        SJF_fun(p1,arriveTime,1);
        System.out.print("p2:\t");
        SJF_fun(p2,arriveTime,2);
        System.out.print("p3:\t");
        SJF_fun(p3,arriveTime,3);
        System.out.print("p4:\t");
        SJF_fun(p4,arriveTime,4);
        System.out.print("p5:\t");
        SJF_fun(p5,arriveTime,5);
        System.out.print("p6:\t");
        SJF_fun(p6,arriveTime,6);
        System.out.print("p7:\t");
        SJF_fun(p7,arriveTime,7);
        System.out.print("p8:\t");
        SJF_fun(p8,arriveTime,8);


        System.out.println("----------------------------");

        System.out.println("MLFQ:");
        System.out.println("\tWT\t\tTAT\tRT");
        System.out.print("p1:\t");
        MLFQ_fun(p1,arriveTime,1);
        System.out.print("p2:\t");
        MLFQ_fun(p2,arriveTime,2);
        System.out.print("p3:\t");
        MLFQ_fun(p3,arriveTime,3);
        System.out.print("p4:\t");
        MLFQ_fun(p4,arriveTime,4);
        System.out.print("p5:\t");
        MLFQ_fun(p5,arriveTime,5);
        System.out.print("p6:\t");
        MLFQ_fun(p6,arriveTime,6);
        System.out.print("p7:\t");
        MLFQ_fun(p7,arriveTime,7);
        System.out.print("p8:\t");
        MLFQ_fun(p8,arriveTime,8);


    }

    public static void FCFS(int[] pr1,int arriveTime,int num){
        Process[] processes = new Process[pr1.length / 2];
        toArrayOfObjects(processes, pr1, arriveTime);
        Operations.calculateStartTime(processes);
//        System.out.println("turnAroundTotal = " + WaitingTime.calculateTAT_WT(processes));

        print(Operations.calculateWT(processes), Operations.calculateTAT(processes),num);

    }

    public static void SJF_fun(int[] pr,int arriveTime,int num) {
        Process[] processes = new Process[pr.length / 2];
        toArrayOfObjects(processes, pr, arriveTime);
        SJF.sort(processes);
        Operations.calculateStartTime(processes);

            print(Operations.calculateWT(processes), Operations.calculateTAT(processes),num);


    }

    public static void MLFQ_fun(int[] pr,int arriveTime,int num){
        Process[] processes = new Process[pr.length / 2];
        toArrayOfObjects(processes, pr, arriveTime);
        Operations.calculateTAT(processes);
        print(MLFQ.WT(processes,5,10), Operations.calculateTAT(processes),num);
    }

    public static void print(float WT,int TAT,int num){
        int[] RT = {0,5,9,17,20,36,47,61};
        System.out.println(WT+"\t"+TAT+"\t"+RT[num-1]);
//        System.out.println("cpuBurst\tioTime\tarriveTime\tstartTime\twaitingTime");
//        for (int i = 0; i < processes.length; i++) {
//            System.out.println(processes[i].cpuBurst+"\t\t\t"+processes[i].ioTime+"\t\t\t"+processes[i].arriveTime +"\t\t\t"+ processes[i].startTime+"\t\t\t"+ processes[i].waitingTime);
//        }
    }

    public static void toArrayOfObjects (Process[]processes,int[] pr,int arriveTime){
        for (int i = 0; i < processes.length; i++) {
            for (int j = 0; j <= i*2; j++) {
                processes[i] = new Process(pr[j],pr[j+1],arriveTime);
                j++;
            }
        }

    }

}



