package numbers;

public class Property {

    protected boolean checkProperties(String[] properties, String[] availableProperties) {
        boolean propertyChecked = true;
        int amountOfCorrectProperties;

        for (String value : properties) {
            amountOfCorrectProperties = 0;
            for (String s : availableProperties) {
                if (value.equals(s)) {
                    propertyChecked = true;
                    break;
                } else {
                    propertyChecked = false;
                    amountOfCorrectProperties++;
                }
            }
            if (amountOfCorrectProperties == availableProperties.length) {
                propertyChecked = false;
                break;
            }
        }

        return propertyChecked;
    }

    protected static boolean checkOpposedProperty(String properties) {
        if (properties.contains("even") && properties.contains("odd")) {
            System.out.println("The request contains mutually exclusive properties: [odd, even]");
            System.out.println("There are no numbers with these properties.");
            return false;
        } else if (properties.contains("spy") && properties.contains("duck")) {
            System.out.println("The request contains mutually exclusive properties: [spy, duck]");
            System.out.println("There are no numbers with these properties.");
            return false;
        } else if (properties.contains("sunny") && properties.contains("square")) {
            System.out.println("The request contains mutually exclusive properties: [sunny, square]");
            System.out.println("There are no numbers with these properties.");
            return false;
        } else if (properties.contains("sad") && properties.contains("happy")) {
            System.out.println("The request contains mutually exclusive properties: [sad, happy]");
            System.out.println("There are no numbers with these properties.");
            return false;
        }
        return true; 
    }

    protected static void checkDuplicates(String[] properties) {
        boolean checked = false;
        for (String property : properties) {
            for (String propertyToCompere : properties) {
                if (property.equals(propertyToCompere)) {
                    System.out.println("The request contains mutually exclusive properties: [" +
                            property + ", " + property + "]");
                    System.out.println("There are no numbers with these properties.");
                    checked = true;
                }
                if (checked)
                    break;
            }
            if (checked)
                break;
        }
    }
}
