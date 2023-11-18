package src.com.javacodegeeks.patterns.compositepattern;
import java.util.List;

public class GiftParent extends GiftBox
{
    private List<GiftBox> gifts;
    
    public void Add(GiftBox gift) 
    {
        gifts.add(gift);
    }
    
    public void Remove(GiftBox gift) {
        gifts.remove(gift);
    }
    
    public int CalculateTotalPrice() {
        int total = 0;
        
        // TODO: count leaf
        
        return total;
    }
}
