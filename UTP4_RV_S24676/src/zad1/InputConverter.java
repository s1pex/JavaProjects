package zad1;

import java.util.function.Function;

public class InputConverter<K>{

    private final K fname;

    public InputConverter(K fname){
        this.fname = fname;
    }

    public <A> A convertBy(Function... f){

        Object inputData = fname;
        Object outputData = null;

        for(Function function : f){
            outputData = function.apply(inputData);
            inputData = outputData;
        }

        return (A) outputData;

    }
}
