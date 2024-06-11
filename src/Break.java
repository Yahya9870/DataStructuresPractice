public class Break {
    public static void main(String[] args) {
        for (int i = 1; i <=100 ; i++) {


            if(i==50){

                System.out.println("Break encountered");
                System.out.println("Exiting the loop. . . .");
                break; // immediately terminates the loop.
            }

            System.out.println(i);

        }
    }
}
