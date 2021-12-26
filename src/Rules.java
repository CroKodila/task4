public class Rules {

    public String playGame(int command,int computerCommand,GeneratorHelpTable generatorHelpTable){
        String table[][] = generatorHelpTable.getTable();
        return table[command][computerCommand];
    }
}
