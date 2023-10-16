package MauCauTruc.Composite;

import java.util.ArrayList;
import java.util.List;

class CompositeGift extends GiftBase{
    private String name;
    private double price;
    private List<GiftBase> childGift;
    public CompositeGift(String name, double price) {
        this.name = name;
        this.price = price;
        this.childGift = new ArrayList();
    }
    @Override
    public void addChildGift(GiftBase gift) {
        childGift.add(gift);
    }

    @Override
    public List<GiftBase> getChildren(GiftBase gift) {
        return this.childGift;
    }

    @Override
    public void removeChildGift(GiftBase gift) {
        childGift.remove(gift);
    }
    @Override
    public double CalculateTotalPrice() {
        Double total = this.price;
        for(GiftBase gift: childGift){
            total += gift.CalculateTotalPrice();
        }
        return total;
    }
    @Override
    public String getName() {
        return this.name;
    }
    @Override
    public double getPrice() {
        return this.price;
    }

}