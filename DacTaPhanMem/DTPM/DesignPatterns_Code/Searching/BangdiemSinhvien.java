import java.io.*;
//import java.io.File;
public class BangdiemSinhvien
 {

    // Do not instantiate.
    private BangdiemSinhvien() { }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(new File("sinhvien.csv")));
      
        ST<String, Student> st = new ST<String, Student>();
        
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String line = StdIn.readLine();
            String[] tokens = line.split(",");
            String key = tokens[0];
            Student sinhvien = new Student(tokens);      
            st.put(key,sinhvien);
        }

        for (String filename : args) {
            StdOut.println("  " + filename);
            File file = new File(filename);
            In in = new In(file);
            String mon = filename.substring(0, filename.length()-4);
            while (!in.isEmpty()) {
            String line = in.readLine();
            String[] tokens = line.split(",");
            String masv = tokens[0];
            Double diem = Double.parseDouble(tokens[1]); 
            Student sinhvien = st.get(masv);
            sinhvien.bangdiem().put(mon,diem);
            }
        } 
            for(String ma: st.keys()){
            Student sv = st.get(ma);
            sv.tinh_diemtb();    
            StdOut.println(sv);
        }
            String s = "12345678";
            if (st.contains(s)) {  
                StdOut.println(st.get(s)); 
            }
            else                StdOut.println("Not found");
            Student sinhvien = st.get(s);
            for (String m: sinhvien.bangdiem().keys())
            StdOut.println(m + " " + sinhvien.bangdiem().get(m));
    }
}
