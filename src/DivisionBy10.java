public class DivisionBy10 {
    public static void main(String[] args) {
        // suppose n is a number 1,2,3,4, ...... infinity
        // if you do n/10 it means it will gonna eliminate last digit of that number.
        // for example n=1234
        // n/10=123
        // 123/10 = 12
        //12/10=1
        // 1/10=0

        int num=627895;

        int count=0;

        while(num>0){

            num=num/10;  // 1. 12345/10: num = 1234
                        // 2. 1234/10:   num= 123
                        //3. 123/10:     num=12
                        //4. 12/10:       num=1
                        // 5. 1/10:       num=0

            count++; // value of count getting increased by one value of count 1. 1
                                                                 //2. 2
                                                                 //3. 3
                                                                 //4. 4
                                                                 //5. 5
        }

        System.out.println(count);
    }
}
