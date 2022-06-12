import java.util.ArrayList;

public class Operations {


    public static void CalculateRT(int[] list){


    }


    public static void calculateStartTime(Process[] processes){
        int waitingCounter = 0;
        ArrayList<Process> readyQ = new ArrayList<>();
        for (int i = 0; i < processes.length; i++) {
            readyQ.add(processes[i]);
            if(i > 0){
                processes[i].startTime = waitingCounter;

            }else {
                processes[i].startTime = 0;
            }
            waitingCounter += processes[i].ioTime;
        }
//        System.out.println("Average WaitingTime = "+waitingCounter/processes.length);
    }

    public static int calculateWT(Process[]processes){

//      WaitingTime = startTime - ArrivalTime
        int waitingCounter = 0;
        for (int i = 0; i < processes.length; i++) {
            processes[i].waitingTime = processes[i].startTime - processes[i].arriveTime;
            waitingCounter += processes[i].waitingTime;
        }
        return waitingCounter/ processes.length;
    }

    public static int calculateTAT(Process[]processes){
//        turn around = finishTime - ArrivalTime

        int turnAroundTotal = 0;
//        int waitingCounter = 0;
        for (int i = 0; i < processes.length; i++) {
            //           try {
            processes[i].turnAround = processes[i].startTime + processes[i].ioTime;
//            processes[i].turnAround = processes[i].waitingTime + processes[i].cpuBurst + processes[i].ioTime;
            turnAroundTotal += processes[i].turnAround;
//            waitingCounter += processes[i].waitingTime;
//            } catch (Exception e) {
//                assert processes[i] != null;
//                processes[i].turnAround = (processes[i].startTime + processes[i].ioTime)-processes[i].arriveTime;
//                System.out.println("turn = "+processes[i].turnAround);
//                processes[i].waitingTime = processes[i].startTime - processes[i].arriveTime;
//                turnAroundTotal += processes[i].turnAround;
//            }
        }
//        System.out.println("avg wait = "+(waitingCounter/processes.length));
        return turnAroundTotal/ processes.length;
    }

}
