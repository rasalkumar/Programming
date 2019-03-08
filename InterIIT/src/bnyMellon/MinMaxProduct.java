package bnyMellon;
import java.util.*;

public class MinMaxProduct {
	static class Dataset {
        private Integer min = null;
        private Integer max = null;
        private TreeSet<Integer> elements = new TreeSet<Integer>();
        private Vector<Long> products = new Vector<Long>();
        public void push(int x) {
            elements.add(x);
            if (min == null) {
                min = new Integer(x);
                max = new Integer(x);
            } else {
                if (min.intValue() > x) {
                    min = new Integer(x);
                }
                if (max.intValue() < x) {
                    max = new Integer(x);
                }
            }
            products.add(new Long(min.longValue() * max.longValue()));
        }
        public void pop(int x) {
            elements.remove(x);
            min = elements.first();
            max = elements.last();
            products.add(new Long(min.longValue() * max.longValue()));
        }
        public long[] toArray() {
            long[] la = new long[products.size()];
            Iterator<Long> itl = products.iterator();
			for (int i = 0; itl.hasNext(); i++) {
				la[i] = itl.next();
			}
            return la;
        }
    }

    static long[] maxMin(String[] operations, int[] x) {
        Dataset ds = new Dataset();
        for (int i = 0, fi = operations.length; i < fi; i++) {
            if ("push".equals(operations[i])) {
                ds.push(x[i]);
            } else if ("pop".equals(operations[i])) {
                ds.pop(x[i]);
            }
        }
        return ds.toArray();
    }

    public static void main(String[] argv) {
		{
        String[] operations = {"push","push","push","pop"};
        int[] x = {1,2,3,1};
        long[] la = maxMin(operations,x);
        for (int i = 0, fi = la.length; i < fi; i++) {
            System.out.println(la[i]);
        }
		}
		System.out.println("===");
		{
        String[] operations = {"push","push"};
        int[] x = {3,2};
        long[] la = maxMin(operations,x);
        for (int i = 0, fi = la.length; i < fi; i++) {
            System.out.println(la[i]);
        }
		}
    }
}