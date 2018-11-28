package poo3;

public interface Fly {

    public void takeOff();
    public void land();
    public int ascend(int meters);
    public int descend(int meters);

    default void glide() {
        System.out.println("It glides into the air");
    }

}
