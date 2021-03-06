package dijkstra;

public class _dijkstra{

    static int number = 6;
    static int INF = 10000;

    static int a[][] = new int[][]
    {
        {0, 2, 5, 1, INF, INF},
        {2, 0, 3, 2, INF, INF},
        {5, 3, 0, 3,   1,   5},
        {1, 2, 3, 0,   1, INF},
        {INF, INF, 1, 1, 0 ,2},
        {INF, INF, 5, INF, 2, 0}
    };

    static boolean v[] = new boolean[6];
    static int d[] = new int[6];

    static int getSmallIndex(){
        int min = INF;
        int index = 0;
        for(int i = 0; i < number; i++){
            if(d[i] < min && !v[i]){
                min = d[i];
                index = i;
            }
        }
        
        return index;
    }

    static void dijkstra(int start){
        for(int i = 0 ; i < number ; i++){
            d[i] = a[start][i];
        }
        v[start] = true;

        for(int i = 0 ; i < number -2 ; i++){
            int current = getSmallIndex();
            v[current] = true;
            for(int j = 0 ; j < 6 ; j++){
                if(!v[j]){
                    if(d[current] + a[current][j] < d[j]){
                        d[j] = d[current] + a[current][j];
                    }
                }
            }
        }
    }
// O(nlogn) ����ȭ : https://jason9319.tistory.com/307

    public static void main(String args[]){
        dijkstra(0);
        for(int i = 0 ; i < number ; i++){
            System.out.print(d[i]+" ");
        }
    }
}