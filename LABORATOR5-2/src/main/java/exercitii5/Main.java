package exercitii5;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        int lungime=2700,latime=2070;
        int supraftaCoala=lungime*latime,supraftaCorp,suprafataPlaca,nr;

        List<Mobilier> lista=citire();

        for(Mobilier p:lista)
        {
            System.out.println(p.getNume());
            for(Placa placa:p.getPlaci())
            {
                System.out.println(placa.getDescriere());
                System.out.println(placa.getLungime());
                System.out.println(placa.getLatime());
                System.out.println(placa.getOrientare());
                System.out.println(Arrays.toString(placa.getCanturi()));
                System.out.println(placa.getNr_bucati());
            }
        }

        for(Mobilier p:lista)
        {
            supraftaCorp=0;
            for(Placa placa:p.getPlaci())
            {
                suprafataPlaca=placa.getLungime()*placa.getLatime();
                supraftaCorp=suprafataPlaca*placa.getNr_bucati();
            }
            System.out.println("Suptafta coala "+supraftaCoala+" mm");
            System.out.println("Suptafata toala a corpului "+p.getNume()+" este de : "+supraftaCorp+" mm");
            nr= (int) Math.ceil((double) supraftaCorp/supraftaCoala);
            System.out.println("Pentru corpul "+p.getNume()+" sunt necesare "+ nr +" placi de pal.");
        }

        scriere(lista);

    }

    public static void scriere(List<Mobilier> lista) {
        try {
            ObjectMapper mapper=new ObjectMapper();
            File file=new File("src/main/resources/mobilier.json");
            mapper.writeValue(file,lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Mobilier> citire() {
        try {
            File file=new File("src/main/resources/mobilier.json");
            ObjectMapper mapper=new ObjectMapper();
            List<Mobilier> persoane = mapper
                    .readValue(file, new TypeReference<List<Mobilier>>(){});
            return persoane;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
