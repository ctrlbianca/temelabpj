package exercitiul1;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main
{
    public static void main(String[] args)
    {
        List<PerecheNumere> lista=new ArrayList<PerecheNumere>();
        lista=citire();

        for(PerecheNumere per : lista)
        {
            System.out.println("Pentru a="+per.getA()+" si b="+per.getB());
            System.out.println("Cele doua numere faca parte din sirul lui Fibonaci : "+per.perecheFibonaci(per.getA(), per.getB()));
            System.out.println("Cel mai mic multiplu comun a lui a si b este : "+per.cmmc(per.getA(), per.getB()));
            System.out.println("Cele doua numere au suma cifrelelor egala : "+per.sumaEgala(per.getA(), per.getB()));
            System.out.println("Cele doua numere au acelasi numar de cifere pare : "+per.nrCifrePare(per.getA(), per.getB()));
        }


        scriere(lista);

    }

    public static void scriere(List<PerecheNumere> lista) {
        try {
            ObjectMapper mapper=new ObjectMapper();
            File file=new File("src/main/resources/perechi.json");
            mapper.writeValue(file,lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<PerecheNumere> citire()
    {
        try {
            File file=new File("src/main/resources/perechi.json");
            ObjectMapper mapper=new ObjectMapper();
            List<PerecheNumere> numar = mapper
                    .readValue(file, new TypeReference<List<PerecheNumere>>(){});
            return numar;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
