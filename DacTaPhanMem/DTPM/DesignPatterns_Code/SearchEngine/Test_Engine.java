
/**
 * Write a description of class Test_Engine here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.*;
import java.io.File;
import java.util.HashMap;
public class Test_Engine
{
    public Test_Engine()
    {
       
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static void main(String[] args) throws IOException {
        File ifile = new File("nonwords.txt"); 
     //   System.setIn(new FileInputStream(new File("nonwords.txt")));
        WordTable wt  = new WordTable(ifile);
        TitleTable ttable = new TitleTable();        

        for (String filename : args) {
            //StdOut.println("  " + filename);
            File file = new File(filename);
            //In in = new In(file);
            Doc doc = new Doc(file);
            ttable.addDoc(doc);
            HashMap<String,Integer> add_table = wt.addDoc(doc);
        } 
        //StdOut.println("buoc 1");  
        Query query = new Query(wt);
        //StdOut.println("buoc 2"); 
        Engine engine = new Engine(query);
        //StdOut.println("buoc 3"); 
        engine.settitletable(ttable);
        //StdOut.println("buoc 4"); 
        query = engine.queryFirst("was");
        //if (query == null) StdOut.println("ket qua truy van rong"); 
        if (!(query.results() == null))
        for (int j = 0; j < query.size(); j++)
                StdOut.println(query.fetch(j).title());
        engine.queryMore ("age");
        String[] khoa = engine.query().keys();
        for(int i=0; i < khoa.length && !(khoa[i]==null); i++) StdOut.println(khoa[i]);
        for (int j = 0; j < query.size(); j++)
                StdOut.println(query.fetch(j).title());
        
        //StdOut.println("ket qua rong");    
        engine.queryMore ("times");
        String[] khoa1 = engine.query().keys();
        for(int i=0; i < khoa1.length && !(khoa1[i]==null); i++) StdOut.println(khoa1[i]);
        for (int j = 0; j < query.size(); j++)
                StdOut.println(query.fetch(j).title());
        
        //StdOut.println("ket qua rong");   
    }
   
}
