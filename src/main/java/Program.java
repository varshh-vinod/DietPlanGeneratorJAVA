import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        Test(
                new int[]{3, 4},
                new int[]{2, 8},
                new int[]{5, 2},
                new String[]{"P", "p", "C", "c", "F", "f", "T", "t"},
                new int[]{1, 0, 1, 0, 0, 1, 1, 0});
        Test(
                new int[]{3, 4, 1, 5},
                new int[]{2, 8, 5, 1},
                new int[]{5, 2, 4, 4},
                new String[]{"tFc", "tF", "Ftc"},
                new int[]{3, 2, 0});
        Test(
                new int[]{18, 86, 76, 0, 34, 30, 95, 12, 21},
                new int[]{26, 56, 3, 45, 88, 0, 10, 27, 53},
                new int[]{93, 96, 13, 95, 98, 18, 59, 49, 86},
                new String[]{"f", "Pt", "PT", "fT", "Cp", "C", "t", "", "cCp", "ttp", "PCFt", "P", "pCt", "cP", "Pc"},
                new int[]{2, 6, 6, 2, 4, 4, 5, 0, 5, 5, 6, 6, 3, 5, 6});
    }

    private static void Test(int[] protein, int[] carbs, int[] fat, String[] dietPlans, int[] expected) {
        String result = Arrays.equals(Diet.SelectMeals(protein, carbs, fat, dietPlans), (expected)) ? "PASS" : "FAIL";
        System.out.println(result);
    }
}
