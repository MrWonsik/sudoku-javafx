package gameModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainGrill {
    private Grill[][] grills;
    private int sizeOfGrill;

    public MainGrill(int sizeOfGrill)
    {
        this.sizeOfGrill = sizeOfGrill;
        grills = new Grill[sizeOfGrill][sizeOfGrill];
        for(int grillX=0;grillX<sizeOfGrill;grillX++)
        {
            for(int grillY=0;grillY<sizeOfGrill;grillY++)
            {
                grills[grillX][grillY] = new Grill(sizeOfGrill);
            }
        }
    }

    private void clearMainGrill()
    {
        for (int grillX = 0; grillX < sizeOfGrill; grillX++) {
            for(int grillY = 0; grillY < sizeOfGrill; grillY++)
            {
                for (int grillFieldX = 0; grillFieldX < sizeOfGrill; grillFieldX++) {
                    for (int grillFieldY = 0; grillFieldY < sizeOfGrill; grillFieldY++) {
                        grills[grillX][grillY].getGrillFields()[grillFieldX][grillFieldY].setNumber(0);
                    }
                }
            }
        }
    }

    public int getSizeOfGrill() {
        return sizeOfGrill;
    }

    public void setSizeOfGrill(int sizeOfGrill) {
        this.sizeOfGrill = sizeOfGrill;
    }

    public Grill[][] getGrills() {
        return grills;
    }

    public void setGrills(Grill[][] grills)
    {
        this.grills = grills;
    }

    public void fillGrills() {
        for(int grillX=0;grillX<sizeOfGrill;grillX++)
        {
            for(int grillY=0;grillY<sizeOfGrill;grillY++)
            {
                grills[grillX][grillY]= new Grill(sizeOfGrill);
            }
        }

        long startTime = System.currentTimeMillis();
        for (int grillX = 0; grillX < sizeOfGrill; grillX++) {
            for (int grillY = 0; grillY < sizeOfGrill; grillY++) {
                for (int grillFieldX = 0; grillFieldX < sizeOfGrill; grillFieldX++) {
                    for (int grillFieldY = 0; grillFieldY < sizeOfGrill; grillFieldY++) {
                        int number = grills[grillX][grillY].getGrillFields()[grillFieldX][grillFieldY].setAndReturnRandomNumber(checkPossibleNumberHorizontalAndVertical(grillX, grillY, grillFieldX, grillFieldY));

                        //Jeżeli któraś z liczb po drodze nie może znaleźć odpowiednika, do wstawienia w dane miejsce, plansza generowana jest od nowa.
                        if (number == 0) {
                            clearMainGrill();
                            grillX = 0;
                            grillY = 0;
                            grillFieldX = 0;
                            grillFieldY = -1;
                        }
                    }
                }
            }
        }
        long stopTime = System.currentTimeMillis();
        long timeOfGenerateGrill = stopTime - startTime;
    }

    public void showGrills()
    {
        for(int i=0; i<sizeOfGrill;i++)
        {
            for(int k=0;k<sizeOfGrill;k++)
            {
                for(int j=0;j<sizeOfGrill;j++)
                {
                    for(int m=0;m<sizeOfGrill;m++)
                    {
                       System.out.print(grills[i][j].getGrillFields()[k][m].getNumber() + " ");
                    }
                    System.out.print(" ");
                }

                System.out.println();
            }
            System.out.println();
        }
    }

    private List<Integer> checkPossibleNumberHorizontalAndVertical(int grillX, int grillY, int grillFieldX, int grillFieldY)
    {
        List<Integer> possibleNumbers = new ArrayList<>();
        for(int numberToCheck=1; numberToCheck<sizeOfGrill*sizeOfGrill+1;numberToCheck++) {
            if(checkNumberInLineHorizontal(numberToCheck, grillX, grillFieldX) && checkNumberInLineVertical(numberToCheck, grillY, grillFieldY) && checkNumberInGrill(numberToCheck, grillX, grillY))
            {
                possibleNumbers.add(numberToCheck);
            }
        }

        return possibleNumbers;
    }

    private boolean checkNumberInLineHorizontal(int numberToCheck, int grillX, int grillFieldX)
    {
        for(int grillY=0; grillY<sizeOfGrill; grillY++)
        {
            for(int grillFieldY=0; grillFieldY<sizeOfGrill; grillFieldY++)
            {
                if(grills[grillX][grillY].getGrillFields()[grillFieldX][grillFieldY].getNumber()==numberToCheck)
                {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean checkNumberInLineVertical(int numberToCheck, int grillY, int grillFieldY)
    {
        for(int grillX=0; grillX<sizeOfGrill; grillX++)
        {
            for(int grillFieldX=0; grillFieldX<sizeOfGrill; grillFieldX++)
            {
                if(grills[grillX][grillY].getGrillFields()[grillFieldX][grillFieldY].getNumber()==numberToCheck)
                {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean checkNumberInGrill(int numberToCheck, int grillX, int grillY)
    {
        for(int grillFieldX=0; grillFieldX<sizeOfGrill; grillFieldX++)
        {
            for(int grillFieldY=0; grillFieldY<sizeOfGrill; grillFieldY++)
            {
                if(grills[grillX][grillY].getGrillFields()[grillFieldX][grillFieldY].getNumber()==numberToCheck)
                {
                    return false;
                }
            }
        }

        return true;
    }

    public void cleanRandomGrillField(int countRandomNumber)
    {

        Random randomInt = new Random();
        int grillX;
        int grillY;
        int grillFieldX;
        int grillFieldY;
        int fails=0;
        for(int i=0; i<countRandomNumber;i++)
        {
            grillX = randomInt.nextInt(sizeOfGrill);
            grillY = randomInt.nextInt(sizeOfGrill);
            grillFieldX = randomInt.nextInt(sizeOfGrill);
            grillFieldY = randomInt.nextInt(sizeOfGrill);

            //Sprawdzanie unikalności sudoku, przed wstawieniem sprawdzane jest, czy można tam wstawić inną liczbę oprócz tej docelowej.
            if(checkPossibleNumberHorizontalAndVertical(grillX, grillY, grillFieldX, grillFieldY).size()==0)
            {
                grills[grillX][grillY].getGrillFields()[grillFieldX][grillFieldY].setNumber(0);
            }
            else
            {
                i--;
                fails++;
            }
            if(fails>81)
            {
                break;
            }


        }
    }

    public static void cloneGrills(MainGrill fromGrill, MainGrill toGrill) {

        for (int grillX = 0; grillX < fromGrill.sizeOfGrill; grillX++) {
            for (int grillY = 0; grillY < fromGrill.sizeOfGrill; grillY++) {
                for (int grillFieldX = 0; grillFieldX < fromGrill.sizeOfGrill; grillFieldX++) {
                    for (int grillFieldY = 0; grillFieldY < fromGrill.sizeOfGrill; grillFieldY++) {
                        toGrill.getGrills()[grillX][grillY].getGrillFields()[grillFieldX][grillFieldY].setNumber(fromGrill.getGrills()[grillX][grillY].getGrillFields()[grillFieldX][grillFieldY].getNumber());
                    }
                }
            }
        }
    }


    public boolean equals(MainGrill grillToEquals)
    {
        for(int grillX=0; grillX<sizeOfGrill; grillX++) {
            for(int grillY=0; grillY<sizeOfGrill; grillY++) {
                for(int grillFieldX=0; grillFieldX<sizeOfGrill; grillFieldX++) {
                    for(int grillFieldY=0; grillFieldY<sizeOfGrill; grillFieldY++) {
                        if (grills[grillX][grillY].getGrillFields()[grillFieldX][grillFieldY].getNumber() != grillToEquals.getGrills()[grillX][grillY].getGrillFields()[grillFieldX][grillFieldY].getNumber()) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
