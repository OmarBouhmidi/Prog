public class Rekursjon {

    //Oppgave 1
    static int sum(int x) {
        if(x>0){
            return x+sum(x-1);
    }else return 0;
    }

    //Oppgave 2
    static int pow(int base, int exponent){
        if(exponent>0){
            return base*pow(base, exponent-1);
        }else return 1;
    }

    //Oppgave 3
    static void listElements(int[]array, int length){
        if(length == 1){
            System.out.println(array[length-1]);
            return;
        }
        System.out.print(array[length-1]+" ");
        listElements(array, --length);
    }

    //Oppgave4
    static int minVerdi(int[]array, int length){
        if(length==1){
            return array[length-1];
        }
        return Math.min(array[length-1],minVerdi(array, length-1));
    }

    //Oppgave5
    static boolean sokeIArray(int[]array, int length, int tall){
        if(array[length-1]==tall){
            System.out.println("Tallet "+tall+" finnes i arrayet.");
            return true;
        }
        else if(length==1){
            System.out.println("Tallet "+tall+" finnes ikke i arrayet.");
            return false;
        }
        else return sokeIArray(array,length-1,tall);

    }


    public static void main(String [] args){
        //Oppgave1
      System.out.println ("SUM:"+sum(5));

        //Oppgave2
      System.out.println("POW:"+pow(10, 3));
        //Oppgave3
        int[] arrays = {1,2,3,4,5,6,7,8,9,10};
        listElements(arrays, arrays.length);

        //Oppgave4
        System.out.println("Minste verdi: "+minVerdi(arrays,arrays.length));

        //Oppgave5
        sokeIArray(arrays,arrays.length,30);
    }
}
