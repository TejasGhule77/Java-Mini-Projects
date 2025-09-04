import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;
class Education
{
    String collage,degree;
    int year;
    public Education(String collage,String degree,int year)
    {
        this.collage=collage;
        this.degree=degree;
        this.year=year;
    }
    public String toString()
    {
        return degree+"\t"+"From\t"+collage+"("+year+")";
    }
}
class Experience
{
    String role, company;
    int year;
    public Experience(String role,String company,int year)
    {
        this.role=role;
        this.company =company;
        this.year=year;
    }
    public String toString()
    {
        return role+"\t" +"at\t"+company+"\t"+"For\t"+year+"years";
    }
}
class Resume
{
    String name;
    List<Education> educations;
    List<Experience> experiences;
    List<String> skills;
    public Resume(String name)
    {
        this.name=name;
        educations=new ArrayList<>();
        experiences=new ArrayList<>();
        skills = new ArrayList<>();
    }
    public void addEducation(Education e)
    {
        educations.add(e);
    }
    public void addExperience(Experience e)
    {
        experiences.add(e);
    }
    public void addSkill(String skill)
    {
        skills.add(skill);
    }
    public void generateTOFile() throws IOException
    {
        BufferedWriter writer = new BufferedWriter(new FileWriter("resume.txt"));
        writer.write("========Resume========\n");
        writer.write("Name: " + name + "\n\n");

        writer.write("Education:\n");
        for(Education e: educations)
        {
            writer.write(" - "+ e +" \n ");
        }

        writer.write("\nExperince:\n");
        for(Experience e: experiences)
        {
            writer.write("-"+e+"\n");
        }

        writer.write("\nSkills:\n");
        for(String s: skills)
        {
            writer.write("-"+s+"\n");
        }
        writer.close();
        System.out.println("file resume.txt succenfully saved");
    }



}

public class resume_builder
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the your name");
        String name = sc.nextLine();
        Resume resume = new Resume(name);
        System.out.println("how many education entries?");
        int educount = sc.nextInt();sc.nextLine();
        for(int i=0;i<educount;i++)
        {
            System.out.println("collage:");
            String collage = sc.nextLine();
            System.out.println("degree:");
            String degree= sc.nextLine();
            System.out.println(" Year:");
            int year=sc.nextInt();sc.nextLine();
            resume.addEducation(new Education(collage,degree,year));
        }

        System.out.println("how many experience entries?");
        int expcount = sc.nextInt();sc.nextLine();
        for(int i=0;i<expcount;i++)
        {
            System.out.println("Enter the company name:");
            String role = sc.nextLine();
            System.out.println("Enter the roll in your company:");
            String company= sc.nextLine();
            System.out.println("how many years of work experince :");
            int year=sc.nextInt();sc.nextLine();
            resume.addExperience(new Experience(role,company,year));
        }
        System.out.println("how many skill?");
        int skillcount = sc.nextInt();sc.nextLine();
        for(int i = 0; i< skillcount; i++)
        {
            System.out.println("skill:");
            String skill = sc.nextLine();
            resume.addSkill(skill);


        }
        resume.generateTOFile();
    }
}
