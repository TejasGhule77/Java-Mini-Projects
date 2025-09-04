import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;
class User
{
    private String user;
    private String Password;
    public User(String User,String Password){
        this.user=User;
        this.Password=Password;

    }
    public boolean authenticate(String input){
        return this.Password.equals(input);
    }
}
 class Vault {
    private List<VaultFile> files=new ArrayList<>();
    public void addFile(String path)throws IOException {
        File f= new File(path);
        if(f.exists()){
            VaultFile vf = new VaultFile(f.getName(),f.length());
            files.add(vf);
            System.out.println("file Added:"+vf);

        }

    }
    public void viewFile()
    {
        for (VaultFile vf:files){
            System.out.println(vf);
        }
    }
}
class VaultFile implements Serializable
{
    private String Filename;
    private long size;
    private Date uploaded;
    public VaultFile(String Filename,long size){
        this.Filename=Filename;
        this.size=size;
        this.uploaded= new Date();
    }
    public String toString(){
        return Filename+": | Size-"+size+":bytes | uploaded time:"+uploaded;
    }
}



public class SecureFileVaultApp {
    public static void main(String[] args) throws IOException {
            Scanner sc = new Scanner(System.in);
            User user = new User("Tejas","2395");
            Vault vault= new Vault();
        System.out.println("Enter the Password");
        String input = sc.nextLine();

        if(user.authenticate(input)){
            char c;
            int choice;
            do {
                System.out.println("Accses Granted!!");
                System.out.println("choose the option 1.addfile\t2.Viewfile");
                choice = sc.nextInt();
                sc.nextLine();
               switch (choice)
               {
                   case 1:
                       System.out.println("Enter the path");
                       String path = sc.nextLine();
                       vault.addFile(path);
                       break;
                   case 2:
                       System.out.println("file is :");
                       vault.viewFile();
                       break;
                   default:
                       System.out.println("enter the wrong choice");
               }
                System.out.println("do you want to continue");
               c=sc.next().charAt(0);

            }while (c=='Y'||c=='y');
            }

        else {
            System.out.println("Access denied!!!");
        }
    }
}
