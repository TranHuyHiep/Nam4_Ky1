package MauCauTruc.Composite;

// Có các hộp quà mà bên trong các hộp quà có thể là món đồ hoặc các hộp quà nhỏ
// Sử dụng mẫu composite để tính tổng giá trị hộp quà
public class TestComposite {
    public static void main(String[] args) {
        CompositeGift gift1 = new CompositeGift("Box 1", 0);
        CompositeGift gift2 = new CompositeGift("Box 2", 0);

        SingleGift singleGift1 = new SingleGift("Doll", 5.5);
        SingleGift singleGift2 = new SingleGift("Ball", 4.6);
        SingleGift singleGift3 = new SingleGift("Ballon", 10.5);

        gift1.addChildGift(singleGift3);
        gift1.addChildGift(singleGift1);
        gift2.addChildGift(singleGift2);
        gift2.addChildGift(gift1);

        System.out.println("Tổng giá trị hộp quà : " + gift2.CalculateTotalPrice());
    }
}
