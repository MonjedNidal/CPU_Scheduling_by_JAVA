public class SJF {

    Process[] processes;
    SJF(Process[] processes){
        this.processes = processes;
    }



    public static void sort(Process[] processes){
        Process min = processes[0];
        Process temp;
        for (int i = 0; i < processes.length; i++) {
            for (int j = 0; j < processes.length-i-1; j++) {
                if(processes[j].cpuBurst > processes[j+1].cpuBurst){
                    temp = processes[j];
                    processes[j] = processes[j + 1];
                    processes[j + 1] = temp;
                }
            }
        }
//        Main.print(processes);
    }



}
