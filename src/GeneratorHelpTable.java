
public class GeneratorHelpTable {
    private String[][] helpTable;
    public void generateHelpTable(String characters[]){
        String[][] table= new String[characters.length+1][characters.length+1];
        table[0][0] = "";
        for(int i = 1; i<=characters.length;i++){
            table[0][i] = characters[i-1];
            table[i][0] = characters[i-1];
        }
        for (int i = 1;i<=characters.length;i++){
            for (int j = i; j<=characters.length;j++){
                if (i==j){
                    table[i][j] = "draw";
                }else if(j-i <= (characters.length-1)/2){
                    table[i][j] = "win";
                    table[j][i] = "lose";
                }else{
                    table[i][j] = "lose";
                    table[j][i] = "win";
                }
            }
        }
        this.helpTable = table;
    }
    public String[][] getTable(){
        return this.helpTable;
    }
    public void printTable(){
        System.out.println("Name of raw - users choice, name of column - computers" +
                " choice\n");
        for (int i = 0;i < helpTable.length;i++){
            for (int j = 0; j < helpTable.length;j++){
                System.out.printf("%10s", helpTable[i][j]);
            }
            System.out.println("");

        }

    }
}
