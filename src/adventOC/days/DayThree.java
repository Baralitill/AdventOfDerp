package adventOC.days;

import adventOC.AdventApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.BaseStream;

public class DayThree {

    public static void runday() throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(AdventApp.class.getResource("day_three_input.txt").getFile()));

        String st;
        String[] arrSt;
        int level = 0;
        int[] indices = {0,0,0,0,0};
        int[] encounteredTrees = {0,0,0,0,0};
        while((st = br.readLine()) != null) {
            arrSt = st.split("");
            for(int i = 0; i < indices.length; i++){
                if(i < indices.length-1){
                    encounteredTrees[i] = arrSt[indices[i]].equals(".") ? encounteredTrees[i] : encounteredTrees[i]+1;
                    indices[i] += i*2+1;
                }
                else if(level%2 == 0){
                    encounteredTrees[i] = arrSt[indices[i]].equals(".") ? encounteredTrees[i] : encounteredTrees[i]+1;
                    indices[i] += 1;
                }
                if(indices[i] >= arrSt.length){
                    indices[i] = indices[i] - arrSt.length;
                }
            }
            level++;
        }
        // Já þetta outputtar bara seinni helminginn af dæminu, en fyrri helmingurinn er subsett af þeim seinni so suck my ass
        System.out.println("Encountered trees: " + Arrays.toString(encounteredTrees));
        System.out.println("Their multiplication is: " + Arrays.stream(encounteredTrees).asLongStream().reduce(1, (a,b) -> a*b));
    }
}
