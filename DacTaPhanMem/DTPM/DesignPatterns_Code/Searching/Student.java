/******************************************************************************
 *  Compilation:  javac Transaction.java
 *  Execution:    java Transaction
 *  Dependencies: StdOut.java
 *  
 *  Data type for commercial transactions.
 *
 ******************************************************************************/

 

import java.util.Arrays;
import java.util.Comparator;

/**
 *  The {@code Transaction} class is an immutable data type to encapsulate a
 *  commercial transaction with a customer name, date, and amount.
 *  <p>
 *  For additional documentation, 
 *  see <a href="https://algs4.cs.princeton.edu/12oop">Section 1.2</a> of 
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne. 
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class Student implements Comparable<Student> {
    private final String  masv; 
    private final String  hodem;      // 
    private final String  ten;      // 
    private final Date    ngaysinh;     // date
    private double  diemtb;     // amount
    private ST<String, Double>  bangdiem;    

    /**
     * Initializes a new transaction from the given arguments.
     *
     * @param  who the person involved in this transaction
     * @param  when the date of this transaction
     * @param  amount the amount of this transaction
     * @throws IllegalArgumentException if {@code amount} 
     *         is {@code Double.NaN}, {@code Double.POSITIVE_INFINITY},
     *         or {@code Double.NEGATIVE_INFINITY}
     */
    public Student(String masv, String hodem, String ten, Date ngaysinh, double diemtb) {
        if (Double.isNaN(diemtb) || Double.isInfinite(diemtb))
            throw new IllegalArgumentException("Amount cannot be NaN or infinite");
        this.masv = masv;
        this.hodem    = hodem;
        this.ten    = ten;
        this.ngaysinh   = ngaysinh;
        this.diemtb = diemtb;
        this.bangdiem = bangdiem = new ST<String, Double>();
    }

    /**
     * Initializes a new transaction by parsing a string of the form NAME DATE AMOUNT.
     *
     * @param  transaction the string to parse
     * @throws IllegalArgumentException if {@code amount} 
     *         is {@code Double.NaN}, {@code Double.POSITIVE_INFINITY},
     *         or {@code Double.NEGATIVE_INFINITY}
     */
    public Student(String student) {
        String[] a = student.split("\\s+");
        masv = a[0];
        hodem    = a[1];
        ten = a[2];
        ngaysinh   = new Date(a[3]);
        diemtb = Double.parseDouble(a[4]);
        bangdiem = new ST<String, Double>();
        if (Double.isNaN(diemtb) || Double.isInfinite(diemtb))
            throw new IllegalArgumentException("Amount cannot be NaN or infinite");
    }
    public Student(String[ ] a) {
        masv = a[0];
        hodem    = a[1];
        ten = a[2];
        ngaysinh   = new Date(a[3]);
        diemtb = Double.parseDouble(a[4]);
        bangdiem = new ST<String, Double>();
        if (Double.isNaN(diemtb) || Double.isInfinite(diemtb))
            throw new IllegalArgumentException("Amount cannot be NaN or infinite");
    }
    /**
     * Returns the name of the customer involved in this transaction.
     *
     * @return the name of the customer involved in this transaction
     */
    public String masv() {
        return masv;
    }
    public String hodem() {
        return hodem;
    }
    public String ten() {
        return ten;
    }
    /**
     * Returns the date of this transaction.
     *
     * @return the date of this transaction
     */
    public Date ngaysinh() {
        return ngaysinh;
    }
 
    /**
     * Returns the amount of this transaction.
     *
     * @return the amount of this transaction
     */
    public double diemtb() {
        return diemtb;
    }
    public double tinh_diemtb()
    {
        int i = 0;
        double tb = 0.0; 
        for (String m: this.bangdiem().keys()){
            i += 1;
            tb += this.bangdiem().get(m);
        }
        if (i==0) this.diemtb = 0.0;
        else this.diemtb = tb/i;
        return this.diemtb;
    }    
    public ST<String,Double> bangdiem() {
        return bangdiem;
    }

    /**
     * Returns a string representation of this transaction.
     *
     * @return a string representation of this transaction
     */
    @Override
    public String toString() {
        return String.format("%-10s %10s %10s %10s %8.2f", masv, hodem, ten, ngaysinh, diemtb);
    }

    /**
     * Compares two transactions by amount.
     *
     * @param  that the other transaction
     * @return { a negative integer, zero, a positive integer}, depending
     *         on whether the amount of this transaction is { less than,
     *         equal to, or greater than } the amount of that transaction
     */
    public int compareTo(Student that) {
        return this.masv.compareTo(that.masv);
    }    

    /**
     * Compares this transaction to the specified object.
     *
     * @param  other the other transaction
     * @return true if this transaction is equal to {@code other}; false otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (other.getClass() != this.getClass()) return false;
        Student that = (Student) other;
        return (this.masv == that.masv);
    }


    /**
     * Returns a hash code for this transaction.
     *
     * @return a hash code for this transaction
     */
    public int hashCode() {
        int hash = 1;
        hash = 31*hash + hodem.hashCode();
        hash = 31*hash + ten.hashCode();
        hash = 31*hash + ngaysinh.hashCode();
        hash = 31*hash + ((Double) diemtb).hashCode();
        return hash;
        // return Objects.hash(who, when, amount);
    }

    /**
     * Compares two transactions by customer name.
     */
    public static class Sosanhten implements Comparator<Student> {

        @Override
        public int compare(Student v, Student w) {
            return v.hodem.compareTo(w.hodem);
        }
    }

    /**
     * Compares two transactions by date.
     */
    public static class Sosanhngaysinh implements Comparator<Student> {

        @Override
        public int compare(Student v, Student w) {
            return v.ngaysinh.compareTo(w.ngaysinh);
        }
    }

    /**
     * Compares two transactions by amount.
     */
    public static class Sosanhdiem implements Comparator<Student> {

        @Override
        public int compare(Student v, Student w) {
            return Double.compare(v.diemtb, w.diemtb);
        }
    }


    /**
     * Unit tests the {@code Transaction} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Student[] a = new Student[4];
        a[0] = new Student("12345678 NguyenVan  Cuong  6/17/2003  8.08");
        a[1] = new Student("23456781 TranThi Hang   3/26/2004 9.85");
        a[2] = new Student("34567812 DoVan  An    6/14/2002  7.34");
        a[3] = new Student("45678123 PhamNgoc Anh  8/22/2005 8.40");

        StdOut.println("Khong sap xep");
        for (int i = 0; i < a.length; i++)
            StdOut.println(a[i]);
        StdOut.println();
        
        StdOut.println("Sap xep");
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++)
            StdOut.println(a[i]);
        StdOut.println();
        
                StdOut.println("Sap xep ngay sinh");
        Arrays.sort(a, new Student.Sosanhngaysinh());
        for (int i = 0; i < a.length; i++)
            StdOut.println(a[i]);
        StdOut.println();

        StdOut.println("Sap xep theo ten");
        Arrays.sort(a, new Student.Sosanhten());
        for (int i = 0; i < a.length; i++)
            StdOut.println(a[i]);
        StdOut.println();

        StdOut.println("Sap xep theo diem");
        Arrays.sort(a, new Student.Sosanhdiem());
        for (int i = 0; i < a.length; i++)
            StdOut.println(a[i]);
        StdOut.println();
        Student sv = new Student("78123456 TranVan  Dung  8/4/2003  8.08");
        StdOut.println(sv);
        sv.bangdiem().put("toan",8.5);
        sv.bangdiem().put("ly",7.5);
        sv.bangdiem().put("hoa",9.5);
        for (String m: sv.bangdiem().keys())
            StdOut.println(m + " " + sv.bangdiem().get(m));
        StdOut.println(sv.tinh_diemtb());  
    }
   
}




/******************************************************************************
 *  Copyright 2002-2016, Robert Sedgewick and Kevin Wayne.
 *
 *  This file is part of algs4.jar, which accompanies the textbook
 *
 *      Algorithms, 4th edition by Robert Sedgewick and Kevin Wayne,
 *      Addison-Wesley Professional, 2011, ISBN 0-321-57351-X.
 *      http://algs4.cs.princeton.edu
 *
 *
 *  algs4.jar is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  algs4.jar is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with algs4.jar.  If not, see http://www.gnu.org/licenses.
 ******************************************************************************/