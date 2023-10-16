package MauCauTruc.Bridge;

public class TestBridge {
    public static void main(String[] args) {
        Device radio = new Radio("Radio");
        Remote remote = new Remote(radio);

        remote.togglePower();
        remote.channelDown();
        remote.volumeUp();
        remote.togglePower();
        remote.togglePower();

        remote = new Remote(new TV("TIVI"));
        remote.togglePower();
        remote.volumeUp();
        remote.volumeUp();
        remote.channelDown();
        remote.togglePower();

    }
}
