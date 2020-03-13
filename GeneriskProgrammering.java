
//Oppgave 2.1

import java.util.AbstractList;

public class GeneriskProgrammering {

    static <T> void skrivUtArray (T[] liste){
        for(Object o : liste){
            System.out.println(o);
        }
    }
//Oppgave 2.2
    static <T> void reverserArray (T[] liste){
        for(int i = 0; i<liste.length/2; i++){
            T a = liste[i];
            liste[i]=liste[liste.length-i-1];
            liste[liste.length-i-1]=a;
        }
    }
    //Oppgave3
    static class StatiskArrayList<T> extends AbstractList<T> {
        private Object[] array;
        private int teller = 0;
        private int lengde;

        public StatiskArrayList(int lengde){
            this.lengde = lengde;
            array = new Object[lengde];
        }

        public int size(){
            return lengde;
        }

        public boolean add(T element){
            if(teller == lengde){
                return false;
            }
            else{
                array[teller]=element;
                teller++;
                return true;
            }
        }

        public T get(int index) {
            if(index>lengde || index<0){
                throw new IndexOutOfBoundsException();
            }
            return (T) array[index];
        }

    }

    public static void main(String [] args){
        String[] liste = new String[3];
        liste[0]="a";
        liste[1]="b";
        liste[2]="c";

        Integer[] tall = new Integer[3];
        tall[0]=3;
        tall[1]=4;
        tall[2]=5;

        skrivUtArray(tall);
        reverserArray(tall);
        skrivUtArray(tall);

       //Oppgave3
        StatiskArrayList<Integer> nyttArray = new StatiskArrayList<>(5);
        nyttArray.add(3);
        nyttArray.add(5);
        nyttArray.add(8);
        nyttArray.add(9);
        nyttArray.add(1);

        System.out.println ("ARRAY: "+ nyttArray);
        System.out.println("Hent verdi fra index: "+nyttArray.get(3));
        }


    }

