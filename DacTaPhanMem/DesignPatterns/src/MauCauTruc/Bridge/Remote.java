package MauCauTruc.Bridge;

public class Remote{
    Device device;
    public Remote(Device device) {
        this.device = device;
    }
    void togglePower(){
        if(device.isEnable()){
            device.disable();
        }
        else {
            device.enable();
        }
    }

    void volumeDown(){
        System.out.println("VOLUME DOWN ...");
        device.setVolume(device.getVolume() - 5);
    }

    void volumeUp(){
        System.out.println("VOLUME UP ...");
        device.setVolume(device.getVolume() + 5);
    }

    void channelDown(){
        System.out.println("CHANNEL DOWN ...");
        device.setChannel(device.getChannel() - 1);
    }

    void channelUp(){
        System.out.println("CHANNEL UP ...");
        device.setChannel(device.getChannel() + 1);
    }
}
