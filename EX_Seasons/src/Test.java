public class Test {
    public static void main(String[] args) {
        System.out.println("Seasons---------------");
        for (Season s: Season.values()) {
            System.out.println(s);
        }

        System.out.println("On part d'hiver et on tourne----------");
        Season maSeason = Season.Winter;

        for (int i = 0; i < 10; i++) {
            System.out.println(maSeason);
            maSeason = maSeason.previous();
        }

        System.out.println("Range Summer+-------------");
        for (Season s: Season.range(Season.Summer, Season.Winter)) {
            System.out.println(s);
        }

        System.out.println("Egalités------------");
        Season s1 = Season.Winter;
        Season s2 = Season.Autumn;
        if (s1 == s2){
            System.out.println("Raté");
        }else{
            System.out.println("Ok");
        }
        s2 = s2.next();
        if (s1 != s2){
            System.out.println("Raté");
        }else{
            System.out.println("Ok");
        }
    }
}
