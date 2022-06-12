import java.util.LinkedList;
import java.util.Queue;

public class MLFQ {

    public static float WT(Process[] processes, final int Quantum1, final int Quantum2){

        Queue<Process> QueueRR_Q5 = new LinkedList<>();
        Queue<Process> QueueRR_Q10 = new LinkedList<>();
        Queue<Process> FCFSQueue = new LinkedList<>();

        float RRWaitingCounter = 0;
        for (int i = 0; i < processes.length; i++) {
            Process temp;

            //to check if the quantum greater than the cpu burst.
            if(processes[i].cpuBurst < Quantum1){
                temp = new Process(processes[i].cpuBurst,processes[i].ioTime,0);
                RRWaitingCounter += processes[i].cpuBurst;
            }else {
                temp = new Process(Quantum1,processes[i].ioTime,0);
                RRWaitingCounter += Quantum1;
            }

            processes[i].cpuBurst -= Quantum1;//TODO replacement
            QueueRR_Q5.add(temp);
            if (processes[i].cpuBurst > 0) {
                Process temp2;
                if(processes[i].cpuBurst < Quantum2){
                    temp2 = new Process(processes[i].cpuBurst,processes[i].ioTime,0);
                    RRWaitingCounter += processes[i].cpuBurst;
                }else {
                    temp2 = new Process(Quantum2,processes[i].ioTime,0);
                    RRWaitingCounter += Quantum2;
                }
                processes[i].cpuBurst -= Quantum2;//TODO replacement

                QueueRR_Q10.add(temp2);
                if (processes[i].cpuBurst > 0) {
                    FCFSQueue.add(processes[i]);//FCFS
                }
            }// processes[i].cpuBurst = 0;

        }
        return RRWaitingCounter/ processes.length;
//        System.out.println("rr5: ");
//        for (Process p:QueueRR_Q5) System.out.println(p.cpuBurst);
//        System.out.println("rr10: ");
//        for (Process p:QueueRR_Q10) System.out.println(p.cpuBurst);
//        System.out.println("FCFS: ");
//        for (Process p:FCFSQueue) System.out.println(p.cpuBurst);
        }

//        for (int i = 0; i < ; i++) {
//            System.out.println();
//        }

//            if(processes[i].cpuBurst <= Quantum1){
//                systemTasks.add(processes[i]);
//            }else if(processes[i].cpuBurst > Quantum1){
//                processes[i].cpuBurst -= Quantum2;
//                interactiveJobs.add(processes[i]);
//                BatchJobs.add(processes[i]);
//            }
    }















//class test{
//    public static void main(String[] args) {
//        int[] pr1 = {5, 27, 3, 31, 5, 43, 19, 18, 6, 22, 4, 26, 3, 24};
//
//        Process[] processes = new Process[pr1.length/2];
//        Main.toArrayOfObjects(processes, pr1, 0);
//
//        int Quantum1 = 5;
//        int Quantum2 = 10;
//
//
//        Queue<Process> QueueRR_Q5 = new LinkedList<>();
//        Queue<Process> QueueRR_Q10 = new LinkedList<>();
//        Queue<Process> FCFSQueue = new LinkedList<>();
//
//        int RRWaitingCounter = 0;
//        for (int i = 0; i < processes.length; i++) {
//            Process temp;
//
//            //to check if the quantum greater than the cpu burst.
//            if(processes[i].cpuBurst < Quantum1){
//                temp = new Process(processes[i].cpuBurst,processes[i].ioTime,0);
//                RRWaitingCounter += processes[i].cpuBurst;
//            }else {
//                temp = new Process(Quantum1,processes[i].ioTime,0);
//                RRWaitingCounter += Quantum1;
//            }
//
//            processes[i].cpuBurst -= Quantum1;//TODO replacement
//            QueueRR_Q5.add(temp);
//            if (processes[i].cpuBurst > 0) {
//                Process temp2;
//                if(processes[i].cpuBurst < Quantum2){
//                    temp2 = new Process(processes[i].cpuBurst,processes[i].ioTime,0);
//                    RRWaitingCounter += processes[i].cpuBurst;
//                }else {
//                    temp2 = new Process(Quantum2,processes[i].ioTime,0);
//                    RRWaitingCounter += Quantum2;
//                }
//                processes[i].cpuBurst -= Quantum2;//TODO replacement
//
//                QueueRR_Q10.add(temp2);
//                if (processes[i].cpuBurst > 0) {
//                    FCFSQueue.add(processes[i]);//FCFS
//                }
//            }// processes[i].cpuBurst = 0;
//        }
//        double avgRRWaiting = RRWaitingCounter/ processes.length;
//        System.out.println("Waiting : " + avgRRWaiting);
//        System.out.println("rr5: ");
//        for (Process p:QueueRR_Q5) System.out.println(p.cpuBurst);
//        System.out.println("rr10: ");
//        for (Process p:QueueRR_Q10) System.out.println(p.cpuBurst);
//        System.out.println("FCFS: ");
//        for (Process p:FCFSQueue) System.out.println(p.cpuBurst);
////        System.out.println("rr5: ");
////        for (int i = 0; i < QueueRR_Q5.size(); i++) System.out.println(QueueRR_Q5.poll());
////        System.out.println("rr10: ");
////        for (int i = 0; i < QueueRR_Q10.size(); i++) System.out.println(QueueRR_Q10.poll());
////        System.out.println("FCFS: ");
////        for (int i = 0; i < FCFSQueue.size(); i++) System.out.println(FCFSQueue.poll());
//    }
//}
