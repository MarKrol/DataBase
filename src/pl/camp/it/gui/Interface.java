package pl.camp.it.gui;

import pl.camp.it.methods.Methods;
import pl.camp.it.model.Structure;

import java.util.Scanner;

public class Interface extends Methods{

    private void printMainMenu(){
        System.out.println("------------------------- Main Menu -------------------------");
        System.out.println("1. Wyświetl wszystkie zapisane osoby w bazie");
        System.out.println("2. Wyświelt wszystkie kobiety znajdujące sie w baze");
        System.out.println("3. Wyświetl wszystkich mężczyzn znajdujących się w bazie");
        System.out.println("4. Aktualizuj dane osoby znjadującej się w bazie");
        System.out.println("5. Wyjście z programu");
        System.out.println("-------------------------------------------------------------");
        System.out.println();
        System.out.print("Wybrałeś z Main Menu opcję numer: ");
    }

    private void printSubmenuMenu4(){
        System.out.println("------------------------- Submenu Opcji 4 -------------------------");
        System.out.println("1. Wyszukaj osoby do aktualizacji danych po nazwisku");
        System.out.println("2. Wyszukaj osoby do aktualizacji danych po płci");
        System.out.println("3. Powrót do Main Menu");
        System.out.println("-------------------------------------------------------------------");
        System.out.println();
        System.out.print("Wybrałeś z Submenu Opcji 4 opcję numer: ");
    }

    public void showMainMenu(){
        printMainMenu();
        switch(readNumberOptionMainMenu()){
            case "1":
                System.out.println("\n" + "W bazie znajdują się następujące osoby: "+ "\n");
                showReposytory();
                returnToMenu();
                break;
            case "2":
                System.out.println("\n" + "W bazie znajdują się następujące kobiety: "+ "\n");
                showOnlyWomen();
                returnToMenu();
                break;
            case "3":
                System.out.println("\n" + "W bazie znajdują się następujący mężczyźni: "+ "\n");
                showOnlyMen();
                returnToMenu();
                break;
            case "4":
                System.out.println();
                showSubmenuMenu4();
                break;
            case "5":
                System.out.println("\n"+"Zakończyłeś działanie programu. Do zobaczenia.");
                System.exit(0);  //Wyjście z programu;
                break;
            default:
                System.out.println("\n"+"Wprowadzono błędny numer opcji Main Menu!!! Wprowadź poprawny numer!!!"+"\n");
                break;
        }
        showMainMenu();
    }

    private void showSubmenuMenu4(){
        printSubmenuMenu4();
        switch(readNumberOptionMainMenu()){
            case "1":
                System.out.println("W trakcie pracy :) ");
                break;
            case "2":
                changeData();
                break;
            case "3":
                System.out.println();
                showMainMenu();
                break;
            default:
                System.out.println("\n"+"Wprowdzono błędny numer opcji Submenu Opcji 4!!! Wprowadź poprawny numer!!!"+"\n");
                break;
        }
        showSubmenuMenu4();
    }

    public String readNumberOptionMainMenu(){
        return new Scanner(System.in).nextLine();
    }

    private void returnToMenu(){
        do{
            System.out.println("\n"+"Naciśnij SPACJĘ, a nstępnie ENTER aby wrócić do Main Menu!");
        } while (!readNumberOptionMainMenu().equals(" "));
        System.out.println();
    }

    private String SpecifiedSex(){
        String sex;
        System.out.print("\n"+ "Określ płeć naciskając przycisk 'K' lub 'M': ");
        while(!isSpecifiedSex(sex=readNumberOptionMainMenu())){
            System.out.print("Niepoprawnie określona płeć!!! "+"\n");
            System.out.print("\n"+ "Określ płeć naciskając przycisk 'K' lub 'M': ");
        }
        System.out.println();

        return sex;
    }

    private String SpecifiedIndex(){
        String index;
        System.out.print("\n"+ "Wprowadź indeks osoby do zmiany: ");
        while(!isSpecifieldIndex(index=readNumberOptionMainMenu())){
            System.out.print("Niepoprawny indeks!!! "+"\n");
            System.out.print("\n"+ "Wprowadź indeks osoby do zmiany: ");
        }
        System.out.println();

        return index;
    }

    private void changeData(){
        switch(SpecifiedSex().toUpperCase()){
            case "K":
                showOnlyWomen();
                isEmptyBazaWomen();
                break;
            case "M":
                showOnlyMen();
                isEmptyBazaMen();
                break;
            default:
                System.out.print("Niepoprawnie określona płeć!!! "+"\n");
                changeData();
        }
    }

    private void isEmptyBazaWomen(){
        if (getIndex()>0) {
            changeDataPerson(SpecifiedIndex(), "kobieta");
        } else {
            System.out.println("W bazie nie znajdują się kobiety!!! Nie można dokonać w niej zmian!!!"+"\n");
        }
    }

    private void isEmptyBazaMen(){
        if (getIndex()>0) {
            changeDataPerson(SpecifiedIndex(), "mężczyzna");
        } else {
            System.out.println("W bazie nie znajdują się mężczyźni!!! Nie można dokonać w niej zmian!!!"+"\n");
        }
    }

}
