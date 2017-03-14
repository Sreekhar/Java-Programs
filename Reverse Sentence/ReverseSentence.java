class MainClass {
    public static void main(String args[]) {

        String str = "reverse me! also lets check";
        System.out.println("The initial string is  --->> " + str);

        for (int i = 0; i < str.length(); i++) {
            //Keep iterating each letter from one end to another.
            str = str.substring(1, str.length() - i)
                + str.substring(0, 1)
                + str.substring(str.length() - i, str.length());
        }
        System.out.println("The reversed string is ---->> " + str);

        for (int i = 0, j = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' ' || i == (str.length() - 1)) {
                //Just to know the start of each word
                int k = j;

                //the below if condition is for considering the last word.
                if(i == (str.length() - 1)) i++;

                while(j < i) {
                    j++;
                    str = str.substring(0, k)
                        //(i-j) is the length of each word
                        + str.substring(k + 1, (k + 1) + i - j)
                        + str.substring(k, k + 1)
                        + str.substring((k + 1) + i - j, i)
                        + str.substring(i);
                    if(j == i) {
                        //Extra j++ for considering the empty white space
                        j++;
                    }
                }
            }
        }
        System.out.println("The reversed string but not the reversed words is ---->> " + str);

    }
}
