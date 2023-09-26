package elpu.virtual.api.services;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CrearPassNuevo {

        private static final String CONSONANTS = "BCDfghjlMNprTvy";
        private static final String VOWELS = "AEiu";
        private static final String NUMBERS = "123456789";

        public String generateRandomString(int length) {
            StringBuilder randomString = new StringBuilder();

            Random random = new Random();

            int choice;
            for (int i = 0; i < length; i++) {
                if (i == 0 || i == 1){
                    choice = 1;
                }
                else {
                    choice = random.nextInt(3);
                }

                if ( i == length-1){
                    choice = 2;
                }

                switch (choice) {
                    case 0:
                        randomString.append(CONSONANTS.charAt(random.nextInt(CONSONANTS.length())));
                        break;
                    case 1:
                        randomString.append(VOWELS.charAt(random.nextInt(VOWELS.length())));
                        break;
                    case 2:
                        randomString.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));
                        break;
                }
            }

            return randomString.toString();
        }

}
