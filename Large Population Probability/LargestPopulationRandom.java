import java.util.Scanner;

class MainClass {
    public static void main(String args[]) {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter the number of countries");
        int CountryNum = sc1.nextInt();

        AssignValues av = new AssignValues(CountryNum);
        av.enterDetails();

        av.printDetails();

        SortValues sv = new SortValues();
        sv.mergeSort(av, 0, av.CountryInfo.length - 1);

        av.printDetails();

        FindRandomCountry su = new FindRandomCountry();
        su.addPopulation(av);

        av.printDetails();

        int randomNumber = su.findRandomNumber(av);

        System.out.println("The randomn number is " + randomNumber);
        System.out.println("The randomnly selected country is " + su.findCountry(av, randomNumber));
    }
}

class FindRandomCountry {
    void addPopulation(AssignValues updatedData) {
        for(int iCount=1; iCount < updatedData.CountryInfo.length; iCount++) {
            updatedData.CountryInfo[iCount].population += updatedData.CountryInfo[iCount-1].population;
        }
    }

    int findRandomNumber(AssignValues updatedData) {
        return (int)((Math.random() * (updatedData.CountryInfo[updatedData.CountryInfo.length - 1].population - 1)) + 1);
    }

    String findCountry(AssignValues updatedData, int randomNumber) {
        int low = 0;
        int high = updatedData.CountryInfo.length-1;

        int mid = (low + high)/2;

        while(low <= high) {
            if(randomNumber < updatedData.CountryInfo[mid].population) {
                high = mid - 1;
            } else if(randomNumber > updatedData.CountryInfo[mid].population) {
                low = mid + 1;
            } else if(randomNumber == updatedData.CountryInfo[mid].population) {
                return updatedData.CountryInfo[mid].countryName;
            }
            if(low <= high) {
                mid = (low + high)/2;
            } else {
                if(randomNumber > updatedData.CountryInfo[mid].population) {
                    return updatedData.CountryInfo[mid + 1].countryName;
                } else {
                    return updatedData.CountryInfo[mid].countryName;
                }
            }
        }

        return "";
    }
}

class Data {
    int population;
    String countryName;

    Data(int population, String countryName) {
        this.population = population;
        this.countryName = countryName;
    }
}

class AssignValues {
    Data CountryInfo[];

    AssignValues(int Size) {
        CountryInfo = new Data[Size];
    }

    void enterDetails() {
        Scanner sc2 = new Scanner(System.in);

        for(int iCount=0; iCount< CountryInfo.length; iCount++) {
            System.out.println("Enter the name of the country number " + iCount);
            String tempName = sc2.next();
            System.out.println("Enter the country's corresponding population");
            int tempPopulation = sc2.nextInt();
            CountryInfo[iCount] = new Data(tempPopulation, tempName);
        }
    }

    void printDetails() {
        System.out.println("Please find all the entries below");
        for(int jCount=0; jCount< CountryInfo.length; jCount++) {
            System.out.println("Name - " + CountryInfo[jCount].countryName + ", It's population - " + CountryInfo[jCount].population);
        }
    }
}

class SortValues {

    void mergeSort(AssignValues original, int low, int high) {
        if(low < high) {
            int middle = (low + high)/2;
            mergeSort(original, low, middle);
            mergeSort(original, middle + 1, high);
            merge(original, low, middle, high);
        }
    }

    void merge(AssignValues original, int low, int middle, int high) {
        int duplicatePopulation[] = new int[original.CountryInfo.length];
        String duplicateCountries[] = new String[original.CountryInfo.length];

        for(int iCount=low; iCount <= high; iCount++) {
            duplicatePopulation[iCount] = original.CountryInfo[iCount].population;
            duplicateCountries[iCount] = original.CountryInfo[iCount].countryName;
        }

        int leftIndex = low;
        int rightIndex = middle + 1;
        int current = low;

        while(leftIndex <= middle && rightIndex <= high) {
            if(duplicatePopulation[leftIndex] >= duplicatePopulation[rightIndex]) {
                original.CountryInfo[current].population = duplicatePopulation[leftIndex];
                original.CountryInfo[current].countryName = duplicateCountries[leftIndex];
                leftIndex++;
            } else {
                original.CountryInfo[current].population = duplicatePopulation[rightIndex];
                original.CountryInfo[current].countryName = duplicateCountries[rightIndex];
                rightIndex++;
            }
            current++;
        }

        while(leftIndex <= middle) {
            original.CountryInfo[current].population = duplicatePopulation[leftIndex];
            original.CountryInfo[current].countryName = duplicateCountries[leftIndex];
            current++;
            leftIndex++;
        }
        while(rightIndex <= high) {
            original.CountryInfo[current].population = duplicatePopulation[rightIndex];
            original.CountryInfo[current].countryName = duplicateCountries[rightIndex];
            current++;
            rightIndex++;
        }

    }
}
