import java.io.*;

public class Program{
    private static Comanda comanda = new Comanda();
    public static void main(String [] args){
        try{
            BufferedReader cons = new BufferedReader(
                new InputStreamReader(System.in)
            );
            
            String cmd = "";
            
            while(true){
                System.out.print("COMANDA: ");
                cmd = cons.readLine();
                String [] v = cmd.split("\\s+");
                
                switch(v[0]){
                    case "exit": System.exit(0);
                    case "ap":{
                        String nume = v[1];
                        double pret = Double.parseDouble(v[2]);
                        
                        if(v[3].equals("p")){
                            comanda.adaugaPizza(new ProsciutoPizza(nume, pret));
                        }
                        if(v[3].equals("f")){
                            comanda.adaugaPizza(new FunghiPizza(nume, pret));
                        }
                        if(v[3].equals("q")){
                            comanda.adaugaPizza(new QuatroStagionni(nume, pret));
                        }
                        
                        System.out.println("A fost adaugata pizza!");
                    }break;
                    
                    case "ai":{
                        Pizza p = comanda.getPizza(v[1]);
                        
                        if(p!=null){
                            String nume = v[2];
                            double pret = Double.parseDouble(v[3]);
                            p.adaugaIngredient(new Ingredient(nume, pret));
                        }else{
                            System.out.println("Nu exista aceasta pizza!");
                        }
                    }break;
                    case "afisazapret":{
                        System.out.println("PRET TOTAL: "+comanda.getPretComanda());
                    }break;
                    case "salveaza":{
                        ObjectOutputStream out = new ObjectOutputStream(
                            new FileOutputStream(v[1])
                        );
                        out.writeObject(comanda);
                        out.close();
                        System.out.println("Comanda a fost salvata!");
                    }
                }
                
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
