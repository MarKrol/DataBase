package pl.camp.it.methods;

import pl.camp.it.db.Reposytory;
import pl.camp.it.gui.Interface;
import pl.camp.it.model.Structure;
import sun.security.x509.OtherName;

import java.util.Scanner;

public class Methods {
    private int index = 0;

    //Określa liczbę osób w bazie w zależności od wyboru
    public int getIndex() {
        return index;
    }

    public void showReposytory(){
        int index = 0;
        showFieldName();
        System.out.println();
        for (Structure temp: Reposytory.getReposytory().getStructure()){
            if (temp != null) {
                System.out.print(++index + ". ");
                System.out.println(temp);
            }
        }
        this.index = index;
    }

    public void showOnlyWomen(){
        int index = 0;
        boolean findwomen = false;
        showFieldName();
        System.out.println();
        for(Structure temp: Reposytory.getReposytory().getStructure()){
            if (temp !=null){
                if (temp.getSex() == "kobieta"){
                    findwomen = true;
                    System.out.print(++index + ". ");
                    System.out.println(temp);
                }
            }
        }
        if (!findwomen) {
            System.out.println("\n"+"Nie występują kobiety w bazie!!!"+"\n");
        }
        this.index = index;
    }

    public void changeDataPerson(String i, String sex){
        int index = 0;
        Structure[] tempolary = Reposytory.getReposytory().getStructure();

        for (Structure temp: Reposytory.getReposytory().getStructure()){
            if (temp != null){
                if ((temp.getSex() == sex) && (++index == Integer.parseInt(i))){
                    tempolary[index-1] = newDataPerson(temp);
                }
            }
        }
    }

    private String readNewDataPerson(){
        return new Scanner(System.in).nextLine();
    }

    private boolean isreadNewDataPersonNotEmpty(String data){
        if (!data.equals("")){
            return true;
        }else {
            return false;
        }
    }

    private String newDataNotEmpty(){
        String data;
        System.out.print("\n"+ "Wprowadź dane: ");
        while(!isreadNewDataPersonNotEmpty(data=readNewDataPerson())){
            System.out.print("Nie wprowadzono danych lub dane nie są poprawne!!! "+"\n");
            System.out.print("\n"+ "Wprowadź Dane: ");
        }
        System.out.println();

        return data;
    }

    private int newDataInt(){
        int data = 0;
        String s;
        System.out.print("\n"+ "Wprowadź dane: ");
        while(!isreadNewDataPersonNotEmpty(s = readNewDataPerson()) || ((data = isIntegerString(s.trim())) == 0)) {
            System.out.print("Nie wprowadzono danych lub wprowadzono niepoprawne dane!!! "+"\n");
            System.out.print("\n"+ "Wprowadź Dane: ");
        }
        System.out.println();

        return data;
    }

    private void newNamePerson(Structure temp){
        System.out.println("Aktualne imię: " + temp.getName());
        System.out.println();
        System.out.print("Poniżej wprowadź nowe imię! ");
        temp.setName(newDataNotEmpty());
    }

    private void newSurnamePerson(Structure temp){
        System.out.println("Aktualne nazwisko: " + temp.getSurname());
        System.out.println();
        System.out.print("Poniżej wprowadź nowe nazwisko! ");
        temp.setSurname(newDataNotEmpty());
    }

    private void newAgePerson(Structure temp){
        System.out.println("Aktualny wiek: " + temp.getAge());
        System.out.println();
        System.out.print("Poniżej wprowadż nowy wiek! ");
        temp.setAge(newDataInt());
    }

    private void newCityPerson(Structure temp){
        System.out.println("Aktualne miasto: " + temp.getCity());
        System.out.println();
        System.out.print("Poniżej wprowadź nowe miasto! ");
        temp.setCity(newDataNotEmpty());
    }

    private void newCountryPerson(Structure temp){
        System.out.println("Aktualne kraj: " + temp.getCountry());
        System.out.println();
        System.out.print("Poniżej wprowadź nowy kraj! ");
        temp.setCountry(newDataNotEmpty());
    }

    private void newContinentPerson(Structure temp){
        System.out.println("Aktualne kontynent: " + temp.getContinent());
        System.out.println();
        System.out.print("Poniżej wprowadź nowy kontynent! ");
        temp.setContinent(newDataNotEmpty());
    }

    private void newSexPerson(Structure temp){
        String sex="";
        System.out.println("Aktualne płeć: " + temp.getSex());
        System.out.println();
        System.out.print("Poniżej wprowadź płeć osoby wybierając małe/duże 'K' lub 'M'! ");

        while (!isSpecifiedSex(sex=newDataNotEmpty())){
            System.out.print("Nie wprowadzono danych lub wprowadzono niepoprawne dane!!! "+"\n");
        }

        if (sex.toUpperCase().equals("K")){
            sex = "kobieta";
        }
        if (sex.toUpperCase().equals("M")){
            sex = "mężczyzna";
        }

        temp.setSex(sex);
    }


    private Structure newDataPerson(Structure temp){
        newNamePerson(temp);
        newSurnamePerson(temp);
        newAgePerson(temp);
        newCityPerson(temp);
        newCountryPerson(temp);
        newContinentPerson(temp);
        newSexPerson(temp);

        return temp;
    }

    public void showOnlyMen(){
        int index = 0;
        boolean findMen = false;
        showFieldName();
        System.out.println();
        for(Structure temp: Reposytory.getReposytory().getStructure()){
            if (temp !=null){
                if (temp.getSex() == "mężczyzna"){
                    findMen = true;
                    System.out.print(++index + ". ");
                    System.out.println(temp);
                }
            }
        }
        if (!findMen) {
            System.out.println("\n"+"Nie występują mężczyźni w bazie!!!"+"\n");
        }

        this.index = index;
    }

    private void showFieldName(){
        System.out.format("%-13s %-30s %-35s %-10s %-30s %-30s %-30s %-20s", "[Indeks]","[Imię]",
                "[Nazwisko]", "[Wiek]","[Maisto]", "[Kraj]", "[Kontynent]", "[Płeć]");
    }

    protected boolean isSpecifiedSex(String sex){
        if (sex.equals("k") || sex.equals("K") || sex.equals("m") || sex.equals("M")) {
            return true;
        }else {
            return false;
        }
    }

    protected boolean isSpecifieldIndex(String index){
        boolean trueorfalse = false;
        try {                               //obsługa wyjątków
            if (Integer.parseInt(index.trim()) > 0 && Integer.parseInt(index.trim())<= this.index){ //pozbycie się wszystkich białych znaków w słowie
                trueorfalse = true;
            }
        }
        catch (NumberFormatException nfe){
            trueorfalse = false;
        }
        return trueorfalse;
    }

    protected int isIntegerString(String string){
        int value=0;
        try {                               //obsługa wyjątków
            if (Integer.parseInt(string.trim())>0 && (Integer.parseInt(string.trim())<130)){
                value = Integer.parseInt(string.trim());
            }
        }
        catch (NumberFormatException nfe){
            value = 0;
        }
        return value;
    }
}
