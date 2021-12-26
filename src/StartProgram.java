import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class StartProgram {
    private String[] characters;
    private GeneratorKeys generator = new GeneratorKeys();
    private GeneratorHelpTable generatorHelpTable = new GeneratorHelpTable();
    private Scanner scanner = new Scanner(System.in);
    public void startGame(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        String[] characters = new String[args.length];
        this.characters = characters;
        if(args.length == 0){
            System.out.println("Empty input. Please retry");
            System.exit(0);
        }else {
            for (int i = 0; i < args.length; i++) {
                characters[i] = args[i];
            }
        }
        for(int i = 0;i<characters.length-1;i++){
            for(int j = i+1;j< characters.length;j++){
                if(characters[i].equalsIgnoreCase(characters[j])){
                    System.out.println("Invalid input. There must be no equal characters." +
                            " Please retry");
                    System.exit(0);
                }
            }

        }
        if(characters.length % 2 == 0 || characters.length <=1){
            System.out.println("Your input is incorrect. The amount of characters must be " +
                    "odd and >=3");
            System.exit(0);
        }


        int computerCommand = 0;
        computerCommand = (int)(1+Math.random()*(characters.length));
        generatorHelpTable.generateHelpTable(characters);
        generator.generateKey(characters[computerCommand-1]);

        System.out.println("Available moves:");
        for (int i = 0; i< characters.length; i++){
            System.out.println(i+1 + " - " + characters[i]);
        }
        System.out.print("0 - exit\n404 - help table\n");
        int usersMove = 0;
        do{
            usersMove = inputAndCheckCommand(computerCommand);
            if (usersMove == 404){
                generatorHelpTable.printTable();
            }else if(usersMove == 0){
                System.exit(0);
            }else{
                Rules game = new Rules();
                System.out.println("Your move: "+ characters[usersMove-1]+"\n" +
                        "Computer move: "+characters[computerCommand-1]);
                System.out.println("Result: "+game.playGame(usersMove,computerCommand,generatorHelpTable));
                System.out.println("HMAC key: "+generator.getKey());
            }
        }while(usersMove==404);




    }
    public int inputAndCheckCommand(int computerCommand){
        System.out.println("Enter your move: ");
        int command = 0;
        while (true){
            try {
                command = scanner.nextInt();
                if (((command > characters.length)&&(command!=404)) || (command < 0)){
                    throw new NumberFormatException();
                }else{break;}

            }catch (Exception ex){
                System.out.println("Your input is incorrect. Choose item " +
                        "from the menu and try again.");
                scanner.nextLine();
            }
        }


        return command;

    }
}
