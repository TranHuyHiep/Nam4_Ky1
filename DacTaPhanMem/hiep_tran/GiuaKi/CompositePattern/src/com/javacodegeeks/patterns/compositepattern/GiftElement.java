package src.com.javacodegeeks.patterns.compositepattern;

public class GiftElement extends GiftBox
{
    public GiftElement(String name, int price)
    {
        
    }
    
    @Override
    public int CalculateTotalPrice() 
    {
        return price;
    }
}
