package numbers;

import java.util.Arrays;

public class Controler {

    protected static String[] combineWrongProperties(String[] properties, String[] seekingProperties, String[] excludedProperties) {
        String[] wrongProperties = new String[0];
        int indexOfWrongProperties = 0;
        for (String word : seekingProperties) {
            // If variable is equal length of properties it is not included in properties available
            int checkComplition = 0;
            for (String propertyCheck : properties) {
                if (word.equals(propertyCheck)) {
                    break;
                } else {
                    checkComplition++;
                }
            }

            if (checkComplition == properties.length) {
                wrongProperties = Arrays.copyOf(wrongProperties, wrongProperties.length + 1);
                wrongProperties[indexOfWrongProperties] = word;
                indexOfWrongProperties++;
            }
        }

        for (String word : excludedProperties) {
            // If variable is equal length of properties it is not included in properties available
            int checkComplition = 0;
            for (String propertyCheck : properties) {
                if (word.equals(propertyCheck)) {
                    break;
                } else {
                    checkComplition++;
                }
            }

            if (checkComplition == properties.length) {
                wrongProperties = Arrays.copyOf(wrongProperties, wrongProperties.length + 1);
                wrongProperties[indexOfWrongProperties] = word;
                indexOfWrongProperties++;
            }
        }

        return wrongProperties;
    }
}
