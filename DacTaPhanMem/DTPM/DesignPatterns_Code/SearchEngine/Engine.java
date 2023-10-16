
/**
 * Write a description of class Engine here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.*;
import java.io.File;
import java.util.NoSuchElementException;
import java.util.HashMap;
public class Engine
{
    private Query query;
    private TitleTable titletable; 
    public Engine() throws NoSuchElementException
    {  
     query = new Query();
     titletable = new TitleTable();
    }
    public Engine(Query query) throws NoSuchElementException
    {  
     this.query = query;
     titletable = new TitleTable();
    }
    public Engine (Query query,TitleTable titletable) throws NoSuchElementException
    {  
     this.query = query;
     this.titletable = titletable;
    }
    private void setquery (Query query)
    {
        this.query = query;
    }
    public void settitletable (TitleTable t_table)
    {
        this.titletable = t_table;
    }
    public Query query ()
    {
        return query;
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public Query queryFirst (String w) throws NoSuchElementException
    {
        //if (!(query.wordtable().isInteresting(w))){
        //    StdOut.println("it is a not interesting word");
        //    return null;
        //}    
        Query newquery = new Query (query.wordtable(),w);
        setquery(newquery);
        if (newquery ==null) System.out.println("ket qua newquery rong");
        return newquery;
        
    }
    public Query queryMore (String w) throws NoSuchElementException
    {
        query.addKey(w);
    return query;    
    }
    public Doc findDoc (String t) throws NoSuchElementException
    {
    return null;
    }
    public Query addDocs () throws NoSuchElementException
    {    
    return query;    
    }
}
