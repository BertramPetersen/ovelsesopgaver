package Moldul3_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Matrix {
    double[][] data;

    public Matrix(String filename){
        File file = new File(filename);

//        try{
//            Scanner scanner = new Scanner(file);

        // Closes scanner when try block is terminated
        try(Scanner scanner = new Scanner(file)){

            String numbers = scanner.nextLine();
            String[] splitNumbers = numbers.split(",");
            int numberOfColumns = splitNumbers.length;

            int numberOfRows = 1;

            while(scanner.hasNextLine()){
                numberOfRows++;
                scanner.nextLine();
            }
            this.data = new double[numberOfColumns][numberOfColumns];
            try (Scanner newScanner = new Scanner(file)){
                for (int row = 0; scanner.hasNextLine(); row++) {
                    String numbersRead = newScanner.nextLine();
                    String[] splitNumbersLoop = numbers.split(",");
                    int column = 0;

                    for(String number : splitNumbersLoop){
                        this.data[row][column] = Double.parseDouble(number);
                        column++;
                    }
                }
                for (double[] a : this.data){
                    for (int i = 0; i < a.length; i++) {
                        System.out.print(a[i]);
                        System.out.print(" ");
                    }
                    System.out.println();
                }
            }
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }
    }

    public static void main(String[] args) {
        Matrix matrix = new Matrix("C:\\Users\\bertr\\OneDrive\\Skrivebord\\Skole\\SemesterProjekt\\opgaver\\src\\Moldul3_3\\abc");
    }
}
