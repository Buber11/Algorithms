public class Sort {

    public static void main(String[] args) {
        int tab[];

        tab = BubbleSort(new int[]{8,9,8,7,6,5,4,3,2});
        print(tab);

    }

    public static void print(int tab[]){
        int i;

        for(i=0;i<tab.length; i++){

            System.out.print(tab[i]);

        }

    }

    public static int[]  BubbleSort(int tab[]){

        int i,j;
        int n  = tab.length;

        for(i = 0; i < n - 1 ; i++){
            for(j = 0; j < n - i - 1; j++){
                if(tab[j] > tab[j+1]){

                    int temp = tab[j];
                    tab[j] = tab[j+1];
                    tab[j + 1] = temp;

                 }
            }
        }

        return tab;
    }

    public static int[] SelectionSort(int tab[]){

        int i,j;
        int min_value;
        int temp;

        for(i = 0; i < tab.length - 1; i++){

            min_value = i;
            for(j = i + 1; j < tab.length; j++){

                if(tab[j] < tab[min_value]){

                    min_value = j;

                }
            }

            temp = tab[i];
            tab[i] = tab[min_value];
            tab[min_value] = temp;

        }

        return tab;
    }



}
