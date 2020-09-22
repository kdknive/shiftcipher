import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class Main
{

    static int s = 0;
    static int c = 0;
    public static StringBuffer encrypt(String text, int s)
    {
        StringBuffer result= new StringBuffer();
        switch (c){
            case 1:
                for (int i=0; i<text.length(); i++)
                {
                    if (Character.isUpperCase(text.charAt(i)))
                    {
                        char ch = (char)(((int)text.charAt(i) +
                                s - 65) % 26 + 65);
                        result.append(ch);
                    }
                }
                break;
            case 2:
                for (int i=0; i<text.length(); i++)
                {
                    if (Character.isUpperCase(text.charAt(i)))
                    {
                        char ch = (char)(((int)text.charAt(i) -
                                s - 65) % 26 + 65);
                        result.append(ch);
                    }
                }
                break;
        }
        return result;
    }

    public static void main(String[] args)
    {
        System.out.println("Enkripsi atau Dekripsi?");
        System.out.println("1.  Enkripsi");
        System.out.println("2.  Dekripsi");
        System.out.print("Pilihan =   ");
        InputStreamReader valueC = new InputStreamReader(System.in);
        BufferedReader Cvalue = new BufferedReader(valueC);
        try{
            c = Integer.parseInt(Cvalue.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.print("Masukkan pesan untuk di enkripsi/dekripsi  =   ");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine().toUpperCase();

        System.out.print("Masukkan kunci    =   ");
        InputStreamReader valueK = new InputStreamReader(System.in);
        BufferedReader Kvalue = new BufferedReader(valueK);
        try{
            s = Integer.parseInt(Kvalue.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Text : " + text);
        System.out.println("Shift : " + s);
        System.out.println("Cipher: " + encrypt(text, s));
    }
}
