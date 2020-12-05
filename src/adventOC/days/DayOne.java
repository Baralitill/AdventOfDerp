package adventOC.days;

import adventOC.AdventApp;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DayOne {

    public static void runday() throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(AdventApp.class.getResource("day_one_input.txt").getFile()));

        String st;
        Integer num = null;
        HashMap<Integer, Integer> hNums = new HashMap<>();
        List<Integer> nums = new ArrayList<>();
        while ((st = br.readLine()) != null) {
            num = Integer.parseInt(st);
            nums.add(num);
            hNums.put(num, num);
        }
        for (int index : nums) {
            int searchNumber = 2020 - index;
            if (hNums.containsValue(searchNumber)) {
                System.out.println("Numbers are: " + index + " and " + searchNumber +".");
                System.out.println("Their multiplication is : " + index*searchNumber);
                break;
            }
        }
        // yuck
        outer:
        for(int i = 0; i < nums.size(); i++){
            for(int j = i+1; j < nums.size(); j++){
                int searchNum = 2020 - (nums.get(i) + nums.get(j));
                if(searchNum > 0 && hNums.containsValue(searchNum)){
                    System.out.println("Numbers are: " + nums.get(i) + ", " + nums.get(j) +", and " + searchNum);
                    System.out.println("Their multiplication is : " + nums.get(i)*searchNum*nums.get(j));
                    break outer;
                }
            }
        }
    }

}
