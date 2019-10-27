package com.example.invitation_codingtest;


import java.util.Scanner;

//public class ReadWriteExecute {
public class javatest {
    public static int symbolicToOctal(String permString) {
        //  throw new UnsupportedOperationException("Waiting to be implemented.");
        int blocklength = permString.length() / 3; //길이를 구하고
        String container2 = "";
        for(int i =0; i< blocklength; i++)
        { //3개씩 인식할 것이다
            int container = 0;
            for( int j =0; j < 3; j++)
            {
                //char checkfor = permString.charAt((3*i)+j);
                if(permString.charAt((3*i)+j) == 'r')
                {
                    container += 4;
                }
                else if(permString.charAt((3*i)+j) == 'w')
                {
                    container += 2;
                }
                else if(permString.charAt((3*i)+j) == 'x')
                {
                    container += 1;
                }
                else
                {

                }

            }
            container2 += container;
            System.out.print(container);
        }


        return Integer.parseInt(container2);
    }

    public static void main(String[] args) {
        // Should write 752
        String message;
        Scanner scan = new Scanner(System.in);
        message = scan.nextLine();
        javatest.symbolicToOctal(message);

        //System.out.println();

    }
}