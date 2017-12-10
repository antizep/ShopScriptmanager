package spring.tst;

public class tst {
    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++) {

            try {
                TstJPA.tst(i + "4", i + "90");
            } catch (Exception e) {

            }
        }
    }
}
