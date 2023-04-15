package arrays;

/**
 * Created by libsys on 7/18/2022.
 */
public class ContainerWitMostWater {

    public static int maxArea(int[] height) {

        int area = 0;

        int i = 0, j = height.length - 1;
        while (i < j) {
            int currArea = Math.min(height[i], height[j]) * (j - i);

            area = Math.max(area, currArea);
            /**
              * if both height equals does not matter which way you move
              * you are looking for a higher height on both sides from there on anyway
              *
             **/
            if (height[i] < height[j])
                i++;
            else
                j--;
        }

        return area;
    }

    public static void main(String[] args){
        int arr[] = {1,8,6,2,5,4,8,3,7};
        System.out.print(maxArea(arr));
    }
}
