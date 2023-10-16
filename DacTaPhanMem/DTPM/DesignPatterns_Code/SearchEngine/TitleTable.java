
/**
 * Write a description of class TitleTable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.HashMap;
import java.util.NoSuchElementException;
public class TitleTable
{
    // instance variables - replace the example below with your own
    private HashMap <String,Doc> titletable;

    /**
     * Constructor for objects of class TitleTable
     */
    public TitleTable() throws NoSuchElementException
    {
        // initialise instance variables
        titletable = new HashMap <String,Doc>();
    }

    
    public void  addDoc (Doc d) throws NoSuchElementException
    {
     String title = d.title();
     titletable.put(title,d);
     //StdOut.println(title + " " + titletable.get(title).title());
    }
    
    public Doc lookup (String t) throws NoSuchElementException
    {
        if(!(titletable.containsKey(t)))
            return null;
        return titletable.get(t);
    }
}
