package MauCauTruc.Composite;

import java.util.List;

public abstract class GiftBase {
    public abstract String getName();
    public abstract double getPrice();
    public void addChildGift(GiftBase gift) {
        throw new UnsupportedOperationException("Current operation is not support for this object");
    }
    public void removeChildGift(GiftBase gift) {
        throw new UnsupportedOperationException("Current operation is not support for this object");
    }
    public List<GiftBase> getChildren(GiftBase gift) {
        throw new UnsupportedOperationException("Current operation is not support for this object");
    }
    public abstract double CalculateTotalPrice();
}