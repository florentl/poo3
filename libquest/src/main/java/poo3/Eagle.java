package poo3;

public class Eagle extends Bird implements Fly{

    private boolean flying;
    private int altitude;

    public Eagle(String name) {
        super(name);
        this.flying = false;
        this.altitude = 0;
    }

    public int getAltitude() {
        return altitude;
    }

    public boolean isFlying() {
        return flying;
    }

    @Override
    public String sing() {
        return "Screech!";
    }

    @Override
    public void takeOff() {
        this.flying=true;
        System.out.println("Eagle takes off in the sky");
    }

    @Override
    public void land() {
        this.flying=false;
        System.out.println("Eagle is landing");
    }

    @Override
    public int ascend(int meters) {
        this.altitude+=meters;
        System.out.println("Eagle flies upward, altitude " + this.altitude);
        return meters;
    }

    @Override
    public int descend(int meters) {
        this.altitude-=meters;
        System.out.println("Eagle flies downward, altitude " + this.altitude);
        return meters;
    }

}
