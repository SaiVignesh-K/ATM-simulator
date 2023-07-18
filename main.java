import java.util.*;

interface atm {
    //this interface contains methods for user.
    public void makedeposit(int x, int x1, int x2, int x3, int x4, int x5, int x6, int x7, int x8, int x9, int x10, int[] m);

    //this method allows the user to make deposit.
    public void withdraw(int y, int[] m);
    //this method allows the user to withdraw amount.

    public void setApin();
    //this method allows the user to set account pin.
}

class account {
    //this class contains all the details related to account.
    int ano;
    private String apin;
    //account pin is private for security purpose.
    boolean visited = false;
    //this boolean is used to check whether that user is using the atm for the first time or not.
    private int abal;

    public void getAno() {
        if (this.ano < 10) {
            System.out.print("your account number is 0000" + this.ano);
        } else if (this.ano >= 10 && this.ano < 100) {
            System.out.print("your account number is 000" + this.ano);
        } else if (this.ano >= 100 && this.ano < 1000) {
            System.out.print("your account number is 00" + this.ano);
        } else if (this.ano >= 1000 && this.ano < 10000) {
            System.out.print("your account number is 0" + this.ano);
        } else {
            System.out.print(this.ano);
        }
        System.out.println();
    }

    public int getAbal() {
        return abal;
    }

    public void setAbal(int abal) {
        this.abal = abal;
    }

    public String getApin() {
        return apin;
    }

    public void setApin(String apin) {
        this.apin = apin;
    }
}

class user extends account implements atm {
    //this class contains all the details related to user.
    protected String aname;
    protected String phno;

    protected String mail;

    public String getAname() {
        return aname;
    }

    public void makedeposit(int d, int x1, int x2, int x3, int x4, int x5, int x6, int x7, int x8, int x9, int x10, int[] m) {
        //this method allows the user to make deposit and update the account balance.
        int r = getAbal();
        setAbal(r + d);
        m[0] += x1;
        m[1] += x2;
        m[2] += x3;
        m[3] += x4;
        m[4] += x5;
        m[5] += x6;
        m[6] += x7;
        m[7] += x8;
        m[8] += x9;
        m[9] += x10;
    }

    public void withdraw(int w, int[] m) {
        //this method allows the user to withdraw amount and update the account balance.
        int r = getAbal();
        setAbal(r - w);
    }


    public void setApin() {
        //this method allows the user to set account pin.
        Scanner sv = new Scanner(System.in);
        String s;
        boolean r = false;
        do {
            System.out.println("enter a pin");
            s = sv.next();
            System.out.println("re-enter the pin");
            String k = sv.next();
            if (k.equals(s)) {
                setApin(k);
                r = true;
            } else {
                System.out.println("TRY AGAIN, NOT MATCHED");
            }
        } while (!r);
    }
}

class money {
    //this class is used to maintain the money in atm.
    int[] m = new int[10];
    int[] v = new int[10];

    int bal = (1 * m[0]) + (2 * m[1]) + (5 * m[2]) + (10 * m[3]) + (20 * m[4]) + (50 * m[5]) + (100 * m[6]) + (200 * m[7]) + (500 * m[8]) + (2000 * m[9]);

    boolean available(int k, int[] m) {
        //this method will check whether the amount asked by user is available in atm to give or not.
        v[0] = 1;
        v[1] = 2;
        v[2] = 5;
        v[3] = 10;
        v[4] = 20;
        v[5] = 50;
        v[6] = 100;
        v[7] = 200;
        v[8] = 500;
        v[9] = 2000;
        for (int i = 9; i >= 0; i--) {
            if (k / v[i] <= m[i]) {
                int x = k / v[i];
                if (k % v[i] == 0) {
                    return true;
                } else {
                    k -= x * v[i];
                }
            }
        }
        return false;
    }

    void change(int k) {
        //this method will update the amount in atm if amount asked by user is possible to give.
        int p = 0;
        for (int i = 9; i >= 0; i--) {
            if (k / v[i] <= m[i]) {
                int x = k / v[i];
                if (k % v[i] == 0) {
                    m[i] -= x;
                    break;
                } else {
                    k -= x * m[i];
                    m[i] -= x;
                }
            }
        }
    }

    void addmoney(int[] m) {
        //this method will allow admin to add money in the atm.
        Scanner sv = new Scanner(System.in);
        int d, x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, sum;
        boolean t = false;
        do {
            sum = 0;
            System.out.println("enter the amount you want to add");
            d = sv.nextInt();
            System.out.println("enter the number of 1 rupee coins");
            x1 = sv.nextInt();
            sum += x1 * 1;
            System.out.println("enter the number of 2 rupee coins");
            x2 = sv.nextInt();
            sum += x2 * 2;
            System.out.println("enter the number of 5 rupee coins");
            x3 = sv.nextInt();
            sum += x3 * 5;
            System.out.println("enter the number of 10 rupee notes");
            x4 = sv.nextInt();
            sum += x4 * 10;
            System.out.println("enter the number of 20 rupee notes");
            x5 = sv.nextInt();
            sum += x5 * 20;
            System.out.println("enter the number of 50 rupee notes");
            x6 = sv.nextInt();
            sum += x6 * 50;
            System.out.println("enter the number of 100 rupee notes");
            x7 = sv.nextInt();
            sum += x7 * 100;
            System.out.println("enter the number of 200 rupee notes");
            x8 = sv.nextInt();
            sum += x8 * 200;
            System.out.println("enter the number of 500 rupee notes");
            x9 = sv.nextInt();
            sum += x9 * 500;
            System.out.println("enter the number of 2000 rupee notes");
            x10 = sv.nextInt();
            sum += x10 * 2000;
            if (sum == d) {
                t = true;
            }
        } while (!t);
        m[0] += x1;
        m[1] += x2;
        m[2] += x3;
        m[3] += x4;
        m[4] += x5;
        m[5] += x6;
        m[6] += x7;
        m[7] += x8;
        m[8] += x9;
        m[9] += x10;
    }

}

public class main {
    public static void main(String[] args) {
        Scanner sv = new Scanner(System.in);
        money atm = new money();
        user a[] = new user[99999];
        for (int i = 0; i < 99999; i++) {
            a[i] = new user();
        }
        for (int i = 0; i < 99999; i++) {
            a[i].ano = i + 1;
        }
        while (true) {
            System.out.println("Welcome to ATM!!!");
            System.out.println("1.first time user\n2.existing user\n3.admin");
            int n = sv.nextInt();
            if (n == 1) {
                int acn;
                boolean z = false;
                do {
                    System.out.println("enter your account number");
                    acn = sv.nextInt();
                    if (acn >= 1 && acn <= 99999) {
                        z = true;
                    }
                } while (!z);
                if(a[acn-1].visited){
                    System.out.println("your are not a first time user,login using existing user option!");
                }
                else {
                    System.out.print("enter your name: ");
                    String s = sv.next();
                    a[acn - 1].aname = s;
                    System.out.print("enter your phone number: ");
                    String k = sv.next();
                    a[acn - 1].phno = k;
                    System.out.print("enter your mail id: ");
                    String p = sv.next();
                    a[acn - 1].mail = p;
                    a[acn - 1].setApin();
                    a[acn - 1].visited = true;
                    System.out.println("Thanks for registering!");
                    System.out.println("1.check balance\n2.withdraw amount\n3.make deposit\n4.reset pin\n5.update profile\n6.transfer money\n7.exit");
                    int y = sv.nextInt();
                    while (y != 7) {
                        if (y > 7 || y <= 0) {
                            System.out.println("enter a valid input");
                            y = sv.nextInt();
                        }
                        if (y == 1) {
                            //allows user to see his current account balance.
                            System.out.println("your account balance is: " + a[acn - 1].getAbal());
                            System.out.println("1.check balance\n2.withdraw amount\n3.make deposit\n4.reset pin\n5.update profile\n6.transfer money\n7.exit");
                            y = sv.nextInt();
                        } else if (y == 2) {
                            //allows user to withdraw money from his account.
                            System.out.println("enter the amount you want to withdraw from your account");
                            int t = sv.nextInt();
                            while (t > a[acn - 1].getAbal()) {
                                System.out.println("enter the valid amount you want to withdraw from your account");
                                t = sv.nextInt();
                            }
                            if (atm.available(t, atm.m)) {
                                atm.change(t);
                                a[acn - 1].setAbal(a[acn - 1].getAbal() - t);
                                System.out.println("please collect your cash below!\nthank you!");
                            } else {
                                System.out.println("ATM does not have enough money!\nsorry for the inconvenience!try again.");
                            }
                            System.out.println("1.check balance\n2.withdraw amount\n3.make deposit\n4.reset pin\n5.update profile\n6.transfer money\n7.exit");
                            y = sv.nextInt();
                        } else if (y == 3) {
                            //allows user to make deposit in the atm.
                            int d, x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, sum;
                            boolean t = false;
                            do {
                                sum = 0;
                                System.out.println("enter the amount you want to deposit");
                                d = sv.nextInt();
                                System.out.println("enter the number of 1 rupee coins");
                                x1 = sv.nextInt();
                                sum += x1 * 1;
                                System.out.println("enter the number of 2 rupee coins");
                                x2 = sv.nextInt();
                                sum += x2 * 2;
                                System.out.println("enter the number of 5 rupee coins");
                                x3 = sv.nextInt();
                                sum += x3 * 5;
                                System.out.println("enter the number of 10 rupee notes");
                                x4 = sv.nextInt();
                                sum += x4 * 10;
                                System.out.println("enter the number of 20 rupee notes");
                                x5 = sv.nextInt();
                                sum += x5 * 20;
                                System.out.println("enter the number of 50 rupee notes");
                                x6 = sv.nextInt();
                                sum += x6 * 50;
                                System.out.println("enter the number of 100 rupee notes");
                                x7 = sv.nextInt();
                                sum += x7 * 100;
                                System.out.println("enter the number of 200 rupee notes");
                                x8 = sv.nextInt();
                                sum += x8 * 200;
                                System.out.println("enter the number of 500 rupee notes");
                                x9 = sv.nextInt();
                                sum += x9 * 500;
                                System.out.println("enter the number of 2000 rupee notes");
                                x10 = sv.nextInt();
                                sum += x10 * 2000;
                                if (sum == d) {
                                    t = true;
                                }
                            } while (!t);
                            a[acn - 1].makedeposit(d, x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, atm.m);
                            System.out.println("thank you! money deposited successfully!");
                            System.out.println("1.check balance\n2.withdraw amount\n3.make deposit\n4.reset pin\n5.update profile\n6.transfer money\n7.exit");
                            y = sv.nextInt();
                        } else if (y == 4) {
                            //allows user to reset pin.
                            a[acn - 1].setApin();
                            System.out.println("1.check balance\n2.withdraw amount\n3.make deposit\n4.reset pin\n5.update profile\n6.transfer money\n7.exit");
                            y = sv.nextInt();
                        } else if (y == 5) {
                            //here user can change is phone number and mail.
                            System.out.println("what do you want to change\n1.phone number\n2.mail");
                            int x = sv.nextInt();
                            if (x == 1) {
                                System.out.print("enter new mobile number:");
                                String i = sv.next();
                                a[acn - 1].phno = i;
                                System.out.println("phone number updated successfully!");
                            } else if (x == 2) {
                                System.out.print("enter new mail:");
                                String w = sv.next();
                                a[acn - 1].mail = w;
                                System.out.println("mail updated successfully!");
                            }
                            System.out.println("1.check balance\n2.withdraw amount\n3.make deposit\n4.reset pin\n5.update profile\n6.transfer money\n7.exit");
                            y = sv.nextInt();
                        } else if (y == 6) {
                            //here user can transfer money from one account to other account.
                            boolean o = false;
                            int u;
                            do {
                                System.out.println("enter the receivers account number");
                                u = sv.nextInt();
                                while (u > 99999 || u <= 0) {
                                    System.out.println("enter the valid receivers account number");
                                    u = sv.nextInt();
                                }
                                System.out.println("reenter the receivers account number");
                                int r = sv.nextInt();
                                if (r == u) {
                                    o = true;
                                }
                            } while (!o);
                            System.out.println("enter the amount you want to transfer");
                            int m = sv.nextInt();
                            while (m > a[acn - 1].getAbal() || m < 0) {
                                System.out.println("enter the valid amount you want to transfer");
                                m = sv.nextInt();
                            }
                            a[acn - 1].setAbal(a[acn - 1].getAbal() - m);
                            a[u - 1].setAbal(a[u - 1].getAbal() + m);
                            System.out.println("money transferred successfully!");
                            System.out.println("1.check balance\n2.withdraw amount\n3.make deposit\n4.reset pin\n5.update profile\n6.transfer money\n7.exit");
                            y = sv.nextInt();
                        } else if (y == 7) {
                            System.out.println("THANK YOU!!!");
                            break;
                        }
                    }
                }

            } else if (n == 2) {
                int acn;
                boolean z = false;
                do {
                    System.out.println("enter your account number");
                    acn = sv.nextInt();
                    if (acn >= 1 && acn <= 99999) {
                        z = true;
                    }
                } while (!z);
                if (!a[acn - 1].visited) {
                    System.out.println("your are not existing user,login using first time user option!");
                } else {
                    z = false;
                    int x = 3;
                    do {
                        if (x == 0) {
                            //if user entered wrong pin 3 times then here it checks the users phone number and gives him option to reset pin.
                            boolean p = false;
                            do {
                                System.out.println("you have exceeded the limit!!!\nverify its you and reset your pin");
                                System.out.println("enter your phone number");
                                String k = sv.next();
                                if (k.equals(a[acn - 1].phno)) {
                                    p = true;
                                }
                            } while (!p);
                            a[acn - 1].setApin();
                            break;
                        }
                        System.out.println("enter your pin");
                        System.out.println("you have " + x + " attempts");
                        String q = sv.next();
                        x--;
                        if (q.equals(a[acn - 1].getApin())) {
                            z = true;
                        }
                    } while (!z);
                    System.out.println("Welcome " + a[acn - 1].aname);
                    System.out.print("your account number is ");
                    a[acn - 1].getAno();
                    System.out.println("1.check balance\n2.withdraw amount\n3.make deposit\n4.reset pin\n5.update profile\n6.transfer money\n7.exit");
                    int y = sv.nextInt();
                    while (y != 7) {
                        if (y > 7 || y <= 0) {
                            System.out.println("enter a valid input");
                            y = sv.nextInt();
                        }
                        if (y == 1) {
                            System.out.println("your account balance is: " + a[acn - 1].getAbal());
                            System.out.println("1.check balance\n2.withdraw amount\n3.make deposit\n4.reset pin\n5.update profile\n6.transfer money\n7.exit");
                            y = sv.nextInt();
                        } else if (y == 2) {
                            System.out.println("enter the amount you want to withdraw from your account");
                            int t = sv.nextInt();
                            while (!(t <= a[acn - 1].getAbal())) {
                                System.out.println("enter the valid amount you want to withdraw from your account");
                                t = sv.nextInt();
                            }
                            if (atm.available(t, atm.m)) {
                                atm.change(t);
                                a[acn - 1].setAbal(a[acn - 1].getAbal() - t);
                                System.out.println("please collect your cash below!\nthank you!");
                            } else {
                                System.out.println("ATM does not have enough money!\nsorry for the inconvenience!try again.");
                            }
                            System.out.println("1.check balance\n2.withdraw amount\n3.make deposit\n4.reset pin\n5.update profile\n6.transfer money\n7.exit");
                            y = sv.nextInt();
                        } else if (y == 3) {
                            int d, x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, sum;
                            boolean t = false;
                            do {
                                sum = 0;
                                System.out.println("enter the amount you want to deposit");
                                d = sv.nextInt();
                                System.out.println("enter the number of 1 rupee coins");
                                x1 = sv.nextInt();
                                sum += x1 * 1;
                                System.out.println("enter the number of 2 rupee coins");
                                x2 = sv.nextInt();
                                sum += x2 * 2;
                                System.out.println("enter the number of 5 rupee coins");
                                x3 = sv.nextInt();
                                sum += x3 * 5;
                                System.out.println("enter the number of 10 rupee notes");
                                x4 = sv.nextInt();
                                sum += x4 * 10;
                                System.out.println("enter the number of 20 rupee notes");
                                x5 = sv.nextInt();
                                sum += x5 * 20;
                                System.out.println("enter the number of 50 rupee notes");
                                x6 = sv.nextInt();
                                sum += x6 * 50;
                                System.out.println("enter the number of 100 rupee notes");
                                x7 = sv.nextInt();
                                sum += x7 * 100;
                                System.out.println("enter the number of 200 rupee notes");
                                x8 = sv.nextInt();
                                sum += x8 * 200;
                                System.out.println("enter the number of 500 rupee notes");
                                x9 = sv.nextInt();
                                sum += x9 * 500;
                                System.out.println("enter the number of 2000 rupee notes");
                                x10 = sv.nextInt();
                                sum += x10 * 2000;
                                if (sum == d) {
                                    t = true;
                                }
                            } while (!t);
                            a[acn - 1].makedeposit(d, x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, atm.m);
                            System.out.println("thank you! money deposited successfully!");
                            System.out.println("1.check balance\n2.withdraw amount\n3.make deposit\n4.reset pin\n5.update profile\n6.transfer money\n7.exit");
                            y = sv.nextInt();
                        } else if (y == 4) {
                            a[acn - 1].setApin();
                            System.out.println("1.check balance\n2.withdraw amount\n3.make deposit\n4.reset pin\n5.update profile\n6.transfer money\n7.exit");
                            y = sv.nextInt();
                        } else if (y == 5) {
                            System.out.println("what do you want to change\n1.phone number\n2.mail");
                            int e = sv.nextInt();
                            if (e == 1) {
                                System.out.print("enter new mobile number:");
                                String i = sv.next();
                                a[acn - 1].phno = i;
                                System.out.println("phone number updated successfully!");
                            } else {
                                System.out.print("enter new mail:");
                                String i = sv.next();
                                a[acn - 1].mail = i;
                                System.out.println("mail updated successfully!");
                            }
                            System.out.println("1.check balance\n2.withdraw amount\n3.make deposit\n4.reset pin\n5.update profile\n6.transfer money\n7.exit");
                            y = sv.nextInt();
                        } else if (y == 6) {
                            boolean o = false;
                            int u;
                            do {
                                System.out.println("enter the receivers account number");
                                u = sv.nextInt();
                                while (u > 99999 || u <= 0) {
                                    System.out.println("enter the valid receivers account number");
                                    u = sv.nextInt();
                                }
                                System.out.println("reenter the receivers account number");
                                int r = sv.nextInt();
                                if (r == u) {
                                    o = true;
                                }
                            } while (!o);
                            System.out.println("enter the amount you want to transfer");
                            int m = sv.nextInt();
                            while (m > a[acn - 1].getAbal() || m < 0) {
                                System.out.println("enter the valid amount you want to transfer");
                                m = sv.nextInt();
                            }
                            a[acn - 1].setAbal(a[acn - 1].getAbal() - m);
                            a[u - 1].setAbal(a[u - 1].getAbal() + m);
                            System.out.println("money transferred successfully!");
                            System.out.println("1.check balance\n2.withdraw amount\n3.make deposit\n4.reset pin\n5.update profile\n6.transfer money\n7.exit");
                            y = sv.nextInt();
                        } else if (y == 7) {
                            System.out.println("THANK YOU!!!");
                            break;
                        }
                    }
                }
            } else if (n == 3) {
                System.out.println("Welcome admin!");
                boolean z = false;
                do {
                    System.out.println("enter your password");
                    String s = sv.next();
                    if (s.equals("0000")) {
                        //admin is given a security password 0000.
                        System.out.println("now you can add money!");
                        z = true;
                    }
                } while (!z);
                System.out.println("1.see atm money\n2.add money");
                //1 allows admin to see how many notes of each type are currently present in atm.
                //2 allows admin to add money.
                int r = sv.nextInt();
                if (r == 1) {
                    System.out.println("number of 1 rupee coins = " + atm.m[0]);
                    System.out.println("number of 2 rupee coins = " + atm.m[1]);
                    System.out.println("number of 5 rupee coins = " + atm.m[2]);
                    System.out.println("number of 10 rupee notes = " + atm.m[3]);
                    System.out.println("number of 20 rupee notes = " + atm.m[4]);
                    System.out.println("number of 50 rupee notes = " + atm.m[5]);
                    System.out.println("number of 100 rupee notes = " + atm.m[6]);
                    System.out.println("number of 200 rupee notes = " + atm.m[7]);
                    System.out.println("number of 500 rupee notes = " + atm.m[8]);
                    System.out.println("number of 2000 rupee notes = " + atm.m[9]);
                } else if (r == 2) {
                    atm.addmoney(atm.m);
                }
            }
        }
    }
}



