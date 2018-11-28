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
        if(this.flying) {
            System.out.println(getName() + " can't take off, already flying !");
        } else {
            this.flying=true;
            System.out.println(getName() + " takes off in the sky");
        }

    }

    @Override
    public void land() {
        if(!this.flying) {
            System.out.println( getName() + "can't land, already on the ground!" );
        } else {
            this.flying = false;
            this.altitude=0;
            System.out.println( getName() + " is landing" );
        }
    }

    @Override
    public int ascend(int meters) {
        if(this.isFlying()) {
            this.altitude += meters;
            System.out.println( getName() + " flies upward, altitude " + this.altitude );
        } else {
            System.out.println( getName() + " can't ascend, not flying !");
        }
        return this.altitude;
    }

    @Override
    public int descend(int meters) {
        if (this.flying) {
            this.altitude -= meters;
            if (this.altitude < 0) {
                System.out.println( "Mayday mayday " + getName() + " has crashed !!!!" );
                this.altitude = 0;
            } else {
                System.out.println( getName() + " flies downward, altitude " + this.altitude );
            }
        } else {
            System.out.println( getName() + " can't descend, not flying !" );
        }
        return this.altitude;
    }
}
