package src.com.javacodegeeks.patterns.compositepattern;
import java.util.List;

public abstract class GiftBox
{
    protected String name;
    protected int price;
    
    public void add(GiftBox giftBox){
        throw new UnsupportedOperationException("Current operation is not support for this object");
    }
    
    public void remove(GiftBox giftBox){
        throw new UnsupportedOperationException("Current operation is not support for this object");
    }

    public abstract int CalculateTotalPrice();
}
