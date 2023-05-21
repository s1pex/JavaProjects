package zad1;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class XList <A> extends ArrayList<A> {
    private XList () {

    }

    public XList (Object... objects) {
        this.addAll(XList.of(objects));
    }

    public static <A> XList<A> of(Object... o) {

        boolean komb = true;
        XList xlist = new XList<>();

        if (o.length > 1) {
            komb = false;
            for(int i = 0; i < o.length; i++) {
                Object object = o[i];
                if (!(object instanceof Collection == true || object.getClass().isArray() == true)) {
                    komb = true;
                    break;
                }
            }
        }

        for (Object object1 : o) {
            if (object1.getClass().isArray() == true && komb == true) {
            Arrays.stream(((Object[]) object1)).forEach(c -> xlist.addAll(XList.of(c)));
            } else if (object1 instanceof Collection == true && komb == true) {
                ((Collection) object1).forEach(c -> xlist.addAll(XList.of(c)));
            } else {
                if (komb == false) {
                    xlist.add(XList.of(object1));
                } else {
                    xlist.add(object1);
                }
            }
        }
        return xlist;
    }


    public static XList<String> ofChars(String string) {
        List<String> listOfChars = new ArrayList<>();

            for(int i = 0; i < string.toCharArray().length; i++){
                    char c = string.toCharArray()[i];
                    listOfChars.add(String.valueOf(c));
            }
        return XList.of(listOfChars);
    }


    public static XList<String> ofTokens(String str) {
        return XList.ofTokens(str, "\n\r\t\f");
    }


    public static XList<String> ofTokens(String str, String sep) {
        return XList.of(str.split(sep));
    }


    public XList<Integer> union(Object... obj) {
        XList xlist1 = new XList(this);
        xlist1.addAll(XList.of(obj));
        return xlist1;
    }


    public XList diff(Object... obj) {
        XList xlist2 = new XList(this);
        xlist2.removeAll(XList.of(obj));
        return xlist2;
    }


    public XList<A> unique() {
        return XList.of( new LinkedHashSet<A>(this));
    }


    public XList<XList<A>> combine() {
        XList<XList<A>> xlist4 = combine(0, (XList<XList<A>>) this);
        xlist4.forEach(xlist -> Collections.reverse(xlist));
        return xlist4;
    }


    private static <A> XList<XList<A>> combine(int number, XList<XList<A>> newXList) {
        XList<XList<A>> komb = new XList<>();

        if (number != newXList.size()) {
            for (Object o : newXList.get(number)) {
                for (XList<A> set : combine(number + 1, newXList)) {
                    set.add((A) o);
                    komb.add(set);
                }
            }
        } else {
            komb.add(new XList());
        }
        return komb;
    }


    public String join(String sep) {
        return this.stream().map(Object::toString).collect(Collectors.joining(sep));
    }


    public String join() {
        return join("");
    }


    public <B> XList<String> collect (Function<XList<B>, String> func) {
        XList xlist5 = new XList();

        for (XList<B> xlist : ((XList<XList<B>>) this)) {
            xlist5.add(func.apply(xlist));
        }
        return xlist5;
    }

    public void forEachWithIndex(BiConsumer<A, Integer> con) {
        for (int j = 0; j < this.size(); j++)
            con.accept(this.get(j), j);
    }
}
