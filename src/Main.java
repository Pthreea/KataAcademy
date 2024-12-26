import java.util.Scanner;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println(textModifier());

    }

    public static String textModifier(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите текст: ");
        String userInput = scanner.nextLine();

        
        StringBuilder modifiedText = new StringBuilder();
        int sumOfDigits = 0;
        int length = userInput.length();

        for(int i = 0; i < length; i++){
         char currentChar = userInput.charAt(i);

         if(Character.isDigit(currentChar)){
             sumOfDigits += Character.getNumericValue(currentChar);
         } else if (currentChar == '+') {
             modifiedText.append('!');
         } else if (currentChar == '-') {
             if (i > 0 && i < length - 1){
                 char leftChar = userInput.charAt(i - 1);
                 char rightChar = userInput.charAt(i + 1);

                 modifiedText.deleteCharAt(modifiedText.length() - 1); //
                 modifiedText.append(rightChar).append(leftChar);
                 i++;
             }
         }else {
             if(currentChar == ' '){
                 if(modifiedText.length() > 0 && modifiedText.charAt(modifiedText.length() - 1) != ' '){
                     modifiedText.append(currentChar);
                 }
             }else {
                 modifiedText.append(currentChar);
             }
         }

        }

        String result = modifiedText.toString();

        if(sumOfDigits != 0){
            result += " " + sumOfDigits;
        }

        scanner.close();
        return result;

    }

}

