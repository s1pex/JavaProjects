package zad2;

public class StringTask implements Runnable {

    String letter;
    int multiplyNum;
    boolean ifRunned;
    TaskState stateOfProgramm;
    Thread thread;
    String result;
    String nothing = "";

    public StringTask(String letter,int multiplyNum) {
        this.multiplyNum = multiplyNum;
        this.letter = letter;
        this.stateOfProgramm = TaskState.CREATED;
        this.thread = new Thread(this);
        this.ifRunned = false;
        this.result = nothing;
    }

    public String getResult() {
        return result;
    }

    public TaskState getState() {
        return stateOfProgramm;
    }

    public void start() {
        ifRunned = true;
        thread.start();
    }

    public void  abort() {
        ifRunned = false;
        stateOfProgramm = TaskState.ABORTED;
        thread.interrupt();
    }

    public boolean isDone() {
        if(stateOfProgramm.equals(TaskState.CREATED) || stateOfProgramm.equals(TaskState.RUNNING)){
            return false;
        } else {
            return true;
        }
    }

    public void run() {
        ConcateLetter();
    }

    String letterForConcatenation;

    private void ConcateLetter() {
        while(multiplyNum!=0 && thread.isInterrupted() == false) {
            int tmpValue = multiplyNum;
            stateOfProgramm = TaskState.RUNNING;
            for(int i=0; thread.isInterrupted() == false &&  i<tmpValue; i++) {
                result = letterForConcatenation + result;
                multiplyNum = multiplyNum - 1;
            }
        }

        if(multiplyNum!=0){
            stateOfProgramm=TaskState.ABORTED;
        } else {
            stateOfProgramm=TaskState.READY;
        }
    }

    public StringTask(String letterForConcatenation,int multiplyNum,String result ) {
        this.multiplyNum = multiplyNum;
        this.letterForConcatenation = letterForConcatenation;
        this.stateOfProgramm = TaskState.CREATED;
        this.thread = new Thread(this);
        this.ifRunned = false;
        this.result = result;
    }

    public String getLetterForConcatenation() {
        return letterForConcatenation;
    }

    public int getMultiplyNum() {
        return multiplyNum;
    }

}