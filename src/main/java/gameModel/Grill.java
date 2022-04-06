package gameModel;

public class Grill {
    private GrillField[][] grillFields;
    private int countGrillField;


    public Grill(int countGrillField) {
        this.countGrillField = countGrillField;
        this.grillFields = new GrillField[countGrillField][countGrillField];
        fillGrillFields();
    }

    public GrillField[][] getGrillFields() {
        return grillFields;
    }

    public void setGrillFields(GrillField[][] grillFields) {
        this.grillFields = grillFields;
    }

    private void fillGrillFields()
    {
        for(int grillFieldX=0;grillFieldX<countGrillField;grillFieldX++)
        {
            for(int grillFieldY=0;grillFieldY<countGrillField;grillFieldY++)
            {
                grillFields[grillFieldX][grillFieldY] = new GrillField(0);
            }
        }
    }


}