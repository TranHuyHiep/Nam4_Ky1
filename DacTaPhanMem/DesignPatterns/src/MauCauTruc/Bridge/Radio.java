package MauCauTruc.Bridge;

public class Radio implements Device{
    private String name;
    private boolean active;
    private int volume;
    private int channel;
    public Radio(String name) {
        this.name = name;
        this.active = false;
        this.volume = 0;
        this.channel = 100;
    }
    @Override
    public boolean isEnable() {
        return this.active;
    }
    @Override
    public void enable() { System.out.println(name + " ON ...");  this.active = true;    }
    @Override
    public void disable() {  System.out.println(name + " OFF ...");  this.active = false;   }
    @Override
    public int getVolume() {
        return this.volume;
    }
    @Override
    public void setVolume(int volume) {
        this.volume = volume;
    }
    @Override
    public int getChannel() {
        return this.channel;
    }
    @Override
    public void setChannel(int channel) {
        this.channel = channel;
    }
}
