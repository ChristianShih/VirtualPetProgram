/*
 * Project 9
 * Description: Virtual Pet
 * Name: Christian Shih
 * ID: 921026207
 * Class: CSC 210-01
 * Semester: Fall 2020
 */

import java.util.Scanner;
public class VirtualPetProgram
{
    public static void main(String[] args) {
        // Initialize the Scanner
        Scanner input = new Scanner(System.in);
        int option;

        // Start the user experience
        System.out.println("Welcome to the Virtual Pet Program!");
        System.out.print("What would you like to name your pet? ");

        VirtualPet pet = new VirtualPet(input.nextLine());

        do {
            System.out.println("\n-----------------------------------------------------------------");
            System.out.println("Please enter the integer for the option you choose:");
            System.out.println("  1. Check statuses");
            System.out.println("  2. Feed your virtual pet");
            System.out.println("  3. Play with your virtual pet");
            System.out.println("  4. Clean your virtual pet");
            System.out.println("  5. End program");
            System.out.print("\nYour choice: ");

            // Get the choice from the user.
            option = input.nextInt();

            switch (option) {
                case 1:     // Check statuses
                    // Retrieve the values using the Getter methods.
                    System.out.println("\nValues for " + pet.getName());
                    System.out.println("  Happiness: " + pet.getHappiness());
                    System.out.println("  Energy: " + pet.getEnergy());
                    System.out.println("  Hygiene: " + pet.getHygiene());
                    break;
                case 2:     // Feed your virtual pet
                    // Call feed() instance method. VirtualPet's feed() method should be doing all the work.
                    if (pet.feed()) {
                        System.out.println("\nYou fed " + pet.getName() + ".");
                    } else {
                        System.out.println("\nYou couldn't feed " + pet.getName() + " due to a restriction.");
                    }
                    break;
                case 3:     // Play with your virtual pet
                    // Call play() instance method. VirtualPet's play() method should be doing all the work.
                    if (pet.play()) {
                        System.out.println("\nYou played with " + pet.getName() + ".");
                    } else {
                        System.out.println("\nYou couldn't play with " + pet.getName() + " due to a restriction.");
                    }
                    break;
                case 4:     // Clean your virtual pet
                    // Call clean() instance method. VirtualPet's clean() method should be doing all the work.
                    if (pet.clean()) {
                        System.out.println("\nYou cleaned " + pet.getName() + ".");
                    } else {
                        System.out.println("\nYou couldn't clean " + pet.getName() + " due to a restriction.");
                    }
                    break;
                case 5:     // End program
                    // Display a summary depending on how high the happiness is.
                    System.out.println("Thank you for playing! Here is a summary of your pet's experience:");
                    if (pet.getHappiness() >= 100) {
                        System.out.println("  You did a PERFECT job! Your pet loves you!");
                    } else if (pet.getHappiness() >= 80) {
                        System.out.println("  You did pretty well! Your pet likes you.");
                    } else if (pet.getHappiness() >= 60) {
                        System.out.println("  You did okay. Your pet isn't as happy as it could be.");
                    } else {
                        System.out.println("  You could have done a lot better. Your pet isn't very happy.");
                    }
                    break;
                default:        // User selected an invalid option.
                    System.out.println("\nPlease select a valid option.");
            }
        } while (option != 5);

    }
}

class VirtualPet {
    private String name;
    private int happiness;
    private int energy;
    private int hygiene;

    public VirtualPet(String petName)
    { //constracor classes
        setName(petName);
        setHappiness(25);
        setEnergy(25);
        setHygiene(50);
    }

    public String getName() {
        // getter for name
        return name;
    }

    public void setName(String petName) {
        // setter for name
        if (petName.length() < 30) {
            this.name = petName;
        }
        else
            {
                this.name=("Default");
            }

    }

    public int getHappiness() {
        // setter for happiness
        return happiness;
    }

    public void setHappiness(int petHappiness) {
        // setter for happiness
        if (petHappiness>= 1 && petHappiness <= 100) {
            this.happiness = petHappiness;
        }
    }

    public int getEnergy() {
        //getter for energy
        return energy;
    }

    public void setEnergy(int petEnergy) {
        // setter for energy
        if (petEnergy >= 1 && petEnergy <= 100) {
            this.energy = petEnergy;
        }
    }

    public int getHygiene() {
        // getter for hygiene
        return hygiene;
    }

    public void setHygiene(int petHygiene) {
        // setter for hygiene
        if (petHygiene >= 1 && petHygiene <= 100) {
            this.hygiene = petHygiene;
        }
    }


    public boolean feed() {
        // if energy goes or equal 80 then feed won't affect the status of the pet
        if (energy >= 80) {
            return false;
        } else {
            setHappiness(happiness+5);
            setEnergy(energy+30);
        }
        return true;
    }

    public boolean play()
    {
        if (energy <= 30) {
            return false;
        } else {
            setHappiness(happiness+20);
            setEnergy(energy-15);
            setHygiene(hygiene-30);
        }
        return true;
    }

    public boolean clean() {
        if (energy > 70) {
            return false;
        } else {
            setHygiene(hygiene+50);
            setHappiness(happiness-20);
        }
        return true;
    }
}

