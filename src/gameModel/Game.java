package gameModel;

import static java.lang.Math.pow;

public class Game {
    private String lvl;
    private int sizeOfGrill;
    private int startCountNumber;
    private int hint;
    private GameTime gameTime;

    private MainGrill mainGrill;
    private MainGrill grillToGame;
    private MainGrill usersGrill;

    public Game(String lvl, int sizeOfGrill)  {
        this.lvl = lvl;
        hint=5;
        switch(this.lvl) {
            case ("easy"):
                startCountNumber = (int)pow(sizeOfGrill,4)/3;
                break;
            case ("med"):
                startCountNumber = (int)pow(sizeOfGrill,4)/2;
                break;
            case ("hard"):
                startCountNumber = (int)pow(sizeOfGrill,4)/1;
                break;
        }

        this.sizeOfGrill = sizeOfGrill;
        mainGrill = new MainGrill(this.sizeOfGrill);
        mainGrill.fillGrills();

        grillToGame = new MainGrill(this.sizeOfGrill);
        usersGrill = new MainGrill(this.sizeOfGrill);

        MainGrill.cloneGrills(mainGrill, grillToGame);

        grillToGame.cleanRandomGrillField(startCountNumber);
        MainGrill.cloneGrills(grillToGame, usersGrill);

        gameTime = new GameTime();

    }

    public String getLvl() {
        return lvl;
    }

    public void setLvl(String lvl) {
        this.lvl = lvl;
    }

    public int getSizeOfGrill() {
        return sizeOfGrill;
    }

    public void setSizeOfGrill(int sizeOfGrill) {
        this.sizeOfGrill = sizeOfGrill;
    }

    public int getStartCountNumber() {
        return startCountNumber;
    }

    public void setStartCountNumber(int startCountNumber) {
        this.startCountNumber = startCountNumber;
    }

    public MainGrill getMainGrill() {
        return mainGrill;
    }

    public void setMainGrill(MainGrill mainGrill) {
        this.mainGrill = mainGrill;
    }

    public MainGrill getGrillToGame() {
        return grillToGame;
    }

    public void setGrillToGame(MainGrill grillToGame) {
        this.grillToGame = grillToGame;
    }

    public int getHint() {
        return hint;
    }

    public void setHint(int hint) {
        this.hint = hint;
    }

    public MainGrill getUsersGrill() {
        return usersGrill;
    }

    public void setUsersGrill(MainGrill usersGrill) {
        this.usersGrill = usersGrill;
    }

    public GameTime getGameTime() {
        return gameTime;
    }

    public void setGameTime(GameTime gameTime) {
        this.gameTime = gameTime;
    }

    public int[][] getValidateTable()
    {
        int[][] tableValidate = new int[sizeOfGrill*sizeOfGrill][sizeOfGrill*sizeOfGrill];
        for(int grillX=0; grillX<sizeOfGrill;grillX++)
        {
            for(int grillY=0; grillY<sizeOfGrill; grillY++)
            {
                for(int grillFieldX=0; grillFieldX<sizeOfGrill; grillFieldX++)
                {
                    for(int grillFieldY=0; grillFieldY<sizeOfGrill; grillFieldY++)
                    {
                        if(usersGrill.getGrills()[grillX][grillY].getGrillFields()[grillFieldX][grillFieldY].getNumber()
                                != mainGrill.getGrills()[grillX][grillY].getGrillFields()[grillFieldX][grillFieldY].getNumber())
                        {
                            if(usersGrill.getGrills()[grillX][grillY].getGrillFields()[grillFieldX][grillFieldY].getNumber() == 0)
                            {
                                tableValidate[grillX*sizeOfGrill+grillFieldX][grillY*sizeOfGrill+grillFieldY] = 2;
                            }
                            else
                            {
                                tableValidate[grillX*sizeOfGrill+grillFieldX][grillY*sizeOfGrill+grillFieldY] = 0;
                                //System.out.println("Na Czerwono: GrillX: " + grillX + ", GrillY: " + grillY + ", GrillFieldX: " + grillFieldX + ", GrillFieldY: " + grillFieldY);
                            }

                        }
                        else {
                            if (grillToGame.getGrills()[grillX][grillY].getGrillFields()[grillFieldX][grillFieldY].getNumber() != 0) {
                                tableValidate[grillX*sizeOfGrill+grillFieldX][grillY*sizeOfGrill+grillFieldY] = 2;
                            } else {
                                tableValidate[grillX*sizeOfGrill+grillFieldX][grillY*sizeOfGrill+grillFieldY] = 1;
                                //System.out.println("Na Zielono: GrillX: " + grillX + ", GrillY: " + grillY + ", GrillFieldX: " + grillFieldX + ", GrillFieldY: " + grillFieldY);
                            }
                        }
                    }
                }
            }
        }

        return tableValidate;
    }

    public boolean checkWin()
    {
        return usersGrill.equals(mainGrill);
    }

}
