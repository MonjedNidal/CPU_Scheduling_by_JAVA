public class Process {

    int cpuBurst;
    int ioTime;
    int arriveTime;
    int startTime;
    int waitingTime;
    int turnAround;
//    int turnAroundTotal = 0;

    public Process(int cpuBurst, int ioTime, int arriveTime) {
        this.cpuBurst = cpuBurst;
        this.ioTime = ioTime;
        this.arriveTime = arriveTime;
        startTime = 0;
        turnAround = 0;
        waitingTime = 0;
    }

    public Process(int cpuBurst, int ioTime) {
        this.cpuBurst = cpuBurst;
        this.ioTime = ioTime;
        startTime = 0;
        turnAround = 0;
        waitingTime = 0;
    }
}
