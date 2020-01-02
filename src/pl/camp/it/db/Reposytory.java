package pl.camp.it.db;

import pl.camp.it.model.Structure;

public class Reposytory {

    private final int size = 6;
    private Structure[] structure = new Structure[size];

    private Reposytory(){
        this.structure[0] = new Structure("Marcin", "Król", 35, "Kraków",
                "Polska", "Europa", "mężczyzna");
        this.structure[1] = new Structure("Miack", "Penks", 45, "Nowy Jork",
                "USA", "Ameryka Północna", "mężczyzna");
        this.structure[2] = new Structure("Zenek", "Miler", 62, "Łódź",
                "Polska", "Europa", "mężczyzna");
        this.structure[3] = new Structure("Elizabeth", "Furry", 33, "Sydney",
                "Australia","Australia", "kobieta");
        this.structure[4] = new Structure("Claudia", "Monterio", 27, "Brazylia",
                "Brazylia","Ameryka Południowa", "kobieta");
    }

    private static Reposytory reposytory = new Reposytory();

    public static Reposytory getReposytory() {
        return reposytory;
    }

    public static void setReposytory(Reposytory reposytory) {
        Reposytory.reposytory = reposytory;
    }

    public Structure[] getStructure(){
        Structure[] tempolary = new Structure[size];
        int i=0;

        // Przepisujemy strukturę do tempa, aby oryginalnej nie ruszać w repozytorium i ją zwracamy
        for(Structure temp: getReposytory().structure){
            tempolary[i++]=temp;
        }
        return tempolary;
    }

}
