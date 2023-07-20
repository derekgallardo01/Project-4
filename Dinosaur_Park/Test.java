 //***********************************************************************************************************************************************
 //
 //  Name: Derek Gallardo
 //  Date: July 17th, 2022
 //  Version: 1.0.0
 //  Programming Language: Java
 //  Java Version: 17
 //  Description: We have been asked to create a program to keep track of the dinosaurs in the park. Our park has both herbivores and carnosaurs.
 //
//***********************************************************************************************************************************************

import java.util.*;


public class Test {
    public static void main(String[] args) {
      
        // Create Data Structure for List of Dinosaurs
        List<Dinosaur> dinosaurs = new ArrayList<>();
        dinosaurs.add(new Thyrannosaurus());
        dinosaurs.add(new Dilophosaurus());
        dinosaurs.add(new Chindesaurus());
        dinosaurs.add(new Staurikosaurus());
        dinosaurs.add(new Iguanodon());
        dinosaurs.add(new Parasaurolophus());
        dinosaurs.add(new Stenopelix());
        dinosaurs.add(new Triceratops());

        // Print List of Dinosaurs
        System.out.println("List of dinosaurs: ");
        for (Dinosaur d : dinosaurs) {
            System.out.println(d);
        }
        
        
        // Sort list of Dinosaurs by Height
        System.out.println();
        System.out.println("Sorted by Height: ");
        Collections.sort(dinosaurs);
        for (Dinosaur d : dinosaurs) {
            System.out.println(d);
        }
        System.out.println();
        System.out.println();

        // Begin Menu

        try (Scanner scanner = new Scanner(System.in)) {
            boolean isOver = false;
            while (!isOver) {
                int choice = getMenuChoice(scanner);
                switch (choice) {
                    case 0:
                        isOver = true;
                        break;
                    case 1:
                        System.out.println("Choose dinosaur:");
                        Dinosaur d = chooseDinosaur(scanner, dinosaurs);
                        System.out.println(d);
                        break;
                    case 2:
                        System.out.println("Choose 1st dinosaur to compare:");
                        Dinosaur d1 = chooseDinosaur(scanner, dinosaurs);
                        System.out.println("Choose 2nd dinosaur to compare:");
                        Dinosaur d2 = chooseDinosaur(scanner, dinosaurs);
                        int result = d1.compareTo(d2);
                        if (result < 0) {
                            System.out.println(d1.getName() + " < " + d2.getName());
                        } else if (result > 0) {
                            System.out.println(d1.getName() + " > " + d2.getName());
                        } else {
                            System.out.println(d1.getName() + " = " + d2.getName());
                        }
                        break;
                    default:
                        throw new IllegalStateException();
                }
            }
        }
        
    }


      // Menu Choice
    private static int getMenuChoice(Scanner scanner) {
        while (true) {
            StringBuilder builder = new StringBuilder("Menu:" + System.lineSeparator());
            builder.append("1. View dinosaur info").append(System.lineSeparator());
            builder.append("2. Compare to dinosaurs").append(System.lineSeparator());
            builder.append("0. Exit").append(System.lineSeparator());
            builder.append("Your choice: ");
            System.out.print(builder);
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice < 0 || choice > 2) {
                    throw new IllegalArgumentException();
                }
                return choice;
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
            System.out.println();
        }
    }
    
    // Dinosaur Choice

    private static Dinosaur chooseDinosaur(Scanner scanner, List<Dinosaur> dinosaurs) {
        while (true) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < dinosaurs.size(); i++) {
                builder.append((i + 1)).append(". ").append(dinosaurs.get(i).getName()).append(System.lineSeparator());
            }
            builder.append("Your choice: ");
            System.out.print(builder);
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice <= 0 || choice > dinosaurs.size()) {
                    throw new IllegalArgumentException();
                }
                return dinosaurs.get(choice-1);
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
            System.out.println();
        }
    }
}
