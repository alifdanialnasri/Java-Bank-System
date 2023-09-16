package com.nycto;

//Swing(Java)
//Provide Interfaces
import javax.swing.*;


//Array Utilities
import java.util.Arrays;


//Bankaccount class initialization
public class Bankaccount {

//Starting of Alif
    //Main body
    public static void main(String[] args) {

        //Button Declaration & Initialization
        int bc = JOptionPane.OK_OPTION;
        int bb = JOptionPane.CANCEL_OPTION;


        //Dialog box "username" field declaration
        JTextField username = new JTextField();

        //Dialog box "password" field declaration
        JTextField password = new JPasswordField();


        //Object Declaration & Initialization
        Object[] message =
                {
                        "Username", username, "Password", password
                };


        //User Greeting & Welcoming Message
        int loginbutton = JOptionPane.showConfirmDialog(null,
                "\t\t  Welcome to Malay Bank \n " +
                        "Please Login To Continue", "WELCOME", JOptionPane.OK_CANCEL_OPTION);


        //If-Else Statement
        //Looping
        //Initialization Login Page if-else statment
        if (loginbutton == bc) {
            do
            {
                JOptionPane.showMessageDialog(null, message, "Login", JOptionPane.INFORMATION_MESSAGE);


                //String
                //Username List
                String[] user = {"ADMIN", "ALIF", "AFIF", "AYIH", "ZAIM"};

                //String
                //Password Listt
                String[] passwords = {"0000", "1111", "2222", "3333", "4444"};


                //Get username input
                String username1 = username.getText();

                //Get password input
                String password1 = password.getText();

                //FOO function
                //To Return Value "Username" and "Password
                banksystem foo = new banksystem("" + username1, "MYB" + password1);


                //If-Else Statement
                //Initialization of Login Input if-else statement
                if (Arrays.asList(user).contains(username1) && Arrays.asList(passwords).contains(password1)) {
                    //Method calling
                    foo.menu();

                } else {
                    //Wrong Login Input Message
                    //Error Message
                    JOptionPane.showMessageDialog(null, "Login Error", "Error",
                            JOptionPane.ERROR_MESSAGE);


                    //Ending of Login Input if-else statement
                }
        }while(loginbutton != bb);


            }

        else

            {

                //Login session cancelled message
                JOptionPane.showMessageDialog(null, "Login Canceled", "Login",
                        JOptionPane.INFORMATION_MESSAGE);

                //Initialization Login Page if-else statment
            }








    //End of main body
    }




//End of Alif's Parts
//End of Bankaccount class
}


//Initialization of banksystem class
 class banksystem
 {

     //Variable declaration
     float balance,previoustransaction;
     String custnmae,custid;



     //Constructor for user information
     banksystem(String cname, String cid)
     {
         custnmae = cname;

         custid = cid;

     }


     //Starting of Afif's Part
     //Method Deposit
     //Perform calculation for "Deposit"
     void deposit(float amount)
     {
         if(amount !=0)
         {

             //Deposit formula
             balance = balance + amount;

             //Return value to "previoustransaction" method
             previoustransaction = amount;
         }
     }
     //Ending of Afif's part


     //Starting of Zaim Part
     //Method Withdraw
     //Perform calculation for "Withdraw"
     void withdraw(float amount)
     {
         if(amount > balance)
         {
            JOptionPane.showMessageDialog(null,"Insufficient Balance!!","Withdraw Error",JOptionPane.ERROR_MESSAGE);
         }

         else
         {
             //Deposit formula
             balance = balance - amount;

             //Return value to "previoustransaction" method
             previoustransaction = -amount;

             //Withdraw succesfull message
             JOptionPane.showMessageDialog(null,
                     "--------------------------------------------------------------\n" +
                             String.format("You Have Succesfully Withdrawn RM %.2f\n",amount) +
                             "--------------------------------------------------------------"
                     , "Withdraw", JOptionPane.INFORMATION_MESSAGE);
         }
     }
     //Ending of Zaim Part


     //Start of Haris's Part
     //Method Withdrawn
     //Display withdrawn or deposited value
     void getprevioustransaction()
     {

         //Money Deposited
         if(previoustransaction > 0)
         {
             //Money deposited information message
             JOptionPane.showMessageDialog(null,"-------------------------------------------\n"+
                     String.format("Deposited:RM %.2f ",previoustransaction)+
                     "\n -------------------------------------------\n"
                     ,"Previous Transaction",JOptionPane.INFORMATION_MESSAGE);

         }

         //Money Withdrawn
         else if(previoustransaction < 0)
         {
             //Money withdrawn information message
             JOptionPane.showMessageDialog(null,"-------------------------------------------\n"+
                     String.format("Withdrawn:RM %.2f ",Math.abs(previoustransaction))+
                     "\n -------------------------------------------\n"
                     ,"Previous Transaction",JOptionPane.INFORMATION_MESSAGE);
         }

         else

         {
             //No transaction information message
             JOptionPane.showMessageDialog(null,"-------------------------------------------\n"+
                     "No Transaction occur"+
                     "\n -------------------------------------------\n"
                     ,"Previous Transaction",JOptionPane.INFORMATION_MESSAGE);
         }
     }
     //Ending of Haris's Part



     //"Menu" method
      public void  menu()
     {

         //Variable declaration
         //Variable for switch
         int pilih;

         //do-while loop
         //Initialization of menu do while loop
         do {

         //Menu selection
         //Variable "option" is for switch selection
         String option = JOptionPane.showInputDialog(null,
                 "-------------------------------------------\n" +
                         "     Welcome to Malay Bank    \n" +
                         "Welcome back "+custnmae+
                         "\nYour ID is "+custid+
                         "\n-------------------------------------------\n\n"+
                         "\t1. Check Balance\n"+
                         "\t2. Deposit\n"+
                         "\t3. Withdraw\n"+
                         "\t4. Previous Transaction\n"+
                         "\t5. Exit\n","Menu",JOptionPane.PLAIN_MESSAGE);

         //Convert string to integer variable type
          pilih = Integer.parseInt(option);


                 //Switch statement
                 //Switch for "menu"
                 //Switch initialization
                 switch(pilih)
                 {

                     //Check balance case
                     case 1:
                     {
                         //Balance information message
                         JOptionPane.showMessageDialog(null,
                                 "-------------------------------------------\n" +
                                         String.format("Balace:RM %.2f ", balance )+
                                         "\n-------------------------------------------"
                                 , "Balance", JOptionPane.PLAIN_MESSAGE);
                         break;

                     //End of check balance case
                     }

                     //Deposit case
                     case 2:
                     {

                         //Get input value(Deposit amount) from user
                         String jumlahdepo = JOptionPane.showInputDialog(null,
                                 "---------------------------------------------\n" +
                                         "Enter an Amount to Deposit(RM)\n" +
                                         "---------------------------------------------"
                                 , "Deposit", JOptionPane.PLAIN_MESSAGE);

                         //Convert string to float type variable
                         float depoamount = Float.parseFloat(jumlahdepo);

                         //return value to deposit method
                         deposit(depoamount);


                         //Deposit succesfull message
                         JOptionPane.showMessageDialog(null,
                                 "--------------------------------------------------------------\n" +
                                         String.format("You Have Succesfully Deposited RM %.2f\n",depoamount) +
                                         "--------------------------------------------------------------"
                                 , "Deposit", JOptionPane.PLAIN_MESSAGE);
                         break;

                     //End of Deposit case
                     }

                     //Withdraw case
                     case 3:
                     {
                         //Get input value(Withdraw amount) from user
                         String jumlahwidh = JOptionPane.showInputDialog(null,
                                 "---------------------------------------------\n" +
                                         "Enter an Amount to Withdraw(RM)\n" +
                                         "---------------------------------------------"
                                 , "Deposit", JOptionPane.PLAIN_MESSAGE);

                         //Convert string to float type variable
                         float withdamount = Float.parseFloat(jumlahwidh);

                         //return value to withdraw method
                         withdraw(withdamount);




                         break;

                     //End of Withdraw case
                     }

                     //Previous Transaction case
                     case 4:
                     {

                         //Method calling
                         //calling previoustransaction method
                         getprevioustransaction();

                         break;

                     //End of previous transaction case
                     }


                     //Exit case
                     case 5:
                     {

                         //Exit message
                         //Appreciation Message
                         JOptionPane.showMessageDialog(null,
                                 "-------------------------------------------\n" +
                                         "Thank You for using Malay Bank!!\n" +
                                         "-------------------------------------------"
                                 , "Invalid", JOptionPane.INFORMATION_MESSAGE);

                         break;

                     //End of previous transaction case
                     }

                     //Default message
                     default:
                     {

                         JOptionPane.showMessageDialog(null,
                                 "-------------------------------------------\n" +
                                         "Invalid Choice!!\n" +
                                         "-------------------------------------------"
                                 , "Invalid", JOptionPane.ERROR_MESSAGE);

                         break;

                     //End of default
                     }


                 //End of "menu" switch statement
                 }

         //Initialization of menu do while loop
         }while(pilih != 5);


     //End of main body
     }

 //End of banksystem class
 //End of program
 }