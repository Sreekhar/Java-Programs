import java.util.*;

class PersonDetails {
    int birthYear;
    int deathYear;

    PersonDetails(int birthYear, int deathYear) {
        this.birthYear = birthYear;
        this.deathYear = deathYear;
    }

    int getBirthYear() {
        return birthYear;
    }

    int getDeathYear() {
        return deathYear;
    }
}

class MainClass {
    public static void main(String[] args) {
        List<PersonDetails> personsList = new ArrayList<PersonDetails>();
        Map<Integer, Integer> commonYears = new HashMap<>();
        PersonDetails[] persons = new PersonDetails[10];
        persons[0] = new PersonDetails(1904, 1961);
        persons[1] = new PersonDetails(1901, 1967);
        persons[2] = new PersonDetails(1903, 1944);
        persons[3] = new PersonDetails(1904, 1951);
        persons[4] = new PersonDetails(1906, 1944);
        persons[5] = new PersonDetails(1907, 1945);
        persons[6] = new PersonDetails(1909, 1932);
        persons[7] = new PersonDetails(1901, 1941);
        persons[8] = new PersonDetails(1900, 1981);
        persons[9] = new PersonDetails(1905, 1977);

        for(int iCount=0; iCount < persons.length; iCount++) {
            personsList.add(persons[iCount]);
        }

        PersonDetails initialPerson = personsList.get(0);
        int lowestBirthYear = initialPerson.getBirthYear();
        int lowestDeathYear = initialPerson.getDeathYear();
        int highestBirthYear = initialPerson.getBirthYear();
        int highestDeathYear = initialPerson.getDeathYear();
        for(int iCount=0; iCount < persons.length; iCount++) {
            PersonDetails tempPerson = personsList.get(iCount);
            if(lowestBirthYear > tempPerson.getBirthYear()) {
                lowestBirthYear = tempPerson.getBirthYear();
            }
            if(highestBirthYear < tempPerson.getBirthYear()) {
                highestBirthYear = tempPerson.getBirthYear();
            }
            if(lowestDeathYear > tempPerson.getDeathYear()) {
                lowestDeathYear = tempPerson.getDeathYear();
            }
            if(highestDeathYear < tempPerson.getDeathYear()) {
                highestDeathYear = tempPerson.getDeathYear();
            }
        }
        System.out.println("Lowest Birth year of a person is ---> " + lowestBirthYear);
        System.out.println("Highest Birth year of a person is ---> " + highestBirthYear);
        System.out.println("Lowest Death year of a person is ---> " + lowestDeathYear);
        System.out.println("Highest Death year of a person is ---> " + highestDeathYear);

        for(int iCount=0; iCount < persons.length; iCount++) {
            PersonDetails tempPerson = personsList.get(iCount);
            for(int jCount=tempPerson.getBirthYear(); jCount < tempPerson.getDeathYear(); jCount++) {
                if (commonYears.containsKey(jCount)) {
                    commonYears.put(jCount, commonYears.get(jCount) + 1);
                } else {
                    commonYears.put(jCount, 1);
                }
            }
        }

        System.out.println("\nHighest population was in the following years \n\n" + highestDeathYear);

        int maxValueInMap = (Collections.max(commonYears.values()));  // This will return max value in the Hashmap
        for (Map.Entry<Integer, Integer> entry : commonYears.entrySet()) {  // Itrate through hashmap
            if (entry.getValue() == maxValueInMap) {
                System.out.println(entry.getKey());     // Print the key with max value
            }
        }
    }
}
