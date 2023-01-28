public class LinkList {
    int max = 50;//pool size
    int AV;//pointer
    int start = 0;
    int[] POOL_LINK = new int[max];//pool array
    Boolean found;
    String[] City = new String[max];
    int[] Headpointer = new int[max];
    int[] Cost = new int[max];
    int[] LINK = new int[max];
    public void Init() {//make pool and set pointer
        for (int i = 0; i < max - 1; i++) {POOL_LINK[i] = i + 1;}
        POOL_LINK[max - 1] = 0;
        AV = 1;
    }

    public int GETNODE() {// get the pointer from pool;
        int reference = 0;
        if (AV == 0) { System.out.println("NO MORE NODES"); }
        else {
            reference = AV;
            AV = POOL_LINK[AV];
        }
        return reference;
    }

    public void display(int pointer) { //print the list
        while (pointer != 0)
        {
            System.out.print(City[pointer] + "\t");
            System.out.println("$"+Cost[pointer]);
            pointer = LINK[pointer];
        }
    }

    void insert(String city, int cost, int Head) {//Add to list
        int pointer = 0;
        pointer = GETNODE();
        City[pointer] = city;
        Cost[pointer] = cost;
        Headpointer[pointer] = Head;
        LINK[pointer] = start;
        start = pointer;
    }
    void insertEnd(String city, int cost, int Head) {//Add but to no next pointer
        int pointer = 0;
        pointer = GETNODE();
        City[pointer] = city;
        Cost[pointer] = cost;
        Headpointer[pointer] = Head;
        LINK[pointer] = 0;
        start = pointer;
    }


    void isDirect(int pointer, String city)
    {
        while (pointer != 0)
        {
            if (city == City[pointer]) {
                System.out.print(City[pointer] + "\t");
                System.out.print("$"+Cost[pointer]);
                System.out.println("\t(Direct Route)");
            }
            pointer = LINK[pointer];
        }
    }

    void isInDirect(int pointer, String city) {
        int pointer2, pointer3, pointer4;
        while (pointer != 0) {
            pointer2 = Headpointer[pointer];
            while (pointer2 != 0){
                pointer3 = Headpointer[pointer2];
                if (city == City[pointer2]) {
                    System.out.print(City[pointer] + "->" + City[pointer2] + "\t");
                    int cost = Cost[pointer] + Cost[pointer2];
                    System.out.print("$"+cost);
                    System.out.println("\t(Indirect Route)");
                }
                while (pointer3 != 0){
                    pointer4 = Headpointer[pointer3];
                    if (city == City[pointer3]) {
                        System.out.print(City[pointer] + "->" + City[pointer2] + "->" + City[pointer3] + "\t");
                        int cost = Cost[pointer] + Cost[pointer2] + Cost[pointer3];
                        System.out.print("$"+cost);
                        System.out.println("\t(Indirect Route)");
                    }
                    while(pointer4 != 0){
                        if (city == City[pointer4]) {
                            System.out.print(City[pointer] + "->" + City[pointer2] + "->" + City[pointer3] + "->" + City[pointer4] +  "\t");
                            int cost = Cost[pointer] + Cost[pointer2] + Cost[pointer3] + Cost[pointer4];
                            System.out.print("$"+cost);
                            System.out.println("\t(Indirect Route)");
                        }
                        pointer4 = LINK[pointer4];
                    }
                    pointer3 = LINK[pointer3];
                }

                pointer2 = LINK[pointer2];
            }
            pointer = LINK[pointer];
        }
    }

    void creatlist(){

        insert("Miami", 90, 5);
        insert("Dallas", 125, 9);
        insert("Denver", 100, 11);
        insert("Chicago", 50, 7);//new york4

        insertEnd("Dallas", 50, 9);//Miami5

        insertEnd("San Francisco", 25, 13);
        insert("Denver", 20, 11);//Chicago7

        insertEnd("San Diego", 90, 12);
        insert("L.A.", 80, 0);//Dallas9

        insertEnd("San Francisco", 75, 13);
        insert("L.A.", 100, 0);//Denver11

        insertEnd("L.A.", 45, 0);//SanDiego12

        insertEnd("L.A.", 45, 0);//SanFrancisco13
    }

}
