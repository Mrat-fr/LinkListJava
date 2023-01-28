public class Project3 {
    public static void main(String[] args) {
        java.util.Scanner input=new java.util.Scanner(System.in);

        LinkList List = new LinkList();
        List.Init();
        List.creatlist();

        int From, To;
        String ToName = null;
        boolean mainLoop = true;
        while(mainLoop) {
            System.out.println("------------------------------");
            System.out.println("Transporting items from cities");
            System.out.println("------------------------------");
            System.out.println("          Pick a city         ");
            System.out.println("1) New York       2) Miami");
            System.out.println("3) Chicago        4) Dallas");
            System.out.println("5) Denver         6) San Diego");
            System.out.println("7) San Francisco  8) L.A.");
            System.out.println("            0) Exit          ");
            System.out.print("/");
            From = input.nextInt();
            if(From !=0 || From !=8) {
                System.out.println("------------------------------");
                System.out.println("     Pick a city to go to     ");
                System.out.print("/");
                To = input.nextInt();
                if (To == 1 || To == 2 || To == 3 || To == 4 || To == 5 || To == 6 || To == 7 || To == 8) {
                    if (To == 1) {ToName = "New York";}
                    if (To == 2) {ToName = "Miami";}
                    if (To == 3) {ToName = "Chicago";}
                    if (To == 4) {ToName = "Dallas";}
                    if (To == 5) {ToName = "Denver";}
                    if (To == 6) {ToName = "San Diego";}
                    if (To == 7) {ToName = "San Francisco";}
                    if (To == 8) {ToName = "L.A.";}
                } else
                    From = 10;
            }
            switch (From){
                case 1 ->{
                    System.out.println("-----------------------------");
                    System.out.println("-----------New York----------");
                    List.isDirect(4, ToName);
                    List.isInDirect(4, ToName);
                }
                case 2 ->{
                    System.out.println("-----------------------------");
                    System.out.println("------------Miami------------");
                    List.isDirect(5, ToName);
                    List.isInDirect(5, ToName);
                }
                case 3 ->{
                    System.out.println("-----------------------------");
                    System.out.println("-----------Chicago-----------");
                    List.isDirect(7, ToName);
                    List.isInDirect(7, ToName);
                }
                case 4 ->{
                    System.out.println("------------------------------");
                    System.out.println("------------Dallas------------");
                    List.isDirect(9, ToName);
                    List.isInDirect(9, ToName);
                }
                case 5 ->{
                    System.out.println("------------------------------");
                    System.out.println("------------Denver------------");
                    List.isDirect(11, ToName);
                    List.isInDirect(11, ToName);
                }
                case 6 ->{
                    System.out.println("-----------------------------");
                    System.out.println("----------San Diego----------");
                    List.isDirect(12, ToName);
                    List.isInDirect(12, ToName);
                }
                case 7 ->{
                    System.out.println("-----------------------------");
                    System.out.println("--------San Francisco--------");
                    List.isDirect(13, ToName);
                    List.isInDirect(13, ToName);
                }
                case 8 ->{
                    System.out.println("-----------------------------");
                    System.out.println("-------------L.A.------------");
                    System.out.println("   You can go to no cities   ");
                }
                case 0 ->{
                    System.out.println("-------------------------------");
                    System.out.println("------EXITING APPLICATION------");
                    System.out.println("-------------------------------");
                    mainLoop = false;
                }
                default -> {
                    System.out.println("Invalid input");
                    System.out.println("");
                }
            }
        }
    }
}

