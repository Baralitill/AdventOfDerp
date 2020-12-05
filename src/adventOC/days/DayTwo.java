package adventOC.days;

import adventOC.AdventApp;

import java.io.BufferedReader;
import java.io.FileReader;

public class DayTwo {

    public static void runday() throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(AdventApp.class.getResource("day_two_input.txt").getFile()));

        String st;
        int validOldJobPass = 0;
        int validProperPass = 0;
        long count;
        while ((st = br.readLine()) != null) {
            String[] words = st.split(" ");
            String[] range = words[0].split("-");
            String letterAtIndex = words[1].substring(0,1);
            count = words[2].chars().filter(b -> String.valueOf((char)b).equals(letterAtIndex)).count();
            if(count >= Integer.parseInt(range[0]) && count <= Integer.parseInt(range[1])){
                validOldJobPass++;
            }
            boolean first = String.valueOf(words[2].charAt(Integer.parseInt(range[0]) - 1)).equals(letterAtIndex);
            boolean second = String.valueOf(words[2].charAt(Integer.parseInt(range[1]) - 1)).equals(letterAtIndex);
            if( (first && !second )|| (!first && second) ){
                validProperPass++;
            }
        }
        System.out.println("Number of valid passwords: " + validOldJobPass);
        System.out.println("Number of proper valid passwords: " + validProperPass);
    }


}
