import java.util.ArrayList;

public class Diet {
    public static int[] SelectMeals(int[] protein, int[] carbs, int[] fat, String[] dietPlans)
    {
        int[] output = new int[dietPlans.length];
        int[] calories = new int[protein.length];

        ArrayList<Integer> IndexList = new ArrayList<Integer>();

        for (int i = 0; i < protein.length; i++)
        {
            calories[i] = protein[i] * 5 + carbs[i] * 5 + fat[i] * 9;
            IndexList.add(i);
        }
        for (int i = 0; i < dietPlans.length; i++)
        {
            ArrayList<Integer> IndexListOfSelectedMeals = new ArrayList<Integer>();
            ArrayList<Integer> IndicesListUnderConsideration = IndexList;
            int min = 10000, max = -1;
            for (int j = 0; j < dietPlans[i].length(); j++)
            {
                IndexListOfSelectedMeals = new ArrayList<Integer>();
                switch (dietPlans[i].toCharArray()[j])
                {
                    case 'C' :
                        for (int k : IndicesListUnderConsideration)
                        if (max < carbs[k])
                            max = carbs[k];
                        for (int k : IndicesListUnderConsideration)
                        if (max == carbs[k])
                            IndexListOfSelectedMeals.add(k);
                        break;
                    case 'c' :
                        for (int k : IndicesListUnderConsideration)
                        if (min > carbs[k])
                            min = carbs[k];
                        for (int k : IndicesListUnderConsideration)
                        if (min == carbs[k])
                            IndexListOfSelectedMeals.add(k);
                        break;

                    case 'P' :
                        for (int k : IndicesListUnderConsideration)
                        if (max < protein[k])
                            max = protein[k];
                        for (int k : IndicesListUnderConsideration)
                        if (max == protein[k])
                            IndexListOfSelectedMeals.add(k);
                        break;

                    case 'p' :
                        for (int k : IndicesListUnderConsideration)
                        if (min > protein[k])
                            min = protein[k];
                        for (int k : IndicesListUnderConsideration)
                        if (min == protein[k])
                            IndexListOfSelectedMeals.add(k);
                        break;

                    case 'F' :
                        for (int k : IndicesListUnderConsideration)
                        if (max < fat[k])
                            max = fat[k];
                        for (int k : IndicesListUnderConsideration)
                        if (max == fat[k])
                            IndexListOfSelectedMeals.add(k);
                        break;

                    case 'f' :
                        for (int k : IndicesListUnderConsideration)
                        if (min > fat[k])
                            min = fat[k];
                        for (int k : IndicesListUnderConsideration)
                        if (min == fat[k])
                            IndexListOfSelectedMeals.add(k);
                        break;

                    case 'T' :
                        for (int k : IndicesListUnderConsideration)
                        if (max < calories[k])
                            max = calories[k];
                        for (int k : IndicesListUnderConsideration)
                        if (max == calories[k])
                            IndexListOfSelectedMeals.add(k);
                        break;
                    case 't' :
                        for (int k: IndicesListUnderConsideration)
                        if (min > calories[k])
                            min = calories[k];
                        for (int k : IndicesListUnderConsideration)
                        if (min == calories[k])
                            IndexListOfSelectedMeals.add(k);
                        break;
                }
                if (IndexListOfSelectedMeals.size() == 1)
                    break;
                IndicesListUnderConsideration = IndexListOfSelectedMeals;
            }
            if(dietPlans[i].equals(""))
                IndexListOfSelectedMeals.add(0);
            output[i] = IndexListOfSelectedMeals.get(0);
        }
        return output;
    }
}
