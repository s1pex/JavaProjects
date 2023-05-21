package zad2;

import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Maybe <T> {

    private T t;


    private Maybe (T t) {
        this.t = t;
    }


    public static <K> Maybe<K> of(K t) {
        Maybe<K> m = new Maybe<>(t);
        return m;
    }


    public void ifPresent (Consumer cons) {
        if (this.t != null) {
            cons.accept(t);
        }
    }

    public <K> Maybe<K> map (Function<T, K> func) {
        if (this.t != null) {
            Maybe m = new Maybe<>(func.apply(this.t));
            return m;
        } else {
            Maybe m1 = new Maybe<>(null);
            return m1;
        }
    }


    public T get () {
        if (t == null){
            throw new NoSuchElementException("maybe is empty");
        }
        return this.t;
    }

    public boolean isPresent () {
        String str =  null;
        return t != str;
    }


    public T orElse (T t) {
        if(this.t == null){
            return t;
        } else {
            return this.t;
        }
    }


    public Maybe<T> filter (Predicate<T> pred) {
        if (this.t == null) {
            return this;
        } else if (pred.test(this.t)){
            return this;
        } else return Maybe.of(null);
    }

    @Override
    public String toString() {
        return(this.t == null) ? "Maybe is empty" : "Maybe has value " + this.t;
    }
}