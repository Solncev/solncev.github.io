import java.io.*;
import java.util.*;

/**
 * Created by Марат on 25.05.2016.
 */
public class Sorter implements StudentsSorter {
    InputStream input;
    OutputStream output;

    public Sorter(InputStream input, OutputStream output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public void process(InputStream input, OutputStream output) throws IOException {

        SortedMap<String,LinkedList<String> > tm = new TreeMap();
        Scanner scanner = new Scanner(input);
        PrintStream ps = new PrintStream(output);
        System.setOut(ps);

        while (scanner.hasNextLine()){
            String s = scanner.nextLine();
            String [] b = s.split(":");

            if(tm.get(b[1]) == null){
                LinkedList<String> l = new LinkedList<String>();
                l.add(b[0]);
                tm.put(b[1],l);
            }
            else{
                LinkedList <String> n = tm.get(b[1]);
                n.add(b[0]);
                n.sort(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        int i = 0;
                        String s1 = o1.toUpperCase();
                        String s2  = o2.toUpperCase();
                        while (s1.charAt(i) == s2.charAt(i)){
                            i++;
                        }
                        return (int)(s1.charAt(i) - s2.charAt(i));
                    }
                });

                tm.remove(b[1]);
                tm.put(b[1], n);
            }
        }

        ArrayList<String> c =  new ArrayList<String>(tm.keySet());

        for (int i = c.size(); i > 0; i--){
            String r = tm.get(c.get(i-1)).toString();
            r = r.substring(1,r.length()-1);
            System.out.println( c.get(i-1) +" : " + r);
        }
    }

    public static void main(String[] args) throws IOException {
        InputStream in = new FileInputStream("in.txt");
        OutputStream out = new FileOutputStream("out1.txt");
        Sorter s = new Sorter(in, out);
        s.process(in, out);
    }
}
