package numbers;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String appName = "Welcome to Amazing Numbers!\n";
        System.out.println(appName);
        Model.printInstruction();

        Scanner scanner = new Scanner(System.in);
        long number = 1;
        int len;
        final String[] properties = {"even", "odd", "buzz", "duck", "palindromic", "gapful", "spy", "square", "sunny",
                "jumping", "happy", "sad"};

        do {
            System.out.print("\nEnter a request: ");
            String decision = scanner.nextLine().toLowerCase();
            String[] choiceDetermination = decision.split(" ");
            String[] propertiesToSeek = new String[0];
            String[] propertiesToExclude = new String[0];
            Property property = new Property();

            boolean isNatural = true;

            if (decision.isEmpty()) {
                Model.printInstruction();
                continue;
            }

            if ((int)decision.charAt(0) > 57 || (int)decision.charAt(0) < 48) {
                System.out.println("\nThe first parameter should be a natural number or zero.");
                continue;
            }

            boolean seekPropertiesCheck = true;
            boolean excludePropertiesCheck = true;
            switch (choiceDetermination.length) {
                case 1 -> {
                    number = Long.parseLong(choiceDetermination[0]);
                    len = 0;
                }
                case 2 -> {
                    number = Long.parseLong(choiceDetermination[0]);
                    len = Integer.parseInt(choiceDetermination[1]);
                }
                default -> {
                    number = Long.parseLong(choiceDetermination[0]);
                    len = Integer.parseInt(choiceDetermination[1]);

                    // Excluding parameters to wanted and unwanted arrays.
                    int excludeIter = 0;
                    int seekIter = 0;
                    for (int i = 2; i < choiceDetermination.length; i++) {
                        if (choiceDetermination[i].charAt(0) == '-') {
                            propertiesToExclude = Arrays.copyOf(propertiesToExclude, propertiesToExclude.length + 1);
                            propertiesToExclude[excludeIter] = choiceDetermination[i].substring(1);
                            excludeIter++;
                        } else {
                            propertiesToSeek = Arrays.copyOf(propertiesToSeek, propertiesToSeek.length + 1);
                            propertiesToSeek[seekIter] = choiceDetermination[i];
                            seekIter++;
                        }
                    }

                    // Checking if all properties received are correct
                    seekPropertiesCheck = property.checkProperties(propertiesToSeek, properties);
                    excludePropertiesCheck = property.checkProperties(propertiesToExclude, properties);

                }
            }

            if (!seekPropertiesCheck && !excludePropertiesCheck) {
                // Merging incorrect properties
                String[] wrongProperties = Controler.combineWrongProperties(properties, propertiesToSeek, propertiesToExclude);
                Model.printPropertiesError(properties, wrongProperties);
                continue;
            } else if (!excludePropertiesCheck) {
                Model.printPropertiesError(properties, propertiesToExclude);
                continue;
            } else if (!seekPropertiesCheck) {
                Model.printPropertiesError(properties, propertiesToSeek);
                continue;
            }

            if (!Property.checkOpposedProperty(Arrays.toString(propertiesToSeek)))
                continue;

            if (!Property.checkOpposedProperty(Arrays.toString(propertiesToExclude)))
                continue;

            boolean duplicate = false;
            for (String wordSeek : propertiesToSeek) {
                duplicate = false;
                for (String wordExclude : propertiesToExclude) {
                    if (wordSeek.equals(wordExclude)) {
                        duplicate = true;
                        break;
                    }
                }

                if (duplicate)
                    break;
            }

            if (duplicate) {
                String[] combinedProperties = new String[propertiesToSeek.length + propertiesToExclude.length];
                System.arraycopy(propertiesToSeek, 0, combinedProperties, 0, propertiesToSeek.length);
                System.arraycopy(propertiesToExclude, 0, combinedProperties,
                        propertiesToSeek.length, propertiesToExclude.length);
                Property.checkDuplicates(combinedProperties);
                continue;
            }

            if (number < 0L || len < 0) {
                System.out.println("\nThe first parameter should be a natural number or zero.");
                System.out.println("The second parameter should be a natural number.");
                isNatural = false;
            }

            if (isNatural && number != 0L && len != 0) {
                Number numberProperty = new Number(number, len, propertiesToSeek, propertiesToExclude);
                numberProperty.getProperties();
            } else if (isNatural && number != 0L) {
                Number numberProperty = new Number(number);
                numberProperty.getProperties();
            }

        } while (number != 0);

        scanner.close();
        System.out.println("\nGoodbye!");
    }
}
